
package com.gencare.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;
import io.appium.java_client.android.AndroidDriver;

public class LogoutPage extends BaseAutomationPage {

	public LogoutPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(LogoutPage.class.getName());

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement HamburgerMenuBtn;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Equipment']")
	private WebElement equipment;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Users and Permissions']")
	private WebElement UsersAndPermissions;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Settings']")
	private WebElement settings;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Help']")
	private WebElement help;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Legal']")
	private WebElement legal;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Logout']")
	private WebElement logout;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Welcome to SALUS']")
	private WebElement welComeToSalus;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement signInButton;

	@FindBy(xpath = " //android.widget.Button[@content-desc = 'Demo']")
	private WebElement demoButton;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Local WiFi mode']")
	private WebElement locaLWifiModeButton;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Sign up']")
	private WebElement signUp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Welcome to SALUS']")
	private WebElement welcomeToSalus;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;
	
	public void clickOnHamBurgerMenuBtn() throws Exception {
		logger.info("starting of ClickingOnMenuIcon");
		
		Thread.sleep(10000);
		this.clickOnElementWithXpath("hamburgermenu.button");
	//	this.HamburgerMenuBtn.click();
		
		logger.info("ending of ClickingOnMenuIcon");
	}

	public String getEquipmentText() {
		logger.info("starting of getEquipmentText");
		logger.info("ending of getEquipmentText");
		
		String equipmentText = this.getContentDescValue("equipment.button");
		return equipmentText;
	//	return equipment.getAttribute("content-desc");

	}

	public String getUsersAndPermissionsText() {
		logger.info("starting of getUsersAndPermissionsText");
		logger.info("ending of getUsersAndPermissionsText");
		
		String usersAndPermissionsText = this.getContentDescValue("users.and.permissions.button");
		return usersAndPermissionsText;
		//return UsersAndPermissions.getAttribute("content-desc");
	}

	public String getSettingsText() {
		logger.info("starting of getSettingsText");
		logger.info("ending ofgetSettingsText");
		
		String settingsText = this.getContentDescValue("settings.button");
		return settingsText;
	//	return settings.getAttribute("content-desc");

	}

	public String getHelpText() {
		logger.info("starting of getHelpText");
		logger.info("ending of getHelpText");
		
		String helpText = this.getContentDescValue("help.button");
		return helpText;
	//	return btnHelp.getAttribute("content-desc");

	}

	public String getLegalText() {
		logger.info("starting of getLegalText");
		logger.info("ending of getLegalText");
		
		String legalText = this.getContentDescValue("legal.button");
		return legalText;
	//	return btnLegal.getAttribute("content-desc");
	}

	public String getLogoutText() {
		logger.info("starting of getLogoutText");
		
		this.verticalScroll();
		
		logger.info("ending of getLogoutText");
		
		String logoutText = this.getContentDescValue("logout.button");
		return logoutText;
		//return btnLogout.getAttribute("content-desc");

	}
	public void clickOnLogoutBtn() throws Exception {		
		logger.info("starting of getLogoutText");
		
		this.clickOnElementWithXpath("logout.button");
		//this.logout.click();
		
		logger.info("ending of getLogoutText");
	}


	public String getSignInButtonText()  {
		logger.info("starting of getSignInButtonText");
		logger.info("ending of getSignInButtonText");
		
		String signinButtonText = this.getContentDescValue("signin.button");
		return signinButtonText;
		//return lblSignIn.getAttribute("content-desc");

	}

	public String getDemoButtonText() {
		logger.info("starting of getDemoButtonText");
		logger.info("ending of getDemoButtonText");
		
		String demoButtonText = this.getContentDescValue("demo.button");
		return demoButtonText;
		//return lblDemo.getAttribute("content-desc");

	}
	public String getLocalWifiModeButtonText() {
		logger.info("starting of getLocalWifiModeButtonText");
		logger.info("ending of getLocalWifiModeButtonText");
		
		return this.getContentDescValue("local.wifi.mode");
		//return locaLWifiModeButton.getAttribute("content-desc");

	}

	public String getSignUpButtonText() {
		logger.info("starting of getSignUpButtonText");
		logger.info("ending of getSignUpButtonText");
		
		String signupButtonText = this.getContentDescValue("signup.button");
		return signupButtonText;
	//	return signUp.getAttribute("content-desc");

	}
	public String getWelcomeToSalusText() {
		logger.info("starting of getSignUpButtonText");
		logger.info("ending of getSignUpButtonText");
		
		String welcomSalusLbl = this.getContentDescValue("welcome.to.salus.text");
		return welcomSalusLbl;
		//return welcomeToSalus.getAttribute("content-desc");

	}
}
