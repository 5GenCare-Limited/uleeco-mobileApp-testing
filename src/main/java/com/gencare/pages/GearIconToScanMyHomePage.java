package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class GearIconToScanMyHomePage extends BaseAutomationPage {

	public GearIconToScanMyHomePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(GearIconToScanMyHomePage.class.getName());

	@FindBy(xpath = "//android.widget.ImageView[3]")
	private WebElement iconGear;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Scan my home']")
	private WebElement btnScanMyHome;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Scan Complete']")
	private WebElement txtScanCompleted;

	@FindBy(xpath = "//android.widget.Button")
	private WebElement iconExit;

	@FindBy(xpath = "//android.view.View[@content-desc = '​E​n​e​r​g​y​ ​M​e​t​e​r​s​']")
	private WebElement txtEnergyMeter;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[2]")
	private WebElement iconEcm600;

	@FindBy(xpath = "(//android.widget.ImageView)[1]")
	private WebElement iconEye;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Back']")
	private WebElement btnBack;

	@FindBy(xpath = "//android.view.View[@content-desc = '09160525']")
	private WebElement txtFirmWare;

	public void clickGatewayText() throws Exception {
		logger.info("Starting of clickGatewayText");
		this.Verticalscroll3();
		this.clickOnElement("txt.gatewayname.scanmyhome");
		// this.txtFirmWare.click();

		logger.info("Ending of clickGatewayText");
	}

	public void clickOnGearIconBtn() throws Exception {
		logger.info("starting of clickOnGearIconBtn");

		Thread.sleep(3000);
		this.clickOnElementWithXpath("gear.icon");
		// this.iconGear.click();

		logger.info("ending of clickOnGearIconBtn");
	}

	public void clickOnBackBtn() {
		logger.info("starting of clickOnBackBtn");

		this.clickOnElement("back.button");
		// this.btnBack.click();

		logger.info("ending of clickOnBackBtn");
	}

	public String getScanMyHomeText() {
		logger.info("starting of getChoosePhotoFromLibrary method");
		this.implicitWait();
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ending of getChoosePhotoFromLibrary method");

		return this.getContentDescValue("scan.my.home.button");
		// return btnScanMyHome.getAttribute("content-desc");
	}

	public void clickOnScanMyHomebtn() {
		logger.info("starting of ScanMyHomebtn");

		this.clickOnElement("scan.my.home.button");
		// this.btnScanMyHome.click();

		logger.info("ending of ScanMyHomebtn");
	}

	public String getScanMyHomeGatewayText() {
		logger.info("starting of getScanMyHomeGatewayText method");
		this.implicitWait();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("ending of getScanMyHomeGatewayText method");
		this.verticalScrollUp2();
		return this.getContentDescValueWithXPath("text.gateway.category");
		// return txtEnergyMeter.getAttribute("content-desc");
	}

	public boolean displayEnergyMeterText() {
		this.implicitWait();
		logger.info("starting of getEnergyMeterText method");
		logger.info("ending of getEnergyMeterText method");

		return this.isDisplayed("text.energy.meter");
		// return txtEnergyMeter.isDisplayed();
	}

	public String getScanCompletedText() {
		logger.info("starting of getScanCompletedText method");
		this.implicitWait();
		logger.info("ending of getScanCompletedText method");

		return this.getContentDescValueWithXPath("scan.complete.text");
		// return txtScanCompleted.getAttribute("content-desc");
	}

	public String getECM600Text() {
		this.implicitWait();
		logger.info("starting of getECM600Text method");
		logger.info("ending of getECM600Text method");

		return this.getContentDescValue("device.name.scan.myhome");
		// return iconEcm600.getAttribute("content-desc");
	}

	public boolean displayECM600Icon() {
		logger.info("starting of displayECM600Icon method");
		logger.info("ending of displayECM600Icon method");

		return this.isDisplayed("device.name.scan.myhome");
		// return iconEcm600.isDisplayed();
	}

	public void clickOnExitIcon() {
		logger.info("starting of ExitIcon method");

		this.clickOnElement("icon.exit");
		// this.iconExit.click();

		logger.info("ending of ExitIcon method");
	}

	public void clickOnEnergyMeter() {
		logger.info("starting of clickOnEnergyMeter method");

		this.clickOnElement("text.energy.meter");
		// this.txtEnergyMeter.click();

		logger.info("ending of clickOnEnergyMeter method");
	}

	public boolean displayEyeIcon() {
		logger.info("starting of displayEyeIcon Method");
		logger.info("ending of displayEyeIcon Method");

		return this.isDisplayed("eye.icon.scan.myhome");
		// return iconEye.isDisplayed();
	}

	public void clickOnEyeIcon() {
		logger.info("starting of clickOnEyeIcon method");

		this.clickOnElementWithXpath("eye.icon.scan.myhome");
		// this.iconEye.click();

		logger.info("ending of clickOnEyeIcon method");
	}
}
