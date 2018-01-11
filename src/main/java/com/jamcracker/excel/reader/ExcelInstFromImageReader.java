package com.jamcracker.excel.reader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

import com.jamcracker.entity.service.InstFromImageOrder;
import com.jamcracker.entity.service.SecurityGroup;
import com.jamcracker.entity.service.SecurityGroupRules;

public class ExcelInstFromImageReader {

	public String path;
	public FileInputStream fis;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public HSSFCell cell;

	public ExcelInstFromImageReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InstFromImageOrder[] getExcelData(String imageSheet)

	{
		// Map<String , List<SecurityGroup>> mapSecurityGroup =
		// readSecurityGroup("Security Groups");
		List<InstFromImageOrder> instanceOrdersInfo = new ArrayList<InstFromImageOrder>();
		try {
			sheet = workbook.getSheet(imageSheet);
			int totalRow = sheet.getLastRowNum();
			for (int i = 1; i <= totalRow; i++) {
				row = sheet.getRow(i);

				InstFromImageOrder instFromImageObj = new InstFromImageOrder();
				instFromImageObj.setExecutable(row.getCell(0).getStringCellValue());
				if (instFromImageObj.getExecutable().equalsIgnoreCase("y")) {
					instFromImageObj.setEmail(row.getCell(1).getStringCellValue().trim());
					instFromImageObj.setPassword(row.getCell(2).getStringCellValue().trim());
					instFromImageObj.setImageName(row.getCell(3).getStringCellValue().trim());
					instFromImageObj.setVendorName(row.getCell(4).getStringCellValue().trim());
					instFromImageObj.setStackName(row.getCell(5).getStringCellValue().trim());
					instFromImageObj.setStackDesc(row.getCell(6).getStringCellValue().trim());
					instFromImageObj.setSalesReferenceCode(row.getCell(7).getStringCellValue().trim());
					String a = row.getCell(8).getStringCellValue();
					LinkedHashMap<String, String> tags = new LinkedHashMap<String, String>();
					if (null != a) {
						String[] pairs = a.split(",");
						for (int j = 0; j < pairs.length; j++) {
							String[] pair = pairs[j].split("=");
							tags.put(pair[0].trim(), pair[1].trim());
						}
					}
					instFromImageObj.setTags(tags);
					instFromImageObj.setInstanceName(row.getCell(9).getStringCellValue().trim());
					instFromImageObj.setRegion(row.getCell(10).getStringCellValue().trim());
					instFromImageObj.setAvailabiltyZone(row.getCell(11).getStringCellValue().trim());
					instFromImageObj.setFamily(row.getCell(12).getStringCellValue().trim());
					instFromImageObj.setType(row.getCell(13).getStringCellValue().trim());
					instFromImageObj.setFlavor(row.getCell(14).getStringCellValue().trim());
					instFromImageObj.setInstUserName(row.getCell(15).getStringCellValue().trim());
					instFromImageObj.setInstPassword(row.getCell(16).getStringCellValue().trim());
					instFromImageObj.setResourceGroup(row.getCell(17).getStringCellValue().trim());
					instFromImageObj.setStorageType(row.getCell(18).getStringCellValue().trim());
					instFromImageObj.setStorageAccount(row.getCell(19).getStringCellValue().trim());
					instFromImageObj.setAvailabitySet(row.getCell(20).getStringCellValue().trim());

					instFromImageObj.setEnableMonitoring(row.getCell(21).getStringCellValue().trim());
					instFromImageObj.setNetwork(row.getCell(22).getStringCellValue().trim());
					instFromImageObj.setNetworkInterfaceName(row.getCell(23).getStringCellValue().trim());
					instFromImageObj.setSubNetName(row.getCell(24).getStringCellValue().trim());
					if (row.getCell(25) != null) {
						instFromImageObj.setPrivateIp(row.getCell(25).getStringCellValue().trim());
					}
					if (row.getCell(26) != null) {
						instFromImageObj.setPublicIp(row.getCell(26).getStringCellValue().trim());
					}

					/*instFromImageObj.setSecGroupName(row.getCell(27).getStringCellValue());

					List<SecurityGroupRules> rules = new ArrayList<SecurityGroupRules>();

					String securityGrprules = row.getCell(28).getStringCellValue();
					String[] arrRules = securityGrprules.split("/");
					for (String rule : arrRules) {
						String[] ruledetails = rule.split(",");
						SecurityGroupRules secRules = new SecurityGroupRules();
						secRules.setProtocol(ruledetails[0]);
						secRules.setPortStart(ruledetails[1]);
						secRules.setPortEnd(ruledetails[2]);
						secRules.setIpAddress(ruledetails[3]);
						secRules.setSubnetMask(ruledetails[4]);
						rules.add(secRules);
					}
					instFromImageObj.setsecurityGroupRules(rules);*/
					SecurityGroup securityGroup = new SecurityGroup();
					securityGroup.setSecurityGroupName(row.getCell(27).getStringCellValue().trim());
					
					List<SecurityGroupRules> rules = new ArrayList<SecurityGroupRules>();
					String securityGrprules = row.getCell(28).getStringCellValue().trim();
					String[] arrRules = securityGrprules.split("/");
					for(String rule : arrRules)
					{
						String[] ruledetails	= rule.split(",");
						SecurityGroupRules secRules = new SecurityGroupRules();
						secRules.setProtocol(ruledetails[0].toLowerCase());
						secRules.setPortStart(ruledetails[1]);
						secRules.setPortEnd(ruledetails[2]);
						secRules.setIpAddress(ruledetails[3]);
						secRules.setSubnetMask(ruledetails[1]);	
						rules.add(secRules);
					}
					securityGroup.setRules(rules);
					instFromImageObj.setSecurityGroups(securityGroup);
					instFromImageObj.setStaticIp(row.getCell(29).getStringCellValue().trim());
					
					instanceOrdersInfo.add(instFromImageObj);
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<p style='color:red'>EXCEPTION:--" + ExceptionUtils.getStackTrace(e)+"</p>");
		}
		return instanceOrdersInfo.toArray(new InstFromImageOrder[instanceOrdersInfo.size()]);

	}
}
