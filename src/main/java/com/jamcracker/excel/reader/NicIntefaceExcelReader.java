package com.jamcracker.excel.reader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

import com.jamcracker.entity.service.NicDetails;
import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.entity.service.SecurityGroupRules;

public class NicIntefaceExcelReader {

	public String path;
	public FileInputStream fis;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public HSSFCell cell;

	public NicIntefaceExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NicDetails[] getExcelData(String nicSheet)

	{
		Map<String , List<SecurityGroup>> mapSecurityGroup =  readSecurityGroup("NicSecurityGroup"); // To read the security group and store the information in MAP
		List<NicDetails> nicInfo = new ArrayList<NicDetails>();
		try {
			sheet = workbook.getSheet(nicSheet);
			int totalRow = sheet.getLastRowNum();
			for (int i = 1; i <= totalRow; i++) {
				row = sheet.getRow(i);

				NicDetails nicDetailsObj = new NicDetails();
				nicDetailsObj.setExecutable(row.getCell(0).getStringCellValue());
				if (nicDetailsObj.getExecutable().equalsIgnoreCase("y")) {
					nicDetailsObj.setEmail(row.getCell(1).getStringCellValue().trim());
					nicDetailsObj.setPassword(row.getCell(2).getStringCellValue().trim());
					nicDetailsObj.setAction(row.getCell(3).getStringCellValue().trim());
					nicDetailsObj.setInstName(row.getCell(4).getStringCellValue().trim());
					nicDetailsObj.setNicName(row.getCell(5).getStringCellValue().trim());
					nicDetailsObj.setUpdateNicName(row.getCell(6).getStringCellValue().trim());
					nicDetailsObj.setSubNet(row.getCell(7).getStringCellValue().trim());
					if (row.getCell(8) != null) {
						nicDetailsObj.setPrivateIp(row.getCell(8).getStringCellValue().trim());
					}
					if (row.getCell(9) != null) {
						nicDetailsObj.setPublicIp(row.getCell(9).getStringCellValue().trim());
					}
				
					nicDetailsObj.setSecurityGroups(mapSecurityGroup.get(nicDetailsObj.getNicName()));	
					
					nicInfo.add(nicDetailsObj);
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
		}
		return nicInfo.toArray(new NicDetails[nicInfo.size()]);

	}
	
	public Map<String , List<SecurityGroup>> readSecurityGroup(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		int totalrows = sheet.getLastRowNum();
		Map<String,List<SecurityGroup>> mapSec = new LinkedHashMap<String,List<SecurityGroup>>();
		for(int i=1; i<=totalrows ; i++)
		{
			row = sheet.getRow(i);
			String nicName = row.getCell(0).getStringCellValue().trim();
			if(mapSec.get(nicName) == null){
				mapSec.put(nicName, new ArrayList<SecurityGroup>());
			}
			
			
			SecurityGroup securityGroup = new SecurityGroup();
			securityGroup.setNicName(nicName);
			securityGroup.setSecurityGroupName(row.getCell(1).getStringCellValue());
			if(row.getCell(2)!= null){
			List<SecurityGroupRules> rules = new ArrayList<SecurityGroupRules>();
			
			String securityGrprules = row.getCell(2).getStringCellValue();
			String[] arrRules = securityGrprules.split("/");
			for(String rule : arrRules)
			{
				String[] ruledetails	= rule.split(",");
				SecurityGroupRules secRules = new SecurityGroupRules();
				secRules.setProtocol(ruledetails[0].toLowerCase());
				secRules.setPortStart(ruledetails[1]);
				secRules.setPortEnd(ruledetails[2]);
				secRules.setIpAddress(ruledetails[3]);
				secRules.setSubnetMask(ruledetails[4]);	
				rules.add(secRules);
			}
			securityGroup.setRules(rules);}
			
			//mapSec.get(instanceName) -- It will return Array list object 
			mapSec.get(nicName).add(securityGroup);
			
		}
		return mapSec;
	}
	
}
