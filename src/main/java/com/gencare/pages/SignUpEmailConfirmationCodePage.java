package com.gencare.pages;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import io.appium.java_client.android.AndroidDriver;

	public class SignUpEmailConfirmationCodePage extends BaseAutomationPage {

		public SignUpEmailConfirmationCodePage(AndroidDriver<WebElement> driver) {
			super(driver);
		
		}
		private static final Logger logger = Logger.getLogger(SignUpPage.class.getName());

		@FindBy(xpath = "//android.view.View[@content-desc='Welcome to SALUS']")
		private WebElement lblWelcomeToSalus;
		
		@FindBy(xpath = "//android.view.View[@content-desc='Confirmation code has been sent to below email address']")
		private WebElement lblCnfmEmail;
		
		@FindBy(xpath = "//android.widget.EditText[@text='Confirmation code']")
		private WebElement lblCnfmCode;
		
		@FindBy(xpath = "//android.view.View[@content-desc='Resend Confirmation Email']")
		private WebElement lblResendCnfmEmail;
			
		@FindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
		private WebElement lblConfirmButton;
		
		@FindBy(xpath = "//android.widget.EditText[@text='Confirmation code']")
		private WebElement txtCnfmCode;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Incorrect confirmation code ']")
		private WebElement ldlIncorrectCnfmCode;
		
		@FindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
		private WebElement btnConfirm;
		
		
		public String getWelcmToSalusText() throws InterruptedException {
			logger.info("starting of getWelcmToSalusText method");
			logger.info("ending of getWelcmToSalusText method");
			
			return this.getContentDescValueWithXPath("lbl.welcome.to.salus.signup");
			//return lblWelcomeToSalus.getAttribute("content-desc");
		}

		public String getCnfmEmailText() throws InterruptedException {
			logger.info("starting of getCnfmEmailText method");
			logger.info("ending of getCnfmEmailText method");
			
			return this.getContentDescValueWithXPath("lbl.confirm.email.signup");
			//return lblCnfmEmail.getAttribute("content-desc");
				
		}
		
		public String getCnfmCodeText() throws InterruptedException {
			logger.info("starting of getCnfmCodeText method");
			logger.info("ending of getCnfmCodeText method");
			
			return this.getTextValueWithXpath("lbl.confirmation.codemsg.signup");
			//return lblCnfmCode.getText();
				
		}
		
		public String getResendCnfmEmailText() throws InterruptedException {
			logger.info("starting of getResendCnfmEmailText method");
			logger.info("ending of getResendCnfmEmailText method");
			
			return this.getContentDescValueWithXPath("txt.resend.confirmationcode.signup");
			//return lblResendCnfmEmail.getAttribute("content-desc");	
			
		}
		
		public String getConfirmButtonText() throws InterruptedException {
			logger.info("starting of getConfirmText method");
			logger.info("ending of getConfirmText method");
			
			return this.getContentDescValueWithXPath("btn.confirm.signup");
			//return lblConfirmButton.getAttribute("content-desc");	
			
		}
		
		public void enterCnfmCodeField(String emailconfirmcode) {
			logger.info("starting of enterCnfmCodeField");

			this.setValueWithClearWithXpath("lbl.confirmation.codemsg.signup", emailconfirmcode);
			//this.txtCnfmCode.click();
			//this.txtCnfmCode.sendKeys(emailconfirmcode);
			driver.hideKeyboard();

			logger.info("ending of enterCnfmCodeField");
		}
		
		public void clickOnConfirm() throws Exception {
			logger.info("starting of clickOnConfirm");

			this.clickOnElementWithXpath("btn.confirm.signup");
			//this.btnConfirm.click();
			
			logger.info("ending of clickOnConfirm");
		}
		
		
		public String getIncorrectCnfmCodeText() throws Exception {
			logger.info("starting of getIncorrectCnfmCodeText method");
			logger.info("ending of getIncorrectCnfmCodeText method");
			
			return this.getContentDescValue("err.incorrect.cnfrmncode.frggtpswd");
			//return ldlIncorrectCnfmCode.getAttribute("content-desc");	
			
		}
			
	}


