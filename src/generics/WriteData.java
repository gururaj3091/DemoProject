package generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {
	
	public static void writeCellData(String xlpath,String sh,int r,int c,String res) throws Exception
	{
		FileInputStream fis = new FileInputStream(xlpath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sh);
		XSSFRow row = null;
		XSSFCell cell = null;
		
		row = sheet.getRow(r);
				if(row==null)
					sheet.createRow(r);
		cell = row.getCell(c);
				if(cell==null)
					row.createCell(c);
				
		cell.setCellValue(res);
		
		FileOutputStream fos = new FileOutputStream(xlpath);
		wb.write(fos);
		fos.close();
					
	}

}
