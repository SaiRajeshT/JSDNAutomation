package com.jamcracker.excel.reader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jamcracker.entity.service.CustomerCreationData;

public class CustomerCreationReader {
	
	public String path;
	public FileInputStream fis;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;

	public CustomerCreationReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CustomerCreationData[] getCustomerCreationData(String fileName, String sheetName) {
		
		List<CustomerCreationData> ccData = new ArrayList<CustomerCreationData>();
		try {
			sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			for (int i = 1; i < totalRow; i++) {
				row = sheet.getRow(i);
				CustomerCreationData custData = new CustomerCreationData();
				custData.setFirstName(row.getCell(0).getStringCellValue());
				custData.setLastName(row.getCell(1).getStringCellValue());
				custData.setEmail(row.getCell(2).getStringCellValue());
				custData.setContactPhone(row.getCell(3).getStringCellValue());
				custData.setCompanyName(row.getCell(4).getStringCellValue());
				custData.setMailingAddress1(row.getCell(5).getStringCellValue());
				custData.setMailingPhone(row.getCell(6).getStringCellValue());
				custData.setMailingCountry(row.getCell(7).getStringCellValue());
				custData.setMailingState(row.getCell(8).getStringCellValue());
				custData.setMailingOtherState(row.getCell(9).getStringCellValue());
				custData.setMailingCity(row.getCell(10).getStringCellValue());
				custData.setMailingZip(row.getCell(11).getStringCellValue());
				custData.setBillEqualMailAddress(row.getCell(12).getStringCellValue());
				custData.setBillingAddress1(row.getCell(13).getStringCellValue());
				custData.setBillingPhone(row.getCell(14).getStringCellValue());
				custData.setBillingCountry(row.getCell(15).getStringCellValue());
				custData.setBillingState(row.getCell(16).getStringCellValue());
				custData.setBillingOtherState(row.getCell(17).getStringCellValue());
				custData.setBillingCity(row.getCell(18).getStringCellValue());
				custData.setBillingZip(row.getCell(19).getStringCellValue());
				custData.setTimeZone(row.getCell(20).getStringCellValue());
				ccData.add(custData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ccData.toArray(new CustomerCreationData[ccData.size()]);
		
	}

}
