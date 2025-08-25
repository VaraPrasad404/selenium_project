package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CompareTwoExcel {
	
	public static void main(String args[]) throws IOException {
		
		boolean issame = true;
		
		FileInputStream fis1 = new FileInputStream("Excel1.xlsx");
		FileInputStream fis2 = new FileInputStream("Excel2.xlsx");
		
		Workbook wb1 = new XSSFWorkbook(fis1);
		Workbook wb2 = new XSSFWorkbook(fis2);
		
		Sheet sheet1 = wb1.getSheetAt(0);
		Sheet sheet2 = wb2.getSheetAt(0);
		
		int row1 = sheet1.getLastRowNum();
		int row2 = sheet2.getLastRowNum();
		
		if(row1 != row2) {
			System.out.println("Rows are not equal in two files");
			issame = false;
		}
		
		for(int i=1; i< Math.max(row1, row2);i++) {
			
			Row rows1 = sheet1.getRow(i);
			Row rows2 = sheet2.getRow(i);
			
			if(rows1 == null && rows2 == null) {
				
				System.out.println("Empty row at"+ i);
				continue;
			}
			
			if(rows1 == null || rows2 == null) {
				
				System.out.println("Data is not matching at row"+i);
				issame = false;
			}
			
			int cells1 = rows1.getLastCellNum();
			int cells2 = rows2.getLastCellNum();
			
			if(cells1 != cells2) {
				System.out.println("Cells are different in row"+i);
			}
			
			for(int j=1; j<Math.max(cells1, cells2);j++) {
				
			Cell rowcell1	= rows1.getCell(j);
			Cell rowcell2 = rows2.getCell(j);
			
			String val1 = (rowcell1 == null) ? "" : rowcell1.toString().trim();
			String val2 = (rowcell2 == null) ? "" : rowcell2.toString().trim();
			
			if(!val1.equals(val2)) {
				
				System.out.println("In row"+ i+"the column"+j+"is not matching"+ val1+" : "+val2);
				issame = false;
			}
			
			}
		}
	}
	

}
