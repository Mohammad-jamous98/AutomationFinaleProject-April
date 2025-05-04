# Almosafer UI Automation Test Suite

This is a Java-based automation testing project using **Selenium WebDriver** and **TestNG** to validate the UI functionality and content of the travel website [Almosafer](https://www.almosafer.com/en).

---

## 📌 Project Features

The automated tests in this project verify:

- 🌐 Website language (English/Arabic)
- 💱 Default currency (should be SAR)
- 📞 Customer contact number
- 🖼️ Qitaf logo visibility in footer
- 🏨 Default selection state of the "Stays" tab
- 📅 Departure and return dates (should be tomorrow and day after tomorrow)
- 🔁 Switching languages randomly and validating changes

---

## 🔗 Tested URLs

- https://www.almosafer.com/en
- https://www.almosafer.com/ar

---

## 🧪 Technologies Used

- Java 8+
- TestNG
- Selenium WebDriver
- Maven (recommended)
- Chrome + ChromeDriver

---

## 📦 Maven Dependency

Add the following to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.20.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.9.0</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 🚀 How to Run the Tests

1. Clone this project.
2. Replace `path/to/chromedriver` in your Java code with the actual path to your `chromedriver.exe`.
3. Use TestNG to run the test class `AppTest.java`.

---

## 📁 Test Descriptions

| Test Method                   | Description                                                                         |
| ----------------------------- | ----------------------------------------------------------------------------------- |
| `CheckTheWebSiteLunguage`     | Validates the HTML language tag of the website.                                     |
| `CheckCurrency`               | Asserts that the default currency is "SAR".                                         |
| `CheckContactNumber`          | Checks if the displayed contact number is correct.                                  |
| `CheckQitafLogo`              | Verifies that the Qitaf logo is displayed in the footer.                            |
| `CheckTheStaysTabNotSelected` | Ensures the "Stays" tab is not selected by default.                                 |
| `CheckTheDateOfTheDeparture`  | Confirms the departure date is set to tomorrow.                                     |
| `CheckTheDateOfTheReturn`     | Confirms the return date is set to the day after tomorrow.                          |
| `ChangeTheWebsiteLanguage`    | Randomly opens Arabic or English version and validates the language. (Runs 5 times) |

---

## ✅ Best Practices

- Use `WebDriverWait` instead of `Thread.sleep()` for dynamic content.
- Add `@AfterTest` with `driver.quit()` to clean up after tests.
- Keep method names and variables clear and consistently spelled.
- Use `@DataProvider` if you want parameterized tests in the future.

---

## 📎 Author

## Mohammad Jamous

Happy Testing! 🚀
