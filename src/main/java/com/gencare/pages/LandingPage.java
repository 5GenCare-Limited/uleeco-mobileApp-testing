
package com.gencare.pages;

import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class LandingPage extends BaseAutomationPage {

	public LandingPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(LandingPage.class.getName());

	@FindBy(id = "com.android.permissioncontroller:id/permission_message")
	private WebElement txtAllowSalusSmartPremiumAccessDevicesToLocation;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement btnLocationAllowWhileUsingTheApp;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
	private WebElement btnLocationOnlyThisTime;

	@FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
	private WebElement btnLocationDontAllow;

	@FindBy(id = "com.android.permissioncontroller:id/permission_icon")
	private WebElement iconLocation;

	@FindBy(id = "com.android.permissioncontroller:id/permission_message")
	private WebElement txtAllowSalusSmartPremiumAccessToTakeVideo;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement btnVideoAllowWhileUsingTheApp;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
	private WebElement btnVideoOnlyThisTime;

	@FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
	private WebElement btnVideoDontAllow;

	@FindBy(id = "com.android.permissioncontroller:id/permission_icon")
	private WebElement iconVideo;

	@FindBy(xpath = "//android.view.View[@content-desc='Welcome to SALUS']")
	private WebElement lblWelcomeToSalus;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement lblSignIn;

	@FindBy(xpath = " //android.widget.Button[@content-desc = 'Demo']")
	private WebElement lblDemo;

	// @FindBy(xpath = "//android.widget.Button[@content-desc = 'Local WiFi mode']")
	// private WebElement btnLocaLWifiMode;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Sign up']")
	private WebElement lblSignUp;

	public void clickOnLocationWhileUsingThisAppBtnPopup() throws InterruptedException {
		logger.info("starting of clickOnLocationWhileUsingThisAppBtnPopup");

		Thread.sleep(2000);
		this.clickOnElementWithXpath("while.using.the.app");
		//this.clickOnElement("while.using.the.app");
		//this.btnLocationAllowWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationWhileUsingThisAppBtnPopup");
	}

	public void clickOnVideoWhileUsingThisAppBtnPopup() {

		logger.info("starting of clickOnVideoWhileUsingThisAppBtnPopup method");
		this.implicitWait();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.clickOnElementWithXpath("while.using.the.app");
		// this.btnVideoAllowWhileUsingTheApp.click();
		logger.info("starting of clickOnVideoWhileUsingThisAppBtnPopup method");

	}

	public String getWelcomeToSalusText() throws Exception {

		logger.info("Starting of getWelcomeToSalusText");
		logger.info("Ending of getWelcomeToSalusText");
		Thread.sleep(5000);
		String welcomeToSalusTittle = this.getContentDescValue("welcome.to.salus.text");
		return welcomeToSalusTittle;

		// System.out.println(lblWelcomeToSalus.getText());
		// return lblWelcomeToSalus.getAttribute("content-desc");
	}

	public String getSignInButtonText() {

		logger.info("starting of getSignInButtonText");
		logger.info("ending of getSignInButtonText");
		String signinButtonText = this.getContentDescValue("signin.button");
		return signinButtonText;
		// return lblSignIn.getAttribute("content-desc");

	}

	public String getDemoButtonText() {
		logger.info("starting of getDemoButtonText");
		logger.info("ending of getDemoButtonText");
		String demoButtonText = this.getContentDescValue("demo.button");
		return demoButtonText;
		// return lblDemo.getAttribute("content-desc");

	}

	/*
	 * public String getLocalWifiModeButtonText() {
	 * logger.info("starting of getLocalWifiModeButtonText");
	 * logger.info("ending of getLocalWifiModeButtonText");
	 * 
	 * return locaLWifiModeButton.getAttribute("content-desc");
	 * 
	 * }
	 */

	public String getSignUpButtonText() throws Exception {

		logger.info("starting of getSignUpButtonText");
		logger.info("ending of getSignUpButtonText");
		Thread.sleep(5000);
		String signUpButtonText = this.getContentDescValue("signup.button");
		return signUpButtonText;
		// return lblSignUp.getAttribute("content-desc");

	}

	public boolean isAllowSalusSmartPremiumToAccessThisDevicesLocationText() {

		logger.info("Starting of isAllowSalusSmartPremiumToAccessThisDevicesLocationText");
		logger.info("Ending of isAllowSalusSmartPremiumToAccessThisDevicesLocationText");

		return this.isDisplayed("access.this.device.location");
		//return txtAllowSalusSmartPremiumAccessDevicesToLocation.isDisplayed();
	}

	public String getAllowSalusSmartPremiumToTakePicturesAndRecordVideoText() {

		logger.info("Starting of getAllowSalusSmartPremiumToTakePicturesAndRecordVideoText");
		logger.info("Ending of getAllowSalusSmartPremiumToTakePicturesAndRecordVideoText");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(txtAllowSalusSmartPremiumAccessToTakeVideo.getText());
		return this.getTextValueWithXpath("salus.pictures.record.video");
		//return txtAllowSalusSmartPremiumAccessToTakeVideo.getText();
	}

	public String getLocationWhileUsingTheAppText() {
		logger.info("Starting of getLocationWhileUsingTheAppText");
		logger.info("Ending of getLocationWhileUsingTheAppText");
		
		//System.out.println(btnLocationAllowWhileUsingTheApp.getText());
		return this.getTextValueWithXpath("allow.access.to.permission");
		//return btnLocationAllowWhileUsingTheApp.getText();
	}

	public String getLocationOnlyThisTimeText() {
		logger.info("Starting of getLocationOnlyThisTimeText");
		logger.info("Ending of getLocationOnlyThisTimeText");
		
		//System.out.println(btnLocationOnlyThisTime.getText());
		//return btnLocationOnlyThisTime.getText();
		return this.getTextValueWithXpath("only.this.time");
	}

	public boolean isLocationDontAllowButton() throws InterruptedException {
		logger.info("Starting of isLocationDontAllowButton");
		
		Thread.sleep(2000);
		
		logger.info("Ending of isLocationDontAllowButton");
		
		//return btnLocationDontAllow.isDisplayed();
		return this.isDisplayed("do.not.allow");
	}

	public String getVideoWhileUsingTheAppText() {

		logger.info("Starting of getVideoWhileUsingTheAppText");
		logger.info("Ending of getVideoWhileUsingTheAppText");
		
		//System.out.println(txtAllowSalusSmartPremiumAccessToTakeVideo.getText());
		//return btnLocationAllowWhileUsingTheApp.getText();
		return this.getTextValueWithXpath("allow.access.to.permission");
	}

	public String getVideoOnlyThisTimeText() {

		logger.info("Starting of getLocationOnlyThisTimeText");
		logger.info("Ending of getLocationOnlyThisTimeText");
		//System.out.println(btnLocationOnlyThisTime.getText());
		//return btnLocationOnlyThisTime.getText();
		return this.getTextValueWithXpath("only.this.time");
	}

	public boolean isVideoDontAllowButton() {

		logger.info("Starting of isVideoDontAllowButton");
		logger.info("Ending of isVideoDontAllowButton");

		return this.isDisplayed("do.not.allow");
	}

	public boolean isDisplyLocationIcon() {

		logger.info("Starting of isDisplyLocationIcon method");
		logger.info("Ending of isDisplyLocationIcon method");

		return iconLocation.isDisplayed();

	}

	public boolean isDisplyVideoIcon() {

		logger.info("Starting of isDisplyVideoIcon method");
		logger.info("Ending of isDisplyVideoIcon method");

		return iconVideo.isDisplayed();

	}

}
