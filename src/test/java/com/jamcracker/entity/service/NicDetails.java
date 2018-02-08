package com.jamcracker.entity.service;

import java.util.List;

public class NicDetails {

	private String executable;
	private String email;
	private String password;
	private String action;
	private String nicName;
	private String subNet;
	private String privateIp;
	private String publicIp;
	private String instName;

	private List<SecurityGroup> securityGroups;

	public String getExecutable() {
		return executable;
	}
	public void setExecutable(String executable) {
		this.executable = executable;
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getNicName() {
		return nicName;
	}
	public void setNicName(String nicName) {
		this.nicName = nicName;
	}
	public String getSubNet() {
		return subNet;
	}
	public void setSubNet(String subNet) {
		this.subNet = subNet;
	}
	public String getPrivateIp() {
		return privateIp;
	}
	public void setPrivateIp(String privateIp) {
		this.privateIp = privateIp;
	}
	public String getPublicIp() {
		return publicIp;
	}
	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}



	public List<SecurityGroup> getSecurityGroups() {
		return securityGroups;
	}
	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}
	public String getInstName() {
		return instName;
	}
	public void setInstName(String instName) {
		this.instName = instName;
	}

	

}
