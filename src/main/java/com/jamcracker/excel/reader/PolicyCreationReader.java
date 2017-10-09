package com.jamcracker.excel.reader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jamcracker.entity.service.PolicyCreationData;

public class PolicyCreationReader {
	
	public String path;
	public FileInputStream fis;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;

	public PolicyCreationReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PolicyCreationData[] getRestrictPolicyCreationData(String sheetName) {
		
		List<PolicyCreationData> policyData = new ArrayList<PolicyCreationData>();
		try {
			sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			for (int i = 1; i < totalRow; i++) {
				row = sheet.getRow(i);
				PolicyCreationData pData = new PolicyCreationData();
				pData.setEmail(row.getCell(0).getStringCellValue());
				pData.setPassword(row.getCell(1).getStringCellValue());
				pData.setPolicyName(row.getCell(2).getStringCellValue());
				pData.setPolicyDesc(row.getCell(3).getStringCellValue());
				pData.setPolicyCategory(row.getCell(4).getStringCellValue());
				pData.setUsingEvent(row.getCell(5).getStringCellValue());
				pData.setAction(row.getCell(6).getStringCellValue());
				pData.setDepartment(row.getCell(7).getStringCellValue());
				pData.setProvider(row.getCell(8).getStringCellValue());
				pData.setRegions(row.getCell(9).getStringCellValue().split(","));
				pData.setImages(row.getCell(10).getStringCellValue().split(","));
				pData.setSizes(row.getCell(11).getStringCellValue().split(","));
				pData.setNetworks(row.getCell(12).getStringCellValue().split(","));
				policyData.add(pData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return policyData.toArray(new PolicyCreationData[policyData.size()]);
		
	}
	
	public PolicyCreationData[] getInstancePolicyCreationData(String sheetName) {
		
		List<PolicyCreationData> policyData = new ArrayList<PolicyCreationData>();
		try {
			sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			for (int i = 1; i < totalRow; i++) {
				row = sheet.getRow(i);
				PolicyCreationData pData = new PolicyCreationData();
				pData.setEmail(row.getCell(0).getStringCellValue());
				pData.setPassword(row.getCell(1).getStringCellValue());
				pData.setPolicyName(row.getCell(2).getStringCellValue());
				pData.setPolicyDesc(row.getCell(3).getStringCellValue());
				pData.setPolicyCategory(row.getCell(4).getStringCellValue());
				String a = row.getCell(5).getStringCellValue();
				LinkedHashMap<String,String> tags = new LinkedHashMap<String,String>();
				if(null != a){
					String[] pairs = a.split(",");
					for (int j = 0; j < pairs.length; j++) {
						String[] pair = pairs[j].split("=");
						tags.put(pair[0].trim(), pair[1].trim());
					}
				}
				pData.setTags(tags);
				policyData.add(pData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return policyData.toArray(new PolicyCreationData[policyData.size()]);
		
	}

}
