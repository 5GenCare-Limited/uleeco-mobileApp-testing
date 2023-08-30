package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class NewUsersDashBoardPage extends BaseAutomationPage {

	public NewUsersDashBoardPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(NewUsersDashBoardPage.class.getName());

	// @FindBy(xpath = "//android.view.View[@content-desc = 'Add new Gateway']")
	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Add new Gateway']")
	private WebElement addNewGateway;

	@FindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement hamburgerMenuBtn;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Welcome to your dashboard!']")
	private WebElement welcomeToSUrDashBoardMessage;

	@FindBy(xpath = "android.view.View[@content-desc = 'Activate your gateway']")
	private WebElement activerYourGatewayText;

	@FindBy(xpath = "android.widget.Button[@content-desc = 'Search for gateway']")
	private WebElement searchForGatewayBtn;

	@FindBy(xpath = "//android.view.View[2]/android.view.View[1]//android.widget.ImageView[1]")
	private WebElement gatewayImage;

	@FindBy(xpath = "//android.view.View[2]/android.view.View[1]//android.widget.ImageView[2]")
	private WebElement gearIcon;

	@FindBy(xpath = "//android.view.View[@content-desc = '!']")
	private WebElement alertIcon;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement signInbutton;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement emailfield;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement passwordfield;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement LogInSignInButton;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Activate your gateway']")
	private WebElement txtActivateyourgateway;

	@FindBy(xpath = "//android.view.View/android.widget.ImageView[2]")
	private WebElement btnMenu;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Home']")
	private WebElement btnHome;

	@FindBy(xpath = "//android.view.View[2]/android.view.View[1]")
	private WebElement txtWelcometoyourdashboard;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickOnSignInButton() throws Exception {

		logger.info("starting of ClickingOnSignInButton");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		this.clickOnElement("login.button");

		// this.signInbutton.click();
		logger.info("ending of ClickingOnSignInButton");
	}

	public void enterEmailField(String newUserEmail) throws Exception {

		logger.info("starting of ClickingAndEnterEmailField");
		this.setValueWithClear("email.text", newUserEmail);

		/*
		 * this.emailfield.click(); this.emailfield.clear();
		 * this.emailfield.sendKeys(newUserEmail);
		 */
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterEmailField");
	}

	public void enterPasswordField(String newUserPassword) throws Exception {

		logger.info("starting of ClickingAndEnterPasswordField");
		this.setValueWithClear("password.text", newUserPassword);
		/*
		 * this.passwordfield.click(); this.passwordfield.clear();
		 * this.passwordfield.sendKeys(newUserPassword);
		 */
		driver.hideKeyboard();
		logger.info("ending of ClickingAndEnterPasswordField");
	}

	public void clickOnLogInButton() {
		logger.info("starting of ClickingOnLogInSignInButton");		try {
			this.clickOnElement("login.button");

			// this.LogInSignInButton.click();
		} catch (Exception e) {
		}
		
		logger.info("ending of ClickingOnLogInSignInButton");

	}

	public String getAddNewGatewayText() {
		logger.info("starting of getAddNewGatewayText");
		logger.info("ending of getAddNewGatewayText");
		
		String addNewGatewayText = this.getContentDescValue("addnew.gateway.text");
		return addNewGatewayText;
		// return addNewGateway.getAttribute("content-desc");
	}

	public boolean displayHamburgerMenu() {
		logger.info("starting of displayHamburgerMenu");
		logger.info("ending of displayHamburgerMenu");
		
		boolean displayHamburger = this.isDisplayed("txt.last.name.viewprofile");
		return displayHamburger;
		// this.hamburgerMenuBtn.isDisplayed();

	}

	public String getActivateyourgatewayText() {
		logger.info("starting of getAddNewGatewayText");
		logger.info("ending of getAddNewGatewayText");
		
		String activateyourgatewayText = this.getContentDescValue("active.your.gateway.text");
		return activateyourgatewayText;
		// return txtActivateyourgateway.getAttribute("content-desc");
	}

	public void clickOnMenuButton() throws Exception {		
		logger.info("starting of clickOnMenuButton");
		
		this.clickOnElementWithXpath("hamburgermenu.button");
		// this.btnMenu.click();

		logger.info("ending of clickOnMenuButton");

	}

	public void clickOnSalusIcon() throws Exception {
		logger.info("starting of clickOnSalusIcon");
		
		this.implicitWait();
		this.clickOnElementWithXpath("salus.icon");
		//this.btnMenu.click();

		logger.info("ending of clickOnSalusIcon");

	}

	public void clickOnHomeButton() throws Exception {
		logger.info("starting of clickOnHomeButton");
		
		this.clickOnElement("home.button");
		//	this.btnHome.click();

		logger.info("ending of clickOnHomeButton");

	}

	public String getWelcometoyourdashboardText() {
		logger.info("starting of getWelcometoyourdashboardText");
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("ending of getWelcometoyourdashboardText");
		
		String welcometoyourdashboardText = this.getContentDescValue("welcome.toyour.dashboard.text");
		return welcometoyourdashboardText;
		// return txtWelcometoyourdashboard.getAttribute("content-desc");

	}

}
