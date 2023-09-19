package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Apijira {
	
	
	
	
	
	public ChromeDriver driver;
	//public RemoteWebDriver driver;
	//public String fileName;
	@Parameters({"url","username","password"})
	
	
@BeforeMethod

	public void preCondition(String url,String uname,String pwd)throws InterruptedException {
		
	        
	        
			// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys(uname);
		
		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hari.radhakrishnan@testleaf.com");
		
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		driver.findElement(By.id("password")).sendKeys(pwd);
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		
			
	}
	/*@AfterMethod
	public void podtconditiom() throws InterruptedException
	{
		//Thread.sleep(6000);
		driver.close();
		//System.exit(0);
	}*/

}
