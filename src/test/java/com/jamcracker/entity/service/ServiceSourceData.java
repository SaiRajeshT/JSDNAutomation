package com.jamcracker.entity.service;

import java.util.Map;

public class ServiceSourceData {
	
	private String email;
	private String password;
	private String serviceName;
	private String offerName;
	private String serviceType;
	private Map<Integer, Price> price;
	
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Map<Integer, Price> getPrice() {
		return price;
	}
	public void setPrice(Map<Integer, Price> price) {
		this.price = price;
	}
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
	
}
