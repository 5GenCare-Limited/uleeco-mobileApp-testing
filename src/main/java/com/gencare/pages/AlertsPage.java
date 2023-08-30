package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class AlertsPage extends BaseAutomationPage {

	public AlertsPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(AlertsPage.class.getName());

	public String getAlertsText() throws Exception {
		logger.info("starting of getAlertsText");
		logger.info("ending of getAlertsText");
		String alertsTittle = this.getContentDescValue( "txt.alerts");
		return alertsTittle;
	}
	
	public void clickOnAlertIcon( ) {
		logger.info("starting of clickOnAlertIcon");

		this.clickOnElementWithXpath("alert.icon");

		logger.info("starting of clickOnAlertIcon");
	}
}
