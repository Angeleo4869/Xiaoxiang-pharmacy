package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * ShopGoods entity. @author MyEclipse Persistence Tools
 */

public class ShopGoods implements java.io.Serializable {

	// Fields

	private Integer idShopGoods;
	private Store store;
	private Goods goods;
	private String shopGoodsImage;
	private Double shopGoodsPrice;
	private Integer shopGoodsInventory;
	private Double shopGoodsFreight;
	private Integer shopGoodsSales;
	private String shopGoodsName;
	private String shopGoodsDetailImage;
	private Set voucherses = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);
	private Set collections = new HashSet(0);
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public ShopGoods() {
	}

	/** minimal constructor */
	public ShopGoods(Store store, Goods goods, Double shopGoodsPrice, Integer shopGoodsInventory,
			Double shopGoodsFreight, Integer shopGoodsSales, String shopGoodsName) {
		this.store = store;
		this.goods = goods;
		this.shopGoodsPrice = shopGoodsPrice;
		this.shopGoodsInventory = shopGoodsInventory;
		this.shopGoodsFreight = shopGoodsFreight;
		this.shopGoodsSales = shopGoodsSales;
		this.shopGoodsName = shopGoodsName;
	}

	/** full constructor */
	public ShopGoods(Store store, Goods goods, String shopGoodsImage, Double shopGoodsPrice, Integer shopGoodsInventory,
			Double shopGoodsFreight, Integer shopGoodsSales, String shopGoodsName, String shopGoodsDetailImage,
			Set voucherses, Set shoppingcarts, Set collections, Set orderdetails) {
		this.store = store;
		this.goods = goods;
		this.shopGoodsImage = shopGoodsImage;
		this.shopGoodsPrice = shopGoodsPrice;
		this.shopGoodsInventory = shopGoodsInventory;
		this.shopGoodsFreight = shopGoodsFreight;
		this.shopGoodsSales = shopGoodsSales;
		this.shopGoodsName = shopGoodsName;
		this.shopGoodsDetailImage = shopGoodsDetailImage;
		this.voucherses = voucherses;
		this.shoppingcarts = shoppingcarts;
		this.collections = collections;
		this.orderdetails = orderdetails;
	}

	// Property accessors

	public Integer getIdShopGoods() {
		return this.idShopGoods;
	}

	public void setIdShopGoods(Integer idShopGoods) {
		this.idShopGoods = idShopGoods;
	}
	@JSON(serialize=false)
	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	@JSON(serialize=false)
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@JSON(serialize=false)
	public String getShopGoodsImage() {
		return this.shopGoodsImage;
	}

	public void setShopGoodsImage(String shopGoodsImage) {
		this.shopGoodsImage = shopGoodsImage;
	}
	@JSON(serialize=false)
	public Double getShopGoodsPrice() {
		return this.shopGoodsPrice;
	}

	public void setShopGoodsPrice(Double shopGoodsPrice) {
		this.shopGoodsPrice = shopGoodsPrice;
	}

	public Integer getShopGoodsInventory() {
		return this.shopGoodsInventory;
	}

	public void setShopGoodsInventory(Integer shopGoodsInventory) {
		this.shopGoodsInventory = shopGoodsInventory;
	}

	public Double getShopGoodsFreight() {
		return this.shopGoodsFreight;
	}

	public void setShopGoodsFreight(Double shopGoodsFreight) {
		this.shopGoodsFreight = shopGoodsFreight;
	}

	public Integer getShopGoodsSales() {
		return this.shopGoodsSales;
	}

	public void setShopGoodsSales(Integer shopGoodsSales) {
		this.shopGoodsSales = shopGoodsSales;
	}

	public String getShopGoodsName() {
		return this.shopGoodsName;
	}

	public void setShopGoodsName(String shopGoodsName) {
		this.shopGoodsName = shopGoodsName;
	}

	public String getShopGoodsDetailImage() {
		return this.shopGoodsDetailImage;
	}

	public void setShopGoodsDetailImage(String shopGoodsDetailImage) {
		this.shopGoodsDetailImage = shopGoodsDetailImage;
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
	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}
	@JSON(serialize=false)
	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}