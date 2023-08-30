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
import com.gencare.pages.SigninWithoutConfirmationCodePage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("sign in with out confirmation code:")
@Feature("CategoriesList function Test")

public class SigninWithoutConfirmationCodeTest extends BaseAutomationTest {
	
	SigninWithoutConfirmationCodePage signinWithoutConfirmationCodePage = null;
	LandingPage landingPage = null;
	
	private static final Logger logger = Logger.getLogger(SigninWithoutConfirmationCodeTest.class.getName());

	@BeforeClass
	@Parameters({ "clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SigninWithoutConfirmationCodeTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGN_WITH_0UT_CONFIRMATION_CODE_DRIVER_TEST);
		
		this.signinWithoutConfirmationCodePage = new SigninWithoutConfirmationCodePage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		
		logger.info("Ending of initClass method in SigninWithoutConfirmationCodeTest");
	}

	@Test(priority = 1, description = "Verify The Landing page")
	@Description("Test Description: Verify The Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void testLandingPage() throws Exception {
		logger.info("Starting of TestLandingPage method");
	
		try {
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

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
		logger.info("Ending of TestLandingPage method");

	}

	@Test(priority = 2, description = "Verifying on login page")
	@Description("Test Description: Verifying on login page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Login page")
	public void testLoginPageWithoutVerifyingconfirmationCode() throws Exception {
		logger.info("Starting of testLoginPageWithoutVerifyingconfirmationCode method");
		try {

			signinWithoutConfirmationCodePage.clickOnSignInButton();
			signinWithoutConfirmationCodePage.enterEmailField(testDataProp.getProperty("with.out.Confirmation.Email"));
			signinWithoutConfirmationCodePage
					.enterPasswordField(testDataProp.getProperty("with.out.Confirmation.Password"));
			signinWithoutConfirmationCodePage.clickOnLogInButton();

		} catch (Exception e) {
			Assert.fail("Error accured while testing login page: " + e.getMessage());
			logger.error("Error accured while testing login page: " + e);
		}
		logger.info("Ending of testLoginPageWithoutVerifyingconfirmationCode method");

	}

	@Test(priority = 3, description = "Verifying on confirmation code page")
	@Description("Test Description: Verifying on confirmation code page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Login page")
	public void testConfirmationCodePage() throws Exception {
		logger.info("Starting of testConfirmationCodePage method");

		try {
			
			String getWelcomeToSalusTitle = this.signinWithoutConfirmationCodePage.getWelcomeToSalusText();
			Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

//			signinWithoutConfirmationCodePage.displyEmailFldBtn();
//
//			signinWithoutConfirmationCodePage.displyConfirmationCodeFld();
//
//			signinWithoutConfirmationCodePage.displyBackNavigatinIcon();

			String getConfirmationCodeLblTitle = this.signinWithoutConfirmationCodePage.getConfirmationCodeLbl();
			Assert.assertEquals(getConfirmationCodeLblTitle,
					expectedAssertionsProp.getProperty("confirmationCodeLbl.text"));

			String getResendCodeToEmailTitle = this.signinWithoutConfirmationCodePage.getResendCodeToEmailText();
			Assert.assertEquals(getResendCodeToEmailTitle,
					expectedAssertionsProp.getProperty("resendCodeToEmail.text"));

			String getConfirmBtnTitle = this.signinWithoutConfirmationCodePage.getConfirmBtnText();
			Assert.assertEquals(getConfirmBtnTitle, expectedAssertionsProp.getProperty("confirm.text"));
			
		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending of testConfirmationCodePage method");
	}

	/*
	 * @Test(priority = 4, description = "Verifying on confirmation code page")
	 * 
	 * @Description("Test Description: Verifying on confirmation code page")
	 * 
	 * @Severity(SeverityLevel.BLOCKER)
	 * 
	 * @Story("Verify The Login page") public void testConfirmationCode() throws
	 * Exception{ Thread.sleep(5000);
	 * signinWithoutConfirmationCodePage.clickAndEnterConfirmationCode(); }
	 */

	@Test(priority = 5, description = "Verifying on confirmation code page")
	@Description("Test Description: Verifying on confirmation code page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Login page")
	public void testBackIcon() throws Exception {
		logger.info("Starting of testBackIcon method");

		try {
			
			Thread.sleep(3000);
			signinWithoutConfirmationCodePage.clickOnBackNavigationIcon();

		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending of testBackIcon method");
	}

	@Test(priority = 5, description = "Verifying on confirmation code page")
	@Description("Test Description: Verifying on confirmation code page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Login page")
	public void verifyUserIsNotConfirmedText() {
		logger.info("Starting of verifyUserIsNotConfirmedText method");

		try {
			String getUserIsNotConfirmedTitle = this.signinWithoutConfirmationCodePage.getUserIsNotConfirmedText();
			Assert.assertEquals(getUserIsNotConfirmedTitle,
					expectedAssertionsProp.getProperty("userIsNotConfirmed.text"));
		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending of verifyUserIsNotConfirmedText method");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}

}
