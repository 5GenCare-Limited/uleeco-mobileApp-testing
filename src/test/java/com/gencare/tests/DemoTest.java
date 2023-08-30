package com.gencare.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.CategoriesListPage;
import com.gencare.pages.DemoPage;
import com.gencare.pages.GroupListPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignoutPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Demo")
@Feature("Demo Functionality")
public class DemoTest extends BaseAutomationTest {
	private DemoPage demo = null;
	private LandingPage landingpage = null;
	private SignoutPage loginPage = null;
	private CategoriesListPage categoriesListpage = null;
	private GroupListPage groupList = null;
	private static final Logger logger = Logger.getLogger(DemoTest.class.getName());

	@BeforeClass
	@Parameters({ "clientApiKey", "platform","deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform,String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in DemoTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.DEMO_DRIVER_TEST);
		this.landingpage = new LandingPage(this.getMobileDriver(udid));
		this.demo = new DemoPage(this.getMobileDriver(udid));
		this.loginPage = new SignoutPage(this.getMobileDriver(udid));
		this.groupList = new GroupListPage(this.getMobileDriver(udid));
		this.categoriesListpage = new CategoriesListPage(this.getMobileDriver(udid));

		logger.info("Ending of initClass method in DemoTest");
	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Landing Page Method");

		try {
			
			landingpage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingpage.clickOnVideoWhileUsingThisAppBtnPopup();

			String getWelcomeToSalusTitle = this.demo.getWelcomeToSalusText();
			Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

			String signInButtonTitle = this.landingpage.getSignInButtonText();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingpage.getDemoButtonText();
			Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			String signUpButtonTitle = this.landingpage.getSignUpButtonText();
			Assert.assertEquals(signUpButtonTitle, expectedAssertionsProp.getProperty("signup.button.text"));

		} catch (Exception e) {

			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}

		logger.info("Ending Of Landing Page Method");
	}

	@Test(priority = 2, description = "Verify Demo Functionality")
	@Description("Test Description: Verify Demo Functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Demo Functionality")
	public void verifyDemo() {
		logger.info("Starting Of Demo Functionality Method");

		try {
			
			demo.clickOnDemoBtn();
			Thread.sleep(20000);
			demo.clickOnGearIconBtn();
		
		} catch (Exception e) {
			Assert.fail("Error occured while testing On GearIcon : " + e.getMessage());
			logger.error("Error occured while testing On GearIcon: " + e);
		}
		logger.info("Ending Of Demo Functionality Method");
	}

	/*
	 * @Test(priority = 21, description = "Verifying veriFyChangeDeviceSettings2")
	 * 
	 * @Description("Test Description: Verify veriFyChangeDeviceSettings2")
	 * 
	 * @Severity(SeverityLevel.BLOCKER)
	 * 
	 * @Story("Verify The ChangeDeviceSettings2") public void
	 * testChangeDeviceSettings2() {
	 * 
	 * logger.info("Starting of ChangeDeviceSettings2");
	 * 
	 * try {
	 * 
	 * this.verticalScroll(); Thread.sleep(3000);
	 * demo.clickOnRemoteTemperatureButton(); demo.clickOnTemperatureButton();
	 * 
	 * String getInformation1Tittle = this.demo.getInformation1Text();
	 * Assert.assertEquals(getInformation1Tittle,
	 * expectedAssertionsProp.getProperty("Information1.text"));
	 * 
	 * demo.clickOnSettings2Button();
	 * 
	 * String getSettingsTittle = this.demo.getSettingsText();
	 * Assert.assertEquals(getSettingsTittle,
	 * expectedAssertionsProp.getProperty("settings.text"));
	 * 
	 * this.verticalScroll(); demo.clickOnSendEmailCheckBox();
	 * demo.clickOnSaveButton(); demo.clickOnBackButton();
	 * 
	 * demo.clickOnSettings2Button(); demo.isSelecedSendEmailCheckBox();
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } logger.info("Ending of ChangeDeviceSettings2");
	 * 
	 * }
	 * 
	 * @Test(priority = 22, description = "Verifying veriFyChangeDeviceSettings3")
	 * 
	 * @Description("Test Description: Verify veriFyChangeDeviceSettings3")
	 * 
	 * @Severity(SeverityLevel.BLOCKER)
	 * 
	 * @Story("Verify The ChangeDeviceSettings3") public void
	 * testChangeDeviceSettings3() {
	 * 
	 * logger.info("Starting of ChangeDeviceSettings3");
	 * 
	 * try {
	 * 
	 * this.verticalScroll();
	 * 
	 * demo.clickOnHotWaterButton(); demo.clickOnWateTimerButton();
	 * 
	 * String getInformation1Tittle = this.demo.getInformation1Text();
	 * Assert.assertEquals(getInformation1Tittle,
	 * expectedAssertionsProp.getProperty("Information1.text"));
	 * demo.clickOnSettings3Button();
	 * 
	 * String getSettingsTittle = this.demo.getSettingsText();
	 * Assert.assertEquals(getSettingsTittle,
	 * expectedAssertionsProp.getProperty("settings.text"));
	 * 
	 * this.verticalScroll(); demo.clickOnTimeButton1(); this.verticalScroll();
	 * demo.clickOnSaveButton(); demo.clickOnBackButton();
	 * demo.clickOnSettings3Button(); this.verticalScroll();
	 * demo.isSelecedTimeButton1();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * logger.info("Ending of ChangeDeviceSettings3");
	 * 
	 * }
	 * 
	 * @Test(priority = 23, description = "Verifying veriFyChangeDeviceSettings4")
	 * 
	 * @Description("Test Description: Verify veriFyChangeDeviceSettings4")
	 * 
	 * @Severity(SeverityLevel.BLOCKER)
	 * 
	 * @Story("Verify The ChangeDeviceSettings4") public void
	 * testChangeDeviceSettings4() throws Exception {
	 * 
	 * logger.info("Starting of ChangeDeviceSettings4");
	 * 
	 * try { this.verticalScroll();
	 * 
	 * demo.clickOnThermostatButton(); demo.clickOnBatteryQuantumButton();
	 * demo.clickOnSettings4Button();
	 * 
	 * String getSettingsTittle = this.demo.getSettingsText();
	 * Assert.assertEquals(getSettingsTittle,
	 * expectedAssertionsProp.getProperty("settings.text")); Thread.sleep(5000);
	 * this.verticalScroll(); demo.clickOnHideRadioButton(); this.verticalScroll();
	 * demo.clickOnSaveButton(); demo.clickOnChangejustthisoneButton();
	 * demo.clickOnBackButton(); demo.clickOnSettings4Button();
	 * this.verticalScroll(); demo.isSelecedHideRadioButton();
	 * 
	 * } catch (InterruptedException e) { e.printStackTrace(); }
	 * 
	 * logger.info("Ending of ChangeDeviceSettings4");
	 * 
	 * }
	 */

	@Test(priority = 3, description = "Verify Add A Photo")
	@Description("Test Description: Verify Add A Photo")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add A Photo")
	public void verifyAddaPhoto() {
		logger.info("Starting Of Verify Add A Photo Method");

		try {

			String getAddAPhotoTitle = this.demo.getAddAPhotoText();
			Assert.assertEquals(getAddAPhotoTitle, expectedAssertionsProp.getProperty("addAPhoto.text"));

			demo.clickOnAddAPhotoButton();

			String ChoosePhotoFromLibraryTitle = this.demo.getChoosePhotoFromLibrary();
			Assert.assertEquals(ChoosePhotoFromLibraryTitle,
					expectedAssertionsProp.getProperty("choosePhotofrmLbry.text"));

			demo.clickAnduploadAFilefromChoosePhotoFromLibrary();

			Thread.sleep(8000);
			demo.refreshPage();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On Add a Photo : " + e.getMessage());
			logger.error("Error occured while testing On Add a Photo: " + e);
		}
		logger.info("Ending Of Verify Add A Photo Method");

	}

	@Test(priority = 4, description = "Verify Hamburger Menu")
	@Description("Test Description: Verify Hamburger Menu")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Hamburger Menu")
	public void verifyHamburgerMenu() {
		logger.info("starting Of Verify Hamburger Menu Method");

		try {
			Thread.sleep(8000);
			demo.clickOnHamburgerMenuButton();

			String equipmentTitle = this.loginPage.getEquipmentText();
			Assert.assertEquals(equipmentTitle, expectedAssertionsProp.getProperty("equipment.text"));

			String userTitle = this.loginPage.getUsersAndPermissionsText();
			Assert.assertEquals(userTitle, expectedAssertionsProp.getProperty("users.and.permission.text"));

			String settingsTitle = this.loginPage.getSettingsText();
			Assert.assertEquals(settingsTitle, expectedAssertionsProp.getProperty("settings.text"));

			String helpTitle = this.loginPage.getHelpText();
			Assert.assertEquals(helpTitle, expectedAssertionsProp.getProperty("help.text"));

			String legalTitle = this.loginPage.getLegalText();
			Assert.assertEquals(legalTitle, expectedAssertionsProp.getProperty("legal.text"));

			String logoutTitle = this.loginPage.getLogoutText();

		} catch (Exception e) {
		}
		logger.info("Ending Of Verify Hamburger Menu Method");

	}

	@Test(priority = 5, description = "Verify Equipment")
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

	@Test(priority = 6, description = "Verify All Equipment")
	@Description("Test Description: Verify All Equipment")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify All Equipment")
	public void verifyAllEquipment() {
		logger.info("starting Of Verify All Equipment Method");

		try {
			categoriesListpage.clickOnAllEquipment();

			String getMyEquipmentTitle = this.demo.getMyEquipmentText();
			Assert.assertEquals(getMyEquipmentTitle, expectedAssertionsProp.getProperty("myEquiment.text"));

			String getGroupTitle = this.demo.getGroupText();
			Assert.assertEquals(getGroupTitle, expectedAssertionsProp.getProperty("groups.text"));

			String getCategoriesTitle = this.demo.getCategoriesText();
			Assert.assertEquals(getCategoriesTitle, expectedAssertionsProp.getProperty("categories.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing AllEquipment : " + e.getMessage());
			logger.error("Error occured while testing AllEquipment: " + e);
		}
		logger.info("Ending Of Verify All Equipment Method");

	}

	@Test(priority = 7, description = "Verify Add New Group")
	@Description("Test Description: Verify Add New Group")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Add New Group")
	public void verifyAddNewGroup() {
		logger.info("Starting Of Verify Add New Group Method");

		try {
			
			String getAddNewGroupTitle = this.demo.getAddNewGroupText();
			Assert.assertEquals(getAddNewGroupTitle, expectedAssertionsProp.getProperty("add.new.group.text"));

			groupList.clickOnbtnAddNewGroup();

			Thread.sleep(4000);
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
			groupList.displayPinIcon();
			
			String getFinishTitle = this.groupList.getFinishText();
			Assert.assertEquals(getFinishTitle, expectedAssertionsProp.getProperty("finish.text"));

			groupList.clickOnPinIcon();
			groupList.clickOnbtnFinish();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On Add New Group : " + e.getMessage());
			logger.error("Error occured while testing On Add New Group: " + e);
		}
		logger.info("Ending Of Verify Add New Group Method");
	}

	@Test(priority = 9, description = "Verify Edit Name")
	@Description("Test Description:  Verify Edit Name")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Edit Name")
	public void VerifyEditName() throws Exception {
		logger.info("Starting Of Verify Edit Name Method");
		
		try {
		this.demo.clickOnBackButton();
		this.demo.clickOnBackButton();
		this.verticalScroll();
		this.demo.clickOnDevice();
		this.demo.clickOnDeviceName();
		this.demo.setDeviceName(testDataProp.getProperty("Name"));
		this.demo.clickOnSaveButton();
		
		} catch (Exception e) {
			Assert.fail("Error occured while testing On Edit Name : " + e.getMessage());
			logger.error("Error occured while testing On Edit Name: " + e);
		}
		logger.info("Ending Of Verify Edit Name Method");
	}

	@Test(priority = 10, description = "Verify Remove Device")
	@Description("Test Description: Verify Remove Device")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Remove Device")
	public void verifyRemoveDevice() throws Exception {
		logger.info("Starting Of Verify Remove Device Method");

		try {

			this.demo.clickOnBackButton();
			this.demo.clickOnDevice();
			this.demo.clickOnDeviceName();
			this.verticalScroll();

			this.demo.clickOnRemoveButton();

			String deleteText = this.demo.getDeleteText();
			Assert.assertEquals(deleteText, expectedAssertionsProp.getProperty("delete.text"));

			this.demo.clickOnDeleteButton();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On Edit Name : " + e.getMessage());
			logger.error("Error occured while testing On Edit Name: " + e);
		}

		logger.info("Ending Of Verify Remove Device Method");
	}

	/*
	 * @Test(priority = 11, description = "Verify Change Device Settings")
	 * 
	 * @Description("Test Description: Verify Change Device Settings")
	 * 
	 * @Severity(SeverityLevel.BLOCKER)
	 * 
	 * @Story("Verify Change Device Settings") public void
	 * veriFyChangeDeviceSettings() throws Exception {
	 * logger.info("Starting Of Verify Change Device Settings Method"); try {
	 * 
	 * Thread.sleep(5000); this.demo.clickOnBackButton(); this.verticalScroll();
	 * this.demo.clickOnDevice(); this.demo.clickOnDeviceName();
	 * this.demo.clickOnSettingsButton();
	 * 
	 * String ConnectedText = this.demo.getSettingsTxt();
	 * Assert.assertEquals(ConnectedText,
	 * expectedAssertionsProp.getProperty("settings.text"));
	 * 
	 * this.demo.changeSettings();
	 * 
	 * this.demo.CheckSettingChanges();
	 * 
	 * this.demo.iSselectedSetting();
	 * 
	 * this.verticalScroll(); } catch (InterruptedException e) {
	 * 
	 * }
	 * 
	 * logger.info("Ending Of Verify Change Device Settings Method"); }
	 */
	@Test(priority = 12, description = "Verify The schedule function")
	@Description("Test Description:Verify The schedule function")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The schedule function")
	public void testScheduleFunction() throws Exception {
		logger.info("Starting Of testScheduleFunction Method");

		try {
			
		this.demo.clickOnBackButton();
		demo.clickOnHTRPDevice();
		Thread.sleep(2000);
		demo.verticalScroll();
		demo.clickOnScheduleIcon();

		String createYourOwnScheduleTitle = this.demo.getCreateYourOwnScheduleText();
		Assert.assertEquals(createYourOwnScheduleTitle,
				expectedAssertionsProp.getProperty("create.your.own.schedule.text"));

		String duplicateScheduleTitle = this.demo.getDuplicateScheduleText();
		Assert.assertEquals(duplicateScheduleTitle, expectedAssertionsProp.getProperty("duplicate.schedule.text"));

		String workingWeekTitle = this.demo.getWorkingWeekText();
		Assert.assertEquals(workingWeekTitle, expectedAssertionsProp.getProperty("working.week.text"));

		demo.clickOndrpDwnWrkngWeek();

		String homeMustOfTheTitle = this.demo.getHomeMustOfTheTime();
		Assert.assertEquals(homeMustOfTheTitle, expectedAssertionsProp.getProperty("home.most.of.the.time.text"));

		String dailyTitle = this.demo.getDailyText();
		Assert.assertEquals(dailyTitle, expectedAssertionsProp.getProperty("daily.text"));
		
		demo.clickOndrpDwnWrkngWeek();
		demo.verticalScroll();
		
		String defaultScheduleTitle = this.demo.getDefaultScheduleText();
		Assert.assertEquals(defaultScheduleTitle, expectedAssertionsProp.getProperty("default.schedule.text"));
		
		demo.clickOnAddIntervalIcon();
		demo.clickOnTimeButton();
		demo.clickOnOkButton();
		demo.clickOnHeatingText(testDataProp.getProperty("Number"));
		//demo.clickOnCoolingText(testDataProp.getProperty("Number1"));

		demo.clickOnAddButton();
		demo.clickOnSaveButton();
		demo.clickonBackBtn();
		
		}catch (Exception e) {
			Assert.fail("Error occured while testing schedule function : " + e.getMessage());
			logger.error("Error occured while testingschedule function : " + e);
		}
		logger.info("Ending Of testScheduleFunction Method");

	}

	@Test(priority = 13, description = "Verify The OneTouch Functionality")
	@Description("Test Description: Verify The OneTouch Functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The OneTouch Functionality")
	public void testOneTouchFunction() throws Exception {

		logger.info("Starting Of Verify The OneTouch Functionality Method");

		Thread.sleep(5000);
		demo.clickOnHamburgerMenuButton();
		demo.clickOnEquipmentButton();
		demo.clickOnOneTouchButton();

		String getOneTouchTitle = this.demo.getOneTouchText();
		Assert.assertEquals(getOneTouchTitle, expectedAssertionsProp.getProperty("OneTouch.text"));

		demo.clickOnAddaANDButton();
		demo.clickOnNameThisOneTouchButton(testDataProp.getProperty("OneTouch"));

		String getCreateaANDOneTouchTitle = this.demo.getCreateaANDOneTouchText();
		Assert.assertEquals(getCreateaANDOneTouchTitle, expectedAssertionsProp.getProperty("CreateaANDOneTouch.text"));
		Thread.sleep(5000);

		demo.clickOnWhenButton();
		demo.clickOnTimeofDayButton();
		demo.clickOnSunriseButton();
		demo.clickOnDOTHISButton();
		this.verticalScroll();
		demo.clickOnSendmeanotificationButton();
		demo.clickOnCheckBox();
		this.verticalScroll();
		demo.clickOnSave1Button();
		demo.clickOnBackButton();

		// boolean displayAutomationRule =this.demo.displayAutomationRule();
		//assertTrue(demo.displayAutomationRule());

		logger.info("Ending Of Verify The OneTouch Functionality Method");
	}

	@Test(priority = 14, description = "Verify The DataCollection Collection")
	@Description("Test Description: Verify The DataCollection Collection")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The DataCollection Collection")
	public void testDataCollectionFunction() {
		logger.info("Starting Of Verify The DataCollection Collection Method");

		try {
			
			demo.clickOnHamburgerMenuButton();
			demo.clickOnSettingButton();			
			demo.clickOnDataCollectionButton();

			String getDataCollectionText = this.demo.getDataCollectionText();
			Assert.assertEquals(getDataCollectionText, expectedAssertionsProp.getProperty("data.collection"));
			
			demo.clickOnDataCollectionisOFFButton();
			this.verticalScroll();
			demo.clickOnSaveButton();
			assertFalse(demo.isSelecedtDataCollectionButton());
			demo.clickOnBackButton();

		} catch (Exception e) {
			
			Assert.fail("Error occured while testing DataCollection : " + e.getMessage());
			logger.error("Error occured while testing DataCollection: " + e);
			
			logger.info("Ending Of Verify The DataCollection Collection Method");
		}
	}

	/*
	 * @Test(priority = 15, description = "Verify Created Group List")
	 * 
	 * @Description("Test Description: Verify Created Group List")
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Verify Created Group List") public void testCreatedGroupList() throws
	 * Exception { logger.info("Starting Of Verify Created Group List Method");
	 * 
	 * try { demo.clickOnHamburgerMenuButton();
	 * categoriesListpage.clickOnEquipment();
	 * categoriesListpage.clickOnAllEquipment(); groupList.verticalScroll();
	 * groupList.clickOnbtnAddNewGroup(); groupList.clickOnAVA10M30RFcheckBox();
	 * groupList.clickOnAWRT10RFcheckBox(); groupList.clickOnbtnFinish();
	 * 
	 * String getErrorMessageTitle = this.groupList.getErrorMessageText();
	 * Assert.assertEquals(getErrorMessageTitle,
	 * expectedAssertionsProp.getProperty("pleaseEnterValidGroupName.text"));
	 * 
	 * groupList.clickOnEnterNameOfEquipmentGroup(testDataProp.getProperty(
	 * "b2btesters")); assertTrue(groupList.displayPinIcon());
	 * groupList.clickOnbtnFinish();
	 * 
	 * } catch (Exception e) {
	 * Assert.fail("Error occured while testing testCreatedGroupList : " +
	 * e.getMessage());
	 * logger.error("Error occured while testing testCreatedGroupList: " + e);
	 * 
	 * } logger.info("Ending Of Verify Created Group List Method");
	 * 
	 * }
	 * 
	 * @Test(priority = 16, description = "Verify Edit Group Functionality")
	 * 
	 * @Description("Test Description: Verify Edit Group Functionality")
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Verify Edit Group Functionality") public void testEditGroupName()
	 * throws Exception {
	 * logger.info("Starting Of Verify Edit Group Functionalityt Method");
	 * 
	 * try { groupList.clickOnCreatedGroup(); demo.clickonGroupEditBtn();
	 * demo.changeGroupName(testDataProp.getProperty("abcd"));
	 * demo.clickOnPinIcon(); demo.clickOnbtnFinish(); this.demo.verticalScrollUp();
	 * this.demo.verticalScrollUp(); demo.clickonBackBtn();
	 * 
	 * } catch (Exception e) {
	 * Assert.fail("Error occured while testing testEditGroupName : " +
	 * e.getMessage());
	 * logger.error("Error occured while testing testEditGroupName: " + e); }
	 * 
	 * logger.info("Ending Of Verify Edit Group Functionality Method");
	 * 
	 * }
	 * 
	 * @Test(priority = 17, description = "Verify Delete Group Text")
	 * 
	 * @Description("Test Description: Verify Delete Group Text")
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Verify Delete Group Text") public void testDeleteGroupFunctionality()
	 * throws Exception {
	 * logger.info("Starting Of Verify Delete Group Functionality Method");
	 * 
	 * try {
	 * 
	 * String getDeleteGroupOptionTitle = this.demo.getDeleteGroupOptionText();
	 * Assert.assertEquals(getDeleteGroupOptionTitle,
	 * expectedAssertionsProp.getProperty("delete.group.text"));
	 * 
	 * } catch (Exception e) {
	 * Assert.fail("Error occured while testing testDeleteGroupFunctionality : " +
	 * e.getMessage());
	 * logger.error("Error occured while testing testDeleteGroupFunctionality: " +
	 * e); }
	 * 
	 * logger.info("Ending Of Verify Delete Group Functionality Method");
	 * 
	 * }
	 * 
	 * @Test(priority = 18, description = "Verify Delete Group Option")
	 * 
	 * @Description("Test Description: Verify The Delete Group Option")
	 * 
	 * @Severity(SeverityLevel.BLOCKER)
	 * 
	 * @Story("Verify The Delete Group Option") public void testDeleteGroupOption()
	 * { logger.info("Starting Of Verify The Delete Group Option Method");
	 * 
	 * try { Thread.sleep(5000); demo.clickOnDeleteGroupOption(); } catch (Exception
	 * e) { Assert.fail("Error occured while testing testDeleteGroupOption : " +
	 * e.getMessage());
	 * logger.error("Error occured while testing testDeleteGroupOption: " + e); }
	 * 
	 * logger.info("Ending Of Verify The Delete Group Option Method");
	 * 
	 * }
	 * 
	 * @Test(priority = 19, description = "Verify Delete Group Popup")
	 * 
	 * @Description("Test Description: Verify Delete Group Popup")
	 * 
	 * @Severity(SeverityLevel.NORMAL)
	 * 
	 * @Story("Verify Delete Group Popup") public void testDeleteGroupPopUp() throws
	 * Exception { logger.info("Starting Of Verify Delete Group Popup Method");
	 * 
	 * try { Thread.sleep(8000); String getDeleteTitle =
	 * this.groupList.getDeleteText(); Assert.assertEquals(getDeleteTitle,
	 * expectedAssertionsProp.getProperty("delete.text"));
	 * 
	 * String getCancelBtnInDeleteGroupTitle =
	 * this.groupList.getCancelBtnInDeleteGroupText();
	 * Assert.assertEquals(getCancelBtnInDeleteGroupTitle,
	 * expectedAssertionsProp.getProperty("cancel.text"));
	 * 
	 * } catch (Exception e) {
	 * Assert.fail("Error occured while testing On testDeleteGroupPopUp : " +
	 * e.getMessage());
	 * logger.error("Error occured while testing On testDeleteGroupPopUp: " + e); }
	 * logger.info("Ending Of Verify Delete Group Popup Method");
	 * 
	 * }
	 * 
	 * @Test(priority = 20, description = "Verify The Delete Group")
	 * 
	 * @Description("Test Description: Verify The Delete Group")
	 * 
	 * @Severity(SeverityLevel.BLOCKER)
	 * 
	 * @Story("Verify The Delete Group") public void testDeleteBtn() {
	 * logger.info("Starting Of Verify The Delete Group Method"); try {
	 * Thread.sleep(5000); groupList.clickOnbtnDelete(); } catch (Exception e) {
	 * Assert.fail("Error occured while testing testDeleteBtn : " + e.getMessage());
	 * logger.error("Error occured while testing testDeleteBtn: " + e);
	 * 
	 * } logger.info("Ending Of Verify The Delete Group Method"); }
	 */

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		this.quitMobileDriver(udid);
	}

}