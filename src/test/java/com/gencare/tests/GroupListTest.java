package com.gencare.tests;

import static org.testng.Assert.assertTrue;

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

@Epic("Groups")
@Feature("Groups Functionality")
public class GroupListTest extends BaseAutomationTest {

	private CategoriesListPage categoriesListpage = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private GroupListPage groupList = null;
	private static final Logger logger = Logger.getLogger(CategoriesListTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.GROUP_LIST_DRIVER_TEST);
		this.categoriesListpage = new CategoriesListPage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.groupList = new GroupListPage(this.getMobileDriver(udid));
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

			assertTrue(categoriesListpage.displayHumburgerMenu());
			categoriesListpage.clickOnHamburgerMenu();

		} catch (Exception e) {

			Assert.fail("Error accured while testing login page: " + e.getMessage());
			logger.error("Error accured while testing login page: " + e);
		}
		logger.info("Ending Verify The Signin Method");
	}

	@Test(priority = 3, description = "Verify Equipment")
	@Description("Test Description: Verify Equipment")
	@Severity(SeverityLevel.NORMAL)
	@Story(" Verify Equipment")
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
			logger.error("Error occured while testing e0quipment: " + e);
		}
		logger.info("Ending Of Verify Equipment Method");

	}

	@Test(priority = 4, description = "Verify All Equipment ")
	@Description("Test Description: Verify All Equipment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify All Equipment")
	public void verifyAllEquipment() {
		logger.info("Starting Of Verify All Equipment Method");

		try {

			categoriesListpage.clickOnAllEquipment();

			String getMyEquipmentTitle = this.groupList.getMyEquipmentText();
			Assert.assertEquals(getMyEquipmentTitle, expectedAssertionsProp.getProperty("myEquiment.text"));

			String getGroupTitle = this.groupList.getGroupText();
			Assert.assertEquals(getGroupTitle, expectedAssertionsProp.getProperty("groups.text"));

			String getCategoriesTitle = this.groupList.getCategoriesText();
			Assert.assertEquals(getCategoriesTitle, expectedAssertionsProp.getProperty("categories.text"));

			String getAddNewGroupTitle = this.groupList.getAddNewGroupText();
			Assert.assertEquals(getAddNewGroupTitle, expectedAssertionsProp.getProperty("add.new.group.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing verifyAllEquipment : " + e.getMessage());
			logger.error("Error occured while testing verifyAllEquipment: " + e);
		}
		logger.info("Ending Of Verify All Equipment Method");
	}

	@Test(priority = 5, description = "Verify Groups")
	@Description("Test Description: Verify Groups")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Groups")
	public void verifyGroups() {
		logger.info("Starting Of Verify Groups Method");

		try {
			groupList.clickOnbtnAddNewGroup();
			Thread.sleep(1000);
			String getGroupingEquipmentTitle = this.groupList.getGroupingEquipmentText();
			Assert.assertEquals(getGroupingEquipmentTitle,
					expectedAssertionsProp.getProperty("grouping.equipment.text"));

			String getGiveyourGroupAnameTitle = this.groupList.getGiveyourGroupAnameText();
			Assert.assertEquals(getGiveyourGroupAnameTitle,
					expectedAssertionsProp.getProperty("give.your.group.name.text"));

			String getSelectTheGroupTitle = this.groupList.getSelectTheGroupText();
			Assert.assertEquals(getSelectTheGroupTitle, expectedAssertionsProp.getProperty("select.the.group.text"));

			groupList.clickOnAVA10M30RFcheckBox();
			groupList.clickOnAWRT10RFcheckBox();
			
			assertTrue(groupList.pinIconDisplayed());

			String getFinishTitle = this.groupList.getFinishText();
			Assert.assertEquals(getFinishTitle, expectedAssertionsProp.getProperty("finish.text"));

			//groupList.clickOnPinIcon();
			groupList.clickOnbtnFinish();

			String getErrorMessageTitle = this.groupList.getErrorMessageText();
			Assert.assertEquals(getErrorMessageTitle,
					expectedAssertionsProp.getProperty("pleaseEnterValidGroupName.text"));

			groupList.clickOnEnterNameOfEquipmentGroup(testDataProp.getProperty("b2btesters"));
			assertTrue(groupList.displayPinIcon());
			groupList.clickOnbtnFinish();
			groupList.clickOnSalusIcon();
			
		} catch (Exception e) {
			Assert.fail("Error occured while testing Groups : " + e.getMessage());
			logger.error("Error occured while testing Groups: " + e);
			e.printStackTrace();
		}
		logger.info("Ending Of Verify Groups Method Method");

	}

	@Test(priority = 6, description = "Verify Unique Name")
	@Description("Test Description: Verify Unique Name")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Unique Name")
	public void verifyUniqueGroupName() {
		logger.info("Starting Verify Unique Name Method");
		
		try {			
			categoriesListpage.clickOnHamburgerMenu();
			categoriesListpage.clickOnEquipment();
			categoriesListpage.clickOnAllEquipment();
			this.verticalScroll();
			groupList.clickOnbtnAddNewGroup();
			groupList.clickOnEnterNameOfEquipmentGroup(testDataProp.getProperty("b2btesters"));
			
			String getUniqueGroupNameTitle = this.groupList.getUniqueGroupNameText();
			Assert.assertEquals(getUniqueGroupNameTitle, expectedAssertionsProp.getProperty("unique.group.name.text"));
			Thread.sleep(3000);
			groupList.clickOnSalusIcon();

		} catch (Exception e) {
			Assert.fail("Error occured while testing Unique Name : " + e.getMessage());
			logger.error("Error occured while testing Unique Name: " + e);
			e.printStackTrace();
		}
		logger.info("Ending Of Verify Unique Name Method");

	}

	@Test(priority = 7, description = "Verify Created Group")
	@Description("Test Description: Verify Created Group")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Created Group")
	public void verifyCreatedGroup() {
		logger.info("Starting Verify Created Group Method");
		
		try {
		
			assertTrue(groupList.displayDashBoardCreatedGroup());
			groupList.clickOnCloseGroup();

		} catch (Exception e) {
			Assert.fail("Error occured while testing Created Group : " + e.getMessage());
			logger.error("Error occured while testing Created Group: " + e);
			e.printStackTrace();
		}
		logger.info("Ending Of Verify Created Group Method");
	}

	@Test(priority = 8, description = "Verify Delete Group")
	@Description("Test Description: Verify Delete Group")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Delete Group")
	public void verifyDeleteGroup() {
		logger.info("Starting Verify Delete Group Method");
		
		try {			
			categoriesListpage.clickOnHamburgerMenu();
			categoriesListpage.clickOnEquipment();
			categoriesListpage.clickOnAllEquipment();

			assertTrue(groupList.displayCreatedGroup());

			groupList.clickOnCreatedGroup();
			
			assertTrue(groupList.isEditButtonDisplayed());
			
			String getDeleteGroupOptionTitle = this.groupList.getDeleteGroupOptionText();
			Assert.assertEquals(getDeleteGroupOptionTitle, expectedAssertionsProp.getProperty("deleteGroup.text"));

			groupList.clickOnDeleteGroupOption();

			String getDeleteTitle = this.groupList.getDeleteText();
			Assert.assertEquals(getDeleteTitle, expectedAssertionsProp.getProperty("delete.text"));

			String getCancelBtnInDeleteGroupTitle = this.groupList.getCancelBtnInDeleteGroupText();
			Assert.assertEquals(getCancelBtnInDeleteGroupTitle, expectedAssertionsProp.getProperty("cancel.text"));

			groupList.clickOnbtnDelete();
			Thread.sleep(8000);

		} catch (Exception e) {
			Assert.fail("Error occured while testing verifyDeleteGroup : " + e.getMessage());
			logger.error("Error occured while testing verifyDeleteGroup: " + e);
			e.printStackTrace();
		}
		logger.info("Ending Of Verify Delete Group Method");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
	}
}
