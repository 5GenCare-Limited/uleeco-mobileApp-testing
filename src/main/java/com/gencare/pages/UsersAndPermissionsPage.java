package com.gencare.pages;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class UsersAndPermissionsPage extends BaseAutomationPage {

	public UsersAndPermissionsPage(AndroidDriver<WebElement> driver) {
		super(driver);

	}

	private static final Logger logger = Logger.getLogger(CategoriesListPage.class.getName());

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement hamBurgerMenu;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Users and Permissions\"]") // asser,click
	private WebElement btnusersAndPermissions;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Users']")
	private WebElement users;// asser

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'suraj.patil+admin@5gencare.com\r\n" + "Owner")
	private WebElement icon;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Edit']")
	private WebElement btnEdit;// asser

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Resend Invitation']")
	private WebElement btnResendInvitation;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Remove Access']")
	private WebElement btnRemoveAcess;// asser

	@FindBy(xpath = "//android.view.View[@content-desc = 'Edit User']")
	private WebElement editUser;// asser

	@FindBy(xpath = "//android.view.View[@content-desc = 'Choose access level for user']")
	private WebElement chooseAcessLevelFrUser;// asser

	@FindBy(xpath = "//android.view.View[@content-desc = 'Owner']")
	private WebElement btnOwner;// asser

	@FindBy(xpath = "//android.view.View[@content-desc = concat('Owner', \"'\", 's have full admin access to devices, rules and users.')]")
	private WebElement ownerAccess;// asser

	@FindBy(xpath = "//android.view.View[@content-desc = 'Family']")
	private WebElement btnFamily;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Family members can control devices automations but cannot add or edit new device or user.']")
	private WebElement familyMemberAcess;// asser

	@FindBy(xpath = "//android.view.View[@content-desc = 'Temporary Access']")
	private WebElement temporaryAccess;// asser

	@FindBy(xpath = "//android.widget.Switch")
	private WebElement btnTemporaryAccess;

	@FindBy(xpath = "//android.view.View[@text = '16/03/2022, From Date']")
	private WebElement lblFromDate;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'OK']")
	private WebElement btnOk;

	@FindBy(xpath = "//android.view.View[@text = '4:30 PM, Start Time']")
	private WebElement lblStartTime;

	/*
	 * @FindBy(xpath = "//android.widget.Button[@content-desc = 'OK']") private
	 * WebElement btnOk;
	 */
	@FindBy(xpath = "//android.view.View[@text = '31/03/2022, To Date']")
	private WebElement dtpToDate;

	@FindBy(xpath = "//android.view.View[@content-desc = '23, Wednesday, March 23, 2022']")
	private WebElement lstDate;

	@FindBy(xpath = "//android.view.View[@text = '11:58 AM, End Time']")
	private WebElement dtpEndTime;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Save']")
	private WebElement btnSave;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Guest']")
	private WebElement btnGuest;// asser

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Yes']")
	private WebElement btnYes;// aser

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement btnCancel;// asser

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Remove Access']")
	private WebElement removeAccess;// asser

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement txtEmailfield;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement txtPasswordfield;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Demo De Owner Show menu']")
	private WebElement threeDotMenu;

	/*
	 * @FindBy(xpath = "") private WebElement ;
	 */

	public void enterEmailField(String swethaEmail) {
		logger.info("starting of ClickingAndEnterEmailField");

		this.setValueWithClear("email.text", swethaEmail);
		// this.txtEmailfield.click();
		// this.txtEmailfield.sendKeys(swethaEmail);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterEmailField");
	}

	public void enterPasswordField(String swethaPassword) {
		logger.info("starting of ClickingAndEnterPasswordField");

		this.setValueWithClear("password.text", swethaPassword);
		this.txtPasswordfield.click();
		// this.implicitWait();
		// this.txtPasswordfield.sendKeys(swethaPassword);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterPasswordField");
	}

	public void clickOnHumBurgerMenu() {
		logger.info("starting of clickOnHumBurgerMenu");

		this.clickOnElement("hamburgermenu.button");
		// this.hamBurgerMenu.click();

		logger.info("ending of clickOnHumBurgerMenu");
	}

	public void clickOnCancelButton() {
		logger.info("starting of clickOnHumBurgerMenu");

		this.clickOnElement("btn.cancel.vwprofile");
		// this.btnCancel.click();

		logger.info("ending of clickOnHumBurgerMenu");
	}

	public void clickOnYesButton() {

		logger.info("starting of clickOnYesButton");
		this.clickOnElement("btn.yes.users.and.permissions");
		// this.threeDotMenu.click();
		logger.info("ending of clickOnYesButton");
	}

	public void clickOnBtnusersAndPermissions() {

		logger.info("starting of clickOnBtnusersAndPermissions");
		this.clickOnElement("users.and.permissions.button");
		// this.btnusersAndPermissions.click();
		logger.info("ending of clickOnBtnusersAndPermissions");
	}

	public String getUsersText() {

		logger.info("starting of getUsersText");
		logger.info("ending of getUsersText");
		return this.getContentDescValue("txt.users");
		// return users.getAttribute("content-desc");

	}

	public String getEditText() {

		logger.info("starting of getEditText");
		logger.info("ending of getEditText");

		return this.getContentDescValue("edit.button.users.and.permissions");
		// return btnEdit.getAttribute("content-desc");

	}

	public String getResendInvitationText() {

		logger.info("starting of getResendInvitationText");
		logger.info("ending of getResendInvitationText");
		return this.getContentDescValue("btn.resendinvitation.users.and.permissions");
		// return btnResendInvitation.getAttribute("content-desc");

	}

	public String getRemoveAcessText() {

		logger.info("starting of getRemoveAcessText");
		logger.info("ending of getRemoveAcessText");
		return this.getContentDescValue("btn.remove.acess.users.and.permissions");
		// return btnRemoveAcess.getAttribute("content-desc");

	}

	public void clickOnEditButton() {

		logger.info("starting of clickOnEditButton");
		this.clickOnElement("edit.button.users.and.permissions");
		// this.btnEdit.click();
		logger.info("ending of clickOnEditButton");
	}

	public String getEditUsersText() {

		logger.info("starting of getEditUsersText");
		logger.info("ending of getEditUsersText");

		String editUsersText = this.getTextValue("edituser.users.and.permissions");
		return editUsersText;
		// return editUser.getAttribute("content-desc");

	}

	public String getChooseAcessLevelFrUserText() {

		logger.info("starting of getChooseAcessLevelFrUserText");
		logger.info("ending of getChooseAcessLevelFrUserText");
		return this.getContentDescValue("choose.Acess.Level.FrUser.users.and.permissions");
		// return chooseAcessLevelFrUser.getAttribute("content-desc");

	}

	public String getOwnerText() {

		logger.info("starting of getOwnerText");
		logger.info("ending of getOwnerText");
		return this.getContentDescValue("btn.owner.users.and.permissions");
		// return btnOwner.getAttribute("content-desc");

	}

	public String getGuestText() {

		logger.info("starting of getFamilyText");
		logger.info("ending of getFamilyText");
		String familyAccessText = this.getContentDescValue("btn.guest.users.and.permissions");
		return familyAccessText;
		// return this.getContentDescValue("btn.guest.users.and.permissions");
		// return btnGuest.getAttribute("content-desc");

	}

	public String getFamilyText() {

		logger.info("starting of getFamilyText");
		logger.info("ending of getFamilyText");
		String familyAccessText = this.getContentDescValue("btn.family.users.and.permissions");
		return familyAccessText;
		// return this.getContentDescValue("btn.family.users.and.permissions");
		// return btnFamily.getAttribute("content-desc");

	}

	public void clickOnBtnOwner() {

		logger.info("starting of clickOnBtnOwner");
		this.clickOnElement("btn.owner.users.and.permissions");
		// this.btnOwner.click();
		logger.info("ending of clickOnBtnOwner");
	}

	public String getOwnerAccessText() {

		logger.info("starting of getOwnerAccessText");
		logger.info("ending of getOwnerAccessText");
		String familyAccessText = this.getContentDescValue("btn.owner.access.users.and.permissions");
		return familyAccessText;
		// return this.getContentDescValue("btn.owner.access.users.and.permissions");
		// return ownerAccess.getAttribute("content-desc");

	}

	public void clickOnBtnSave() {

		logger.info("starting of clickOnBtnSave");
		this.implicitWait();
		this.clickOnElement("btn.save.users.and.permissions");
		// this.btnSave.click();
		logger.info("ending of clickOnBtnSave");
	}

	public void clickOnBtnFamily() {

		logger.info("starting of clickOnBtnFamily");
		this.clickOnElement("btn.family.users.and.permissions");
		// this.btnFamily.click();
		logger.info("ending of clickOnBtnFamily");
	}

	public String getFamilyAccessText() {

		logger.info("starting of getTemporaryAccessText");
		logger.info("ending of getTemporaryAccessText");
		String familyAccessText = this.getContentDescValue("family.member.access.users.and.permissions");
		return familyAccessText;
		// return
		// this.getContentDescValue("family.member.access.users.and.permissions");
		// return familyMemberAcess.getAttribute("content-desc");

	}

	public String getTemporaryAccessText() {

		logger.info("starting of getTemporaryAccessText");
		logger.info("ending of getTemporaryAccessText");
		String temporaryAccessText = this.getContentDescValue("temporary.access.users.and.permissions");
		return temporaryAccessText;
		// return this.getContentDescValue("temporary.access.users.and.permissions");
		// return temporaryAccess.getAttribute("content-desc");

	}

	public void clickOnBtnTemporaryAccess() {

		logger.info("starting of clickOnBtnTemporaryAccess");
		this.clickOnElementWithXpath("btn.temporary.access.users.and.permissions");
		// this.btnTemporaryAccess.click();
		logger.info("ending of clickOnBtnTemporaryAccess");
	}

	public void selectDtpFromDate() {

		logger.info("starting of clickOnBtnFromDate");
		this.clickOnElementWithXpath("lbl.from.date.users.and.permissions");
		// this.lblFromDate.click();
		this.clickOnElementWithXpath("btn.users.and.permission");
		// this.btnOk.click();
		logger.info("ending of clickOnBtnFromDate");
	}

	public void enterLblStartTime() {

		logger.info("starting of enterLblStartTime");
		this.clickOnElementWithXpath("lbl.start.timer.users.and.permissions");
		// this.lblStartTime.click();
		this.clickOnElementWithXpath("btn.users.and.permission");
		// this.btnOk.click();
		logger.info("ending of enterLblStartTime");
	}

	public void selectDtpToDate() {

		logger.info("starting of enterLblToDate");
		this.clickOnElementWithXpath("dtp.to.date.users.and.permissions");
		// this.dtpToDate.click();
		this.clickOnElementWithXpath("last.Date.users.and.permissions");
		// this.lstDate.click();
		this.clickOnElementWithXpath("btn.users.and.permission");
		// this.btnOk.click();
		logger.info("ending of enterLblToDate");
	}

	public void enterLblEndTime() {

		logger.info("starting of enterLblEndTime");
		this.clickOnElementWithXpath("dtp.end.time.users.and.permissions");
		// this.dtpEndTime.click();
		this.clickOnElementWithXpath("btn.users.and.permission");
		logger.info("ending of enterLblEndTime");
	}

	public void clickOnBtnGuest() {

		logger.info("starting of clickOnBtnGuest");
		this.clickOnElement("btn.guest.users.and.permissions");
		// this.btnGuest.click();
		logger.info("ending of clickOnBtnGuest");
	}

	public void clickOnBtnResendInvitation() {

		logger.info("starting of clickOnBtnResendInvitation");
		this.clickOnElement("btn.resendinvitation.users.and.permissions");
		// this.btnResendInvitation.click();
		logger.info("ending of clickOnBtnResendInvitation");
	}

	public String getCancelText() {
		logger.info("starting of getTemporaryAccessText");
		logger.info("ending of getTemporaryAccessText");
		
		String cancelText = this.getContentDescValueWithXPath("btn.cancel.vwprofile");
		return cancelText;
		// return this.getContentDescValue("btn.cancel.vwprofile");
		// return btnCancel.getAttribute("content-desc");

	}

	public String getSaveText() {
		logger.info("starting of getTemporaryAccessText");
		logger.info("ending of getTemporaryAccessText");
		
		String saveText = this.getContentDescValue("btn.save.users.and.permissions");
		return saveText;
		// return this.getContentDescValue("btn.save.users.and.permissions");
		// return btnSave.getAttribute("content-desc");

	}

	public void clickOnBtnRemoveAccess() {
		logger.info("starting of clickOnBtnResendInvitation");
		
		this.clickOnElement("btn.remove.acess.users.and.permissions");
		// this.btnRemoveAcess.click();
		
		logger.info("ending of clickOnBtnResendInvitation");
	}

	public void clickOnThreeDotMenu() {
		logger.info("starting of clickOnThreeDotMenu");
		this.clickOnElement("btn.three.dot.menu");
		// this.threeDotMenu.click();
		logger.info("ending of clickOnThreeDotMenu");
	}

	public String getYesText() {

		logger.info("starting of getYesText");
		logger.info("ending of getYesText");
		String yesText = this.getContentDescValue("btn.yes.users.and.permissions");
		return yesText;
		// return this.getContentDescValue("btn.yes.users.and.permissions");

	}

	public void clickAddPermissionPlusBtn() {

		logger.info("starting of clickAddPermissionPlusBtn");
		this.clickOnElementWithXpath("icon.plus.users.permissions");
		logger.info("ending of clickAddPermissionPlusBtn");
	}

	public String getAddUserText() {

		logger.info("starting of getYesText");
		logger.info("ending of getYesText");

		return this.getContentDescValue("txt.add.user");

	}

	public void clickSendInvitationBtn() {

		logger.info("starting of clickSendInvitationBtn");
		this.clickOnElement("btn.send.invitation");
		logger.info("ending of clickSendInvitationBtn");
	}

	public String getInviteNewUserViaEmailText() {

		logger.info("starting of getInviteNewUserViaEmailText");
		logger.info("ending of getInviteNewUserViaEmailText");

		return this.getContentDescValue("txt.invite.newuser.viaemail");

	}

	public String getSendInvitationText() {

		logger.info("starting of getSendInvitationText");
		logger.info("ending of getSendInvitationText");
		return this.getContentDescValue("btn.send.invitation");

	}

	public String getGuestAccessText() {

		logger.info("starting of getGuestAccessText");
		logger.info("ending of getGuestAccessText");
		return this.getContentDescValue("txt.guest.has.limitedaccess");

	}

	public String getEnterValidEmailText() {

		logger.info("starting of getGuestAccessText");
		logger.info("ending of getGuestAccessText");
		return this.getContentDescValue("err.please.enter.validemail");

	}

	public String getEmailAlreadyTakenText() {

		logger.info("starting of getEmailAlreadyTakenText");
		logger.info("ending of getEmailAlreadyTakenText");
		return this.getContentDescValue("err.emailaddress.already.taken");

	}
	public void enterOwnerPermissionExistedEmail(String email) {
		logger.info("starting of enterPermissionEmailField");
		
	
		this.setValueWithClearWithXpath("txt.enter.email.permission", email);
	
		//this.setValueWithClearWithXpath("txt.enter.email.permission", owneremail);
		driver.hideKeyboard();
		
		logger.info("ending of enterPermissionEmailField");
	}
	public void enterOwnerPermissionEmailField() {
		logger.info("starting of enterPermissionEmailField");
		
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000); 
		this.setValueWithClearWithXpath("txt.enter.email.permission", ("sharath.mudimadugula"+ "+"+ randomInt +"@b2btesters.com"));
	
		//this.setValueWithClearWithXpath("txt.enter.email.permission", owneremail);
		driver.hideKeyboard();
		
		logger.info("ending of enterPermissionEmailField");
	}

	public void enterFamilyPermissionEmailField() {
		logger.info("starting of enterFamilyPermissionEmailField");
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000); 
		this.setValueWithClearWithXpath("txt.enter.email.permission", ("sharath.mudimadugula"+ "+"+ randomInt +"@b2btesters.com"));
	
		//this.setValueWithClearWithXpath("txt.enter.email.permission", familyemail);
		driver.hideKeyboard();
		logger.info("ending of enterFamilyPermissionEmailField");
	}

	public void enterGuestPermissionEmailField() {
		logger.info("starting of enterGuestPermissionEmailField");
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000); 
		this.setValueWithClearWithXpath("txt.enter.email.permission", ("sharath.mudimadugula"+ "+"+ randomInt +"@b2btesters.com"));
	
		//this.setValueWithClearWithXpath("txt.enter.email.permission", guestemail);
		driver.hideKeyboard();
		logger.info("ending of enterGuestPermissionEmailField");
	}

	public String getUserCurrentAccess() throws Exception {

		logger.info("starting of getUserCurrentAccess");
		logger.info("ending of getUserCurrentAccess");
		
		String element = this.getContentDescValueWithXPath("txt.user.current.access");
		System.out.println(element);
        // Join the modified lines back into a single string
        String modifiedText = String.join("\n", element);
        
        System.out.println(modifiedText);
		
		return modifiedText;

	}
	
	public void clickOnResenTPermissionSubject() {

		logger.info("starting of clickOnResenTPermissionSubject");
		this.clickOnElementWithXpath("resend.permission.mail");
		// this.threeDotMenu.click();
		logger.info("ending of clickOnResenTPermissionSubject");
	}
	public void clickOnRemovedPermissionSubject() {

		logger.info("starting of clickOnRemovedPermissionSubject");
		this.clickOnElementWithXpath("remove.access.mail");
		// this.threeDotMenu.click();
		logger.info("ending of clickOnRemovedPermissionSubject");
	}
	
	public void clickOnGrantedPermissionSubject() {

		logger.info("starting of clickOnGrantedPermissionSubject");
		this.clickOnElementWithXpath("permission.granted.mail");
		// this.threeDotMenu.click();
		logger.info("ending of clickOnGrantedPermissionSubject");
	}
} 
