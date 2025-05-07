package AutomationFinaleProject_April.AutomationFinaleProject_April;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData {

	@BeforeTest

	public void MySetUp() {

		SetUp();

	}

	@Test(priority = 1, enabled = false)
	public void CheckTheWebSiteLunguage(String ExpectedLanguage) {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}

	@Test(priority = 2, enabled = false)
	public void CheckCurrency() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4, enabled = false)
	public void CheckQitafLogo() {

		WebElement TheFooter = driver.findElement(By.tagName("footer"));

		Boolean ActualImageIsDisplay = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();

		Assert.assertEquals(ActualImageIsDisplay, true);
	}

	@Test(priority = 5, enabled = false)
	public void CheckTheStaysTabNotSelected() {

		WebElement Stays = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		String MakeSureNotSelected = Stays.getDomAttribute("aria-selected");

		Assert.assertEquals(MakeSureNotSelected, Value);
	}

	@Test(priority = 6, enabled = false)
	public void CheckTheDateOfTheDeparture() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualDepatureDate = dates.get(0).getText();

		Assert.assertEquals(ActualDepatureDate, tomorrowAsFormatedValue);

	}

	@Test(priority = 7, enabled = false)
	public void CheckTheDateOfTheReturn() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualReturnDate = dates.get(1).getText();

		Assert.assertEquals(ActualReturnDate, DayAftertomorrowAsFormatedValue);

	}

	@Test(priority = 8)
	public void ChangeTheWebsiteLanaguage() {

		driver.get(webistes[randomIndex]);

		if (driver.getCurrentUrl().contains("en")) {

			CheckTheWebSiteLunguage("en");
		}

		else {
			CheckTheWebSiteLunguage("ar");
		}
	}

	@Test(priority = 9)
	public void RandomlySelectCity() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		WebElement SearchInputField = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input "));

		if (driver.getCurrentUrl().contains("en")) {

			SearchInputField.sendKeys(EnglishCities[RandomEnglish]);

		}

		else {

			SearchInputField.sendKeys(ArabicCities[RandomArabic]);

		}

		WebElement Numberofvisitors = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Select SelectChoice = new Select(Numberofvisitors);

		SelectChoice.selectByValue(VisitorsValues[Values]);

		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();

	}

	@Test(priority = 10)
	public void CheckTheResultsIsretrived() throws InterruptedException {

		Thread.sleep(10000);

		String Result = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();

		if (driver.getCurrentUrl().contains("en")) {
			Assert.assertEquals(Result.contains("found"), true);

		} else {
			Assert.assertEquals(Result.contains("مكان إقامة"), true);

		}
	}

}
