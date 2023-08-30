package com.gencare.pages;

import java.time.Duration;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;

public class DemoPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(DemoPage.class.getName());

	public DemoPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	@FindBy(xpath = "//android.view.View[@content-desc = 'Welcome to SALUS']")
	private WebElement welcomeToSalus;

	@FindBy(xpath = " //android.widget.Button[@content-desc = 'Demo']")
	private WebElement demoButton;

	// @FindBy(xpath = "//android.view.View[1]/android.widget.ImageView[3]")
	@FindBy(xpath = "//android.widget.ImageView[3]")
	private WebElement gearIconButton;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Add a photo']")
	private WebElement addAPhoto;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Choose photo from library']")
	private WebElement choosePhotoFromLibrary;;

	@FindBy(xpath = "//android.widget.LinearLayout[6]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView")
	private WebElement uploadImage;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]//android.widget.ImageView[2]")
	private WebElement exitIcon;

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement HamburgerMenuBtn;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Equipment']")
	private WebElement equipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'All equipment']")
	private WebElement AllEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'My Equipment']")
	private WebElement myEquipment;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Groups']")
	private WebElement group;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Categories']")
	private WebElement categories;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Add new group']")
	private WebElement btnAddNewGroup;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Grouping Equipment']")
	private WebElement groupingEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Give your group a name']")
	private WebElement giveyourGroupAname;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Name of equipment group']")
	private WebElement lblNameOfEquipmentGroup;

	@FindBy(xpath = "//android.view.View[1]/android.widget.CheckBox")
	private WebElement AVA10M30RFcheckBox;

	@FindBy(xpath = "//android.view.View[3]/android.widget.CheckBox")
	private WebElement AWRT10RFCheckBox;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
	private WebElement pinIcon;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Finish']")
	private WebElement finishBtn;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ImageView")
	private WebElement createdGroupList;

	@FindBy(xpath = "//android.view.View[2]/android.widget.ImageView")
	private WebElement editBtn;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Delete group']")
	private WebElement deleteGroupbtn;

	@FindBy(xpath = "//android.view.View[@content-desc = 'You are about to Delete group B2Btesters']")
	private WebElement deleteGroupPopUpMessage;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Delete']")
	private WebElement deleteButton;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement groupCancelBtn;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Please enter a valid group name']")
	private WebElement errorMessage;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Select the equipment you would like in this group']")
	private WebElement selectTheEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Fan Coil Thermostat 13']")
	private WebElement device;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Fan Coil Thermostat 13']")
	private WebElement deviceName;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement editButton;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement editDeviceName;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Save']")
	private WebElement btnSave;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Back']")
	private WebElement btnBack;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Remove  Fan Coil Thermostat 13']") // changed
	private WebElement btnRemove;

	@FindBy(xpath = "//android.widget.ImageView[6]")
	private WebElement btnSettings;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Settings']")
	private WebElement SettingsTxt;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Advanced settings']")
	private WebElement btnAdvancedSettibgs;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Next']")
	private WebElement btnNext;

	@FindBy(xpath = "//android.widget.RadioButton[@content-desc = 'TPI']")
	private WebElement selectsetiing;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Delete']")
	private WebElement btnDelete;

	@FindBy(xpath = "//android.view.View[@content-desc = 'ST880ZB -q']")
	private WebElement txtST880ZB;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[1]")
	private WebElement iconEdit;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Information']")
	private WebElement txtInformation;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Schedule']")
	private WebElement txtSchedule;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[3]")
	private WebElement iconST880ZBedit;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Remove ST880ZB -q']")
	private WebElement txtRemoveST880ZB;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Create your own schedule']")
	private WebElement txtCreateYourOwnSchedule;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Duplicate schedule']")
	private WebElement txtDuplicateSchedule;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Select the type of schedule you would like to create for this equipment']")
	private WebElement txtSlctTypofScdlUwldLkcreateFrThzEqpmt;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Working Week / MON-FRI and SAT+SUN']")
	private WebElement drpDwnWrkngWeek;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Home most of the time / MON-SUN']")
	private WebElement opnHomeMstOfTheTime;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Add interval']")
	// @FindBy(xpath = "//android.view.View[6]")
	private WebElement iconAddInterval;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Default schedule']")
	private WebElement btnDefaultSchedule;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Save']")
	private WebElement btnSaveST880;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement btnCancelST880;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Name of equipment']")
	private WebElement txtNameOfEqpmt;

	@FindBy(xpath = "//android.widget.ImageView[6]")
	private WebElement btnSettingsST880;

	@FindBy(xpath = "//android.view.View[2]//android.widget.ImageView[1]")
	private WebElement iconEditST880;

	@FindBy(xpath = "//android.widget.RadioButton[@content-desc = 'Yes, Lock it']")
	private WebElement rdoYesLock;

	@FindBy(xpath = "//android.widget.RadioButton[@content-desc = '24:00']")
	private WebElement rdo24hrFrmt;

	@FindBy(xpath = "//android.widget.RadioButton[@content-desc = 'Celsius']")
	private WebElement rdoCelsius;

	@FindBy(xpath = "//android.widget.CheckBox[@content-desc = 'Send Email']")
	private WebElement chkBoxSendEmail;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Please enter a valid group name']")
	private WebElement msgError;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Daily']")
	private WebElement txtDaily;

	@FindBy(xpath = "//android.view.View[@content-desc = 'You are about to delete']")
	private WebElement txtYouAreAbtToDlt;

	@FindBy(xpath = "//android.view.View[@content-desc = concat('Don', \"'\", 't worry, you can always add it back later.')]")
	private WebElement txtDntWryYouCanAlwaysAddItLater;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Back']")
	private WebElement btnBackGrp;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[3]")
	private WebElement btnEdit;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[3]")
	private WebElement btnEdit1;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Add interval']")
	private WebElement btnAddInterval;

	@FindBy(xpath = "//android.view.View[@text = 'Time']")
	private WebElement txtTime;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'OK']")
	private WebElement btnOk;

	@FindBy(xpath = "//android.view.View/android.widget.EditText[1]")
	// @FindBy(xpath = "//android.widget.EditText[@text = 'Heating\r\n"+ " Ã‚Â°C']")

	private WebElement txtHeating;

	@FindBy(xpath = "//android.view.View/android.widget.EditText[2]")
	private WebElement txtCooling;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Add']")
	private WebElement btnAdd;

	@FindBy(xpath = "//android.view.View[@content-desc = 'OneTouch']")
	private WebElement btnOneTouch;

	@FindBy(xpath = "//android.view.View[@content-desc = 'OneTouch']")
	private WebElement txtOneTouch;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Add a AND OneTouch']")
	private WebElement btnAddaAND;

	@FindBy(xpath = "//android.widget.EditText[@text = 'E.g. Porch lights']")
	private WebElement txtNameThisOneTouch;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Create a AND OneTouch']")
	private WebElement txtCreateaANDOneTouch;// asser

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'WHEN']")
	private WebElement btnWHEN;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Time of Day']")
	private WebElement btnTimeofDay;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Sunrise']")
	private WebElement btnSunrise;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'DO THIS']")
	private WebElement btnDOTHIS;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Send me a notification']")
	private WebElement btnSendmeanotification;

	@FindBy(xpath = "//android.widget.CheckBox")
	private WebElement chkCheckBox;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Set']")
	private WebElement btnSet;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Save']")
	private WebElement btnSave1;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Automation']")
	private WebElement txtAutomationRule;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Settings']")
	private WebElement btnSettings1;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Data Collection']")
	private WebElement btnDataCollection;

	@FindBy(xpath = "//android.widget.RadioButton[@content-desc = 'Data Collection is OFF']")
	private WebElement btnDataCollectionisOFF;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Data Collection']")
	private WebElement txtDataCollection;

	// changedevices

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[2]")
	private WebElement btnRemoteTemperature;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Remote Temperature Sensor 8']")
	private WebElement btnTemperature;

	@FindBy(xpath = "//android.widget.ImageView[3]")
	private WebElement btnSettings2;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Settings']")
	private WebElement txtSettings;

	@FindBy(xpath = "//android.widget.CheckBox[@content-desc = 'Send Email']")
	private WebElement chkSendEmail;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Information']")
	private WebElement txtInformation1;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[3]")
	private WebElement btnHotWater;

	@FindBy(xpath = "//android.view.View[@content-desc = 'iT600 VS 230V Hot Water Timer 8']")
	private WebElement btnWateTimer;

	@FindBy(xpath = "//android.widget.RadioButton[@content-desc = '12:00']")
	private WebElement btnTime;

	@FindBy(xpath = "//android.widget.ImageView[6]")
	private WebElement btnSettings3;

	@FindBy(xpath = "//android.view.View[4]/android.widget.ImageView[2]")
	private WebElement btnThermostat;

	@FindBy(xpath = "//android.view.View[@content-desc = 'SQ610RF Battery Quantum Thermostat 12']")
	private WebElement btnBatteryQuantum;

	@FindBy(xpath = "//android.widget.ImageView[7]")
	private WebElement btnSettings4;

	@FindBy(xpath = "//android.widget.RadioButton[@content-desc = 'Hide']")
	private WebElement rdoHide;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Change just this one']")
	private WebElement btnChangejustthisone;

	public void gridReorderingOS600() throws InterruptedException {

		this.implicitWait();
		Actions act = new Actions(driver);
		WebElement src = driver.findElement(By.xpath("//android.widget.ImageView[1]/android.widget.ImageView"));
		Thread.sleep(4000);
		WebElement destination = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc = 'CSB600']"));
		act.clickAndHold(src).moveToElement(destination).release().build().perform();
	}

	public void dragOS600Device() {
		Actions act = new Actions(driver);
		WebElement from = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc = 'CSB600']"));
		act.dragAndDropBy(from, 220, 110).perform();
	}

	public void clickOnDemoBtn() {
		logger.info("starting of clickOnDemoBtn");
		this.clickOnElement("demo.button");
		logger.info("ending of clickOnDemoBtn");
	}

	public void clickOnBackButton() throws InterruptedException {
		logger.info("starting of clickOnBackButton");
		Thread.sleep(3000);
		this.clickOnElement("back.button");
		logger.info("ending of clickOnBackButton");
	}

	public String getWelcomeToSalusText() {
		logger.info("starting of getWelcomeToSalusText");
		String welcomeToSalusText = this.getContentDescValue("welcome.to.salus.text");
		logger.info("ending of getWelcomeToSalusText");
		return welcomeToSalusText;

	}

	public void clickOnGearIconBtn() throws InterruptedException {

		logger.info("starting of clickOnGearIconBtn");
		Thread.sleep(2000);
		try {
			this.implicitWait();
			this.clickOnElementWithXpath("gear.icon");
		} catch (Exception e) {
		}
		logger.info("ending of clickOnGearIconBtn");
	}

	public String getAddAPhotoText() {
		logger.info("starting of getAddAPhotoText method");
		logger.info("ending of getAddAPhotoText method");

		this.implicitWait();
		return this.getContentDescValue("add.a.photo.button");
		// return addAPhoto.getAttribute("content-desc");
	}

	public void clickOnAddAPhotoButton() {

		logger.info("starting of clickOnAddAPhotoButton");
		try {
			// this.gearIconButton.click();
			this.implicitWait();
			this.elementToBeClickable("//android.widget.ImageView[@content-desc = 'Add a photo']");
			this.clickOnElement("add.a.photo.button");
		} catch (Exception e) {
		}
		logger.info("ending of clickOnAddAPhotoButton");

	}

	public String getChoosePhotoFromLibrary() {
		logger.info("starting of getChoosePhotoFromLibrary");
		logger.info("ending of getChoosePhotoFromLibrary");

		return this.getContentDescValueWithXPath("choose.photo.from.library");
		// return choosePhotoFromLibrary.getAttribute("content-desc");
	}

	public void clickAnduploadAFilefromChoosePhotoFromLibrary() {

		logger.info("starting of uploadAFilefromChoosePhotoFromLibrary");
		try {
			this.clickOnElement("choose.from.library.button");
			// this.choosePhotoFromLibrary.click()
			this.clickOnElementWithXpath("upload.image");
			// this.uploadImage.click();
		} catch (Exception e) {
		}
		logger.info("ending of uploadAFilefromChoosePhotoFromLibrary");
	}

	public void clickOnExitBtn() {
		logger.info("starting of clickOnExitBtn");

		try {
			this.clickOnElement("icon.exit");
			// this.exitIcon.click();
			this.clickOnElement("icon.exit");
			// this.exitIcon.click();
		} catch (Exception e) {
		}
		logger.info("ending of clickOnExitBtn");
	}

	public void clickOnHamburgerMenuButton() {
		logger.info("starting of clickOnHamburgerMenuButton");

		this.clickOnElementWithXpath("hamburgermenu.button");

		logger.info("Ending of clickOnHamburgerMenuButton");
	}

	public void clickOnEquipmentButton() throws InterruptedException {
		logger.info("starting of clickOnEquipmentButton");

		Thread.sleep(2000);
		this.clickOnElement("equipment.button");

		logger.info("Ending of clickOnEquipmentButton");
	}

	public void clickOnAllEquipmentBtn() {
		logger.info("starting of clickOnAllEquipmentBtn method");

		this.implicitWait();
		this.clickOnElement("all.equipment.button");

		logger.info("ending of clickOnAllEquipmentBtn method");
	}

	public String getMyEquipmentText() {
		logger.info("starting of getGroupText");
		logger.info("ending of getGroupText");

		return this.getContentDescValue("my.equipment.groups.text");
		// return myEquipment.getAttribute("content-desc")

	}

	public String getGroupText() {
		logger.info("starting of getGroupText");

		this.verticalScroll();
		this.verticalScroll();

		logger.info("ending of getGroupText");
		return this.getContentDescValue("groups.button");
		// return group.getAttribute("content-desc");

	}

	public String getCategoriesText() {
		logger.info("starting of getCategoriesText");
		logger.info("ending of getCategoriesText");

		return this.getContentDescValue("categories.button");
		// return categories.getAttribute("content-desc");

	}

	public String getAddNewGroupText() {
		logger.info("starting of getCategoriesText");
		logger.info("ending of getCategoriesText");

		return this.getContentDescValue("add.new.group.button");
		// return btnAddNewGroup.getAttribute("content-desc");

	}

	public void clickOnbtnAddNewGroup() {
		logger.info("starting of btnAddNewGroup");

		this.clickOnElement("add.new.group.button");

		logger.info("ending of btnAddNewGroup");
	}

	public String getGroupingEquipmentText() {
		logger.info("starting ofgetgroupingEquipmentText");
		logger.info("ending of getgroupingEquipmentText");

		return this.getContentDescValue("gropping.equipment.text");
		// return groupingEquipment.getAttribute("content-desc");

	}

	public String getGiveyourGroupAnameText() {
		logger.info("starting of getGiveyourGroupAnameText");
		logger.info("ending of getGiveyourGroupAnameText");

		return this.getContentDescValue("give.yourname.text");
		// return giveyourGroupAname.getAttribute("content-desc");

	}

	public String getSelectTheGroupText() {
		logger.info("starting of getGiveyourGroupAnameText");
		logger.info("ending of getGiveyourGroupAnameText");

		return this.getContentDescValue("select.equipment.text");
		// return selectTheEquipment.getAttribute("content-desc");

	}

	public void clickOnEnterNameOfEquipmentGroup(String b2btesters) {
		logger.info("starting of clickOnlblNameOfEquipmentGroup");

		this.clickOnElement("name.ofthe.equipment.group");
		this.setValueWithClearWithXpath("name.ofthe.equipment.group", b2btesters);
		driver.hideKeyboard();
		for (int i = 0; i <= 12; i++) {
			this.verticalScroll();
		}

		logger.info("ending of clickOnlblNameOfEquipmentGroup");
	}

	public void clickOnAVA10M30RFcheckBox() {
		logger.info("starting of clickOnchkAVA10M30RF");

		this.clickOnElement("");

		logger.info("ending of clickOnchkAVA10M30RF");
	}

	public void clickOnAWRT10RFcheckBox() {

		logger.info("starting of clickOnchkAWRT10RF");
		this.clickOnElement("");
		logger.info("ending of clickOnchkAWRT10RF");
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();

	}

	public void displayPinIcon() {
		this.clickOnElement("icon.pin");
	}

	public void clickOnPinIcon() {
		logger.info("starting of clickOnbtnPin");

		this.clickOnElement("icon.pin");

		logger.info("ending of clickOnbtnPin");
	}

	public String getFinishText() {
		logger.info("starting of geterrorMessageText");
		logger.info("ending of geterrorMessageText");

		return this.getContentDescValue("finish.button");
		// return finishBtn.getAttribute("content-desc");

	}

	public String getErrorMessageText() {
		logger.info("starting of geterrorMessageText");

		this.implicitWait();
		for (int i = 0; i <= 15; i++) {
			this.verticalScrollUp();
		}

		logger.info("ending of geterrorMessageText");

		return this.getContentDescValue("err.enter.validgroup.name");
		// return errorMessage.getAttribute("content-desc");

	}

	public void clickOnbtnFinish() {
		logger.info("starting of  clickOnbtnFinish");

		this.clickOnElement("finish.button");

		logger.info("ending of clickOnbtnFinish");
	}

	public void clickOnSelectGroupList() {
		logger.info("starting of clickOnSelectGroupList");

		this.implicitWait();
		this.elementToBeClickable("//android.view.View[2]/android.view.View/android.widget.ImageView");
		this.clickOnElement("");

		logger.info("ending of clickOnSelectGroupList");

	}

	public String getbtnEditText() {
		logger.info("starting of getGiveyourGroupAnameText");
		logger.info("ending of getGiveyourGroupAnameText");

		return this.getElementValueWithXpath("edit.button");

	}

	public void clickOnEditButton() {
		logger.info("starting of clickOnEditButton method");

		this.clickOnElementWithXpath("edit.button");

		logger.info("ending of clickOnEditButton method");

	}

	public String getDeleteGroupOptionText() {
		logger.info("starting of getDeleteGroupOptionText method");
		logger.info("ending of getDeleteGroupOptionText method");

		String deleteGroupbtn = this.getContentDescValueWithXPath("delete.group.button");
		return deleteGroupbtn;
	}

	public void clickOnDeleteGroupOption() {
		logger.info("starting of clickOnbtnDeleteGroup");

		this.clickOnElementWithXpath("delete.group.button");

		logger.info("ending of clickOnbtnDeleteGroup");
	}

	public String getDeleteGroupPopUpMessageText() {
		logger.info("starting of getdeleteGroupMessageText");

		this.implicitWait();

		logger.info("ending of getdeleteGroupMessagelText");

		return this.getContentDescValue("delete.group.pop.up");
		// return deleteGroupPopUpMessage.getAttribute("content-desc");
	}

	public String getDeleteText() {
		logger.info("starting of getDeleteText");
		logger.info("ending of getDeleteText");

		return this.getContentDescValue("delete.button");
		// return deleteButton.getAttribute("content-desc");
	}

	public void clickOnbtnDelete() {
		logger.info("starting of clickOnbtnDelete");

		this.clickOnElement("delete.group.button");

		logger.info("ending of clickOnbtnDelete");
	}

	public String getCancelBtnInDeleteGroupText() {
		logger.info("starting of getCancelText");
		logger.info("ending of getCancelText");

		return this.getContentDescValue("cancel.button.groups");
		// return groupCancelBtn.getAttribute("content-desc");

	}

	public void refreshPage() {
		logger.info("Starting of refreshPage method");

		Dimension size = driver.manage().window().getSize();

		int startX = (int) (size.width * 0.9);

		int endX = startX;

		int startY = (int) (size.height * 0.2);

		int endY = (int) (size.height * 0.9);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		// Creating Sequence object to add actions
		Sequence swipe = new Sequence(finger, 1);
		// Move finger into starting position
		swipe.addAction(
				finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), startX, (int) startY));
		// Finger comes down into contact with screen
		swipe.addAction(finger.createPointerDown(0));
		// Finger moves to end position
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(5000), PointerInput.Origin.viewport(), startX, (int) endY));
		// Get up Finger from Srceen
		swipe.addAction(finger.createPointerUp(0));

		// Perform the actions
		driver.perform(Arrays.asList(swipe));

		logger.info("Ending of refreshPage method");
	}

	public void clickOnDevice() {
		logger.info("starting of clickOnDevice method");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		this.clickOnElement("device");

		logger.info("ending of clickOnDevice method");

	}

	public void clickOnDeviceName() {
		logger.info("starting of clickOnDeviceName");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.clickOnElement("device.name");

		logger.info("ending of clickOnDeviceName");

	}

	public void setDeviceName(String Name) {
		logger.info("starting of setDeviceName");

		this.clickOnElementWithXpath("edit.button");
		// this.editButton.click();
		this.setValueWithClearWithXpath("edit.device.name", Name);
		// this.setValueWithoutClear("edit.device.name", Name);
		// this.editDeviceName.sendKeys(Name);
		driver.hideKeyboard();

		logger.info("ending of setDeviceName");

	}

	public void clickOnSaveButton() {
		logger.info("starting of clickOnSaveButton");

		this.clickOnElement("save.button");

		logger.info("ending of clickOnSaveButton");

	}

	public void clickOnRemoveButton() {
		logger.info("starting of clickOnRemoveButton");

		this.clickOnElement("remove.button");

		logger.info("ending of clickOnRemoveButton");

	}

	public void clickOnDeleteButton() {
		logger.info("starting of clickOnDeleteButton");

		this.clickOnElement("delete.button");

		logger.info("ending of clickOnDeleteButton");
	}

	public String geteDeleteText() {
		logger.info("starting of geteDeleteText method");
		logger.info("ending of geteDeleteText method");

		return this.getContentDescValue("delete.button");
		// return btnDelete.getAttribute("content-desc");
	}

	public void clickOnSettingsButton() {
		logger.info("starting of clickOnSettingsButton method");

		this.clickOnElement("settings.button");

		logger.info("ending of clickOnSettingsButton method");
	}

	public String getSettingsTxt() {
		logger.info("starting of getSettingsTxt method");
		logger.info("ending of getSettingsTxt method");

		return this.getContentDescValue("settings.button");
		// return SettingsTxt.getAttribute("content-desc");
	}

	public void changeSettings() throws InterruptedException {
		Thread.sleep(50000);
		this.verticalScroll();
		this.clickOnElement("advanced.setting.button");
		// this.btnAdvancedSettibgs.click();
		this.clickOnElement("next.button");
		// this.btnNext.click(;
		this.verticalScroll();
		this.verticalScroll();
		this.clickOnElement("select.setting");
		// this.selectsetiing.click();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.verticalScroll();
		this.clickOnElement("");
		// this.btnSave.click();

	}

	public void CheckSettingChanges() throws InterruptedException {

		this.clickOnBackButton();
		this.clickOnElement("settings.button");
		// this.btnSettings.click();
		this.clickOnElement("advanced.setting.button");
		// this.btnAdvancedSettibgs.click();
		this.clickOnElement("next.button");
		// this.btnNext.click();
		this.verticalScroll();
		this.verticalScroll();

	}

	public boolean iSselectedSetting() {

		return selectsetiing.isSelected();

	}

	public void clickOnST880ZBTile() {
		logger.info("starting of clickOnST880ZBTile");

		this.clickOnElement("");

		logger.info("starting of clickOnST880ZBTile");
	}

	public void clickonGroupEditBtn() {
		logger.info("starting of clickonGroupEditBtn");

		this.clickOnElementWithXpath("group.edit.button");

		logger.info("ending of clickonGroupEditBtn");

	}

	public void changeGroupName(String abcd) {

		this.setValueWithClear("lblNameOfEquipmentGroup", abcd);
//		this.lblNameOfEquipmentGroup.click();
//		this.lblNameOfEquipmentGroup.clear();
//		this.lblNameOfEquipmentGroup.sendKeys(abcd);
		driver.hideKeyboard();
		this.verticalScroll();
		this.verticalScroll();
	}

	public void clickonBackBtn() {
		logger.info("starting of  clickonBackBtn");

		this.clickOnElement("back.button");

		logger.info("ending of clickonBackBtn");

	}

	public void clickOnScheduleIcon() {
		logger.info("starting of clickOnScheduleIcon method");

		this.clickOnElementWithXpath("schedule.icon");

		logger.info("ending of clickOnScheduleIcon method");
	}

	public void clickOnHTRPDevice() throws InterruptedException {
		logger.info("starting of clickOnHTRPDevice method");

		//this.verticalScroll();
		//this.androidScrollUsingText("htrp.device.name");
		this.clickOnElementWithXpath("htrp.device");
		this.clickOnElementWithXpath("back.tile.ntsq");

		logger.info("ending of clickOnHTRPDevice method");
	}

	public String getDuplicateScheduleText() {
		logger.info("starting of getDuplicateScheduleText");
		logger.info("ending of getDuplicateScheduleText");

		return this.getContentDescValue("duplicate.schedule");
		// return txtDuplicateSchedule.getAttribute("content-desc");
	}

	public String getST880ZBText() {
		logger.info("starting of getST880ZBText");
		logger.info("ending of getST880ZBText");

		return this.getContentDescValue("");
		// return txtST880ZB.getAttribute("content-desc");
	}

	public String getWorkingWeekText() {
		logger.info("starting of getWorkingWeekText");
		logger.info("ending of getWorkingWeekText");

		return this.getContentDescValue("drop.down.working.week");
		// return drpDwnWrkngWeek.getAttribute("content-desc");
	}

	public String getDefaultScheduleText() {
		logger.info("starting of getDefaultScheduleText");
		logger.info("ending of getDefaultScheduleText");

		return this.getContentDescValue("default.schedule");
		// return btnDefaultSchedule.getAttribute("content-desc");
	}

	public void clickOnAddIntervalIcon() throws InterruptedException {
		logger.info("starting of clickOnAddIntervalIcon");

		// Thread.sleep(2000);
		this.clickOnElement("add.interval");

		logger.info("ending of clickOnAddIntervalIcon");

	}

	public void clickOndrpDwnWrkngWeek() {
		logger.info("starting of clickOndrpDwnWrkngWeek");

		this.clickOnElement("drop.down.working.week");

		logger.info("ending of clickOndrpDwnWrkngWeek");
	}

	public String getHomeMustOfTheTime() {
		logger.info("starting of getHomeMustOfTheTime");
		logger.info("ending of getHomeMustOfTheTime");

		return this.getContentDescValue("home.most.of.the.time");
		// return opnHomeMstOfTheTime.getAttribute("content-desc");
	}

	public String getDailyText() {
		logger.info("starting of getDailyText");
		logger.info("ending of getDailyText");

		return this.getContentDescValue("daily.text");
		// return txtDaily.getAttribute("content-desc");

	}

	public void clickOnHomeMstOfTheTime() {
		logger.info("starting of clickOnopnHomeMstOfTheTime");

		this.clickOnElement("home.most.of.the.time");

		logger.info("ending of clickOnopnHomeMstOfTheTime");
	}

	public String getCancelText() {
		logger.info("starting of getCancelText");
		logger.info("ending of getCancelText");

		return this.getContentDescValue("cancel.button.groups");
		// return btnCancelST880.getAttribute("content-desc");
	}

	public String getSaveText() {
		logger.info("starting of getSaveText");
		logger.info("ending of getSaveText");

		return getContentDescValue("save.button");
		// return btnSaveST880.getAttribute("content-desc");
	}

	public String getCreateYourOwnScheduleText() {
		logger.info("starting of getCreateYourOwnScheduleText");
		logger.info("ending of getCreateYourOwnScheduleText");

		return getContentDescValue("create.your.own.schedule");
		// return txtCreateYourOwnSchedule.getAttribute("content-desc");
	}

	public void clickOnOkButton() throws InterruptedException {
		logger.info("starting of clickOnOkButton");

		Thread.sleep(2000);
		this.clickOnElementWithXpath("ok.button");

		logger.info("ending of clickOnOkButton");
	}

	public void clickOnHeatingText(String Number) throws InterruptedException {
		logger.info("starting of clickOnHeatingText");

		this.setValueWithClearWithXpath("text.heating", Number);
		Thread.sleep(2000);
		// this.txtHeating.click();
//		this.txtHeating.clear();
//		this.txtHeating.sendKeys(Number);
		// driver.hideKeyboard();

		logger.info("ending of clickOnHeatingText");
	}

	public void clickOnCoolingText(String Number1) throws InterruptedException {
		logger.info("starting of clickOnCoolingText");

		setValueWithClear("text.cooling", Number1);
		Thread.sleep(10000);
//		this.txtCooling.click();
//		this.txtCooling.clear();
//		this.txtCooling.sendKeys(Number1);
		// driver.hideKeyboard();

		logger.info("ending of clickOnCoolingText");
	}

	public void clickOnAddButton() throws InterruptedException {
		logger.info("starting of clickOnCoolingText");

		Thread.sleep(10000);
		this.clickOnElement("add.button");

		logger.info("ending of clickOnCoolingText");
	}

	public void clickOnTimeButton() {
		logger.info("starting of clickOnTimeButton");

		this.clickOnElementWithXpath("onetime.button");

		logger.info("ending of clickOnTimeButton");
	}

	public void clickOnOneTouchButton() {
		logger.info("starting of clickOneOneTouchButton");

		this.clickOnElement("one.touch.button");

		logger.info("ending of clickOneOneTouchButton");
	}

	public String getOneTouchText() {
		logger.info("starting of getOneTouchText");
		logger.info("ending of getOneTouchText");

		return this.getContentDescValue("one.touch.button");
		// return txtOneTouch.getAttribute("content-desc");
	}

	public void clickOnAddaANDButton() {
		logger.info("starting of clickOnAddaANDButton");

		this.clickOnElement("add.a.and.button");

		logger.info("ending of clickOnAddaANDButton");
	}

	public void clickOnNameThisOneTouchButton(String OneTouch) {
		logger.info("starting of clickOnNameThisOneTouchButton");

		this.setValueWithClearWithXpath("name.this.one.touch", OneTouch);
//		this.txtNameThisOneTouch.click();
//		this.txtNameThisOneTouch.clear();
//		this.txtNameThisOneTouch.sendKeys(OneTouch);
		driver.hideKeyboard();

		logger.info("ending of clickOnNameThisOneTouchButton");
	}

	public String getCreateaANDOneTouchText() {
		logger.info("starting of getCreateaANDOneTouchText");
		logger.info("ending of getCreateaANDOneTouchText");

		return this.getContentDescValue("create.a.and.one.touch");
		// return txtCreateaANDOneTouch.getAttribute("content-desc");
	}

	public void clickOnWhenButton() {
		logger.info("starting of clickOnWHENButton");

		this.clickOnElementWithXpath("when.button");

		logger.info("ending of clickOnWHENButton");
	}

	public void clickOnTimeofDayButton() {
		logger.info("starting of clickOnTimeofDayButton");

		this.clickOnElement("button.time.of.day");

		logger.info("ending of clickOnTimeofDayButton");
	}

	public void clickOnSunriseButton() {
		logger.info("starting of clickOnSunriseButton");

		this.clickOnElement("button.sunrise");

		logger.info("ending of clickOnSunriseButton");
	}

	public void clickOnDOTHISButton() {
		logger.info("starting of clickOnDOTHISButton");

		this.clickOnElement("button.do.this");

		logger.info("ending of clickOnDOTHISButton");
	}

	public void clickOnSendmeanotificationButton() {
		logger.info("starting of clickOnSendmeanotificationButton");

		this.clickOnElement("send.me.a.notification");

		logger.info("ending of clickOnSendmeanotificationButton");
	}

	public void clickOnCheckBox() throws InterruptedException {
		logger.info("starting of clickOnCheckBox method");

		// this.verticalScroll();
		this.clickOnElementWithXpath("check.box");

		logger.info("ending of clickOnCheckBox method");
	}

	public void clickOnSet() {
		logger.info("starting of clickOnCheckBox method");

		// this.verticalScroll();
		this.clickOnElementWithXpath("set.button");

		logger.info("ending of clickOnCheckBox method");
	}

	public void clickOnSave1Button() {
		logger.info("starting of clickOnSave1Button");

		this.clickOnElement("btn.save.mystatus");

		logger.info("ending of clickOnSave1Button");
	}

	public boolean displayAutomationRule() {
		logger.info("starting of clickOnSave1Button");
		logger.info("ending of clickOnSave1Button");

		return this.isDisplayed("text.automation.rule");
		// System.out.println(txtAutomationRule.isDisplayed());
		// return txtAutomationRule.isDisplayed();
	}

	public void clickOnSettingButton() {
		logger.info("starting of clickOnSettings1Button");

		this.clickOnElement("settings.button");

		logger.info("ending of clickOnSettings1Button");
	}

	public void clickOnDataCollectionButton() {
		logger.info("starting of clickOnDataCollectionButton");

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			}
		this.clickOnElement("button.data.collection");

		logger.info("ending of clickOnDataCollectionButton");
	}

	public boolean isSelecedtDataCollectionButton() {
		logger.info("starting of isSelecedtDataCollectionButton");
		logger.info("ending of isSelecedtDataCollectionButton");

		return btnDataCollectionisOFF.isSelected();

	}

	public void clickOnDataCollectionisOFFButton() throws InterruptedException {
		logger.info("starting of clickOnDataCollectionisOFFButton");

		Thread.sleep(5000);
		this.clickOnElement("data.collection.is.off");

		logger.info("ending of clickOnDataCollectionisOFFButton");
	}

	public String getDataCollectionText() throws InterruptedException {
		logger.info("starting of getDataCollectionText");
		logger.info("ending of getDataCollectionText");

		return this.getContentDescValue("button.data.collection");
		// return txtDataCollection.getAttribute("content-desc");
	}

	// changedevices

	public void clickOnRemoteTemperatureButton() {
		logger.info("starting of clickOnRemoteTemperatureButton");

		this.clickOnElement("remote.temperature");

		logger.info("ending of clickOnRemoteTemperatureButton");
	}

	public void clickOnTemperatureButton() throws InterruptedException {
		logger.info("starting of clickOnTemperatureButton");

		Thread.sleep(3000);
		this.clickOnElement("temperatur.button");

		logger.info("ending of clickOnTemperatureButton");
	}

	public String getInformation1Text() throws InterruptedException {
		logger.info("starting of getInformation1Text");
		logger.info("ending of getInformation1Text");

		Thread.sleep(3000);
		return this.getContentDescValue("text.information");
		// return txtInformation1.getAttribute("content-desc");
	}

	public void clickOnSettings2Button() {
		logger.info("starting of clickOnSettings2Button");

		this.clickOnElement("settings.button");

		logger.info("ending of clickOnSettings2Button");
	}

	public String getSettingsText() throws InterruptedException {
		logger.info("starting of getSettingsText");
		logger.info("ending of getSettingsText");

		Thread.sleep(5000);
		return this.getContentDescValue("settings.button");
		// return txtSettings.getAttribute("content-desc");
	}

	public void clickOnSendEmailCheckBox() {
		logger.info("starting of clickOnSendEmailCheckBox");

		this.clickOnElement("send.email");

		logger.info("ending of clickOnSendEmailCheckBox");
	}

	public boolean isSelecedSendEmailCheckBox() {
		logger.info("starting of isSelecedSendEmailCheckBox");
		logger.info("ending of isSelecedSendEmailCheckBox");

		return chkSendEmail.isSelected();

	}

	public void clickOnHotWaterButton() {
		logger.info("starting of clickOnHotWaterButton");

		this.clickOnElement("hot.water.button");

		logger.info("ending of clickOnHotWaterButton");
	}

	public void clickOnWateTimerButton() throws InterruptedException {
		logger.info("starting of clickOnWateTimerButton");

		Thread.sleep(3000);
		this.clickOnElement("water.timer.button");

		logger.info("ending of clickOnWateTimerButton");
	}

	public void clickOnTimeButton1() throws InterruptedException {
		logger.info("starting of clickOnTimeButton1");

		Thread.sleep(2000);
		this.clickOnElement("button.time");

		logger.info("ending of clickOnTimeButton1");
	}

	public void clickOnSettings3Button() {
		logger.info("starting of clickOnSettings3Button");

		this.clickOnElement("settings.button");

		logger.info("ending of clickOnSettings3Button");
	}

	public boolean isSelecedTimeButton1() {
		logger.info("starting of isSelecedTimeButton1");
		logger.info("ending of isSelecedTimeButton1");

		return btnTime.isSelected();
	}

	public void clickOnThermostatButton() {
		logger.info("starting of clickOnThermostatButton");

		this.clickOnElement("thrmostat.button");

		logger.info("ending of clickOnThermostatButton");
	}

	public void clickOnBatteryQuantumButton() throws InterruptedException {
		logger.info("starting of clickOnBatteryQuantumButton");

		Thread.sleep(3000);
		this.clickOnElement("battery.quantum.button");

		logger.info("ending of clickOnBatteryQuantumButton");
	}

	public void clickOnSettings4Button() throws InterruptedException {
		logger.info("starting of clickOnSettings4Button");

		Thread.sleep(3000);
		this.clickOnElement("settings.button");

		logger.info("ending of clickOnSettings4Button");
	}

	public void clickOnHideRadioButton() {
		logger.info("starting of clickOnHideRadioButton");

		this.clickOnElement("radi.hide");

		logger.info("ending of clickOnHideRadioButton");
	}

	public boolean isSelecedHideRadioButton() {
		logger.info("starting of isSelecedHideRadioButton");
		logger.info("ending of isSelecedHideRadioButton");

		return rdoHide.isSelected();
	}

	public void clickOnChangejustthisoneButton() {
		logger.info("starting of clickOnChangejustthisoneButton");

		this.clickOnElement("change.just.this.one");

		logger.info("ending of clickOnChangejustthisoneButton");
	}

}
