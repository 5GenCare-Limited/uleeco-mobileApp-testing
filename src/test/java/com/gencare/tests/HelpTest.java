package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.ChangePasswordPage;
import com.gencare.pages.HelpPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.pages.SignoutPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Help")
@Feature("Verify Required Data")
public class HelpTest extends BaseAutomationTest {
	private SignInPage loginflowpage = null;
	private HelpPage helpPage = null;
	private LandingPage landingPage = null;
	private ChangePasswordPage ChangePassword = null;
	private static final Logger logger = Logger.getLogger(HelpTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in MenuToLogoutTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.HELP_DRIVER_TEST);
		new SignoutPage(this.getMobileDriver(udid));
		this.helpPage = new HelpPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in MenuToLogoutTest");

	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Verify The Landing page Method");

		try {

			this.landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
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
	@Story("Verify The Landing Page")
	public void verifyLogIn() {
		logger.info("Starting Of Verify Signin Method");

		try {
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();
			Thread.sleep(4000);
			ChangePassword.displayHumburgerMenu();
			ChangePassword.clickOnHamburgerMenu();
		} catch (Exception e) {
		}
		logger.info("Ending Of Verify Signin Method");

	}

	@Test(priority = 3, description = "Verify Help Functionality")
	@Description("Test Description: Verify Help Functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Help Functionality")
	public void verifyHelp() {
		logger.info("Starting Of Verify Help Functionality Method");

		try {
			
			helpPage.clickOnHelpBtn();
			
			String getFAQTitle = this.helpPage.getFAQText();
			Assert.assertEquals(getFAQTitle, expectedAssertionsProp.getProperty("faq.text"));

			String getContactsupportTitle = this.helpPage.getContactSupportText();
			Assert.assertEquals(getContactsupportTitle, expectedAssertionsProp.getProperty("contactSupport.text"));

			String getaAboutThisAppTitle = this.helpPage.getAboutThisAppText();
			Assert.assertEquals(getaAboutThisAppTitle, expectedAssertionsProp.getProperty("aboutThisApp.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing Help  : " + e.getMessage());
			logger.error("Error occured while testing Help : " + e);
		}
		logger.info("Ending Of Verify Help Functionality Method");
	}

	@Test(priority = 4, description = "Verify FAQ")
	@Description("Test Description: Verify FAQ")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify FAQ")
	public void verifyFAQ() {

		logger.info("Starting Of Verify FAQ Method");
		try {
			helpPage.clickOnFAQBtn();
			Thread.sleep(5000);
			driver.navigate().back();
		} catch (Exception e) {
		}
		logger.info("Ending Of Verify FAQ Method");
	}

	@Test(priority = 5, description = "Verify About This App")
	@Description("Test Description: Verify About This App")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify About This App")
	public void verifyAboutThisApp() {
		logger.info("Starting Of Verify About This App Method");

		try {

			ChangePassword.clickOnHamburgerMenu();
			helpPage.clickOnHelpBtn();
			helpPage.clickOnAboutThisAppBtn();

			this.helpPage.implicitWait();
			String getCompanyTitle = this.helpPage.getCompanyText();
			Assert.assertEquals(getCompanyTitle, expectedAssertionsProp.getProperty("company.text"));

			String getCompanyNameTitle = this.helpPage.getCompanyNameText();
			Assert.assertEquals(getCompanyNameTitle, expectedAssertionsProp.getProperty("companyName.text"));

			String getBuildDateTitle = this.helpPage.getBuildDateText();
			Assert.assertEquals(getBuildDateTitle, expectedAssertionsProp.getProperty("buildDate.text"));

			this.helpPage.implicitWait();
			String getReleasedTitle = this.helpPage.getReleasedText();
			Assert.assertEquals(getReleasedTitle, expectedAssertionsProp.getProperty("released.text"));

			String getVersionTitle = this.helpPage.getVersionText();
			Assert.assertEquals(getVersionTitle, expectedAssertionsProp.getProperty("version.text"));

			//String getVersionNameTitle = this.helpPage.getVersionNameText();
			//Assert.assertEquals(getVersionNameTitle, expectedAssertionsProp.getProperty("versionName.text"));

			helpPage.clickOnBackBtn();

		} catch (Exception e) {
			Assert.fail("Error occured while testing DisplayReleasedDate Functionalities : " + e.getMessage());
			logger.error("Error occured while testing DisplayReleasedDate Functionalities: " + e);
		}

		logger.info("Ending Of Verify About This App Method");
	}

	@Test(priority = 6, description = "Verify Contact Support")
	@Description("Test Description:Verify Contact Support")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Contact Support")
	public void verifyContactSupport() throws Exception {
		logger.info("Starting Of Verify Contact Support Method");

		try {
			ChangePassword.clickOnHamburgerMenu();
			helpPage.clickOnHelpBtn();
			helpPage.clickOnContactSupportBtn();
			Thread.sleep(5000);
			// driver.terminateApp("com.android.chrome");
			driver.navigate().back();

		} catch (Exception e) {
			Assert.fail("Error occured while testing verifyContactSupport : " + e.getMessage());
			logger.error("Error occured while testing verifyContactSupport: " + e);
		}
		logger.info("Ending Of Verify Contact Support Method");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
	}
}
