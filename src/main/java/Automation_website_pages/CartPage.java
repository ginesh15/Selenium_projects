package Automation_website_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.Base;

public class CartPage extends Base{
	
	/*Locators of web page*/
	@FindBy(xpath="//a[contains(text(),'Proceed To Checkout')]")
	WebElement clickproceedTocheck;
	
	@FindBy(xpath="//u[contains(text(),'Register / Login')]")
	WebElement clickregisterLogin;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement enteremail;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement enterpwd;
	
	@FindBy(xpath="//input[@data-qa='signup-name']")
	WebElement entername;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement entersignupemail;
	
	@FindBy(xpath="//button[contains(text(),'Signup')]")
	WebElement cliksignupbtn;
	
	/*PageFactory*/
	public CartPage () {
		PageFactory.initElements(driver,this); 
	} 
	
	/*To get title*/
	public String CartPageTitle() {
		return driver.getTitle();
	}
	/*To Click proceed  button*/
	public void clickProceedTo_check() {
		clickproceedTocheck.click();
	}
	/*To click Register utton*/
	public void clickRegisterbtn() {
		clickregisterLogin.click();
	}
	/*To Send the Data to sign page*/
	public void signup(String name,String email) {
		entername.sendKeys(name);
		entersignupemail.sendKeys(email);
	}
	/*To click signup btn*/
	public Createaccountpage clickSignup() {
		cliksignupbtn.click();
		return new Createaccountpage();
	}
  


}
