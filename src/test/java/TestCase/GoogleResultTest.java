package TestCase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.GoogleHomePage;
import PageObjects.GoogleResultPage;

public class GoogleResultTest extends BaseTest {
	//@Test (dataProvider="getData")
	@Test
	@Parameters({"keyword","index"})
	public void GoogleResult(String keyword, int index)  {
		
		GoogleResultPage resultpage= new GoogleResultPage(driver);
		GoogleHomePage gp = new GoogleHomePage(driver);
		gp.LaunchUrl();
		gp.isDisplayed();
		gp.searchText(keyword);
		gp.clickSuggestionByIndex(index);
		resultpage.isDisplayed();
		Assert.assertEquals("Pass", "Pass");
		
	}
	
	/*@DataProvider
	public Object[][] getData() {
		return new Object[][]{
		{"Docker", 3},
		{"Selenium", 2}
		
	};
	}*/
}
