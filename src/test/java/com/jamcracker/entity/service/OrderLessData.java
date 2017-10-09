package com.jamcracker.entity.service;

import java.util.Map;

public class OrderLessData {

	private String email;
	private String password;
	private String serviceName;
	private String offerName;
	private String offerCode;
	private String totalQty;
	
	//orderNumber-quantity
	private Map<String,String> orderQnt;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}

	public Map<String,String> getOrderQnt() {
		return orderQnt;
	}

	public void setOrderQnt(Map<String,String> orderQnt) {
		this.orderQnt = orderQnt;
	}

	public String getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}

}
