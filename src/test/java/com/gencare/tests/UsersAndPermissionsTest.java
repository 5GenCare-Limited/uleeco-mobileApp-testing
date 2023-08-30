package com.gencare.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.LandingPage;
import com.gencare.pages.MyStatusPage;
import com.gencare.pages.SignInPage;
import com.gencare.pages.UsersAndPermissionsPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(" UsersAndPermissions functionality")
@Feature(" UsersAndPermissions functionality")
public class UsersAndPermissionsTest extends BaseAutomationTest {
	private UsersAndPermissionsPage usersAndPermissionspage = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private MyStatusPage myStatusPage = null;
	private static final Logger logger = Logger.getLogger(CategoriesListTest.class.getName());

	@BeforeClass
	@Parameters({ "clientApiKey","platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.USERS_AND_PERMISSIONS_DRIVER_TEST);
		this.usersAndPermissionspage = new UsersAndPermissionsPage(this.getMobileDriver(udid));
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
			myStatusPage.implicitWait();
			myStatusPage.clickOnHamburgerMenuBtn();
		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Verify The Signin Method");
	}

	@Test(priority = 3, description = "Verify Add Owner Permission")
	@Description("Test Description:Verify Add Owner Permission")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Add Owner Permission")
	public void verifyAddOwnerPermission() throws Exception {
		logger.info("Starting Of Verify Add Owner Permission");
		
		
		Thread.sleep(4000);
		usersAndPermissionspage.clickOnBtnusersAndPermissions();
		Thread.sleep(4000);

		usersAndPermissionspage.clickAddPermissionPlusBtn();

		String addUserTitle = this.usersAndPermissionspage.getAddUserText();
		Assert.assertEquals(addUserTitle, expectedAssertionsProp.getProperty("add.user"));

		String inviteNewUserViaEmail = this.usersAndPermissionspage.getInviteNewUserViaEmailText();
		Assert.assertEquals(inviteNewUserViaEmail, expectedAssertionsProp.getProperty("invite.newuser.viaemail"));

		String sendInvitation = this.usersAndPermissionspage.getSendInvitationText();
		Assert.assertEquals(sendInvitation, expectedAssertionsProp.getProperty("send.invitation"));

		String ownerAccess = this.usersAndPermissionspage.getOwnerAccessText();
		Assert.assertEquals(ownerAccess, expectedAssertionsProp.getProperty("owner.access.text"));

		String getOwnerTextTitle = this.usersAndPermissionspage.getOwnerText();
		Assert.assertEquals(getOwnerTextTitle, expectedAssertionsProp.getProperty("owner.text"));
		Thread.sleep(4000);
		String getFamilyTextTitle = this.usersAndPermissionspage.getFamilyText();
		Assert.assertEquals(getFamilyTextTitle, expectedAssertionsProp.getProperty("family.text"));

		String getGuestTextTitle = this.usersAndPermissionspage.getGuestText();
		Assert.assertEquals(getGuestTextTitle, expectedAssertionsProp.getProperty("guest.text"));
		usersAndPermissionspage.clickOnBtnOwner();
		Thread.sleep(6000);

		String enterValidEmailTitle = this.usersAndPermissionspage.getEnterValidEmailText();
		Assert.assertEquals(enterValidEmailTitle, expectedAssertionsProp.getProperty("err.please.enter.validemail"));
		Thread.sleep(4000);
		usersAndPermissionspage.enterOwnerPermissionExistedEmail(testDataProp.getProperty("email"));
		Thread.sleep(4000);
		usersAndPermissionspage.clickSendInvitationBtn();

		String emailAlreadyTakenTitle = this.usersAndPermissionspage.getEmailAlreadyTakenText();
		Assert.assertEquals(emailAlreadyTakenTitle,
				expectedAssertionsProp.getProperty("err.emailaddress.already.taken"));

		Thread.sleep(4000);
		usersAndPermissionspage.enterOwnerPermissionEmailField();
		usersAndPermissionspage.clickOnBtnOwner();
		Thread.sleep(4000);
		usersAndPermissionspage.clickSendInvitationBtn();
		
		  Thread.sleep(10000); 
		  // Check User Granted permission email
		  usersAndPermissionspage.getPermissionGranted(testDataProp.getProperty(
		  "emailPackage"), testDataProp.getProperty("emailActivity"));
		 
		logger.info("Ending Of Verify Add Owner Permission");
	}

	@Test(priority = 4, description = "Verify add Family  Permission")
	@Description("Test Description:Verify add Family  Permission")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify add Family  Permission")
	public void verifyAddFamilyPermission() throws Exception {
		
		logger.info("Starting Of Verify add Family  Permission");
		Thread.sleep(4000);
		usersAndPermissionspage.clickAddPermissionPlusBtn();

		String addUserTitle = this.usersAndPermissionspage.getAddUserText();
		Assert.assertEquals(addUserTitle, expectedAssertionsProp.getProperty("add.user"));

		String inviteNewUserViaEmail = this.usersAndPermissionspage.getInviteNewUserViaEmailText();
		Assert.assertEquals(inviteNewUserViaEmail, expectedAssertionsProp.getProperty("invite.newuser.viaemail"));

		String sendInvitation = this.usersAndPermissionspage.getSendInvitationText();
		Assert.assertEquals(sendInvitation, expectedAssertionsProp.getProperty("send.invitation"));

		usersAndPermissionspage.enterFamilyPermissionEmailField();
		usersAndPermissionspage.clickOnBtnFamily();

		String familyAccess = this.usersAndPermissionspage.getFamilyAccessText();
		Assert.assertEquals(familyAccess, expectedAssertionsProp.getProperty("family.access.text"));

		Thread.sleep(4000);
		usersAndPermissionspage.clickSendInvitationBtn();
		
		  Thread.sleep(10000);
		  usersAndPermissionspage.getPermissionGranted(testDataProp.getProperty(
		  "emailPackage"), testDataProp.getProperty("emailActivity"));
		 
		// Check User Granted permission
		logger.info("Ending Of Verify add Family  Permission");
	}

	@Test(priority = 5, description = "Verify add Guest  Permission")
	@Description("Test Description:Verify add Guest  Permission")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify add Guest  Permission")
	public void verifyAddGuestPermission() throws Exception {
		
		logger.info("Starting Of Verify add Guest  Permission");
		Thread.sleep(4000);
		usersAndPermissionspage.clickAddPermissionPlusBtn();

		String addUserTitle = this.usersAndPermissionspage.getAddUserText();
		Assert.assertEquals(addUserTitle, expectedAssertionsProp.getProperty("add.user"));

		String inviteNewUserViaEmail = this.usersAndPermissionspage.getInviteNewUserViaEmailText();
		Assert.assertEquals(inviteNewUserViaEmail, expectedAssertionsProp.getProperty("invite.newuser.viaemail"));

		String sendInvitation = this.usersAndPermissionspage.getSendInvitationText();
		Assert.assertEquals(sendInvitation, expectedAssertionsProp.getProperty("send.invitation"));
		Thread.sleep(4000);
		usersAndPermissionspage.enterGuestPermissionEmailField();
		usersAndPermissionspage.clickOnBtnGuest();

		String guestAccess = this.usersAndPermissionspage.getGuestAccessText();
		Assert.assertEquals(guestAccess, expectedAssertionsProp.getProperty("guestHasLimitedaccess"));
		Thread.sleep(4000);
		usersAndPermissionspage.clickSendInvitationBtn();
		
		  Thread.sleep(10000);
		  usersAndPermissionspage.getPermissionGranted(testDataProp.getProperty(
		  "emailPackage"), testDataProp.getProperty("emailActivity"));
		 
		// Check User Granted permission
	}

	@Test(priority = 6, description = "Verify Edit Users And Permissions")
	@Description("Test Description:Verify Edit Users And Permissions")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Edit Users And Permissions")
	public void verifyEditUsersAndPermissions() throws Exception {
		logger.info("Starting of Verify Edit Users And Permissions");

		Thread.sleep(6000);
		String access = usersAndPermissionspage.getUserCurrentAccess();

		if (access.contains("Owner") == true) {
			// For owner user, should able to change family and guest access
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnEditButton();
			usersAndPermissionspage.clickOnBtnFamily();

			String getFamilyAccessTextTitle = this.usersAndPermissionspage.getFamilyAccessText();
			Assert.assertEquals(getFamilyAccessTextTitle, expectedAssertionsProp.getProperty("family.access.text"));

			String getTemporaryAccessTextTitle = this.usersAndPermissionspage.getTemporaryAccessText();
			Assert.assertEquals(getTemporaryAccessTextTitle,
					expectedAssertionsProp.getProperty("temporary.access.text"));
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnBtnTemporaryAccess();
			usersAndPermissionspage.selectDtpFromDate();
			usersAndPermissionspage.enterLblStartTime();
			usersAndPermissionspage.selectDtpToDate();
			usersAndPermissionspage.enterLblEndTime();
			usersAndPermissionspage.clickOnBtnSave();
			 
			// Check User Granted permission
			String getUsersTextTitle = this.usersAndPermissionspage.getUsersText();
			Assert.assertEquals(getUsersTextTitle, expectedAssertionsProp.getProperty("users.text"));
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnEditButton();
			usersAndPermissionspage.clickOnBtnOwner();
			usersAndPermissionspage.clickOnBtnSave();
			usersAndPermissionspage.clickOnEditButton();
			usersAndPermissionspage.clickOnBtnGuest();

			Thread.sleep(8000);

			usersAndPermissionspage.clickOnBtnTemporaryAccess();
			usersAndPermissionspage.selectDtpFromDate();
			usersAndPermissionspage.enterLblStartTime();
			usersAndPermissionspage.selectDtpToDate();
			usersAndPermissionspage.enterLblEndTime();
			usersAndPermissionspage.clickOnBtnSave();
			 	// Check User Granted permission
			String getUsersTextTitle2 = this.usersAndPermissionspage.getUsersText();
			Assert.assertEquals(getUsersTextTitle2, expectedAssertionsProp.getProperty("users.text"));

		} else if (access.contains("Family") == true) {
			// For family user, should able to change owner and guest access
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnEditButton();
			usersAndPermissionspage.clickOnBtnGuest();

			String getEditUsersTextTitle1 = this.usersAndPermissionspage.getUsersText();
			Assert.assertEquals(getEditUsersTextTitle1, expectedAssertionsProp.getProperty("users.text"));
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnBtnTemporaryAccess();
			usersAndPermissionspage.selectDtpFromDate();
			usersAndPermissionspage.enterLblStartTime();
			usersAndPermissionspage.selectDtpToDate();
			usersAndPermissionspage.enterLblEndTime();
			usersAndPermissionspage.clickOnBtnSave();
			 
			// Check User Granted permission
			Thread.sleep(4000);
			usersAndPermissionspage.clickOnEditButton();
			usersAndPermissionspage.clickOnBtnFamily();

			String getFamilyAccessTextTitle = this.usersAndPermissionspage.getFamilyAccessText();
			Assert.assertEquals(getFamilyAccessTextTitle, expectedAssertionsProp.getProperty("family.access.text"));

			String getTemporaryAccessTextTitle = this.usersAndPermissionspage.getTemporaryAccessText();
			Assert.assertEquals(getTemporaryAccessTextTitle,
					expectedAssertionsProp.getProperty("temporary.access.text"));
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnBtnTemporaryAccess();
			usersAndPermissionspage.selectDtpFromDate();
			usersAndPermissionspage.enterLblStartTime();
			usersAndPermissionspage.selectDtpToDate();
			usersAndPermissionspage.enterLblEndTime();
			usersAndPermissionspage.clickOnBtnSave();
			  
			 	// Check User Granted permission
			Thread.sleep(4000);

			String getUsersTextTitle1 = this.usersAndPermissionspage.getUsersText();
			Assert.assertEquals(getUsersTextTitle1, expectedAssertionsProp.getProperty("users.text"));

		} else if (access.contains("Guest") == true) {
			// For family guest, should able to change owner and family access
			Thread.sleep(6000);
			usersAndPermissionspage.clickOnEditButton();

			String getEditUsersTextTitle = this.usersAndPermissionspage.getEditUsersText();
			Assert.assertEquals(getEditUsersTextTitle, expectedAssertionsProp.getProperty("edit.users.text"));

			String getChooseAcessLevelFrUserTextTitle = this.usersAndPermissionspage.getChooseAcessLevelFrUserText();
			Assert.assertEquals(getChooseAcessLevelFrUserTextTitle,
					expectedAssertionsProp.getProperty("ChooseAcessLevelFrUser.text"));
			Thread.sleep(6000);

			String getOwnerTextTitle = this.usersAndPermissionspage.getOwnerText();
			Assert.assertEquals(getOwnerTextTitle, expectedAssertionsProp.getProperty("owner.text"));

			String getFamilyTextTitle = this.usersAndPermissionspage.getFamilyText();
			Assert.assertEquals(getFamilyTextTitle, expectedAssertionsProp.getProperty("family.text"));

			String getGuestTextTitle = this.usersAndPermissionspage.getGuestText();
			Assert.assertEquals(getGuestTextTitle, expectedAssertionsProp.getProperty("guest.text"));

			usersAndPermissionspage.clickOnBtnOwner();

			String getOwnerAccessTextTitle = this.usersAndPermissionspage.getOwnerAccessText();
			Assert.assertEquals(getOwnerAccessTextTitle, expectedAssertionsProp.getProperty("owner.access.text"));
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnBtnSave();

			String getUsersTextTitle = this.usersAndPermissionspage.getUsersText();
			Assert.assertEquals(getUsersTextTitle, expectedAssertionsProp.getProperty("users.text"));

			// 3dots
			usersAndPermissionspage.clickOnEditButton();
			usersAndPermissionspage.clickOnBtnFamily();

			String getFamilyAccessTextTitle = this.usersAndPermissionspage.getFamilyAccessText();
			Assert.assertEquals(getFamilyAccessTextTitle, expectedAssertionsProp.getProperty("family.access.text"));

			String getTemporaryAccessTextTitle = this.usersAndPermissionspage.getTemporaryAccessText();
			Assert.assertEquals(getTemporaryAccessTextTitle,
					expectedAssertionsProp.getProperty("temporary.access.text"));
			Thread.sleep(6000);

			usersAndPermissionspage.clickOnBtnTemporaryAccess();
			usersAndPermissionspage.selectDtpFromDate();
			usersAndPermissionspage.enterLblStartTime();
			usersAndPermissionspage.selectDtpToDate();
			usersAndPermissionspage.enterLblEndTime();
			Thread.sleep(6000);
			usersAndPermissionspage.clickOnBtnSave();

			// Check User Granted permission
			Thread.sleep(4000);

			String getUsersTextTitle3 = this.usersAndPermissionspage.getUsersText();
			Assert.assertEquals(getUsersTextTitle3, expectedAssertionsProp.getProperty("users.text"));

		} else {
			logger.info("user access unavailable");
		}

		logger.info("Ending of Verify Edit Users And Permissions");

	}

	@Test(priority = 7, description = "Verifying Resend Invitation")
	@Description("Test Description: Verifying Resend Invitation")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying Resend Invitation")
	public void verifyResendInvitation() {
		logger.info("Starting of ResendInvitation");
		
		try {
			Thread.sleep(6000);
			// 3dots
			usersAndPermissionspage.clickOnBtnResendInvitation();

			String getCancelTextTitle = this.usersAndPermissionspage.getCancelText();
			Assert.assertEquals(getCancelTextTitle, expectedAssertionsProp.getProperty("cancel.text"));

			String getSaveTextTitle = this.usersAndPermissionspage.getYesText();
			Assert.assertEquals(getSaveTextTitle, expectedAssertionsProp.getProperty("yes.text"));

			usersAndPermissionspage.clickOnYesButton();
			
			  Thread.sleep(10000);
			  usersAndPermissionspage.getResendPermissionText(testDataProp.getProperty(
			  "emailPackage"), testDataProp.getProperty("emailActivity"));
			 
			// Check User Resend permission
			Thread.sleep(4000);

		} catch (Exception e) {
			Assert.fail("Error occured while testing ResendInvitation: " + e.getMessage());
			logger.error("Error occured while testing ResendInvitation: " + e);
		}
		logger.info("Ending of ResendInvitation");

	}

	@Test(priority = 8, description = "Verifying Remove Access")
	@Description("Test Description:Verifying Remove Access")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying Remove Access")
	public void verifyRemoveAccess() {
		logger.info("Starting of removeAccess");
		
		try {
			
			Thread.sleep(6000); // 3dots
			usersAndPermissionspage.clickOnBtnRemoveAccess();

			String getCancelTextTitle = this.usersAndPermissionspage.getCancelText();
			Assert.assertEquals(getCancelTextTitle, expectedAssertionsProp.getProperty("cancel.text"));

			String getSaveTextTitle = this.usersAndPermissionspage.getYesText();
			Assert.assertEquals(getSaveTextTitle, expectedAssertionsProp.getProperty("yes.text"));
			Thread.sleep(6000); // 3dots
		
			usersAndPermissionspage.clickOnYesButton();
			
			  Thread.sleep(10000);
			  usersAndPermissionspage.getRemoveAccessText(testDataProp.getProperty(
			  "emailPackage"), testDataProp.getProperty("emailActivity")); 
			  // Check User Remove permission
			 
		} catch (Exception e) {
			Assert.fail("Error occured while testing On removeAccess : " + e.getMessage());
			logger.error("Error occured while testing On removeAccess: " + e);
		}
		logger.info("Ending of removeAccess");
	}
	
	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {

		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}

}
