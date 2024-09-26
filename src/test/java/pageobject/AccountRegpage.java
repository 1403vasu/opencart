package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegpage extends Basepage{
	
	 
	public AccountRegpage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement pheno;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement Confpassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btnContinue;
	
		public void firstnamefield(String fname) {
			firstname.sendKeys(fname);		
			}
		
		public void Lastnamefield(String Lname) {
			lastname.sendKeys(Lname);		
			}
		
		public void emailfield(String emailfield) {
			Email.sendKeys(emailfield);
		}
		public void phenumber(String pnofield) {
			 pheno .sendKeys(pnofield);
		}
		public void password(String pass)
		{
			password.sendKeys(pass);
		}
		
		public void passwordconfrimation(String conpass) {
			Confpassword.sendKeys(conpass);
		}
		
		public void checkboxconfrimation() {
			checkbox.click();
		}
		
		public void buttonclick() {
			btnContinue.click();
		}
		
}
