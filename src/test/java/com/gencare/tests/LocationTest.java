package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.LandingPage;
import com.gencare.pages.LocationPage;
import com.gencare.pages.MyStatusPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LocationTest extends BaseAutomationTest {

	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private LocationPage locationPage = null;
	private MyStatusPage myStatusPage = null;
	private static final Logger logger = Logger.getLogger(GroupListTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey,  String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.LOCATION_DRIVER_TEST);
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.locationPage = new LocationPage(this.getMobileDriver(udid));
		this.myStatusPage = new MyStatusPage(this.getMobileDriver(udid));
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
			myStatusPage.displayHumBurgerMenu();
			myStatusPage.clickOnHamburgerMenuBtn();
		} catch (Exception e) {
			Assert.fail("Error accured while testing verifyLogIn page: " + e.getMessage());
			logger.error("Error accured while testing verifyLogIn page: " + e);
		}
		logger.info("Ending Verify The Signin Method");
}
	
	

	@Test(priority = 3, description = "Verify Location")
	@Description("Test Description: Verify Location")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Location")
	public void verifyLocation() throws Exception {
		logger.info("Starting Of verifyLocation Method");

			Thread.sleep(4000);
			locationPage.clickOnLocationButton();
			Thread.sleep(4000);
	    
			String addNewLocationText = this.locationPage.getAddNewLocationText();
			Assert.assertEquals(addNewLocationText, expectedAssertionsProp.getProperty("add.location.text"));
		
			locationPage.clickOnLocationFirstGatewayButton();
			Thread.sleep(4000);
			locationPage.displayGatewayImage();
			
		logger.info("Ending of verifyLocation Method");
}
	@Test(priority = 4, description = "Verify Location")
	@Description("Test Description: Verify Location")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Location")
	public void verifyAddLocation() throws Exception {
		logger.info("Starting Of verifyLocation Method");

			Thread.sleep(4000);
			myStatusPage.clickOnHamburgerMenuBtn();
			Thread.sleep(4000);
			locationPage.clickOnLocationButton();

			locationPage.clickOnAddLocationButton();
			Thread.sleep(4000);
			
			String chooseConnectionModeTittle = this.locationPage.getChooseConnectionModeText();
			Assert.assertEquals(chooseConnectionModeTittle, expectedAssertionsProp.getProperty("choose.connection.mode"));
		
		logger.info("Ending of verifyLocation Method");
}
	
	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}
	
}


