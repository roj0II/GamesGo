package com.gamesgo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamesgo.dto.CheckoutDto;
import com.gamesgo.model.Game;
import com.gamesgo.model.Rent;
import com.gamesgo.model.Shipping;
import com.gamesgo.model.Storage;
import com.gamesgo.model.Transaction;
import com.gamesgo.model.User;
import com.gamesgo.repository.GameRepository;
import com.gamesgo.repository.RentRepository;
import com.gamesgo.repository.ShippingRepository;
import com.gamesgo.repository.StorageRepository;
import com.gamesgo.repository.TransactionRepository;
import com.gamesgo.util.EmailManager;
import com.gamesgo.util.KeyGenerator;

import jakarta.servlet.http.HttpSession;

@Controller
public class CheckoutController {

	private final String pathCheckoutPage = "/home/checkout.jsp";
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private StorageRepository storageRepository;
	
	@Autowired
	private ShippingRepository shippingRepository;
	
	@Autowired
	private RentRepository rentRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@PostMapping("/checkout/{id}")
	public String checkoutForm (Model model, HttpSession session, @PathVariable int id, @RequestParam String formatType, @RequestParam String transactionType){
		// digital o retail = formatType
		// buy o rent = transactionType
		Game game = gameRepository.findById(id).orElse(new Game());
		User loggedUser = (User) session.getAttribute("loggedUser");

		if (loggedUser == null) {
			model.addAttribute("error", true);
			model.addAttribute("message", "Effettua prima l'accesso.");
			model.addAttribute("color", "yellow");
			model.addAttribute("title", "Alert!");
			
			return "/login/loginPage.jsp";
		}
		
		CheckoutDto cd = new CheckoutDto();

		// Info dell'acquisto.
		cd.setOnline(formatType.equals("digital"));
		cd.setRent(transactionType.equals("rent"));
		
		// Dati del gioco.
		cd.setGameId(game.getId());
		cd.setGameTitle(game.getTitle());
		cd.setGamePhotoUrl(game.getPhotoUrl());
		if (formatType.equals("digital")) {
			cd.setGamePrice(game.getPriceDigital());
		} else {
			cd.setGamePrice(game.getPriceRetail());
		}
		
		// Dati di fatturazione.
		cd.setTransactionAddress(loggedUser.getAddress());
		cd.setTransactionEmail(loggedUser.getEmail());
		cd.setTransactionName(loggedUser.getName());
		cd.setTransactionPhone(loggedUser.getPhone());
		cd.setTransactionSurname(loggedUser.getSurname());
		
		// Dati per la spedizione.
		cd.setShippingAddress(loggedUser.getAddress());
		cd.setShippingEmail(loggedUser.getEmail());
		cd.setShippingName(loggedUser.getName());
		cd.setShippingPhone(loggedUser.getPhone());
		cd.setShippingSurname(loggedUser.getSurname());
		
		// Dati per il pagamento con carta.
		cd.setPaymentNameAndSurname(loggedUser.getName()+ " "+loggedUser.getSurname());
		
		
		if (transactionType.equals("rent")) {
			cd.setGamePrice((float) (cd.getGamePrice()/30 - 0.20));
		}
		
		model.addAttribute("check", cd);
		return pathCheckoutPage;
	}
	
	
	@PostMapping("/final")
	public String checkout(Model model, HttpSession session, @ModelAttribute("check") CheckoutDto checkoutDto) throws MessagingException, IOException{
		// digital o retail = formatType
		// buy o rent = transactionType
		User loggedUser = (User) session.getAttribute("loggedUser");
		System.out.println(checkoutDto.getGameId());
		Game game = gameRepository.findById(checkoutDto.getGameId()).orElse(new Game());
		if (isNull(game, model, "Errore!","L'id del gioco non è corrente o è errato.")) {
			model.addAttribute("check", checkoutDto);
			return pathCheckoutPage;
		}
		
		double totalPrice = 0;
		
		Transaction transaction = new Transaction();
		transaction.setGame(game);
		transaction.setUser(loggedUser);
		transaction = transactionRepository.save(transaction);
		LocalDate localDate= LocalDate.now();


		// controlliamo se è un buy o rent.
		if (checkoutDto.isRent()) { // rent.
			Rent rent = new Rent();
			
			if (isNull(checkoutDto.getRentDays(), model, "Errore!","Non hai selezionato il numero di giorni.")) {
				model.addAttribute("check", checkoutDto);
				return pathCheckoutPage;
			}
			
			// rimuoviamo il gioco dal db:
			if (checkoutDto.isOnline()) { // online.
				totalPrice = checkoutDto.getRentDays()*(game.getPriceDigital()/30 - 0.20);
				Storage storage = game.getStorage();
				storage.setAmountDigital(storage.getAmountDigital()-1);
				storageRepository.save(storage);
				
				rent.setStartDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				
			} else { // fisico.
				totalPrice = checkoutDto.getRentDays()*(game.getPriceRetail()/30 - 0.20);
				Storage storage = game.getStorage();
				storage.setAmountRetail(storage.getAmountRetail()-1);
				storageRepository.save(storage);

				Shipping shipping = new Shipping();
				shipping.setTransaction(transaction);
				shipping.setUser(loggedUser);
				shipping.setStatus("In spedizione");
				shipping.setShippingDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				
				switch (checkoutDto.getShippingMethod()) {
				case "normale": //4 7 giorni
					totalPrice += 4;
					shipping.setScheduleDeliveryDate(Date.from(localDate.plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()));
					break;
				case "veloce": //6 4 giorni
					totalPrice += 6;
					shipping.setScheduleDeliveryDate(Date.from(localDate.plusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant()));
					break;
					
				case "due giorni": //12 2giorni
					totalPrice += 12;
					shipping.setScheduleDeliveryDate(Date.from(localDate.plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant()));
					break;
					default:
						// todo ERRORE metodo di spedizione non selezionato o non valido.
						break;
				}
				shipping = shippingRepository.save(shipping);
				List<Shipping> shippingList = transaction.getShipments();
				shippingList.add(shipping);
				transaction.setShipments(shippingList);
				rent.setStartDate(shipping.getScheduleDeliveryDate());
			}
			
			// otteniamo  il numero di giorni dal checkoutDto.
			int rentDays = checkoutDto.getRentDays();

	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(rent.getStartDate());
	        // aggiungiamo i giorni del rent.
	        calendar.add(Calendar.DAY_OF_MONTH, rentDays);

	        // Ottieni la nuova data
	        Date endDate = calendar.getTime();
	        rent.setEndDate(endDate);		        
			rent.setType(checkoutDto.isOnline() ? "digital": "retail");
			rent.setProductKey(KeyGenerator.generateProductKey());
			rent.setTransaction(transaction);
			rent = rentRepository.save(rent);
			
			List<Rent> rentList = transaction.getRents();
			rentList.add(rent);
			transaction.setRents(rentList);
			
		} else { // buy.
			
			if (checkoutDto.isOnline()) { // online.
				totalPrice += game.getPriceDigital();
				Storage storage = game.getStorage();
				storage.setAmountDigital(storage.getAmountDigital()-1);
				storageRepository.save(storage);
			} else { // fisico.
				totalPrice += game.getPriceRetail();
				Storage storage = game.getStorage();
				storage.setAmountRetail(storage.getAmountRetail()-1);
				storageRepository.save(storage);
				
				Shipping shipping = new Shipping();
				shipping.setTransaction(transaction);
				shipping.setUser(loggedUser);
				shipping.setStatus("In spedizione");
				shipping.setShippingDate(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
				switch (checkoutDto.getShippingMethod()) {
				case "normale": //4 7 giorni
					totalPrice += 4;
					shipping.setScheduleDeliveryDate(Date.from(localDate.plusDays(7).atStartOfDay(ZoneId.systemDefault()).toInstant()));
					break;
				case "veloce": //6 4 giorni
					totalPrice += 6;
					shipping.setScheduleDeliveryDate(Date.from(localDate.plusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant()));
					break;
				case "due giorni": //12 2giorni
					totalPrice += 12;
					shipping.setScheduleDeliveryDate(Date.from(localDate.plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant()));
					break;
					default:
						isNull(null,model,"Errore!","Metodo di spedizione non selezionato o non valido.");
						model.addAttribute("check", checkoutDto);
						return pathCheckoutPage;
						// todo ERRORE metodo di spedizione non selezionato o non valido.
				}
				checkoutDto.setShippingScheduleDate(shipping.getScheduleDeliveryDate());
				shipping = shippingRepository.save(shipping);
				List<Shipping> shippingList = transaction.getShipments();
				shippingList.add(shipping);
				transaction.setShipments(shippingList);
			}
		}

		transaction.setCheckoutPayment((float)totalPrice);
		transactionRepository.save(transaction);
		
		checkoutDto.setGamePrice((float)totalPrice);
		
		checkoutDto.setShippingOrderDate(new Date());
		
		
		EmailManager.sendMailCheckout(checkoutDto);

		
		// nome gioco
		// soldi spesi
		// data ordine
		// productImageUrl
		if (checkoutDto.isRent()) { // rent.
			// inzio rent, fine rent
			if (checkoutDto.isOnline()) { // online.
				// chiave auto generata.
			} else {
				// data arrivo ordine
				// tipo di consegna (normale, rapida, due_giorni)
			}
		} else { // buy
			
			if (checkoutDto.isOnline()) { // online.
				// chiave auto generata.
			} else {
				// data arrivo ordine
				// tipo di consegna (normale, rapida, due_giorni)
			}
		}
		
		return "";
	}
	
	private boolean isNull (Object o, Model model, String title, String message) {
		if (o!=null) {
			return false;
		}
		model.addAttribute("error", true);
        model.addAttribute("message", message);
        model.addAttribute("color", "red");
        model.addAttribute("title", title);
		return true;
	}
	
}
