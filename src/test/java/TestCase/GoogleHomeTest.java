package TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.GoogleHomePage;



public class GoogleHomeTest extends BaseTest{
	@Test
	public void searchTest() {
		GoogleHomePage gp = new GoogleHomePage(driver);
		gp.LaunchUrl();
		gp.isDisplayed();
		Assert.assertEquals(1, 1);
		
	}


}
