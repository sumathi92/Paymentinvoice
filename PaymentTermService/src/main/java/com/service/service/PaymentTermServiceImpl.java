package com.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.dao.PaymentTermDao;
import com.service.entity.PaymentTerm;
import com.service.exception.DetailsNotFoundException;

@Service
public class PaymentTermServiceImpl implements PaymentTermService {

	@Autowired
	private PaymentTermDao paymentTermDao;

	@Override
	public PaymentTerm saveAll(PaymentTerm paymentTerm) {

		if (paymentTerm.getId() == 0) {

			paymentTerm.setCode("NET " + paymentTerm.getCode());

			if (paymentTerm.getDays() == 30 ) {
				paymentTerm.setReminderBeforeDays(4);
			} else if (paymentTerm.getDays() == 45) {
				paymentTerm.setReminderBeforeDays(5);
			} else if (paymentTerm.getDays() == 15){
				paymentTerm.setReminderBeforeDays(2);
			}else {
				throw new DetailsNotFoundException("please enter valid Days "+paymentTerm.getDays()+" is not valid");
			}
		}
		
		/* 
		 by range
		 
		 if (paymentTerm.getId() == 0) {

			paymentTerm.setCode("NET " + paymentTerm.getCode());

			if (paymentTerm.getDays() >= 30 && paymentTerm.getDays() <= 44) {
				paymentTerm.setReminderBeforeDays(4);
			} else if (paymentTerm.getDays() >= 45) {
				paymentTerm.setReminderBeforeDays(5);
			} else {
				paymentTerm.setReminderBeforeDays(2);
			}
		}
		  
		  */
		
		return paymentTermDao.save(paymentTerm);
	}

	@Override
	public List<PaymentTerm> getAll() {
		return paymentTermDao.findAll();
	}

	@Override
	public Optional<PaymentTerm> getById(int id) {
		return paymentTermDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		paymentTermDao.deleteById(id);
	}

	@Override
	public PaymentTerm update(PaymentTerm paymentTerm) {
		return paymentTermDao.save(paymentTerm);
	}

}
