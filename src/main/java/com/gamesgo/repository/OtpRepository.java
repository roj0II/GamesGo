package com.gamesgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamesgo.model.Otp;

public interface OtpRepository extends JpaRepository<Otp, Integer> {
	public Otp findByCode(String code);
}
