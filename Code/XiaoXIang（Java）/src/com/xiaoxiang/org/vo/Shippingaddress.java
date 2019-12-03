package com.xiaoxiang.org.vo;

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

	// Constructors

	/** default constructor */
	public Shippingaddress() {
	}

	/** full constructor */
	public Shippingaddress(Integer idBuyer, String recipientName, String recipientTel, String recipientAddress) {
		this.idBuyer = idBuyer;
		this.recipientName = recipientName;
		this.recipientTel = recipientTel;
		this.recipientAddress = recipientAddress;
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

}