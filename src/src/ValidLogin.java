package src;

import generics.GetData;

import org.testng.annotations.Test;

import pom.ActiTIMELogin;
import pom.ActiTIMEOpenTasks;

public class ValidLogin extends BaseTest{
	
	@Test
	public void testValidLogin()
	{
		String xlPath = ".\\excel\\Credentials.xlsx";
		String sheet = "ValidLogin";
		
		String un = GetData.getCellData(xlPath, sheet, 1, 0);
		String pw = GetData.getCellData(xlPath, sheet, 1, 1);
		
		ActiTIMELogin atl = new ActiTIMELogin(driver);
		atl.setUsername(un);
		atl.setPassword(pw);
		atl.clickLogin();
		
		ActiTIMEOpenTasks ato = new ActiTIMEOpenTasks(driver);
		ato.clickLogOutBtn();
	}

}
