package src;

import generics.GetData;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.ActiTIMELogin;

public class InvalidLogin extends BaseTest {
	
	@Test
	public  void testInvalidLogin()
	{
		String xlPath = ".\\excel\\Credentials.xlsx";
		String sheet = "InvalidLogin";
		
		int rc = GetData.getLatRowNum(xlPath, sheet);
		
		for(int i=1;i<=rc;i++)
		{
			String un = GetData.getCellData(xlPath, sheet, i, 0);
			String pw = GetData.getCellData(xlPath, sheet, i, 1);
			
			ActiTIMELogin atl = new ActiTIMELogin(driver);
			atl.setUsername(un);
			atl.setPassword(pw);
			atl.clickLogin();
			atl.verifyErrMsg();
		}
		
	}

}
