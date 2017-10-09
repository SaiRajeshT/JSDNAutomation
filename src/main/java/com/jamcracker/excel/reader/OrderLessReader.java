package com.jamcracker.excel.reader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.jamcracker.entity.service.OrderLessData;
import com.jamcracker.objectRepository.customer.ResultsFromDB;

public class OrderLessReader {

	public String path;
	public FileInputStream fis;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;

	public OrderLessReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public OrderLessData[] getOrderLessData(String fileName, String sheetName) {

		List<OrderLessData> olData = new ArrayList<OrderLessData>();

		try {
			sheet = workbook.getSheet(sheetName);

			row = sheet.getRow(0);
			Map<Integer, String> colIndex = new HashMap<Integer, String>();
			int celLen = row.getLastCellNum();
			for (int i = 0; i < celLen; i++) {
				colIndex.put(i, row.getCell(i).getStringCellValue());
			}

			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				row = sheet.getRow(i);
				OrderLessData orderLess = new OrderLessData();

				orderLess.setEmail(row.getCell(0).getStringCellValue());
				orderLess.setPassword(row.getCell(1).getStringCellValue());
				orderLess.setServiceName(row.getCell(2).getStringCellValue());
				orderLess.setOfferName(row.getCell(3).getStringCellValue());
				orderLess.setOfferCode(row.getCell(4).getStringCellValue());

				int sum=0;
				Map<String, String> ordQty = new HashMap<String, String>();
				Map<String, String> dbOffer = ResultsFromDB.getOrderNumber(orderLess.getEmail(),
						orderLess.getOfferCode());

				for (int j = 5; j < celLen; j++) {

					if (dbOffer.get(colIndex.get(j)) != null){
						ordQty.put(dbOffer.get(colIndex.get(j)), row.getCell(j).getStringCellValue());
						sum+=Integer.parseInt(row.getCell(j).getStringCellValue());
					}

				}
				orderLess.setTotalQty(String.valueOf(sum));
				orderLess.setOrderQnt(ordQty);
				olData.add(orderLess);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return olData.toArray(new OrderLessData[olData.size()]);
	}

}
