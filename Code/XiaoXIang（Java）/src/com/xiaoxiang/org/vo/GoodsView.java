package com.xiaoxiang.org.vo;

/**
 * GoodsView entity. @author MyEclipse Persistence Tools
 */

public class GoodsView implements java.io.Serializable {

	// Fields

	private GoodsViewId id;

	// Constructors

	/** default constructor */
	public GoodsView() {
	}

	/** full constructor */
	public GoodsView(GoodsViewId id) {
		this.id = id;
	}

	// Property accessors

	public GoodsViewId getId() {
		return this.id;
	}

	public void setId(GoodsViewId id) {
		this.id = id;
	}

}