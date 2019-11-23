package com.xiaoxiang.org.vo;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private Integer idComments;
	private Orderdetail orderdetail;
	private Short commentLevel;
	private Short commentsAnonymous;
	private String commentsdetails;
	private Integer commentsReplyid;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(Orderdetail orderdetail, Short commentLevel, Short commentsAnonymous, String commentsdetails) {
		this.orderdetail = orderdetail;
		this.commentLevel = commentLevel;
		this.commentsAnonymous = commentsAnonymous;
		this.commentsdetails = commentsdetails;
	}

	/** full constructor */
	public Comments(Orderdetail orderdetail, Short commentLevel, Short commentsAnonymous, String commentsdetails,
			Integer commentsReplyid) {
		this.orderdetail = orderdetail;
		this.commentLevel = commentLevel;
		this.commentsAnonymous = commentsAnonymous;
		this.commentsdetails = commentsdetails;
		this.commentsReplyid = commentsReplyid;
	}

	// Property accessors

	public Integer getIdComments() {
		return this.idComments;
	}

	public void setIdComments(Integer idComments) {
		this.idComments = idComments;
	}

	public Orderdetail getOrderdetail() {
		return this.orderdetail;
	}

	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	public Short getCommentLevel() {
		return this.commentLevel;
	}

	public void setCommentLevel(Short commentLevel) {
		this.commentLevel = commentLevel;
	}

	public Short getCommentsAnonymous() {
		return this.commentsAnonymous;
	}

	public void setCommentsAnonymous(Short commentsAnonymous) {
		this.commentsAnonymous = commentsAnonymous;
	}

	public String getCommentsdetails() {
		return this.commentsdetails;
	}

	public void setCommentsdetails(String commentsdetails) {
		this.commentsdetails = commentsdetails;
	}

	public Integer getCommentsReplyid() {
		return this.commentsReplyid;
	}

	public void setCommentsReplyid(Integer commentsReplyid) {
		this.commentsReplyid = commentsReplyid;
	}

}