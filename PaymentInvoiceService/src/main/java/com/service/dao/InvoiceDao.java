package com.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.entity.Invoice;

public interface InvoiceDao extends JpaRepository<Invoice, Integer> {
	Invoice findByInvoiceNumber(String invoiceNumber);

}
