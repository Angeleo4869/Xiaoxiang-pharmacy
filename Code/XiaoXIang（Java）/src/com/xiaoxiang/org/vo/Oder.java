package com.xiaoxiang.org.vo;

/**
 * Oder entity. @author MyEclipse Persistence Tools
 */

public class Oder implements java.io.Serializable {

	// Fields

	private Integer idOder;
	private Buyer buyer;
	private ShopGoods shopGoods;
	private Short oderState;

	// Constructors

	/** default constructor */
	public Oder() {
	}

	/** full constructor */
	public Oder(Buyer buyer, ShopGoods shopGoods, Short oderState) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.oderState = oderState;
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

}