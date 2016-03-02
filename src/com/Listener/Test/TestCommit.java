package com.Listener.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class TestCommit {
	
	public static void main(String[] args) {
		
		ProfilesIni profile = new ProfilesIni();

		FirefoxProfile myprofile = profile.getProfile("Selenium");
		
		WebDriver driver= new FirefoxDriver(myprofile);
	
		driver.get("https://www.google.co.in/?gws_rd=ssl");
		
	}

}
