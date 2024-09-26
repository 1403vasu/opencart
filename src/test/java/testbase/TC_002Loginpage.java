package testbase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Loginpage;
import pageobject.MyAccountpage;
import testbasepack.Baseclass;

public class TC_002Loginpage  extends Baseclass{

	@Test(groups={"sanity","Master"})
	public void Verify_login() {
		try {
		Homepage hp = new Homepage(d);
		hp.clickMyAccount();
		hp.clickLogin();
		
		Loginpage lp = new Loginpage(d);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickloginbutton();
		
		MyAccountpage acc = new MyAccountpage(d) ;
		Boolean page = acc.ismyaccountpageexsist();
		Assert.assertEquals(page, true, "Loginfailed");
		}
		catch(Exception e){
			Assert.fail();
		}
		}
	}

