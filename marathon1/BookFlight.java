package marathon1;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BookFlight extends ProjectFlight {
	@Test(dataProvider = "fetchData")
	public void getFlightsByPrice(String from, String to) throws InterruptedException {

		driver.findElement(By.xpath("//label[@for='onewayTrip']")).click();
		driver.findElement(By.xpath("//a[@class='suggestion-box__clear icon']")).click();
		driver.findElement(By.id("from0")).sendKeys(from, Keys.ENTER);

		driver.findElement(By.id("from0")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("to0")).sendKeys(to, Keys.ENTER);

		driver.findElement(By.id("to0")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("cal0")).click();
		driver.findElement(By.xpath("//a[@class=' month-date is--today']")).click();
		// Random number generator
		int temp = (Math.random() <= 0.5) ? 1 : 2;
		if (temp == 2) {
			driver.findElement(By.id("travellerButton")).click();
			driver.findElement(By.id("addadults")).click();
		}
		driver.findElement(By.id("searchNow")).click();
		driver.findElement(By.xpath("//button[text()='See Flights Only']")).click();
		driver.findElement(By.xpath("//a//span[text()='Cheapest']")).click();
		Thread.sleep(3000);

		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='currency ']"));
		System.out.println("Sorted Prices");
		for (WebElement e : prices)
			System.out.println(e.getAttribute("title"));
	}

}
