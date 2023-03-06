package com.api_flexpag.payment;

import com.api_flexpag.payment.entities.Payment;
import com.api_flexpag.payment.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {

	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Payment p1 = new Payment(null, "06/03/2023 16:50", false);
		Payment p2 = new Payment(null, "12/06/2020 15:00", false);

		paymentRepository.saveAll(Arrays.asList(p1, p2));

		System.out.println(p1 + "payment test " + p2);



	}
}
