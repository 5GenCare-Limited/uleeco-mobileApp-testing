package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.mongodb.connection.Connection;

import io.appium.java_client.android.AndroidDriver;

public class NoInternetPopupPage extends BaseAutomationPage {

	public NoInternetPopupPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	private static final Logger logger = Logger.getLogger(NoInternetPopupPage.class.getName());

	public String getNoInternetPopuUpText() {
		logger.info("starting of getNoInternetPopuUpText");
		logger.info("ending of getNoInternetPopuUpText");
		
		String noInternetPopuUpText = this.getContentDescValueWithXPath("txt.no.internet.popup");
		return noInternetPopuUpText;
	}
	
	public String getLogoutText() {
		logger.info("starting of getLogoutText");
		logger.info("ending of getLogoutText");
		
		String logoutText = this.getContentDescValueWithXPath("btn.logout.nointernet");
		return logoutText;
	}
}
