package src;

import java.io.IOException;

import generics.TakeScreenshot;
import generics.WriteData;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		System.out.println("Test Siute Finished "+result.getName());
		
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("Test Siute started "+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed "+result.getName());
		//WriteData.writeCellData(xlpath, sh, r, c, res);
		try {
			TakeScreenshot.takeScreenshotTest(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped "+result.getName());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success "+result.getName());
		
	}

}
