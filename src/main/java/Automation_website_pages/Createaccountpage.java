package Automation_website_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.Base;

public class Createaccountpage extends Base{

	/*Locators*/
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement clikgender;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pswd;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement checknews;
	
	@FindBy(xpath="//input[@id='optin']")
	WebElement checkoffer;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement addrs;
		
	@FindBy(xpath="//input[@id='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement zip;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement mno;
	
	@FindBy(xpath="//button[contains(text(),'Create Account')]")
	WebElement crteaccntbtn;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement clickcontinubtn;
	
	@FindBy(css="textarea")
	WebElement enteridcription;
	
	@FindBy(xpath="//a[contains(text(),'Place Order')]")
	WebElement placeorderbtn;
	
	@FindBy(xpath="//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]")
	WebElement verifyLoginlink;
	
	public Createaccountpage () {
		PageFactory.initElements(driver,this); 
	} 

	/*SendThe data to Register the page*/
	public void Createaccnt(String passwd,String email,String firstname,String lastname,String address,String stat,String
			citi,String zipcod,String Mobno) {
		
		clikgender.click();
		pswd.sendKeys(passwd);
		
		checknews.click();
		checkoffer.click();
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		addrs.sendKeys(address);
		
		state.sendKeys(stat);
		city.sendKeys(citi);
		zip.sendKeys(zipcod);
		mno.sendKeys(Mobno);
		crteaccntbtn.click();
		clickcontinubtn.click();
		
		
	}
	
	public String verifyLoginlink() {
		return verifyLoginlink.getText();
	}
	
	public void enterDiscription(String data) {
		enteridcription.sendKeys(data);
		
	}
	
	public PaymentPage clickplaceorderbtn() {
		placeorderbtn.click();
		return new PaymentPage();
	}
	
		

}
