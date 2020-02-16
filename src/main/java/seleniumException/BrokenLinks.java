package seleniumException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hossa\\eclipse-workspace\\SeleniumInterview\\src\\main\\java\\exefile\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		List<WebElement> linksElement = driver.findElements(By.tagName("a"));
		for (int i = 0; i < linksElement.size(); i++) {

			String url = linksElement.get(i).getAttribute("href");
			verifyLinks(url);
		}
	}

	public static void verifyLinks(String links) throws Exception {
		URL url = new URL(links);

		HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
		urlConnection.connect();
		if (urlConnection.getResponseCode() == 200) {

			System.out.println("Links: " + urlConnection.getResponseMessage());
		} else if (urlConnection.getResponseCode() == urlConnection.HTTP_NOT_FOUND) {
			System.out.println(urlConnection.getResponseMessage());
		}

	}
}
