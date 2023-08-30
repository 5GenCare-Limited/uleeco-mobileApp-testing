package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class GroupListPage extends BaseAutomationPage {

	public GroupListPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(LogoutPage.class.getName());

	@FindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[2]")
	private WebElement btnHamburgerMenu;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Equipment']")
	private WebElement btnEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'All equipment']")
	private WebElement btnAllEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'My Equipment']")
	private WebElement txtMyEquipment;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Groups']")
	private WebElement btngroup;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Categories']")
	private WebElement btnCategories;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Add new group']")
	private WebElement btnAddNewGroup;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Grouping Equipment']")
	private WebElement txtGroupingEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Give your group a name']")
	private WebElement txtGiveyourGroupAname;

	@FindBy(xpath = "//android.widget.EditText")
	private WebElement lblNameOfEquipmentGroup;

	@FindBy(xpath = "//android.view.View[1]/android.widget.CheckBox")
	private WebElement chkAVA10M30RF;

	@FindBy(xpath = "//android.view.View[3]/android.widget.CheckBox")
	private WebElement chkAWRT10RF;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
	private WebElement iconPin;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Finish']")
	private WebElement btnFinish;

	@FindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.ImageView")
	private WebElement lstcreatedGroup;

	@FindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.ImageView")
	private WebElement btnEdit;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Delete Group']")
	private WebElement txtDeleteGroup;

	@FindBy(xpath = "//android.view.View[@content-desc = 'You are about to Delete group B2Btesters']")
	private WebElement msgDeleteGroupPopUp;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Delete']")
	private WebElement btnDelete;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement btnGroupCancel;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Please enter a valid group name']")
	private WebElement msgError;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Select the equipment you would like in this group']")
	private WebElement txtSelectTheEquipment;

	@FindBy(xpath = "//android.widget.Button[@text = 'While using the app']")
	private WebElement btnWhileUsingTheApp;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Back']")
	private WebElement btnBack;

	@FindBy(xpath = "//android.view.View[4]/android.view.View/android.widget.ImageView[2]")
	private WebElement frmCreatedGroup;

	@FindBy(xpath = "//android.widget.ImageView[1]\r\n" + "")
	private WebElement iconSalus;

	/*
	 * @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"B2Btesters 2\"]")
	 * private WebElement frmDashBoardCreatedGroup;
	 */
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='B2Btesters 2']")
	private WebElement frmDashBoardCreatedGroup;

	@FindBy(xpath = "//android.view.View[@content-desc = 'You must use unique name.']")
	private WebElement txtUniqueGroupName;

	public void clickOnHamburgerMenuBtn() throws Exception {
		logger.info("starting of ClickingOnMenuIcon");

		Thread.sleep(10000);
		this.clickOnElement("hamburgermenu.button");
		// this.btnHamburgerMenu.click();

		logger.info("ending of ClickingOnMenuIcon");
	}

	public String getUniqueGroupNameText() {
		logger.info("starting of getGroupText");
		logger.info("ending of getGroupText");

		return this.getContentDescValue("unique.name.groups");
		//return txtUniqueGroupName.getAttribute("content-desc");

	}

	public void clickOnSalusIcon() {
		logger.info("starting of clickOnSalusIcon");

		this.clickOnElementWithXpath("icon.salus.middle");
		//this.iconSalus.click();

		logger.info("ending of clickOnSalusIcon");
	}

	public boolean displayCreatedGroup() {
		logger.info("starting of displayCreatedGroup");
		for(int i=0; i<=2; i++) {
			this.verticalScroll();
		}
		logger.info("ending of displayCreatedGroup");

		return this.isDisplayed("created.group");
		//return frmCreatedGroup.isDisplayed();
	}

	public boolean displayDashBoardCreatedGroup() throws Exception {
		logger.info("starting of displayDashBoardCreatedGroup");
		
		for(int i=0; i<=2; i++) {
			this.verticalScroll();
		}
		Thread.sleep(2000);
		this.clickOnElementWithXpath("dashboard.group.element");
		logger.info("ending of displayDashBoardCreatedGroup");

		return this.isDisplayed("dashboard.created.group");
		// return frmDashBoardCreatedGroup.isDisplayed();
	}
	
	public void clickOnCloseGroup() {
		logger.info("starting of clickOnCloseGroup method");

		this.clickOnElementWithXpath("group.close.tile");
		// this.frmCreatedGroup.click();

		logger.info("ending of clickOnCloseGroup method");
	}

	public void clickOnCreatedGroup() {
		logger.info("starting of clickOnCreatedGroup");

		this.clickOnElementWithXpath("created.group");
		// this.frmCreatedGroup.click();

		logger.info("ending of clickOnCreatedGroup");
	}

	public void clickOnBackBtn() {
		logger.info("starting of clickOnBackBtn");

		this.clickOnElement("back.button");
		// this.btnBack.click();

		logger.info("ending of clickOnBackBtn");
	}

	public void clickOnEquipmentButton() {
		logger.info("starting of clickOnEquipmentButton");

		this.clickOnElement("equipment.button");
		//this.btnEquipment.click();

		logger.info("starting of clickOnEquipmentButton");
	}

	public void clickOnAllEquipmentBtn() {
		logger.info("starting of clickOnAllEquipmentBtn method");

		this.clickOnElement("all.equipment.button");
		// this.btnAllEquipment.click();

		logger.info("ending of clickOnAllEquipmentBtn method");
	}

	public String getMyEquipmentText() {
		logger.info("starting of getGroupText");
		logger.info("ending of getGroupText");

		return this.getContentDescValue("myEquiment.text");
		// return txtMyEquipment.getAttribute("content-desc");

	}

	public String getGroupText() {
		this.verticalScroll();
		this.verticalScroll();
		logger.info("starting of getGroupText");
		logger.info("ending of getGroupText");

		return this.getContentDescValue("groups.button");
		//return btngroup.getAttribute("content-desc");

	}

	public String getCategoriesText() {
		logger.info("starting of getCategoriesText");
		logger.info("ending of getCategoriesText");

		return this.getContentDescValue("categories.button");
		// return btnCategories.getAttribute("content-desc");

	}

	public String getAddNewGroupText() {
		logger.info("starting of getCategoriesText");
		logger.info("ending of getCategoriesText");

		return this.getContentDescValue("add.new.group.button");
		//return btnAddNewGroup.getAttribute("content-desc");

	}

	public void clickOnbtnAddNewGroup() {
		logger.info("starting of btnAddNewGroup");

		this.clickOnElement("add.new.group.button");
		// this.btnAddNewGroup.click();

		logger.info("ending of btnAddNewGroup");
	}

	public String getGroupingEquipmentText() {
		logger.info("starting ofgetgroupingEquipmentText");
		logger.info("ending of getgroupingEquipmentText");

		return this.getContentDescValue("gropping.equipment.text");
		// return txtGroupingEquipment.getAttribute("content-desc");

	}

	public String getGiveyourGroupAnameText() {
		logger.info("starting of getGiveyourGroupAnameText");
		logger.info("ending of getGiveyourGroupAnameText");

		return this.getContentDescValue("give.yourname.text");
		// return txtGiveyourGroupAname.getAttribute("content-desc");

	}

	public String getSelectTheGroupText() {
		logger.info("starting of getGiveyourGroupAnameText");
		logger.info("ending of getGiveyourGroupAnameText");

		return this.getContentDescValue("select.equipment.text");
		// return txtSelectTheEquipment.getAttribute("content-desc");

	}

	public void clickOnEnterNameOfEquipmentGroup(String b2btesters) {
		logger.info("starting of clickOnlblNameOfEquipmentGroup");

		this.setValueWithClearWithXpath("name.ofthe.equipment.group", b2btesters);
//		this.lblNameOfEquipmentGroup.click();
//		this.lblNameOfEquipmentGroup.clear();
//		this.lblNameOfEquipmentGroup.sendKeys(b2btesters);
		driver.hideKeyboard();

		logger.info("ending of clickOnlblNameOfEquipmentGroup");
	}

	public void clickOnAVA10M30RFcheckBox() {
		logger.info("starting of clickOnchkAVA10M30RF");

		this.clickOnElementWithXpath("ava.check.box");
		 //this.chkAVA10M30RF.click();

		logger.info("ending of clickOnchkAVA10M30RF");
	}

	public void clickOnAWRT10RFcheckBox() {
		logger.info("starting of clickOnchkAWRT10RF");

		this.verticalScroll();
		this.clickOnElementWithXpath("awrtf.check.Box");
		//this.chkAWRT10RF.click();
		for (int i = 0; i <= 3; i++) {
			this.verticalScroll();
		}

		logger.info("ending of clickOnchkAWRT10RF");

	}

	public boolean displayPinIcon() {
		logger.info("starting of displayPinIcon");

		for(int i= 0; i<=4; i++) {
			this.verticalScroll();
		}
		//this.clickOnElementWithXpath("icon.pin");
		// this.iconPin.click();

		logger.info("ending of displayPinIcon");
		return this.isDisplayed("icon.pin");
	}
	
	public boolean pinIconDisplayed() {
		logger.info("starting of pinIconDisplayed");

		for(int i= 0; i<=2; i++) {
			this.verticalScroll();
		}
		//this.clickOnElementWithXpath("icon.pin");
		// this.iconPin.click();

		logger.info("ending of pinIconDisplayed");
		return this.isDisplayed("icon.pin");
	}

	public void clickOnPinIcon() {
		logger.info("starting of clickOnbtnPin");

		this.clickOnElementWithXpath("icon.pin");
		// this.iconPin.click();

		logger.info("ending of clickOnbtnPin");
	}

	public String getFinishText() {
		logger.info("starting of geterrorMessageText");
		logger.info("ending of geterrorMessageText");

		return this.getContentDescValue("finish.button");
		//return btnFinish.getAttribute("content-desc");

	}

	public String getErrorMessageText() {

		this.implicitWait();
		logger.info("starting of geterrorMessageText");
		
		for(int i=0; i<=4; i++) {
			this.verticalScrollUp();
		}
		logger.info("ending of geterrorMessageText");

		return this.getContentDescValueWithXPath("err.enter.validgroup.name");
		// return msgError.getAttribute("content-desc");

	}

	public void clickOnbtnFinish() {
		logger.info("starting of  clickOnbtnFinish");

		this.clickOnElement("finish.button");
		// this.btnFinish.click();

		logger.info("ending of clickOnbtnFinish");
	}

	public void clickOnSelectGroupList() {
		this.implicitWait();
		logger.info("starting of clickOnSelectGroupList");

		this.elementToBeClickable("//android.view.View[2]/android.view.View/android.widget.ImageView");
		this.clickOnElement("created.group");
		// this.lstcreatedGroup.click();

		logger.info("ending of clickOnSelectGroupList");

	}

	public boolean isEditButtonDisplayed() {
		logger.info("starting of getGiveyourGroupAnameText");

		//this.clickOnElement("edit.button");
		// this.btnEdit.isDisplayed();

		logger.info("ending of getGiveyourGroupAnameText");
		return this.isDisplayed("group.edit.button");

	}
	
	public void clickOnEditbutton() {
		logger.info("starting of clickOnEditbutton method");

		//this.clickOnElement("edit.button");
		// this.btnEdit.isDisplayed();
		this.clickOnElementWithXpath("group.edit.button");

		logger.info("ending of clickOnEditbutton method");
		
	}

	public String getDeleteGroupOptionText() {
		logger.info("starting of getDeleteGroupOptionText");
		logger.info("ending of getDeleteGroupOptionText");

		return this.getContentDescValueWithXPath("delete.group.button");
		// return txtDeleteGroup.getAttribute("content-desc");
	}

	public void clickOnDeleteGroupOption() {
		logger.info("starting of clickOnbtnDeleteGroup");

		this.clickOnElementWithXpath("delete.group.button");
		// this.txtDeleteGroup.click();

		logger.info("ending of clickOnbtnDeleteGroup");
	}

	public String getDeleteGroupPopUpMessageText() {
		this.implicitWait();
		logger.info("starting of getdeleteGroupMessageText");
		logger.info("ending of getdeleteGroupMessagelText");

		return this.getContentDescValue("delete.group.pop.up");
		// return msgDeleteGroupPopUp.getAttribute("content-desc");
	}

	public String getDeleteText() {
		this.implicitWait();
		logger.info("starting of getDeleteText");
		logger.info("ending of getDeleteText");

		return this.getContentDescValue("delete.button");
		// return btnDelete.getAttribute("content-desc");
	}

	public void clickOnbtnDelete() {
		logger.info("starting of clickOnbtnDelete");

		this.clickOnElement("delete.button");
		// this.btnDelete.click();

		logger.info("ending of clickOnbtnDelete");
	}

	public String getCancelBtnInDeleteGroupText() {
		logger.info("starting of getCancelBtnInDeleteGroupText method");
		logger.info("ending of getCancelBtnInDeleteGroupText method");

		return this.getContentDescValueWithXPath("cancel.button.deletegroup");
		 //return btnGroupCancel.getAttribute("content-desc");

	}

}
