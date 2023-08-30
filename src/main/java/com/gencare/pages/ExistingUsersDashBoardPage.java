package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class ExistingUsersDashBoardPage extends BaseAutomationPage {

	public ExistingUsersDashBoardPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(ExistingUsersDashBoardPage.class.getName());

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement txtGatewayTime;

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement btnhamburgerMenu;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[3]")
	private WebElement iconGear;

	@FindBy(xpath = "//android.view.View[@content-desc = '!']")
	private WebElement IconAlert;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement frmPinnedDevice;

	public void clickOnHamburgerMenu() throws Exception {

		logger.info("starting of clickOnHamburgerMenu");

		Thread.sleep(15000);
		this.clickOnElement("hamburgermenu.button");
		 //this.btnhamburgerMenu.click();

		logger.info("ending of clickOnHamburgerMenu");
	}

	public boolean displayHumBurgerMenu() {
		logger.info("starting of displayHumBurgerMenu");
		logger.info("ending of displayHumBurgerMenu");

		boolean hamburgermenu = this.isDisplayed("hamburgermenu.button");
		return hamburgermenu;

	}

	public boolean displayGatewayTimeImage() {
		logger.info("Starting of ShowGatewayTimeImage");
		logger.info("Starting of ShowGatewayTimeImage");

		boolean gatewayimage = this.isDisplayed("existing.user.dashboardimage");
		return gatewayimage;

	}

	public boolean displayHamburgerMenuBtn() {
		logger.info("Starting of ShowHamburgerMenuBtn");
		logger.info("Ending of ShowHamburgerMenuBtn");

		boolean hamburgermenu = this.isDisplayed("hamburgermenu.button");
		return hamburgermenu;

	}

	public boolean displyAlertIconText() {
		logger.info("Starting of GetalertIconText");
		logger.info("Ending of GetalertIconText");

		boolean alerticon = this.isDisplayed("alert.icon");
		return alerticon;

	}

	public boolean displayGearIcon() {
		logger.info("Starting of ShowGearIcon");
		logger.info("Ending of showGearIcon");

		boolean gearicon = this.isDisplayed("gear.icon");
		return gearicon;

	}

	public boolean displayPinnedDevice() {
		logger.info("Starting of displayPinnedDevice");
		logger.info("Ending of displayPinnedDevice");

		boolean gatewayicon = this.isDisplayed("gateway.icon");
		return gatewayicon;

	}
}
