package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class HelpPage extends BaseAutomationPage {

	public HelpPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(HelpPage.class.getName());

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnSignin;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement btnEmailField;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement btnPasswordfield;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnLogInSignIn;

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement iconMenu;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Help']")
	private WebElement btnHelp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'FAQ']")
	private WebElement btnFAQ;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Contact Support']")
	private WebElement btnContactSupport;

	@FindBy(xpath = "//android.view.View[@content-desc = 'About This App']")
	private WebElement btnAboutThisApp;

	@FindBy(xpath = "//android.view.View[1]/android.view.View[2]/android.view.View/android.widget.TextView[2]")
	private WebElement btnSmartHomeFAQs;

	@FindBy(xpath = "//android.widget.TextView[@text = 'Smart Home � Contact']")
	private WebElement btnSmartHomeContact;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Company']")
	private WebElement txtCompany;

	@FindBy(xpath = "//android.view.View[@content-desc = 'SALUS Controls PLC.']")
	private WebElement txtCompanyName;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Build Date']")
	private WebElement txtBuildDate;

	@FindBy(xpath = "//android.view.View[5]")
	private WebElement txtDate;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Released']")
	private WebElement txtReleased;

	@FindBy(xpath = "//android.view.View[7]")
	private WebElement txtReleasedDate;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Version']")
	private WebElement txtVersion;

	//@FindBy(xpath = "//android.view.View[@content-desc = '0.48.4(239)']")
	@FindBy(xpath = "//android.view.View[@content-desc = '0.48.4 (239)']")
	private WebElement txtVersionName;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Back']")
	private WebElement btnBack;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.clickOnElement("");
		//this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickOnHelpBtn() {
		logger.info("starting of clickOnHelpBtn");

		this.clickOnElement("help.button");
		//this.btnHelp.click();

		logger.info("ending of clickOnHelpBtn");
	}

	public String getFAQText() {
		logger.info("starting of getFAQText");
		logger.info("ending of getFAQText");

		return this.getContentDescValue("faq.button");
		//return btnFAQ.getAttribute("content-desc");

	}

	public String getContactSupportText() {
		logger.info("starting of getContactSupportText");
		
		this.verticalScroll();
		
		logger.info("ending of getContactSupportText");

		return this.getContentDescValue("contact.support.button");
		//return btnContactSupport.getAttribute("content-desc");

	}

	public String getAboutThisAppText() {
		logger.info("starting of getAboutThisAppText");
		logger.info("ending of getAboutThisAppText");

		return this.getContentDescValue("about.this.app.button");
		//return btnAboutThisApp.getAttribute("content-desc");

	}

	public void clickOnFAQBtn() throws Exception {
		logger.info("starting of clickOnFAQBtn");

		this.clickOnElement("faq.button");
		//this.btnFAQ.click();

		logger.info("ending of clickOnFAQBtn");
	}

	public String getSmartHomeFAQsText() throws Exception {
		logger.info("starting of getsmartHomeFAQsText");
		logger.info("ending of getsmartHomeFAQsText");

		Thread.sleep(5000);
		return this.getTextValue("smart.home.faq.button");
		//return btnSmartHomeFAQs.getText();

	}

	public void clickOnContactSupportBtn() throws Exception {
		logger.info("starting of clickOnContactSupportBtn");

		this.verticalScroll();
		this.clickOnElement("contact.support.button");
		//this.btnContactSupport.click();

		logger.info("ending of clickOnContactSupportBtn");
	}

	public String getSmartHomeContactText() {
		logger.info("starting of getSmartHomeContactText");
		logger.info("ending of getSmartHomeContactText");

		return this.getContentDescValue("about.this.app.button");
		//return btnSmartHomeContact.getAttribute("text");

	}

	public void clickOnAboutThisAppBtn() {
		logger.info("starting of clickOnaboutThisAppBtn");

		this.verticalScroll();
		this.clickOnElement("about.this.app.button");
		//this.btnAboutThisApp.click();

		logger.info("ending of clickOnaboutThisAppBtn");
	}

	public String getCompanyText() {
		logger.info("starting of getCompanyText");
		logger.info("ending of getCompanyText");

		return this.getContentDescValue("company.text");
		//return txtCompany.getAttribute("content-desc");

	}

	public String getCompanyNameText() {
		logger.info("starting of getCompanyText");
		logger.info("ending of getCompanyText");

		return this.getContentDescValue("company.name.text");
		//return txtCompanyName.getAttribute("content-desc");

	}

	public String getBuildDateText() {
		logger.info("starting of getBuildDateText");
		logger.info("ending of getBuildDateText");
		
		return this.getContentDescValue("build.date.text");
		//return txtBuildDate.getAttribute("content-desc");

	}

	public boolean displayBuildDate() {
		logger.info("starting of displayBuildDate");

		//this.txtDate.isDisplayed();

		logger.info("ending of displayBuildDate");
		
		return this.isDisplayed("build.date.text");

	}

	public String getReleasedText() {
		logger.info("starting of getReleasedText");
		logger.info("ending of getReleasedText");

		return this.getContentDescValue("released.text");
		//return txtReleased.getAttribute("content-desc");

	}

	public boolean displayReleased() {
		logger.info("starting of displayReleased");

		//this.txtReleased.isDisplayed();

		logger.info("ending of displayReleased");
		
		return this.isDisplayed("released.text");
	}

	public String getVersionText() {
		logger.info("starting of getVersionText");
		logger.info("ending of getVersionText");

		return this.getContentDescValue("version.text");
		//return txtVersion.getAttribute("content-desc");

	}

	public String getVersionNameText() {
		logger.info("starting of getVersionNameText");
		logger.info("ending of getVersionNameText");

		return this.getContentDescValue("version.number");
		//return txtVersionName.getAttribute("content-desc");

	}

	public void clickOnBackBtn() {
		logger.info("starting of clickOnBackBtn");

		this.clickOnElement("back.button");
		//this.btnBack.click();

		logger.info("ending of clickOnBackBtn");
	}

}
