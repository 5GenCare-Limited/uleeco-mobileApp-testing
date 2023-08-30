package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.LandingPage;
import com.gencare.pages.MyStatusPage;
import com.gencare.pages.NoInternetPopupPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("No internet")
@Feature("Verify No Internet Popup")
public class NoInternetPopupTest extends BaseAutomationTest {
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;

	private MyStatusPage myStatusPage = null;
	private NoInternetPopupPage noInternetPopupPage = null;
	private static final Logger logger = Logger.getLogger(GroupListTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.NO_INTERNET_DRIVER_TEST);
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.myStatusPage = new MyStatusPage(this.getMobileDriver(udid));

		this.noInternetPopupPage = new NoInternetPopupPage(this.getMobileDriver(udid));
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
	public void verifyLogIn() throws Exception {
		logger.info("Starting Of Verify The Signin Method");

		try {
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();
			Thread.sleep(10000);
		}
		 catch (Exception e) {
				Assert.fail("Error accured while testing Signin: " + e.getMessage());
				logger.error("Error accured while testing Signin: " + e);
			}
	
		logger.info("Ending Verify The Signin Method");
	}

	@Test(priority = 3, description = "Verifying Login With Out Internet")
	@Description("Test Description: Verifying Login With Out Internet")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Signin")
	public void verifyLogInWithNoInternet() throws Exception {
		logger.info("Starting Of Verify The Signin Method");
     
		try {
		
			Thread.sleep(4000);
			loginflowpage.ToggleWIFI();
			
			String noInternetPopupTittle = this.noInternetPopupPage.getNoInternetPopuUpText();
			Assert.assertEquals(noInternetPopupTittle, expectedAssertionsProp.getProperty("no.internet.popup"));
			
			String logoutTittle = this.noInternetPopupPage.getLogoutText();
			Assert.assertEquals(logoutTittle, expectedAssertionsProp.getProperty("logout.no.internet"));
			
			Thread.sleep(4000);
			loginflowpage.ToggleWIFI();
			Thread.sleep(14000);			
		}
		 catch (Exception e) {
				Assert.fail("Error accured while testing Login With Out Internet: " + e.getMessage());
				logger.error("Error accured while testing Login With Out Internet: " + e);
			}
		
		logger.info("Ending Verify The Signin Method");
	}
	
	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {

		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}

}
