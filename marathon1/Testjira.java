package marathon1;

import org.testng.annotations.Test;
import java.io.IOException;



import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;



public class Testjira extends Apijira{
	
	@Test(dataProvider="fetchdata")
	
	public  void runTestjira(String summary) throws InterruptedException {
	
         driver.findElement(By.xpath("//p[text()='SDET-5']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//div[@class='css-hue21z']//span)[1]")).click();
		
		driver.findElement(By.id("summary-field")).sendKeys(summary);
		
		
		driver.findElement(By.xpath("(//span[text()='Create']/parent::button)[2]")).click();
		
		driver.findElement(By.xpath("//span[text()='Backlog']")).click();
		
		driver.findElement(By.name("search")).sendKeys(summary,Keys.ENTER);
		
		String findElement = driver.findElement(By.xpath("//mark[1]")).getText();
		if(findElement.matches(summary))
			System.out.println("created success");
		
			
		
	
		
	}
@DataProvider(name="fetchdata")
public String[][] getData() throws IOException
{

	String[][] readData = Readjira.readData();
	
	return readData;
	
}

}
