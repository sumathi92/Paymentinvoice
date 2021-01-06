package com.service.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PaymentTerm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String description;
//	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date creationDate = new Date();
	private int days;
	private int reminderBeforeDays;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the days
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/**
	 * @return the reminderBeforeDays
	 */
	public int getReminderBeforeDays() {
		return reminderBeforeDays;
	}

	/**
	 * @param reminderBeforeDays the reminderBeforeDays to set
	 */
	public void setReminderBeforeDays(int reminderBeforeDays) {
		this.reminderBeforeDays = reminderBeforeDays;
	}

	@Override
	public String toString() {
		return "PaymentService [id=" + id + ", code=" + code + ", description=" + description + ", creationDate="
				+ creationDate + ", days=" + days + ", reminderBeforeDays=" + reminderBeforeDays + "]";
	}

}
