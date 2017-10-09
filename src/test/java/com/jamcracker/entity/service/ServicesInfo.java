package com.jamcracker.entity.service;

import java.util.List;

public class ServicesInfo {

	private String serviceName;
	private String servicePublisher;
	private String serviceDescription;
	private String moreInformation;
	private String Requirements;
	private String faqs;
	private String cloudServiceType;
	private String serviceSubCategory;
	private String slm;
	private String firstAdminEnable;
	
	
	private List<Offers> offers;
	
	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public String getRequirements() {
		return Requirements;
	}

	public void setRequirements(String requirements) {
		Requirements = requirements;
	}

	public String getFaqs() {
		return faqs;
	}

	public void setFaqs(String faqs) {
		this.faqs = faqs;
	}

	public String getCloudServiceType() {
		return cloudServiceType;
	}

	public void setCloudServiceType(String cloudServiceType) {
		this.cloudServiceType = cloudServiceType;
	}

	public String getServiceSubCategory() {
		return serviceSubCategory;
	}

	public void setServiceSubCategory(String serviceSubCategory) {
		this.serviceSubCategory = serviceSubCategory;
	}

	public String getSlm() {
		return slm;
	}

	public void setSlm(String slm) {
		this.slm = slm;
	}

	public String getFirstAdminEnable() {
		return firstAdminEnable;
	}

	public void setFirstAdminEnable(String firstAdminEnable) {
		this.firstAdminEnable = firstAdminEnable;
	}



	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<Offers> getOffers() {
		return offers;
	}

	public void setOffers(List<Offers> offers) {
		this.offers = offers;
	}

	public String getServicePublisher() {
		return servicePublisher;
	}

	public void setServicePublisher(String servicePublisher) {
		this.servicePublisher = servicePublisher;
	}

}
