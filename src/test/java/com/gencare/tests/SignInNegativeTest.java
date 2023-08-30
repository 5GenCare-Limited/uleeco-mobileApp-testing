package com.gencare.tests;

import com.gencare.pages.SignInNegativePage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Epic("Signin")
@Feature("SignIn Negative Functionality")
public class SignInNegativeTest extends BaseAutomationTest {

	private SignInNegativePage signIn = null;
	private static final Logger logger = Logger.getLogger(SignInNegativeTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey","platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SignInPage");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SING_IN_DRIVER_TEST);
		this.signIn = new SignInNegativePage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in SignInPage");

	}

	@Test(priority = 1, description = "Verify Signin With Empty Fields")
	@Description("Test Description: Verify Signin With Empty Fields")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify Signin With Empty Fields")
	public void verifySignInWithEmptyFields() {
		logger.info("Starting Of Verify Signin With Empty Fields Method");

		try {
			signIn.clickOnLocationPopup();
			signIn.clickOnSignInBtn();
			signIn.clickAndClearEmailField();
			signIn.clickOnLogInBtn();
			
			String logInWithOutEmailTitle = this.signIn.getLogInWithOutEmailText();
			Assert.assertEquals(logInWithOutEmailTitle,
					expectedAssertionsProp.getProperty("thisFieldsIsRequired.text"));

			String LogInWithOutPasswordTitle = this.signIn.getLogInWithOutPasswordText();
			Assert.assertEquals(LogInWithOutPasswordTitle, expectedAssertionsProp.getProperty("password.this.field.required"));

		} catch (Exception e) {
			Assert.fail("Error accured while testing SignInWithEmptyFields : " + e.getMessage());
			logger.error("Error accured while testing SignInWithEmptyFields: " + e);
		}
		logger.info("Ending Of Verify Signin With Empty Fields Method");
	}

	@Test(priority = 2, description = "Verifying SignInwithInvalidCredentials")
	@Description("Test Description: Verifying SignInwithInvalidCredentials")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying SignInwithInvalidCredentials")
	public void verifyingSignInwithInvalidCredentials() {

		logger.info("Starting of SignInwithInvalidCredentials");

		try {
			Thread.sleep(3000);
			signIn.clickOnSignInBtn();
			signIn.clickAndEnterUserEmail(testDataProp.getProperty("invalidUserEmail"));
			signIn.clickAndEnterUserPassword(testDataProp.getProperty("invalidUserPassword"));
			signIn.clickOnLogInBtn();
			
			String emailIncorrectErrorMessageTitle = this.signIn.getEmailIncorrectText();
			Assert.assertEquals(emailIncorrectErrorMessageTitle,
					expectedAssertionsProp.getProperty("emailIncorrect.text"));

		} catch (Exception e) {
		}
		logger.info("Ending of Verifying SignInwithInvalidCredentials");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}
}
