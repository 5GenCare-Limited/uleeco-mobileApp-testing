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
import com.gencare.pages.SignUpCountryAndLanguageValidationPage;
import com.gencare.pages.ViewProfileCountryAndLanguagePage;
import com.gencare.pages.ViewProfilePage;
import com.gencare.tests.BaseAutomationTest.MOBILE_DRIVER;
import com.gencare.vo.MobileConfigurationVO;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("View Profile")
@Feature("Verify View Profile Functionality Countries and Languages")
public class ViewProfileCountriesAndLanguagesTest extends BaseAutomationTest {

	private ViewProfileCountryAndLanguagePage viewProfileCountryAndLanguagePage = null;
	private ViewProfilePage viewProfilePage = null;
	private SignInPage loginflowpage = null;
	private LandingPage landingPage = null;
	private ChangePasswordPage ChangePassword = null;
	private SignUpCountryAndLanguageValidationPage signUpCountryValidationPage = null;

	private static final Logger logger = Logger.getLogger(ViewProfileCountriesAndLanguagesTest.class.getName());

	@BeforeClass
	@Parameters({"clientApiKey", "platform", "deviceName", "udid", "platformName", "platformVersion", "appPackage", "appActivity" })
	public void initClass(String clientApiKey, String platform, String deviceName, String udid, String platformName, String platformVersion,
			String appPackage, String appActivity) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		MobileConfigurationVO mobileConfigurationVO = new MobileConfigurationVO(clientApiKey, deviceName, udid, platformName,
				platformVersion, appPackage, appActivity);
		this.initMobileDriver(platform, mobileConfigurationVO,MOBILE_DRIVER.VIEWPROFILE_COUNTRIES_DRIVER_TEST);
		this.viewProfilePage = new ViewProfilePage(this.getMobileDriver(udid));
		this.loginflowpage = new SignInPage(this.getMobileDriver(udid));
		this.ChangePassword = new ChangePasswordPage(this.getMobileDriver(udid));
		this.landingPage = new LandingPage(this.getMobileDriver(udid));
		this.viewProfileCountryAndLanguagePage = new ViewProfileCountryAndLanguagePage(this.getMobileDriver(udid));
		this.signUpCountryValidationPage = new SignUpCountryAndLanguageValidationPage(this.getMobileDriver(udid));

		logger.info("Ending of initClass method in LoginTest");
	}

	@Test(priority = 1, description = "Verify Landing page")
	@Description("Test Description: Verify Landing page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verify The Landing page")
	public void verifyLandingPage() {
		logger.info("Starting of Landing Page");

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
		logger.info("Ending of Landing Page");

	}

	@Test(priority = 2, description = "Verify Signin")
	@Description("Test Description: Verify Signin")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Verify The Landing Page")
	public void verifyLogIn() {
		logger.info("Starting Of Signin Method");

		try {
			
			loginflowpage.clickOnSignInButton();
			loginflowpage.enterEmailField(testDataProp.getProperty("email"));
			loginflowpage.enterPasswordField(testDataProp.getProperty("password"));
			loginflowpage.clickOnLogInButton();

		} catch (Exception e) {
			Assert.fail("Error accured while testing landing page: " + e.getMessage());
			logger.error("Error accured while testing landing page: " + e);
		}
		logger.info("Ending Of Signin Method");
	}

	@Test(priority = 3, description = " Verifying HumBurgerMenu")
	@Description("Test Description:  Verifying HumBurgerMenu")
	@Severity(SeverityLevel.BLOCKER)
	@Story(" Verifying HumBurgerMenu")
	public void verifyHamburgerMenu() throws Exception {
		logger.info("Starting of HumBurgerMenu");

		try {
		Thread.sleep(15000);
		viewProfilePage.clickOnHamBurgerMenu();
		viewProfilePage.clickOnSettings();
		viewProfilePage.clickOnProfile();
		
	} catch (Exception e) {
		Assert.fail("Error accured while verifyHamburgerMenu: " + e.getMessage());
		logger.error("Error accured while verifyHamburgerMenu: " + e);
	}
	}

	@Test(priority = 4, description = "Verifying CountryDropdown")
	@Description("Test Description:Verifying CountryDropdown")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying CountryDropdown")
	public void verifyCountryDropdown() throws Exception {
		logger.info("Starting of CountryDropdown");

		Thread.sleep(6000);
		//this.signUpCountryValidationPage.verticalScroll();
		signUpCountryValidationPage.clickOnCountryDropDown();
		//signUpCountryValidationPage.clickOnIndiaCountryButton();
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
		Thread.sleep(3000);
		signUpCountryValidationPage.verticalScrollUp2();
		signUpCountryValidationPage.verticalScrollUp2();
		signUpCountryValidationPage.selectCountry();
		
		String signInButtonTitle = this.signUpCountryValidationPage.getSelectedCountry();
		Assert.assertEquals(signInButtonTitle, expectedAssertionsProp.getProperty("text.selected.country"));

		logger.info("Ending of CountryDropdown");

	}

	@Test(priority = 5, description = "Verifying LanguageDropdown")
	@Description("Test Description:Verifying LanguageDropdown")
	@Severity(SeverityLevel.NORMAL)
	@Story("Verifying LanguageDropdown")
	public void verifyAllTheLanguagesInLanguageDropdown() {
		logger.info("Starting of verify All The Languages In Language Dropdown");

		try {
			Thread.sleep(5000);
			this.signUpCountryValidationPage.verticalScroll();
			this.signUpCountryValidationPage.verticalScroll();
			signUpCountryValidationPage.clickOnLanguageDropdown();
			signUpCountryValidationPage.displyLanguageEnglishText();
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
			Thread.sleep(3000);
			this.signUpCountryValidationPage.verticalScroll();
			signUpCountryValidationPage.displyLanguageRussianText();
			signUpCountryValidationPage.displyLanguageSerbianText();
			signUpCountryValidationPage.displyLanguageSpanishText();
			signUpCountryValidationPage.displyLanguageSwedishText();
			signUpCountryValidationPage.displyLanguageUkrainianText();
			this.signUpCountryValidationPage.verticalScrollUp2();
			signUpCountryValidationPage.clickOnSelectLanguageOption();

		} catch (Exception e) {
			Assert.fail("Error occured while testing On verifyAllTheLanguagesInLanguageDropdown : " + e.getMessage());
			logger.error("Error occured while testing On verifyAllTheLanguagesInLanguageDropdown: " + e);
		}
		logger.info("Ending of LanguageDropdown");
	}

	@AfterClass
	@Parameters({ "deviceName", "udid" })
	public void quitDriver(String deviceName, String udid) {
		logger.info("Starting of quitDriver method");

		this.quitMobileDriver(udid );

		logger.info("Ending of quitDriver method");
	}
}