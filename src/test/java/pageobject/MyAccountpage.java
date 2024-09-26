package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends Basepage {

	public MyAccountpage(WebDriver d) {
		super(d);
		
	}
	@FindBy(xpath ="//h1[text()='Your Account Has Been Created!']")
	WebElement Afterlogin;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	

	
	public boolean  ismyaccountpageexsist(){
	 try {
		return (Afterlogin.isDisplayed());
	 }
	 catch(Exception e) {
		 return false;
	 }
	 
	}
	public void logging() {
		logout.click();
	}
		
	//xmlns="http://maven.apache.org/POM/4.0.0"
    //xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    //xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 ">

}
