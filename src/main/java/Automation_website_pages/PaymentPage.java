package Automation_website_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Base;

public class PaymentPage extends Base {

	/*Locators*/
	@FindBy(xpath="//*[@class='form-control']")
	WebElement namecard;
	
	@FindBy(xpath="//*[@class='form-control card-number']")
	WebElement cardno;
	
	@FindBy(xpath="//*[@class='form-control card-cvc']")
	WebElement cardcv1;
	
	@FindBy(xpath="//*[@class='form-control card-expiry-month']")
	WebElement expiremonth;
	
	@FindBy(xpath="//*[@class='form-control card-expiry-year']")
	WebElement expireyear;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement clickpaybtn;
	
	@FindBy(xpath="//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
	WebElement verifyorderplaced;
	
	@FindBy(xpath="//a[@href='/delete_account']")
	WebElement deleteaccnt;
	
	@FindBy(xpath="//b[contains(text(),'Account Deleted!')]")
	WebElement displaydelete;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	WebElement clickcontin;
	/*PAgeFactory*/
	public PaymentPage () {
		PageFactory.initElements(driver,this);
	} 
	
	/* Send Data The in web PAge*/
	public void PymentPAge(String nameofcard,String Cardnumber,String cvv,String expiremont,String expireyea) {
		namecard.sendKeys(nameofcard);
		cardno.sendKeys(Cardnumber);
		cardcv1.sendKeys(cvv);
		expiremonth.sendKeys(expiremont);
		expireyear.sendKeys(expireyea);
		clickpaybtn.click();
		
	}
	
	public String verifyorderplacedsuccess() {
		return verifyorderplaced.getText();
	}
	
	public void clickdeleteaccnt() {
		deleteaccnt.click();
	}
	public String verifydeleteaccount() {
		return displaydelete.getText();
	}
	public void clickcontinubtn() {
		clickcontin.click();
	}
	
	

}
