package com.jamcracker.entity.service;

public class Offers {

	private String offerName;
	private String serviceName;
	private String offerCode;
	private String offerDescription;
	private String addOffertoCatalog;
	private String payasyouGo;
	private String payperUser;
	private String subcriptionType;
	private String datacollectionforservice;
	private PricingInfo pricingInfo;

	public PricingInfo getPricingInfo() {
		return pricingInfo;
	}

	public void setPricingInfo(PricingInfo pricingInfo) {
		this.pricingInfo = pricingInfo;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public String getAddOffertoCatalog() {
		return addOffertoCatalog;
	}

	public void setAddOffertoCatalog(String addOffertoCatalog) {
		this.addOffertoCatalog = addOffertoCatalog;
	}

	public String getPayasyouGo() {
		return payasyouGo;
	}

	public void setPayasyouGo(String payasyouGo) {
		this.payasyouGo = payasyouGo;
	}

	public String getPayperUser() {
		return payperUser;
	}

	public void setPayperUser(String payperUser) {
		this.payperUser = payperUser;
	}

	public String getSubcriptionType() {
		return subcriptionType;
	}

	public void setSubcriptionType(String subcriptionType) {
		this.subcriptionType = subcriptionType;
	}

	public String getDatacollectionforservice() {
		return datacollectionforservice;
	}

	public void setDatacollectionforservice(String datacollectionforservice) {
		this.datacollectionforservice = datacollectionforservice;
	}

}
