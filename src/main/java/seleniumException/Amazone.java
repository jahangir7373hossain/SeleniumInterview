package seleniumException;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazone {

	
	static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hossa\\eclipse-workspace\\SeleniumInterview\\src\\main\\java\\exefile\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void validateAllOptionsFromSearchDropDown(){
		driver.findElement(By.xpath("//select[@aria-describedby = 'searchDropdownDescription']")).click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//option[contains(@value , 'search-alias')]"));
		for(int i = 0; i < allOptions.size(); i++) {
			System.out.println(allOptions.get(i).getText());
		}
		driver.findElement(By.xpath("//select[@aria-describedby = 'searchDropdownDescription']")).click();
	}
	
	@Test
	public void selectOptionFromDropDown() throws InterruptedException {
		WebElement dropDown = driver.findElement(By.xpath("//select[@aria-describedby = 'searchDropdownDescription']"));
		Select select = new Select(dropDown);	
		select.selectByVisibleText("Amazon Devices");
		
	}
	
	@Test
	public void testFooter() {	
		List<WebElement> footerList = driver.findElements(By.xpath("//td[@class = 'navFooterDescItem']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", footerList.get(0));
		
		System.out.println("------------------ Footer List-------------------");
		for(int i = 0; i < footerList.size(); i++) {
			System.out.println(footerList.get(i).getText());
		}
	}
	
	@Test
	public void valiadateHeader() {
		List<String> headerList = new ArrayList<String>();
		headerList.add("Today's Deals");
		headerList.add("Best Sellers");
		headerList.add("Find a Gift");
		List<WebElement> headerEle = driver.findElements(By.xpath("//div[@id= 'nav-xshop']//a[contains(@href,'nav')]"));
		System.out.println("--------------- Header List ---------------------");
		for(int i = 0; i < 3; i++) {
			System.out.println(headerEle.get(i).getText());
			Assert.assertEquals(headerList.get(i), headerEle.get(i).getText());
		}
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("air pod");
		
		WebElement serchButton =  driver.findElement(By.xpath("//div[@class = 'nav-search-submit nav-sprite']"));
		
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", serchButton);
		Thread.sleep(5000);
	}
	
	@Test
	public void hoverSignIn() throws InterruptedException {
		WebElement signInElement = driver.findElement(By.xpath("//div[@id = 'nav-tools']//a[contains(@href,'com/ap/signin')]"));
		Actions act = new Actions(driver);
		act.moveToElement(signInElement).perform();
		WebElement signInButton = driver.findElement(By.xpath("(//span[contains(text(), 'Sign in')])[3]"));
		signInButton.click();
		driver.findElement(By.xpath("//a[@id = 'createAccountSubmit']")).click();
		driver.findElement(By.xpath("//input[@id = 'ap_customer_name']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id = 'ap_email']")).sendKeys("Mike345@GMAIL.COM");
		driver.findElement(By.xpath("//input[@id = 'ap_password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id = 'ap_password_check']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@class= 'a-button-input']")).submit();
	}
	
	@AfterMethod
	public void classTearDown() {
		driver.quit();
	}
}
