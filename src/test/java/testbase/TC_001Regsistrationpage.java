package testbase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import pageobject.AccountRegpage;
import pageobject.Homepage;
import testbasepack.Baseclass;

public class TC_001Regsistrationpage extends Baseclass{
	
@Test(groups={"regression", "Master"})
public void TC1() throws InterruptedException {
	Homepage hp = new Homepage(d);
	hp.clickMyAccount();
	hp.clickRegister();
	
	AccountRegpage accregpage = new AccountRegpage(d) ;
		accregpage.firstnamefield(randomeString().toUpperCase());
		accregpage.Lastnamefield(randomeString().toLowerCase());
		accregpage.emailfield(randomeString()+"@gmail.com");
		accregpage.phenumber(randomeNumber());
		String password = randomAlphaNumeric();
		accregpage.password(password);
		accregpage.passwordconfrimation(password);
		Thread.sleep(5000);
		accregpage.checkboxconfrimation();
		Thread.sleep(5000);
		accregpage.buttonclick();
	
}
public String randomeString()
{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
}

public String randomeNumber()
{
	String generatedString=RandomStringUtils.randomNumeric(10);
	return generatedString;
}

public String randomAlphaNumeric()
{
	String str=RandomStringUtils.randomAlphabetic(3);
	String num=RandomStringUtils.randomNumeric(3);
	
	return (str+"@"+num);
}
}
