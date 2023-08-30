
package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class SignoutPage extends BaseAutomationPage {

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement signInbutton;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement emailfield;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement passwordfield;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement LogInSignInButton;

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement menuicon;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Equipment']")
	private WebElement equipment;

	// @FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Users and
	// Permissions']")
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

	@FindBy(xpath = "//android.view.View[@content-desc = 'All equipment']")
	private WebElement allEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'OneTouch']")
	private WebElement oneTouch;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Gateways']")
	private WebElement gateways;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Users']")
	private WebElement users;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Profile']")
	private WebElement profile;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Change Password']")
	private WebElement changePassword;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Setup Equipment']")
	private WebElement setupEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'FAQ']")
	private WebElement faq;

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement btnHamburgerMenu;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Contact Support']")
	private WebElement ContactSupport;

	@FindBy(xpath = "//android.view.View[@content-desc = 'About This App']")
	private WebElement AboutThisApp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Privacy notice']")
	private WebElement privacyNotice;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Terms & conditions']")
	private WebElement termsAndConditions;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	private static final Logger logger = Logger.getLogger(SignoutPage.class.getName());

	public SignoutPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	public void displayHumBurgerMenu() {
		logger.info("starting of displayHumBurgerMenu");

		this.clickOnElement("hamburgermenu.button");
		// this.btnHamburgerMenu.isDisplayed();

		logger.info("ending of displayHumBurgerMenu");
	}

	public void clickOnHamburgerMenu() throws Exception {

		logger.info("starting of ClickingOnMenuIcon");

		Thread.sleep(15000);
		this.clickOnElement("hamburgermenu.button");
		// this.btnHamburgerMenu.click();

		logger.info("ending of ClickingOnMenuIcon");
	}

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.clickOnElement("while.using.the.app");
		// this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickOnSignInButton() {

		logger.info("starting of ClickingOnSignInButton");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.clickOnElement("signin.button");
		// this.signInbutton.click();

		logger.info("ending of ClickingOnSignInButton");
	}

	public void enterEmailField(String email) {
		logger.info("starting of ClickingAndEnterEmailField");

		this.setValueWithoutClear("email.text", email);
//		this.emailfield.click();
//		this.emailfield.sendKeys(email);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterEmailField");
	}

	public void enterPasswordField(String password) {
		logger.info("starting of ClickingAndEnterPasswordField");

		this.setValueWithoutClear("password.text", password);
//		this.passwordfield.click();
//		this.passwordfield.sendKeys(password);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterPasswordField");
	}

	public void clickOnLogInButton() {

		logger.info("starting of ClickingOnLogInSignInButton");
		try {
			Thread.sleep(1000);
			this.clickOnElement("signin.button");
			// this.LogInSignInButton.click();
		} catch (Exception e) {
		}
		logger.info("ending of ClickingOnLogInSignInButton");
	}

	public void clickOnMenu() {
		logger.info("starting of ClickingOnMenuIcon");
		try {
			Thread.sleep(15000);
			this.clickOnElement("menu.icon");
			 //this.menuicon.click();
		} catch (Exception e) {
		}

		logger.info("ending of ClickingOnMenuIcon");
	}

	public String getEquipmentText() {
		logger.info("starting of getEquipmentText");

		// System.out.println(equipment.getAttribute("content-desc"));

		logger.info("ending of getEquipmentText");

		return this.getContentDescValue("equipment.button");
		 //return equipment.getAttribute("content-desc");

	}

	public String getUsersAndPermissionsText() {
		logger.info("starting of getUsersAndPermissionsText");
		logger.info("ending of getUsersAndPermissionsText");

		return this.getContentDescValue("users.and.permissions.button");
	 //return UsersAndPermissions.getAttribute("content-desc");
	}

	public String getSettingsText() {
		logger.info("starting of getSettingsText");
		logger.info("ending ofgetSettingsText");

		return this.getContentDescValue("settings.button");
		// return settings.getAttribute("content-desc");

	}

	public String getHelpText() {
		logger.info("starting of getHelpText");
		logger.info("ending of getHelpText");

		return this.getContentDescValue("help.button");
		// return help.getAttribute("content-desc");

	}

	public String getLegalText() {
		logger.info("starting of getLegalText");
		logger.info("ending of getLegalText");

		return this.getContentDescValue("legal.button");
		// return legal.getAttribute("content-desc");
	}

	public String getLogoutText() {
		logger.info("starting of getLogoutText");
		logger.info("ending of getLogoutText");

		return this.getContentDescValue("");
		// return logout.getAttribute("content-desc");

	}

	public void clickOnEquipmentButton() {
		logger.info("starting of clickOnEquipmentButton");

		this.clickOnElement("logout.button");
		// this.equipment.click();

		logger.info("starting of clickOnEquipmentButton");
	}

	public String getAllEquipmentText() {
		logger.info("starting of getAllEquipmentText");
		logger.info("ending of getAllEquipmentText");

		return this.getContentDescValue("all.equipment.button");
		// return allEquipment.getAttribute("content-desc");
	}

	public String getoneTouchText() {
		logger.info("starting of getoneTouchText");
		logger.info("ending of getoneTouchText");

		return this.getContentDescValue("onetouch.button");
		// return oneTouch.getAttribute("content-desc");
	}

	public String getGatewaysText() {
		logger.info("starting of getGatewaysText");
		logger.info("ending of getGatewaysText");

		return this.getContentDescValue("gateway.button");
		// return gateways.getAttribute("content-desc");
	}

	public void closeEquipmentDropDown() {
		logger.info("starting of closeEquipmentDropDown");

		this.clickOnElement("equipment.button");
		 this.equipment.click();

		logger.info("ending of closeEquipmentDropDown");

	}

	public void clickOnSettings() {
		logger.info("starting of clickOnSettings");

		this.clickOnElement("settings.button");
		// this.settings.click();

		logger.info("ending of clickOnSettings");
	}

	public String getProfileText() {
		logger.info("starting of getProfileText");
		logger.info("ending of getProfileText");

		return this.getContentDescValue("profile.button");
		//return profile.getAttribute("content-desc");
	}

	public String getChangePasswordText() {
		logger.info("starting of getChangePasswordText");
		logger.info("ending of getChangePasswordText");

		return this.getContentDescValue("change.password.button");
		// return changePassword.getAttribute("content-desc");

	}

	public String getSetupEquipmentText() {
		logger.info("starting of getSetupEquipmentText");
		logger.info("ending of getSetupEquipmentText");

		return this.getContentDescValue("setup.equipment.button");
		// return setupEquipment.getAttribute("content-desc");

	}

	public void closeSettingsDropDown() {
		logger.info("starting of closeSettingsDropDown");

		this.clickOnElement("settings.button");
		// this.settings.click();

		logger.info("ending of closeSettingsDropDown");

	}

	public void clickOnHelpButton() {
		logger.info("starting of ClickingOnHelpButton");

		this.clickOnElement("help.button");
		// this.help.click();

		logger.info("ending of ClickingOnHelpButton");
	}

	public String getFAQText() {
		logger.info("starting of getFAQText");
		logger.info("ending of getFAQText");

		return this.getContentDescValue("faq.button");
		// return faq.getAttribute("content-desc");
	}

	public String getContactSupportText() {
		logger.info("starting of getContactSupportText");
		logger.info("ending of getContactSupportText");

		return this.getContentDescValue("contact.support.button");
		// return ContactSupport.getAttribute("content-desc");

	}

	public String getAboutThisAppText() {
		logger.info("starting of getAboutThisAppText");
		logger.info("ending of getAboutThisAppText");

		return this.getContentDescValue("about.this.app.button");
		// return AboutThisApp.getAttribute("content-desc");

	}

	public void closeHelpDropDown() {
		logger.info("starting of closeHelpDropDown");

		this.clickOnElement("help.button");
		// this.help.click();

		logger.info("ending of closeHelpDropDown");

	}

	public void clickOnLegalButton() {
		logger.info("starting of clickOnLegalButton");

		this.clickOnElement("legal.button");
		// this.legal.click();

		logger.info("starting of clickOnLegalButton");
	}

	public String getPrivacyNoticeText() {
		logger.info("starting of getPrivacyNoticeText");
		logger.info("ending of getPrivacyNoticeText");

		return this.getContentDescValue("");
		// return privacyNotice.getAttribute("content-desc");

	}

	public String getTermsAndConditionsText() {
		logger.info("starting of getTermsAndConditionsText");
		logger.info("ending of getTermsAndConditionsText");

		return this.getContentDescValue("privacy.notice");
		// return termsAndConditions.getAttribute("content-desc");

	}

	public void closeLegalDropDown() {
		logger.info("starting of closeLegalDropDown");

		this.clickOnElement("legal.button");
		// this.legal.click();
		logger.info("ending of closeLegalDropDown");

	}

	public void clickOnLogout() {
		logger.info("starting of clickOnLogout");

		this.clickOnElement("logout.button");
		// this.logout.click();

		logger.info("ending of clickOnLogout");

	}
}
