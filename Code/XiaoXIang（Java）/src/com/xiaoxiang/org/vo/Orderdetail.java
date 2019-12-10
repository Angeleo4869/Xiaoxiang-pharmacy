package com.xiaoxiang.org.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private Integer idOrder;
	private Buyer buyer;
	private ShopGoods shopGoods;
	private Vouchers vouchers;
	private Date paymentTime;
	private Double totalPrice;
	private String orderNumber;
	private Short logistics;
	private Oder order;
	private Set commentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(Buyer buyer, ShopGoods shopGoods, Vouchers vouchers, Date paymentTime, Double totalPrice,
			String orderNumber, Short logistics,Oder order) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.vouchers = vouchers;
		this.paymentTime = paymentTime;
		this.totalPrice = totalPrice;
		this.setOrderNumber(orderNumber);
		this.logistics = logistics;
		this.order = order;
	}

	/** full constructor */
	public Orderdetail(Buyer buyer, ShopGoods shopGoods, Vouchers vouchers, Date paymentTime, Double totalPrice,
			String orderNumber, Short logistics,Oder order, Set commentses) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.vouchers = vouchers;
		this.paymentTime = paymentTime;
		this.totalPrice = totalPrice;
		this.setOrderNumber(orderNumber);
		this.logistics = logistics;
		this.order = order;
		this.commentses = commentses;
	}

	// Property accessors

	public Integer getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public ShopGoods getShopGoods() {
		return this.shopGoods;
	}

	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}

	public Vouchers getVouchers() {
		return this.vouchers;
	}

	public void setVouchers(Vouchers vouchers) {
		this.vouchers = vouchers;
	}

	public Date getPaymentTime() {
		return this.paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Short getLogistics() {
		return this.logistics;
	}

	public void setLogistics(Short logistics) {
		this.logistics = logistics;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

	public Oder getOrder() {
		return order;
	}

	public void setOrder(Oder order) {
		this.order = order;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

}