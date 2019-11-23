package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Vouchers entity. @author MyEclipse Persistence Tools
 */

public class Vouchers implements java.io.Serializable {

	// Fields

	private Integer idVouchers;
	private Buyer buyer;
	private ShopGoods shopGoods;
	private Double vouchersAmount;
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Vouchers() {
	}

	/** minimal constructor */
	public Vouchers(Buyer buyer, ShopGoods shopGoods, Double vouchersAmount) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.vouchersAmount = vouchersAmount;
	}

	/** full constructor */
	public Vouchers(Buyer buyer, ShopGoods shopGoods, Double vouchersAmount, Set orderdetails) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.vouchersAmount = vouchersAmount;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getIdVouchers() {
		return this.idVouchers;
	}

	public void setIdVouchers(Integer idVouchers) {
		this.idVouchers = idVouchers;
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

	public Double getVouchersAmount() {
		return this.vouchersAmount;
	}

	public void setVouchersAmount(Double vouchersAmount) {
		this.vouchersAmount = vouchersAmount;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}