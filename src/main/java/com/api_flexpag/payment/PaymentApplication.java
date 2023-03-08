package com.api_flexpag.payment;

import com.api_flexpag.payment.entities.Payment;
import com.api_flexpag.payment.enums.PaymentStatus;
import com.api_flexpag.payment.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {

	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Payment p1 = new Payment(null, "05/03/2023 13:00", PaymentStatus.Pago);

		paymentRepository.saveAll(Arrays.asList(p1));

		System.out.println(p1.toString());
		System.out.println(LocalDateTime.now());


	}
}
