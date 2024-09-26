package testbasepack;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Baseclass {
static public WebDriver d;
public Properties p;
	
  @BeforeClass(groups= {"sanity","regression", "Master"})
	@Parameters({"os","browser"})
  public void setup(@Optional("Windows") String os, @Optional("Chrome") String browser)throws IOException {
	
	
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("window")) {
				
				cap.setPlatform(Platform.WIN10); //cap.setPlatform(Platform.MAC);	
			}
			else {
				System.out.println("No matching windows");
				return;
				
			}
			//browser
			switch(browser.toLowerCase()) {
			case "chrome" : cap.setBrowserName("chrome");
			break;
			default: System.out.println("No matching browser"); 
			return;
			
			}
		 d= new RemoteWebDriver(new URL(" http://192.168.1.40:4444"), cap);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
	
		switch (browser.toLowerCase()) {
		case "chrome" : d = new ChromeDriver();break;
		case "firefox" : d = new FirefoxDriver(); break;     
	
		default : System.out.print("Invalid browser name "); return;
		}
  //	WebDriver driver = new RemoteWebDriver(new URL(huburl), cap);
		}
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get(p.getProperty("appurl"));
		d.manage().window().maximize();
	}
		
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) d;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
}
	
	//@AfterClass
	//public void tearDown()
	//{
		//d.close();
	//}

