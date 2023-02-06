package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] arg) {
        // Set the path to the chrome driver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chrome/driver");
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the webpage
        driver.get("https://www.example.com");
        
        // Close the browser
        driver.quit();
    }
}