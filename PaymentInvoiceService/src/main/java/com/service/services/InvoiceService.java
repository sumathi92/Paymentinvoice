package com.service.services;

import java.util.List;
import java.util.Optional;

import com.service.entity.Invoice;

public interface InvoiceService {

	Invoice saveAll(Invoice invoice);

	List<Invoice> getAll();

	Optional<Invoice> getById(int id);

	void deleteById(int id);

	Invoice update(Invoice invoice);
	Invoice getByInvoiceNumber(String invoiceNumber);

}
