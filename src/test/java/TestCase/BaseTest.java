package TestCase;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {
	protected WebDriver driver ;
	@BeforeTest
	public void setUpDriver() throws MalformedURLException {
		String host = "localhost";
		if(System.getProperty("HUB_HOST")!=null) {
			host=System.getProperty("HUB_HOST");
			
		}
		String completeURL="http://" + host +":4444/wd/hub";
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\Vivek Mishra\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		DesiredCapabilities dc=null;
		//driver=new EdgeDriver();
		//dc=DesiredCapabilities.chrome();
		if(System.getProperty("BROWSER") !=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
			dc=DesiredCapabilities.firefox();
			this.driver = new RemoteWebDriver(new URL(completeURL), dc);
		}else {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			//options.setCapability("name", testname);
			this.driver = new RemoteWebDriver(new URL(completeURL), options);
			
		}
		
		
		
		//dc.setCapability(capabilityName, value);
		//this.driver =new RemoteWebDriver
		
	}
	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}

}
