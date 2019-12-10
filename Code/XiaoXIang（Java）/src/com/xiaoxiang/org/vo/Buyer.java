package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Buyer entity. @author MyEclipse Persistence Tools
 */

public class Buyer implements java.io.Serializable {

	// Fields

	private Integer idBuyer;
	private String buyerName;
	private String buyerNumber;
	private String buyerPassword;
	private String buyerEmail;
	private String buyerTel;
	private String buyerHeadpor;
	private Set oders = new HashSet(0);
	private Set voucherses = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);
	private Set orderdetails = new HashSet(0);
	private Set complaintses = new HashSet(0);
	private Set collections = new HashSet(0);

	// Constructors

	/** default constructor */
	public Buyer() {
	}

	/** minimal constructor */
	public Buyer(String buyerName, String buyerNumber, String buyerPassword) {
		this.buyerName = buyerName;
		this.buyerNumber = buyerNumber;
		this.buyerPassword = buyerPassword;
	}

	/** full constructor */
	public Buyer(String buyerName, String buyerNumber, String buyerPassword, String buyerEmail, String buyerTel,
			String buyerHeadpor, Set oders, Set voucherses, Set shoppingcarts, Set orderdetails, Set complaintses,
			Set collections) {
		this.buyerName = buyerName;
		this.buyerNumber = buyerNumber;
		this.buyerPassword = buyerPassword;
		this.buyerEmail = buyerEmail;
		this.buyerTel = buyerTel;
		this.buyerHeadpor = buyerHeadpor;
		this.oders = oders;
		this.voucherses = voucherses;
		this.shoppingcarts = shoppingcarts;
		this.orderdetails = orderdetails;
		this.complaintses = complaintses;
		this.collections = collections;
	}

	// Property accessors

	public Integer getIdBuyer() {
		return this.idBuyer;
	}

	public void setIdBuyer(Integer idBuyer) {
		this.idBuyer = idBuyer;
	}

	public String getBuyerName() {
		return this.buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerNumber() {
		return this.buyerNumber;
	}

	public void setBuyerNumber(String buyerNumber) {
		this.buyerNumber = buyerNumber;
	}

	public String getBuyerPassword() {
		return this.buyerPassword;
	}

	public void setBuyerPassword(String buyerPassword) {
		this.buyerPassword = buyerPassword;
	}

	public String getBuyerEmail() {
		return this.buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerTel() {
		return this.buyerTel;
	}

	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}

	public String getBuyerHeadpor() {
		return this.buyerHeadpor;
	}

	public void setBuyerHeadpor(String buyerHeadpor) {
		this.buyerHeadpor = buyerHeadpor;
	}
	@JSON(serialize=false)
	public Set getOders() {
		return this.oders;
	}

	public void setOders(Set oders) {
		this.oders = oders;
	}
	@JSON(serialize=false)
	public Set getVoucherses() {
		return this.voucherses;
	}

	public void setVoucherses(Set voucherses) {
		this.voucherses = voucherses;
	}
	@JSON(serialize=false)
	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}
	@JSON(serialize=false)
	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}
	@JSON(serialize=false)
	public Set getComplaintses() {
		return this.complaintses;
	}

	public void setComplaintses(Set complaintses) {
		this.complaintses = complaintses;
	}
	@JSON(serialize=false)
	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

}