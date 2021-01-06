package com.service.service;

import java.util.List;
import java.util.Optional;

import com.service.entity.PaymentTerm;

public interface PaymentTermService {

	PaymentTerm saveAll(PaymentTerm paymentTerm);

	List<PaymentTerm> getAll();

	Optional<PaymentTerm> getById(int id);

	void deleteById(int id);

	PaymentTerm update(PaymentTerm paymentTerm);

}
