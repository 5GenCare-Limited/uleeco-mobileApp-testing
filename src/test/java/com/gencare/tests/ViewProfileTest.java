package com.gencare.tests;

import static org.testng.Assert.assertTrue;

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
import com.gencare.pages.ViewProfilePage;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("View Profile")
@Feature("Verify View Profile Functionality")
public class ViewProfileTest extends BaseAutomationTest {

	private ViewProfilePage viewProfilePage = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private ChangePasswordPage ChangePassword = null;

	private static final Logger logger = Logger.getLogger(ViewProfileTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO, MOBILE_DRIVER.VIEW_PROFILE_DRIVER_TEST);

		this.viewProfilePage = new ViewProfilePage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));

		logger.info("Ending of initClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verifying Landing page")
	@Description("Test Description: Verifying Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting of LandingPage");

		try {

			// assertTrue(landingPage.isLocationDontAllowButton());
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			// assertTrue(landingPage.isVideoDontAllowButton());
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
		logger.info("Ending of LandingPage");

	}

	@Test(priority = 2, description = "Verifying Signin")
	@Description("Test Description: Verifying Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Landing Page")
	public void verifyLogIn() {
		logger.info("Starting of signin");

		try {

			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("view.profile.email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("view.profile.password"));
			loginflowpage.clickOnLogInButton();

			assertTrue(ChangePassword.displayHumburgerMenu());

		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending of signin");
	}

	@Test(priority = 3, description = " Verifying HumBurgerMenu")
	@Description("Test Description:  Verifying HumBurgerMenu")
	@Severity(SeverityLevel.BLOCKER)
	@Story(" Verifying HumBurgerMenu")
	public void verifyHamburgerMenu() {
		logger.info("Starting of HumBurger Menu method");

		try {
			Thread.sleep(5000);
			viewProfilePage.clickOnHamBurgerMenu();

			String equipmentTitle = this.viewProfilePage.getEquipmentText();
			Assert.assertEquals(equipmentTitle, expectedAssertionsProp.getProperty("equipment.text"));

			String userTitle = this.viewProfilePage.getUsersAndPermissionsText();
			Assert.assertEquals(userTitle, expectedAssertionsProp.getProperty("users.and.permission.text"));

			String settingsTitle = this.viewProfilePage.getSettingsText();
			Assert.assertEquals(settingsTitle, expectedAssertionsProp.getProperty("settings.text"));

			String helpTitle = this.viewProfilePage.getHelpText();
			Assert.assertEquals(helpTitle, expectedAssertionsProp.getProperty("help.text"));

			String legalTitle = this.viewProfilePage.getLegalText();
			Assert.assertEquals(legalTitle, expectedAssertionsProp.getProperty("legal.text"));

			// String logoutTitle = this.viewProfilePage.getLogoutText();
			// Assert.assertEquals(logoutTitle,
			// expectedAssertionsProp.getProperty("logout.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing HumBurgerMenu: " + e.getMessage());
			logger.error("Error accured while testing HumBurgerMenu: " + e);
		}

		logger.info("Ending of HumBurger Menu");
	}

	@Test(priority = 4, description = "Verify Settings")
	@Description("Test Description: Verify Settings")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Settings")
	public void verifySettings() {
		logger.info("Starting Of Settings Method");

		try {
			viewProfilePage.clickOnSettings();

			String changePasswordTitle = this.viewProfilePage.getChangePasswordText();
			Assert.assertEquals(changePasswordTitle, expectedAssertionsProp.getProperty("changepassword.text"));

			String setEquipmentTitle = this.viewProfilePage.getSetupEquipmentText();
			Assert.assertEquals(setEquipmentTitle, expectedAssertionsProp.getProperty("setequipment.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing settings : " + e.getMessage());
			logger.error("Error occured while testing settings: " + e);
		}
		logger.info("Ending Of Settings Method");

	}

	@Test(priority = 5, description = "Verifying Profile")
	@Description("Test Description: Verifying Profile")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying Profile")
	public void verifyProfile() {
		logger.info("starting of Profile Method");
		try {

			viewProfilePage.clickOnProfile();
			Thread.sleep(6000);
			String getEditProfileTitle = this.viewProfilePage.getEditProfileText();
			Assert.assertEquals(getEditProfileTitle, expectedAssertionsProp.getProperty("edit.profile.text"));

			String getFirstNameTitle = this.viewProfilePage.getFirstNameText();
			Assert.assertEquals(getFirstNameTitle, expectedAssertionsProp.getProperty("first.name.text"));

			String getLastNameTitle = this.viewProfilePage.getLastNameFieldText();
			Assert.assertEquals(getLastNameTitle, expectedAssertionsProp.getProperty("last.name.text"));

			String getCountryTitle = this.viewProfilePage.getCountryText();
			Assert.assertEquals(getCountryTitle, expectedAssertionsProp.getProperty("country.text"));

			String getEmailAddressTitle = this.viewProfilePage.getEmailAddressText();
			Assert.assertEquals(getEmailAddressTitle, expectedAssertionsProp.getProperty("email.address.text"));

			viewProfilePage.verticalScrollProfile();

			String getLanguageOptionTitle = this.viewProfilePage.getLanguageOptionText();
			Assert.assertEquals(getLanguageOptionTitle, expectedAssertionsProp.getProperty("english.text"));

			String getMyAcessTextTitle = this.viewProfilePage.getMyAcessText();
			Assert.assertEquals(getMyAcessTextTitle, expectedAssertionsProp.getProperty("my.access.text"));

			String getTermsAndConditionsTitle = this.viewProfilePage.getTermsAndConditionsText();
			Assert.assertEquals(getTermsAndConditionsTitle,
					expectedAssertionsProp.getProperty("terms.&.conditions.text"));
			Thread.sleep(4000);
			String getPrivacyNoticeTitle = this.viewProfilePage.getPrivacyNoticeText();
			Assert.assertEquals(getPrivacyNoticeTitle, expectedAssertionsProp.getProperty("privacyNotice.text"));

			String getSubmitbtnTitle = this.viewProfilePage.getSubmitbtnText();
			Assert.assertEquals(getSubmitbtnTitle, expectedAssertionsProp.getProperty("submit.btn.text"));

			String getCancelTitle = this.viewProfilePage.getCancelText();
			Assert.assertEquals(getCancelTitle, expectedAssertionsProp.getProperty("cancel.text"));

			String getDeleteUserProfileTitle = this.viewProfilePage.getDeleteUserProfileText();
			Assert.assertEquals(getDeleteUserProfileTitle, expectedAssertionsProp.getProperty("delete.user.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing Profile : " + e.getMessage());
			logger.error("Error occured while testing Profile: " + e);
		}
		logger.info("Ending of Profile Method");
	}

	@Test(priority = 6, description = "Verify Edit Profile")
	@Description("Test Description:Verify Edit Profile")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Edit Profile")
	public void verifyEditProfile() {
		logger.info("Starting Of Edit Profile");

		try {
			Thread.sleep(4000);
			viewProfilePage.verticalScrollUp();
			viewProfilePage.verticalScrollUp();
			viewProfilePage.clickAndEnterFirstNameField(testDataProp.getProperty("firstname"));
			viewProfilePage.clickAndEnterLastNameField(testDataProp.getProperty("lastname"));
			viewProfilePage.clickOnCountryButton();
			viewProfilePage.clickOnIndia();
			viewProfilePage.clickOnLanguageDropdown();
			viewProfilePage.clickOnEnglish();
			Thread.sleep(4000);
			viewProfilePage.clickOnEditIcon();

			String ChangeMobileNumberTitle = this.viewProfilePage.GetChangeMobileNumberText();
			Assert.assertEquals(ChangeMobileNumberTitle,
					expectedAssertionsProp.getProperty("change.mobile.number.text"));

			assertTrue(viewProfilePage.isOldMobileNameTextDisplyed());
			String OldMobileNameTitle = this.viewProfilePage.getOldMobileNameText();
			Assert.assertEquals(OldMobileNameTitle, expectedAssertionsProp.getProperty("old.mobile.name.text"));

			String OldMobileNumberTitle = this.viewProfilePage.getOldMobileNumberText();
			Assert.assertEquals(OldMobileNumberTitle, expectedAssertionsProp.getProperty("old.mobile.number.text"));

			String NewMobileNameTitle = this.viewProfilePage.getNewMobileNameText();
			Assert.assertEquals(NewMobileNameTitle, expectedAssertionsProp.getProperty("new.mobile.name.text"));

			String NewMobileNumberTitle = this.viewProfilePage.getNewMobileNumberText();
			Assert.assertEquals(NewMobileNumberTitle, expectedAssertionsProp.getProperty("new.mobile.number.text"));

			this.verticalScroll();
			String VerificationCodeTitle = this.viewProfilePage.getVerificationCodeText();
			Assert.assertEquals(VerificationCodeTitle, expectedAssertionsProp.getProperty("verification.code.text"));

			String RequestVerificationCodeTitle = this.viewProfilePage.getRequestVerificationCodeText();
			Assert.assertEquals(RequestVerificationCodeTitle,
					expectedAssertionsProp.getProperty("request.verification.code.text"));

			String getSubmitbtnTitle = this.viewProfilePage.getSubmitbtnText();
			Assert.assertEquals(getSubmitbtnTitle, expectedAssertionsProp.getProperty("submit.btn.text"));

			String getCancelTitle = this.viewProfilePage.getCancelText();
			Assert.assertEquals(getCancelTitle, expectedAssertionsProp.getProperty("cancel.text"));
			Thread.sleep(4000);
			viewProfilePage.clickOnnewMobileNumberField(testDataProp.getProperty("mobilenum"));
			viewProfilePage.clickonRequestedVerificationcode();
			viewProfilePage.clickOnnewMobileNumberNameField(testDataProp.getProperty("mobilenumname"));
			viewProfilePage.clickonRequestedVerificationcode();
			viewProfilePage.displayOkBtn();
			viewProfilePage.displayErrIcon();
			viewProfilePage.clickOnOkButton();
			viewProfilePage.clickOnSubmitButton();
			viewProfilePage.clickOnBackBtn();
			viewProfilePage.verticalScrollProfile();
			viewProfilePage.clickOnSubmitButton();
			viewProfilePage.verticalScroll();

		} catch (Exception e) {
			Assert.fail("Error occured while testing EditProfile : " + e.getMessage());
			logger.error("Error occured while testing EditProfile: " + e);
		}
		logger.info("ending Of Edit Profile");

	}

	@Test(priority = 7, description = "Verify Delete User Profile")
	@Description("Test Description:Verify Delete User Profile")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Delete User Profile")
	public void verifyDeleteUserProfile() {
		logger.info("Starting Of Delete User Profile");

		try {
			Thread.sleep(4000);

			viewProfilePage.clickOnHamBurgerMenu();
			viewProfilePage.clickOnSettings();
			viewProfilePage.clickOnProfile();

			assertTrue(viewProfilePage.displayMudimadugulaText());

			assertTrue(viewProfilePage.displaySharathText());

			viewProfilePage.verticalScrollProfile();
			viewProfilePage.verticalScrollProfile();
			viewProfilePage.clickOnDeleteUserProfile();

		} catch (Exception e) {
			Assert.fail("Error occured while testing verifyDeleteUserProfile : " + e.getMessage());
			logger.error("Error occured while testing verifyDeleteUserProfile: " + e);
		}

		logger.info("Ending Of Delete User Profile");

	}

	@AfterClass

	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");
	}
}
