package TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Utilities.TestUtil;
import org.apache.commons.mail.*;
public class Base {
	/*webdriver initialilize*/
	public static WebDriver driver;
	public static Properties prop; 
	
	/*Read Configure Properties*/
	public Base(){ 
		
		try {
		
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./resources/confg.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		

/*Browser initilization Before Suite*/
@BeforeSuite
	public static void initialization(){ 
	
	String browserName = prop.getProperty("browser");  
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addExtensions(new File("./Block_add/addblock.crx"));
        	driver = new ChromeDriver(option);
		}
		else if(browserName.equals("ChromeHeadlessMode")){
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			driver = new ChromeDriver(option);
		}
        else if(browserName.equalsIgnoreCase("edge")) {
        	EdgeOptions edgeOptions = new EdgeOptions();
        	driver = new EdgeDriver(edgeOptions);
        }
        else if(browserName.equals("EdgeHeadlessMode")){
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
		}
        else if(browserName.equalsIgnoreCase("firefox")) {
        	driver= new FirefoxDriver();
        }
        else if(browserName.equals("FireFoxHeadlessMode")){
			FirefoxOptions firefox = new FirefoxOptions();
			firefox.addArguments("--headless");
			driver = new FirefoxDriver(firefox);
		}
        else
        	System.out.println("No browser found");
		
		/*maximize the Window*/
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		
		/*Imlicit Wait or Page Loadtimeout*/
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		/*Initialize the Browser*/
		driver.get(prop.getProperty("url"));
		
		//To iterate the window while testing
		Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
//        String childID = it.next();
        driver.switchTo().window(parentID);
		
	}

 /*Close the Browser*/
@AfterSuite

	public static void email() {
		
	    driver.quit();
	
		System.out.println("=====Test is Started==========");
		try {
			
			 EmailAttachment attachment = new EmailAttachment();
			  attachment.setPath("./Reports");
			 
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment.setDescription("Report of Whole Test");
			  attachment.setName("Automation Test Report");
			
			  String filePath = "./Reports/screenshots/FailTest.jpeg";
			  EmailAttachment attachment1 = new EmailAttachment();

			  attachment1.setPath(filePath);
			  attachment1.setDisposition(EmailAttachment.ATTACHMENT);
			  attachment1.setDescription("Report of Fail Test");
			  attachment1.setName("Automation Test Report");
			  
			  MultiPartEmail email = new MultiPartEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator("goyalginesh15@gmail.com", "zfkvsoofkhejxqfb"));
            email.setSSLOnConnect(true);
            email.setFrom("goyalginesh15@gmail.com");
            email.setSubject("Test Email");

            email.setMsg("Please Find Attached document to see Test Report of AutomationTest website ... :-)");
            email.addTo("goyalginesh15@gmail.com");
            
            email.attach(attachment);
            email.attach(attachment1);
            email.send();
            System.out.println("Email sent successfully!");
        } catch (EmailException e) {
            e.printStackTrace();
        }
		

	}

}


