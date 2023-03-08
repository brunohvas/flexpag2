package com.api_flexpag.payment.enums;


import com.api_flexpag.payment.entities.Payment;

import java.time.LocalDateTime;

public enum PaymentStatus {

    Pendente(1),
    Pago(2);

    private int code;

    private PaymentStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static PaymentStatus value(int code) {
        for (PaymentStatus value : PaymentStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status");
    }
}






