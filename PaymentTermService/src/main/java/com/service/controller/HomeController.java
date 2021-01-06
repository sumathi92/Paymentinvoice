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
import com.service.entity.PaymentTerm;
import com.service.exception.DetailsNotFoundException;
import com.service.service.PaymentTermService;

@RestController
@RequestMapping("/paymentTerm")
public class HomeController {

	@Autowired
	private PaymentTermService paymentTermService;

	@PostMapping("/save")
	public ResponseEntity<PaymentTerm> saveAll(@RequestBody PaymentTerm paymentTerm) {
		paymentTerm.setId(0);
		paymentTerm = paymentTermService.saveAll(paymentTerm);
		if (paymentTerm == null) {
			return new ResponseEntity<PaymentTerm>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<PaymentTerm>(paymentTerm, HttpStatus.CREATED);
		}
	}

	@GetMapping("/getAll")
	public List<PaymentTerm> getAll() {
		List<PaymentTerm> paymentTerms = paymentTermService.getAll();

		if (paymentTerms.isEmpty()) {
			throw new DetailsNotFoundException("No Data found in DataBase");
		} else {
			return paymentTerms;
		}
	}

	@GetMapping("/getById/{id}")
	public Optional<PaymentTerm> getbyId(@PathVariable int id) {
		Optional<PaymentTerm> optional = paymentTermService.getById(id);

		if (!optional.isPresent()) {
			throw new DetailsNotFoundException("id " + id + " not found");
		} else {
			return optional;
		}
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {

		Optional<PaymentTerm> optional = paymentTermService.getById(id);
		if (optional.isPresent()) {
			paymentTermService.deleteById(id);
			return "Deleted details :" + id;
		} else {
			throw new DetailsNotFoundException(id + " not found");
		}

	}

	@PutMapping("/update")
	public PaymentTerm update(@RequestBody PaymentTerm paymentTerm) {
		PaymentTerm paymentTerm2 = paymentTermService.update(paymentTerm);
		if (paymentTerm2 == null) {
			throw new DetailsNotFoundException("not updated");
		} else {
			return paymentTerm2;
		}

	}

}
