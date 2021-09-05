package com.app.wesomma.domain.message;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGE")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String messageText;

	private Boolean readit;

	private Date shippingDate;

	private Date dateReading;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public boolean getReadit() {
		return readit;
	}

	public void setReadit(boolean readit) {
		this.readit = readit;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Date getDateReading() {
		return dateReading;
	}

	public void setDateReading(Date dateReading) {
		this.dateReading = dateReading;
	}
	

	
}
