package com.assignment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.agilecrmautomation.BaseClass;

public class TestListeners extends BaseClass  implements ITestListener,ISuiteListener {
	// ondart method of ISuiteListener Interface
	
	public void onStart(ISuite suite) {
  System.out.println("This is onStart method of suite");
	}
	
	//onfinish method of ISuiteListener Interface
	public void onFinish(ISuite suite) {
		System.out.println("This is onfinish method of suite");
	}
	public void onStart(ITestContext context) {
		System.out.println("This is onStart method of Test");
}
	public void onFinish(ITestContext context) {
		System.out.println("This is onfinish method of test");
	}
	public void onTestStart(ITestResult result) {
		System.out.println("This is ontest start method");
		
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("This is on test success method");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("This is on testfailure method");
		TakesScreenshot takes=	(TakesScreenshot)driver;
	File screenshotFile=	takes.getScreenshotAs(OutputType.FILE);
	//get project folder path
	String fileName=result.getName();

	String outpath=System.getProperty("user.dir")+"//ExecutionResult//screenshots//"+fileName+".png";
	File outputFile=new  File(outpath);
	
	try {
		FileUtils.copyFile(screenshotFile, outputFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	public void onTestSkipped(ITestResult result) {
	System.out.println("this is ontest skippedmethod");
	}
	public void OnTestfailedWithTimeout(ITestResult result) {
		System.out.println("Thsis onm testfailed with timeout method");
		onTestFailure(result);
	}

}
