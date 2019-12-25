package com.xiaoxiang.org.vo;

/**
 * GoodsViewId entity. @author MyEclipse Persistence Tools
 */

public class GoodsViewId implements java.io.Serializable {

	// Fields

	private Integer idShopGoods;
	private String shopGoodsImage;
	private String shopGoodsName;
	private Double shopGoodsPrice;
	private String goodsMajorFunctioncol;
	private String goodsSeries;
	private String goodsClass;
	private Integer idGoods;
	private Integer idStore;

	// Constructors

	/** default constructor */
	public GoodsViewId() {
	}

	/** minimal constructor */
	public GoodsViewId(Integer idShopGoods, String shopGoodsName, Double shopGoodsPrice, String goodsMajorFunctioncol,
			Integer idGoods, Integer idStore) {
		this.idShopGoods = idShopGoods;
		this.shopGoodsName = shopGoodsName;
		this.shopGoodsPrice = shopGoodsPrice;
		this.goodsMajorFunctioncol = goodsMajorFunctioncol;
		this.idGoods = idGoods;
		this.idStore = idStore;
	}

	/** full constructor */
	public GoodsViewId(Integer idShopGoods, String shopGoodsImage, String shopGoodsName, Double shopGoodsPrice,
			String goodsMajorFunctioncol, String goodsSeries, String goodsClass, Integer idGoods, Integer idStore) {
		this.idShopGoods = idShopGoods;
		this.shopGoodsImage = shopGoodsImage;
		this.shopGoodsName = shopGoodsName;
		this.shopGoodsPrice = shopGoodsPrice;
		this.goodsMajorFunctioncol = goodsMajorFunctioncol;
		this.goodsSeries = goodsSeries;
		this.goodsClass = goodsClass;
		this.idGoods = idGoods;
		this.idStore = idStore;
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

	public String getGoodsMajorFunctioncol() {
		return this.goodsMajorFunctioncol;
	}

	public void setGoodsMajorFunctioncol(String goodsMajorFunctioncol) {
		this.goodsMajorFunctioncol = goodsMajorFunctioncol;
	}

	public String getGoodsSeries() {
		return this.goodsSeries;
	}

	public void setGoodsSeries(String goodsSeries) {
		this.goodsSeries = goodsSeries;
	}

	public String getGoodsClass() {
		return this.goodsClass;
	}

	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}

	public Integer getIdGoods() {
		return this.idGoods;
	}

	public void setIdGoods(Integer idGoods) {
		this.idGoods = idGoods;
	}

	public Integer getIdStore() {
		return this.idStore;
	}

	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GoodsViewId))
			return false;
		GoodsViewId castOther = (GoodsViewId) other;

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
				&& ((this.getGoodsMajorFunctioncol() == castOther.getGoodsMajorFunctioncol())
						|| (this.getGoodsMajorFunctioncol() != null && castOther.getGoodsMajorFunctioncol() != null
								&& this.getGoodsMajorFunctioncol().equals(castOther.getGoodsMajorFunctioncol())))
				&& ((this.getGoodsSeries() == castOther.getGoodsSeries())
						|| (this.getGoodsSeries() != null && castOther.getGoodsSeries() != null
								&& this.getGoodsSeries().equals(castOther.getGoodsSeries())))
				&& ((this.getGoodsClass() == castOther.getGoodsClass()) || (this.getGoodsClass() != null
						&& castOther.getGoodsClass() != null && this.getGoodsClass().equals(castOther.getGoodsClass())))
				&& ((this.getIdGoods() == castOther.getIdGoods()) || (this.getIdGoods() != null
						&& castOther.getIdGoods() != null && this.getIdGoods().equals(castOther.getIdGoods())))
				&& ((this.getIdStore() == castOther.getIdStore()) || (this.getIdStore() != null
						&& castOther.getIdStore() != null && this.getIdStore().equals(castOther.getIdStore())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdShopGoods() == null ? 0 : this.getIdShopGoods().hashCode());
		result = 37 * result + (getShopGoodsImage() == null ? 0 : this.getShopGoodsImage().hashCode());
		result = 37 * result + (getShopGoodsName() == null ? 0 : this.getShopGoodsName().hashCode());
		result = 37 * result + (getShopGoodsPrice() == null ? 0 : this.getShopGoodsPrice().hashCode());
		result = 37 * result + (getGoodsMajorFunctioncol() == null ? 0 : this.getGoodsMajorFunctioncol().hashCode());
		result = 37 * result + (getGoodsSeries() == null ? 0 : this.getGoodsSeries().hashCode());
		result = 37 * result + (getGoodsClass() == null ? 0 : this.getGoodsClass().hashCode());
		result = 37 * result + (getIdGoods() == null ? 0 : this.getIdGoods().hashCode());
		result = 37 * result + (getIdStore() == null ? 0 : this.getIdStore().hashCode());
		return result;
	}

}