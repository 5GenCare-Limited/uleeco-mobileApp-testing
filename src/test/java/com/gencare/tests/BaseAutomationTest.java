package com.gencare.tests;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.gencare.pages.BaseAutomationPage;
import com.gencare.pages.ChangePasswordPage;
import com.gencare.util.AutomationUtil;
import com.gencare.util.Constants;
import com.gencare.util.TestListener;
import com.gencare.vo.MobileConfigurationVO;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@Listeners(TestListener.class)
public class BaseAutomationTest {
	private static final Logger logger = Logger.getLogger(BaseAutomationTest.class.getName());

	protected static AndroidDriver<WebElement> driver = null;

	protected static Map<String, AndroidDriver<WebElement>> driversMap = new HashMap<String, AndroidDriver<WebElement>>();

	protected static Properties testDataProp = null;

	protected static Properties expectedAssertionsProp = null;

	protected ChangePasswordPage ChangePassword = null;
	
	BaseAutomationPage basePage = null;

	protected String currentAct = null;

	public enum MOBILE_DRIVER {

		LOGIN_SCREEN, ADD_PHOTO_DRIVER_TEST,ALERT_DRIVER_TEST,CATEGORI_LIST_DRIVER_TEST,CHANGE_PASSWORD_DRIVER_TEST,DATA_COLLECTION_DRIVER_TEST,
		DEMO_DRIVER_TEST,EXISTING_USER_DRIVER_TEST,FORGOT_PASSWORD_USER_DRIVER_TEST,GRID_REORDERING_DRIVER_TEST,GROUP_LIST_DRIVER_TEST,
		HELP_DRIVER_TEST,LANDING_DRIVER_TEST,LEGAL_DRIVER_TEST,LOCATION_DRIVER_TEST,LOGOUT_DRIVER_TEST,MULTIPLE_GATEWAY_DRIVER_TEST,MY_STATUS_DRIVER_TEST,
		NEW_USER_DASHBOARD_DRIVER_TEST,NO_INTERNET_DRIVER_TEST,SCAN_MY_HOME_DRIVER_TEST,SING_IN_DRIVER_TEST,SIGN_IN_DRIVER_TEST,SIGN_WITH_0UT_CONFIRMATION_CODE_DRIVER_TEST,
		SIGN_UP_ASSERTION_DRIVER_TEST,SIGN_UP_COUNTRY_DRIVER_TEST,SIGN_UP_EMAIL_CONFIRMATION_DRIVER_TEST,SIGNUP_NEGATIVE_PASSWORD_DRIVER_TEST,SIGNUP_NEGATIVE_DRIVER_TEST,
		SIGN_UP_DRIVER_TEST,USERS_AND_PERMISSIONS_DRIVER_TEST,VIEWPROFILE_COUNTRIES_DRIVER_TEST,VIEW_PROFILE_DRIVER_TEST

	}
	
	public enum ENUM_DRIVER {
		
		SCREEN_ID
		
		
	}

