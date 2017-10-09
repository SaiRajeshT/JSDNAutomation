package com.jamcracker.entity.service;

import java.util.List;

public class SecurityGroup {
	
	private String securityGroupName;
	private String instanceName;
	private String protocol;
	private String portStart;
	private String portEnd;
	private String ipAddress;
	private String subnetMask;

	private List<SecurityGroupRules> rules;


	
	public String getSecurityGroupName() {
		return securityGroupName;
	}
	public void setSecurityGroupName(String securityGroupName) {
		this.securityGroupName = securityGroupName;
	}
	
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}




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
	public List<SecurityGroupRules> getRules() {
		return rules;
	}
	public void setRules(List<SecurityGroupRules> rules) {
		this.rules = rules;
	}
	


	


}
