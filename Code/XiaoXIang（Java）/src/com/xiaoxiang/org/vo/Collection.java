package com.xiaoxiang.org.vo;

/**
 * Collection entity. @author MyEclipse Persistence Tools
 */

public class Collection implements java.io.Serializable {

	// Fields

	private Integer idcollection;
	private Buyer buyer;
	private ShopGoods shopGoods;

	// Constructors

	/** default constructor */
	public Collection() {
	}

	/** full constructor */
	public Collection(Buyer buyer, ShopGoods shopGoods) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
	}

	// Property accessors

	public Integer getIdcollection() {
		return this.idcollection;
	}

	public void setIdcollection(Integer idcollection) {
		this.idcollection = idcollection;
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

}