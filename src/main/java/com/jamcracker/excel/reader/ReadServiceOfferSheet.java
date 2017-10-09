package com.jamcracker.excel.reader;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jamcracker.entity.service.Offers;
import com.jamcracker.entity.service.Price;
import com.jamcracker.entity.service.PricingInfo;
import com.jamcracker.entity.service.ServiceSourceData;
import com.jamcracker.entity.service.ServicesInfo;
import com.jamcracker.utilities.SQLUtil;

 

public class ReadServiceOfferSheet {

	public String path;
	public FileInputStream fis;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;

	public ReadServiceOfferSheet(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String,Integer> getCurrency() {

		Map<String,Integer> curr = new HashMap<String,Integer>();

		try {
			Connection con = SQLUtil.getConnection();

			PreparedStatement pre = con.prepareStatement("SELECT CURRENCY,CURRENCY_ID FROM JCP_CURRENCY");

			ResultSet res = pre.executeQuery();
			while (res.next()) {
				curr.put(res.getString(1),res.getInt(2));
			}
			SQLUtil.closeResultSet(res);
			SQLUtil.closePreparedStatement(pre);
			SQLUtil.closeConnection(con);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return curr;

	}
	
	public String getCurrencyCode(String colName){
		return colName.split(" ")[0].trim();
	}
	
	public Map<String,PricingInfo> getPricingInfoFromSheet(String pricingSheet){
		Map<String,PricingInfo> pricingInfos = new HashMap<String,PricingInfo>();
		Map<String,Integer> currency = getCurrency();
		sheet = workbook.getSheet(pricingSheet);
		
		row = sheet.getRow(0);
		Map<Integer,String> colIndex = new HashMap<Integer,String>();
		int celLen = row.getLastCellNum();
		System.out.println("row.getLastCellNum" + celLen);
		for (int i = 0; i < celLen; i++) {
			colIndex.put(i, row.getCell(i).getStringCellValue());
		}
		
		
		
		int totalRow = sheet.getLastRowNum() + 1;
		System.out.println("Row numbers" + sheet.getLastRowNum());
		for (int i = 1; i < totalRow; i++) {
			row = sheet.getRow(i);
			PricingInfo priceInfo = new PricingInfo();
			
			 Map<Integer, Price> currPrice = new HashMap<Integer, Price>();
			 
			 
			 
			 priceInfo.setOfferCode(row.getCell(0).getStringCellValue());
			 priceInfo.setUnitPrice(row.getCell(1).getStringCellValue());
			 priceInfo.setMinimumQty(row.getCell(2).getStringCellValue());
			 priceInfo.setUnitPriceQuantity(row.getCell(3).getStringCellValue());
			 priceInfo.setStaticQuantity(row.getCell(4).getStringCellValue());
			 priceInfo.setBillingCycle(row.getCell(5).getStringCellValue());
			 priceInfo.setIsSetupFee(row.getCell(6).getStringCellValue());
			 priceInfo.setSetUpFeePlan(row.getCell(7).getStringCellValue());
			 priceInfo.setProrate(row.getCell(8).getStringCellValue());
			 
			 
			 for (int j = 9; j <= 45; j+=5) {
				 if(row.getCell(j) != null){
					 Price price  = new Price();
					 price.setVendorSalePrice(row.getCell(j).getStringCellValue());
					 price.setVendorSetupFee(row.getCell(j+1).getStringCellValue());
					 price.setWholeSalePrice(row.getCell(j+2).getStringCellValue());
					 price.setWholesaleSetupFee(row.getCell(j+3).getStringCellValue());
					 price.setMinRetailPrice(row.getCell(j+4).getStringCellValue());
					 price.setCurrencyCode(getCurrencyCode(colIndex.get(j)));//Taking the column name and by using that getting the currency code and setting the currency code
					 
					 currPrice.put(currency.get(price.getCurrencyCode()), price);
				 }
				 
			}
			 
			 priceInfo.setPrice(currPrice);
			 pricingInfos.put(row.getCell(0).getStringCellValue(), priceInfo);
		}
		
		
		return pricingInfos;
	}

	public Map<String, List<Offers>> getOfferDataFromSheet(String offerSheet) {

		Map<String, List<Offers>> offers = new HashMap<String, List<Offers>>();

		try {
			 Map<String,PricingInfo> pricingInfos = getPricingInfoFromSheet("Pricing Info");
			
			sheet = workbook.getSheet(offerSheet);
			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				row = sheet.getRow(i);
				String serviceName = row.getCell(8).getStringCellValue();

				if (null == offers.get(serviceName)) {
					offers.put(serviceName, new ArrayList<Offers>());
				}

				Offers offer = new Offers();

				offer.setOfferName(row.getCell(0).getStringCellValue());
				offer.setOfferCode(row.getCell(1).getStringCellValue());
				offer.setOfferDescription(row.getCell(2).getStringCellValue());
				offer.setAddOffertoCatalog(row.getCell(3).getStringCellValue());
				offer.setPayasyouGo(row.getCell(4).getStringCellValue());
				offer.setPayperUser(row.getCell(5).getStringCellValue());
				offer.setSubcriptionType(row.getCell(6).getStringCellValue());
				offer.setDatacollectionforservice(row.getCell(7).getStringCellValue());
				offer.setServiceName(serviceName);
				
				offer.setPricingInfo(pricingInfos.get(offer.getOfferCode()));

				offers.get(serviceName).add(offer);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return offers;

	}

	public ServicesInfo[] getDataFromSheet(String excelName, String serviceSheet, String offerSheet) {

		List<ServicesInfo> serviceInfos = new ArrayList<ServicesInfo>();

		try {
			Map<String, List<Offers>> offersMap = getOfferDataFromSheet(offerSheet);
			sheet = workbook.getSheet(serviceSheet);
			// HSSFSheet offerSh = workbook.getSheet(offerSheet);
			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				row = sheet.getRow(i);
				ServicesInfo serviceInfo = new ServicesInfo();

				serviceInfo.setServiceName(row.getCell(0).getStringCellValue());
				serviceInfo.setServicePublisher(row.getCell(1).getStringCellValue());
				serviceInfo.setServiceDescription(row.getCell(2).getStringCellValue());
				serviceInfo.setMoreInformation(row.getCell(3).getStringCellValue());
				serviceInfo.setRequirements(row.getCell(4).getStringCellValue());
				serviceInfo.setFaqs(row.getCell(5).getStringCellValue());
				serviceInfo.setCloudServiceType(row.getCell(6).getStringCellValue());
				serviceInfo.setServiceSubCategory(row.getCell(7).getStringCellValue());
				serviceInfo.setSlm(row.getCell(8).getStringCellValue());
				serviceInfo.setFirstAdminEnable(row.getCell(9).getStringCellValue());
				serviceInfo.setOffers(offersMap.get(serviceInfo.getServiceName()));

				serviceInfos.add(serviceInfo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceInfos.toArray(new ServicesInfo[serviceInfos.size()]);
	}
	
	public ServiceSourceData[] getServiceSourceData(String excelName, String sheetName) {
		
		List<ServiceSourceData> serviceSource = new ArrayList<ServiceSourceData>();
		
		Map<String,Integer> currency = getCurrency();
		sheet = workbook.getSheet(sheetName);
		
		row = sheet.getRow(0);
		Map<Integer,String> colIndex = new HashMap<Integer,String>();
		int celLen = row.getLastCellNum();
		System.out.println("row.getLastCellNum" + celLen);
		for (int i = 0; i < celLen; i++) {
			colIndex.put(i, row.getCell(i).getStringCellValue());
		}
		
		int totalRow = sheet.getLastRowNum() + 1;
		System.out.println("Row numbers" + sheet.getLastRowNum());
		
		for (int i = 1; i < totalRow; i++) {
			
			row = sheet.getRow(i);
			
			ServiceSourceData sourceData = new ServiceSourceData();
			Map<Integer, Price> currPrice = new HashMap<Integer, Price>();
			
			sourceData.setServiceName(row.getCell(0).getStringCellValue());
			sourceData.setOfferName(row.getCell(1).getStringCellValue());
			sourceData.setServiceType(row.getCell(2).getStringCellValue());
			
			for (int j = 5; j < 41; j+=5) {
				
				if(row.getCell(j) != null){
					
					 Price price  = new Price();
					 
					 price.setVendorSalePrice(row.getCell(j).getStringCellValue());
					 price.setVendorSetupFee(row.getCell(j+1).getStringCellValue());
					 price.setWholeSalePrice(row.getCell(j+2).getStringCellValue());
					 price.setWholesaleSetupFee(row.getCell(j+3).getStringCellValue());
					 price.setMinRetailPrice(row.getCell(j+4).getStringCellValue());
					 price.setCurrencyCode(getCurrencyCode(colIndex.get(j)));
					 currPrice.put(currency.get(price.getCurrencyCode()), price);
					 
				 }
				
			}
			
			sourceData.setPrice(currPrice);
			serviceSource.add(sourceData);
			
		}
		
		return serviceSource.toArray(new ServiceSourceData[serviceSource.size()]);
		
	}

}
