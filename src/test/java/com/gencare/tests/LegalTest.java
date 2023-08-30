package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.ChangePasswordPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.LegalPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Leagal Functionality")
@Feature("Leagal Functionality")
public class LegalTest extends BaseAutomationTest {

	private LegalPage legal = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private ChangePasswordPage ChangePassword = null;
	private static final Logger logger = Logger.getLogger(LegalTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform","deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform,mobileConfigurationVO,MOBILE_DRIVER.LEGAL_DRIVER_TEST);
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.legal = new LegalPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in LoginTest");
	}
	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify The Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Verify The Landing page Method");

		try {

			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			Thread.sleep(4000);
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			Thread.sleep(6000);

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			/*
			 * String localWifiModeButton = this.landingPage.getLocalWifiModeButtonText();
			 * Assert.assertEquals(localWifiModeButton,
			 * expectedAssertionsProp.getProperty("localwifi.mode.button.text"));
			 */

			String signUpButton = this.landingPage.getSignUpButtonText();
			Assert.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signup.button.text"));

		} catch (Exception e) {

			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Of Verify The Landing page Method");

	}

	@Test(priority = 2, description = "Verifying Signin")
	@Description("Test Description: Verifying Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Signin")
	public void verifyLogIn() {
		logger.info("Starting Of Verify The Signin Method");

		try {
			Thread.sleep(4000);

			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();

			Thread.sleep(10000);
			legal.displayHumBurgerMenu();
			legal.clickOnHamburgerMenuBtn();
		} catch (Exception e) {
			Assert.fail("Error accured while testing verifyLogIn page: " + e.getMessage());
			logger.error("Error accured while testing verifyLogIn page: " + e);
		}
		logger.info("Ending Verify The Signin Method");
}
	

	@Test(priority = 3, description = "Legal Functionality")
	@Description("Test Description: Legal Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Legal Functionality")
	public void verifyPrivacyNotice() {
		logger.info("starting of verifyPrivacyNotice");

		try {
			Thread.sleep(6000);
			legal.clickOnLegalButton();
			legal.verticalScroll();

			Thread.sleep(5000);
			String privacyNoticeTitle = this.legal.getPrivacyNoticeText();
			Assert.assertEquals(privacyNoticeTitle, expectedAssertionsProp.getProperty("privacyNotice.text"));

			String termsAndConditionsTitle = this.legal.getTermsAndConditionsText();
			Assert.assertEquals(termsAndConditionsTitle, expectedAssertionsProp.getProperty("terms.&.conditions.text"));

			legal.clickOnPrivacyAndNoticeBtn();
			
			String backButtonTextTitle = this.legal.getBackButtonText();
			Assert.assertEquals(backButtonTextTitle, expectedAssertionsProp.getProperty("txt.legal.back"));

			Thread.sleep(5000);
			driver.navigate().back();


		} catch (Exception e) {
			Assert.fail("Error accured while testing legal: " + e.getMessage());
			logger.error("Error accured while testing legal: " + e);
		}
		logger.info("Ending of verifyPrivacyNotice");
	}
	
	@Test(priority = 4, description = "Legal Functionality")
	@Description("Test Description: Legal Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Legal Functionality")
	public void verifyTermsAndConditions() {
		logger.info("starting of verifyTermsAndConditions");

		try {
			Thread.sleep(6000);
			legal.clickOnHamburgerMenuBtn();
			Thread.sleep(6000);
			legal.clickOnLegalButton();
			legal.verticalScroll();

			Thread.sleep(6000);
			String privacyNoticeTitle = this.legal.getPrivacyNoticeText();
			Assert.assertEquals(privacyNoticeTitle, expectedAssertionsProp.getProperty("privacyNotice.text"));

			String termsAndConditionsTitle = this.legal.getTermsAndConditionsText();
			Assert.assertEquals(termsAndConditionsTitle, expectedAssertionsProp.getProperty("terms.&.conditions.text"));

			legal.clickOnTermsAndConditionsBtn();
			Thread.sleep(5000);
			String backButtonTextTitle = this.legal.getBackButtonText();
			Assert.assertEquals(backButtonTextTitle, expectedAssertionsProp.getProperty("txt.legal.back"));
		
			driver.navigate().back();

		} catch (Exception e) {
			Assert.fail("Error accured while testing legal: " + e.getMessage());
			logger.error("Error accured while testing legal: " + e);
		}
		logger.info("Ending of verifyTermsAndConditions");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}
}