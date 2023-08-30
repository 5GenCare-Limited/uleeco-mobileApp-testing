package com.gencare.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.ChangePasswordPage;
import com.gencare.pages.AddAPhotoPage;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Gateway Dashboard Image")
@Feature("Add A Photo Functionality")
public class AddAPhotoTest extends BaseAutomationTest {

	private AddAPhotoPage gatewayImageUploading = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private ChangePasswordPage ChangePassword = null;
	private static final Logger logger = Logger.getLogger(AddAPhotoTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in ExistingUsersDashBoardTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.ADD_PHOTO_DRIVER_TEST);
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.gatewayImageUploading = new AddAPhotoPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		
		logger.info("Ending of initClass method in ExistingUsersDashBoardTest");
	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify The Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Verify Landing Page Method");

		try {

			this.landingPage.clickOnLocationWhileUsingThisAppBtnPopup();

			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			AssertJUnit.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			AssertJUnit.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			// String localWifiModeButton = this.landingPage.getLocalWifiModeButtonText();
			// Assert.assertEquals(localWifiModeButton,
			// expectedAssertionsProp.getProperty("local.wifi.mode.button.text"));

			String signUpButton = this.landingPage.getSignUpButtonText();
			AssertJUnit.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signup.button.text"));

		} catch (Exception e) {

			AssertJUnit.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Of Verify Landing Page Method");

	}

	@Test(priority = 2, description = "Verify Signin")
	@Description("Test Description: Verify Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Landing Page")
	public void verifyLogIn() {
		logger.info("Starting Of Verify Signin Method");

		try {

			Thread.sleep(6000);
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();
			ChangePassword.displayHumburgerMenu();
		} catch (Exception e) {
			AssertJUnit.fail("Error occured while testing On verifyLogIn : " + e.getMessage());
			logger.error("Error occured while testing On verifyLogIn: " + e);
		}
		logger.info("Ending Of Verify Signin Method");

	}

	@Test(priority = 3, description = "Verify Gear icon")
	@Description("Test Description: Verify Gear icon")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Gear icon")
	public void verifyGearIcon() {
		logger.info("Starting Of Verify Gear Icon Method");

		try {
		
			gatewayImageUploading.clickOnGearIconBtn();

			String getAddAPhotoTitle = this.gatewayImageUploading.getAddAPhotoText();
			AssertJUnit.assertEquals(getAddAPhotoTitle, expectedAssertionsProp.getProperty("addAPhoto.text"));

		} catch (Exception e) {
			AssertJUnit.fail("Error occured while testing On GearIcon : " + e.getMessage());
			logger.error("Error occured while testing On GearIcon: " + e);
		}
		logger.info("Ending Of Verify Gear Icon Method");
	}

	@Test(priority = 4, description = "Verify Add A Photo")
	@Description("Test Description: Verify Add A Photo")
	@Severity(SeverityLevel.BLOCKER)
	public void verifyAddaPhoto() {
		logger.info("Starting Of Verify Add A Photo Method");

		try {

			gatewayImageUploading.clickOnAddAPhotoButton();

			String ChoosePhotoFromLibraryTitle = this.gatewayImageUploading.getChoosePhotoFromLibrary();
			AssertJUnit.assertEquals(ChoosePhotoFromLibraryTitle,
					expectedAssertionsProp.getProperty("choosePhotofrmLbry.text"));

			gatewayImageUploading.clickAnduploadAFilefromChoosePhotoFromLibrary();
			Thread.sleep(4000);

		} catch (Exception e) {
			AssertJUnit.fail("Error occured while testing On Add a Photo : " + e.getMessage());
			logger.error("Error occured while testing On Add a Photo: " + e);
		}
		logger.info("Ending Of Verify Add A Photo Method");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {		
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
		
	}
}