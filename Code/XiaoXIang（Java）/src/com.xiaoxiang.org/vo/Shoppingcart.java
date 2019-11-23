package com.xiaoxiang.org.vo;

/**
 * Shoppingcart entity. @author MyEclipse Persistence Tools
 */

public class Shoppingcart implements java.io.Serializable {

	// Fields

	private Integer idshoppingcart;
	private Buyer buyer;
	private ShopGoods shopGoods;
	private Integer goodsNumber;

	// Constructors

	/** default constructor */
	public Shoppingcart() {
	}

	/** full constructor */
	public Shoppingcart(Buyer buyer, ShopGoods shopGoods, Integer goodsNumber) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.goodsNumber = goodsNumber;
	}

	// Property accessors

	public Integer getIdshoppingcart() {
		return this.idshoppingcart;
	}

	public void setIdshoppingcart(Integer idshoppingcart) {
		this.idshoppingcart = idshoppingcart;
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

	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

}