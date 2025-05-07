package AutomationFinaleProject_April.AutomationFinaleProject_April;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {

	String TheWebSiteUrl = "https://www.almosafer.com/en";

	WebDriver driver = new ChromeDriver();

	Random Rand = new Random();

	String ExpectedCurrency = "SAR";

	String ExpectedContactNumber = "+966554400000";

	String Value = "false";

	LocalDate date = LocalDate.now();

	int tomorrow = date.plusDays(1).getDayOfMonth();

	String tomorrowAsFormatedValue = String.format("%02d", tomorrow);

	int dayAfterTomrrow = date.plusDays(2).getDayOfMonth();

	String DayAftertomorrowAsFormatedValue = String.format("%02d", dayAfterTomrrow);

	String[] webistes = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };

	int randomIndex = Rand.nextInt(webistes.length);

	String[] ArabicCities = { "دبي", "جدة" };
	int RandomArabic = Rand.nextInt(ArabicCities.length);

	String[] EnglishCities = { "Dubai", "Jeddah", "Riyad" };
	int RandomEnglish = Rand.nextInt(EnglishCities.length);

	String[] VisitorsValues = { "A", "B" };
	int Values = Rand.nextInt(VisitorsValues.length);

	public void SetUp() {

		driver.get(TheWebSiteUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		WebElement SettingButtonEn = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));

		SettingButtonEn.click();
	}

}
