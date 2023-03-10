package com.api_flexpag.payment.entities;

import com.api_flexpag.payment.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@Table(name = "tb_Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT + 3")
    @Column(nullable = false, length = 50)
    private LocalDateTime date;

    @Column(nullable = false, length = 50)
    private Integer paymentStatus;

    public Payment() {
    }

    public Payment(Long id, String date, PaymentStatus paymentStatus) {
        this.id = id;
        this.date = getDateFromString(date);
        setPaymentStatus(paymentStatus);

    }

    public PaymentStatus getPaymentStatus(){
        return PaymentStatus.value(paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if (paymentStatus != null) {
            this.paymentStatus = paymentStatus.getCode();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = getDateFromString(date);
    }




    public LocalDateTime getDateFromString(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(dateString, formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Agendamento: " +
                "id: " + id +
                ", data e hora do agendamento:" + date +
                ", situa????o do pagamento: " + getPaymentStatus() +
                '.';
    }
}


