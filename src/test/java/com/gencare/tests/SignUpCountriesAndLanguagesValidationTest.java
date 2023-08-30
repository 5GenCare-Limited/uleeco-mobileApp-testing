package com.gencare.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gencare.pages.LandingPage;
import com.gencare.pages.SignInPage;
import com.gencare.pages.SignUpAssertionsPage;
import com.gencare.pages.SignUpCountryAndLanguageValidationPage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Signup")
@Feature("Signup Conties And Languages Validation Test")
public class SignUpCountriesAndLanguagesValidationTest extends BaseAutomationTest {

	private SignUpCountryAndLanguageValidationPage signUpCountryValidationPage = null;
	private LandingPage landingPage = null;
	private SignUpAssertionsPage signUpPage = null;
	private static final Logger logger = Logger.getLogger(SignUpCountriesAndLanguagesValidationTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in SignUpFieldsTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.SIGN_UP_COUNTRY_DRIVER_TEST);
		new SignInPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.signUpCountryValidationPage = new SignUpCountryAndLanguageValidationPage(this.getMobileDriver(udid));
		logger.info("Ending of initClass method in SignUpFieldsTest");
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

			String getWelcomeToSalusTitle = this.landingPage.getWelcomeToSalusText();
			Assert.assertEquals(getWelcomeToSalusTitle, expectedAssertionsProp.getProperty("welcome.to.salus.text"));

