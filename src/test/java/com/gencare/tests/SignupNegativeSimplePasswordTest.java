package com.gencare.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.pages.SignUpAssertionsPage;
import com.gencare.pages.SignUpNegativePage;
import com.gencare.pages.SignUpPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("SignUp function With negative Scenarios")
@Feature("SignUp function With negative Scenarios")
public class SignupNegativeSimplePasswordTest extends BaseAutomationTest {
	private SignUpPage signUp = null;
	private LandingPage landingPage = null;
	private SignUpAssertionsPage signUpPage = null;
	private SignUpNegativePage signUpNegativePage = null;
	private static final Logger logger = Logger.getLogger(SignUpTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SignUpFieldsTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGNUP_NEGATIVE_PASSWORD_DRIVER_TEST);
		new SignInPage(this.getMobileDriver(udid));
		this.signUp = new SignUpPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.signUpPage = new SignUpAssertionsPage(this.getMobileDriver(udid));
		this.signUpNegativePage = new SignUpNegativePage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in SignUpFieldsTest");
	}

	@Test(priority = 1, description = "Verify the Password Is Too Simple")
	@Description("Test Description: Verify the Password Is Too Simple")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify the Password Is Too Simple")
	public void testSimplePassword() throws Exception {

		logger.info("Starting of testsimplePassword method");
		try {
			
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();
			signUp.clickOnSignUpButton();
			signUp.clickAndEnterFirstName(testDataProp.getProperty("firstname"));
			signUp.clickAndEnterLastName(testDataProp.getProperty("lastname"));
			Thread.sleep(3000);
			signUp.clickAndEnterEmailAdress(testDataProp.getProperty("valid.email"));
			signUp.clickOnConfirmEmailAddress(testDataProp.getProperty("valid.email"));
			signUp.clickAndEnterPassword(testDataProp.getProperty("simplePassword"));
			this.signUp.verticalScroll2();
			Thread.sleep(6000);
			signUp.clickAndEnterConfirmNewPassword(testDataProp.getProperty("simplePassword"));
			signUp.clickOnCountryDropdown();
			signUp.selectCountry();
			signUp.clickAndEnterMobileNumber(testDataProp.getProperty("signUpMobileNumber"));
			signUp.clickOnTermsAndConditionsCheckBox();
			signUp.clickOnPrivacyNoticeCheckBox();
			signUp.clickOnYesCheckBox();
			signUp.clickOnCreateMyProfile();
			signUpPage.scrollToPasswordText();

			String simplePasswordTitle = this.signUpNegativePage.getSimplePasswordText();
			Assert.assertEquals(simplePasswordTitle,
					expectedAssertionsProp.getProperty("this.password.is.too.simple.text"));

			signUp.clickOnCancel();

			} catch (Exception e) {
			Assert.fail("Error occured while testing On SignUpNegativePage : " + e.getMessage());
			logger.error("Error occured while testing On SignUpNegativePage: " + e);
		}

		logger.info("Ending on testsimplePassword method");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}
}
