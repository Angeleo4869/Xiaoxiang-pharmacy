package com.xiaoxiang.org.vo;

/**
 * OrderViewId entity. @author MyEclipse Persistence Tools
 */

public class OrderViewId implements java.io.Serializable {

	// Fields

	private Integer idorder;
	private Integer idStore;
	private Integer idbuyer;
	private String storename;
	private Short odstate;
	private String shname;
	private String shimage;
	private Double shPrice;
	private Double odprice;
	private Integer odNumber;

	// Constructors

	/** default constructor */
	public OrderViewId() {
	}

	/** minimal constructor */
	public OrderViewId(Integer idorder, Integer idStore, Integer idbuyer, Short odstate, String shname, Double shPrice,
			Double odprice, Integer odNumber) {
		this.idorder = idorder;
		this.idStore = idStore;
		this.idbuyer = idbuyer;
		this.odstate = odstate;
		this.shname = shname;
		this.shPrice = shPrice;
		this.odprice = odprice;
		this.odNumber = odNumber;
	}

	/** full constructor */
	public OrderViewId(Integer idorder, Integer idStore, Integer idbuyer, String storename, Short odstate,
			String shname, String shimage, Double shPrice, Double odprice, Integer odNumber) {
		this.idorder = idorder;
		this.idStore = idStore;
		this.idbuyer = idbuyer;
		this.storename = storename;
		this.odstate = odstate;
		this.shname = shname;
		this.shimage = shimage;
		this.shPrice = shPrice;
		this.odprice = odprice;
		this.odNumber = odNumber;
	}

	// Property accessors

	public Integer getIdorder() {
		return this.idorder;
	}

	public void setIdorder(Integer idorder) {
		this.idorder = idorder;
	}

	public Integer getIdStore() {
		return this.idStore;
	}

	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}

	public Integer getIdbuyer() {
		return this.idbuyer;
	}

	public void setIdbuyer(Integer idbuyer) {
		this.idbuyer = idbuyer;
	}

	public String getStorename() {
		return this.storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public Short getOdstate() {
		return this.odstate;
	}

	public void setOdstate(Short odstate) {
		this.odstate = odstate;
	}

	public String getShname() {
		return this.shname;
	}

	public void setShname(String shname) {
		this.shname = shname;
	}

	public String getShimage() {
		return this.shimage;
	}

	public void setShimage(String shimage) {
		this.shimage = shimage;
	}

	public Double getShPrice() {
		return this.shPrice;
	}

	public void setShPrice(Double shPrice) {
		this.shPrice = shPrice;
	}

	public Double getOdprice() {
		return this.odprice;
	}

	public void setOdprice(Double odprice) {
		this.odprice = odprice;
	}

	public Integer getOdNumber() {
		return this.odNumber;
	}

	public void setOdNumber(Integer odNumber) {
		this.odNumber = odNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderViewId))
			return false;
		OrderViewId castOther = (OrderViewId) other;

		return ((this.getIdorder() == castOther.getIdorder()) || (this.getIdorder() != null
				&& castOther.getIdorder() != null && this.getIdorder().equals(castOther.getIdorder())))
				&& ((this.getIdStore() == castOther.getIdStore()) || (this.getIdStore() != null
						&& castOther.getIdStore() != null && this.getIdStore().equals(castOther.getIdStore())))
				&& ((this.getIdbuyer() == castOther.getIdbuyer()) || (this.getIdbuyer() != null
						&& castOther.getIdbuyer() != null && this.getIdbuyer().equals(castOther.getIdbuyer())))
				&& ((this.getStorename() == castOther.getStorename()) || (this.getStorename() != null
						&& castOther.getStorename() != null && this.getStorename().equals(castOther.getStorename())))
				&& ((this.getOdstate() == castOther.getOdstate()) || (this.getOdstate() != null
						&& castOther.getOdstate() != null && this.getOdstate().equals(castOther.getOdstate())))
				&& ((this.getShname() == castOther.getShname()) || (this.getShname() != null
						&& castOther.getShname() != null && this.getShname().equals(castOther.getShname())))
				&& ((this.getShimage() == castOther.getShimage()) || (this.getShimage() != null
						&& castOther.getShimage() != null && this.getShimage().equals(castOther.getShimage())))
				&& ((this.getShPrice() == castOther.getShPrice()) || (this.getShPrice() != null
						&& castOther.getShPrice() != null && this.getShPrice().equals(castOther.getShPrice())))
				&& ((this.getOdprice() == castOther.getOdprice()) || (this.getOdprice() != null
						&& castOther.getOdprice() != null && this.getOdprice().equals(castOther.getOdprice())))
				&& ((this.getOdNumber() == castOther.getOdNumber()) || (this.getOdNumber() != null
						&& castOther.getOdNumber() != null && this.getOdNumber().equals(castOther.getOdNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdorder() == null ? 0 : this.getIdorder().hashCode());
		result = 37 * result + (getIdStore() == null ? 0 : this.getIdStore().hashCode());
		result = 37 * result + (getIdbuyer() == null ? 0 : this.getIdbuyer().hashCode());
		result = 37 * result + (getStorename() == null ? 0 : this.getStorename().hashCode());
		result = 37 * result + (getOdstate() == null ? 0 : this.getOdstate().hashCode());
		result = 37 * result + (getShname() == null ? 0 : this.getShname().hashCode());
		result = 37 * result + (getShimage() == null ? 0 : this.getShimage().hashCode());
		result = 37 * result + (getShPrice() == null ? 0 : this.getShPrice().hashCode());
		result = 37 * result + (getOdprice() == null ? 0 : this.getOdprice().hashCode());
		result = 37 * result + (getOdNumber() == null ? 0 : this.getOdNumber().hashCode());
		return result;
	}

}