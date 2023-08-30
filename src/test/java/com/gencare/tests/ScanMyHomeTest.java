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
import com.gencare.pages.GearIconToScanMyHomePage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Scan My Home")
@Feature("Scan My Home Functionality")
public class ScanMyHomeTest extends BaseAutomationTest {
	private GearIconToScanMyHomePage gearIconToScanMyHome = null;
	private LandingPage landingPage = null;
	private SignInPage loginflowpage = null;
	private ChangePasswordPage ChangePassword = null;
	private static final Logger logger = Logger.getLogger(ScanMyHomeTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in GearIconToScanMyHomeTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO, MOBILE_DRIVER.SCAN_MY_HOME_DRIVER_TEST);
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.gearIconToScanMyHome = new GearIconToScanMyHomePage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in GearIconToScanMyHomeTest");
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
			// expectedAssertionsProp.getProperty("local.wifi.mode.button.text"));

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
	public void verifyLogIn() {
		logger.info("Starting Of verifyLogIn Method");

		try {
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();

			assertTrue(ChangePassword.displayHumburgerMenu());
		} catch (Exception e) {
			Assert.fail("Error occured while testing On verify LogIn : " + e.getMessage());
			logger.error("Error occured while testing On verify LogIn: " + e);
		}
		logger.info("Ending Of verifyLogIn Method");

	}

	@Test(priority = 3, description = "Verify Scan My Home")
	@Description("Test Description: Verify Scan My Home")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Scan My Home")
	public void verifyScanMyHome() throws Exception {
		logger.info("starting Of Verify Scan My Home Method");

		try {
			gearIconToScanMyHome.clickOnGearIconBtn();

			String getScanMyHomeTitle = this.gearIconToScanMyHome.getScanMyHomeText();
			Assert.assertEquals(getScanMyHomeTitle, expectedAssertionsProp.getProperty("scanMyHome.text"));

			gearIconToScanMyHome.clickOnScanMyHomebtn();

			String getScanCompletedTitle = this.gearIconToScanMyHome.getScanCompletedText();
			Assert.assertEquals(getScanCompletedTitle, expectedAssertionsProp.getProperty("scanCompleted.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing On ScanMyHome : " + e.getMessage());
			logger.error("Error occured while testing On ScanMyHome: " + e);
		}
		logger.info("Ending Of Verify Scan My Home Method");
	}

	@Test(priority = 4, description = "Verify Scan My Devices")
	@Description("Test Description: Verify Scan My Devices")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Scan My Devices")
	public void verifyScannedDevice() throws Exception {
		logger.info("Starting Of verifyScannedDevice Method");

		try {

			/*
			 * String getScanCompletedTitle =
			 * this.gearIconToScanMyHome.getScanMyHomeGatewayText();
			 * Assert.assertEquals(getScanCompletedTitle,
			 * expectedAssertionsProp.getProperty("scanMyHome.gateway.text"));
			 */
			Thread.sleep(3000);
			gearIconToScanMyHome.clickGatewayText();
			// gearIconToScanMyHome.displayECM600Icon();
			gearIconToScanMyHome.clickOnBackBtn();

			assertTrue(gearIconToScanMyHome.displayEyeIcon());

			gearIconToScanMyHome.clickOnEyeIcon();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On verifyScannedDevice : " + e.getMessage());
			logger.error("Error occured while testing On verifyScannedDevice: " + e);
		}
		logger.info("Ending Of verifyScannedDevice Method");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}
}
