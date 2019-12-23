package com.xiaoxiang.org.vo;

/**
 * GoodsDetailViewId entity. @author MyEclipse Persistence Tools
 */

public class GoodsDetailViewId implements java.io.Serializable {

	// Fields

	private Integer idShopGoods;
	private String shopGoodsImage;
	private String shopGoodsName;
	private Double shopGoodsPrice;
	private Integer shopGoodsSales;
	private Double shopGoodsFreight;
	private Integer shopGoodsInventory;
	private String shopGoodsDetailImage;
	private String goodsSpecifications;

	// Constructors

	/** default constructor */
	public GoodsDetailViewId() {
	}

	/** minimal constructor */
	public GoodsDetailViewId(Integer idShopGoods, String shopGoodsName, Double shopGoodsPrice, Integer shopGoodsSales,
			Double shopGoodsFreight, Integer shopGoodsInventory, String goodsSpecifications) {
		this.idShopGoods = idShopGoods;
		this.shopGoodsName = shopGoodsName;
		this.shopGoodsPrice = shopGoodsPrice;
		this.shopGoodsSales = shopGoodsSales;
		this.shopGoodsFreight = shopGoodsFreight;
		this.shopGoodsInventory = shopGoodsInventory;
		this.goodsSpecifications = goodsSpecifications;
	}

	/** full constructor */
	public GoodsDetailViewId(Integer idShopGoods, String shopGoodsImage, String shopGoodsName, Double shopGoodsPrice,
			Integer shopGoodsSales, Double shopGoodsFreight, Integer shopGoodsInventory, String shopGoodsDetailImage,
			String goodsSpecifications) {
		this.idShopGoods = idShopGoods;
		this.shopGoodsImage = shopGoodsImage;
		this.shopGoodsName = shopGoodsName;
		this.shopGoodsPrice = shopGoodsPrice;
		this.shopGoodsSales = shopGoodsSales;
		this.shopGoodsFreight = shopGoodsFreight;
		this.shopGoodsInventory = shopGoodsInventory;
		this.shopGoodsDetailImage = shopGoodsDetailImage;
		this.goodsSpecifications = goodsSpecifications;
	}

	// Property accessors

	public Integer getIdShopGoods() {
		return this.idShopGoods;
	}

	public void setIdShopGoods(Integer idShopGoods) {
		this.idShopGoods = idShopGoods;
	}

	public String getShopGoodsImage() {
		return this.shopGoodsImage;
	}

	public void setShopGoodsImage(String shopGoodsImage) {
		this.shopGoodsImage = shopGoodsImage;
	}

	public String getShopGoodsName() {
		return this.shopGoodsName;
	}

	public void setShopGoodsName(String shopGoodsName) {
		this.shopGoodsName = shopGoodsName;
	}

	public Double getShopGoodsPrice() {
		return this.shopGoodsPrice;
	}

	public void setShopGoodsPrice(Double shopGoodsPrice) {
		this.shopGoodsPrice = shopGoodsPrice;
	}

	public Integer getShopGoodsSales() {
		return this.shopGoodsSales;
	}

	public void setShopGoodsSales(Integer shopGoodsSales) {
		this.shopGoodsSales = shopGoodsSales;
	}

	public Double getShopGoodsFreight() {
		return this.shopGoodsFreight;
	}

	public void setShopGoodsFreight(Double shopGoodsFreight) {
		this.shopGoodsFreight = shopGoodsFreight;
	}

	public Integer getShopGoodsInventory() {
		return this.shopGoodsInventory;
	}

	public void setShopGoodsInventory(Integer shopGoodsInventory) {
		this.shopGoodsInventory = shopGoodsInventory;
	}

	public String getShopGoodsDetailImage() {
		return this.shopGoodsDetailImage;
	}

	public void setShopGoodsDetailImage(String shopGoodsDetailImage) {
		this.shopGoodsDetailImage = shopGoodsDetailImage;
	}

	public String getGoodsSpecifications() {
		return this.goodsSpecifications;
	}

	public void setGoodsSpecifications(String goodsSpecifications) {
		this.goodsSpecifications = goodsSpecifications;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GoodsDetailViewId))
			return false;
		GoodsDetailViewId castOther = (GoodsDetailViewId) other;

		return ((this.getIdShopGoods() == castOther.getIdShopGoods()) || (this.getIdShopGoods() != null
				&& castOther.getIdShopGoods() != null && this.getIdShopGoods().equals(castOther.getIdShopGoods())))
				&& ((this.getShopGoodsImage() == castOther.getShopGoodsImage())
						|| (this.getShopGoodsImage() != null && castOther.getShopGoodsImage() != null
								&& this.getShopGoodsImage().equals(castOther.getShopGoodsImage())))
				&& ((this.getShopGoodsName() == castOther.getShopGoodsName())
						|| (this.getShopGoodsName() != null && castOther.getShopGoodsName() != null
								&& this.getShopGoodsName().equals(castOther.getShopGoodsName())))
				&& ((this.getShopGoodsPrice() == castOther.getShopGoodsPrice())
						|| (this.getShopGoodsPrice() != null && castOther.getShopGoodsPrice() != null
								&& this.getShopGoodsPrice().equals(castOther.getShopGoodsPrice())))
				&& ((this.getShopGoodsSales() == castOther.getShopGoodsSales())
						|| (this.getShopGoodsSales() != null && castOther.getShopGoodsSales() != null
								&& this.getShopGoodsSales().equals(castOther.getShopGoodsSales())))
				&& ((this.getShopGoodsFreight() == castOther.getShopGoodsFreight())
						|| (this.getShopGoodsFreight() != null && castOther.getShopGoodsFreight() != null
								&& this.getShopGoodsFreight().equals(castOther.getShopGoodsFreight())))
				&& ((this.getShopGoodsInventory() == castOther.getShopGoodsInventory())
						|| (this.getShopGoodsInventory() != null && castOther.getShopGoodsInventory() != null
								&& this.getShopGoodsInventory().equals(castOther.getShopGoodsInventory())))
				&& ((this.getShopGoodsDetailImage() == castOther.getShopGoodsDetailImage())
						|| (this.getShopGoodsDetailImage() != null && castOther.getShopGoodsDetailImage() != null
								&& this.getShopGoodsDetailImage().equals(castOther.getShopGoodsDetailImage())))
				&& ((this.getGoodsSpecifications() == castOther.getGoodsSpecifications())
						|| (this.getGoodsSpecifications() != null && castOther.getGoodsSpecifications() != null
								&& this.getGoodsSpecifications().equals(castOther.getGoodsSpecifications())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdShopGoods() == null ? 0 : this.getIdShopGoods().hashCode());
		result = 37 * result + (getShopGoodsImage() == null ? 0 : this.getShopGoodsImage().hashCode());
		result = 37 * result + (getShopGoodsName() == null ? 0 : this.getShopGoodsName().hashCode());
		result = 37 * result + (getShopGoodsPrice() == null ? 0 : this.getShopGoodsPrice().hashCode());
		result = 37 * result + (getShopGoodsSales() == null ? 0 : this.getShopGoodsSales().hashCode());
		result = 37 * result + (getShopGoodsFreight() == null ? 0 : this.getShopGoodsFreight().hashCode());
		result = 37 * result + (getShopGoodsInventory() == null ? 0 : this.getShopGoodsInventory().hashCode());
		result = 37 * result + (getShopGoodsDetailImage() == null ? 0 : this.getShopGoodsDetailImage().hashCode());
		result = 37 * result + (getGoodsSpecifications() == null ? 0 : this.getGoodsSpecifications().hashCode());
		return result;
	}

}