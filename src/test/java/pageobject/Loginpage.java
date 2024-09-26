package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

	public Loginpage(WebDriver d) {
		super(d);
	}
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	 
	@FindBy(xpath = "//input[@value='Login']")
	WebElement clicklogin;
    
	public void setemail(String emailvalue) {
		email.sendKeys(emailvalue);
	}
	public void setpassword(String passwordvalue) {
		password.sendKeys(passwordvalue);
	}
	public void clickloginbutton() {
		clicklogin.click();
	}
	
}
