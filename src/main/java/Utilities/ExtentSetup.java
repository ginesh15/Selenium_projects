package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import TestBase.Base;



public class ExtentSetup extends Base {
	public static ExtentReports extent;
	//public static ExtentTest test;
	public static ExtentReports setupExtentReport() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		//String reportPath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+actualDate+".html";
		String reportPath = System.getProperty("user.dir")+"/Reports/ExtentReport.html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
		
		extent = new ExtentReports();
		  
		extent.attachReporter(sparkReport);
		sparkReport.config().setDocumentTitle("Extent Report");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Ginesh Goyal");
		 
		return extent;
	}
}
