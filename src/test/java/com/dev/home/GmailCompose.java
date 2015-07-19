package com.dev.home;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailCompose {
	
	@Test
	public void loginAndCompose() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		
		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.id("Email"));
		userName.sendKeys("ebhun.851@gmail.com");
		
		WebElement pwd = driver.findElement(By.id("Passwd"));
		pwd.sendKeys("B91777khaju");
		
		WebElement loginButton = driver.findElement(By.id("signIn"));
		loginButton.click();	
		
		Thread.sleep(10000);
		
		WebElement composeButton = driver.findElement(By.xpath(".//*[@id=':jb']/div/div"));
		composeButton.click();	
		
		Thread.sleep(10000);
		
		
		TargetLocator locator= driver.switchTo();
		WebElement receiver = locator.activeElement();
		receiver.sendKeys("ebhun.851@gmail.com");
		
		receiver.sendKeys(Keys.ENTER);
		
		locator.activeElement().sendKeys(Keys.TAB);
		
		WebElement subject = locator.activeElement();
		subject.sendKeys("Test email");
		
		locator.activeElement().sendKeys(Keys.TAB);
		
		WebElement emailBody = locator.activeElement();
		emailBody.sendKeys("Test email to check in sent email");
		
		
		locator.activeElement().sendKeys(Keys.TAB);
		
		WebElement sendButton = locator.activeElement();
		sendButton.click();
		Thread.sleep(10000);
		
		driver.navigate().refresh();
		
		Thread.sleep(10000);
		
		/*WebElement sentEmailLink = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/u/0/#sent']"));
		sentEmailLink.click();*/
		
		List<WebElement> getEmails = driver.findElements(By.xpath(".//td[@class='yX xY']"));
		
		System.out.println(getEmails.size());
		
		Thread.sleep(10000);
		
		driver.quit();
	}
}
