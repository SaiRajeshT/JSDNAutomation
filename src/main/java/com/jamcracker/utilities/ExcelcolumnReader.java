package com.jamcracker.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelcolumnReader 
{
	@SuppressWarnings("deprecation")
	public static ArrayList<String> extractExcelContentByColumnIndex(String fileName,String sheetName,int columnIndex){
        ArrayList<String> columndata = null;
        try {
        	  columnIndex = columnIndex-1;
        	String path = System.getProperty("user.dir")+"/Data/"+fileName;
            File f = new File(path);
            FileInputStream ios = new FileInputStream(f);
            @SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(ios);
            HSSFSheet sheet = workbook.getSheet(sheetName);
            Iterator<Row> rowIterator = sheet.iterator();
            columndata = new ArrayList<String>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if(row.getRowNum() > 0){ //To filter column headings
                        if(cell.getColumnIndex() == columnIndex){// To match column index
                            switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                columndata.add(cell.getNumericCellValue()+"");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                columndata.add(cell.getStringCellValue());
                                break;
                            }
                        }
                    }
                }
            }
            ios.close();
            System.out.println(columndata);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columndata;
    }

}
