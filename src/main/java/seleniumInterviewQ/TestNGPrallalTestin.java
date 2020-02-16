package seleniumInterviewQ;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGPrallalTestin {
	
	WebDriver driver = null;
	
	@Test
	public void testFb() {
		
		System.setProperty("webdriver.chrome.driver",".//src//main//java//exefile//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("I AM INSIDE THE FACEBOOK "+ Thread.currentThread().getId());
	}

	@Test
	public void testGoogle() {
		System.setProperty("webdriver.chrome.driver",".//src//main//java//exefile//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("I AM INSIDE THE google "+ Thread.currentThread().getId());
	}
}
