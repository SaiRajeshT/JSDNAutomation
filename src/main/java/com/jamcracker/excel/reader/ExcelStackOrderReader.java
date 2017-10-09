package com.jamcracker.excel.reader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.entity.service.SecurityGroupRules;
import com.jamcracker.entity.service.StackOrder;

public class ExcelStackOrderReader {
	
	public String path;
	public FileInputStream fis;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;

	public ExcelStackOrderReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public StackOrder[] getExcelData(String orderSheet)
	
	{
		Map<String , List<SecurityGroup>> mapSecurityGroup =  readSecurityGroup("Security Groups");
		List<StackOrder> stackOrdersInfo = new ArrayList<StackOrder>();
		try {
			  sheet = workbook.getSheet(orderSheet);
			int totalRow = sheet.getLastRowNum();
			for (int i = 1; i <= totalRow; i++) {
				row = sheet.getRow(i);
				StackOrder stackOrder = new StackOrder();
				stackOrder.setExecutable(row.getCell(0).getStringCellValue());
				if (stackOrder.getExecutable().equalsIgnoreCase("y")){
				stackOrder.setEmail(row.getCell(1).getStringCellValue().trim());
				stackOrder.setPassword(row.getCell(2).getStringCellValue().trim());
				stackOrder.setServiceName(row.getCell(3).getStringCellValue().trim());
				stackOrder.setStackName(row.getCell(4).getStringCellValue().trim());
				stackOrder.setStackDesc(row.getCell(5).getStringCellValue().trim());
				stackOrder.setSalesReferenceCode(row.getCell(6).getStringCellValue().trim());
				
				String a = row.getCell(7).getStringCellValue();
									  										
				LinkedHashMap<String,String> tags = new LinkedHashMap<String,String>();
				if(null != a){
					String[] pairs = a.split(",");
					for (int j = 0; j < pairs.length; j++) {
						String[] pair = pairs[j].split("=");
						tags.put(pair[0].trim(), pair[1].trim());
					}
				}
				stackOrder.setTags(tags);
				
				
				stackOrder.setInstanceName(row.getCell(8).getStringCellValue().trim());
				stackOrder.setVendors(row.getCell(9).getStringCellValue().trim());
				stackOrder.setRegion(row.getCell(10).getStringCellValue().trim());
				stackOrder.setAvailabiltyZone(row.getCell(11).getStringCellValue().trim());
				stackOrder.setImageName(row.getCell(12).getStringCellValue().trim());
				stackOrder.setFamily(row.getCell(13).getStringCellValue().trim());
				stackOrder.setType(row.getCell(14).getStringCellValue().trim());
				stackOrder.setFlavor(row.getCell(15).getStringCellValue().trim());
				stackOrder.setInstUserName(row.getCell(16).getStringCellValue().trim());
				stackOrder.setInstPassword(row.getCell(17).getStringCellValue().trim());
				stackOrder.setResourceGroup(row.getCell(18).getStringCellValue().trim());
				stackOrder.setStorageType(row.getCell(19).getStringCellValue().trim());
				stackOrder.setStorageAccount(row.getCell(20).getStringCellValue().trim());
				stackOrder.setAvailabitySet(row.getCell(21).getStringCellValue().trim());
				
				stackOrder.setEnableMonitoring(row.getCell(22).getStringCellValue().trim());
				stackOrder.setNetwork(row.getCell(23).getStringCellValue().trim());
				stackOrder.setNetworkInterfaceName(row.getCell(24).getStringCellValue().trim());
				stackOrder.setSubNetName(row.getCell(25).getStringCellValue().trim());
				if(row.getCell(26)!= null){
				stackOrder.setPrivateIp(row.getCell(25).getStringCellValue().trim());}
				if(row.getCell(27)!=null){
				stackOrder.setPublicIp(row.getCell(27).getStringCellValue().trim());}
				stackOrder.setSecurityGroups(mapSecurityGroup.get(stackOrder.getInstanceName()));
				
				
				stackOrdersInfo.add(stackOrder);}}
			}
		
		catch (Exception e)
		{
			
		}
		return stackOrdersInfo.toArray(new StackOrder[stackOrdersInfo.size()]);
		
		}
	
	public Map<String , List<SecurityGroup>> readSecurityGroup(String sheetName)
	{
		sheet = workbook.getSheet(sheetName);
		int totalrows = sheet.getLastRowNum();
		Map<String,List<SecurityGroup>> mapSec = new LinkedHashMap<String,List<SecurityGroup>>();
		for(int i=1; i<=totalrows ; i++)
		{
			row = sheet.getRow(i);
			String instanceName = row.getCell(0).getStringCellValue();
			if(mapSec.get(instanceName) == null){
				mapSec.put(instanceName, new ArrayList<SecurityGroup>());
			}
			
			
			SecurityGroup securityGroup = new SecurityGroup();
			securityGroup.setInstanceName(instanceName);
			securityGroup.setSecurityGroupName(row.getCell(1).getStringCellValue());
			/*securityGroup.setProtocol(row.getCell(2).getStringCellValue());
			securityGroup.setPortStart(row.getCell(3).getStringCellValue());
			securityGroup.setPortEnd(row.getCell(4).getStringCellValue());
			securityGroup.setIpAddress(row.getCell(5).getStringCellValue());
			securityGroup.setSubnetMask(row.getCell(6).getStringCellValue());
			*/
			
			List<SecurityGroupRules> rules = new ArrayList<SecurityGroupRules>();
			
			String securityGrprules = row.getCell(2).getStringCellValue();
			String[] arrRules = securityGrprules.split("/");
			for(String rule : arrRules)
			{
				String[] ruledetails	= rule.split(",");
				SecurityGroupRules secRules = new SecurityGroupRules();
				secRules.setProtocol(ruledetails[0]);
				secRules.setPortStart(ruledetails[1]);
				secRules.setPortEnd(ruledetails[2]);
				secRules.setIpAddress(ruledetails[3]);
				secRules.setSubnetMask(ruledetails[1]);	
				rules.add(secRules);
			}
			 
			securityGroup.setRules(rules);
			
			
			//mapSec.get(instanceName) -- It will return Array list object 
			mapSec.get(instanceName).add(securityGroup);
			
		}
		return mapSec;
	}
	
	
/*	public Map<String,Map<List<SecurityGroup>,List<SecurityGroupRules>>> readSecurirtyGroup1(String sheetName)
	
	{
		sheet = workbook.getSheet(sheetName);
		int totalrows = sheet.getLastRowNum();
		
	}*/
	
	
	
	
	
	
	
	
	
}


