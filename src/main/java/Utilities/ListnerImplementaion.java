package Utilities;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;


import com.aventstack.extentreports.ExtentTest;

import TestBase.Base;


public class ListnerImplementaion extends Base	implements ITestListener{
    public int count_pass =0;
    public int count_fail = 0;
	public static ExtentReports extent;
	public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//before each test case
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ "is Passed");
		count_pass= count_pass+1;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ "is Failed");
		
		count_fail= count_fail+1;
		
		test.log(Status.FAIL, result.getThrowable());
				
		String screenshotPath = CommonUtils.getCaptureFailedTestCaseScreenShot(driver);
		
		test.addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//setup method call
		extent = ExtentSetup.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		  // Send the report via SMS
		 String phoneNumber = "+918816991392"; // Replace with the recipient's phone number
	        String message = "Your test report is ready!!" +"  "+"\nNumber of Test Passed: "+ count_pass + "\nNumber of Test Fail: "+ count_fail +"\nPlease check your Email for whole Test Report.\n Thanks.";  // Replace with a custom message if needed
	        SmsUtil.sendSMS(phoneNumber, message);
	        
	        String whatappno = "+919896380211";
	        String Whatsappmsg =   "Hi, Ginesh! Thanks for Testing the Automation Website"+"  "+"\nNumber of Test Passed: "+ count_pass +"\nNumber of Test Fail: "+ count_fail + "\nFor detailed Report Please check your email.\n Thank you.";
	        SmsUtil.sendWhatsAppMessage(whatappno, Whatsappmsg);

	    final String callMessage = "Hi Ginesh, Your test report is ready. Please check your email for details.Thanks.";
        SmsUtil.makePhoneCall(phoneNumber, callMessage);
        
       
	}
	
	}


