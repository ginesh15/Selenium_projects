package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.Base;


public class CommonUtils extends Base{
	
	
	public static String getCaptureFailedTestCaseScreenShot(WebDriver driver) {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date=new Date();
		String actualDate=format.format(date);
		//String screenshotPath=System.getProperty("user.dir")+"/Reports/screenshots/"+actualDate+".jpeg";
		String screenshotPath=System.getProperty("user.dir")+"/Reports/screenshots/"+"FailTest"+".jpeg";
		 
		File dest = new File(screenshotPath); 
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}

}
