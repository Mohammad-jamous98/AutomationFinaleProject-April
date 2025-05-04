package AutomationFinaleProject_April.AutomationFinaleProject_April;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {

	String TheWebSiteUrl = "https://www.almosafer.com/en";

	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void MySetUp() {

		driver.get(TheWebSiteUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		WebElement SettingButtonEn = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));

		SettingButtonEn.click();

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

		String ExpectedCurrency = "SAR";

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();
		String ExpectedContactNumber = "+966554400000";

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

		String Value = "false";

		Assert.assertEquals(MakeSureNotSelected, Value);
	}

	@Test(priority = 6, enabled = false)
	public void CheckTheDateOfTheDeparture() {

		LocalDate date = LocalDate.now();

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualDepatureDate = dates.get(0).getText();

		int tomorrow = date.plusDays(1).getDayOfMonth();

		String tomorrowAsFormatedValue = String.format("%02d", tomorrow);

		System.out.println(tomorrow);
		System.out.println(ActualDepatureDate);
		System.out.println(tomorrowAsFormatedValue);
		Assert.assertEquals(ActualDepatureDate, tomorrowAsFormatedValue);

	}

	@Test(priority = 7, enabled = false)
	public void CheckTheDateOfTheReturn() {

		LocalDate date = LocalDate.now();

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualReturnDate = dates.get(1).getText();

		int dayAfterTomrrow = date.plusDays(2).getDayOfMonth();

		String DayAftertomorrowAsFormatedValue = String.format("%02d", dayAfterTomrrow);

		System.out.println(dayAfterTomrrow);
		System.out.println(ActualReturnDate);
		System.out.println(DayAftertomorrowAsFormatedValue);
		Assert.assertEquals(ActualReturnDate, DayAftertomorrowAsFormatedValue);

	}

	@Test(priority = 8, invocationCount = 5)
	public void ChangeTheWebsiteLanaguage() {

		String[] webistes = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
		Random rand = new Random();

		int randomIndex = rand.nextInt(webistes.length);

		driver.get(webistes[randomIndex]);

		if (driver.getCurrentUrl().contains("en")) {

			CheckTheWebSiteLunguage("en");
		}

		else {
			CheckTheWebSiteLunguage("ar");
		}
	}

}
