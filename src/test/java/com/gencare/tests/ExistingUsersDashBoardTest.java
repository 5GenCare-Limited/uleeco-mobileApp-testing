package com.gencare.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.ExistingUsersDashBoardPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("User DashBoard")
@Feature("Existing User DashBoard Functionality")
public class ExistingUsersDashBoardTest extends BaseAutomationTest {

	private ExistingUsersDashBoardPage existingUsersDashBoard = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private static final Logger logger = Logger.getLogger(ExistingUsersDashBoardTest.class.getName());

	@BeforeClass

	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of ExistingUsersDashBoardTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.EXISTING_USER_DRIVER_TEST);
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.existingUsersDashBoard = new ExistingUsersDashBoardPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		logger.info("Ending of ExistingUsersDashBoardTest  ");
	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Verify Landing page Method");

		try {
			this.landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			AssertJUnit.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			AssertJUnit.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			// String localWifiModeButton = this.landingPage.getLocalWifiModeButtonText();
			// Assert.assertEquals(localWifiModeButton,
			// expectedAssertionsProp.getProperty("local.wifi.mode.button.text"));

			String signUpButton = this.landingPage.getSignUpButtonText();
			AssertJUnit.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signup.button.text"));

		} catch (Exception e) {
			AssertJUnit.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Of Verify Landing page Method");

	}

	@Test(priority = 2, description = "Verify Signin")
	@Description("Test Description: Verify Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Signin")
	public void verifyLogIn() {
		logger.info("Starting Of Verify Signin Method");

		try {
			
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();

		} catch (Exception e) {
			AssertJUnit.fail("Error accured while testing verifyLogIn page: " + e.getMessage());
			logger.error("Error accured while testing verifyLogIn page: " + e);
		}
		logger.info("Ending Of Verify Signin Method");

	}

	@Test(priority = 3, description = "Verify Hamburger Menu")
	@Description("Test Description:Verify Hamburger Menu")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Hamburger Menu")
	public void verifyHamburgerMenuBtn() {
		logger.info("starting Of Verify Hamburger Menu Button Method");

		try {
			Thread.sleep(8000);
			existingUsersDashBoard.displayHumBurgerMenu();
		} catch (Exception e) {
			AssertJUnit.fail("Error accured while testing verifyHamburgerMenuBtn page: " + e.getMessage());
			logger.error("Error accured while testing verifyHamburgerMenuBtn page: " + e);
		}
		logger.info("Ending Of Verify Hamburger Menu Button Method");
	}

	@Test(priority = 4, description = "Verify Alert Icon")
	@Description("Test Description:Verify Alert Icon")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Alert Icon")
	public void verifyAlertIconBtn() {
		logger.info("starting Of Verify Alert Icon Method");

		try {
			Thread.sleep(6000);
			assertTrue(existingUsersDashBoard.displyAlertIconText());

		} catch (Exception e) {
			AssertJUnit.fail("Error accured while testing verifyAlertIconBtn page: " + e.getMessage());
			logger.error("Error accured while testing verifyAlertIconBtn page: " + e);
		}
		logger.info("Ending of gear icon");
	}

	@Test(priority = 5, description = "Verifying GearIcon")
	@Description("Test Description:Verifying GearIcon")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying GearIcon")
	public void verifyGearIcon() {
		logger.info("starting of gear icon");

		try {
			Thread.sleep(6000);
			assertTrue(existingUsersDashBoard.displayGearIcon());

		} catch (Exception e) {
			AssertJUnit.fail("Error accured while testing verifyGearIcon page: " + e.getMessage());
			logger.error("Error accured while testing verifyGearIcon page: " + e);
		}
		logger.info("Ending of gear icon");
	}

	@Test(priority = 6, description = "Verify Gateway Image Time")
	@Description("Test Description:Verify Gateway Image Time")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Gateway Image Time")
	public void verifyGatewayImageTime() {
		logger.info("starting Of Verify Gateway Image Time Method");

		try {
			Thread.sleep(6000);
			existingUsersDashBoard.displayGatewayTimeImage();

		} catch (Exception e) {
			AssertJUnit.fail("Error accured while testing verifyGatewayImageTime page: " + e.getMessage());
			logger.error("Error accured while testing verifyGatewayImageTime page: " + e);
		}
		logger.info("Ending Of Verify Gateway Image Time Method");
	}

	@Test(priority = 7, description = "Verify Pinned Device")
	@Description("Test Description:Verify Pinned Device")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Pinned Device")
	public void verifyPinnedDevice() {
		logger.info("starting Of Verify Pinned Device Method");

		try {
			Thread.sleep(6000);
			existingUsersDashBoard.displayPinnedDevice();

		} catch (Exception e) {
			AssertJUnit.fail("Error accured while testing verifyPinnedDevice page: " + e.getMessage());
			logger.error("Error accured while testing verifyPinnedDevice page: " + e);
		}
		logger.info("Ending Of Verify Alert Icon Method");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
	}
}
