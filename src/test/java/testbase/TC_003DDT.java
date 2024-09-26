package testbase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Loginpage;
import pageobject.MyAccountpage;
import testbasepack.Baseclass;
import utilies.Dataprovider;

public class TC_003DDT extends Baseclass{
	
	@Test(dataProvider="LoginData",dataProviderClass = Dataprovider.class)
	public void verify_loginDDT(String email, String password, String exp)
	{	
		try {
	
		//Home page
			Homepage hp=new Homepage(d);
			hp.clickMyAccount();
			hp.clickLogin(); //Login link under MyAccount
				
			//Login page
			Loginpage lp=new Loginpage(d);
			lp.setemail(email);
			lp.setpassword(password);
			lp.clickloginbutton(); //Login button
				
			//My Account Page
			MyAccountpage acc=new MyAccountpage(d);
			boolean targetPage=acc.ismyaccountpageexsist();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					Thread.sleep(5000);
					acc.logging();
					Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
					
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					Thread.sleep(5000);
					acc.logging();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			}
	

}
