package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class MyStatusPage extends BaseAutomationPage {

	public MyStatusPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	private static final Logger logger = Logger.getLogger(MyStatusPage.class.getName());

	
	public void clickOnHamburgerMenuBtn() throws Exception {
		logger.info("starting of ClickingOnMenuIcon");
		
		this.clickOnElementWithXpath( "hamburgermenu.button");

		logger.info("ending of ClickingOnMenuIcon");
	}
	
	public boolean displayHumBurgerMenu() {
		logger.info("starting of displayHumBurgerMenu");
		logger.info("ending of displayHumBurgerMenu");
		boolean hamburgermenu = this.isDisplayed("hamburgermenu.button");
		return	hamburgermenu;
	}
	
	public void clickOnMyStatusButton( ) {
		logger.info("starting of clickOnMyStatusButton");

		this.clickOnElement("mystatus.button");

		logger.info("starting of clickOnMyStatusButton");
	}
	
	public String getMyStatusText() {
		logger.info("starting of getMyStatusText");
		logger.info("ending of getMyStatusText");
		
		String myStatusText = this.getContentDescValue("mystatus.button");
		return myStatusText;
	}
	
	public String getAddNewStatusText() {
		logger.info("starting of getAddNewStatusText");
		logger.info("ending of getAddNewStatusText");
		
		String addNewStatus = this.getContentDescValue( "add.new.status");
		return addNewStatus;
	}
	
	public void clickOnAddNewMyStatusButton() {
		logger.info("starting of clickOnAddNewMyStatusButton");

		this.clickOnElement( "add.new.status");

		logger.info("starting of clickOnAddNewMyStatusButton");
	}
	
	public void clickOnAMyStatusButton() {
		logger.info("starting of clickOnAMyStatusButton");

		this.clickOnElementWithXpath("a.icon.my.status");

		logger.info("starting of clickOnAMyStatusButton");
	}
	
	public String getCreateNewStatusText() {
		logger.info("starting of getCreateNewStatusText");
		logger.info("ending of getCreateNewStatusText");
		
		String createNewStatusTittle = this.getContentDescValue("create.new.status");
		return createNewStatusTittle;
	}
	
	public String getNameThisStatusText() {
		logger.info("starting of getNameThisStatusText");
		logger.info("ending of getNameThisStatusText");
		
		String nameThisStatusTittle = this.getContentDescValue("name.this.status");
		return nameThisStatusTittle;
	}
	
	public void clickOnEnterNameOfMyStatus(String cherry) {
		logger.info("starting of clickOnEnterNameOfMyStatus");

		this.setValueWithClearWithXpath("txt.name.of.status", cherry);
		driver.hideKeyboard();

		logger.info("ending of clickOnEnterNameOfMyStatus");
	}
	
	public String getSelectIconForStatusText() {
		logger.info("starting of getSelectIconForStatusText");
		logger.info("ending of getSelectIconForStatusText");
		
		String selectIconForStatusTextTittle = this.getContentDescValue( "txt.selectan.iconyour.status");
		return selectIconForStatusTextTittle;
	}
	
	public void clickOnContinueButton() {
		logger.info("starting of clickOnContinueButton");

		this.clickOnElement("btn.continue.mystatus");

		logger.info("starting of clickOnContinueButton");
	}
	
	public String getContinueText() {
		logger.info("starting of getContinueText");
		logger.info("ending of getContinueText");
		
		String continueText = this.getContentDescValue( "btn.continue.mystatus");
		return continueText;
	}
	
	public String getCancelText() {
		logger.info("starting of getCancelText");
		logger.info("ending of getCancelText");
		
		String cancelText = this.getContentDescValue( "btn.cancel.mystatus");
		return cancelText;
	}
	
	public String NameFieldRequired() {
		logger.info("starting of getNameFieldRequiredText");
		logger.info("ending of getNameFieldRequiredText");
		
		String nameFieldRequiredTittle = this.getContentDescValue( "err.mystatus.fldrequired");
		return nameFieldRequiredTittle;
	}
	
	public void clickOnOneTouchCheckBox() {
		logger.info("starting of clickOnOneTouchCheckBox");

		this.clickOnElementWithXpath("chk.first.mystatus.onetouch");

		logger.info("starting of clickOnOneTouchCheckBox");
	}
	
	public void clickOnSelecctMystatusRadioBtn() {
		logger.info("starting of clickOnSelecctMystatusRadioBtn");

		this.clickOnElementWithXpath("radio.mystatus.select");

		logger.info("starting of clickOnSelecctMystatusRadioBtn");
	}
	
	public void clickOnEditMystatusIcon() {
		logger.info("starting of clickOnEditMystatusIcon");

		this.clickOnElementWithXpath("icon.edit.mystatus");

		logger.info("starting of clickOnEditMystatusIcon");
	}
	
	public void clickOnSaveButtonMystatus() {
		logger.info("starting of clickOnSaveButtonMystatus");

		for(int i=0; i<=2; i++) {
			this.verticalScroll();
		}
		this.clickOnElement("btn.save.mystatus");

		logger.info("starting of clickOnSaveButtonMystatus");
	}
	
	public void clickOnSaveButton() {
		logger.info("starting of clickOnSaveButton");

		this.clickOnElement("btn.save.mystatus");

		logger.info("starting of clickOnSaveButton");
	}
	
	public void clickOnCreatedMystatus() throws InterruptedException {
		logger.info("starting of clickOnCreatedMystatus");

		Thread.sleep(15000);
		this.clickOnElementWithXpath("created.mystatus");

		logger.info("starting of clickOnCreatedMystatus");
	}
	
	public String getDeleteStatusText() {
		logger.info("starting of getDeleteStatusText");
		
		for(int i=0; i<=2; i++) {
			this.verticalScroll();
		}
		
		logger.info("ending of getDeleteStatusText");
		
		String deleteStatusTittle = this.getContentDescValue("txt.delete.mystatus");
		return deleteStatusTittle;
	}
	
	public String getDeleteThisStatusText() {
		logger.info("starting of getDeleteThisStatusText");
		logger.info("ending of getDeleteThisStatusText");
		
		String deleteThisStatusTittle = this.getContentDescValue("txt.delete.this.status");
		return deleteThisStatusTittle;
	}
	
	public String getDeleteText() {
		logger.info("starting of getDeleteText");
		logger.info("ending of getDeleteText");
		
		String deleteTittle = this.getContentDescValue("btn.delete.mystatus");
		return deleteTittle;
	}
	
	public void clickOnDeleteButton() {
		logger.info("starting of clickOnDeleteButton");

		this.clickOnElement("btn.delete.mystatus");

		logger.info("starting of clickOnDeleteButton");
	}
	
	public void clickOnCancelButton() {
		logger.info("starting of clickOnCancelButton");

		this.clickOnElement("btn.cancel.mystatus");

		logger.info("starting of clickOnCancelButton");
	}
	
	public void clickOnDeleteStatusButton() throws InterruptedException {
		logger.info("starting of clickOnDeleteStatusButton");

		Thread.sleep(2000);
		this.clickOnElement("txt.delete.mystatus");

		logger.info("starting of clickOnDeleteStatusButton");
	}
}