	@BeforeSuite(groups = { "salus", "purmo" })
	@Parameters({ "flavour", "lang" })
	public void initTestData(@Optional String flavour, @Optional String lang) {
		
		this.basePage = new BaseAutomationPage(driver);

		if (testDataProp == null) {
			FileReader testDataReader = null;
			FileReader assertionsReader = null;

			try {

				String testDataFile = AutomationUtil.getLanguageFilePath(flavour, Constants.TEST_DATA_PROPERTIES, lang);
				logger.debug("Test data properties file " + testDataFile);
				testDataReader = new FileReader(testDataFile);
				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				String expectedAssertionFile = AutomationUtil.getLanguageFilePath(flavour,
						Constants.EXPECTED_ASSERTIONS_PROPERTIES, lang);
				logger.debug("Expected assertions properties file " + expectedAssertionFile);
				assertionsReader = new FileReader(expectedAssertionFile);
				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);
				
				basePage.iosTestData(flavour, lang);
				basePage.androidTestData(flavour, lang);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					testDataReader.close();
					assertionsReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	protected synchronized void initMobileDriver(String platform, MobileConfigurationVO mobileConfigurationVO,MOBILE_DRIVER mobileDriver)
			throws MalformedURLException {
		logger.info("Starting of method initMobileDriver");
		
		if(platform.equalsIgnoreCase("android")) {
			
			driver = driversMap.get(mobileDriver);

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("clientApiKey", mobileConfigurationVO.getClientApiKey());
		
		cap.setCapability("deviceName", mobileConfigurationVO.getDeviceName());

		cap.setCapability("udid", mobileConfigurationVO.getUdId());

		cap.setCapability("platformName", mobileConfigurationVO.getPlatformName());

		cap.setCapability("platformVersion", mobileConfigurationVO.getPlatformVersion());

		cap.setCapability("appPackage", mobileConfigurationVO.getAppPackage());

		cap.setCapability("appActivity", mobileConfigurationVO.getAppActivity());
		
		cap.setCapability("autograntPermissions", true);
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);

		// cap.setCapability("appPackage", "com.salus.smarthome");

		// cap.setCapability("appActivity", "com.example.smart_home.MainActivity");

		//cap.setCapability("fullReset", true);
		
		//cap.setCapability("noReset", false);

		//driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver = new AndroidDriver<WebElement>(new URL("http://b2bmobilelab.com:8080/wd/hub"), cap);

		driversMap.put(mobileConfigurationVO.getUdId(), driver);
		
		driversMap.put(String.valueOf(mobileDriver), driver);
		
		}else if (platform.equalsIgnoreCase("ios")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability("platformName", mobileConfigurationVO.getPlatformName());
			
			cap.setCapability("deviceName", mobileConfigurationVO.getDeviceName());

			cap.setCapability("udid", mobileConfigurationVO.getUdId());
			
			cap.setCapability("automationName", "XCUITest");

			cap.setCapability("bundleId", "com.salus.eu.smarthome");

			//cap.setCapability("fullReset", true);
			
			cap.setCapability("noReset", false);

			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

			driversMap.put(mobileConfigurationVO.getUdId(), driver);	
			driversMap.put(String.valueOf(mobileDriver), driver);
			
		}

		logger.info("Ending of method initMobileDriver");

	}

	protected synchronized AndroidDriver<WebElement> getMobileDriver(String driverKey) throws Exception {
		logger.info("Starting of method getMobileDriver");

		//driver = (AndroidDriver<WebElement>) driversMap.get(driverKey);
			driver = driversMap.get(driverKey);
		// Use existing driver
		if (driver == null) {

			logger.error("Driver not initialized, Please call initDriver Method. Before calling getDriver ");

			throw new Exception("Drivier not initialized");
			// driver = initMobileDriver();
		}

		// Otherwise create new driver
		logger.info("Ending of method getMobileDriver");

		return driver;

	}

	protected void androidScrollUsingText(String text) {
		logger.info("Starting of androidScrollUsingText method");

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));

		logger.info("Ending of androidScrollUsingText method");

	}

	public void verticalScroll() throws Exception {
		logger.info("Starting of verticalScroll Method");

		Thread.sleep(3000);

		Dimension size = driver.manage().window().getSize();

		int startX = size.width / 2;

		int endX = startX;

		int startY = (int) (size.height * 0.7);

		int endY = (int) (size.height * 0.2);

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("Ending of verticalScroll Method");
	}

	protected synchronized void quitMobileDriver(String driverKey) {

		logger.info("Starting of method quitDriver in BaseAutomationTest ");

		AndroidDriver<WebElement> driver = null;

		driver = (AndroidDriver<WebElement>) driversMap.get(driverKey);

		try {

			if (driver != null) {

				driver.quit();

				driver = null;
	
			}

		} catch (Exception ex) {

			logger.error(ex.getMessage());

			driver = null;

		}

		logger.info("Ending of method quitDriver in BaseAutomationTest");
	}

	/*
	 * public void waitForElementVisibilty(WebElement element) { WebDriverWait wait
	 * = new WebDriverWait(this.driver, Duration.ofSeconds(120));
	 * wait.until(ExpectedConditions.visibilityOf(element));
	 * wait.until(ExpectedConditions.elementToBeClickable(element));
	 * 
	 * }
	 */
	public void resetApp() {

		driver.resetApp();

	}

	public String getCurrentPackage() {

		currentAct = ((AndroidDriver) driver).getCurrentPackage();

		System.out.println(currentAct);

		return currentAct;
	}

	public void terminateApp() throws Exception {

		Thread.sleep(10000);
		driver.terminateApp(currentAct);

	}

	public void relaunchApplicationWithoutReset() throws Exception {

		Thread.sleep(10000);
		driver.activateApp(currentAct);
		Thread.sleep(10000);

	}

	public WebDriver getChildWebDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

}