			String signInButtonTitle = this.landingPage.getSignInButtonText();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("signin.button.text"));

			String demoButtonTitle = this.landingPage.getDemoButtonText();
			Assert.assertEquals(demoButtonTitle, expectedAssertionsProp.getProperty("demo.button.text"));

			// String localWifiModeButton = this.landingPage.getLocalWifiModeButtonText();
			// Assert.assertEquals(localWifiModeButton,
			// expectedAssertionsProp.getProperty("localwifi.mode.button.text"));

			String signUpButton = this.landingPage.getSignUpButtonText();
			Assert.assertEquals(signUpButton, expectedAssertionsProp.getProperty("signup.button.text"));

		} catch (Exception e) {

			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Of Landing Page Method");

	}

	@Test(priority = 2, description = "Verify Language Dropdown")
	@Description("Test Description:Verify Language Dropdown")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify Language Dropdown")
	public void verifyAllTheLanguagesInLanguageDropdown() {
		logger.info("Starting of Language Dropdown");

		try {
			signUpCountryValidationPage.clickOnSignUpButton();
			signUpCountryValidationPage.clickOnLanguageDropdown();
			assertTrue(signUpCountryValidationPage.displyLanguageEnglishText());
			signUpCountryValidationPage.displyLanguageBulgarianText();
			signUpCountryValidationPage.displyLanguageCzechText();
			signUpCountryValidationPage.displyLanguageDanishText();
			signUpCountryValidationPage.displyLanguageDutchText();
			signUpCountryValidationPage.displyLanguageEstonianText();
			signUpCountryValidationPage.displyLanguageFinnishText();
			signUpCountryValidationPage.displyLanguageFrenchText();
			signUpCountryValidationPage.displyLanguageGermanText();
			signUpCountryValidationPage.displyLanguageGreekText();
			signUpCountryValidationPage.displyLanguageLatvianText();
			signUpCountryValidationPage.displyLanguageNorwegianText();
			signUpCountryValidationPage.displyLanguagePolishText();
			signUpCountryValidationPage.displyLanguageRomanianText();
			this.signUpCountryValidationPage.verticalScroll();
			signUpCountryValidationPage.displyLanguageRussianText();
			signUpCountryValidationPage.displyLanguageSerbianText();
			signUpCountryValidationPage.displyLanguageSpanishText();
			signUpCountryValidationPage.displyLanguageSwedishText();
			signUpCountryValidationPage.displyLanguageUkrainianText();
			this.signUpCountryValidationPage.verticalScrollUp();
			signUpCountryValidationPage.clickOnSelectLanguageOption();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On LanguageDropdown : " + e.getMessage());
			logger.error("Error occured while testing On LanguageDropdown: " + e);
		}
		logger.info("Ending of Language Dropdown");
	}

	@Test(priority = 3, description = "Verifying CountryDropdown")
	@Description("Test Description:Verifying CountryDropdown")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying CountryDropdown")
	public void verifyAllCountriesInCountryDropdown() {
		logger.info("Starting of Country Dropdown");

		try {
			this.signUpCountryValidationPage.verticalScroll();
			signUpCountryValidationPage.clickOnCountryDropdown();
			signUpCountryValidationPage.displyCountryAlbaniaText();
			signUpCountryValidationPage.displyCountryAustraliaText();
			signUpCountryValidationPage.displyCountryAustriaText();
			signUpCountryValidationPage.displyCountryAzerbaijanText();
			signUpCountryValidationPage.displyCountryBelarusText();
			signUpCountryValidationPage.displyCountryBelgiumText();
			signUpCountryValidationPage.displyCountryBosnaAndHerzText();
			signUpCountryValidationPage.displyCountryBulgariaText();
			signUpCountryValidationPage.displyCountryChinaText();
			signUpCountryValidationPage.displyCountryCroatiaText();
			signUpCountryValidationPage.displyCountryCyprusText();
			signUpCountryValidationPage.displyCountryChinaText();
			signUpCountryValidationPage.displyCountryDenmarkText();
			signUpCountryValidationPage.displyCountryEstoniaText();
			signUpCountryValidationPage.displyCountryFaroeIslandText();
			this.signUpCountryValidationPage.verticalScroll();
			signUpCountryValidationPage.displyCountryFinlandText();
			signUpCountryValidationPage.displyCountryFranceText();
			signUpCountryValidationPage.displyCountryGeorgiaText();
			signUpCountryValidationPage.displyCountryGreenlandText();
			signUpCountryValidationPage.displyCountryGermanyText();
			signUpCountryValidationPage.displyCountryGreeceText();
			signUpCountryValidationPage.displyCountryHungaryText();
			signUpCountryValidationPage.displyCountryIcelandText();
			signUpCountryValidationPage.displyCountryIndiaText();
			signUpCountryValidationPage.displyCountryIrelandText();
			signUpCountryValidationPage.displyCountryItalyText();
			signUpCountryValidationPage.displyCountryKazakhistanText();
			signUpCountryValidationPage.displyCountryKosovoText();
			signUpCountryValidationPage.displyCountryLatviaText();
			signUpCountryValidationPage.displyCountryLithuaniaText();
			signUpCountryValidationPage.displyCountryMacedoniaText();
			this.signUpCountryValidationPage.verticalScroll();
			signUpCountryValidationPage.displyCountryMontenegroText();
			signUpCountryValidationPage.displyCountryNewZealandText();
			signUpCountryValidationPage.displyCountryNetherlandsText();
			signUpCountryValidationPage.displyCountryNorwayText();
			signUpCountryValidationPage.displyCountryPortugalText();
			signUpCountryValidationPage.displyCountryPolandText();
			signUpCountryValidationPage.displyCountryRomaniaText();
			signUpCountryValidationPage.displyCountryRussiaText();
			signUpCountryValidationPage.displyCountrySerbiaText();
			signUpCountryValidationPage.displyCountrySlovakiaText();
			signUpCountryValidationPage.displyCountrySloveniaText();
			signUpCountryValidationPage.displyCountrySpainText();
			signUpCountryValidationPage.displyCountrySwedenText();
			signUpCountryValidationPage.displyCountrySwitzerlandText();
			signUpCountryValidationPage.displyCountryUkraineText();
			this.signUpCountryValidationPage.verticalScroll();
			signUpCountryValidationPage.displyCountryUnitedKingdomText();
			signUpCountryValidationPage.displyCountryUnitedStatesText();
			signUpCountryValidationPage.displyCountryUruguayText();
			signUpCountryValidationPage.verticalScrollUp();
			signUpCountryValidationPage.verticalScrollUp();
			signUpCountryValidationPage.selectCountry();
			
			String signInButtonTitle = this.signUpCountryValidationPage.getSelectedCountry();
			Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("text.selected.country"));

		} catch (Exception e) {
			Assert.fail("Error occured while testing On CountryDropdown : " + e.getMessage());
			logger.error("Error occured while testing On CountryDropdown: " + e);
		}
		logger.info("Ending of Country Dropdown");

	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}
}
