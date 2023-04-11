package com.omrbranch;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class OMRSortBy {

	public static void main(String[] args) throws AWTException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\sample program\\OmrBranch\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("angukarthikeyans@gmail.com");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("Akkn@0597");
		WebElement BtnLogin = driver.findElement(By.xpath("//button[text()='Login']"));
		BtnLogin.click();

		WebElement txtState = driver.findElement(By.id("state"));
		Select select = new Select(txtState);
		select.selectByValue("Tamil Nadu");

		WebElement txtCity = driver.findElement(By.id("city"));
		Select dddistSelect = new Select(txtCity);
		dddistSelect.selectByIndex(1);

		WebElement DDNRoomType = driver.findElement(By.xpath("//textarea[@placeholder='Select Room Type']"));

		DDNRoomType.sendKeys("Standard");
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);

		WebElement DDNCheckInDate = driver.findElement(By.name("check_in"));
		JavascriptExecutor executer = (JavascriptExecutor) driver;
		executer.executeScript("arguments[0].setAttribute('value','2023-04-20')", DDNCheckInDate);

		WebElement DDNCheckOutDate = driver.findElement(By.name("check_out"));
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].setAttribute('value','2023-04-28')", DDNCheckOutDate);

		WebElement DDNRoomNo = driver.findElement(By.id("no_rooms"));
		Select room1 = new Select(DDNRoomNo);
		room1.selectByValue("2");

		WebElement DDNAdult = driver.findElement(By.id("no_adults"));
		Select ddadult = new Select(DDNAdult);
		ddadult.selectByValue("2");

		WebElement txtChildNo = driver.findElement(By.id("no_child"));
		txtChildNo.sendKeys("0");

		driver.switchTo().frame(0);

		WebElement btnSearch = driver.findElement(By.id("searchBtn"));
		btnSearch.click();

		WebElement sortBy = driver.findElement(By.xpath("//label[text()='Price low to high']"));
		sortBy.click();

		WebElement BtnContinue = driver.findElement(By.xpath("(//a[text()='Continue'])[1]"));
		BtnContinue.click();

		driver.switchTo().alert().accept();

		// selecting room for myself

		Thread.sleep(1000);
		WebElement rdoMyself = driver.findElement(By.id("own"));
		rdoMyself.click();

		// Mr/Mrs.
		WebElement ddnSalutation = driver.findElement(By.id("user_title"));
		Select select5 = new Select(ddnSalutation);
		select5.selectByIndex(1);

		// Booking Details

		WebElement txtFirstName = driver.findElement(By.name("first_name"));
		txtFirstName.sendKeys("Angukarthikeyan");

		WebElement txtLastName = driver.findElement(By.name("last_name"));
		txtLastName.sendKeys("Sundararajan");

		WebElement txtPhone = driver.findElement(By.id("user_phone"));
		txtPhone.sendKeys("9698806733");

		WebElement txtEmail = driver.findElement(By.id("user_email"));
		txtEmail.sendKeys("angukarthikeyans@gmail.com");

		// next page
		WebElement btnNext = driver.findElement(By.id("step1next"));
		btnNext.click();

		// Room Specifications
		WebElement chkSpecify = driver.findElement(By.id("high"));
		chkSpecify.click();

		WebElement txtRequest = driver.findElement(By.id("other_request"));
		txtRequest.sendKeys("Large Space");

		Thread.sleep(1000);

		// next page	
		WebElement btnNext2 = driver.findElement(By.id("step2next"));
		Thread.sleep(1000);
		btnNext2.click();

		// credit card payment
		WebElement btnCreditDetails = driver.findElement(By.xpath("//h5[text()='Credit/Debit/ATM Card']"));
		btnCreditDetails.click();

		Thread.sleep(1000);

		WebElement ddnPaymentType = driver.findElement(By.id("payment_type"));
		Select a = new Select(ddnPaymentType);
		a.selectByVisibleText("Debit Card");

		WebElement ddnCardType = driver.findElement(By.id("card_type"));
		Select b = new Select(ddnCardType);
		b.selectByVisibleText("Visa");

		WebElement txtCardNo = driver.findElement(By.id("card_no"));
		txtCardNo.sendKeys("5555555555552222");

		WebElement txtCardName = driver.findElement(By.id("card_name"));
		txtCardName.sendKeys("Angukarthikeyan_s");

		WebElement txtCardMonth = driver.findElement(By.id("card_month"));
		Select c = new Select(txtCardMonth);
		c.selectByVisibleText("August");

		WebElement txtCardYear = driver.findElement(By.id("card_year"));
		Select d = new Select(txtCardYear);
		d.selectByVisibleText("2023");

		WebElement txtCardCvv = driver.findElement(By.id("cvv"));
		txtCardCvv.sendKeys("786");

		WebElement btnSubmit = driver.findElement(By.id("submitBtn"));
		btnSubmit.click();

		WebElement bookingID = driver.findElement(By.xpath("//h2[@name='booking-code']"));
		String text2 = bookingID.getText();
		String[] split = text2.split(" ");
		String id = split[0];
		String substring = id.substring(1);

		WebElement welcomeMsg = driver.findElement(By.xpath("//a[@data-testid='username']"));
		welcomeMsg.click();

		WebElement myAccount = driver.findElement(By.xpath("//a[text()='My Account']"));
		myAccount.click();

		WebElement txtSearchBox = driver.findElement(By.name("search"));
		txtSearchBox.sendKeys(substring);

		WebElement btnEdit = driver.findElement(By.xpath("(//button[text()='Edit'])"));
		Thread.sleep(1000);
		btnEdit.click();

		WebElement change_Checkin_date = driver.findElement(By.name("check_in"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','2023-04-16')", change_Checkin_date);

		WebElement confirmBtn = driver.findElement(By.xpath("//button[text()='Confirm']"));
		confirmBtn.click();

		WebElement EditMsg = driver.findElement(By.xpath("//li[text()='Booking updated successfully']"));
		String text = EditMsg.getText();
		System.out.println(text);

	}

}
