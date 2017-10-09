package com.jamcracker.entity.service;

public class SecurityGroupRules {
	
	private String securityGroupName;
	private String protocol;
	private String portStart;
	private String portEnd;
	private String ipAddress;
	private String subnetMask;



	
    public String getPortStart() {
		return portStart;
	}
	public void setPortStart(String portStart) {
		this.portStart = portStart;
	}
	public String getPortEnd() {
		return portEnd;
	}
	public void setPortEnd(String portEnd) {
		this.portEnd = portEnd;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getSubnetMask() {
		return subnetMask;
	}
	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}
	public String getSecurityGroupName() {
		return securityGroupName;
	}
	public void setSecurityGroupName(String securityGroupName) {
		this.securityGroupName = securityGroupName;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	
}
