package com.xiaoxiang.org.vo;

/**
 * Complaints entity. @author MyEclipse Persistence Tools
 */

public class Complaints implements java.io.Serializable {

	// Fields

	private Integer idComplaints;
	private Store store;
	private Buyer buyer;
	private String complaintsContent;
	private Short complaintsCategory;

	// Constructors

	/** default constructor */
	public Complaints() {
	}

	/** minimal constructor */
	public Complaints(Store store, Buyer buyer) {
		this.store = store;
		this.buyer = buyer;
	}

	/** full constructor */
	public Complaints(Store store, Buyer buyer, String complaintsContent, Short complaintsCategory) {
		this.store = store;
		this.buyer = buyer;
		this.complaintsContent = complaintsContent;
		this.complaintsCategory = complaintsCategory;
	}

	// Property accessors

	public Integer getIdComplaints() {
		return this.idComplaints;
	}

	public void setIdComplaints(Integer idComplaints) {
		this.idComplaints = idComplaints;
	}

	public Store getStore() {
		return this.store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Buyer getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public String getComplaintsContent() {
		return this.complaintsContent;
	}

	public void setComplaintsContent(String complaintsContent) {
		this.complaintsContent = complaintsContent;
	}

	public Short getComplaintsCategory() {
		return this.complaintsCategory;
	}

	public void setComplaintsCategory(Short complaintsCategory) {
		this.complaintsCategory = complaintsCategory;
	}

}