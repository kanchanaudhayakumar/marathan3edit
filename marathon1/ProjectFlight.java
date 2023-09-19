package marathon1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

//import io.cucumber.java.ParameterType;

public class ProjectFlight {
	public ChromeDriver driver;
	@Parameters({"url"})

	//@ParameterType({"url"})
	@BeforeMethod
	public void preCondition(String url) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-close-icon']")));
		driver.findElement(By.xpath("//div[@class='modal-close-icon']")).click();

	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

	@DataProvider(name = "fetchData")
	public String[][] getData() throws IOException {
		String[][] readData = ReadExcel.readData();
		return readData;

	}
	
	
	
}