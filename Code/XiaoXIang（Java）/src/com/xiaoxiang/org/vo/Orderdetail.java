package com.xiaoxiang.org.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Orderdetail entity. @author MyEclipse Persistence Tools
 */

public class Orderdetail implements java.io.Serializable {

	// Fields

	private Integer idOrder;
	private Buyer buyer;
	private ShopGoods shopGoods;
	private Vouchers vouchers;
	private Shippingaddress shippingaddress;
	private Date paymentTime;
	private Double totalPrice;
	private String orderNumber;
	private Short logistics;
	private Integer goodsNumber;
	private Short oderState;
	private Set commentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orderdetail() {
	}

	/** minimal constructor */
	public Orderdetail(Buyer buyer, ShopGoods shopGoods, Date paymentTime, Double totalPrice, String orderNumber,
			Short logistics, Integer goodsNumber, Short oderState) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.paymentTime = paymentTime;
		this.totalPrice = totalPrice;
		this.orderNumber = orderNumber;
		this.logistics = logistics;
		this.goodsNumber = goodsNumber;
		this.oderState = oderState;
	}

	/** full constructor */
	public Orderdetail(Buyer buyer, ShopGoods shopGoods, Vouchers vouchers, Shippingaddress shippingaddress,
			Date paymentTime, Double totalPrice, String orderNumber, Short logistics, Integer goodsNumber,
			Short oderState, Set commentses) {
		this.buyer = buyer;
		this.shopGoods = shopGoods;
		this.vouchers = vouchers;
		this.shippingaddress = shippingaddress;
		this.paymentTime = paymentTime;
		this.totalPrice = totalPrice;
		this.orderNumber = orderNumber;
		this.logistics = logistics;
		this.goodsNumber = goodsNumber;
		this.oderState = oderState;
		this.commentses = commentses;
	}

	// Property accessors

	public Integer getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}
	@JSON(serialize=false)
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

	public Shippingaddress getShippingaddress() {
		return this.shippingaddress;
	}

	public void setShippingaddress(Shippingaddress shippingaddress) {
		this.shippingaddress = shippingaddress;
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

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Short getLogistics() {
		return this.logistics;
	}

	public void setLogistics(Short logistics) {
		this.logistics = logistics;
	}

	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Short getOderState() {
		return this.oderState;
	}

	public void setOderState(Short oderState) {
		this.oderState = oderState;
	}
	@JSON(serialize=false)
	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

}