package com.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.dao.InvoiceDao;
import com.service.entity.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public Invoice saveAll(Invoice invoice) {
		
		if(invoice.getId()==0) {
			invoice.setInvoiceNumber("INV-"+invoice.getInvoiceNumber());
		}
		
		return invoiceDao.save(invoice);
	}

	@Override
	public List<Invoice> getAll() {
		return invoiceDao.findAll();
	}

	@Override
	public Optional<Invoice> getById(int id) {
		return invoiceDao.findById(id);
	}
	@Override
	public Invoice getByInvoiceNumber(String invoiceNumber) {
		return invoiceDao.findByInvoiceNumber(invoiceNumber);
	}

	@Override
	public void deleteById(int id) {
		invoiceDao.deleteById(id);
	}

	@Override
	public Invoice update(Invoice invoice) {
		return invoiceDao.save(invoice);
	}
	
}
