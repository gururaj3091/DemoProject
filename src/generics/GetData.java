package generics;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GetData {
	
	public static String getCellData(String xlPath,String sheet, int row, int cell)
	{
		String data = "";
		try
		{
			FileInputStream fis = new FileInputStream(xlPath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			data= wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	public static int getLatRowNum(String xlPath,String sheet)
	{
		int rc = 0;
		try
		{
		FileInputStream fis = new FileInputStream(xlPath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		rc= wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return rc;
	}
}
