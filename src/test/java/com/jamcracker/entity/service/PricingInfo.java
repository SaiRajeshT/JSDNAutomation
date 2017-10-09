package com.jamcracker.entity.service;

import java.util.Map;

public class PricingInfo {

	private String unitPrice;
	private String minimumQty;
	private String unitPriceQuantity;
	private String staticQuantity;
	private String billingCycle;
	private String isSetupFee;
	private String setupFeePlan;

	private String setUpFeePlan;
	private String Prorate;
	private String offerCode;
	private Map<Integer, Price> price;
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getMinimumQty() {
		return minimumQty;
	}
	public void setMinimumQty(String minimumQty) {
		this.minimumQty = minimumQty;
	}
	public String getUnitPriceQuantity() {
		return unitPriceQuantity;
	}
	public void setUnitPriceQuantity(String unitPriceQuantity) {
		this.unitPriceQuantity = unitPriceQuantity;
	}
	public String getStaticQuantity() {
		return staticQuantity;
	}
	public void setStaticQuantity(String staticQuantity) {
		this.staticQuantity = staticQuantity;
	}
	public String getBillingCycle() {
		return billingCycle;
	}
	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}
	public String getIsSetupFee() {
		return isSetupFee;
	}
	public void setIsSetupFee(String isSetupFee) {
		this.isSetupFee = isSetupFee;
	}
	public String getSetUpFeePlan() {
		return setUpFeePlan;
	}
	public void setSetUpFeePlan(String setUpFeePlan) {
		this.setUpFeePlan = setUpFeePlan;
	}
	public String getProrate() {
		return Prorate;
	}
	public void setProrate(String prorate) {
		Prorate = prorate;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	public Map<Integer, Price> getPrice() {
		return price;
	}
	public void setPrice(Map<Integer, Price> price) {
		this.price = price;
	}
	public String getSetupFeePlan() {
		return setupFeePlan;
	}
	public void setSetupFeePlan(String setupFeePlan) {
		this.setupFeePlan = setupFeePlan;
	}

	

}
