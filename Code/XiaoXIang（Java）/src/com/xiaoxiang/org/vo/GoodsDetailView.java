package com.xiaoxiang.org.vo;

/**
 * GoodsDetailView entity. @author MyEclipse Persistence Tools
 */

public class GoodsDetailView implements java.io.Serializable {

	// Fields

	private GoodsDetailViewId id;

	// Constructors

	/** default constructor */
	public GoodsDetailView() {
	}

	/** full constructor */
	public GoodsDetailView(GoodsDetailViewId id) {
		this.id = id;
	}

	// Property accessors

	public GoodsDetailViewId getId() {
		return this.id;
	}

	public void setId(GoodsDetailViewId id) {
		this.id = id;
	}

}