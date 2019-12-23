package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Shippingaddress entity. @author MyEclipse Persistence Tools
 */

public class Shippingaddress implements java.io.Serializable {

	// Fields

	private Integer idShippingAddress;
	private Buyer buyer;
	private String recipientName;
	private String recipientTel;
	private String addressDetail;
	private String provinces;
	private String city;
	private Set orderdetails = new HashSet(0);
	private Set buyers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shippingaddress() {
	}

	/** minimal constructor */
	public Shippingaddress(Buyer buyer, String recipientName, String recipientTel, String addressDetail,
			String provinces, String city) {
		this.buyer = buyer;
		this.recipientName = recipientName;
		this.recipientTel = recipientTel;
		this.addressDetail = addressDetail;
		this.provinces = provinces;
		this.city = city;
	}

	/** full constructor */
	public Shippingaddress(Buyer buyer, String recipientName, String recipientTel, String addressDetail,
			String provinces, String city, Set orderdetails, Set buyers) {
		this.buyer = buyer;
		this.recipientName = recipientName;
		this.recipientTel = recipientTel;
		this.addressDetail = addressDetail;
		this.provinces = provinces;
		this.city = city;
		this.orderdetails = orderdetails;
		this.buyers = buyers;
	}

	// Property accessors

	public Integer getIdShippingAddress() {
		return this.idShippingAddress;
	}

	public void setIdShippingAddress(Integer idShippingAddress) {
		this.idShippingAddress = idShippingAddress;
	}
	@JSON(serialize=false)
	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
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

	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getProvinces() {
		return this.provinces;
	}

	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@JSON(serialize=false)
	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}
	@JSON(serialize=false)
	public Set getBuyers() {
		return this.buyers;
	}

	public void setBuyers(Set buyers) {
		this.buyers = buyers;
	}

}