package com.gencare.pages;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Optional;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseAutomationPage {

	protected AndroidDriver<WebElement> driver = null;
	protected static Properties androidLangXPathsProp = null;
	protected static Properties iosLangXPathsProp = null;

	private static final String platformName = "platform";

	String platform = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter(platformName);

	private static final Logger logger = Logger.getLogger(BaseAutomationPage.class.getName());

	public BaseAutomationPage(AndroidDriver<WebElement> driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void elementToBeClickable(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} catch (StaleElementReferenceException se) {
			// alternate solution
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		}

	}

	public Properties androidTestData(@Optional String flavour, @Optional String lang) throws IOException {

		FileReader androidLangxPathReader = null;
		String fileName = "androidxpaths_en.properties";

		String androidLangxPathFile = getLanguageFilePath(flavour, fileName, lang);
		logger.debug("Android Xpath properties file " + androidLangxPathFile);
		androidLangxPathReader = new FileReader(androidLangxPathFile);
		androidLangXPathsProp = new Properties();
		androidLangXPathsProp.load(androidLangxPathReader);

		return androidLangXPathsProp;

	}

	public Properties iosTestData(@Optional String flavour, @Optional String lang) throws IOException {
		FileReader iosLangxPathReader = null;
		String fileName = "iosxpaths_en.properties";

		String iosLangxPathFile = getLanguageFilePath(flavour, fileName, lang);
		logger.debug("IOS Xpath properties file " + iosLangxPathFile);
		iosLangxPathReader = new FileReader(iosLangxPathFile);
		iosLangXPathsProp = new Properties();
		iosLangXPathsProp.load(iosLangxPathReader);

		return iosLangXPathsProp;

	}

	public static String getLanguageFilePath(String flavour, String fileName, String lang) {

		logger.info("Starting of getLanguageFilePath method");
		if (lang == null) {
			lang = "en";
		}

		if (fileName.contains("_")) {
			fileName = fileName.split("_")[0] + "_" + lang + ".properties";
		}

		logger.info("End of getLanguageFilePath method");
		return "src/main/resources" + "/" + flavour + "/" + "lang" + "/" + lang + "/" + fileName;
	}

	public String getTestFilePath() {
		// String path = "src/main/resources/testdata";
		String path = "src/main/resources";
		File file = new File(path);
		return file.getAbsolutePath();
	}

	public void implicitWait() {
		logger.info("Starting of implicitWait Method");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		logger.info("Ending of implicitWait Method");
	}

	public LocalDate getFutureDate() {
		logger.info("Starting of getCurrentDate method");

		LocalDate futureDate = LocalDate.now().plusMonths(1);

		logger.info("Ending of getCurrentDate method");
		return futureDate;
	}

	public String getCurrentDate() {
		logger.info("Starting of getCurrentDate method");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		String dateValue = formatter.format(date);
		logger.info("Ending of getCurrentDate method");
		return dateValue;
	}

	public String nextDate() {
		logger.info("Starting of nextDate method");

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date futureDateTime = calendar.getTime();
		String formattedFutureDate = sdf.format(futureDateTime);
		System.out.println(formattedFutureDate);

		logger.info("Ending of nextDate method");
		return formattedFutureDate;
	}

	public void verticalScrollProfile() {
		logger.info("Starting of verticalScroll Method");

		Dimension size = driver.manage().window().getSize();
		for (int i = 1; i < 3; i++) {
			int startX = size.width / 4;

			int endX = startX;

			int startY = (int) (size.height * 0.7);

			int endY = (int) (size.height * 0.2);

			TouchAction t = new TouchAction(driver);

			t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
					.moveTo(PointOption.point(endX, endY)).release().perform();
		}
		logger.info("Ending of verticalScroll Method");
	}

	public void verticalScroll() {
		logger.info("Starting of verticalScroll Method");
		
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.9);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	public void verticalScroll2() throws InterruptedException {
		logger.info("Starting of verticalScroll Method");

		Thread.sleep(3000);

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.9);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	public void verticalScrollThree() throws InterruptedException {
		logger.info("Starting of verticalScroll Method");

		Thread.sleep(3000);

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 4;

		int endX = startX;

		int startY = (int) (size.height * 0.6);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	public void verticalScrollUp() {
		logger.info("Starting of verticalScrollUp Method");

		Dimension dimension = driver.manage().window().getSize();

		int start_X = (int) (dimension.width * 0.9);
		int start_Y = (int) (dimension.height * 0.2);

		int end_X = (int) (dimension.width * 0.2);
		int end_Y = (int) (dimension.height * 0.8);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(start_X, start_Y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(end_X, end_Y)).release().perform();

		logger.info("Starting of verticalScrollUp Method");
	}

	public void rToLHorizontalScroll() {

		logger.info("Starting of rToLHorizontalScroll Method");

		Dimension dimension = driver.manage().window().getSize();

		int start_X = (int) (dimension.width * 0.5);
		int start_Y = (int) (dimension.height * 0.2);

		int end_X = (int) (dimension.width * 0.2);
		int end_Y = (int) (dimension.height * 0.8);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(start_X, start_Y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(end_X, end_Y)).release().perform();

		logger.info("Ending of rToLHorizontalScroll Method");
	}

	public void lToRHorizontalScroll() {
		logger.info("Starting of lToRHorizontalScroll Method");

		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width * 0.5);

		int endX = (int) (size.width * 0.8);

		int startY = (int) ((int) size.height / 3.0);

		int endY = startY;

		for (int i = 0; i < 2; i++) {

			TouchAction t = new TouchAction(driver);

			t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
					.moveTo(PointOption.point(endX, endY)).release().perform();
		}

		logger.info("Ending of lToRHorizontalScroll Method");
	}

	public void sleep(int sec) {
		logger.info("Starting of sleep Method");

		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {

		}

		logger.info("Ending of sleep Method");
	}

	protected void scrolltoView() throws InterruptedException {
		// Thread.sleep(3000);
		Dimension size = driver.manage().window().getSize();

		int endY = size.width / 2;

		int startY = endY;

		int endX = (int) (size.height * 0.3);

		int startX = (int) (size.height * 0.8);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	public void back() {
		logger.info("Starting of back Method");

		driver.navigate().back();

		logger.info("Ending of back Method");
	}

	public void verticalScrollUp2() {
		logger.info("Starting of verticalScroll Method");

		sleep(3000);

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.2);

		int endY = (int) (size.height * 0.8);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	public void getOTPFromEmail(String appPkg, String appAct, WebElement emailSubject, WebElement emailBody,
			WebElement OTPField) throws InterruptedException {

		String currentAct = ((AndroidDriver) driver).getCurrentPackage();

		System.out.println(currentAct);

		Thread.sleep(5000);

		((StartsActivity) driver).startActivity(new Activity(appPkg, appAct));

		Thread.sleep(5000);

		this.clickOnElementWithXpath("email.subject");
		//emailSubject.click();

		Thread.sleep(5000);

		//String otp = emailBody.getText();
		String otp = this.getElementValueWithXpath("email.body");

		Thread.sleep(5000);

		String str = otp;

		String numberOnly = str.replaceAll("[^0-9]", "");

		String otpNumber = numberOnly.substring(0, 6);

		System.out.println(otpNumber);

		Thread.sleep(5000);

		driver.activateApp(currentAct);

		Thread.sleep(1000);
		setValueWithClearWithXpath("text.otp.field", otpNumber);
//		OTPField.click();
//		OTPField.clear();
//		OTPField.sendKeys(otpNumber);

		driver.hideKeyboard();
	}
	
	public void getOTPForgotEmail(String appPkg, String appAct, WebElement emailSubject, WebElement emailBody,
			WebElement OTPField) throws InterruptedException {

		String currentAct = ((AndroidDriver) driver).getCurrentPackage();

		System.out.println(currentAct);

		Thread.sleep(5000);

		((StartsActivity) driver).startActivity(new Activity(appPkg, appAct));

		Thread.sleep(10000);

		this.clickOnElementWithXpath("email.subject.forgot.password");
		
		Thread.sleep(5000);
		//emailSubject.click();
		this.Verticalscroll3();
		Thread.sleep(5000);

		//String otp = emailBody.getText();
		String otp = this.getElementValueWithXpath("email.body.forgot.password");

		Thread.sleep(5000);

		String str = otp;

		String numberOnly = str.replaceAll("[^0-9]", "");

		String otpNumber = numberOnly.substring(0, 6);

		System.out.println(otpNumber);

		Thread.sleep(5000);

		driver.activateApp(currentAct);

		Thread.sleep(1000);
		setValueWithClearWithXpath("text.otp.field", otpNumber);
//		OTPField.click();
//		OTPField.clear();
//		OTPField.sendKeys(otpNumber);

		driver.hideKeyboard();
	}

	public void clickOnElementWithAccessibilityID(String text) {

		WebElement element = driver.findElementByAccessibilityId(text);

		element.click();

	}

	public String getTextOfElementWithAccessibilityID(String text) {

		WebElement element = driver.findElementByAccessibilityId(text);

		return element.getText();

	}

	public void scroll() {

		sleep(3000);

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.8);

		int endY = (int) (size.height * 0.4);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

	}

	public void Verticalscroll() {
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.8);

		int endY = (int) (size.height * 0.4);

		for (int i = 0; i < 2; i++) {

			TouchAction t = new TouchAction(driver);

			t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
					.moveTo(PointOption.point(endX, endY)).release().perform();
		}
	}
	public void Verticalscroll3() {
		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.5);

		int endY = (int) (size.height * 0.2);

		for (int i = 0; i < 1; i++) {

			TouchAction t = new TouchAction(driver);

			t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
					.moveTo(PointOption.point(endX, endY)).release().perform();
		}
	}

	public void clickOnElement(String xpath) {

		if (platform.equalsIgnoreCase("android")) {

			String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId(xpathAndroid);

			element.click();

		} else if (platform.equalsIgnoreCase("ios")) {

			String xpathIOS = iosLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathIOS);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId(xpathIOS);

			element.click();

		} else {

			logger.info("Platform Not Provided");

		}

	}

	public void clickAndClear(String xpath) {

		if (platform.equalsIgnoreCase("android")) {

			String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//WebElement element = driver.findElementByAccessibilityId(xpathAndroid);
			
			WebElement element = driver.findElement(By.xpath(xpathAndroid));

			element.click();

			element.clear();

		} else if (platform.equalsIgnoreCase("ios")) {

			String xpathIOS = iosLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathIOS);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId(xpathIOS);

			element.click();

			element.clear();

			element.clear();

			element.clear();

		} else {

			logger.info("Platform Not Provided");

		}

	}

	public void setValueWithClear(String xpath, String input) {

		if (platform.equalsIgnoreCase("android")) {

			String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId(xpathAndroid);

			element.click();
			element.clear();

			element.sendKeys(input);

		} else if (platform.equalsIgnoreCase("ios")) {

			String xpathIOS = iosLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathIOS);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId(xpathIOS);

			element.click();

			element.clear();

			element.clear();

			element.clear();

			element.sendKeys(input);

		} else {

			logger.info("Platform Not Provided");

		}

	}

	public void setValueWithoutClear(String xpath, String input) {

		if (platform.equalsIgnoreCase("android")) {

			String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId((xpathAndroid));

			element.click();

			element.sendKeys(input);

		} else if (platform.equalsIgnoreCase("ios")) {

			String xpathIOS = iosLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathIOS);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId(xpathIOS);

			element.click();

			element.sendKeys(input);

		} else {

			logger.info("Platform Not Provided");

		}

	}

	public String getTextValue(String xpath) {

		WebElement element = null;

		String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

		logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

		element = driver.findElementByAccessibilityId((xpathAndroid));

		return element.getText();

	}

	public String getTextValueWithXpath(String xpath) {

		WebElement element = null;

		String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

		logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

		element = driver.findElement(By.xpath(xpathAndroid));

		return element.getText();

	}

	public String getNameValue(String xpath) {

		WebElement element = null;

		String xpathIOS = iosLangXPathsProp.getProperty(xpath);

		logger.debug("***** xPath from properties file ********** : " + xpathIOS);

		element = driver.findElementByAccessibilityId(xpathIOS);

		return element.getAttribute("name");

	}

	public String getNameValueWithXpath(String xpath) {

		WebElement element = null;

		String xpathIOS = iosLangXPathsProp.getProperty(xpath);

		logger.debug("***** xPath from properties file ********** : " + xpathIOS);

		element = driver.findElement(By.xpath(xpathIOS));

		return element.getAttribute("name");

	}

	public String getContentDescValue(String xpath) {

		WebElement element = null;

		String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

		logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

		element = driver.findElementByAccessibilityId(xpathAndroid);

		return element.getAttribute("content-desc");

	}

	public String getContentDescValueWithXPath(String xpath) {

		WebElement element = null;

		String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

		logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

		element = driver.findElement(By.xpath(xpathAndroid));
		return element.getAttribute("content-desc");

	}

	public boolean isDisplayed(String xpath) {

		WebElement element = null;

		if (platform.equalsIgnoreCase("android")) {

			String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

			element = driver.findElement(By.xpath(xpathAndroid));

		} else if (platform.equalsIgnoreCase("ios")) {

			String xpathIOS = iosLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathIOS);

			element = driver.findElementByAccessibilityId(xpathIOS);

		} else {

			logger.info("Platform Not Provided");

		}

		return element.isDisplayed();

	}

	public void clickOnElementWithXpath(String xpath) {

		if (platform.equalsIgnoreCase("android")) {

			String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath(xpathAndroid));

			element.click();

		} else if (platform.equalsIgnoreCase("ios")) {

			String xpathIOS = iosLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathIOS);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath(xpathIOS));

			element.click();

		} else {

			logger.info("Platform Not Provided");

		}

	}

	public void setValueWithClearWithXpath(String xpath, String input) {

		if (platform.equalsIgnoreCase("android")) {

			String xpathAndroid = androidLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathAndroid);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElement(By.xpath(xpathAndroid));

			element.click();

			element.clear();

			element.sendKeys(input);

		} else if (platform.equalsIgnoreCase("ios")) {

			String xpathIOS = iosLangXPathsProp.getProperty(xpath);

			logger.debug("***** xPath from properties file ********** : " + xpathIOS);

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement element = driver.findElementByAccessibilityId(xpathIOS);

			element.click();

			element.clear();

			element.clear();

			element.clear();

			element.sendKeys(input);

		} else {

			logger.info("Platform Not Provided");

		}

	}

	public String getElementValue(String xpath) {

		String elementValue = null;

		if (platform.equalsIgnoreCase("android")) {

			if (this.getTextValue(xpath) == null) {

				elementValue = this.getContentDescValue(xpath);
			} else {

				elementValue = this.getTextValue(xpath);

			}

		} else if (platform.equalsIgnoreCase("ios")) {

			elementValue = this.getNameValue(xpath);

		} else {

			logger.info("Platform Not Provided");

		}

		return elementValue;

	}

	public String getElementValueWithXpath(String xpath) {

		String elementValue = null;

		if (platform.equalsIgnoreCase("android")) {

			if (this.getTextValueWithXpath(xpath) == null) {

				elementValue = this.getContentDescValueWithXPath(xpath);
			} else {

				elementValue = this.getTextValueWithXpath(xpath);

			}

		} else if (platform.equalsIgnoreCase("ios")) {

			elementValue = this.getNameValueWithXpath(xpath);

		} else {

			logger.info("Platform Not Provided");

		}

		return elementValue;

	}
	
	public enum MOBILE_ACTIONS {
		CLICK, VISIBILE, TOAST
	}
	
	protected WebElement findElement(WebElement webelement, MOBILE_ACTIONS mobileActions) {
		logger.info("Starting of findElement Method");

		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			switch (mobileActions) {
			case CLICK:
				wait.until(ExpectedConditions.elementToBeClickable(webelement));
				break;
			case VISIBILE:
				wait.until(ExpectedConditions.visibilityOf(webelement));
				break;
			default:
				wait.until(ExpectedConditions.visibilityOf(webelement));
			}
		} catch (TimeoutException | StaleElementReferenceException ex) {
			logger.info("Webelement exception{}" + webelement, ex);
			if (mobileActions.VISIBILE == MOBILE_ACTIONS.VISIBILE) {
				return null;
			}
		}

		logger.info("Ending of findElement Method");
		return webelement;
	}
	

	public String getResendPermissionText(String emailPackage, String emailActivity)
			throws Exception {

		String currentAct = ((AndroidDriver) driver).getCurrentPackage();
		
		System.out.println(currentAct);

		Thread.sleep(10000);

		( (StartsActivity) driver).startActivity(new Activity(emailPackage, emailActivity));

        this.implicitWait();

		this.clickOnElementWithXpath("resend.permission.mail");

		Thread.sleep(5000);

		String resendpermission = this.getElementValueWithXpath("txt.resend.permission");
		
		Thread.sleep(5000);
		
		driver.activateApp(currentAct);
		
		return resendpermission;
		
	}
	public String getRemoveAccessText(String emailPackage, String emailActivity)
			throws Exception {

		String currentAct = ((AndroidDriver) driver).getCurrentPackage();
		
		System.out.println(currentAct);

		Thread.sleep(10000);

		( (StartsActivity) driver).startActivity(new Activity(emailPackage, emailActivity));

        this.implicitWait();
        
		this.clickOnElementWithXpath("remove.access.mail");

		Thread.sleep(5000);

		String removeAccess = this.getElementValueWithXpath("txt.remove.access");
		
		Thread.sleep(5000);
		
		driver.activateApp(currentAct);
		
		return removeAccess;
	}
	
	public String  getPermissionGranted(String emailPackage, String emailActivity)
			throws Exception {

		String currentAct = ((AndroidDriver) driver).getCurrentPackage();
		
		System.out.println(currentAct);

        this.implicitWait();

		( (StartsActivity) driver).startActivity(new Activity(emailPackage, emailActivity));

		Thread.sleep(10000);

		this.clickOnElementWithXpath("permission.granted.mail");

		Thread.sleep(5000);

		String permissionGranted = this.getElementValueWithXpath("txt.permission.granted");
		
		Thread.sleep(5000);
		
		driver.activateApp(currentAct);
		
		return permissionGranted;

	}
	
	public void ToggleWIFI() {

		((AndroidDriver) driver).toggleWifi();

	}
	
	protected void androidScrollUsingText(String contentDesc) {
		logger.info("Starting of androidScrollUsingText method");

		driver.findElementByAndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
			        + "new UiSelector().description(\"" + contentDesc + "\").instance(0))");
				

		logger.info("Ending of androidScrollUsingText�method");
	}
	
	public String randomEmailGenarator() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String email = ("sharath.mudimadugula"+ "+"+ randomInt +"@b2btesters.com");
		return email;

	}
}





