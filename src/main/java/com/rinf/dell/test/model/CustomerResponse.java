package com.rinf.dell.test.model;

public class CustomerResponse {

	private Long id;
	private String name;
	private String mail;
	private String comment;
	private String responseMessage;

	public CustomerResponse(){}

	public CustomerResponse(String status){
		this.responseMessage = status;
	}

	public CustomerResponse(Customer customer, String responseStatus) {
		this.id = customer.getId();
		this.name = customer.getName();
		this.mail = customer.getMail();
		this.comment = customer.getComment();
		this.responseMessage = responseStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
