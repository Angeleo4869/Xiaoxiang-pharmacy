package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Oder entity. @author MyEclipse Persistence Tools
 */

public class Oder implements java.io.Serializable {

	// Fields

	private Integer idOder;
	private Buyer buyer;
	private ShopGoods shopGoods;
	private Short oderState;
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Oder() {
	}

	/** minimal constructor */
	public Oder(Buyer buyer, ShopGoods shopGoods, Short oderState) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.oderState = oderState;
	}

	/** full constructor */
	public Oder(Buyer buyer, ShopGoods shopGoods, Short oderState, Set orderdetails) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.oderState = oderState;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getIdOder() {
		return this.idOder;
	}

	public void setIdOder(Integer idOder) {
		this.idOder = idOder;
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

	public Short getOderState() {
		return this.oderState;
	}

	public void setOderState(Short oderState) {
		this.oderState = oderState;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}