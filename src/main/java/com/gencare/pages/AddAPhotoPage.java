package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class AddAPhotoPage extends BaseAutomationPage {

	public AddAPhotoPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(AddAPhotoPage.class.getName());

	@FindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[3]")
	private WebElement iconGear;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Add a photo']")
	private WebElement btnAddAPhoto;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Choose photo from library']")
	private WebElement btnChoosePhotoFromLibrary;;

	@FindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]")
	private WebElement imgUploadPhoto;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]//android.widget.ImageView[2]")
	private WebElement btnExit;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	public void clickOnGearIconBtn() throws Exception {
		logger.info("Starting of clickOnGearIconBtn");

		Thread.sleep(2000);
		this.clickOnElementWithXpath("gear.icon");

		logger.info("Ending of clickOnGearIconBtn");
	}

	public String getAddAPhotoText() {
		logger.info("Starting of getAddAPhotoText method");
		logger.info("Ending of getAddAPhotoText method");
		
		String addAPhotoText = this.getContentDescValue("add.a.photo.button");
		return addAPhotoText;
	}

	public void clickOnAddAPhotoButton() throws Exception {
		logger.info("Starting of clickOnAddAPhotoButton");

		Thread.sleep(2000);
		this.clickOnElement("add.a.photo.button");

		logger.info("Ending of clickOnAddAPhotoButton");

	}

	public String getChoosePhotoFromLibrary() {
		logger.info("Starting of getChoosePhotoFromLibrary");
		logger.info("Ending of getChoosePhotoFromLibrary");
		
		String choosePhotoFromLibrary = this.getContentDescValue("choose.from.library.button");
		return choosePhotoFromLibrary;
	}

	public void clickAnduploadAFilefromChoosePhotoFromLibrary() {
		logger.info("Starting of uploadAFilefromChoosePhotoFromLibrary");

		this.clickOnElement("choose.from.library.button");
		this.clickOnElementWithXpath("first.image");

		logger.info("Ending of uploadAFilefromChoosePhotoFromLibrary");
	}

	public void clickOnExitBtn() {
		logger.info("Starting of clickOnExitBtn");

		this.clickOnElement("");

		logger.info("Ending of clickOnExitBtn");
	}
}