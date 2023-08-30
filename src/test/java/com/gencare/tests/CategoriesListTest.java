package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.CategoriesListPage;
import com.gencare.pages.GroupListPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Categories")
@Feature("Device Categories Functionality")
public class CategoriesListTest extends BaseAutomationTest {
	private CategoriesListPage categoriesListpage = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private GroupListPage groupList = null;
	private static final Logger logger = Logger.getLogger(CategoriesListTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass Method In LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.CATEGORI_LIST_DRIVER_TEST);
		this.categoriesListpage = new CategoriesListPage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.groupList = new GroupListPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass Method In LoginTest");
	}

	@Test(priority = 1, description = "Verify Landing Page")
	@Description("Test Description: Verify The Landing Page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting of Landing Page Method");

		try {

			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			//Thread.sleep(4000);
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			//Thread.sleep(6000);

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
		logger.info("Ending of Landing Page Method");

	}

	@Test(priority = 2, description = "Verify Signin")
	@Description("Test Description: Verify Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Signin")
	public void verifyLogIn() {
		logger.info("Starting of Signin Method");

		try {
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();

			Thread.sleep(1000);
			categoriesListpage.displayHumburgerMenu();
			Thread.sleep(10000);
			categoriesListpage.clickOnHamburgerMenu();
			
		} catch (Exception e) {
			Assert.fail("Error Accured While Testing Verify LogIn Page: " + e.getMessage());
			logger.error("Error Accured While Testing Verify LogIn Page: " + e);
		}
		logger.info("Ending of Signin Method");
	}

	@Test(priority = 3, description = "VerifY Equipment Functionality")
	@Description("Test Description: VerifY Equipment Functionality")
	@Severity(SeverityLevel.NORMAL)
	@Story(" Verifying Equipment")
	public void verifyEquipment() {
		logger.info("Starting Of Verify Equipment Method");

		try {
			categoriesListpage.clickOnEquipment();

			String allEquipmentTitle = this.categoriesListpage.getAllEquipmentText();
			Assert.assertEquals(allEquipmentTitle, expectedAssertionsProp.getProperty("allEquipment.text"));

			String oneTouchTitle = this.categoriesListpage.getoneTouchText();
			Assert.assertEquals(oneTouchTitle, expectedAssertionsProp.getProperty("oneTouch.text"));

			String gatewaysTitle = this.categoriesListpage.getGatewaysText();
			Assert.assertEquals(gatewaysTitle, expectedAssertionsProp.getProperty("gateways.text"));
			
		} catch (Exception e) {
			Assert.fail("Error occured while testing equipment : " + e.getMessage());
			logger.error("Error occured while testing equipment: " + e);
		}
		logger.info("Ending Of Verify Equipment Method");

	}

	@Test(priority = 4, description = "Verify All Equipment")
	@Description("Test Description: Verify All Equipment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify All Equipment")
	public void verifyAllEquipment() {
		logger.info("Starting Of Verify All Equipment Method");

		try {

			categoriesListpage.clickOnAllEquipment();

			Thread.sleep(10000);
			String getMyEquipmentTitle = this.groupList.getMyEquipmentText();
			Assert.assertEquals(getMyEquipmentTitle, expectedAssertionsProp.getProperty("myEquiment.text"));

			String getGroupTitle = this.groupList.getGroupText();
			Assert.assertEquals(getGroupTitle, expectedAssertionsProp.getProperty("groups.text"));

			String getCategoriesTitle = this.groupList.getCategoriesText();
			Assert.assertEquals(getCategoriesTitle, expectedAssertionsProp.getProperty("categories.text"));

			String getAddNewGroupTitle = this.groupList.getAddNewGroupText();
			Assert.assertEquals(getAddNewGroupTitle, expectedAssertionsProp.getProperty("add.new.group.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing AllEquipment : " + e.getMessage());
			logger.error("Error occured while testing AllEquipment: " + e);
		}
		logger.info("Ending Of Verify All Equipment Method");
	}

	@Test(priority = 5, description = "verify Categories")
	@Description("Test Description: verify Categories")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Categories")
	public void verifyCategories() {
		logger.info("Starting Of Verify Categories Method");

		try {
			categoriesListpage.clickOncategories();

			//Thread.sleep(10000);
			String getCategoriesMyEquipmentTextTitle = this.categoriesListpage.getCategoriesMyEquipmentText();
			Assert.assertEquals(getCategoriesMyEquipmentTextTitle,
					expectedAssertionsProp.getProperty("myEquiment.text"));

			//Thread.sleep(3000);
			categoriesListpage.clickOngateWaysTile();

			//Thread.sleep(10000);
			String getCategoriesAddNewEquipmentTextTitle = this.categoriesListpage.getAddNewEquipmentText();
			Assert.assertEquals(getCategoriesAddNewEquipmentTextTitle,
					expectedAssertionsProp.getProperty("categories.addnew.equipment.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing categories : " + e.getMessage());
			logger.error("Error occured while testing categories: " + e);
		}

		logger.info("Ending Of Verify Categories Method");
	}

	@AfterClass

	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");

	}

}