package com.gencare.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.ChangePasswordPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInNegativePage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Login")
@Feature("Login Functionality")
public class SignInTest extends BaseAutomationTest {
	private SignInPage signinpage = null;
	private LandingPage landingPage = null;
	private ChangePasswordPage ChangePassword = null;
	private SignInNegativePage signIn = null;
	private static final Logger logger = Logger.getLogger(SignInTest.class.getName());

	@BeforeClass

	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGN_IN_DRIVER_TEST);
		this.signinpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		this.signIn = new SignInNegativePage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify SignIn")
	@Description("Test Description: Verify SignIn")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify SignIn")
		public void verifySignIn() {
		logger.info("Starting Of SignIn Method");

		try {
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();
			signinpage.clickOnSignInButton();
		
			String getKeepMeLoggedInTittle = this.signinpage.getKeepMeLoggedInText();
			Assert.assertEquals(getKeepMeLoggedInTittle, expectedAssertionsProp.getProperty("keep.me.logged.in"));

			signinpage.clickAndClearPasswordEmail();			
			signinpage.clickOnLogInButton();
			
			String logInWithOutEmailTitle = this.signIn.getLogInWithOutEmailText();
			Assert.assertEquals(logInWithOutEmailTitle,
					expectedAssertionsProp.getProperty("thisFieldsIsRequired.text"));
			
			signinpage.setEmailField(testDataProp.getProperty("invaliduseremail"));
			signinpage.setPasswordField(testDataProp.getProperty("password"));
			signinpage.clickOnLogInButton();

			String getYourEmailAndPasswordIsIncorrectTittle = this.signinpage.getYourEmailAndPasswordIsIncorrectText();
			Assert.assertEquals(getYourEmailAndPasswordIsIncorrectTittle,
					expectedAssertionsProp.getProperty("invalid.email.or.password"));
			
			
			signinpage.setEmailField(testDataProp.getProperty("email"));
			signinpage.clickonKeepMeLoggedInCheckbox();
			signinpage.clickOnLogInButton();
			
			assertTrue(ChangePassword.displayHumburgerMenu());		

		} catch (Exception e) {
			Assert.fail("Error occured while testing On SignInPage : " + e.getMessage());
			logger.error("Error occured while testing On SignInPage: " + e);
		}
		logger.info("Ending Of SignIn Method");
	}
	
	@Test(priority = 2, description = "Verify Keep Me Logged In")
	@Description("Test Description: Verify Keep Me Logged In")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Keep Me Logged In")
	public void verifyKeepMeSignedIn() {
		logger.info("Starting Of Verify Keep Me Logged In Method");

		try {
			this.getCurrentPackage();
			this.terminateApp();
			this.relaunchApplicationWithoutReset();
			
			assertTrue(ChangePassword.displayHumburgerMenu());
			
		} catch (Exception e) {
			Assert.fail("Error occured while testing On verifyKeepMeSignedIn : " + e.getMessage());
			logger.error("Error occured while testing On verifyKeepMeSignedIn: " + e);
		}
		logger.info("Ending Of Verify Keep Me Logged In Method");
	}


	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}

}
