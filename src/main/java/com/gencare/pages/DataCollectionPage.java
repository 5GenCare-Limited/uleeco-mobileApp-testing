package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class DataCollectionPage extends BaseAutomationPage {

	public DataCollectionPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	public static final Logger logger = Logger.getLogger(DataCollectionPage.class.getName());

	
	
	public void clickOnSettingButton() {
		logger.info("starting of clickOnSettingButton");

		this.clickOnElementWithXpath( "btn.settings");

		logger.info("starting of clickOnSettingButton");
	}
	
	public void clickOnDataCollectionButton() {
		logger.info("starting of clickOnDataCollectionButton");

		this.clickOnElementWithXpath( "txt.data.collection");

		logger.info("starting of clickOnDataCollectionButton");
	}
	
	public String getDataCollectionText() {
		logger.info("starting of getDataCollectionText");
		logger.info("ending of getDataCollectionText");
		
		String dataCollectionTittle = this.getContentDescValueWithXPath("txt.data.collection");
		return dataCollectionTittle;
	}
	
	public void clickOnDataCollectionOf() {
		logger.info("starting of clickOnDataCollectionOf");

		this.clickOnElementWithXpath( "rdo.data.collection.off");

		logger.info("starting of clickOnDataCollectionOf");
	}
	
	public void clickOnDataCollectionSaveButton() {
		logger.info("starting of clickOnDataCollectionSaveButton");

		this.clickOnElementWithXpath( "btn.save.data.collection");

		logger.info("starting of clickOnDataCollectionSaveButton");
	}
	public void clickOnOkButton() {
		logger.info("starting of clickOnOkButton");

		this.clickOnElementWithXpath( "btn.ok.data.collection");

		logger.info("starting of clickOnOkButton");
	}
	public void clickOnDataCollectionOn() {
		logger.info("starting of clickOnDataCollectionOn");

		this.clickOnElementWithXpath( "rdo.data.collection.on");

		logger.info("starting of clickOnDataCollectionOn");
	}
	public boolean displayGatewayImage() {
		logger.info("starting of displayGatewayImage");
		logger.info("ending of displayGatewayImage");
		boolean gatewayImage = this.isDisplayed("icon.gatewayimage.datacollection");
		return	gatewayImage;
	}
}
