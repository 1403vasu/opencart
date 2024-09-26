package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	WebDriver d;
	
	public Basepage(WebDriver d){
		this.d = d;
		PageFactory.initElements(d, this);
		
	}
	

}
