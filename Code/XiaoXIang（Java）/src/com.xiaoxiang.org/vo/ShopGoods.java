package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

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
	private Set voucherses = new HashSet(0);
	private Set oders = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);
	private Set collections = new HashSet(0);
	private Set orderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public ShopGoods() {
	}

	/** minimal constructor */
	public ShopGoods(Store store, Goods goods, Double shopGoodsPrice, Integer shopGoodsInventory,
			Double shopGoodsFreight) {
		this.store = store;
		this.goods = goods;
		this.shopGoodsPrice = shopGoodsPrice;
		this.shopGoodsInventory = shopGoodsInventory;
		this.shopGoodsFreight = shopGoodsFreight;
	}

	/** full constructor */
	public ShopGoods(Store store, Goods goods, String shopGoodsImage, Double shopGoodsPrice, Integer shopGoodsInventory,
			Double shopGoodsFreight, Set voucherses, Set oders, Set shoppingcarts, Set collections, Set orderdetails) {
		this.store = store;
		this.goods = goods;
		this.shopGoodsImage = shopGoodsImage;
		this.shopGoodsPrice = shopGoodsPrice;
		this.shopGoodsInventory = shopGoodsInventory;
		this.shopGoodsFreight = shopGoodsFreight;
		this.voucherses = voucherses;
		this.oders = oders;
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

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getShopGoodsImage() {
		return this.shopGoodsImage;
	}

	public void setShopGoodsImage(String shopGoodsImage) {
		this.shopGoodsImage = shopGoodsImage;
	}

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

	public Set getVoucherses() {
		return this.voucherses;
	}

	public void setVoucherses(Set voucherses) {
		this.voucherses = voucherses;
	}

	public Set getOders() {
		return this.oders;
	}

	public void setOders(Set oders) {
		this.oders = oders;
	}

	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

	public Set getCollections() {
		return this.collections;
	}

	public void setCollections(Set collections) {
		this.collections = collections;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

}