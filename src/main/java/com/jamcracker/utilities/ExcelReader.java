package com.jamcracker.utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelReader {
	
	public String path;
	public FileInputStream fis;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;
	
	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new HSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum) {
		
		try {
			int col_Num = 0;
			int index = workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equals(colName)) {
					col_Num = i;
					break;
				}
			}
			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(col_Num);
			if (null != cell && cell.getCellType() == Cell.CELL_TYPE_STRING) 
			{
				return cell.getStringCellValue().trim();
			} 
			else if (null != cell && cell.getCellType() == Cell.CELL_TYPE_NUMERIC) 
			{
				return String.valueOf(cell.getNumericCellValue()).trim();
			} 
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@SuppressWarnings("deprecation")
	public String[][] getDataFromSheet(String excelName, String sheetName) {
		
		//Initializing a 2D array to store the data
		String dataSets[][] = null;
		try {
			//Get sheet from the workbook
			sheet = workbook.getSheet(sheetName);
			//get total number of rows in the sheet
			int totalRow = sheet.getLastRowNum() + 1;
			//get total number of columns in the sheet
			int totalColumn = sheet.getRow(0).getLastCellNum();
			//Creating an array to store data
			dataSets = new String[totalRow - 1][totalColumn];
			//Running the loop to store data in 2D array
			//This for loop will run on all the rows
			for (int i = 1; i < totalRow; i++) {
				//Getting the Row
				row = sheet.getRow(i);
				//This for loop will run for all the columns of the row
				for (int j = 0; j < totalColumn; j++) {
					//Getting the cell
					cell = row.getCell(j);
					//If the cell is String value, then this if condition will execute
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						dataSets[i - 1][j] = cell.getStringCellValue().trim();
					}
					//If the cell is Numeric value, then this if condition will execute
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						String cellText = String.valueOf(cell.getNumericCellValue()).trim();
						dataSets[i - 1][j] = cellText;
					}
					//If the cell is Boolean value, then this if condition will execute
					else {
						dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue()).trim();
					}
				}
			}
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSets;
	}
	


}
