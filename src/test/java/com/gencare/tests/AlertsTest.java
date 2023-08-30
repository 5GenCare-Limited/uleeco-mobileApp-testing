package com.gencare.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.AlertsPage;
import com.gencare.pages.ExistingUsersDashBoardPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.MyStatusPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Gateway Dashboard")
@Feature("Verify Alerts")
public class AlertsTest extends BaseAutomationTest {

	private ExistingUsersDashBoardPage existingUsersDashBoard = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private AlertsPage alertsPage = null;
	private static final Logger logger = Logger.getLogger(AlertsTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO, MOBILE_DRIVER.ALERT_DRIVER_TEST);
		this.existingUsersDashBoard = new ExistingUsersDashBoardPage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.alertsPage = new AlertsPage(this.getMobileDriver(udid));
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
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

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

			assertTrue(existingUsersDashBoard.displyAlertIconText());
		} catch (Exception e) {
			Assert.fail("Error accured while testing verifyLogIn page: " + e.getMessage());
			logger.error("Error accured while testing verifyLogIn page: " + e);
		}
		logger.info("Ending Verify The Signin Method");
	}

	@Test(priority = 3, description = "Verify Alerts")
	@Description("Test Description: Verify Alerts")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Alerts")
	public void verifyAlerts() throws Exception {
		logger.info("Starting Of Verify Alerts Method");

		Thread.sleep(5000);

		alertsPage.clickOnAlertIcon();
		Thread.sleep(4000);
		String alertsTittle = this.alertsPage.getAlertsText();
		Assert.assertEquals(alertsTittle, expectedAssertionsProp.getProperty("txtAlerts"));

		logger.info("Ending of Verify Alerts Method");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {

		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");

	}

}
