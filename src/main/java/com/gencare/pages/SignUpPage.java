package com.gencare.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SignUpPage extends BaseAutomationPage {

	public SignUpPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(SignUpPage.class.getName());

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement btnAllowWhileUsingTheApp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Sign up']")
	private WebElement btnSignUp;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'English']")
	private WebElement btnLanguageChange;

	@FindBy(xpath = "//android.view.View[@content-desc = 'English']")
	private WebElement txtselectLanguage;

	@FindBy(xpath = "//android.widget.EditText[@text = 'First Name']")
	private WebElement txtFirstName;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Last Name']")
	private WebElement txtLastName;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email Address']")
	private WebElement txtEmailAddress;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Confirm Email Address']")
	private WebElement txtConfirmEmailAddress;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Confirm new password']")
	private WebElement txtConfirmNewPassword;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
	private WebElement txtCountrySelection;

	@FindBy(xpath = "//android.view.View[@content-desc = 'India']")
	private WebElement txtIndia;

	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement txtMobileNumber;

	@FindBy(xpath = "//android.view.View[@content-desc = 'I accept SALUS Controls Ã¯Â¿Â¼\r\n" + "Terms & Conditions']")
	private WebElement btnTermsAndConditions;

	@FindBy(xpath = "//android.view.View[3]/android.widget.CheckBox")
	private WebElement chkTermsAndConditions;

	@FindBy(xpath = "//android.view.View[@content-desc = 'I have read and understood SALUS Controls Ã¯Â¿Â¼\r\n"
			+ "Privacy Notice']")
	private WebElement btnPrivacyNotice;

	@FindBy(xpath = "//android.view.View[5]/android.widget.CheckBox")
	private WebElement chkPrivacyNotice;

	@FindBy(xpath = "//android.widget.RadioButton[1]")
	private WebElement btnYes;

	@FindBy(xpath = "//android.view.View[@content-desc=\"No\"]")
	private WebElement btnNo;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Create my profile']")
	private WebElement btnCreateMyProfile;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Cancel']")
	private WebElement btnCancel;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Welcome to SALUS']")
	private WebElement lblWelcomeToSalus;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Confirmation code']")
	private WebElement lblConfirmationCodemsg;

	@FindBy(xpath = "//android.view.View[3]")
	private WebElement btnConfirmationEmailFld;

	@FindBy(xpath = "//android.widget.EditText[@text ='Confirmation code']")
	private WebElement btnConfirmationCodeFld;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
	private WebElement btnConfirm;

	@FindBy(xpath = "//android.view.View[@content-desc='Resend Confirmation Email']")
	private WebElement txtResendConfirmationEmail;

	@FindBy(xpath = "//android.widget.Button[2]")
	private WebElement iconBackNavigation;

	@FindBy(xpath = "	\r\n" + "//android.view.View[@content-desc=\"User is not confirmed.\"]")
	private WebElement txtUserIsNotConfirmed;

	@FindBy(xpath = "//android.widget.EditText/android.view.View")
	private WebElement iconEye;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Please Confirm Your SALUS Account'")
	private WebElement emailSubject;

	@FindBy(xpath = "//android.view.View/android.widget.TextView[2]")
	private WebElement emailBody;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement txtOTPField;
	
	String email = this.randomEmailGenarator();

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.clickOnElement("btn.allow.while.using.app.signup");
		this.btnAllowWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickOnAllowVideoPopup() {

		logger.info("starting of clickOnAllowVideoPopu method");

		this.clickOnElement("btn.allow.while.using.app.signup");
		// this.btnAllowWhileUsingTheApp.click();

		logger.info("starting of clickOnAllowVideoPopu method");

	}

	public void clickOnEyeIcon() {

		logger.info("starting of clickOnAllowVideoPopu method");

		this.clickOnElementWithXpath("eye.icon.signup");
		// this.iconEye.click();

		logger.info("starting of clickOnAllowVideoPopu method");

	}

	public void clickOnSignUpButton() throws Exception {
		logger.info("Starting of clickOnSignUpButton Method");

		this.clickOnElementWithXpath("signup.button.signup");
		// this.btnSignUp.click();

		logger.info("Ending of clickOnSignUpButton Method");
	}

	public void clickOnLanguageButton() throws Exception {
		logger.info("Starting of clickOnLanguageButton Method");

		this.clickOnElementWithXpath("btn.language.change.signup");
		// this.btnLanguageChange.click();

		logger.info("Ending of clickOnLanguageButton Method");

	}

	public void clickOnSelectLanguageOption() throws Exception {
		logger.info("Starting of clickOnSelectLanguageOption Method");

		this.clickOnElementWithXpath("txt.select.language.signup");
		// this.txtselectLanguage.click();

		logger.info("Ending of clickOnSelectLanguageOption Method");
	}

	public void clickAndEnterFirstName(String firstname) {
		logger.info("Starting of clickAndEnterFirstName Method");

		this.setValueWithClearWithXpath("txt.first.name.signup", firstname);
		// this.txtFirstName.click();
		// this.txtFirstName.sendKeys(firstname);
		driver.hideKeyboard();

		logger.info("Ending of clickAndEnterFirstName Method");
	}

	public void clickAndEnterLastName(String lastname) throws Exception {
		logger.info("Starting of clickAndEnterLastName Method");

		Thread.sleep(2000);
		this.setValueWithClearWithXpath("txt.last.name.signup", lastname);
		// this.txtLastName.click();
		// this.txtLastName.sendKeys(lastname);
		driver.hideKeyboard();

		logger.info("Ending of clickAndEnterLastName Method");
	}

	public void clickAndEnterEmailAdress(String signupEmailAddress) {
		logger.info("Starting of clickAndEnterConfirmEmail");

		this.setValueWithClearWithXpath("txt.email.address.signup", signupEmailAddress);
		// this.txtEmailAddress.click();
		// this.txtEmailAddress.sendKeys(signupEmailAddress);
		this.driver.hideKeyboard();

		logger.info("Ending of clickAndEnterConfirmEmail");
	}

	public void clickAndEnterValidEmailAdress() {
		logger.info("Starting of clickAndEnterConfirmEmail");

		/*
		 * Random randomGenerator = new Random(); int randomInt =
		 * randomGenerator.nextInt(1000); String email = ("sharath.mudimadugula"+ "+"+
		 * randomInt +"@b2btesters.com");
		 */
		

		this.setValueWithClearWithXpath("txt.email.address.signup", email);
		driver.hideKeyboard();

		logger.info("Ending of clickAndEnterConfirmEmail");
	}

	public void clickAndEnteDntMatchEmailAdress(String doNotMatchEmail) {
		logger.info("Starting of clickAndEnteDntMatchEmailAdress");

		this.setValueWithClear("txt.email.address.signup", doNotMatchEmail);
		// this.txtEmailAddress.click();
		// this.txtEmailAddress.sendKeys(doNotMatchEmail);
		driver.hideKeyboard();

		logger.info("Ending of clickAndEnteDntMatchEmailAdress");
	}

	public void clickAndEnterAlreadyExistingEmailAdress(String alreadyexistemail) {
		logger.info("Starting of clickAndEnterAlreadyExistingEmailAdress");

		this.setValueWithClear("txt.email.address.signup", alreadyexistemail);
		// this.txtEmailAddress.click();
		// this.txtEmailAddress.sendKeys(alreadyexistemail);
		driver.hideKeyboard();

		logger.info("Ending of clickAndEnterAlreadyExistingEmailAdress");
	}

	public void clickOnAlreadyConfirmEmailAddress(String alreadyexistemail) throws InterruptedException {

		logger.info("Starting of clickOnAlreadyConfirmEmailAddress Method");
		this.setValueWithClear("txt.confirmemail.address.signup", alreadyexistemail);
		this.txtConfirmEmailAddress.click();
		// Thread.sleep(5000);
		// this.txtConfirmEmailAddress.sendKeys(alreadyexistemail);
		driver.hideKeyboard();
		logger.info("Ending of clickOnAlreadyConfirmEmailAddress Method");
	}

	public void clickOnConfirmEmailAddress(String signUpConfirmEmail) {

		logger.info("Starting of clickOnConfirmEmailAddress Method");
		this.setValueWithClearWithXpath("txt.confirmemail.address.signup", signUpConfirmEmail);
		// this.txtConfirmEmailAddress.click();
		// this.txtConfirmEmailAddress.sendKeys(signUpConfirmEmail);
		driver.hideKeyboard();
		logger.info("Ending of clickOnConfirmEmailAddress Method");
	}

	public void clickOnConfirmValidEmailAddress() {

		logger.info("Starting of clickOnConfirmEmailAddress Method");
		this.setValueWithClearWithXpath("txt.confirmemail.address.signup", email);
		driver.hideKeyboard();
		logger.info("Ending of clickOnConfirmEmailAddress Method");
	}

	public void clickAndEnterPassword(String signUpPassword) throws Exception {

		logger.info("Starting of clickAndEnterPassword Method");
		Thread.sleep(4000);
		this.setValueWithClearWithXpath("txt.password.signup", signUpPassword);
		// this.txtPassword.click();
		// this.txtPassword.sendKeys(signUpPassword);
		driver.hideKeyboard();
		logger.info("Ending of clickAndEnterPasswordMethod");
	}

	public void clickAndEnterConfirmNewPassword(String confirmNewPassword) {

		logger.info("Starting of clickAndEnterConfirmNewPassword Method");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		this.setValueWithClearWithXpath("txt.confirm.password.signup", confirmNewPassword);
		// this.txtConfirmNewPassword.click();
		// this.txtConfirmNewPassword.sendKeys(confirmNewPassword);
		driver.hideKeyboard();
		logger.info("Ending of clickAndEnterConfirmNewPasswor Method");
	}

	public void clickAndEnterDntMatchConfirmNewPassword(String doNotMatchPassword) {

		logger.info("Starting of clickAndEnterDntMatchConfirmNewPassword Method");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.setValueWithClear("txt.confirm.password.signup", doNotMatchPassword);
		// this.txtConfirmNewPassword.click();
		// this.txtConfirmNewPassword.sendKeys(doNotMatchPassword);
		driver.hideKeyboard();
		logger.info("Ending of clickAndEnterDntMatchConfirmNewPassword Method");
	}

	public void verticalScroll2() throws InterruptedException {
		logger.info("Starting of verticalScroll Method");

		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.9);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	public void clickOnCountryDropdown() throws Exception {
		logger.info("Starting of clickOnCountryButton Method");

		this.clickOnElementWithXpath("drpwn.country.signup");
		// this.txtCountrySelection.click();
		logger.info("Ending of clickOnCountryButton Method");
	}

	public void verticalScroll111() throws Exception {
		logger.info("Starting of verticalScroll Method");

		Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();

		int endY = size.width / 2;

		int startY = endY;

		int endX = (int) (size.height * 0.87);

		int startX = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	public void selectCountry() throws Exception {
		logger.info("Starting of selectCountry Method");

		Thread.sleep(3000);
		this.implicitWait();
		this.verticalScroll();
		this.clickOnElementWithXpath("txt.india.signup");
		// this.txtIndia.click();
		driver.hideKeyboard();

		logger.info("Ending of selectCountry Method");
	}

	public void clickAndEnterMobileNumber(String signUpMobileNumber) throws Exception {

		logger.info("Starting of clickAndEnterMobileNumber Method");

		this.implicitWait();
		this.setValueWithClearWithXpath("txt.mobilenumber.signup", signUpMobileNumber);
		// txtMobileNumber.click();
		// Thread.sleep(2000);
		// txtMobileNumber.sendKeys(signUpMobileNumber);
		driver.hideKeyboard();
		logger.info("Ending of clickAndEnterMobileNumber Method");
	}

	public void clickOnTermsAndConditionsCheckBox() throws InterruptedException {
		logger.info("Starting of TermsAndConditionsCheckBox Method");
		Thread.sleep(3000);
		this.clickOnElementWithXpath("chk.terms.signup");
		// chkTermsAndConditions.click();
		logger.info("Ending of TermsAndConditionsCheckBox Method");
	}

	public void clickOnPrivacyNoticeCheckBox() {

		logger.info("Starting of PrivacyNoticeCheckBox Method");
		this.clickOnElementWithXpath("chk.privacy.signup");
		// chkPrivacyNotice.click();
		logger.info("Ending of PrivacyNoticeCheckBox Method");
	}

	public void clickOnYesCheckBox() {

		logger.info("Starting of yesCheckBox Method");
		this.clickOnElementWithXpath("btn.radio.yes");
		// btnYes.click();
		logger.info("Ending of yesCheckBox Method");
	}

	public void clickOnCreateMyProfile() {

		logger.info("Starting of clickOnCreateMyProfile");
		this.clickOnElementWithXpath("btn.create.myprofile");
		// btnCreateMyProfile.click();
		logger.info("Ending of clickOnCreateMyProfile");
	}

	public String getWelcomeToSalusText() throws InterruptedException {
		logger.info("Starting of getWelcomeToSalusText");
		logger.info("Ending of getWelcomeToSalusText");

		Thread.sleep(5000);

		return this.getContentDescValueWithXPath("lbl.welcome.to.salus.signup");
		// return lblWelcomeToSalus.getAttribute("content-desc");
	}

	public String getConfirmationCodeLbl() {
		logger.info("Starting of getConfirmationCodeLbl");
		logger.info("Ending of getConfirmationCodeLbl");

		return this.getTextValueWithXpath("lbl.confirmation.codemsg.signup");
		// return lblConfirmationCodemsg.getAttribute("content-desc");
	}

	public boolean displyEmailFldBtn() {
		logger.info("Starting of displyEmailFldBtn");

		// this.isDisplayed("btn.confirmation.email.field.signup");
		// this.btnConfirmationEmailFld.isDisplayed();

		logger.info("Ending of displyEmailFldBtn");
		return isDisplayed("btn.confirmation.email.field.signup");
	}

	public void displyConfirmationCodeFld() {
		logger.info("Starting of displyConfirmationCodeFld");

		this.isDisplayed("btn.confirmation.code.field.signup");
		// this.btnConfirmationCodeFld.isDisplayed();

		logger.info("Ending of displyConfirmationCodeFld");
	}

	public String getConfirmBtnText() {
		logger.info("Starting of getConfirmBtnText");
		logger.info("Ending of getConfirmBtnText");

		return this.getContentDescValueWithXPath("btn.confirm.signup");
		// return btnConfirm.getAttribute("content-desc");
	}

	public String getResendCodeToEmailText() {
		logger.info("Starting of getResendCodeToEmailText");
		logger.info("Ending of getResendCodeToEmailText");

		return this.getContentDescValueWithXPath("txt.resend.confirmationcode.signup");
		// return txtResendConfirmationEmail.getAttribute("content-desc");
	}

	public boolean displyBackNavigatinIcon() {
		logger.info("Starting of displyBackNavigatinIcon");

		// this.isDisplayed("icon.back.navigation.signup");
		// this.iconBackNavigation.isDisplayed();

		logger.info("Ending of displyBackNavigatinIcon");
		return this.isDisplayed("icon.back.navigation.signup");
	}

	public void clickOnConfirmButton() {
		logger.info("Starting of clickOnConfirmButton");

		this.clickOnElementWithXpath("btn.confirm.signup");
		// this.btnConfirm.click();

		logger.info("Ending of clickOnConfirmButton");
	}

	public void setOTP(String appPkg, String appAct) throws InterruptedException {
		logger.info("starting of setOTP ");

		this.getOTPFromEmail(appPkg, appAct, emailSubject, emailBody, txtOTPField);

		logger.info("ending of setOTP ");

	}

	public void clickOnCancel() {
		logger.info("Starting of clickOnCancel");

		for (int i = 0; i <= 1; i++) {
			this.verticalScroll();
		}
		this.clickOnElementWithXpath("btn.cancel.signup");
		// this.btnCancel.click();

		logger.info("Ending of clickOnCancel");
	}
}
