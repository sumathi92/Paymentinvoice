package com.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.entity.Invoice;
import com.service.exception.DetailsNotFoundException;
import com.service.services.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class HomeController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping("/save")
	public ResponseEntity<Invoice> saveAll(@RequestBody Invoice invoice) {
		invoice.setId(0);
		invoice= invoiceService.saveAll(invoice);
		if (invoice == null) {
			return new ResponseEntity<Invoice>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Invoice>(invoice, HttpStatus.CREATED);
		}
	}

	@GetMapping("/getAll")
	public List<Invoice> getAll(){
		
		List<Invoice> invoices = invoiceService.getAll();
		if (invoices.isEmpty()) {
			throw new DetailsNotFoundException("No Data found in DataBase");
		} else {
			return invoices;
		}
	}

	@GetMapping("/getById/{id}")
	public Optional<Invoice> getbyId(@PathVariable int id) {
		
		Optional<Invoice> optional = invoiceService.getById(id);
		
		if (!optional.isPresent()) {
			throw new DetailsNotFoundException("id " + id + " not found");
		} else {
			return optional;
		}

	}
	
	@GetMapping("/getByInvoiceNumber/{invoiceNumber}")
	public Invoice getByInvoiceNumber(@PathVariable("invoiceNumber") String invoiceNumber) {
		Invoice invoice = invoiceService.getByInvoiceNumber(invoiceNumber);

		if (invoice==null) {
			throw new DetailsNotFoundException("id " + invoiceNumber + " not found");
		} else {
			return invoice;
		}
	}
	
	@PutMapping("/update")
	public Invoice update(@RequestBody Invoice Invoice) {
		Invoice invoice2 = invoiceService.update(Invoice);
		
		if (invoice2 == null) {
			throw new DetailsNotFoundException("not updated");
		} else {
			return invoice2;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		
		Optional<Invoice> optional = invoiceService.getById(id);
		
		if (optional.isPresent()) {
			invoiceService.deleteById(id);
			return "Deleted details :"+id;
		} else {
			throw new DetailsNotFoundException( id + " not found");
		}
		
	}
	
	
}
