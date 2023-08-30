package com.gencare.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.log4j.Logger;
import io.appium.java_client.android.AndroidDriver;

public class SignInNegativePage extends BaseAutomationPage {

	public SignInNegativePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(SignInNegativePage.class.getName());

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement BtnSignIn;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement txtUserEmail;

	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement txtUserPassword;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement BtnLogIn;

	@FindBy(xpath = "//android.view.View[2]")
	private WebElement txtThisFieldIsRequiredEmail;

	@FindBy(xpath = "//android.view.View[3]")
	private WebElement txtThisFieldIsRequiredPswd;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Your password or email address is incorrect. Please try again.']s")
	private WebElement txtEmailIncorrect;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Your password or email address is incorrect. Please try again.']")
	private WebElement txtPasswordIncorrect;

	@FindBy(xpath = "//android.view.View[@content-desc = concat('Sorry, can', \"'\", 't access internet.')]")
	private WebElement TxtNoInternet;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Keep me logged in']")
	private WebElement chkkeepMeLoggeIn;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement txtVldEmail;

	@FindBy(xpath = "//android.view.View[@content-desc=\"!\"]")
	private WebElement iconError;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	public void clickOnLocationPopup() throws InterruptedException {
		logger.info("starting of clickOnLocationPopup");

		for(int i=0; i<=1; i++) {
			Thread.sleep(1000);
		this.clickOnElementWithXpath("while.using.the.app");
		}
		//this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}
	
	public void clickOnSignInBtn() {
		logger.info("starting of clickOnSignInBtn method");
		
		this.clickOnElement("signin.button");
		//this.BtnSignIn.click();
		
		logger.info("starting of clickOnSignInBtn method");

	}

	public void clickAndClearEmailField() {
		logger.info("starting of clickAndClearEmailField method");
		
		this.setValueWithClearWithXpath("email.text", platform);
		//this.txtUserEmail.click();
		//this.txtUserEmail.clear();
		driver.hideKeyboard();
		
		logger.info("ending of clickAndClearEmailField method");

	}

	public void clickOnLogInBtnWithOutFields() {
		this.implicitWait();
		logger.info("starting of clickOnLogInBtnWithOutFields method");
		
		this.clickOnElement("signin.button");
		//this.BtnLogIn.click();
		
		logger.info("ending of clickOnLogInBtnWithOutFields method");

	}

	public String getLogInWithOutEmailText() {
		logger.info("starting of getLogInWithOutEmailText method");
		logger.info("ending of getLogInWithOutEmailText method");
		
		return this.getContentDescValueWithXPath("email.this.field.required");
		//return txtThisFieldIsRequiredEmail.getAttribute("content-desc");

	}

	public String getLogInWithOutPasswordText() {
		logger.info("starting of getLogInWithOutPasswordText method");
		logger.info("ending of getLogInWithOutPasswordText method");
		
		return this.getContentDescValueWithXPath("password.this.field.required");
		//return txtThisFieldIsRequiredPswd.getAttribute("content-desc");

	}

	public void clickAndEnterUserEmail(String invalidUserEmail) {
		logger.info("starting of clickAndEnterUserEmail method");
		
		this.setValueWithClear("email.text", invalidUserEmail);
		//this.txtUserEmail.click();
		//this.txtUserEmail.clear();
		//this.txtUserEmail.sendKeys(invalidUserEmail);
		driver.hideKeyboard();
		
		logger.info("ending of clickAndEnterUserEmail method");
	}

	public void clickAndEnterUserPassword(String invalidUserPassword) {
		logger.info("starting of clickAndEnterUserPassword method");
		
		this.setValueWithClear("password.text", invalidUserPassword);
		//this.txtUserPassword.click();
		//this.txtUserPassword.clear();
		//this.txtUserPassword.sendKeys(invalidUserPassword);
		driver.hideKeyboard();
		
		logger.info("ending of clickAndEnterUserPassword method");
	}

	public void clickOnLogInBtn() {
		logger.info("starting of clickOnLogInBtn method");
		
		this.clickOnElement("login.button");
		//this.BtnLogIn.click();
		
		logger.info("ending of clickOnLogInBtn method");
	}

	public String getEmailIncorrectText() {
		this.implicitWait();
		logger.info("starting of getEmailIncorrectText method");
		logger.info("ending getEmailIncorrectText method ");
		
		return this.getContentDescValue("wrong.email.password.text");
		//return txtEmailIncorrect.getAttribute("content-desc");
	}

	public void clickAndEnterValidEmail(String validEmail) {
		logger.info("starting of getEmailIncorrectText method");
		
		this.setValueWithClear("email.text", validEmail);
		//this.txtVldEmail.click();
		//this.txtVldEmail.clear();
		//this.txtUserEmail.sendKeys(validEmail);
		driver.hideKeyboard();
		
		logger.info("ending getEmailIncorrectText method ");
	}
    public String getNoInternetText() {
	logger.info("starting of getNoInternetText method");
	logger.info("ending getNoInternetText method ");

	return this.getContentDescValue("no.internet.text");
	//return TxtNoInternet.getAttribute("content-desc ");
	
}
	public void enterValidPasswordAndClickOnLogInBtn(String validPassword) throws Exception {
		logger.info("starting of enterValidPasswordAndClickOnLogInBtn method");
		
		this.setValueWithClear("password.text", validPassword);
		//this.txtUserPassword.click();
		//Thread.sleep(3000);
		//this.txtUserPassword.clear();
		//this.txtUserPassword.sendKeys(validPassword);
		driver.hideKeyboard();
		
		logger.info("ending enterValidPasswordAndClickOnLogInBtn method ");
	}

	public void clickOnKeepMeLoggedInBtn() {
		logger.info("starting of clickOnKeepMeLoggedInBtn method");
		
		this.clickOnElement("keep.me.loggedin.text");
		//this.chkkeepMeLoggeIn.click();
		
		logger.info("ending clickOnKeepMeLoggedInBtn method ");
	}

	public void clickOnLogInBtnWithValidFields() {
		logger.info("starting of clickOnLogInBtnWithValidFields method");
		
		this.clickOnElement("login.button");
		//this.BtnLogIn.click();
		
		logger.info("ending clickOnLogInBtnWithValidFields method ");
	}

	public void displyErrorIcon() {
		logger.info("starting of displyErrorIcon method");
		
		this.isDisplayed("alert.icon");
		//this.iconError.isDisplayed();
		
		logger.info("ending displyErrorIcon method ");

	}
}
