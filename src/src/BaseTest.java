package src;

import java.util.concurrent.TimeUnit;

import org.automationtesting.excelreport.Xl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser(XmlTest x)
	{
		String browser = x.getParameter("browser");
		if(browser.equalsIgnoreCase("ff"))
		{
		driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("gc"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\exes\\chromedriver.exe");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			driver = new ChromeDriver(cap);
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", ".\\exes\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("requireWindowFocus", true);
			driver = new InternetExplorerDriver(capabilities);
		}
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.close();
	}
	
	@AfterSuite
	public void testReport() throws Exception
	{
		Xl.generateReport("ExcelReport.xlsx");
	}

}
