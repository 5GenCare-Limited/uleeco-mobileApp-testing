package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class GridAndReorderingPage extends BaseAutomationPage {

	public GridAndReorderingPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(GridAndReorderingPage.class.getName());

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnSignIn;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement txtEmailField;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement txtPasswordfield;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnLogin;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.btnWhileUsingTheApp.click();

		logger.info("ending of clickOnLocationPopup");

	}
	
	public void clickOnSignInButton() throws Exception{
		logger.info("starting of ClickingOnSignInButton");
	
			Thread.sleep(5000);
		this.btnSignIn.click();
		
		logger.info("ending of ClickingOnSignInButton");
	}

	public void enterEmailField(String validemail) {
		logger.info("starting of ClickingAndEnterEmailField");
		
		this.txtEmailField.click();
		this.txtEmailField.sendKeys(validemail);
		driver.hideKeyboard();
		
		logger.info("ending of ClickingAndEnterEmailField");
	}

	public void enterPasswordField(String validpassword) {
		logger.info("starting of enterPasswordField");
		
		this.txtPasswordfield.click();
		this.txtPasswordfield.sendKeys(validpassword);
		driver.hideKeyboard();
		
		logger.info("ending of enterPasswordField");
	}

	public void clickOnLogInButton() throws Exception{
		logger.info("starting of ClickingOnLogInSignInButton");
		
			Thread.sleep(3000);
			this.btnLogin.click();
		
		logger.info("ending of ClickingOnLogInSignInButton");
	}

	public void gridReordering() throws Exception {
		logger.info("starting of gridReorderingOS600");

		this.implicitWait();
		
		
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//android.widget.ImageView[5]"));
		Thread.sleep(4000);
		WebElement destination = driver.findElement(By.xpath("//android.view.View[4]"));
		act.clickAndHold(src).moveToElement(destination).release().build().perform();
		
		logger.info("ending of gridReorderingOS600");

	}


	public void dragDevice() {
		logger.info("Starting of dragDevice method");

		Actions act = new Actions(driver);
		WebElement from = driver.findElement(By.xpath("//android.view.View[4]"));
		act.dragAndDropBy(from, 220, 110).perform();

		logger.info("Ending of dragDevice method");

	}

}