package dynamicXpath;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class calenderSelectToDaysTest {

	@Test
	public void calender() throws InterruptedException {
		
		LocalDateTime sysDate = LocalDateTime.now();
		
		int date = sysDate.getDayOfMonth();
		String Month = sysDate.getMonth().toString();
		String actualMonth = Month.substring(0, 1)+Month.substring(1).toLowerCase();
		
		int year = sysDate.getYear();
		String monthAndDate = actualMonth+" "+year;
/*		System.out.println(date);
		System.out.println(actualMonth);
		System.out.println(year);*/
		System.out.println(monthAndDate);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Actions action = new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[text()='"+monthAndDate+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		Thread.sleep(3000);
		driver.close();	
		
		
	}
	
	
	
}
