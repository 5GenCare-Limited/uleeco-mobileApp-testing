package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class LocationPage extends BaseAutomationPage {

	public LocationPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	private static final Logger logger = Logger.getLogger(LocationPage.class.getName());

	
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
	public void clickOnLocationButton( ) {
		logger.info("starting of clickOnLocationButton");

		this.clickOnElementWithXpath("location.button");

		logger.info("ending of clickOnLocationButton");
	}
	public void clickOnLocationFirstGatewayButton( ) {
		logger.info("starting of clickOnLocationFirstGatewayButton");

		this.clickOnElementWithXpath("btn.first.location.gateway");

		logger.info("ending of clickOnLocationFirstGatewayButton");
	}
	public String getAddNewLocationText() {
		logger.info("starting of getAddNewLocationText");
		logger.info("ending of getAddNewLocationText");
		
		String addNewLocationText = this.getContentDescValueWithXPath("add.location.button");
		return addNewLocationText;
	}
	
public String getChooseConnectionModeText() {
	logger.info("starting of getChooseConnectionModeText");
	logger.info("ending of getChooseConnectionModeText");
	
	String chooseConnectionModeText = this.getContentDescValueWithXPath("txt.choose.connection.mode");
	return chooseConnectionModeText;
}
	public void clickOnAddLocationButton() {
		logger.info("starting of clickOnAddLocationButton");

		this.clickOnElementWithXpath("add.location.button");
		
		logger.info("ending of clickOnAddLocationButton");

	}
	public boolean displayGatewayImage() {
		logger.info("starting of displayGatewayImage");
		logger.info("ending of displayGatewayImage");
		
		boolean gatewayImage = this.isDisplayed("icon.gatewayimage.datacollection");
		return	gatewayImage;
	}
	public void clickOnSearchGatewayButton() {
		logger.info("starting of clickOnSearchGatewayButton");

		this.clickOnElementWithXpath("btn.search.gateway.lan");
		
		logger.info("ending of clickOnSearchGatewayButton");

	}
	
	public void clickOnConnectViaLanButton() {
		logger.info("starting of clickOnConnectViaLanButton");

		this.clickOnElementWithXpath("icon.connect.via.lan");
		
		logger.info("ending of clickOnConnectViaLanButton");

	}
	public void clickonCountryButton() {
		logger.info("starting of clickonCountryButton");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickonCountryButton");

	}
	public void clickAndSelectCountry() {
		logger.info("starting of clickAndSelectCountry");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickAndSelectCountry");

	}
	public void clickOnTimezoneDropdown() {
		logger.info("starting of clickOnTimezoneDropdown");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickOnTimezoneDropdown");

	}
	public  void clickAndSelectTimeZone() {
		logger.info("starting of clickAndSelectTimeZone");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickAndSelectTimeZone");

	}
	public void clickOnHourFormat() {
		logger.info("starting of clickOnHourFormat");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickOnHourFormat");

}
	public void clickAndSelectHourFormat() {
		logger.info("starting of clickAndSelectHourFormat");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickAndSelectHourFormat");

}
	public void clickOnLedDropDown() {
		logger.info("starting of clickOnLedDropDown");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickOnLedDropDown");

	}
	public void clickAndSelectLedOption() {
		logger.info("starting of clickAndSelectLedOption");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickAndSelectLedOption");

	}
	public void clickOnAddGatewayImageButton() {
		logger.info("starting of clickOnAddGatewayImageButton");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickOnAddGatewayImageButton");

}
	public void clickAndSelectGatewayImage() {
		logger.info("starting of clickAndSelectGatewayImage");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickAndSelectGatewayImage");

	}
	public void enterGatewayAddress(String address) {
		logger.info("starting of enterGatewayAddress");

		this.setValueWithClearWithXpath("", address);
		
		logger.info("ending of enterGatewayAddress");

		
	}

	public void enterGatewayCity(String city) {
		logger.info("starting of enterGatewayCity");

		this.setValueWithClearWithXpath("", city);
		
		logger.info("ending of enterGatewayCity");

		
	}
	public void enterGatewayPostCode(String postcode) {
		logger.info("starting of enterGatewayPostCode");

		this.setValueWithClearWithXpath("", postcode);
		
		logger.info("ending of enterGatewayPostCode");

		
	}
	public void enterGatewayName(String gatewayname) {
		logger.info("starting of enterGatewayName");

		this.setValueWithClearWithXpath("", gatewayname);
		
		logger.info("ending of enterGatewayName");

		
	}
	public void clickOnActiveGateway() {
		logger.info("starting of clickOnActiveGateway");

		this.clickOnElementWithXpath("");
		
		logger.info("ending of clickOnActiveGateway");

	}
}