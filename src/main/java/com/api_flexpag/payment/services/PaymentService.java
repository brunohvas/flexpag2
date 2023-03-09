package com.api_flexpag.payment.services;

import com.api_flexpag.payment.entities.Payment;
import com.api_flexpag.payment.repositories.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAll() {
        return repository.findAll();
    }

    public Payment findById(Long id) {
        Optional<Payment> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Payment insert(Payment obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Payment update(Long id, Payment obj) {
        try {
            Payment entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }



    private void updateData(Payment entity, Payment obj) {
        entity.setId(obj.getId());
        entity.setDate(String.valueOf(obj.getDate()));
        entity.setPaymentStatus(obj.getPaymentStatus());
    }
}
