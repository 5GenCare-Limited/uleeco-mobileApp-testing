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
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("My Status")
@Feature("Create, Edit and Delete My status ")
public class MyStatusTest extends BaseAutomationTest {

	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private MyStatusPage myStatusPage = null;
	private static final Logger logger = Logger.getLogger(GroupListTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.MY_STATUS_DRIVER_TEST);
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
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
	public void verifyLogIn() {
		logger.info("Starting Of Verify The Signin Method");

		try {
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();

			Thread.sleep(10000);
			myStatusPage.displayHumBurgerMenu();
			myStatusPage.clickOnHamburgerMenuBtn();
		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Verify The Signin Method");
	}

	@Test(priority = 3, description = "Verifying Create My Status ")
	@Description("Test Description: Verifying Create My Status")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Create My Status")
	public void verifyCreateMyStatus() throws Exception {
		logger.info("Starting Of verifyCreateMyStatus");

		try {
		String myStatusTittle = this.myStatusPage.getMyStatusText();
		Assert.assertEquals(myStatusTittle, expectedAssertionsProp.getProperty("mystatus.text"));

		myStatusPage.clickOnMyStatusButton();

		String addNewStatusTittle = this.myStatusPage.getAddNewStatusText();
		Assert.assertEquals(addNewStatusTittle, expectedAssertionsProp.getProperty("add.new.status.text"));

		myStatusPage.clickOnAddNewMyStatusButton();
		
		String createNewStatusTittle = this.myStatusPage.getCreateNewStatusText();
		Assert.assertEquals(createNewStatusTittle, expectedAssertionsProp.getProperty("create.new.status.text"));

		String nameThisStatusTittle = this.myStatusPage.getNameThisStatusText();
		Assert.assertEquals(nameThisStatusTittle, expectedAssertionsProp.getProperty("name.this.status.text"));

		String selectIconForStatusTittle = this.myStatusPage.getSelectIconForStatusText();
		Assert.assertEquals(selectIconForStatusTittle,
				expectedAssertionsProp.getProperty("select.iconfor.status.text"));

		myStatusPage.clickOnAMyStatusButton();
		myStatusPage.verticalScroll();

		String continueTittle = this.myStatusPage.getContinueText();
		Assert.assertEquals(continueTittle, expectedAssertionsProp.getProperty("continue.my.status.text"));

		myStatusPage.clickOnContinueButton();
		myStatusPage.verticalScrollUp();

		String nameFieldRequiredTittle = this.myStatusPage.NameFieldRequired();
		Assert.assertEquals(nameFieldRequiredTittle, expectedAssertionsProp.getProperty("name.mystatus.required.text"));

		myStatusPage.clickOnEnterNameOfMyStatus(testDataProp.getProperty("name.of.mystatus"));
		this.verticalScroll();

		Thread.sleep(2000);
		myStatusPage.clickOnContinueButton();
		
		}catch (Exception e) {
			Assert.fail("Error accured while testing Create My Status: " + e.getMessage());
			logger.error("Error accured while testing Create My Status: " + e);
		}
		logger.info("Ending of verifyCreateMyStatus");

	}

	@Test(priority = 4, description = "verify Add OneTouch To MyStatus")
	@Description("Test Description: verify Add OneTouch To MyStatus")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add OneTouch To MyStatus")
	public void verifyAddOneTouchToMyStatus() throws Exception {
		logger.info("Starting Of verifyAddOneTouchToMyStatus");
		
		try {
		myStatusPage.clickOnOneTouchCheckBox();
		myStatusPage.clickOnSelecctMystatusRadioBtn();
		myStatusPage.clickOnSaveButtonMystatus();
		
		}catch (Exception e) {
			Assert.fail("Error accured while testing Add OneTouch To MyStatus: " + e.getMessage());
			logger.error("Error accured while testing Add OneTouch To MyStatus: " + e);
		}
		logger.info("Ending of verifyAddOneTouchToMyStatus");

	}

	@Test(priority = 5, description = "verify Edit My Status")
	@Description("Test Description: verify Edit My Status")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Edit My Status")
	public void verifyEditMyStatus() throws Exception {
		logger.info("Starting Of verifyEditMyStatus");

		try {
		myStatusPage.clickOnCreatedMystatus();
		myStatusPage.clickOnEditMystatusIcon();
		Thread.sleep(4000);
		//myStatusPage.clickOnSaveButton();
		myStatusPage.clickOnCancelButton();

		}catch (Exception e) {
			Assert.fail("Error accured while testing Create My Status: " + e.getMessage());
			logger.error("Error accured while testing Create My Status: " + e);
		}
		logger.info("Ending of verifyEditMyStatus");
	}

	@Test(priority = 6, description = "verify Delete My Status")
	@Description("Test Description: verify Delete My Status")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Delete My Status")
	public void verifyDeleteMyStatus() throws Exception {
		logger.info("Starting Of verifyDeleteMyStatus");
	
		try {

		String deleteStatusTittle = this.myStatusPage.getDeleteStatusText();
		Assert.assertEquals(deleteStatusTittle, expectedAssertionsProp.getProperty("delete.status.text"));
		
		myStatusPage.clickOnDeleteStatusButton();

		String deleteThisStatusTittle = this.myStatusPage.getDeleteThisStatusText();
		Assert.assertEquals(deleteThisStatusTittle, expectedAssertionsProp.getProperty("delete.this.status.text"));
		
		String deleteTittle = this.myStatusPage.getDeleteText();
		Assert.assertEquals(deleteTittle, expectedAssertionsProp.getProperty("delete.mystatus.button.text"));

		myStatusPage.clickOnDeleteButton();
		Thread.sleep(4000);

		}catch (Exception e) {
			Assert.fail("Error accured while testing Create My Status: " + e.getMessage());
			logger.error("Error accured while testing Create My Status: " + e);
		}
		logger.info("Ending of verifyDeleteMyStatus");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}
}