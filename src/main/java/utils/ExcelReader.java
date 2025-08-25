package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	public static void readexcelfiledata(String path, String sheetname) {
		
		List<String[]> data = new ArrayList<>();
		
		try {
			
			FileInputStream fis = new FileInputStream(path);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetname);
			
			int rowcount = 1;
			
for(int i = rowcount; i<= sheet.getLastRowNum();i++) {
		Row row = sheet.getRow(i);
				int cellcount = row.getPhysicalNumberOfCells();
				String[] rowdata = new String[cellcount];
				
				for(int j=0;j<cellcount;j++) {
					
					rowdata[j] = row.getCell(j).toString();
				}
				data.add(rowdata);
			}
			
			workbook.close();
			fis.close();
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		
		
		
	}

}
