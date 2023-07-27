package Automation_wbsite_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import Automation_website_pages.AddTocartPage;
import Automation_website_pages.CartPage;
import Automation_website_pages.Createaccountpage;
import Automation_website_pages.HomePage;
import Automation_website_pages.PaymentPage;
import TestBase.Base;
import Utilities.ReadExcelData;
@Listeners(Utilities.ListnerImplementaion.class)
public class EndToEndWholeTest extends Base {


	HomePage home;
	CartPage cart;
	Createaccountpage create; 
	PaymentPage payment;
	
	String homepagetitle = "Automation Exercise";
	String Cartpagetitle = "Automation Exercise - Checkout";
	String VerifyOrderSummary = "Congratulations! Your order has been confirmed!";
	String VerfiyAccountDelete = "ACCOUNT DELETED!";
	
	/*Data Provider via Excel*/
	@Test(dataProviderClass = ReadExcelData.class, dataProvider = "XLSheet")
	/*Provide the parmeter using Excel*/
	public void EndToEndTestRun(String Name,String Email,String Password,String Firstname,
			String Lastname,String Address, String State, String City,String Zipcode,
			String Mobileno,String OrderComments,String NameofCard, String Cardno,
			String Cvv,String ExpireMonth, String ExpireYear) { 
		
		    /*Check Home Page*/
		    home= new HomePage();  
		    String homepagetitle =home.HomePageTitle();
		    Assert.assertEquals(homepagetitle, homepagetitle);
		
		    /*Click Add to cart Button*/
		    home.clickAddTocartbutton();
		    cart = home.clickcartbuttonlink();
		
			/*Verify the title of Cart page*/
			String cartpagetitle =cart.CartPageTitle();
			Assert.assertEquals(cartpagetitle, Cartpagetitle);
			
			/*Proceed to check btn in cart page*/
			cart.clickProceedTo_check();
			
			/*Click registerbtn*/
			cart.clickRegisterbtn(); 
			
			/*click signupbtn*/
			cart.signup(Name, Email);
			create= cart.clickSignup();
			create.Createaccnt(Password, Email, Firstname, Lastname, Address,
					State, City, Zipcode, Mobileno);
			
			String loginasusername = create.verifyLoginlink();
			Assert.assertEquals(loginasusername, "Logged in as " + Name);
		
			cart = home.clickcartbuttonlink();
			cart.clickProceedTo_check();
			
			create.enterDiscription(OrderComments);
			payment= create.clickplaceorderbtn();
			
			payment.PymentPAge(NameofCard, Cardno, Cvv, ExpireMonth, ExpireYear);
			String verfiyorder = payment.verifyorderplacedsuccess();
			Assert.assertEquals(verfiyorder, VerifyOrderSummary);
			payment.clickdeleteaccnt();
			
			/*Verify The Delete page*/
			String verfiydeleteaccunt = payment.verifydeleteaccount();
			Assert.assertEquals(verfiydeleteaccunt, VerfiyAccountDelete);
			payment.clickcontinubtn();
		
	}
	

}
