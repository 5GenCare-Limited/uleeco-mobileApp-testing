package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class LegalPage extends BaseAutomationPage {

	public LegalPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(LegalPage.class.getName());

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement btnHamburgerMenu;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Legal']")
	private WebElement btnLegal;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Privacy Notice']")
	private WebElement txtPrivacyNotice;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Terms & Conditions']")
	private WebElement txtTermsAndConditions;

	@FindBy(xpath = "//android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ImageView")
	private WebElement btnBack;

	public void clickOnHamburgerMenuBtn() throws Exception {
		logger.info("starting of ClickingOnMenuIcon");
		
		this.clickOnElementWithXpath("hamburgermenu.button");

		logger.info("ending of ClickingOnMenuIcon");
	}
	public boolean displayHumBurgerMenu() {
		logger.info("starting of displayHumBurgerMenu");
		logger.info("ending of displayHumBurgerMenu");
		boolean hamburgermenu = this.isDisplayed("hamburgermenu.button");
		return	hamburgermenu;
	}
	public void clickOnLegalButton( ) {
		logger.info("starting of clickOnLegalButton");

		this.clickOnElementWithXpath("btn.legal");

		logger.info("starting of clickOnLegalButton");
	}

	public String getLegalText() {
		logger.info("starting of getLegalText");
		logger.info("ending of getLegalText");

		String myStatusText = this.getElementValueWithXpath("btn.legal");
		return myStatusText;
	}

	public String getPrivacyNoticeText() {
		logger.info("starting of getPrivacyNoticeText");
		logger.info("ending of getPrivacyNoticeText");

		String privacyNoticeText = this.getContentDescValueWithXPath("btn.privacy.notice");
		return privacyNoticeText;

	}

	public String getTermsAndConditionsText() {
		logger.info("starting of getTermsAndConditionsText");
		logger.info("ending of getTermsAndConditionsText");

		String termsAndConditionsText = this.getContentDescValueWithXPath("btn.terms.and.conditions");
		return termsAndConditionsText;
	}
	
	public String getBackButtonText() {
		logger.info("starting of getBackButtonText");
		logger.info("ending of getBackButtonText");

		String backButtonText = this.getContentDescValueWithXPath("btn.legal.back");
		return backButtonText;
	}

	public void clickOnPrivacyAndNoticeBtn() throws Exception {
		logger.info("starting of clickOnPrivacyAndNoticeBtn");

		this.clickOnElementWithXpath("btn.privacy.notice");

		logger.info("starting of clickOnPrivacyAndNoticeBtn");

	}

	public void clickOnTermsAndConditionsBtn() throws Exception {
		logger.info("starting of clickOnTermsAndConditionsBtn");

		this.clickOnElementWithXpath("btn.terms.and.conditions");
		
		logger.info("starting of clickOnTermsAndConditionsBtn");

	}
}
