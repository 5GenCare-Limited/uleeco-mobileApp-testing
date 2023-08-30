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
import com.gencare.pages.NewUsersDashBoardPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("New User DashBoard")
@Feature("New Users DashBoard Function Test")
public class NewUsersDashBoardTest extends BaseAutomationTest {
	private NewUsersDashBoardPage dashBoardForNewUsers = null;
	private LandingPage landingPage = null;
	private SignInPage loginflowpage = null;
	private ChangePasswordPage changepasswordPage = null;
	private static final Logger logger = Logger.getLogger(NewUsersDashBoardTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in DashBoardForNewUsersTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.NEW_USER_DASHBOARD_DRIVER_TEST);
		this.dashBoardForNewUsers = new NewUsersDashBoardPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.changepasswordPage = new ChangePasswordPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in DashBoardForNewUsersTest");

	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Landing Page Method");

		try {
			this.landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));
			;

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
	@Story("Verify Signin")
		public void verifyLogIn() throws Exception {
		logger.info("Starting Of Signin Method");

		try {

			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("new.user.mail"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("new.user.password"));
			loginflowpage.clickOnLogInButton();
			
			String getActivateyourgatewayTitle = this.dashBoardForNewUsers.getActivateyourgatewayText();
			Assert.assertEquals(getActivateyourgatewayTitle,
					expectedAssertionsProp.getProperty("activate.your.gateway.text"));

			dashBoardForNewUsers.clickOnSalusIcon();
			//dashBoardForNewUsers.clickOnSalusIcon(platform);

		//	dashBoardForNewUsers.clickOnHomeButton(platform);
		} catch (Exception e) {

			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Of Signin Method");

	}

	@Test(priority = 3, description = "Verify Greating Message")
	@Description("Test Description: Verify Greating Message")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Greating Message")
		public void testGreatingMessagesFromDashboard() throws Exception {
		logger.info("Starting Of Verify Greating Message Method");
		
		try {
			String getAddNewGatewayTitle = this.dashBoardForNewUsers.getAddNewGatewayText();
			Assert.assertEquals(getAddNewGatewayTitle, expectedAssertionsProp.getProperty("addNewGateway.text"));

			String getWelcometoyourdashboardTitle = this.dashBoardForNewUsers.getWelcometoyourdashboardText();
			Assert.assertEquals(getWelcometoyourdashboardTitle,
					expectedAssertionsProp.getProperty("welcome.to.your.dashboard.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing testGreatingMessagesFromDashboard : " + e.getMessage());
			logger.error("Error accured while testing testGreatingMessagesFromDashboard: " + e);
		}
		
		logger.info("Ending Of Verify Greating Message Method");
	}

	@AfterClass
	@Parameters({"deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}
}
