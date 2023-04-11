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

public class ErrorMsgDisplay {
	public static void main(String[] args) throws InterruptedException, AWTException {

		// login
		System.setProperty("webdriver.chrome.driver", "D:\\sample program\\OmrBranch\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("angukarthikeyans@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Akkn@0597");
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));

		loginBtn.click();

		// Explore Hotels
		WebElement iframe = driver.findElement(By.id("hotelsearch_iframe"));
		driver.switchTo().frame(iframe);
		WebElement searchbtn = driver.findElement(By.xpath("//button[text()='Search']"));
		searchbtn.click();

		driver.switchTo().defaultContent();

		// invalid 6 data
		WebElement invalidstate = driver.findElement(By.id("invalid-state"));
		String invalidstate1 = invalidstate.getText();
		System.out.println(invalidstate1);

		WebElement invalidcity = driver.findElement(By.id("invalid-city"));
		String invalidcity1 = invalidcity.getText();
		System.out.println(invalidcity1);

		WebElement invalidCheck_in = driver.findElement(By.id("invalid-check_in"));
		String invalidCheck_in1 = invalidCheck_in.getText();
		System.out.println(invalidCheck_in1);

		WebElement invalidCheck_out = driver.findElement(By.id("invalid-check_out"));
		String invalidCheck_out1 = invalidCheck_out.getText();
		System.out.println(invalidCheck_out1);

		WebElement invalidNo_rooms = driver.findElement(By.id("invalid-no_rooms"));
		String invalidNo_rooms1 = invalidNo_rooms.getText();
		System.out.println(invalidNo_rooms1);

		WebElement invalidNo_adults = driver.findElement(By.id("invalid-no_adults"));
		String invalidNo_adults1 = invalidNo_adults.getText();
		System.out.println(invalidNo_adults1);

		System.out.println("*************************");

		// ReEnter codes
		WebElement state = driver.findElement(By.id("state"));
		Select select = new Select(state);
		select.selectByValue("Tamil Nadu");

		WebElement dist = driver.findElement(By.id("city"));
		Select dddistSelect = new Select(dist);
		dddistSelect.selectByIndex(1);

		WebElement roomtype = driver.findElement(By.xpath("//textarea[@placeholder='Select Room Type']"));

		roomtype.sendKeys("Standard");
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);

		WebElement checkInDate = driver.findElement(By.xpath("//input[@name='check_in']"));
		checkInDate.click();

		driver.findElement(By.xpath("//a[text()='18']")).click();

		driver.findElement(By.xpath("//a[text()='20']")).click();

		WebElement RoomNo = driver.findElement(By.id("no_rooms"));

		Select room1 = new Select(RoomNo);
		room1.selectByValue("2");

		WebElement adult = driver.findElement(By.id("no_adults"));

		Select ddadult = new Select(adult);
		ddadult.selectByValue("2");

		WebElement childno = driver.findElement(By.id("no_child"));
		childno.sendKeys("0");

		driver.switchTo().frame(0);

		WebElement search = driver.findElement(By.id("searchBtn"));
		search.click();

		WebElement sortBy = driver.findElement(By.xpath("//label[text()='Price low to high']"));
		sortBy.click();

		WebElement continueBtn = driver.findElement(By.xpath("(//a[text()='Continue'])[1]"));
		continueBtn.click();

		driver.switchTo().alert().accept();

		// selecting room for myself

		Thread.sleep(1000);
		WebElement myselfRadioBtn = driver.findElement(By.id("own"));
		myselfRadioBtn.click();

		// Booking Details
		WebElement title = driver.findElement(By.id("user_title"));
		Select select5 = new Select(title);
		select5.selectByIndex(1);

		WebElement firstName = driver.findElement(By.name("first_name"));
		firstName.sendKeys("Angukarthikeyan");

		WebElement lastName = driver.findElement(By.name("last_name"));
		lastName.sendKeys("Sundararajan");

		WebElement phone = driver.findElement(By.id("user_phone"));
		phone.sendKeys("9698806733");

		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("angukarthikeyans@gmail.com");

		// next page
		WebElement nextBtn = driver.findElement(By.id("step1next"));
		nextBtn.click();

		// Room Specifications
		WebElement specify = driver.findElement(By.id("high"));
		specify.click();

		WebElement request = driver.findElement(By.id("other_request"));
		request.sendKeys("Large Space");

		Thread.sleep(1000);

		// next page
		WebElement nextBtn2 = driver.findElement(By.id("step2next"));
		Thread.sleep(1000);
		nextBtn2.click();
		

		

		
		// UPIClick
		WebElement upiClick = driver.findElement(By.xpath("//h5[text()='UPI']"));
		upiClick.click();

		WebElement subbtn = driver.findElement(By.id("submitBtn"));
		subbtn.click();

		// invalid UPI
		WebElement invalUpi = driver.findElement(By.id("invalid-upi"));
		String invalupi1 = invalUpi.getText();
		System.out.println(invalupi1);

		
Thread.sleep(1000);

		driver.switchTo().frame(0);
		
		// credit card payment
		WebElement creditDetails = driver.findElement(By.xpath("//h5[text()='Credit/Debit/ATM Card']"));
		creditDetails.click();

		Thread.sleep(1000);

		WebElement paymentType = driver.findElement(By.id("payment_type"));
		Select a = new Select(paymentType);
		a.selectByVisibleText("Debit Card");

		WebElement cardType = driver.findElement(By.id("card_type"));
		Select b = new Select(cardType);
		b.selectByVisibleText("Visa");

		WebElement cardNo = driver.findElement(By.id("card_no"));
		cardNo.sendKeys("5555512345552222");

		WebElement cardName = driver.findElement(By.id("card_name"));
		cardName.sendKeys("Angukarthikeyan_s");

		WebElement cardMonth = driver.findElement(By.id("card_month"));
		Select c = new Select(cardMonth);
		c.selectByVisibleText("August");

		WebElement cardYear = driver.findElement(By.id("card_year"));
		Select d = new Select(cardYear);
		d.selectByVisibleText("2023");

		WebElement cardCvv = driver.findElement(By.id("cvv"));
		cardCvv.sendKeys("786");

		WebElement btnSubmit = driver.findElement(By.id("submitBtn"));
		btnSubmit.click();

		// invalid
		WebElement invalCardNo = driver.findElement(By.id("invalid-card_no"));
		String text = invalCardNo.getText();
		System.out.println(text);
		
		
		// quit
		driver.quit();

	}

}
