package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Shippingaddress entity. @author MyEclipse Persistence Tools
 */

public class Shippingaddress implements java.io.Serializable {

	// Fields

	private Integer idShippingAddress;
	private Integer idBuyer;
	private String recipientName;
	private String recipientTel;
	private String recipientAddress;
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shippingaddress() {
	}

	/** minimal constructor */
	public Shippingaddress(Integer idBuyer, String recipientName, String recipientTel, String recipientAddress) {
		this.idBuyer = idBuyer;
		this.recipientName = recipientName;
		this.recipientTel = recipientTel;
		this.recipientAddress = recipientAddress;
	}

	/** full constructor */
	public Shippingaddress(Integer idBuyer, String recipientName, String recipientTel, String recipientAddress,
			Set orderdetails) {
		this.idBuyer = idBuyer;
		this.recipientName = recipientName;
		this.recipientTel = recipientTel;
		this.recipientAddress = recipientAddress;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getIdShippingAddress() {
		return this.idShippingAddress;
	}

	public void setIdShippingAddress(Integer idShippingAddress) {
		this.idShippingAddress = idShippingAddress;
	}

	public Integer getIdBuyer() {
		return this.idBuyer;
	}

	public void setIdBuyer(Integer idBuyer) {
		this.idBuyer = idBuyer;
	}

	public String getRecipientName() {
		return this.recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientTel() {
		return this.recipientTel;
	}

	public void setRecipientTel(String recipientTel) {
		this.recipientTel = recipientTel;
	}

	public String getRecipientAddress() {
		return this.recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}