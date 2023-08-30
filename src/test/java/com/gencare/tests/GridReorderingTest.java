package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.ChangePasswordPage;
import com.gencare.pages.GridAndReorderingPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("GridAndRecording Functionality")
@Feature("GridAndRecording Functionality")
public class GridReorderingTest extends BaseAutomationTest {
	private SignInPage loginflowpage = null;
	private GridAndReorderingPage gridAndReordering = null;
	private LandingPage landingPage = null;
	private ChangePasswordPage ChangePassword = null;
	private static final Logger logger = Logger.getLogger(GridReorderingTest.class.getName());

	@BeforeClass
	@Parameters({ "clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in GridAndReorderingTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.GRID_REORDERING_DRIVER_TEST);
		this.gridAndReordering = new GridAndReorderingPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in GridAndReorderingTest");

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
		} catch (Exception e) {
			Assert.fail("Error accured while testing verifyLogIn page: " + e.getMessage());
			logger.error("Error accured while testing verifyLogIn page: " + e);
		}
		logger.info("Ending Verify The Signin Method");
}
	
	@Test(priority = 3, description = "Verifying Grid Recording")
	@Description("Test Description: Verifying Grid Recording")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying Grid Recording")
	public void verifyGridRecording() throws Exception {
		logger.info("starting of gridRecording");

			Thread.sleep(10000);
			gridAndReordering.gridReordering();
			Thread.sleep(10000);
			gridAndReordering.dragDevice();
			
		logger.info("Ending of gridRecording");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
	}
}