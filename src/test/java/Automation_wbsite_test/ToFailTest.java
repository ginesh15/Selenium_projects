package Automation_wbsite_test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Automation_website_pages.HomePage;
import TestBase.Base;
@Listeners(Utilities.ListnerImplementaion.class)



public class ToFailTest extends Base {

	HomePage home;
	
	String homepagetitle1 = "Automation Exercise!!";
	
	@Test
	 
	public void FailtestScenario() {
		 home= new HomePage();  
		    String homepagetitle =home.HomePageTitle();
		    Assert.assertEquals(homepagetitle, homepagetitle1);
	}
}
