package src;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class SikuliExample {
	@Test
	public void testSikuli() throws FindFailed, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./exes/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileUpload.html");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Pattern browseButton = new Pattern("./screenshots/Browse.png");
		Pattern filePath = new Pattern("./screenshots/FilePath.png");
		Pattern openButton = new Pattern("./screenshots/Open.png");
		
		Screen screen = new Screen();
		screen.click(browseButton);
		screen.type(filePath,"E:\\fu.docx");
		screen.click(openButton);
	}

}
