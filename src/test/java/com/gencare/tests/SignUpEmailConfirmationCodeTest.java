package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.pages.SignUpAssertionsPage;
import com.gencare.pages.SignUpEmailConfirmationCodePage;
import com.gencare.pages.SignUpPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Signup")
@Feature("Verify Signup emailConfirmation Code")
public class SignUpEmailConfirmationCodeTest  extends BaseAutomationTest {
	private SignUpPage signUp = null;
	private LandingPage landingPage = null;
	private SignUpAssertionsPage signUpPage = null;
	private SignUpEmailConfirmationCodePage signUpEmailPage = null;
	private static final Logger logger = Logger.getLogger(SignUpTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SignUpFieldsTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGN_UP_EMAIL_CONFIRMATION_DRIVER_TEST);
		new SignInPage(this.getMobileDriver(udid));
		this.signUp = new SignUpPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.signUpPage = new SignUpAssertionsPage(this.getMobileDriver(udid));
		this.signUpEmailPage = new SignUpEmailConfirmationCodePage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in SignUpFieldsTest");
	}

	@Test(priority = 1, description = "Verifying Landing page")
	@Description("Test Description: Verifying Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting of LandingPage method");

		try {
			Thread.sleep(6000);
			
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			Thread.sleep(4000);
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			String getWelcomeToSalusTitle = this.landingPage.getWelcomeToSalusText();
			Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			// String localWifiModeButton = this.landingPage.getLocalWifiModeButtonText();
			// Assert.assertEquals(localWifiModeButton,
			// expectedAssertionsProp.getProperty("localwifi.mode.button.text"));

			String signUpButton = this.landingPage.getSignUpButtonText();
			Assert.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signup.button.text"));

		} catch (Exception e) {

			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending of LandingPage method");

	}

	@Test(priority = 2, description = "Verifying Sign Up Page")
	@Description("Test Description:Verifying Sign Up Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Sign Up Page")
	public void testSignUp() {
		logger.info("Starting of testSignUp method");

		try {
				
			signUp.clickOnSignUpButton();

			String languageChangeButtonTitle = this.signUpPage.getLanguageChangeButtonText();
			Assert.assertEquals(languageChangeButtonTitle, expectedAssertionsProp.getProperty("english.txt"));

			String firstNameTitle = this.signUpPage.getFirstNameText();
			Assert.assertEquals(firstNameTitle, expectedAssertionsProp.getProperty("first.name.text"));

			String lastNameTitle = this.signUpPage.getLastNameText();
			Assert.assertEquals(lastNameTitle, expectedAssertionsProp.getProperty("last.name.text"));

			String emailTitle = this.signUpPage.getEmailAddressText();
			Assert.assertEquals(emailTitle, expectedAssertionsProp.getProperty("email.address.text"));

			String confirmEmailTitle = this.signUpPage.getConfirmEmailAddressText();
			Assert.assertEquals(confirmEmailTitle, expectedAssertionsProp.getProperty("confirmEmailAddress.text"));

			this.signUpPage.verticalScroll();
			String passwordTitle = this.signUpPage.getPasswordText();
			Assert.assertEquals(passwordTitle, expectedAssertionsProp.getProperty("password.text"));

			String confirmNewPasswordTitle = this.signUpPage.getConfirmNewPasswordText();
			Assert.assertEquals(confirmNewPasswordTitle, expectedAssertionsProp.getProperty("confirmNewPassword.text"));

			String countrySelectionTitle = this.signUpPage.getCountrySelectionText();
			Assert.assertEquals(countrySelectionTitle, expectedAssertionsProp.getProperty("country.text"));

			this.signUpPage.verticalScroll();
			String mobileNumberTitle = this.signUpPage.getMobileNumberText();
			Assert.assertEquals(mobileNumberTitle, expectedAssertionsProp.getProperty("+44MobileNumber.text"));

			String termsAndConditionsTitle = this.signUpPage.getTermsAndConditionsText();
			Assert.assertEquals(termsAndConditionsTitle,
					expectedAssertionsProp.getProperty("signup.terms.and.conditions.text"));

			String privacyNoticeTitle = this.signUpPage.getPrivacyNoticeText();
			Assert.assertEquals(privacyNoticeTitle, expectedAssertionsProp.getProperty("signup.privacy.notice.text"));

			String yesRadioButtonTitle = this.signUpPage.getYesRadioButtonText();
			Assert.assertEquals(yesRadioButtonTitle, expectedAssertionsProp.getProperty("yes.text"));

			String noRadioButtonTitle = this.signUpPage.getNoRadioButtonText();
			Assert.assertEquals(noRadioButtonTitle, expectedAssertionsProp.getProperty("no.text"));

			String createMyProfileTitle = this.signUpPage.getCreateMyProfileText();
			Assert.assertEquals(createMyProfileTitle, expectedAssertionsProp.getProperty("createMyProfile.text"));

			String cancelButtonTitle = this.signUpPage.getCancelButtonText();
			Assert.assertEquals(cancelButtonTitle, expectedAssertionsProp.getProperty("cancel.text"));

			//Thread.sleep(10000);
			
			signUp.verticalScrollUp();
			signUp.verticalScrollUp();
			signUp.clickAndEnterFirstName(testDataProp.getProperty("firstName"));
			signUp.clickAndEnterLastName(testDataProp.getProperty("lastName"));
			
			String newEmail=testDataProp.getProperty("name")+System.currentTimeMillis()+testDataProp.getProperty("value");
			signUp.clickAndEnterEmailAdress(newEmail);
			signUp.clickOnConfirmEmailAddress(newEmail);

			signUp.clickAndEnterPassword(testDataProp.getProperty("password"));
			this.signUp.verticalScroll2();
			signUp.clickAndEnterConfirmNewPassword(testDataProp.getProperty("password"));
			signUp.clickOnCountryDropdown();
			signUp.selectCountry();
			signUp.clickAndEnterMobileNumber(testDataProp.getProperty("signUpMobileNumber"));
			signUp.clickOnTermsAndConditionsCheckBox();
			signUp.clickOnPrivacyNoticeCheckBox();
			signUp.clickOnYesCheckBox();
			signUp.clickOnCreateMyProfile();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On SignUpPage : " + e.getMessage());
			logger.error("Error occured while testing On SignUpPage: " + e);
		}
		logger.info("Ending of testSignUp method");
	}
	
	
	
	@Test(priority = 3, description = "Verifying Email Confirmation Code")
	@Description("Test Description:Verifying Email Confirmation Code")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Email Confirmation Code")
	public void verifyConfirmationCode() throws Exception {
		logger.info("Starting of verifyConfirmationCode method");

		try {
										
			String welcomeToSalusTitle = this.signUpEmailPage.getWelcmToSalusText();
			Assert.assertEquals(welcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

			String confirmcodeEmailAddressTitle = this.signUpEmailPage.getCnfmEmailText();
			Assert.assertEquals(confirmcodeEmailAddressTitle, expectedAssertionsProp.getProperty("cnfm.code.email.address.text"));			
			
			String resendCnfmCodeTitle = this.signUpEmailPage.getResendCnfmEmailText();
			Assert.assertEquals(resendCnfmCodeTitle, expectedAssertionsProp.getProperty("resend.confirm.code.text"));
			
			String confirmbuttonTitle = this.signUpEmailPage.getConfirmButtonText();
			Assert.assertEquals(confirmbuttonTitle, expectedAssertionsProp.getProperty("confirm.button.text"));
			
			String confirmcodeTitle = this.signUpEmailPage.getCnfmCodeText();
			Assert.assertEquals(confirmcodeTitle, expectedAssertionsProp.getProperty("confirm.code.text"));
			
			signUpEmailPage.enterCnfmCodeField(testDataProp.getProperty("emailconfirmcode"));
			
			signUpEmailPage.clickOnConfirm();
			
			String incorrectCnfmCodeTitle = this.signUpEmailPage.getIncorrectCnfmCodeText();
			Assert.assertEquals(incorrectCnfmCodeTitle, expectedAssertionsProp.getProperty("incorrect.cnfm.code.text"));
			

		} catch (Exception e) {
			Assert.fail("Error occured while testing On Email Confirmation Code : " + e.getMessage());
			logger.error("Error occured while testing On Email Confirmation Code: " + e);
		}
			
		logger.info("Ending of verifyConfirmationCode method");
	}
	
	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}
	
}
