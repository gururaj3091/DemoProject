package generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import src.BaseTest;

public class TakeScreenshot extends BaseTest{
	
	public static String takeScreenshotTest(String screenhotName) throws IOException
	{
		EventFiringWebDriver e = new EventFiringWebDriver(driver);
		File src = e.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\screenshots\\"+screenhotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		
		return path;
	}

}
