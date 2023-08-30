package com.gencare.tests;

import static org.testng.Assert.assertTrue;

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
import com.gencare.pages.SignUpPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("SignUp")
@Feature("SignUp Functionality Test")
public class SignUpTest extends BaseAutomationTest {
	private SignUpPage signUp = null;
	private LandingPage landingPage = null;
	private SignUpAssertionsPage signUpPage = null;
	private static final Logger logger = Logger.getLogger(SignUpTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SignUpFieldsTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGN_UP_DRIVER_TEST);
		new SignInPage(this.getMobileDriver(udid));
		this.signUp = new SignUpPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.signUpPage = new SignUpAssertionsPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in SignUpFieldsTest");
	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting of Landing Page");

		try {
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			String getWelcomeToSalusTitle = this.landingPage.getWelcomeToSalusText();
			Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			String signUpButton = this.landingPage.getSignUpButtonText();
			Assert.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signup.button.text"));

		} catch (Exception e) {

			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending of Landing Page");

	}

	@Test(priority = 2, description = "Verify SignUp")
	@Description("Test Description:Verify SignUp")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify SignUp")
	public void verifySignUp() {
		logger.info("Starting Of Signup Method");

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
			
			signUp.verticalScrollUp();
			signUp.verticalScrollUp();
			signUp.clickOnLanguageButton();
			signUp.clickOnSelectLanguageOption();
			signUp.clickAndEnterFirstName(testDataProp.getProperty("firstName"));
			signUp.clickAndEnterLastName(testDataProp.getProperty("lastName"));
			// String
			// newEmail=testDataProp.getProperty("name")+System.currentTimeMillis()+testDataProp.getProperty("value");
			signUp.clickAndEnterValidEmailAdress();
			signUp.clickOnConfirmValidEmailAddress();
			signUp.clickAndEnterPassword(testDataProp.getProperty("signUpPassword"));
			this.signUp.verticalScroll2();
			signUp.clickAndEnterConfirmNewPassword(testDataProp.getProperty("confirmNewPassword"));
			signUp.clickOnCountryDropdown();
			signUp.selectCountry();
			signUp.clickAndEnterMobileNumber(testDataProp.getProperty("signUpMobileNumber"));
			Thread.sleep(3000);
			signUp.clickOnTermsAndConditionsCheckBox();
			signUp.clickOnPrivacyNoticeCheckBox();
			signUp.clickOnYesCheckBox();
			signUp.clickOnCreateMyProfile();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On SignUpPage : " + e.getMessage());
			logger.error("Error occured while testing On SignUpPage: " + e);
		}
		logger.info("Ending Of Signup Method");
	}

	@Test(priority = 3, description = "Verify Email Confirmation Page")
	@Description("Test Description: Verify Email Confirmation Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Email ConfirmationPage")
	public void verifyEmailConfirmationPage() {
		logger.info("Starting Of  Email Confirmation Page");

		try {

			String getWelcomeToSalusTitle = this.signUp.getWelcomeToSalusText();
			Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

			assertTrue(signUp.displyEmailFldBtn());

			assertTrue(signUp.displyBackNavigatinIcon());
			
			String getConfirmationCodeLblTitle = this.signUp.getConfirmationCodeLbl();
			Assert.assertEquals(getConfirmationCodeLblTitle,
					expectedAssertionsProp.getProperty("confirm.code.text"));

			String getResendCodeToEmailTitle = this.signUp.getResendCodeToEmailText();
			Assert.assertEquals(getResendCodeToEmailTitle,
					expectedAssertionsProp.getProperty("resendCodeToEmail.text"));

			String getConfirmBtnTitle = this.signUp.getConfirmBtnText();
			Assert.assertEquals(getConfirmBtnTitle, expectedAssertionsProp.getProperty("confirm.text"));

			signUp.setOTP(testDataProp.getProperty("emailPackage"), testDataProp.getProperty("emailActivity"));

			Thread.sleep(3000);

			signUp.clickOnEyeIcon();
			Thread.sleep(3000);

			signUp.clickOnConfirmButton();

			Thread.sleep(10000);

		} catch (Exception e) {
			Assert.fail("Error occured while testing On verifyEmailConfirmationPage : " + e.getMessage());
			logger.error("Error occured while testing On verifyEmailConfirmationPage: " + e);
		}
		logger.info("Ending Of  Email Confirmation Page");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}
}
