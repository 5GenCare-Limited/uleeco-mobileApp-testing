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
import com.gencare.pages.SignInPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Password")
@Feature("Change Password Functionality")

public class ChangePasswordTest extends BaseAutomationTest {
	private ChangePasswordPage ChangePassword = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private static final Logger logger = Logger.getLogger(ChangePasswordTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LandingPage");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.CHANGE_PASSWORD_DRIVER_TEST);
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));

		logger.info("Ending of initClass method in LandingPage");

	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting Of Landing Page Method");

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

			Assert.fail("Error accured while testing landing page Screen: " + e.getMessage());
			logger.error("Error accured while testing landing page Screen: " + e);
		}
		logger.info("Ending Of Landing Page Method");

	}

	@Test(priority = 2, description = "Verify Signin")
	@Description("Test Description: Verify Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Landing Page")
	public void verifyLogIn() {
		logger.info("Starting Of Signin Method");

		try {
			
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("view.profile.email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("view.profile.password"));
			loginflowpage.clickOnLogInButton();
			Thread.sleep(5000);
			ChangePassword.displayHumburgerMenu();
			ChangePassword.clickOnHamburgerMenu();
			
		} catch (Exception e) {
			Assert.fail("Error accured while testing Signin Screen: " + e.getMessage());
			logger.error("Error accured while testing Signin Screen: " + e);
		}
		logger.info("Ending Of Signin Method");

	}

	@Test(priority = 3, description = "Verify Global Functions")
	@Description("Test Description:Verify Global Functions")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Global Functions")
	public void verifyGlobalFunctions() {
		logger.info("Starting Of Verify Global Functions Method");

		try {
			String equipmentTitle = this.ChangePassword.getEquipmentText();
			Assert.assertEquals(equipmentTitle, expectedAssertionsProp.getProperty("equipment.text"));

			String userAndPermissionTitle = this.ChangePassword.getUsersAndPermissionsText();
			Assert.assertEquals(userAndPermissionTitle,
					expectedAssertionsProp.getProperty("users.and.permission.text"));

			String settingsTitle = this.ChangePassword.getSettingsText();
			Assert.assertEquals(settingsTitle, expectedAssertionsProp.getProperty("settings.text"));

			String helpTitle = this.ChangePassword.getHelpText();
			Assert.assertEquals(helpTitle, expectedAssertionsProp.getProperty("help.text"));

			String legalTitle = this.ChangePassword.getLegalText();
			Assert.assertEquals(legalTitle, expectedAssertionsProp.getProperty("legal.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing All Global Functions: " + e.getMessage());
			logger.error("Error accured while testing All Global Functions: " + e);
		}
		logger.info("Ending  Of Verify Global Functions Method");

	}

	@Test(priority = 4, description = "Verify Settings")
	@Description("Test Description: Verify Settings")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Settings")

	public void verifySettings() {
		logger.info("Starting Of Verify Settings Method");

		try {
			ChangePassword.clickOnSettings();

			String profileTitle = this.ChangePassword.getProfileText();
			Assert.assertEquals(profileTitle, expectedAssertionsProp.getProperty("profile.text"));

			String changePasswordTitle = this.ChangePassword.getChangePasswordText();
			Assert.assertEquals(changePasswordTitle, expectedAssertionsProp.getProperty("changepassword.text"));

			String setupEquipmentTitle = this.ChangePassword.getSetupEquipmentText();
			Assert.assertEquals(setupEquipmentTitle, expectedAssertionsProp.getProperty("setequipment.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing settings: " + e.getMessage());
			logger.error("Error accured while testing settings: " + e);
		}
		logger.info("Ending Of Verify Settings Method");
	}

	@Test(priority = 5, description = "Verify Change Password Page")
	@Description("Test Description:Verify Change Password Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Change Password Page")
	public void verifyChangePasswordPage() {
		logger.info("Starting Of Verify Change Password Page Method");

		try {
			ChangePassword.clickOnChangePassword();

			Thread.sleep(6000);

			String changePswdTitle = this.ChangePassword.getChangePasswordText();
			Assert.assertEquals(changePswdTitle, expectedAssertionsProp.getProperty("changepassword.text"));

			String oldPswdTitle = this.ChangePassword.getOldPswdText();
			Assert.assertEquals(oldPswdTitle, expectedAssertionsProp.getProperty("old.password.text"));

			String newPswdTitle = this.ChangePassword.getNewPswdText();
			Assert.assertEquals(newPswdTitle, expectedAssertionsProp.getProperty("new.password.text"));

			String confirmPswdTitle = this.ChangePassword.getConfirmPswdText();
			Assert.assertEquals(confirmPswdTitle, expectedAssertionsProp.getProperty("confirm.password.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing change password: " + e.getMessage());
			logger.error("Error accured while testing change password: " + e);
		}
		logger.info("Ending Of Verify Change Password Page Method");
	}

	@Test(priority = 6, description = "Verify Change Password equired  Fields")
	@Description("Test Description: Verify Change Password Required Fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Change Password Required Fields")
	public void verifyChangePasswordRequiredFields() {
		logger.info("Starting Of Verify Change Password Required Fields Method");

		try {
			ChangePassword.clickAllPasswordFields();

			String thisFieldRequiredTitle = this.ChangePassword.getOldPswdErrorMsgText();
			Assert.assertEquals(thisFieldRequiredTitle,
					expectedAssertionsProp.getProperty("this.fld.rqrd.new.pswd.frgtpswd.text"));
			
			
			//steps missed
//			String getNewPswdMustBeAtLeastEightCharactersTitle = this.ChangePassword
//					.getNewPswdMustBeAtLeastEightCharactersText();
//			Assert.assertEquals(getNewPswdMustBeAtLeastEightCharactersTitle,
//					expectedAssertionsProp.getProperty("this.fld.rqrd.new.pswd.frgtpswd.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing verify Change Password Required Fields: " + e.getMessage());
			logger.error("Error accured while testing verify Change Password Required Fields: " + e);
		}
		logger.info("Ending Of Verify Change Password Required Fields Method");
	}

	@Test(priority = 7, description = "Verify New Password required fields")
	@Description("Test Description: Verify New Password required fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify New Password required fields")
	public void verifyRequiredNewPasswordFields() {
		logger.info("Starting Of Verify Required New Password Fields Method");

		try {
			Thread.sleep(4000);
			ChangePassword.clickClearNEnterInvalidNewPswd(testDataProp.getProperty("invalidnewpswd"));
			ChangePassword.clickClearNEnterInvalidconfirmPswd(testDataProp.getProperty("invalidcfrmpswd"));

			String getPswdDoNtMatchTitle = this.ChangePassword.getPswdDoNtMatchText();
			Assert.assertEquals(getPswdDoNtMatchTitle,
					expectedAssertionsProp.getProperty("pswd.dnt.mtch.frgtpswd.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing RequiredNewPasswordFields: " + e.getMessage());
			logger.error("Error accured while testing RequiredNewPasswordFields: " + e);
		}
		logger.info("Ending Of Verify Required New Password Fields Method");

	}

	@Test(priority = 8, description = "Verify Change Password")
	@Description("Test Description: Verify Change Password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Change Password")
	public void verifyChangePassword() {
		logger.info("Starting Of Verify Change Password Method");

		try {
			Thread.sleep(8000);
			ChangePassword.clickOnBackBtn();
			ChangePassword.clickMenuToChangePswd();
			Thread.sleep(3000);
			ChangePassword.clickAndEnterInValidOldPswd(testDataProp.getProperty("invalidoldpswd"));
			ChangePassword.enterValidNewPswd(testDataProp.getProperty("newpswd"));
			ChangePassword.clickClearNEnterconfirmPswd(testDataProp.getProperty("cfrmpswd"));
			ChangePassword.clickOnSubmitButton();
			Thread.sleep(3000);
			ChangePassword.getErrorIconText();

			String getOkBtnTitle = this.ChangePassword.getOkBtnText();
			Assert.assertEquals(getOkBtnTitle, expectedAssertionsProp.getProperty("ok.text"));

			String getPopUpCancelBtnTitle = this.ChangePassword.getPopCancelBtnText();
			Assert.assertEquals(getPopUpCancelBtnTitle, expectedAssertionsProp.getProperty("cancel.text"));
			Thread.sleep(3000);
			ChangePassword.clickOnOkBtn();

		} catch (Exception e) {
			Assert.fail("Error accured while testing change password: " + e.getMessage());
			logger.error("Error accured while testing change password: " + e);
		}
		logger.info("Ending Of Verify Change Password Method");

	}

	@Test(priority = 9, description = "Verify Old Password")
	@Description("Test Description: Verify Old Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Old Password")
	public void verifyOldPassword() {
		logger.info("Starting Of Verify Old Password Method");

		try {
			Thread.sleep(10000);
			ChangePassword.clickAndEnterValidOldPswd(testDataProp.getProperty("validoldpswd"));
			ChangePassword.clickOnSubmitBtnWithValidFields();
			Thread.sleep(3000);

		} catch (Exception e) {
		}
		logger.info("Ending Of Verify Old Password Method");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
		
	}
}