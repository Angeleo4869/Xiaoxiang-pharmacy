package com.xiaoxiang.org.vo;

import java.sql.Timestamp;
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
	private Timestamp paymentTime;
	private Double totalPrice;
	private Integer goodsNumber;
	private Short logistics;
	private Set commentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(Buyer buyer, ShopGoods shopGoods, Vouchers vouchers, Timestamp paymentTime, Double totalPrice,
			Integer goodsNumber, Short logistics) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.vouchers = vouchers;
		this.paymentTime = paymentTime;
		this.totalPrice = totalPrice;
		this.goodsNumber = goodsNumber;
		this.logistics = logistics;
	}

	/** full constructor */
	public Orderdetail(Buyer buyer, ShopGoods shopGoods, Vouchers vouchers, Timestamp paymentTime, Double totalPrice,
			Integer goodsNumber, Short logistics, Set commentses) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.vouchers = vouchers;
		this.paymentTime = paymentTime;
		this.totalPrice = totalPrice;
		this.goodsNumber = goodsNumber;
		this.logistics = logistics;
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

	public Timestamp getPaymentTime() {
		return this.paymentTime;
	}

	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
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

}