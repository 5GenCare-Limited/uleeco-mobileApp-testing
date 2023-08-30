package com.gencare.tests;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.ForgotPasswordPage;
import com.gencare.pages.LandingPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Password Functionality")
@Feature("Forgot Fassword Functionality")
public class ForgotPasswordTest extends BaseAutomationTest {
	private ForgotPasswordPage forgotPasswordPage = null;
	private LandingPage landingPage = null;
	private static final Logger logger = Logger.getLogger(ForgotPasswordTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in forgot password test");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.FORGOT_PASSWORD_USER_DRIVER_TEST);
		this.forgotPasswordPage = new ForgotPasswordPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));

		logger.info("Ending of initClass method in forgot password test");
	}

	@Test(priority = 1, description = "Verifying Landing page")
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

	@Test(priority = 2, description = "Verify Signin Page")
	@Description("Verify Signin Page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Signin Page")
	public void verifySigninPage() {
		logger.info("Starting Of Verify Signin Page Method");

		try {

			forgotPasswordPage.clickOnSignInBtn();

			String emailTitle = this.forgotPasswordPage.getEmailTextBoxText();
			Assert.assertEquals(emailTitle, expectedAssertionsProp.getProperty("email.text"));

			String passwordTitle = this.forgotPasswordPage.getPasswordTextBoxText();
			Assert.assertEquals(passwordTitle, expectedAssertionsProp.getProperty("password.text"));

			String keepMeLoggedInTitle = this.forgotPasswordPage.getKeepMeLoggedInText();
			Assert.assertEquals(keepMeLoggedInTitle,
					expectedAssertionsProp.getProperty("keepme.loggedin.frgtpswd.text"));

			String loginBtnTitle = this.forgotPasswordPage.getLoginBtnText();
			Assert.assertEquals(loginBtnTitle, expectedAssertionsProp.getProperty("login.btn.text"));

			String getForgetYourPswdTitle = this.forgotPasswordPage.getForgetYourPswdText();
			Assert.assertEquals(getForgetYourPswdTitle,
					expectedAssertionsProp.getProperty("frgt.urpswd.frgtpswd.text"));
			/*
			 * String dntHvAcntYtTitle = this.forgotPasswordPage.getDntHvAcntYtText();
			 * Assert.assertEquals(dntHvAcntYtTitle,
			 * expectedAssertionsProp.getProperty("dnthv.acnt.ytfrgtpswd.text"));
			 */
			String setupAnAcntTitle = this.forgotPasswordPage.getSetupAnAcntText();
			Assert.assertEquals(setupAnAcntTitle, expectedAssertionsProp.getProperty("setup.an.acnt.text"));
			this.verticalScroll();
			// forgotPasswordPage.displyBackNavigationIcon();

		} catch (Exception e) {

			Assert.fail("Error accured while testing signin page: " + e.getMessage());
			logger.error("Error accured while testing signin page: " + e);
		}

		logger.info("Ending Of Verify Signin Page Method");

	}

	@Test(priority = 3, description = "Verify Invalid Password Validation message")
	@Description("Test Description:Verify Invalid Password Validation messagae")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Invalid Password Validation message")
	public void verifyLoginWithInvalidPassword() {
		logger.info("Starting Of Verify Invalid Password Validation messagae Method");

		try {
			forgotPasswordPage.clickAndClearEmailField(testDataProp.getProperty("email"));
			forgotPasswordPage.enterInvalidPassword(testDataProp.getProperty("invaliduserpassword"));
			forgotPasswordPage.clickOnLogin();
			Thread.sleep(4000);
			String getErrPswdTitle = this.forgotPasswordPage.getErrPswdText();
			Assert.assertEquals(getErrPswdTitle, expectedAssertionsProp.getProperty("err.pswd.frgtpswd.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing verifyLoginWithInvalidPassword page: " + e.getMessage());
			logger.error("Error accured while testing verifyLoginWithInvalidPassword page: " + e);
		}
		logger.info("Ending Of Verify Invalid Password Validation messagae Method");

	}

	@Test(priority = 4, description = "Verify Confirmation Code")
	@Description("Test Description: Verify Confirmation Code")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Confirmation Code")
	public void verifyConfirmationCode() throws Exception {
		logger.info("Starting Of Verify Confirmation Code Method");

		try {
			Thread.sleep(2000);
			forgotPasswordPage.clickOnFrgtYourPswd();
			Thread.sleep(6000);

			String getWelcmToSalusTitle = this.forgotPasswordPage.getWelcmToSalusText();
			Assert.assertEquals(getWelcmToSalusTitle,
					expectedAssertionsProp.getProperty("welcm.to.salus.frgtpswd.text"));

			String getForgetYourPswdTitle = this.forgotPasswordPage.getForgetYourPswdText();
			Assert.assertEquals(getForgetYourPswdTitle,
					expectedAssertionsProp.getProperty("frgt.urpswd.frgtpswd.text"));

			// forgotPasswordPage.displytEmailTxtBox();

			String getEmailCnfrmCodeTitle = this.forgotPasswordPage.getEmailCnfrmCodeText();
			Assert.assertEquals(getEmailCnfrmCodeTitle,
					expectedAssertionsProp.getProperty("email.cnftn.code.frgtpswd.text"));

			// forgotPasswordPage.displyBackNavigationIcon();
			forgotPasswordPage.clickOnConfirmationCodeBtn();

		} catch (Exception e) {
			Assert.fail("Error accured while testing verifyConfirmationCode: " + e.getMessage());
			logger.error("Error accured while testing verifyConfirmationCode: " + e);
		}

		logger.info("ending Of Verify Confirmation Code Method");
	}

	@Test(priority = 5, description = "Verify Create Password")
	@Description("Test Description: Verify Create Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Create Password")
	public void verifyCreatePassword() {
		logger.info("Starting Of Verify Create Password Method");

		try {

			String getConfirmationCodeTitle = this.forgotPasswordPage.getConfirmationCodeText();
			Assert.assertEquals(getConfirmationCodeTitle,
					expectedAssertionsProp.getProperty("cnfrn.code.frgtpswd.text"));

			String getNewPswdTitle = this.forgotPasswordPage.getNewPswdText();
			Assert.assertEquals(getNewPswdTitle, expectedAssertionsProp.getProperty("new.pswd.frgtpswd.text"));

			String getConfirmNewPswdTTitle = this.forgotPasswordPage.getConfirmNewPswdText();
			Assert.assertEquals(getConfirmNewPswdTTitle,
					expectedAssertionsProp.getProperty("cnfrm.new.pswd.frgtpswd.text"));

			String getSaveNewPswdTitle = this.forgotPasswordPage.getSaveNewPswdText();
			Assert.assertEquals(getSaveNewPswdTitle, expectedAssertionsProp.getProperty("save.new.pswd.frgtpswd.text"));

			String getResendConfirmationEmailTitle = this.forgotPasswordPage.getResendConfirmationEmailText();
			Assert.assertEquals(getResendConfirmationEmailTitle,
					expectedAssertionsProp.getProperty("resnd.cnftn.email.frgtpswd.text"));

			// forgotPasswordPage.displyBackNavigationIcon();

		} catch (Exception e) {

			Assert.fail("Error accured while testing on verifyCreatePassword: " + e.getMessage());
			logger.error("Error accured while testing on verifyCreatePassword: " + e);
		}

		logger.info("Ending Of Verify Create Password Method");

	}

	@Test(priority = 6, description = "Verify Required Fields")
	@Description("Verify Required Fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Required Fields")
	public void verifyRequiredFields() {
		logger.info("starting Of Verify Required Fields Method");

		try {

			forgotPasswordPage.clickOnSaveNewPassword();

			String getResendConfirmationEmailTitle = this.forgotPasswordPage.getThisFldRqrdConfirmationCodeText();
			Assert.assertEquals(getResendConfirmationEmailTitle,
					expectedAssertionsProp.getProperty("this.fld.rqrd.confirmation.frgtpswd.code.text"));

			String getThisFldRqrdNewPswdTitle = this.forgotPasswordPage.getThisFldRqrdNewPswdText();
			Assert.assertEquals(getThisFldRqrdNewPswdTitle,
					expectedAssertionsProp.getProperty("this.fld.rqrd.new.pswd.frgtpswd.text"));

			String getThisFldRqrdCnfrmNewPswdTitle = this.forgotPasswordPage.getThisFldRqrdCnfrmNewPswdText();
			Assert.assertEquals(getThisFldRqrdCnfrmNewPswdTitle,
					expectedAssertionsProp.getProperty("this.fld.rqrd.new.cnfrm.pswd.frgtpswd.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing on verifyRequiredFields: " + e.getMessage());
			logger.error("Error accured while testing on verifyRequiredFields: " + e);
		}

		logger.info("Ending Of Verify Required Fields Method");

	}

	@Test(priority = 7, description = "Verify Invalid Password Validation Message")
	@Description("Test Description: Verify Invalid Password")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Invalid Password Validation Message")
	public void verifyInvalidPassword() throws Exception {
		logger.info("starting Of Verify Invalid Password Method");

		forgotPasswordPage.clickAndEnterInvalidCnfrmCode(testDataProp.getProperty("invalidcnfrncode"));
		forgotPasswordPage.enterInvaliNewPswd(testDataProp.getProperty("invalidnewpswd"));
		forgotPasswordPage.clickAndEnterDntMatchConfrmPswd(testDataProp.getProperty("dntmatchcnfrnpswd"));
		forgotPasswordPage.clickOnSaveNewPassword();

		logger.info("Ending Of Verify Invalid Password Method");

	}

	@Test(priority = 8, description = "Verify All Password Fields Validation messages")
	@Description("Test Description: Verify All Password Fields Validation messages")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify All Password Fields Validation messages")
	public void verifyPasswordFunctions() throws Exception {
		logger.info("Starting Of Verify Password Functions Method");

		try {
			String PswdsNstNtLongerFrteenCrctrsTitle = this.forgotPasswordPage.getPswdsNstNtLongerFrteenCrctrsText();
			Assert.assertEquals(PswdsNstNtLongerFrteenCrctrsTitle,
					expectedAssertionsProp.getProperty("pswdmstbe.lngrtnfrtncrctr.frgtpswd.text"));

			String getPswdDntMatchTitle = this.forgotPasswordPage.getPswdDntMatchText();
			Assert.assertEquals(getPswdDntMatchTitle,
					expectedAssertionsProp.getProperty("pswd.dnt.mtch.frgtpswd.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing on verifyPasswordFunctions: " + e.getMessage());
			logger.error("Error accured while testing on verifyPasswordFunctions: " + e);

			logger.info("Ending Of Verify Password Functions Method");
		}
	}

	@Test(priority = 9, description = "Verify Simple Password")
	@Description("Test Description: Verify Simple Password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Simple Password")
	public void testSimplePassword() throws Exception {
		logger.info("Starting Of Verify Simple Password Method");

		try {
			forgotPasswordPage.clickAndEnterSimpleNewPswdText(testDataProp.getProperty("splnwpswd"));
			forgotPasswordPage.clickAndEnterSimpleCnfrmPswdText(testDataProp.getProperty("splcnfmpswd"));
			forgotPasswordPage.clickOnSaveNewPassword();

		} catch (Exception e) {
			Assert.fail("Error accured while testing on Simple Passwors: " + e.getMessage());
			logger.error("Error accured while testing on Simple Passwor: " + e);

			logger.info("Ending Of Verify Simple Password Method");
		}
	}

	@Test(priority = 10, description = "Verify Simple Password Validation Messages")
	@Description("Test Description: Verify Simple Password Validation Messages")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Simple Password Validation Messages")
	public void verifySimplePasswordValidation() throws Exception {
		logger.info("Starting Of Verify Simple Password Validation Method");

		try {

			String SimpleNewPswdTitle = this.forgotPasswordPage.getSimpleNewPswdText();
			Assert.assertEquals(SimpleNewPswdTitle,
					expectedAssertionsProp.getProperty("thzistoosmpl.nwpswd.frgtpswd.text"));

			String SimpleCnfrmPswdTitle = this.forgotPasswordPage.getSimpleCnfrmPswdText();
			Assert.assertEquals(SimpleCnfrmPswdTitle,
					expectedAssertionsProp.getProperty("thzistoosmpl.cnfmpswd.frgtpswd.text"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing on simple Password Validation Messages: " + e.getMessage());
			logger.error("Error accured while testing on simple Password Validation Messagesn: " + e);
		}

		logger.info("Ending Of Verify Simple Password Method");

	}

	@Test(priority = 11, description = "Verify New Passowrd Field")
	@Description("Test Description: Verify New Passowrd Field")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify New Passowrd Field")
	public void testNewPasswordFuncrtionality() throws Exception {
		logger.info("Starting Of Verify New Passowrd Field Method");

		try {
			forgotPasswordPage.clickAndEnterValidNewPswd(testDataProp.getProperty("validnewpassword"));
			forgotPasswordPage.clickAndEnterCnfrmPswd(testDataProp.getProperty("validcnfmpswd"));
			forgotPasswordPage.clickOnSaveNewPassword();

		} catch (Exception e) {
			Assert.fail("Error accured while testing on New Passowrd Field: " + e.getMessage());
			logger.error("Error accured while testing on New Passowrd Field: " + e);
		}
		logger.info("Ending Of Verify New Passowrd Field Method");

	}

	@Test(priority = 12, description = "Verify Inccorect Confirmation Code")
	@Description("Test Description: Verify Inccorect Confirmation Code")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Inccorect Confirmation Code")
	public void verifyInccorectConfirmationCode() throws Exception {
		logger.info("Starting Of Verify Inccorect Confirmation Code Method");

		try {
			String IncorrectCnfrmCodeTitle = this.forgotPasswordPage.getIncorrectCnfrmCodeText();
			Assert.assertEquals(IncorrectCnfrmCodeTitle,
					expectedAssertionsProp.getProperty("incrct.cnfrn.code.frgtpswd.text"));

			forgotPasswordPage.clickOnConfirmationCode();
			forgotPasswordPage.setOTP(testDataProp.getProperty("emailPackage"),
					testDataProp.getProperty("emailActivity"));
			driver.hideKeyboard();
			forgotPasswordPage.clickOnSaveNewPassword();
			Thread.sleep(4000);

		} catch (Exception e) {
			Assert.fail("Error accured while testing on New Passowrd Field: " + e.getMessage());
			logger.error("Error accured while testing on New Passowrd Field: " + e);
		}

		logger.info("Ending Of Verify Inccorect Confirmation Code Method");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid);

		logger.info("Ending of quitDriver method");


	}

}