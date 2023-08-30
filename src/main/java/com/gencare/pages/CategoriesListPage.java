package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class CategoriesListPage extends BaseAutomationPage {

	public CategoriesListPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(CategoriesListPage.class.getName());

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement btnHamburgerMenu;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Equipment']")
	private WebElement btnEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'All equipment']")
	private WebElement btnAllEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'My Equipment']")
	private WebElement btnMyEquipment;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Groups']")
	private WebElement frmGroup;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Categories']")
	private WebElement btnCategories;

	@FindBy(xpath = "//android.widget.ImageView[4]")
	private WebElement lblGateWaysTile;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Add new Equipment']")
	private WebElement txtAddNewEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'All equipment']")
	private WebElement allEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'OneTouch']")
	private WebElement oneTouch;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Gateways']")
	private WebElement gateways;

	public void clickOnHamburgerMenu() throws Exception {

		logger.info("starting of clickOnHamburgerMenu");

		this.clickOnElementWithXpath("hamburgermenu.button");

		logger.info("ending of clickOnHamburgerMenu");

	}

	public String getAllEquipmentText() {

		logger.info("starting of getAllEquipmentText");

		String allEquipmentText = this.getContentDescValue("all.equipment.button");

		logger.info("ending of getAllEquipmentText");

		return allEquipmentText;

	}

	public String getoneTouchText() {

		logger.info("starting of getoneTouchText");

		String oneTouchText = this.getContentDescValue("onetouch.button");

		logger.info("ending of getoneTouchText");

		return oneTouchText;

	}

	public String getGatewaysText() {

		logger.info("starting of getGatewaysText");

		String gatewaysText = this.getContentDescValue("gateway.button");

		logger.info("ending of getGatewaysText");

		return gatewaysText;

	}

	public void clickOnHamBurgerMenu() {

		logger.info("starting of clickOnHamBurgerMenu");

		this.clickOnElementWithXpath("hamburgermenu.button");

		logger.info("ending of clickOnHamBurgerMenu");

	}

	public boolean displayHumburgerMenu() throws InterruptedException {

		logger.info("starting of displayHumburgerMenu");

		Thread.sleep(10000);
		boolean hamburgermenu = this.isDisplayed("hamburgermenu.button");

		logger.info("ending of displayHumburgerMenu");

		return hamburgermenu;

	}

	public void clickOnEquipment() throws InterruptedException {
		logger.info("starting of clickOnddEquipment");

		Thread.sleep(1000);
		this.clickOnElement("equipment.button");

		logger.info("ending of clickOnddEquipment");

	}

	public void clickOnAllEquipment() {
		logger.info("starting of clickOnlstAllEquipment");

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.clickOnElement("all.equipment.button");

		logger.info("ending of clickOnlstAllEquipment ");

	}

	public String getGroupText() {

		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();

		logger.info("starting of getGroupText");

		String groups = this.getTextValue("groups.button");

		logger.info("ending of getGroupText");

		return groups;

	}

	public String getCategoriesText() {

		logger.info("starting of getCategoriesText");

		String categories = this.getTextValue("categories.button");

		logger.info("ending of getCategoriesText");

		return categories;

	}

	public void clickOncategories() {

		logger.info("starting of clickOncategories");

		this.clickOnElement("categories.button");

		logger.info("ending of clickOncategories");

	}

	public String getCategoriesMyEquipmentText() {

		logger.info("starting getCategoriesMyEquipmentText method");

		String categoriesMyEquipment = this.getContentDescValue("my.equipment.categories.text");

		logger.info("ending of getCategoriesMyEquipmentText method");

		return categoriesMyEquipment;

	}

	public String getUnGrpdMyEquipmentText() {

		logger.info("starting ofgetMyEquipmentText");

		String unGrpdMyEquipment = this.getTextValue("txt.unbrouped.equipment.categories");

		logger.info("ending of getMyEquipmentText");

		return unGrpdMyEquipment;

	}

	public void clickOngateWaysTile() {

		logger.info("starting of clickOngateWaysTile");

		//this.clickOnElement("categories.gateway");
		this.clickOnElementWithXpath("categories.gateway");

		logger.info("ending of clickOngateWaysTile");

	}

	public String getAddNewEquipmentText() {

		logger.info("starting getAddNewEquipmentText");

		String addNewEquipment = this.getContentDescValue("addnew.equipment.categories");

		logger.info("ending of getAddNewEquipmentText");

		return addNewEquipment;

	}

}