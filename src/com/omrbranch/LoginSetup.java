package com.omrbranch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LoginSetup {
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver","D:\\sample program\\OmrBranch\\driver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
	    //options.addArguments("--remote-allow-origins=*");
	    
		WebDriver driver = new ChromeDriver();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("angukarthikeyans@gmail.com");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("Akkn@0597");
		WebElement BtnLogin = driver.findElement(By.xpath("//button[text()='Login']"));
		
		BtnLogin.click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement state = driver.findElement(By.id("state"));
		Select select = new Select(state);
		select.selectByValue("Tamil Nadu");
		
		WebElement dist = driver.findElement(By.id("city"));
		Select dddistSelect = new Select(dist);
		dddistSelect.selectByIndex(1);
		
		WebElement roomtype = driver.findElement(By.xpath("//textarea[@placeholder='Select Room Type']"));

		
//		roomtype.sendKeys("Standard");
//		Robot rt= new Robot();
//		rt.keyPress(KeyEvent.VK_ENTER);
//		rt.keyRelease(KeyEvent.VK_ENTER);
//		
//		roomtype.sendKeys("Deluxe");
//		rt.keyPress(KeyEvent.VK_ENTER);
//		rt.keyRelease(KeyEvent.VK_ENTER);
//		
//		roomtype.sendKeys("Suite");
//		rt.keyPress(KeyEvent.VK_ENTER);
//		rt.keyRelease(KeyEvent.VK_ENTER);
//		
		
		
		
		
		
//		WebElement checkInDate = driver.findElement(By.xpath("//input[@name='check_in']"));
//		checkInDate.click();
//		
//		driver.findElement(By.xpath("//a[text()='18']")).click();
//		
//		driver.findElement(By.xpath("//a[text()='20']")).click();
//		
//		
//		WebElement RoomNo= driver.findElement(By.id("no_rooms"));
//		
//		Select room1 = new Select(RoomNo);
//		room1.selectByValue("2");
//		
//		WebElement adult= driver.findElement(By.id("no_adults"));
//		
//		Select ddadult= new Select(adult);
//		ddadult.selectByValue("2");
//	
//		WebElement childno=driver.findElement(By.id("no_child"));
//		childno.sendKeys("0");		
//		
//		driver.switchTo().frame(0);
//		
//		WebElement search = driver.findElement(By.id("searchBtn"));
//		search.click();
//			
//		
//		WebElement hotel= driver.findElement(By.xpath("//a[text()='Continue']"));
//		hotel.click();
//		
//		driver.switchTo().alert().accept();
//		
//		WebElement self= driver.findElement(By.id("own"));
//		self.click();
//		
//		WebElement salutation= driver.findElement(By.id("user_title"));
//		Select mr= new Select(salutation);
//		mr.selectByIndex(1);
//		
//		WebElement firstname = driver.findElement(By.id("first_name"));
//		firstname.sendKeys("Angukarthikeyan");
//		
//		WebElement lastname = driver.findElement(By.id("last_name"));
//		lastname.sendKeys("Sundararajan");
//		
//		WebElement mobileno = driver.findElement(By.id("user_phone"));
//		mobileno.sendKeys("9698806733");
//		
//		WebElement mail= driver.findElement(By.id("user_email"));
//		mail.sendKeys("angu0597@gmail.com");
//		
//		WebElement next= driver.findElement(By.id("step1next"));
//		next.click();
//		
//		WebElement largebed= driver.findElement(By.id("bed"));
//		largebed.click();
//		
//		WebElement comment = driver.findElement(By.id("other_request"));
//		comment.sendKeys("Food with Tandoori");
//		
//		
//		WebElement next2= driver.findElement(By.id("step2next"));
//		next2.click();
//		
//		WebElement credet = driver.findElement(By.xpath("//h5[text()='Credit/Debit/ATM Card']"));
//		credet.click();
//		
//		WebElement selectcard= driver.findElement(By.id("payment_type"));
//		Select credit= new Select(selectcard);
//		credit.selectByIndex(2);
		
	}
	
	
	


}
