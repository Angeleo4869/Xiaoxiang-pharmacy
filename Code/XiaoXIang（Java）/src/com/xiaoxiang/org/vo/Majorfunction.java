package com.xiaoxiang.org.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Majorfunction entity. @author MyEclipse Persistence Tools
 */

public class Majorfunction implements java.io.Serializable {

	// Fields

	private Integer idMajorFunction;
	private String goodsMajorFunctioncol;
	private String goodsClass;
	private String goodsSeries;
	private Set goodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Majorfunction() {
	}

	/** minimal constructor */
	public Majorfunction(String goodsMajorFunctioncol) {
		this.goodsMajorFunctioncol = goodsMajorFunctioncol;
	}

	/** full constructor */
	public Majorfunction(String goodsMajorFunctioncol, String goodsClass, String goodsSeries, Set goodses) {
		this.goodsMajorFunctioncol = goodsMajorFunctioncol;
		this.goodsClass = goodsClass;
		this.goodsSeries = goodsSeries;
		this.goodses = goodses;
	}

	// Property accessors

	public Integer getIdMajorFunction() {
		return this.idMajorFunction;
	}

	public void setIdMajorFunction(Integer idMajorFunction) {
		this.idMajorFunction = idMajorFunction;
	}

	public String getGoodsMajorFunctioncol() {
		return this.goodsMajorFunctioncol;
	}

	public void setGoodsMajorFunctioncol(String goodsMajorFunctioncol) {
		this.goodsMajorFunctioncol = goodsMajorFunctioncol;
	}

	public String getGoodsClass() {
		return this.goodsClass;
	}

	public void setGoodsClass(String goodsClass) {
		this.goodsClass = goodsClass;
	}

	public String getGoodsSeries() {
		return this.goodsSeries;
	}

	public void setGoodsSeries(String goodsSeries) {
		this.goodsSeries = goodsSeries;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

}