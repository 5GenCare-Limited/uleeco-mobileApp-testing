
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
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Landing Page")
@Feature("Landing Functionality")
public class LandingTest extends BaseAutomationTest {

	private LandingPage landingPage = null;
	private static final Logger logger = Logger.getLogger(LandingTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform,String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LandingPage");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform,mobileConfigurationVO,MOBILE_DRIVER.LANDING_DRIVER_TEST);
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in LandingPage");
	}

	@Test(priority = 1, description = "Verify Access Location Popup Page")
	@Description("Test Description: Verify Access Location Popup Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Access Location Popup Page")
	public void testLocationPopUpPage() throws Exception {
		logger.info("Starting Of Verify Access Location Popup Page Method");

		try {
			Thread.sleep(2000);
		assertTrue(landingPage.isAllowSalusSmartPremiumToAccessThisDevicesLocationText());

		String getLocationWhileUsingTheAppTittle = landingPage.getLocationWhileUsingTheAppText();
		Assert.assertEquals(getLocationWhileUsingTheAppTittle,
				expectedAssertionsProp.getProperty("while.using.the.app"));

		String getLocationOnlyThisTimeTittle = this.landingPage.getLocationOnlyThisTimeText();
		Assert.assertEquals(getLocationOnlyThisTimeTittle, expectedAssertionsProp.getProperty("only.this.time"));
		
		assertTrue(landingPage.isLocationDontAllowButton());
Thread.sleep(4000);
		landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
		
		}catch (Exception e) {
			Assert.fail("Error occured while testing Access Location Popup Page : " + e.getMessage());
			logger.error("Error occured while testing Access Location Popup Page: " + e);
		}
		logger.info("Ending Of Verify Access Location Method");
	}

	@Test(priority = 2, description = "Verifying Video Popup Page")
	@Description("Test Description: Verifying Video Popup Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying Landing")
	public void testVideoPopUpPage() throws Exception {
		logger.info("Starting Of Verify Access To Take Picture And Video Method");

		try {
			Thread.sleep(4000);
		landingPage.isDisplyVideoIcon();

		String getAllowSalusSmartPremiumToTakePicturesAndRecordVideoTittle = this.landingPage
				.getAllowSalusSmartPremiumToTakePicturesAndRecordVideoText();		
		Assert.assertEquals(getAllowSalusSmartPremiumToTakePicturesAndRecordVideoTittle,
				expectedAssertionsProp.getProperty("allow.to.take.pictures.and.video"));

		String getVideoWhileUsingTheAppTittle = this.landingPage.getVideoWhileUsingTheAppText();
		Assert.assertEquals(getVideoWhileUsingTheAppTittle, expectedAssertionsProp.getProperty("while.using.the.app"));

		String getVideoOnlyThisTimeTittle = this.landingPage.getVideoOnlyThisTimeText();
		Assert.assertEquals(getVideoOnlyThisTimeTittle, expectedAssertionsProp.getProperty("only.this.time"));

		assertTrue(landingPage.isVideoDontAllowButton());
		Thread.sleep(4000);
		landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

		String getWelcomeToSalusTitle = this.landingPage.getWelcomeToSalusText();
		Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));
		
		}catch (Exception e) {
			Assert.fail("Error occured while testing Access Location Popup Page : " + e.getMessage());
			logger.error("Error occured while testing Access Location Popup Page: " + e);
		}
		logger.info("Ending of testVideoPopUpPage");

	}

	@Test(priority = 3, description = "Verifying Landing")
	@Description("Test Description: Verifying Landing")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying Landing")	
		public void testLandingPage() throws Exception {
		logger.info("Starting of landing");

		try {
			Thread.sleep(4000);
		String signInButtonTitle = this.landingPage.getSignInButtonText();
		Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

		String demoButtonTitle = this.landingPage.getDemoButtonText();
		Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

		String signUpButton = this.landingPage.getSignUpButtonText();
		Assert.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signUpButton.text"));

		}catch (Exception e) {
			Assert.fail("Error occured while testing Access Location Popup Page : " + e.getMessage());
			logger.error("Error occured while testing Access Location Popup Page: " + e);
		}
		logger.info("Ending Of Verify Access To Take Picture And Video Method");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
	}
}
