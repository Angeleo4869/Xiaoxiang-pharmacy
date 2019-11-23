package com.xiaoxiang.org.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer idGoods;
	private Majorfunction majorfunction;
	private String goodsNumber;
	private String goodsComName;
	private String goodsCheName;
	private String goodsComposition;
	private String goodsCharacter;
	private Double storePurchasePrice;
	private String goodsSpecifications;
	private Integer goodsUsage;
	private String goodsTaboo;
	private String goodsValidity;
	private Date goodsProductionDate;
	private String goodsManufacturer;
	private Set shopGoodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Majorfunction majorfunction, String goodsNumber, String goodsComName, String goodsCheName,
			String goodsComposition, String goodsCharacter, Double storePurchasePrice, String goodsSpecifications,
			Integer goodsUsage, String goodsTaboo, String goodsValidity, Date goodsProductionDate,
			String goodsManufacturer) {
		this.majorfunction = majorfunction;
		this.goodsNumber = goodsNumber;
		this.goodsComName = goodsComName;
		this.goodsCheName = goodsCheName;
		this.goodsComposition = goodsComposition;
		this.goodsCharacter = goodsCharacter;
		this.storePurchasePrice = storePurchasePrice;
		this.goodsSpecifications = goodsSpecifications;
		this.goodsUsage = goodsUsage;
		this.goodsTaboo = goodsTaboo;
		this.goodsValidity = goodsValidity;
		this.goodsProductionDate = goodsProductionDate;
		this.goodsManufacturer = goodsManufacturer;
	}

	/** full constructor */
	public Goods(Majorfunction majorfunction, String goodsNumber, String goodsComName, String goodsCheName,
			String goodsComposition, String goodsCharacter, Double storePurchasePrice, String goodsSpecifications,
			Integer goodsUsage, String goodsTaboo, String goodsValidity, Date goodsProductionDate,
			String goodsManufacturer, Set shopGoodses) {
		this.majorfunction = majorfunction;
		this.goodsNumber = goodsNumber;
		this.goodsComName = goodsComName;
		this.goodsCheName = goodsCheName;
		this.goodsComposition = goodsComposition;
		this.goodsCharacter = goodsCharacter;
		this.storePurchasePrice = storePurchasePrice;
		this.goodsSpecifications = goodsSpecifications;
		this.goodsUsage = goodsUsage;
		this.goodsTaboo = goodsTaboo;
		this.goodsValidity = goodsValidity;
		this.goodsProductionDate = goodsProductionDate;
		this.goodsManufacturer = goodsManufacturer;
		this.shopGoodses = shopGoodses;
	}

	// Property accessors

	public Integer getIdGoods() {
		return this.idGoods;
	}

	public void setIdGoods(Integer idGoods) {
		this.idGoods = idGoods;
	}

	public Majorfunction getMajorfunction() {
		return this.majorfunction;
	}

	public void setMajorfunction(Majorfunction majorfunction) {
		this.majorfunction = majorfunction;
	}

	public String getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getGoodsComName() {
		return this.goodsComName;
	}

	public void setGoodsComName(String goodsComName) {
		this.goodsComName = goodsComName;
	}

	public String getGoodsCheName() {
		return this.goodsCheName;
	}

	public void setGoodsCheName(String goodsCheName) {
		this.goodsCheName = goodsCheName;
	}

	public String getGoodsComposition() {
		return this.goodsComposition;
	}

	public void setGoodsComposition(String goodsComposition) {
		this.goodsComposition = goodsComposition;
	}

	public String getGoodsCharacter() {
		return this.goodsCharacter;
	}

	public void setGoodsCharacter(String goodsCharacter) {
		this.goodsCharacter = goodsCharacter;
	}

	public Double getStorePurchasePrice() {
		return this.storePurchasePrice;
	}

	public void setStorePurchasePrice(Double storePurchasePrice) {
		this.storePurchasePrice = storePurchasePrice;
	}

	public String getGoodsSpecifications() {
		return this.goodsSpecifications;
	}

	public void setGoodsSpecifications(String goodsSpecifications) {
		this.goodsSpecifications = goodsSpecifications;
	}

	public Integer getGoodsUsage() {
		return this.goodsUsage;
	}

	public void setGoodsUsage(Integer goodsUsage) {
		this.goodsUsage = goodsUsage;
	}

	public String getGoodsTaboo() {
		return this.goodsTaboo;
	}

	public void setGoodsTaboo(String goodsTaboo) {
		this.goodsTaboo = goodsTaboo;
	}

	public String getGoodsValidity() {
		return this.goodsValidity;
	}

	public void setGoodsValidity(String goodsValidity) {
		this.goodsValidity = goodsValidity;
	}

	public Date getGoodsProductionDate() {
		return this.goodsProductionDate;
	}

	public void setGoodsProductionDate(Date goodsProductionDate) {
		this.goodsProductionDate = goodsProductionDate;
	}

	public String getGoodsManufacturer() {
		return this.goodsManufacturer;
	}

	public void setGoodsManufacturer(String goodsManufacturer) {
		this.goodsManufacturer = goodsManufacturer;
	}

	public Set getShopGoodses() {
		return this.shopGoodses;
	}

	public void setShopGoodses(Set shopGoodses) {
		this.shopGoodses = shopGoodses;
	}

}