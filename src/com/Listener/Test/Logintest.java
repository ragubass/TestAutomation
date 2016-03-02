package com.Listener.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Logintest {

	public WebDriver driver;

	public Logintest() {

		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("Selenium");

		Properties.driver = new FirefoxDriver(myprofile);
		driver = Properties.driver;
	}

	@Test(priority = 0)
	public void verifytextsucess() {
		driver.get("http://www.gmail.com");
		// Verify the heading is correct
		WebElement text = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/h1"));
		String Heading = text.getText();
		System.out.println(Heading);
		Assert.assertEquals(Heading, "One account. All of Google.");
	}

	@Test(priority = 1)
	public void loginfail() {
		// This test will fail because there is no signin webelement
		driver.get("http://www.gmail.com");
		driver.findElement(By.name("Email")).sendKeys("ragubass.com");
		driver.findElement(By.name("Passwd")).sendKeys("smartboys");
		// signin webelement is not present
		driver.findElement(By.name("signin")).click();

	}

	@AfterTest
	public void endtest() {
		driver.quit();
	}

}
