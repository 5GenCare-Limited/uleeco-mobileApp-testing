package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.LandingPage;
import com.gencare.pages.SignUpAssertionsPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Signup")
@Feature("Signup Assertions")
public class SignUpAssertionsTest extends BaseAutomationTest {

	private SignUpAssertionsPage signUpPage = null;
	LandingPage landingPage = null;
	
	private static final Logger logger = Logger.getLogger(SignUpAssertionsTest.class.getName());

	@BeforeClass
	@Parameters({ "clientApiKey", "platform","deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SignUpPage");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGN_UP_ASSERTION_DRIVER_TEST);
		
		this.signUpPage = new SignUpAssertionsPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));

		logger.info("Ending of initClass method in SignUpPage");

	}

	@Test(priority = 1, description = "testing on signup button")
	@Description("Test Description: Verify The signup button")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The signup button")
	public void testSignUpButton() throws Exception {
		logger.info("Starting Of Test Signup Button Method");

		try {
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			String signUpButton = this.landingPage.getSignUpButtonText();
			Assert.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signup.button.text"));
			
			signUpPage.clickOnSignUpButton();

		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Of Test Signup Button Method");
	}

	@Test(priority = 2, description = "testing on signup page")
	@Description("Test Description: Verify The signup page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The signup page")
	public void testSignupPage() throws Exception {
		logger.info("Starting Of Verify The signup page Method");

		try {

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

		} catch (Exception e) {
			Assert.fail("Error occured while testing On SignUpPage : " + e.getMessage());
			logger.error("Error occured while testing On SignUpPage: " + e);
		}

		logger.info("ending of SignUpPage methods");

	}

	@Test(priority = 3, description = "testing on ValidationPassword")
	@Description("Test Description: Verify The ValidationPassword")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The ValidationPassword")
	public void testValidationPassword() throws Exception {
		logger.info("Starting of initClass method in testValidationPassword");

		try {

			signUpPage.verticalScrollUp();

			String validationPasswordTitle = this.signUpPage.getValidationPasswordText();
			Assert.assertEquals(validationPasswordTitle,
					expectedAssertionsProp.getProperty("validation.fourteen.characters.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing On SignUpNegativePage : " + e.getMessage());
			logger.error("Error occured while testing On SignUpNegativePage: " + e);
		}

		logger.info("ending of Of Verify The signup page Method");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}
}
