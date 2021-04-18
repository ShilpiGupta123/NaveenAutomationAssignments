package naveen.automation.dailychalleage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2 {
	WebDriver driver;

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/pristyncare/chromedriver_linux64/chromedriver");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.noon.com/uae-en/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	}


	public void test() throws InterruptedException {
		String[] itemText= {"Recommended For You", "Top picks in laptops", "Limited time offers", "Bestselling fragrances"};

		for(int i=0;i<itemText.length;i++) {

			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h3[text()='"+itemText[i]+"']")));
			//((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)","");

			List<WebElement> headerList= driver.findElements(By.xpath("//*[@class='sc-1pz9vus-1 iGMThe']/child::div"
					+ "//h3[@class='sc-dlfnbm eFXxew']"));


			for(WebElement header:headerList) {
				if(header.getText().equals(itemText[i])) {

					System.out.println("------------"+header.getText()+"-------------");

					List<WebElement> itemList=driver.findElements(By.xpath("//h3[text()='"+header.getText()+"']/ancestor::div[2]"
							+ "/following-sibling::div[1]//div[@class='e3js0d-7 jULUCI']"));
					WebElement carsoleIcon=driver.findElement(By.xpath("//h3[text()='"+header.getText()+"']"
							+ "//ancestor::div[2]//following-sibling::div[1]"
							+ "//*[starts-with(@class,'swiper-button-next custom-navigation swiper-nav-')]"));

					while(carsoleIcon.isDisplayed()){
						for(WebElement item:itemList) {
							System.out.println(item.getText());
						} 
						carsoleIcon.click();
					}
				}
			}
		} 	 	 		
	} 	

	public void tearUp() {
		driver.close();
	}

	public static void main(String args[]) throws InterruptedException  {
		Day2 obj=new Day2();
		obj.setUp();
		obj.test();
		obj.tearUp();

	}
}
