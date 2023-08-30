package com.gencare.pages;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SignUpNegativePage extends BaseAutomationPage {

	public SignUpNegativePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	private static final Logger logger = Logger.getLogger(SignUpPage.class.getName());

	@FindBy(xpath = "//android.view.View[@content-desc = 'Sign up']")
	private WebElement btnSignUp;

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

	@FindBy(xpath = "//android.view.View[@content-desc = 'I accept SALUS Controls ÃƒÂ¯Ã‚Â¿Ã‚Â¼\r\n"
			+ "Terms & Conditions']")
	private WebElement btnTermsAndConditions;
	
	@FindBy(xpath = "//android.view.View[3]/android.widget.CheckBox")
	private WebElement chkTermsAndConditions;

	@FindBy(xpath = "//android.view.View[@content-desc = 'I have read and understood SALUS Controls ÃƒÂ¯Ã‚Â¿Ã‚Â¼\r\n"
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

	@FindBy(xpath = "(//android.view.View[@content-desc='This field is required'])[1]")
	private WebElement lblFieldRequiredFirstName;
	
	@FindBy(xpath = "(//android.view.View[@content-desc='This field is required'])[2]")
	private WebElement lblFieldRequiredLastName;
	
	@FindBy(xpath = "(//android.view.View[@content-desc='This field is required'])[3]")
	private WebElement lblFieldRequiredEmailAddress;
	
	@FindBy(xpath = "(//android.view.View[@content-desc='This field is required'])[4]")
	private WebElement lblFieldRequiredCnfmEmailAddress;
	
	@FindBy(xpath = "(//android.view.View[@content-desc='This field is required'])[5]")
	private WebElement lblFieldRequiredPassword;
	
	@FindBy(xpath = "(//android.view.View[@content-desc='This field is required'])")
	private WebElement lblFieldRequiredCnfmNewPassword;
	
	@FindBy(xpath = "(//android.view.View[@content-desc='This email address has already been taken'])")
	private WebElement lblAlreadyExistEmail;
	
	@FindBy(xpath = "//android.view.View[@content-desc='The emails you entered do not match']")
	private WebElement lblDoNotMatchEmails;
	
	@FindBy(xpath = "//android.view.View[@content-desc='The email you entered is not a valid email address']")
	private WebElement lblNotAValidEmail;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Passwords do not match']")
	private WebElement lbldoNotMatchPassword;
	
	@FindBy(xpath = "//android.view.View[@content-desc='This password is too simple']")
	private WebElement lblSimplePassword;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Passwords must be at least eight characters']")
	private WebElement lblLessThanSixCharPassword;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Passwords must not be longer than fourteen characters']")
	private WebElement lblMoreThanFourteenCharPassword;
	
	
	
	public void clickOnSignUpButton() throws Exception {
		logger.info("Starting of clickOnSignUpButton Method");

		Thread.sleep(4000);
		this.clickOnElement("signup.button.signup");
		//this.btnSignUp.click();

		logger.info("Ending of clickOnSignUpButton Method");
	}

	public void clickOnFirstName() throws Exception {
		logger.info("Starting of clickAndEnterFirstName Method");

		this.clickOnElementWithXpath("txt.first.name.signup");
		//this.txtFirstName.click();
		Thread.sleep(2000);
		driver.hideKeyboard();

		logger.info("Ending of clickAndEnterFirstName Method");
	}

	public void clickOnLastName() throws Exception {
		logger.info("Starting of clickAndEnterLastName Method");

		Thread.sleep(2000);
		this.clickOnElementWithXpath("txt.last.name.signup");
		//this.txtLastName.click();
		driver.hideKeyboard();

		logger.info("Ending of clickAndEnterLastName Method");
	}

	public void clickOnEmailAddress() throws Exception {
		logger.info("Starting of clickOnEmailAddress Method");

		this.implicitWait();
		this.clickOnElementWithXpath("txt.email.address.signup");
		//this.txtEmailAddress.click();
		Thread.sleep(2000);
		driver.hideKeyboard();

		logger.info("Ending of clickOnEmailAddress Method");
	}

	public void clickOnConfirmEmailAddress() {

		logger.info("Starting of clickOnConfirmEmailAddress Method");
		this.clickOnElementWithXpath("txt.confirmemail.address.signup");
		//this.txtConfirmEmailAddress.click();
		driver.hideKeyboard();
		logger.info("Ending of clickOnConfirmEmailAddress Method");
	}

	public void clickOnPassword() throws Exception {

		logger.info("Starting of clickOnPassword Method");
		Thread.sleep(4000);
		this.implicitWait();
		this.clickOnElementWithXpath("txt.password.signup");
		//this.txtPassword.click();
		driver.hideKeyboard();
		logger.info("Ending of clickOnPassword Method");
	}

	public void clickOnConfirmNewPassword() {

		logger.info("Starting of clickOnConfirmNewPassword Method");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		this.clickOnElementWithXpath("txt.confirm.password.signup");
		//this.txtConfirmNewPassword.click();
		driver.hideKeyboard();
		logger.info("Ending of clickOnConfirmNewPassword Method");
	}
	
	public void clickOnMobileNumber() throws InterruptedException {

		logger.info("Starting of clickAndEnterMobileNumber Method");

		this.implicitWait();
		this.clickOnElementWithXpath("txt.mobilenumber.signup");
		//txtMobileNumber.click();
		Thread.sleep(2000);
		driver.hideKeyboard();
		logger.info("Ending of clickAndEnterMobileNumber Method");
	}

	
	public void verticalScrollDown() {
		logger.info("Starting of verticalScrollDown Method");

		sleep(3000);

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.9);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScrollDown Method");
	}

		public String getThisFldRqrdFirstNameText() {
		logger.info("starting of getThisFldRqrdText Method");
		logger.info("ending of getThisFldRqrdText Method");

		return this.getContentDescValueWithXPath("err.firstname.thzfld.requird");
		//return lblFieldRequiredFirstName.getAttribute("content-desc");
	}
	
	public String getThisFldRqrdLastNameText() {
		logger.info("starting of getThisFldRqrdLastNameText Method");
		logger.info("ending of getThisFldRqrdLastNameText Method");

		return this.getContentDescValueWithXPath("err.lastname.thzfld.requird");
		//return lblFieldRequiredLastName.getAttribute("content-desc");
	}
	
	public String getThisFldRqrdEmailAddressText() {
		logger.info("starting of getThisFldRqrdEmailAddressText Method ");
		logger.info("ending of getThisFldRqrdEmailAddressText Method ");

		return this.getContentDescValueWithXPath("err.email.thzfld.requird");
		//return lblFieldRequiredEmailAddress.getAttribute("content-desc");
	}
	
	public String getThisFldRqrdcnrmEmailAddressText() {
		logger.info("starting of getThisFldRqrdcnrmEmailAddressText Method ");
		logger.info("ending getThisFldRqrdcnrmEmailAddressText Method");

		return this.getContentDescValueWithXPath("err.cnfmemail.thzfld.requird");
		//return lblFieldRequiredCnfmEmailAddress.getAttribute("content-desc");
	}
	public String getThisFldRqrdPasswordText() {
		logger.info("starting of getThisFldRqrdPasswordText Method");
		logger.info("ending getThisFldRqrdPasswordText Method");

		return this.getContentDescValueWithXPath("err.password.thzfld.requird");
		//return lblFieldRequiredPassword.getAttribute("content-desc");
	}
	
	public String getThisFldRqrdCnfmNewPasswordText() {
		logger.info("starting of getThisFldRqrdCnfmNewPasswordText Method");
		logger.info("ending getThisFldRqrdCnfmNewPasswordText Method");

		return this.getContentDescValueWithXPath("lbl.field.required.cnfmnewpassword.signup");
		//return lblFieldRequiredCnfmNewPassword.getAttribute("content-desc");
	}
	
	
	public String getAlreadyExistsEmailText() {
		logger.info("starting of getAlreadyExistsEmailText Method");
		logger.info("ending getAlreadyExistsEmailText Method ");

		return this.getContentDescValueWithXPath("err.email.alreadytkn.signup");
		//return lblAlreadyExistEmail.getAttribute("content-desc");
	}

	public String getDoNotMatchEmailsText() {
		logger.info("starting of getDoNotMatchEmailsText Method");
		logger.info("ending getDoNotMatchEmailsText Method");

		return this.getContentDescValueWithXPath("lbl.do.not.match.emails.signup");
		//return lblDoNotMatchEmails.getAttribute("content-desc");
	}

	public String getNotAValidEmailText() {
		logger.info("starting of getNotAValidEmailText Method");
		logger.info("ending getNotAValidEmailText Method");

		return this.getContentDescValueWithXPath("err.not.validemail.signup");
		//return lblNotAValidEmail.getAttribute("content-desc");
	}
	
	public String getdoNotMatchPasswordText() {
		logger.info("starting of getdoNotMatchPasswordText Method ");
		logger.info("ending getdoNotMatchPasswordText Method");

		return this.getContentDescValueWithXPath("err.pswd.dntmtch.signup");
		//return lbldoNotMatchPassword.getAttribute("content-desc");
	}
	
	public String getSimplePasswordText() {
		logger.info("starting of getSimplePasswordText ");
		logger.info("ending getSimplePasswordText ");

		return this.getContentDescValueWithXPath("err.pswd.smpl.signup");
		//return lblSimplePassword.getAttribute("content-desc");
	}

	public String getLessThanSixCharPasswordText() {
		logger.info("starting of getLessThanSixCharPasswordText Method");
		logger.info("ending getLessThanSixCharPasswordText Method");

		return this.getContentDescValueWithXPath("err.pswdmst.eghtcrctrs.signup");
		//return lblLessThanSixCharPassword.getAttribute("content-desc");
	}
	
	
	public String getMoreThanFourteenCharPasswordText() {
		logger.info("starting of getMoreThanFourteenCharPAsswordText Method");
		logger.info("ending getMoreThanFourteenCharPAsswordText Method");

		return this.getContentDescValueWithXPath("err.pswdmstbe.frtnchrctrs.signup");
		//return lblMoreThanFourteenCharPassword.getAttribute("content-desc");
	}
	
    public void scrollToPasswordText() throws Exception {
		
		Thread.sleep(5000);
		
		this.verticalScroll2();
	}
}
