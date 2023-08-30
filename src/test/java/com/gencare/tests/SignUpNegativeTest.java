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
public class SignUpNegativeTest extends BaseAutomationTest {
	private SignUpPage signUp = null;
	private LandingPage landingPage = null;
	private SignUpAssertionsPage signUpPage = null;
	private SignUpNegativePage signUpNegativePage = null;
	private static final Logger logger = Logger.getLogger(SignUpTest.class.getName());

	@BeforeClass
	@Parameters({ "clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SignUpFieldsTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGNUP_NEGATIVE_DRIVER_TEST);
		new SignInPage(this.getMobileDriver(udid));
		this.signUp = new SignUpPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.signUpPage = new SignUpAssertionsPage(this.getMobileDriver(udid));
		this.signUpNegativePage = new SignUpNegativePage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in SignUpFieldsTest");
	}

	@Test(priority = 1, description = "Verifying Landing page")
	@Description("Test Description: Verifying Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting of LandingPage");

		try {
			landingPage.clickOnLocationWhileUsingThisAppBtnPopup();
			landingPage.clickOnVideoWhileUsingThisAppBtnPopup();

			String getWelcomeToSalusTitle = this.landingPage.getWelcomeToSalusText();
			Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

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

	@Test(priority = 2, description = "Verifying Sign Up Assertions")
	@Description("Test Description:Verifying Sign Up Assertions")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verifying Sign Up Assertions")
	public void verifySignUp() {
		logger.info("Starting of signup");

		try {
			signUp.clickOnSignUpButton();

			String languageChangeButtonTitle = this.signUpPage.getLanguageChangeButtonText();
			Assert.assertEquals(languageChangeButtonTitle, expectedAssertionsProp.getProperty("english.txt"));

			String firstNameTitle = this.signUpPage.getFirstNameText();
			Assert.assertEquals(firstNameTitle, expectedAssertionsProp.getProperty("first.name.text"));

			String lastNameTitle = this.signUpPage.getLastNameText();
			Assert.assertEquals(lastNameTitle, expectedAssertionsProp.getProperty("last.name.text"));

			String emailTitle = this.signUpPage.getEmailAddressText();
			Assert.assertEquals(emailTitle, expectedAssertionsProp.getProperty("email.address.text"));

			String confirmEmailTitle = this.signUpPage.getConfirmEmailAddressText();
			Assert.assertEquals(confirmEmailTitle, expectedAssertionsProp.getProperty("confirmEmailAddress.text"));

			this.signUpPage.verticalScroll();
			String passwordTitle = this.signUpPage.getPasswordText();
			Assert.assertEquals(passwordTitle, expectedAssertionsProp.getProperty("password.text"));

			String confirmNewPasswordTitle = this.signUpPage.getConfirmNewPasswordText();
			Assert.assertEquals(confirmNewPasswordTitle, expectedAssertionsProp.getProperty("confirmNewPassword.text"));

			String countrySelectionTitle = this.signUpPage.getCountrySelectionText();
			Assert.assertEquals(countrySelectionTitle, expectedAssertionsProp.getProperty("country.text"));

			this.signUpPage.verticalScroll();
			String mobileNumberTitle = this.signUpPage.getMobileNumberText();
			Assert.assertEquals(mobileNumberTitle, expectedAssertionsProp.getProperty("+44MobileNumber.text"));

			String termsAndConditionsTitle = this.signUpPage.getTermsAndConditionsText();
			Assert.assertEquals(termsAndConditionsTitle,
					expectedAssertionsProp.getProperty("signup.terms.and.conditions.text"));

			String privacyNoticeTitle = this.signUpPage.getPrivacyNoticeText();
			Assert.assertEquals(privacyNoticeTitle, expectedAssertionsProp.getProperty("signup.privacy.notice.text"));

			String yesRadioButtonTitle = this.signUpPage.getYesRadioButtonText();
			Assert.assertEquals(yesRadioButtonTitle, expectedAssertionsProp.getProperty("yes.text"));

			String noRadioButtonTitle = this.signUpPage.getNoRadioButtonText();
			Assert.assertEquals(noRadioButtonTitle, expectedAssertionsProp.getProperty("no.text"));

			String createMyProfileTitle = this.signUpPage.getCreateMyProfileText();
			Assert.assertEquals(createMyProfileTitle, expectedAssertionsProp.getProperty("createMyProfile.text"));

			String cancelButtonTitle = this.signUpPage.getCancelButtonText();
			Assert.assertEquals(cancelButtonTitle, expectedAssertionsProp.getProperty("cancel.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing On SignUpPage : " + e.getMessage());
			logger.error("Error occured while testing On SignUpPage: " + e);
		}
		logger.info("Ending of signup");

	}

	@Test(priority = 3, description = "Verify the This Field Is Required Assertion")
	@Description("Test Description: Verify the This Field Is Required Assertion")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify the This Field Is Required Assertion")
	public void testThisFieldIsRequired() {
		logger.info("Starting of testThisFieldIsRequiredAssertion method");

		try {
			signUp.verticalScrollUp();
			signUp.verticalScrollUp();
			signUpNegativePage.clickOnFirstName();
			signUpNegativePage.clickOnLastName();

			String thisFieldIsRequirdTitle = this.signUpNegativePage.getThisFldRqrdFirstNameText();
			Assert.assertEquals(thisFieldIsRequirdTitle,
					expectedAssertionsProp.getProperty("this.field.is.required.text"));

			signUpNegativePage.clickOnEmailAddress();

			String thisFieldIsRequirdLastNameTitle = this.signUpNegativePage.getThisFldRqrdLastNameText();
			Assert.assertEquals(thisFieldIsRequirdLastNameTitle,
					expectedAssertionsProp.getProperty("this.field.is.required.text"));

			signUpNegativePage.clickOnConfirmEmailAddress();

			String thisFieldIsRequirdEmailAddressTitle = this.signUpNegativePage.getThisFldRqrdEmailAddressText();
			Assert.assertEquals(thisFieldIsRequirdEmailAddressTitle,
					expectedAssertionsProp.getProperty("this.field.is.required.text"));

			signUpNegativePage.clickOnPassword();

			String thisFieldIsRequirdCnfmEmailAddressTitle = this.signUpNegativePage
					.getThisFldRqrdcnrmEmailAddressText();
			Assert.assertEquals(thisFieldIsRequirdCnfmEmailAddressTitle,
					expectedAssertionsProp.getProperty("this.field.is.required.text"));

			signUpNegativePage.clickOnConfirmEmailAddress();

			String thisFieldIsRequirdPasswordTitle = this.signUpNegativePage.getThisFldRqrdPasswordText();
			Assert.assertEquals(thisFieldIsRequirdPasswordTitle,
					expectedAssertionsProp.getProperty("this.field.is.required.text"));

			signUpPage.verticalScroll();
			signUpNegativePage.clickOnConfirmNewPassword();
			signUpNegativePage.clickOnMobileNumber();
			signUpNegativePage.verticalScrollUp();

			String thisFieldIsRequirdCnfmNewPasswordTitle = this.signUpNegativePage.getThisFldRqrdCnfmNewPasswordText();
			Assert.assertEquals(thisFieldIsRequirdCnfmNewPasswordTitle,
					expectedAssertionsProp.getProperty("this.field.is.required.text"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing On SignUpNegativePage : " + e.getMessage());
			logger.error("Error occured while testing On SignUpNegativePage: " + e);
		}

		logger.info("Ending on testThisFieldIsRequiredAssertion method");

	}

	@Test(priority = 4, description = "Verify the Password less than Six characters ")
	@Description("Test Description: Verify the Password less than Six characters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify the Password less than Six characters ")
	public void testPasswordLessthanSixCharacters() throws Exception {
		logger.info("Starting of testPasswordLessthanSixCharacters method");

		try {

			signUpNegativePage.verticalScrollUp();
			signUp.clickAndEnterFirstName(testDataProp.getProperty("firstName"));
			signUp.clickAndEnterLastName(testDataProp.getProperty("lastName"));
			signUp.clickAndEnterEmailAdress(testDataProp.getProperty("valid.email"));
			signUp.clickOnConfirmEmailAddress(testDataProp.getProperty("valid.email"));
			signUp.clickAndEnterPassword(testDataProp.getProperty("fourCharacterspassword"));
			this.signUp.verticalScroll2();
			signUp.clickAndEnterConfirmNewPassword(testDataProp.getProperty("password"));
			signUp.clickOnCountryDropdown();
			signUp.selectCountry();
			signUp.clickAndEnterMobileNumber(testDataProp.getProperty("signUpMobileNumber"));
			signUp.clickOnTermsAndConditionsCheckBox();
			signUp.clickOnPrivacyNoticeCheckBox();
			signUp.clickOnYesCheckBox();
			signUp.clickOnCreateMyProfile();

			// signUp.verticalScrollUp();
			Thread.sleep(2000);
			signUpPage.scrollToPasswordText();
			String fourCharPasswordTitle = this.signUpNegativePage.getLessThanSixCharPasswordText();
			Assert.assertEquals(fourCharPasswordTitle,
					expectedAssertionsProp.getProperty("passwords.must.be.at.least.eight.characters.text"));

			signUp.clickOnCancel();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On the Password less than Six characters : " + e.getMessage());
			logger.error("Error occured while testing On the Password less than Six characters: " + e);
		}

		logger.info("Ending on testPasswordLessthanSixCharacters method");

	}

	@Test(priority = 5, description = "Verify the Emails And password Do Not Match ")
	@Description("Test Description: Verify the Emails And password Do Not Match")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify the Emails And password Do Not Match ")
	public void testEmailsAndPasswordsDoNotMatch() {
		logger.info("Starting of testEmailsAndPasswordsDoNotMatch method");

		try {

			signUp.clickOnSignUpButton();
			signUp.verticalScrollUp();
			signUp.clickAndEnterFirstName(testDataProp.getProperty("firstName"));
			signUp.clickAndEnterLastName(testDataProp.getProperty("lastName"));
			signUp.clickAndEnterEmailAdress(testDataProp.getProperty("donotmatchemail"));
			signUp.clickOnConfirmEmailAddress(testDataProp.getProperty("alreadyexistemail"));
			signUp.clickAndEnterPassword(testDataProp.getProperty("morethanfourteenchar"));
			this.signUp.verticalScroll2();
			signUp.clickAndEnterConfirmNewPassword(testDataProp.getProperty("doNotMatchPassword"));
			signUp.clickOnCountryDropdown();
			signUp.selectCountry();
			signUp.clickAndEnterMobileNumber(testDataProp.getProperty("signUpMobileNumber"));
			signUp.clickOnTermsAndConditionsCheckBox();
			signUp.clickOnPrivacyNoticeCheckBox();
			signUp.clickOnYesCheckBox();
			signUp.clickOnCreateMyProfile();

			// this.signUp.verticalScroll2();

			String enteredIsNotAValidEmailTitle = this.signUpNegativePage.getNotAValidEmailText();
			Assert.assertEquals(enteredIsNotAValidEmailTitle,
					expectedAssertionsProp.getProperty("the.emails.you.entered.is.not.a.valid.email.address.text"));

			String enteredEmailsDoNotMatchTitle = this.signUpNegativePage.getDoNotMatchEmailsText();
			Assert.assertEquals(enteredEmailsDoNotMatchTitle,
					expectedAssertionsProp.getProperty("the.emails.you.entered.do.not.match.text"));

			Thread.sleep(3000);
			signUpPage.scrollToPasswordText();

			String MorethanFourteenCharPasswordTitle = this.signUpNegativePage.getMoreThanFourteenCharPasswordText();
			Assert.assertEquals(MorethanFourteenCharPasswordTitle,
					expectedAssertionsProp.getProperty("passwords.must.not.be.longer.tan.fouteen.characters.text"));

			String passwordDoNotMatchTitle = this.signUpNegativePage.getdoNotMatchPasswordText();
			Assert.assertEquals(passwordDoNotMatchTitle,
					expectedAssertionsProp.getProperty("passwords.do.not.match.text"));

			signUp.clickOnCancel();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On the Emails And password Do Not Match : " + e.getMessage());
			logger.error("Error occured while testing On the Emails And password Do Not Match: " + e);
		}

		logger.info("Ending on testEmailsAndPasswordsDoNotMatch method");

	}

	@Test(priority = 6, description = "Verify the Already Exists Email ")
	@Description("Test Description: Verify the Already Exists Email ")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify the Already Exists Email Assertion ")
	public void testAlreadyExistsEmail() throws Exception {
		logger.info("Starting of testAlreadyExistsEmail method");
		try {
			Thread.sleep(3000);
			signUp.clickOnSignUpButton();
			signUp.clickAndEnterFirstName(testDataProp.getProperty("firstName"));
			signUp.clickAndEnterLastName(testDataProp.getProperty("lastName"));
			signUp.clickAndEnterEmailAdress(testDataProp.getProperty("alreadyexistemail"));
			signUp.clickOnConfirmEmailAddress(testDataProp.getProperty("alreadyexistemail"));
			signUp.clickAndEnterPassword(testDataProp.getProperty("password"));
			this.signUp.verticalScroll2();
			signUp.clickAndEnterConfirmNewPassword(testDataProp.getProperty("password"));
			signUp.clickOnCountryDropdown();
			signUp.selectCountry();
			Thread.sleep(3000);
			signUp.clickAndEnterMobileNumber(testDataProp.getProperty("signUpMobileNumber"));
			signUp.clickOnTermsAndConditionsCheckBox();
			signUp.clickOnPrivacyNoticeCheckBox();
			signUp.clickOnYesCheckBox();
			signUp.clickOnCreateMyProfile();

			String emailAddressAlreadyBeenTakenTitle = this.signUpNegativePage.getAlreadyExistsEmailText();
			Assert.assertEquals(emailAddressAlreadyBeenTakenTitle,
					expectedAssertionsProp.getProperty("this.email.address.has.already.been.taken.text"));

			signUp.clickOnCancel();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On the Already Exists Email  : " + e.getMessage());
			logger.error("Error occured while testing On the Already Exists Email : " + e);
		}

		logger.info("Ending of AlreadyExistsEmail method");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");

	}
}