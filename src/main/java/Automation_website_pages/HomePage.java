package Automation_website_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestBase.Base;

public class HomePage extends Base {

	/*Locators*/
	@FindBy(xpath="//a[@href='/view_cart']")
	WebElement cartbutton;
	
	@FindBy(xpath="//*[contains(@data-product-id,'1')]")
	WebElement addTocartbtn;
	
	@FindBy(xpath="//*[contains(@data-product-id,'2')]")
	WebElement addTocartbtn1;
	
	@FindBy(xpath="//button[contains(text(),'Continue Shopping')]")
	WebElement clickcontishopping;
	
	/*PAgefactory*/
	public HomePage () {
		PageFactory.initElements(driver,this);
	} 
	public String HomePageTitle() { 
		return driver.getTitle();
	}
	public CartPage clickcartbuttonlink() { 
		cartbutton.click();
		return new CartPage();
	}
	
	/*Click add button*/
	public void clickAddTocartbutton() {
		addTocartbtn.click();
		clickcontishopping.click();
		addTocartbtn1.click();
	}

}
