package com.jamcracker.entity.service;

import java.util.Map;

public class PolicyCreationData {
	
	private String email;
	private String password;
	private String policyName;
	private String policyDesc;
	private String policyCategory;
	private String usingEvent;
	private String action;
	private String department;
	private String provider;
	private String[] regions;
	private String[] images;
	private String[] sizes;
	private String[] networks;
	private Map<String, String> tags; 
	
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
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyDesc() {
		return policyDesc;
	}
	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}
	public String getPolicyCategory() {
		return policyCategory;
	}
	public void setPolicyCategory(String policyCategory) {
		this.policyCategory = policyCategory;
	}
	public String getUsingEvent() {
		return usingEvent;
	}
	public void setUsingEvent(String usingEvent) {
		this.usingEvent = usingEvent;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String[] getRegions() {
		return regions;
	}
	public void setRegions(String[] regions) {
		this.regions = regions;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	public String[] getSizes() {
		return sizes;
	}
	public void setSizes(String[] sizes) {
		this.sizes = sizes;
	}
	public String[] getNetworks() {
		return networks;
	}
	public void setNetworks(String[] networks) {
		this.networks = networks;
	}
	public Map<String, String> getTags() {
		return tags;
	}
	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

}
