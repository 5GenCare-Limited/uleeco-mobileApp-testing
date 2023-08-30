package com.gencare.pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


	public class MultipleGatewayPage extends BaseAutomationPage{

	public MultipleGatewayPage(AndroidDriver<WebElement> driver) {
			super(driver);
		}

	private static final Logger logger = Logger.getLogger(MultipleGatewayPage.class.getName());

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement gateWay;

	
	
	public void SwipeGateway() throws Exception {
		logger.info("starting of clickOnGateWay");

		gateWay.click();
		
		Thread.sleep(30000);
		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width * 0.8);

		int endX = (int) (size.width * 0.2);

		int startY = (int) (size.height * 0.3);

		int endY = startY;

		 for (int i = 0; i < 5; i++) {

		TouchAction t = new TouchAction(driver);

		t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

		logger.info("ending of clickOnGateWay");
	}
}
}

