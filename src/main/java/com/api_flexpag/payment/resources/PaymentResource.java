package com.api_flexpag.payment.resources;

import com.api_flexpag.payment.entities.Payment;
import com.api_flexpag.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    //problemas no post do postman
    @PostMapping
    public ResponseEntity<Payment> insert(@RequestBody Payment obj){
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

}
