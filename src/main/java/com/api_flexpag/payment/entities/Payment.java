package com.api_flexpag.payment.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;
    private Boolean pago = false;

    public Payment() {
    }

    public Payment(Long id, LocalDateTime date, Boolean paid) {
        this.id = id;
        this.date = date;
        this.pago = pago;
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
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
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", pago=" + pago +
                '}';
    }
}
