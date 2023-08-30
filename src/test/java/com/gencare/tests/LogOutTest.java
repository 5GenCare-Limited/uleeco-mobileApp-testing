
package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.LandingPage;
import com.gencare.pages.LogoutPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Logout")
@Feature("Logout Functionality")
public class LogOutTest extends BaseAutomationTest {
	private SignInPage signinPage = null;
	private LogoutPage logoutPage = null;
	private LandingPage landingPage = null;
	private static final Logger logger = Logger.getLogger(LogOutTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.LOGOUT_DRIVER_TEST);
		this.signinPage = new SignInPage(this.getMobileDriver(udid));
		this.logoutPage = new LogoutPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Landing Page Method");

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
		logger.info("Ending Of Landing Page Method");

	}

	@Test(priority = 2, description = "Verify Signin")
	@Description("Test Description: Verify Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Landing Page")

	public void verifyLogIn() throws Exception {
		logger.info("Starting Of Signin Method");

		signinPage.clickOnSignInButton();
		signinPage.enterEmailField(testDataProp.getProperty("email"));
		signinPage.enterPasswordField(testDataProp.getProperty("password"));
		signinPage.clickOnLogInButton();

		logger.info("Ending Of Signin Method");

	}

	@Test(priority = 3, description = "Verify Logout Functionality")
	@Description("Test Description: Verify Logout Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Logout Functionality")
	public void verifyLogoutFunctionality() throws Exception {
		logger.info("Starting Of Verify Logout Functionality Method");
		/*
		 * try {
		 */
		logoutPage.clickOnHamBurgerMenuBtn();

		String equipmentTitle = this.logoutPage.getEquipmentText();
		Assert.assertEquals(equipmentTitle, expectedAssertionsProp.getProperty("equipment.text"));

		String userTitle = this.logoutPage.getUsersAndPermissionsText();
		Assert.assertEquals(userTitle, expectedAssertionsProp.getProperty("users.and.permission.text"));

		String settingsTitle = this.logoutPage.getSettingsText();
		Assert.assertEquals(settingsTitle, expectedAssertionsProp.getProperty("settings.text"));

		String helpTitle = this.logoutPage.getHelpText();
		Assert.assertEquals(helpTitle, expectedAssertionsProp.getProperty("help.text"));

		String legalTitle = this.logoutPage.getLegalText();
		Assert.assertEquals(legalTitle, expectedAssertionsProp.getProperty("legal.text"));
		Thread.sleep(3000);
		String logoutTitle = this.logoutPage.getLogoutText();
		Assert.assertEquals(logoutTitle, expectedAssertionsProp.getProperty("logout.text"));

		logoutPage.clickOnLogoutBtn();

		String signInButtonTitle = this.landingPage.getSignInButtonText();
		Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

		/*
		 * } catch (Exception e) {
		 * Assert.fail("Error accured while testing Logout Functionality: " +
		 * e.getMessage());
		 * logger.error("Error accured while testing Logout Functionality: " + e); }
		 */

		logger.info("Ending Of Verify Logout Functionality Method");
	}

	@AfterClass
	@Parameters({ "platform", "deviceName", "udid" })
	public void quitDriver(String platform, String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}

}
