package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class SignInPage extends BaseAutomationPage {

	public SignInPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(SignInPage.class.getName());

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnSignin;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement txtEmailfield;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement txtPasswordfield;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnLogIn;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Keep me logged in\"]")
	private WebElement chkKeepMeLoggedIn;

	@FindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])[1]")
	private WebElement txtEmailThisFieldIsRequired;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Your password or email address is incorrect. Please try again.\"]")
	private WebElement txtYourPasswordOrEmailIncorrect;

	@FindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])[2]")
	private WebElement txtPasswordThisFieldIsRequired;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement txtWrongEmail;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");
		
		this.clickOnElement("while.using.the.app");
		//this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickOnSignInButton() {
		logger.info("starting of ClickingOnSignInButton");

		try {
			this.clickOnElement("signin.button");
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("ending of ClickingOnSignInButton");
	}

	public void enterEmailField(String email) {
		logger.info("starting of ClickingAndEnterEmailField");
		
		this.setValueWithClearWithXpath("email.text", email);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterEmailField");
	}
	
	public void setEmailField(String email) {
		logger.info("starting of ClickingAndEnterEmailField");
		
		this.setValueWithClearWithXpath("text.email", email);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterEmailField");
	}

	public void enterPasswordField(String password) {
		logger.info("starting of ClickingAndEnterPasswordField");

		this.setValueWithClearWithXpath("password.text", password);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterPasswordField");
	}
	
	public void setPasswordField(String password) {
		logger.info("starting of setPasswordField method");

		this.setValueWithClearWithXpath("text.password", password);
		driver.hideKeyboard();

		logger.info("ending of setPasswordField method");
	}
	public void clickAndClearPasswordEmail() throws Exception {
		logger.info("starting of clickAndClearPasswordEmail");
		
		this.setValueWithClearWithXpath("email.text", platform);
		this.setValueWithClearWithXpath("password.text",platform);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterEmailField");
	}


	public void enterInvalidPasswordField(String invaliduseremail) throws Exception {
		logger.info("starting of ClickingAndEnterPasswordField");

		this.setValueWithClear("password.text", invaliduseremail);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterPasswordField");
	}

	public void clickOnLogInButton() {
		logger.info("starting of ClickingOnLogInSignInButton");

		try {
			this.clickOnElement("login.button");
			} catch (Exception e) {
		}

		logger.info("ending of ClickingOnLogInSignInButton");
	}

	public String getKeepMeLoggedInText() throws Exception {
		logger.info("starting of getKeepMeLoggedInText");
		logger.info("ending of getKeepMeLoggedInText");
		
		String keepmelogin = this.getContentDescValueWithXPath("keep.me.loggedin.text");
		return keepmelogin;

	}

	public String getEmailThisFieldIsRequiredText() throws Exception {
		logger.info("starting of getEmailThisFieldIsRequiredText");
		logger.info("ending of getEmailThisFieldIsRequiredText");

		String emailThisfirldrequired = this.getElementValueWithXpath("email.this.field.required");
		return emailThisfirldrequired;

	}

	public String getPasswordThisFieldIsRequiredText() throws Exception {
		logger.info("starting of getPasswordThisFieldIsRequiredText");
		logger.info("ending of getPasswordThisFieldIsRequiredText");

		String emailThisfirldrequired = this.getElementValueWithXpath("password.this.field.required");
		return emailThisfirldrequired;

	}

	public String getYourEmailAndPasswordIsIncorrectText() throws Exception {
		logger.info("starting of getYourEmailAndPasswordIsIncorrectText");
		logger.info("ending of getYourEmailAndPasswordIsIncorrectText");

		String passwordemailincorrect = this.getContentDescValue("wrong.email.password.text");
		return passwordemailincorrect;

	}

	public void clickOnPasswordField() {
		logger.info("starting of clickOnPasswordField");

		try {
			Thread.sleep(3000);

			this.clickOnElement("password.text");
		} catch (Exception e) {
		}

		logger.info("ending of clickOnPasswordField");
	}

	public void clickonKeepMeLoggedInCheckbox() {
		logger.info("starting of clickonKeepMeLoggedInCheckbox");

			this.clickOnElementWithXpath("keep.me.loggedin.text");

		logger.info("ending of clickonKeepMeLoggedInCheckbox");
	}

	public void clearInvalidEmailField() throws Exception {
		logger.info("starting of clearInvalidEmailField");
		
		this.setValueWithClearWithXpath("email.text", platform);
		/*
		 * this.clickOnElement(platform, "email.text"); this.txtWrongEmail.clear();
		 */

		logger.info("ending of clearInvalidEmailField");
	}

}
