package PageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public GoogleHomePage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 3000L);
		PageFactory.initElements(driver, this);
		
	}
	public void searchText(String searchKey) {
		this.searcBox.sendKeys(searchKey);
		//lambada expression
		this.wait.until((d) -> this.searchSuggestion.size()>3);
		
	}
	
	public void clickSuggestionByIndex(int index) {
		this.searchSuggestion.get(index-1).click();
		
	}
	
	@FindBy(name="q")
	private WebElement searcBox;
	
	
	@FindBy (css="li.sbct")
	private List<WebElement> searchSuggestion;
	
	
	
	public void LaunchUrl() {
		this.driver.get("https://www.google.com");
				
		
	}
	public boolean isDisplayed() {
		this.wait.until(ExpectedConditions.visibilityOf(searcBox) );
		return true;
	}


}
