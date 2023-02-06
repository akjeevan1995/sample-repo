package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

public class ExampleTest {
    @Test
    public void testGoogleSearch() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        driver.findElement(By.name("btnK")).click();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Selenium WebDriver"));
        driver.quit();
    }
}