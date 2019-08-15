package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTIMEOpenTasks {

		
		@FindBy(xpath="//img[@alt='Logout']")
		private WebElement lgoutBtn;
		
		public ActiTIMEOpenTasks(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void clickLogOutBtn()
		{
			lgoutBtn.click();
		}

}
