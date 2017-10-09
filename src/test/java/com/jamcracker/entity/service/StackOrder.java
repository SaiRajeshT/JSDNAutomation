package com.jamcracker.entity.service;

import java.util.List;
import java.util.Map;

public class StackOrder {

	private String executable;
	private String email;
	private String password;
	private String serviceName;
	private String stackName;
	private String stackDesc;
	private String salesReferenceCode;
	private String instanceName;
	private String vendors;
	private String region;
	private String availabiltyZone;
	private String imageName;
	private String family;
	private String type;
	private String flavor;
	private String enableMonitoring;
	private String network;
	private String networkInterfaceName;
	private String instUserName;
	private String	instPassword;
	private String	resourceGroup;
	private String  storageType;
	private String	storageAccount;
	private String	availabitySet;
	

	private String subNetName;
	private String privateIp;
	private String publicIp;
	private String subnetMask;
	
	
	public String getInstUserName() {
		return instUserName;
	}

	public void setInstUserName(String instUserName) {
		this.instUserName = instUserName;
	}

	public String getInstPassword() {
		return instPassword;
	}

	public void setInstPassword(String instPassword) {
		this.instPassword = instPassword;
	}

	public String getResourceGroup() {
		return resourceGroup;
	}

	public void setResourceGroup(String resourceGroup) {
		this.resourceGroup = resourceGroup;
	}

	public String getStorageAccount() {
		return storageAccount;
	}

	public void setStorageAccount(String storageAccount) {
		this.storageAccount = storageAccount;
	}

	public String getAvailabitySet() {
		return availabitySet;
	}

	public void setAvailabitySet(String availabitySet) {
		this.availabitySet = availabitySet;
	}



	private Map<String, String> tags;

	private List<SecurityGroup> securityGroups;

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

	public String getStackName() {
		return stackName;
	}

	public void setStackName(String stackName) {
		this.stackName = stackName;
	}

	public String getStackDesc() {
		return stackDesc;
	}

	public void setStackDesc(String stackDesc) {
		this.stackDesc = stackDesc;
	}

	public String getSalesReferenceCode() {
		return salesReferenceCode;
	}

	public void setSalesReferenceCode(String salesReferenceCode) {
		this.salesReferenceCode = salesReferenceCode;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getVendors() {
		return vendors;
	}

	public void setVendors(String vendors) {
		this.vendors = vendors;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAvailabiltyZone() {
		return availabiltyZone;
	}

	public void setAvailabiltyZone(String availabiltyZone) {
		this.availabiltyZone = availabiltyZone;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getEnableMonitoring() {
		return enableMonitoring;
	}

	public void setEnableMonitoring(String enableMonitoring) {
		this.enableMonitoring = enableMonitoring;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getNetworkInterfaceName() {
		return networkInterfaceName;
	}

	public void setNetworkInterfaceName(String networkInterfaceName) {
		this.networkInterfaceName = networkInterfaceName;
	}

	public Map<String, String> getTags() {
		return tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

	public List<SecurityGroup> getSecurityGroups() {
		return securityGroups;
	}

	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public String getPrivateIp() {
		return privateIp;
	}

	public void setPrivateIp(String privateIp) {
		this.privateIp = privateIp;
	}

	public String getSubNetName() {
		return subNetName;
	}

	public void setSubNetName(String subNetName) {
		this.subNetName = subNetName;
	}

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getExecutable() {
		return executable;
	}

	public void setExecutable(String executable) {
		this.executable = executable;
	}

}
