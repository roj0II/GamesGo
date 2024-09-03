package com.gamesgo.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class WebhookManager {
	public static boolean sendWebhook(String webhookUrl, String jsonPayload) throws Exception {
        URL url = new URL(webhookUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Imposta la richiesta come POST
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        
        // Invia il payload JSON
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonPayload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        
        // Verifica la risposta
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        if (responseCode == HttpURLConnection.HTTP_NO_CONTENT || responseCode == HttpURLConnection.HTTP_OK) {
            return true;
        } else {
            return false;
        }        
    }
	
	public static String embedContact(String titolo, String nome, String cognome, String email, String messaggio) {
        // Costruzione del payload JSON dinamicamente
        JSONObject embed = new JSONObject();
        
        // Creazione della descrizione dell'embed
        String description = "# " + titolo + "\n";
        description += "▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n";
        description += "- **Nome**\n - " + nome + "\n";
        description += "- **Cognome**\n - " + cognome + "\n";
        description += "- **Email**\n - " + email + "\n";
        description += "▬▬▬▬▬▬▬▬▬▬▬▬▬▬\n";
        description += "- **Messaggio**\n```" + messaggio + "```";

        embed.put("description", description);
        embed.put("color", JSONObject.NULL); // Se non è necessario specificare un colore, utilizza JSONObject.NULL

        JSONArray embeds = new JSONArray();
        embeds.put(embed);

        JSONObject payload = new JSONObject();
        payload.put("content", JSONObject.NULL); // Per il campo "content", se non hai contenuto, utilizza JSONObject.NULL
        payload.put("embeds", embeds);
        payload.put("attachments", new JSONArray()); // Assicurati che "attachments" sia un array vuoto se non usato

        return payload.toString();
    }
	
	public static void main(String[] args) throws Exception {
		sendWebhook("https://discord.com/api/webhooks/1280482865393569843/o-PwN4IXGJzw8B-dM6ppPOnsI3PAlsmE4mGH8GOhj1FenH5nUPZ9AKmsct1Y3uCPjLmX",embedContact("asd","asd","asd","asd","asd"));
        // Stampa del JSON
    }
}
