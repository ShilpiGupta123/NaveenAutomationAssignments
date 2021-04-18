package driver.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBase {
	static WebDriver driver;

	public static void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "/home/pristyncare/chromedriver_linux64/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
	}
	
	public static void closeDriver() {
		driver.close();
	}
}
