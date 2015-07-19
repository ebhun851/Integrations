package com.dev.home;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

@RunWith(MockitoJUnitRunner.class)
public class LoginPageTest {
	
	@Test
	public void loginUser(){
//		WebDriver driver = new FirefoxDriver();
		
		HtmlUnitDriver driver = new HtmlUnitDriver();
        
        driver.get("https://www.facebook.com/");
        
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("khaju.mca@gmail.com");
        
        
        WebElement password = driver.findElement(By.className("pass"));
        
        password.sendKeys("khaju99129");
        
        WebElement loginButton = driver.findElement(By.id("u_0_n"));
        loginButton.click();
        
        
        WebElement Identity = driver.findElement(By.className("fbxWelcomeBoxName"));
        String logoText = Identity.getText();
        
        assertEquals(logoText,"Khajabi M Mitayegar");
        
        
      /*  WebElement editProfile = driver.findElement(By.linkText("https://www.facebook.com/khajabim.mitayegar/about?ref=home_edit_profile&section=work"));
        String editProfileText = editProfile.getText();
        System.out.println(editProfileText);*/
        
       /* String pageSource = driver.getPageSource();
        boolean isPresent =pageSource.contains("Edit Profile");
        
        Select daySelect = new Select(driver.findElement(By.id("designation")));
        daySelect.selectByValue("25");
        
        assertTrue(isPresent);*/
        driver.quit();
	}
//	https://www.facebook.com/khajabim.mitayegar/about?ref=home_edit_profile&section=work
//	https://www.facebook.com/khajabim.mitayegar/about?ref=home_edit_profile&section=work
//		
	@Ignore
	public void loginUser1(){
		WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.facebook.com/");
        
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("khaju.mca@gmail.com");
        
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("khaju99129");
        
        WebElement loginButton = driver.findElement(By.id("u_0_n"));
        loginButton.click();
        
        
        WebElement Identity = driver.findElement(By.className("html7magic"));
        String logoText = Identity.getText();
        
        assertEquals(logoText,"Email or Phone");
        
        driver.quit();
	}
}
