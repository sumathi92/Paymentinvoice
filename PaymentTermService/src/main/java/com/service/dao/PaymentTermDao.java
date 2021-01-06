package com.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.entity.PaymentTerm;

public interface PaymentTermDao extends JpaRepository<PaymentTerm, Integer>{

}
