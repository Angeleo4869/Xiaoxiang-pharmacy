package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Store entity. @author MyEclipse Persistence Tools
 */

public class Store implements java.io.Serializable {

	// Fields

	private Integer idStore;
	private String storeNumber;
	private String storePassword;
	private String storeName;
	private Short storeState;
	private String storePhyName;
	private String storePhyIdCard;
	private String storeLicense;
	private String storeTel;
	private String storeAddress;
	private Set complaintses = new HashSet(0);
	private Set shopGoodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Store() {
	}

	/** minimal constructor */
	public Store(String storeNumber, String storePassword, String storeName, Short storeState, String storePhyName,
			String storePhyIdCard, String storeLicense, String storeTel, String storeAddress) {
		this.storeNumber = storeNumber;
		this.storePassword = storePassword;
		this.storeName = storeName;
		this.storeState = storeState;
		this.storePhyName = storePhyName;
		this.storePhyIdCard = storePhyIdCard;
		this.storeLicense = storeLicense;
		this.storeTel = storeTel;
		this.storeAddress = storeAddress;
	}

	/** full constructor */
	public Store(String storeNumber, String storePassword, String storeName, Short storeState, String storePhyName,
			String storePhyIdCard, String storeLicense, String storeTel, String storeAddress, Set complaintses,
			Set shopGoodses) {
		this.storeNumber = storeNumber;
		this.storePassword = storePassword;
		this.storeName = storeName;
		this.storeState = storeState;
		this.storePhyName = storePhyName;
		this.storePhyIdCard = storePhyIdCard;
		this.storeLicense = storeLicense;
		this.storeTel = storeTel;
		this.storeAddress = storeAddress;
		this.complaintses = complaintses;
		this.shopGoodses = shopGoodses;
	}

	// Property accessors

	public Integer getIdStore() {
		return this.idStore;
	}

	public void setIdStore(Integer idStore) {
		this.idStore = idStore;
	}

	public String getStoreNumber() {
		return this.storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getStorePassword() {
		return this.storePassword;
	}

	public void setStorePassword(String storePassword) {
		this.storePassword = storePassword;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Short getStoreState() {
		return this.storeState;
	}

	public void setStoreState(Short storeState) {
		this.storeState = storeState;
	}

	public String getStorePhyName() {
		return this.storePhyName;
	}

	public void setStorePhyName(String storePhyName) {
		this.storePhyName = storePhyName;
	}

	public String getStorePhyIdCard() {
		return this.storePhyIdCard;
	}

	public void setStorePhyIdCard(String storePhyIdCard) {
		this.storePhyIdCard = storePhyIdCard;
	}

	public String getStoreLicense() {
		return this.storeLicense;
	}

	public void setStoreLicense(String storeLicense) {
		this.storeLicense = storeLicense;
	}

	public String getStoreTel() {
		return this.storeTel;
	}

	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Set getComplaintses() {
		return this.complaintses;
	}

	public void setComplaintses(Set complaintses) {
		this.complaintses = complaintses;
	}

	public Set getShopGoodses() {
		return this.shopGoodses;
	}

	public void setShopGoodses(Set shopGoodses) {
		this.shopGoodses = shopGoodses;
	}

}