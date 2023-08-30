package com.gencare.pages;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class SigninWithoutConfirmationCodePage extends BaseAutomationPage{

	public SigninWithoutConfirmationCodePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
private static final Logger logger = Logger.getLogger(SigninWithoutConfirmationCodePage.class.getName());
	

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnSignin;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement txtEmailfield;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement txtPasswordfield;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnLogIn;
	
	@FindBy(xpath = "//android.view.View[@content-desc = 'Welcome to SALUS']")
	private WebElement lblWelcomeToSalus;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Confirmation code has been sent to below email address']")
	private WebElement lblConfirmationCodemsg;
	
	@FindBy(xpath = "	\r\n"
			+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")
	private WebElement btnConfirmationEmailFld;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText\r\n"
			+ "")
	private WebElement btnConfirmationCodeFld;
	
	@FindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
	private WebElement btnConfirm;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Resend Confirmation Email\"]")
	private WebElement txtResendConfirmationEmail;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button[2]")
	private WebElement iconBackNavigation;
	
	@FindBy(xpath = "//android.view.View[@content-desc='User is not confirmed.']")
	private WebElement txtUserIsNotConfirmed;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.clickOnElement("while.using.the.app");
		//this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}
	
	public void clickOnSignInButton() {
		logger.info("starting of ClickingOnSignInButton");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.clickOnElement("login.button");
		//this.btnSignin.click();
		
		logger.info("ending of ClickingOnSignInButton");
	}

	public void enterEmailField(String withoutConfirmationEmail) {
		logger.info("starting of ClickingAndEnterEmailField");
		
		this.setValueWithClearWithXpath("email.text", withoutConfirmationEmail);
		//this.txtEmailfield.click();
		//this.txtEmailfield.sendKeys(withoutConfirmationEmail);
		driver.hideKeyboard();
		
		logger.info("ending of ClickingAndEnterEmailField");
	}

	public void enterPasswordField(String withoutConfirmationPassword) {
		logger.info("starting of ClickingAndEnterPasswordField");
		
		this.setValueWithClearWithXpath("password.text", withoutConfirmationPassword);
		//this.txtPasswordfield.click();
		//this.txtPasswordfield.clear();
		//this.txtPasswordfield.sendKeys(withoutConfirmationPassword);
		driver.hideKeyboard();
		
		logger.info("ending of ClickingAndEnterPasswordField");
	}

	public void clickOnLogInButton() {
		logger.info("starting of ClickingOnLogInSignInButton");
		
		try {
			Thread.sleep(10000);
			this.clickOnElement("login.button");
			//this.btnLogIn.click();
		} catch (Exception e) {
		}
		
		logger.info("ending of ClickingOnLogInSignInButton");
	}
	
	public String getWelcomeToSalusText() {
		logger.info("starting of getWelcomeToSalusText");
		logger.info("ending of getWelcomeToSalusText");
		
		return this.getContentDescValue("welcome.to.salus.text");
		//return lblWelcomeToSalus.getAttribute("content-desc");
	}
	
	public String getConfirmationCodeLbl() {
		logger.info("starting of getConfirmationCodeLbl");
		logger.info("ending of getConfirmationCodeLbl");
		
		return this.getContentDescValueWithXPath("confirmation.code.msg");
		//return lblConfirmationCodemsg.getAttribute("content-desc");
	}
	
	public 	void displyEmailFldBtn() {
		logger.info("starting of displyEmailFldBtn");
		logger.info("ending of displyEmailFldBtn");
		
		this.isDisplayed("email.text");
		//this.btnConfirmationEmailFld.isDisplayed();
	}
	
	public void displyConfirmationCodeFld() {
		logger.info("starting of displyConfirmationCodeFld");
		logger.info("ending of displyConfirmationCodeFld");
		
		this.isDisplayed("btn.email.confirmation.code");
		//this.btnConfirmationCodeFld.isDisplayed();
	}
	
	public String getConfirmBtnText(){
		logger.info("starting of getConfirmBtnText");
		logger.info("ending of getConfirmBtnText");
		
		return this.getContentDescValue("txt.confirmation.code.frgtpswd");
		//return btnConfirm.getAttribute("content-desc");
	}
	
	public String getResendCodeToEmailText() {
		logger.info("starting of getResendCodeToEmailText");
		logger.info("ending of getResendCodeToEmailText");
		
		return this.getContentDescValueWithXPath("txt.resend.confirmationcode.frgtpswd");
		//return txtResendConfirmationEmail.getAttribute("content-desc");
	}
	
	/*public void clickAndEnterConfirmationCode() throws Exception{
		this.btnConfirmationCodeFld.click();
		/*
		 * Actions a= new Actions (driver);
		 * a.sendKeys("sharath.mudimadugula@b2btesters.com").build().perform();
		 * a.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform(
		 * );
		 */
		/*EmailUtils emailUtils=new EmailUtils();
		Properties prop= new Properties();
		prop.load(new FileInputStream("C:\\B2bNew\\mobile-app-testing\\src\\test\\resources\\config-b2bmail.properties.txt"));
		List<String> emailText=emailUtils.getMessageByFromEmail(emailUtils.connectToGmail(prop),"Inbox","no-reply@verificationemail.com","Your verification code");
		if(emailText.size()<1)
			
			throw new Exception("NO OTP RECIEVED");
		
		else
		{
			String regex="[^\\d]+";
			String[] arrOTP=emailText.get(0).split(regex);
			String OTP=arrOTP[1];
			System.out.println("OTP IS "+OTP);
		
		this.btnConfirmationCodeFld.sendKeys(OTP);
		}}
	 */
	public void clickOnConfirmBtn() {
		logger.info("starting of clickOnConfirmBtn");
		
		this.clickOnElement("btn.confirm");
		//this.btnConfirm.click();
		
		logger.info("ending of clickOnConfirmBtn");
	}
	
	public void displyBackNavigatinIcon() {
		logger.info("starting of displyBackNavigatinIcon");
		logger.info("ending of displyBackNavigatinIcon");
		
		this.isDisplayed("btn.back.navigation");
		//this.iconBackNavigation.isDisplayed();
	}
	public void clickOnBackNavigationIcon() {
		logger.info("starting of clickOnBackNavigationIcon");
		logger.info("ending of clickOnBackNavigationIcon");
		
		this.clickOnElement("btn.back.navigation");
		//this.iconBackNavigation.click();
	}
	
	public String getUserIsNotConfirmedText() {
		logger.info("starting of getUserIsNotConfirmedText");
		logger.info("ending of getUserIsNotConfirmedText");
		
		this.implicitWait();
		return this.getContentDescValue("user.is.not.confirmed");
	//return txtUserIsNotConfirmed.getAttribute("content-desc");
	}
}


