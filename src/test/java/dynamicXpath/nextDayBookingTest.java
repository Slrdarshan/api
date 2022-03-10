package dynamicXpath;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class nextDayBookingTest {

	@Test
	public void bookTicket() throws InterruptedException {
		
		LocalDateTime sysdate = LocalDateTime.now().plusDays(1);
		
		System.out.println(sysdate);
		int date = sysdate.getDayOfMonth();
		System.out.println(date);
		String month = sysdate.getMonth().toString();
		String actualMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
		System.out.println(actualMonth);
		String dateAndMonth = actualMonth+" "+date;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		Actions action = new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[text()='"+dateAndMonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		Thread.sleep(3000);
		driver.close();	
		
	}
	
	
}
