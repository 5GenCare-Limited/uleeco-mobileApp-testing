package com.gencare.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SignUpAssertionsPage extends BaseAutomationPage {

	public SignUpAssertionsPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(SignUpAssertionsPage.class.getName());

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement btnAllowWhileUsingTheApp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Sign up']")
	private WebElement btnSignUp;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='English']")
	private WebElement lblLanguage;

	@FindBy(xpath = "//android.widget.EditText[@text = 'First Name']")
	private WebElement lblFirstName;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Last Name']")
	private WebElement lblLastName;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email Address']")
	private WebElement lblEmailAddress;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Confirm Email Address']")
	private WebElement lblConfirmEmailAddress;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement lblPassword;

	@FindBy(xpath = "//android.view.View[@content-desc='Passwords must be between 8 and 14 characters long and must include one numeric character (0 - 9) or symbol, one lowercase (a - z), and one uppercase (A - Z).']")
	private WebElement lblvalidationPassword;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Confirm new password']")
	private WebElement lblConfirmNewPassword;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Country']")
	private WebElement lblCountrySelection;

	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement lblMobileNumber;

	@FindBy(xpath = "//android.view.View[4]")
	private WebElement lblTermsAndConditions;

	@FindBy(xpath = "//android.view.View[6]")
	private WebElement lblPrivacyNotice;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Yes']")
	private WebElement lblYes;

	@FindBy(xpath = "//android.view.View[@content-desc = 'No']")
	private WebElement lblNo;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Create my profile']")
	private WebElement lblCreateMyProfile;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement lblCancelButton;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.clickOnElement("btn.allow.while.using.app.signup");
		//this.btnAllowWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickOnAllowVideoPopup() {

		logger.info("starting of clickOnAllowVideoPopup method");

		this.implicitWait();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.clickOnElement("btn.allow.while.using.app.signup");
		//this.btnAllowWhileUsingTheApp.click();

		logger.info("starting of clickOnAllowVideoPopup method");

	}

	public void clickOnSignUpButton() throws Exception {
		logger.info("starting of signUp method");

		this.clickOnElementWithXpath("signup.button.signup");
		//this.btnSignUp.click();

		logger.info("ending of signUp method");

	}

	public void scrollToPasswordText() throws InterruptedException {
		logger.info("starting of scrollToPasswordText method");
		
		this.verticalScroll2();
		
		logger.info("ending of scrollToPasswordText method");
	}

	public String getLanguageChangeButtonText() throws Exception {
		logger.info("starting of getLanguageChangeButtonText");
		logger.info("ending of getLanguageChangeButtonText");

		return this.getContentDescValueWithXPath("drpwn.language.viewprofile");
		//return lblLanguage.getAttribute("content-desc");
	}

	public String getFirstNameText() {
		logger.info("starting of getFirstNameText");
		logger.info("ending of getFirstNameText");

		return this.getTextValueWithXpath("txt.first.name.signup");
		//return lblFirstName.getAttribute("text");

	}

	public String getLastNameText() {
		logger.info("starting of getLastNameText");
		logger.info("ending of getLastNameText");

		return this.getTextValueWithXpath("txt.last.name.signup");
		//return lblLastName.getAttribute("text");
	}

	public String getEmailAddressText() {
		logger.info("starting of getEmailText");
		logger.info("ending of getEmailText");

		return this.getTextValueWithXpath("txt.email.address.signup");
		//return lblEmailAddress.getAttribute("text");

	}

	public String getConfirmEmailAddressText() {

		logger.info("Starting of getConfirmEmailAddress Method");
		logger.info("Ending of getConfirmEmailAddress Method");

		return this.getTextValueWithXpath("txt.confirmemail.address.signup");
		//return lblConfirmEmailAddress.getAttribute("text");

	}

	public String getPasswordText() {
		logger.info("starting of getPasswordText");
		logger.info("ending of getPasswordText");

		return this.getTextValueWithXpath("txt.password.signup");
		//return lblPassword.getAttribute("text");
	}

	public String getValidationPasswordText() {
		logger.info("starting of getValidationPasswordText");
		logger.info("ending of getValidationPasswordText");

		return this.getContentDescValueWithXPath("lbl.validation.password.signup");
		//return lblvalidationPassword.getAttribute("content-desc");
	}

	public String getConfirmNewPasswordText() {
		logger.info("starting of getConfirmNewPasswordText");
		logger.info("ending of getConfirmNewPasswordText");

		return this.getTextValueWithXpath("txt.confirm.password.signup");
		//return lblConfirmNewPassword.getAttribute("text");
	}

	public String getCountrySelectionText() throws Exception {
		logger.info("starting of getCountrySelectionText");
		logger.info("ending of getCountrySelectionText");

		return this.getContentDescValueWithXPath("txt.drpwn.country.viewprofile");
		//return lblCountrySelection.getAttribute("content-desc");
	}

	public String getMobileNumberText() {
		logger.info("starting of getMobileNumberText");
		logger.info("ending of getMobileNumberText");

		return this.getTextValueWithXpath("btn.newmobile.number.vwprofile");
		//return lblMobileNumber.getText();
		// return lblMobileNumber.getAttribute("text").substring(4, 17);
	}

	public String getTermsAndConditionsText() throws Exception {
		logger.info("starting of getTermsAndConditionsText");
		logger.info("ending of getTermsAndConditionsText");
		
		// lblTermsAndConditions.getText().substring(25, 42);
		//System.out.println(this.getContentDescValueWithXPath("lbl.terms.and.conditions.signup"));
		return this.getContentDescValueWithXPath("lbl.terms.and.conditions.signup");
		
		 
		//return lblTermsAndConditions.getAttribute("content-desc");
	}

	public String getPrivacyNoticeText() throws Exception {
		logger.info("starting of getPrivacyNoticeText");
		logger.info("ending of getPrivacyNoticeText");

		return this.getContentDescValueWithXPath("lbl.privacy.notice.signup");
		//return lblPrivacyNotice.getAttribute("content-desc");
	}

	public String getYesRadioButtonText() {
		logger.info("starting of getYesRadioButtonText");
		logger.info("ending of getYesRadioButtonText");

		return this.getContentDescValueWithXPath("lbl.yes.signup");
		//return lblYes.getAttribute("content-desc");
	}

	public String getNoRadioButtonText() {
		logger.info("starting of getYesRadioButtonText");
		logger.info("ending of getYesRadioButtonText");

		return this.getContentDescValueWithXPath("lbl.no.signup");
		//return lblNo.getAttribute("content-desc");
	}

	public String getCreateMyProfileText() {
		logger.info("starting of getCreateMyProfileText");
		logger.info("ending of getCreateMyProfileText");

		return this.getContentDescValueWithXPath("btn.create.myprofile");
		//return lblCreateMyProfile.getAttribute("content-desc");
	}

	public String getCancelButtonText() {
		logger.info("starting of getCancelButtonText");
		logger.info("ending of getCancelButtonText");

		return this.getContentDescValueWithXPath("btn.cancel.vwprofile");
		//return lblCancelButton.getAttribute("content-desc");
	}

}
