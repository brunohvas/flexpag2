package com.api_flexpag.payment.resources;

import com.api_flexpag.payment.entities.Payment;
import com.api_flexpag.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    //problemas no post do postman insert
    @PostMapping
    public ResponseEntity<Payment> insert(@RequestBody Payment obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //mesmo problema do Post, erro com a data
    @PutMapping(value = "/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
