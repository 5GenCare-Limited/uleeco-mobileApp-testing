package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class ForgotPasswordPage extends BaseAutomationPage {

	public ForgotPasswordPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(CategoriesListPage.class.getName());

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement BtnSignIn;

	@FindBy(xpath = "//android.view.View[@content-desc='Welcome to SALUS']")
	private WebElement lblWelcomeToSalus;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement txtBoxUserEmail;

	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement txtBoxUserPassword;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement BtnLogIn;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Your password or email address is incorrect. Please try again.\"]")
	private WebElement txtPasswordIncorrect;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Keep me logged in\"]")
	private WebElement chkkeepMeLoggeIn;

	@FindBy(xpath = "//android.view.View[@content-desc='Forgot your password?']")
	private WebElement txtForgotPassword;

	@FindBy(xpath = "//android.view.View[@content-desc='Don't have an account yet?']")
	private WebElement txtDontHaveAcnt;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Set up an account ›']")
	private WebElement txtSetUpAcnt;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.Button[2]")
	private WebElement iconBackNavigation;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Your password or email address is incorrect. Please try again.\"]")
	private WebElement errPassword;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Forgot your password?']")
	private WebElement txtFrgtPswd;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement txtEmailBox;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Email Confirmation code']")
	private WebElement btnEmailCnfmtnCode;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement txtBoxCnfrmtnCode;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement txtBoxNewPswrd;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[3]")
	private WebElement txtBoxCnfrmNwPswrd;

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Save new password\"]")
	private WebElement btnSaveNwPswrd;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Resend Confirmation Email\"]")
	private WebElement txtResendCnfrtnEmail;

	@FindBy(xpath = "(//android.view.View[@content-desc='This field is required'])[1]")
	private WebElement txtThisFldIsRqrdCnfrmtnCode;

	@FindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])[2]")
	private WebElement txtThisFldIsRqrdNwPswrd;

	@FindBy(xpath = "(//android.view.View[@content-desc=\"This field is required\"])[3]")
	private WebElement txtThisFldIsRqrdCnfrmNwPswd;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Passwords must not be longer than fourteen characters']")
	private WebElement errPswdMstNtBeLngrTnFrtnChrtrs;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Passwords do not match']")
	private WebElement errPswdDntMatch;

	@FindBy(xpath = "(//android.view.View[@content-desc=\"This password is too simple\"])[1]")
	private WebElement errThsPswdIsTooSmpleNwPswd;

	@FindBy(xpath = "(//android.view.View[@content-desc=\"This password is too simple\"])[2]")
	private WebElement errThsPswdIsTooSmpleCnfmPswd;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Incorrect confirmation code ']")
	private WebElement errIncrctCnfmtnCode;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Your Reset Request']")
	private WebElement emailSubject;

	@FindBy(xpath = "//android.view.View/android.widget.TextView[2]")
	private WebElement emailBody;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement txtOTPField;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickAndClearEmailField() {
		logger.info("starting of clickAndClearEmailField method");

		this.clickAndClear("email.text");
		// this.txtBoxUserEmail.click();
		// this.txtBoxUserEmail.clear();
		driver.hideKeyboard();

		logger.info("ending of clickAndClearEmailField method");

	}

	public String getWelcmToSalusText() throws InterruptedException {
		logger.info("starting of getWelcmToSalusText method");
		logger.info("ending of getWelcmToSalusText method");
		Thread.sleep(3000);

		return this.getContentDescValue("welcome.to.salus.text");
		// return lblWelcomeToSalus.getAttribute("content-desc");
	}

	public String getEmailTextBoxText() throws InterruptedException {
		logger.info("starting of getEmailTextBoxText method");
		
		Thread.sleep(10000);
		
		logger.info("ending of getEmailTextBoxText method");

		return this.getTextValueWithXpath("email.text");
		// return txtBoxUserEmail.getText();
	}

	public String getPasswordTextBoxText() {
		logger.info("starting of getPasswordTextBoxText method");
		logger.info("ending of getPasswordTextBoxText method");

		return this.getTextValueWithXpath("password.text");
		// return txtBoxUserPassword.getText();
	}

	public String getKeepMeLoggedInText() {
		logger.info("starting of clickAndClearEmailField method");
		logger.info("ending of clickAndClearEmailField method");

		return this.getContentDescValueWithXPath("keep.me.loggedin.text");
		// return chkkeepMeLoggeIn.getAttribute("content-desc");
	}

	public String getLoginBtnText() {
		logger.info("starting of getLoginBtnText method");
		logger.info("ending of getLoginBtnText method");

		return this.getContentDescValue("login.button");
		// return BtnLogIn.getAttribute("content-desc");
	}

	public String getForgetYourPswdText() {
		logger.info("starting of getForgetYourPswdText method");
		logger.info("ending of getForgetYourPswdText method");

		return this.getContentDescValue("forgot.your.password.text");
		// return txtForgotPassword.getAttribute("content-desc");
	}

	public String getDntHvAcntYtText() {
		logger.info("starting of getDntHvAcntYtText method");
		logger.info("ending of getDntHvAcntYtText method");

		return this.getTextValue("dnt.have.account.button");
		// return txtDontHaveAcnt.getText();
	}

	public String getSetupAnAcntText() {
		logger.info("starting of getSetupAnAcntText method");
		logger.info("ending of getSetupAnAcntText method");

		return this.getContentDescValueWithXPath("set.up.an.account");
		// return this.getContentDescValueWithXPath("");
		// return txtSetUpAcnt.getAttribute("content-desc");
	}

	public boolean displyBackNavigationIcon() {
		logger.info("starting of displyBackNavigationIcon method");
		logger.info("ending of displyBackNavigationIcon method");

		return this.isDisplayed("icn.back");

	}

	public String getErrPswdText() {
		logger.info("starting of getErrPswdText method");
		logger.info("ending of  getErrPswdText method");

		return this.getContentDescValue("wrong.email.password.text");
		// return errPassword.getAttribute("content-desc");
	}

	public void clickOnSignInBtn() {
		logger.info("starting of clickOnSignInBtn method");

		this.clickOnElement("signin.button");
		// this.BtnSignIn.click();

		logger.info("starting of clickOnSignInBtn method");

	}

	public void clickAndClearEmailField(String email) {
		logger.info("starting of clickAndClearEmailField method");

		this.setValueWithClearWithXpath("email.text", email);
		// this.txtBoxUserEmail.click();
		// this.txtBoxUserEmail.clear();
		this.implicitWait();
		// this.txtBoxUserEmail.sendKeys(email);
		driver.hideKeyboard();

		logger.info("ending of clickAndClearEmailField method");

	}

	public void enterInvalidPassword(String invaliduserpassword) {
		logger.info("starting of enterInvalidPassword method");

		this.setValueWithClearWithXpath("password.text", invaliduserpassword);
//		this.txtBoxUserPassword.click();
//		this.implicitWait();
//		this.txtBoxUserPassword.sendKeys(invaliduserpassword);
		driver.hideKeyboard();

		logger.info("ending of enterInvalidPassword method");
	}
	/*
	 * public void enterValidPswd(String ) {
	 * logger.info("starting of enterValidPswd method");
	 * 
	 * this.txtBoxUserPassword.click(); this.txtBoxUserPassword.clear();
	 * this.txtBoxUserPassword.sendKeys(); driver.hideKeyboard();
	 * 
	 * logger.info("ending of enterValidPswd method"); }
	 */

	public void clickOnLogin() {
		logger.info("starting of clickOnLogout method");

		this.clickOnElement("login.button");
		// this.BtnLogIn.click();

		logger.info("ending of clickOnLogout method");
	}

	public void clickOnFrgtYourPswd() {
		logger.info("starting of clickOnFrgtYourPswd method");

		this.clickOnElement("forgot.your.password.text");
		// this.txtForgotPassword.click();

		logger.info("ending of clickOnFrgtYourPswd method");
	}

	public String getFrgtUrPswdText() {
		logger.info("starting of getFrgtUrPswdText ");
		logger.info("ending of getFrgtUrPswdText ");

		return this.getTextValue("forgot.your.password.text");
		// return txtFrgtPswd.getText();
	}

	public boolean displytEmailTxtBox() {
		logger.info("starting of clickAndClearEmailField method");
		logger.info("ending of clickAndClearEmailField method");

		return this.isDisplayed("email.box");
		// this.txtEmailBox.isDisplayed();

	}

	public String getEmailCnfrmCodeText() {
		logger.info("starting of getEmailCnfrmCodeText method");
		logger.info("ending of getEmailCnfrmCodeText method");

		return this.getContentDescValue("btn.email.confirmation.code");
		// return btnEmailCnfmtnCode.getAttribute("content-desc");
	}

	public void clickOnConfirmationCodeBtn() {
		logger.info("starting of clickOnConfirmationCodeBtn ");

		this.clickOnElement("btn.email.confirmation.code");

		// this.btnEmailCnfmtnCode.click();
		// this.btnEmailCnfmtnCode.click();

		logger.info("ending of clickOnConfirmationCodeBtn ");
	}

	public String getConfirmationCodeText() throws InterruptedException {
		logger.info("starting of getConfirmationCodeText ");
		
		Thread.sleep(3000);
		
		logger.info("ending of getConfirmationCodeText ");

		return this.getTextValueWithXpath("txt.confirmation.code.frgtpswd");
		// return txtBoxCnfrmtnCode.getText();
	}

	public String getNewPswdText() {
		logger.info("starting of getNewPswdText ");
		logger.info("ending of getNewPswdText ");

		return this.getTextValueWithXpath("txt.new.password.frgtpswd");
		// return txtBoxNewPswrd.getText();
	}

	public String getConfirmNewPswdText() {
		logger.info("starting of getConfirmNewPswdText ");
		logger.info("ending of getConfirmNewPswdText ");

		return this.getTextValueWithXpath("txt.confirm.password.frgtpswd");
		// return txtBoxCnfrmNwPswrd.getText();
	}

	public String getSaveNewPswdText() {
		logger.info("starting of getSaveNewPswdText ");
		logger.info("ending of getSaveNewPswdText ");

		return this.getContentDescValue("btn.save.newpassword.frgtpswd");
		// return btnSaveNwPswrd.getAttribute("content-desc");
	}

	public String getResendConfirmationEmailText() {
		logger.info("starting of getResendConfirmationEmailText ");
		
		this.verticalScroll();
		
		logger.info("ending of getResendConfirmationEmailText ");

		return this.getContentDescValue("txt.resend.confirmationcode.frgtpswd");
		// return txtResendCnfrtnEmail.getAttribute("content-desc");
	}

	public void clickOnSaveNewPassword() {
		logger.info("starting of clickOnSaveNewPassword method");

		this.clickOnElement("btn.save.newpassword.frgtpswd");
		// this.btnSaveNwPswrd.click();

		logger.info("ending of clickOnSaveNewPassword method");
	}

	public String getThisFldRqrdConfirmationCodeText() {
		logger.info("starting of getThisFldRqrdConfirmationCodeText ");
		logger.info("ending of getThisFldRqrdConfirmationCodeText ");

		return this.getContentDescValueWithXPath("err.cnfrmtncode.fldrequired.frgtpswd");
		// return txtThisFldIsRqrdCnfrmtnCode.getAttribute("content-desc");
	}

	public String getThisFldRqrdNewPswdText() {
		logger.info("starting of getThisFldRqrdNewPswdText ");
		logger.info("ending of getThisFldRqrdNewPswdText ");

		return this.getContentDescValueWithXPath("err.nwpswd.fldrequired.frgtpswd");
		// return txtThisFldIsRqrdNwPswrd.getAttribute("content-desc");
	}

	public String getThisFldRqrdCnfrmNewPswdText() {
		logger.info("starting of getThisFldRqrdCnfrmNewPswdText ");
		logger.info("ending of getThisFldRqrdCnfrmNewPswdText ");

		return this.getContentDescValueWithXPath("err.cnfrmpswd.fldrequired.frgtpswd");
		// return txtThisFldIsRqrdCnfrmNwPswd.getAttribute("content-desc");
	}

	public void clickAndEnterInvalidCnfrmCode(String invalidcnfrncode) {
		logger.info("starting of clickAndEnterInvalidCnfrmCode method");

		this.setValueWithClearWithXpath("txt.confirmation.code.frgtpswd", invalidcnfrncode);
//		this.txtBoxCnfrmtnCode.click();
//		this.implicitWait();
//		this.txtBoxCnfrmtnCode.sendKeys(invalidcnfrncode);
		driver.hideKeyboard();

		logger.info("ending of clickAndEnterInvalidCnfrmCode method");

	}

	public void enterInvaliNewPswd(String invalidnewpswd) {
		logger.info("starting of enterInvaliNewPswd method");

		this.setValueWithClearWithXpath("txt.new.password.frgtpswd", invalidnewpswd);
//		this.txtBoxNewPswrd.click();
//		this.implicitWait();
//		this.txtBoxNewPswrd.sendKeys(invalidnewpswd);
		driver.hideKeyboard();

		logger.info("ending of enterInvaliNewPswd method");

	}

	public void clickAndEnterDntMatchConfrmPswd(String dntmatchcnfrnpswd) {
		logger.info("starting of clickAndEnterDntMatchConfrmPswd method");

		this.setValueWithClearWithXpath("txt.confirm.password.frgtpswd", dntmatchcnfrnpswd);
//		this.txtBoxCnfrmNwPswrd.click();
//		this.implicitWait();
//		this.txtBoxCnfrmNwPswrd.sendKeys(dntmatchcnfrnpswd);
		driver.hideKeyboard();

		logger.info("ending of clickAndEnterDntMatchConfrmPswd method");

	}

	public String getPswdsNstNtLongerFrteenCrctrsText() {
		logger.info("starting of getPswdsNstNtLongerFrteenCrctrsText ");
		logger.info("ending of getPswdsNstNtLongerFrteenCrctrsText ");

		return this.getContentDescValueWithXPath("err.pswd.mstnot.frtncrctrs");
		// return errPswdMstNtBeLngrTnFrtnChrtrs.getAttribute("content-desc");
	}

	public String getPswdDntMatchText() {
		logger.info("starting of getPswdDntMatchText ");
		logger.info("ending of getPswdDntMatchText ");

		return this.getContentDescValueWithXPath("err.password.dntmatch.frgtpswd");
		// return errPswdDntMatch.getAttribute("content-desc");
	}

	public void clickAndEnterSimpleNewPswdText(String splnwpswd) {
		logger.info("starting of clickAndEnterSimpleNewPswdText ");

		this.setValueWithClearWithXpath("err.nwpswd.smplpswd.frgtpswd", splnwpswd);
//		this.txtBoxNewPswrd.click();
//		this.txtBoxNewPswrd.clear();
//		this.implicitWait();
//		this.txtBoxNewPswrd.sendKeys(splnwpswd);

		logger.info("ending of clickAndEnterSimpleNewPswdText ");

	}

	public void clickAndEnterSimpleCnfrmPswdText(String splcnfmpswd) {
		logger.info("starting of clickAndEnterSimpleCnfrmPswdText ");

		this.setValueWithClearWithXpath("err.cnfrmpswd.smplpswd.frgtpswd", splcnfmpswd);
//		this.txtBoxCnfrmNwPswrd.click();
//		this.txtBoxCnfrmNwPswrd.clear();
//		this.implicitWait();
//		this.txtBoxCnfrmNwPswrd.sendKeys(splcnfmpswd);
		driver.hideKeyboard();

		logger.info("ending of clickAndEnterSimpleCnfrmPswdText ");

	}

	public void clickAndEnterValidNewPswd(String validnewpassword) {
		logger.info("starting of clickAndEnterValidNewPswd ");

		this.setValueWithClearWithXpath("txt.new.password.frgtpswd", validnewpassword);
//		this.txtBoxNewPswrd.click();
//		this.txtBoxNewPswrd.clear();
//		this.implicitWait();
//		this.txtBoxNewPswrd.sendKeys(validnewpassword);
		driver.hideKeyboard();

		logger.info("ending of clickAndEnterValidNewPswd ");

	}

	public void clickAndEnterCnfrmPswd(String validcnfmpswd) {
		logger.info("starting of clickAndEnterCnfrmPswd ");

		this.setValueWithClearWithXpath("txt.confirm.password.frgtpswd", validcnfmpswd);
//		this.txtBoxCnfrmNwPswrd.click();
//		this.txtBoxCnfrmNwPswrd.clear();
//		this.implicitWait();
//		this.txtBoxCnfrmNwPswrd.sendKeys(validcnfmpswd);
		driver.hideKeyboard();

		logger.info("ending of clickAndEnterCnfrmPswd ");
	}

	public String getIncorrectCnfrmCodeText() {
		logger.info("starting of getIncorrectCnfrmCodeText ");
		logger.info("ending of getIncorrectCnfrmCodeText ");

		return this.getContentDescValue("err.incorrect.cnfrmncode.frggtpswd");
		// return errIncrctCnfmtnCode.getAttribute("content-desc");
	}

	public String getSimpleNewPswdText() {
		logger.info("starting of getSimpleNewPswdText ");
		logger.info("ending of getSimpleNewPswdText ");

		return this.getContentDescValueWithXPath("err.nwpswd.simplepswd.frgtpswd");
		// return errThsPswdIsTooSmpleNwPswd.getAttribute("content-desc");

	}

	public String getSimpleCnfrmPswdText() {
		logger.info("starting of getSimpleCnfrmPswdText ");
		logger.info("ending of getSimpleCnfrmPswdText ");

		return this.getContentDescValueWithXPath("err.cnfrmpswd.simplepswd.frgtpswd");
		// return errThsPswdIsTooSmpleCnfmPswd.getAttribute("content-desc");
	}

	public void clickOnConfirmationCode() {
		logger.info("starting of clickOnConformationCode ");

		this.clickAndClear("txt.confirmation.code.frgtpswd");
		this.setValueWithClearWithXpath("txt.confirmation.code.frgtpswd", "");
//		this.txtBoxCnfrmtnCode.click();
//		this.txtBoxCnfrmtnCode.clear();
		driver.hideKeyboard();

		logger.info("ending of clickOnConformationCode ");

	}

	public void setOTP(String appPkg, String appAct) throws InterruptedException {
		logger.info("starting of setOTP ");

		this.getOTPForgotEmail(appPkg, appAct, emailSubject, emailBody, txtOTPField);

		logger.info("ending of setOTP ");

	}

}
