package com.omrbranch;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Test {

public static void main(String[] args) throws InterruptedException, AWTException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\SeleniumTest\\Driver1\\chromedriver.exe");
		//***
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //***
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		
		
		// login with username and password
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("angukarthikeyans@gmail.com");
		
		driver.findElement(By.id("pass")).sendKeys("Riyas@2301");
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
		loginBtn.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		//select state
		WebElement state = driver.findElement(By.id("state"));
		Select select = new Select(state);
		select.selectByValue("Tamil Nadu");
		
		//select city
		WebElement city = driver.findElement(By.id("city"));
		Select select1 = new Select(city);
		select1.selectByValue("Madurai");
		
		//select multiple room type
		WebElement roomType = driver.findElement(By.name("room_type[]"));
			
		Select selectOne = new Select(roomType);
		selectOne.selectByVisibleText("Deluxe");
		selectOne.selectByVisibleText("Standard");
		selectOne.selectByVisibleText("Suite");
	
		//check in date 
		WebElement checkInDate = driver.findElement(By.name("check_in"));
	
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','2023-04-18')", checkInDate);
		
		//checkout date
		WebElement checkOutDate = driver.findElement(By.name("check_out"));
		
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].setAttribute('value','2023-04-20')", checkOutDate);
		
	
		//no of rooms
		WebElement noOfRooms = driver.findElement(By.id("no_rooms"));
		Select select3 = new Select(noOfRooms);
		select3.selectByIndex(3);
		
		//no of adults
		WebElement noOfAdults = driver.findElement(By.id("no_adults"));
		
		Select select4 = new Select(noOfAdults);
		select4.selectByIndex(3);
		
		//no of children
		
		WebElement noOfChild = driver.findElement(By.id("no_child"));
		noOfChild.sendKeys("2");
	

		//search button click
		
		driver.switchTo().frame(0);
		
		WebElement search = driver.findElement(By.id("searchBtn"));
		search.click();
		
		 WebElement continueBtn = driver.findElement(By.xpath("(//a[text()='Continue'])[1]"));
		 continueBtn.click();
		 
		 driver.switchTo().alert().accept();
		
		//selecting room for myself
	
		WebElement myselfRadioBtn = driver.findElement(By.id("own"));
		myselfRadioBtn.click();
		
		//Mr/Mrs.
		WebElement title = driver.findElement(By.id("user_title"));
		Select select5 = new Select(title);
		select5.selectByIndex(1);
		
		//Booking Details
		
		WebElement firstName = driver.findElement(By.name("first_name"));
		firstName.sendKeys("Angukarthikeyan");
		
		WebElement lastName = driver.findElement(By.name("last_name"));
		lastName.sendKeys("Sundararajan");
		
		WebElement phone = driver.findElement(By.id("user_phone"));
		phone.sendKeys("9698806733");
		
		WebElement email = driver.findElement(By.id("user_email"));
		email.sendKeys("angukarthikeyans@gmail.com");
		
		//next page
		WebElement nextBtn = driver.findElement(By.id("step1next"));
		nextBtn.click();
		
		//Room Specifications
		WebElement specify = driver.findElement(By.id("high"));
        specify.click();
        
        
        WebElement request = driver.findElement(By.id("other_request"));
		request.sendKeys("Comfortable spacing rooms");
		
		
		//next page
		WebElement nextBtn2 = driver.findElement(By.id("step2next"));
		Thread.sleep(1000);
		nextBtn2.click();
		
		//credit card payment
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
        cardNo.sendKeys("5555555555552222");
        
        WebElement cardName = driver.findElement(By.id("card_name"));
        cardName.sendKeys("Angukarthikeyan S");
        
        WebElement cardMonth = driver.findElement(By.id("card_month"));
	    Select c = new Select(cardMonth);
	    c.selectByVisibleText("August");
	    
	    WebElement cardYear = driver.findElement(By.id("card_year"));
	    Select d = new Select(cardYear);
	    d.selectByVisibleText("2023");
	    
	    WebElement cardCvv = driver.findElement(By.id("cvv"));
	    cardCvv.sendKeys("865");
	    
	    WebElement btnSubmit = driver.findElement(By.id("submitBtn"));
	    btnSubmit.click();
	    
	    WebElement bookingID = driver.findElement(By.xpath("//h2[@name='booking-code']"));
	    
	    String Id = bookingID.getText();
		String[] split = Id.split(" ");
		String id = split[0];
		String BookingId = id.substring(1);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		WebElement welcomeBtn = driver.findElement(By.xpath("//a[@data-testid='username']"));
		welcomeBtn.click();
		
		WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount.click();
		
		WebElement searchBox = driver.findElement(By.name("search"));
		searchBox.sendKeys(BookingId);
		
		WebElement cancelBtn = driver.findElement(By.xpath("//a[text()='Cancel']"));
		cancelBtn.click();
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
//		WebElement CancellationMsg = driver.findElement(By.xpath("//li[text()='Your booking cancelled successfully']"));
//		String text = CancellationMsg.getText();
//
//		System.out.println(text);
	    


	// String text = bookingID.getText();
	// String[] split = text.split("0");
	//
	// String bookingid = null;
	// for (String f : split) {
	// bookingid = f.substring(1);
	// System.out.println(bookingid);
	// }
	//
	//
	// WebElement searchBooking = driver.findElement(By.xpath("//span[text()='Search
	// By Booking #']"));
	// searchBooking.sendKeys("bookingid");
	//
	// WebElement cancelBtn = driver.findElement(By.id("//a[text()='Cancel']"));
	// cancelBtn.click();
	//
	// driver.switchTo().alert().accept();
	//

	     

}

}
