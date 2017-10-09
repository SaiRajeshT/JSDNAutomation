package com.jamcracker.entity.service;

public class Price {

	private String vendorSalePrice;
	private String wholeSalePrice;
	private String minRetailPrice;
	private String vendorSetupFee;
	private String wholesaleSetupFee;
	private String currencyCode;

	public String getVendorSalePrice() {
		return vendorSalePrice;
	}

	public void setVendorSalePrice(String vendorSalePrice) {
		this.vendorSalePrice = vendorSalePrice;
	}

	public String getWholeSalePrice() {
		return wholeSalePrice;
	}

	public void setWholeSalePrice(String wholeSalePrice) {
		this.wholeSalePrice = wholeSalePrice;
	}

	public String getMinRetailPrice() {
		return minRetailPrice;
	}

	public void setMinRetailPrice(String minRetailPrice) {
		this.minRetailPrice = minRetailPrice;
	}

	public String getWholesaleSetupFee() {
		return wholesaleSetupFee;
	}

	public void setWholesaleSetupFee(String wholesaleSetupFee) {
		this.wholesaleSetupFee = wholesaleSetupFee;
	}

	public String getVendorSetupFee() {
		return vendorSetupFee;
	}

	public void setVendorSetupFee(String vendorSetupFee) {
		this.vendorSetupFee = vendorSetupFee;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
