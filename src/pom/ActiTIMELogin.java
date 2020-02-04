package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ActiTIMELogin {
	
	@FindBy(name="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement lgnBtn;
	
	@FindBy(xpath="//span[contains(text(),'Username or Password is invalid')]")
	private WebElement errMsg;
	
	public ActiTIMELogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String username)
	{
		unTB.clear();
		unTB.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		pwTB.clear();
		pwTB.sendKeys(password);
	}
	
	public void clickLogin()
	{
		lgnBtn.click();
	}
	
	public void verifyErrMsg() 
	{
		Assert.assertTrue(errMsg.isDisplayed());
	}
}
