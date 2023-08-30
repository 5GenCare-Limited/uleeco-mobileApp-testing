package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.android.AndroidDriver;;

public class ChangePasswordPage extends BaseAutomationPage {

	public ChangePasswordPage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(ChangePasswordPage.class.getName());

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnSignIn;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Email']")
	private WebElement txtUserEmail;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
	private WebElement txtUserPassword;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Sign in']")
	private WebElement btnLogIn;

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement btnHamburgerMenu;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Equipment']")
	private WebElement btnEquipment;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Users and Permissions']")
	private WebElement btnUsersAndPermissions;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Settings']")
	private WebElement btnSettings;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Help']")
	private WebElement btnHelp;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'Legal']")
	private WebElement btnLegal;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Logout']")
	private WebElement btnLogout;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Profile']")
	private WebElement btnProfile;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Change Password']")
	private WebElement btnChangePassword;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Setup Equipment']")
	private WebElement btnSetupEquipment;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Change Password']")
	private WebElement btnChangePswd;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement btnOldPswd;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement btnFilledOldPswd;

	@FindBy(xpath = "//android.widget.EditText[@text = 'New password']")
	private WebElement txtNewPswd;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Confirm Password']")
	private WebElement txtConfirmPswd;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement btnCancel;

	@FindBy(xpath = "//android.widget.ImageView[2]")
	private WebElement IconError;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement btnPopUpCancel;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'OK']")
	private WebElement btnOk;

	@FindBy(xpath = "//android.view.View[@content-desc = 'This field is required']")
	private WebElement txtThisFieldRequired;

	@FindBy(xpath = "//android.view.View[3]")
	private WebElement txtNewPswdMustBeAtLeastEightCharacters;

	@FindBy(xpath = "//android.view.View[4]")
	private WebElement txtCnfmPswdMustBeAtLeastEightCharacters;

	@FindBy(xpath = "//android.view.View[@content-desc = 'This password is too simple']")
	private WebElement txtThisPswdTooSimple;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Passwords do not match']")
	private WebElement txtPswdDoNotMatch;

	@FindBy(xpath = "//android.view.View[5]")
	private WebElement txtThisPasswordtooSimple;

	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement txtValidNewPassword;

	@FindBy(xpath = "//android.widget.EditText[@text = '���������, Confirm Password']")
	private WebElement txtValidConfirmPassword;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Back']")
	private WebElement bntnBack;

	@FindBy(xpath = "//android.widget.EditText[@text = '�������������, Old Password']")
	private WebElement txtValidOldPassword;

	@FindBy(xpath = "//android.widget.Button[@text = 'WHILE USING THE APP']")
	private WebElement btnWhileUsingTheApp;

	public void clickOnLocationPopup() {
		logger.info("starting of clickOnLocationPopup");

		this.clickOnElement("");

		logger.info("ending of clickOnLocationPopup");

	}

	public void clickOnSignInButton() {
		logger.info("starting of ClickingOnSignInButton");

		this.clickOnElement("");
		logger.info("ending of ClickingOnSignInButton");
	}

	public void enterEmailField(String email) {
		logger.info("starting of ClickingAndEnterEmailField");

		this.setValueWithClear("", email);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterEmailField");
	}

	public void enterPasswordField(String password) {
		logger.info("starting of ClickingAndEnterPasswordField");

		this.setValueWithClear("", password);
		driver.hideKeyboard();

		logger.info("ending of ClickingAndEnterPasswordField");
	}

	public void clickOnLogInButton() throws Exception {
		logger.info("starting of ClickingOnLogInSignInButton");

		Thread.sleep(1000);
		this.clickOnElement("");

		logger.info("ending of ClickingOnLogInSignInButton");
	}

	public void clickOnHamburgerMenu() throws Exception {

		logger.info("starting of ClickingOnMenuIcon");

		Thread.sleep(8000);
		this.clickOnElementWithXpath("hamburgermenu.button");

		logger.info("ending of ClickingOnMenuIcon");
	}

	public boolean displayHumburgerMenu() throws Exception {
		logger.info("starting of displayHumburgerMenu");
		logger.info("ending of displayHumburgerMenu");
		Thread.sleep(10000);
		boolean hamburgermenu = this.isDisplayed("hamburgermenu.button");
		return hamburgermenu;
	}

	public String getEquipmentText() throws Exception {
		logger.info("starting of getEquipmentText");
		logger.info("ending of getEquipmentText");
		
		Thread.sleep(2000);
		String equipmentText = this.getContentDescValue("equipment.button");
		return equipmentText;
		// return btnEquipment.getAttribute("content-desc");

	}

	public String getUsersAndPermissionsText() {
		logger.info("starting of getUsersAndPermissionsText");
		logger.info("ending of getUsersAndPermissionsText");
		String usersAndPermissionsText = this.getContentDescValue("users.and.permissions.button");
		return usersAndPermissionsText;
		// return btnUsersAndPermissions.getAttribute("content-desc");
	}

	public String getSettingsText() {
		logger.info("starting of getSettingsText");
		logger.info("ending ofgetSettingsText");
		
		String settingsText = this.getContentDescValue("settings.button");
		return settingsText;
		// return btnSettings.getAttribute("content-desc");

	}

	public String getHelpText() {
		logger.info("starting of getHelpText");
		logger.info("ending of getHelpText");
		
		String helpText = this.getContentDescValue("help.button");
		return helpText;
		// return btnHelp.getAttribute("content-desc");

	}

	public String getLegalText() {
		logger.info("starting of getLegalText");
		logger.info("ending of getLegalText");
		
		String legalText = this.getContentDescValue("legal.button");
		return legalText;
		// return btnLegal.getAttribute("content-desc");
	}

	public String getLogoutText() {
		logger.info("starting of getLogoutText");
		logger.info("ending of getLogoutText");
		
		String logoutText = this.getContentDescValue("logout.button");
		return logoutText;
		// return btnLogout.getAttribute("content-desc");

	}

	public void clickOnSettings() {
		logger.info("starting of clickOnSettings");

		this.clickOnElement("settings.button");
		// this.btnSettings.click();

		logger.info("ending of clickOnSettings");
	}

	public String getProfileText() {
		logger.info("starting of getProfileText");
		logger.info("ending of getProfileText");

		String profileText = this.getContentDescValue("profile.button");
		return profileText;
		// return btnProfile.getAttribute("content-desc");
	}

	public String getChangePasswordText() {
		logger.info("starting of getChangePasswordText");
		logger.info("ending of getChangePasswordText");

		String changePasswordText = this.getContentDescValue("change.password.button");
		return changePasswordText;
		// return btnChangePassword.getAttribute("content-desc");

	}

	public String getSetupEquipmentText() {
		logger.info("starting of getSetupEquipmentText");
		logger.info("ending of getSetupEquipmentText");

		String setupEquipmentText = this.getContentDescValue("setup.equipment.button");
		return setupEquipmentText;
		// return btnSetupEquipment.getAttribute("content-desc");

	}

	public String getDataCollectionText() {
		logger.info("starting of getDataCollectionText");
		logger.info("ending of getDataCollectionText");

		String dataCollectionText = this.getContentDescValue("data.collection.button");
		return dataCollectionText;
		// return btnSetupEquipment.getAttribute("content-desc");

	}

	public void clickOnChangePassword() {
		logger.info("starting of clickOnChangePassword");

		this.clickOnElement("change.password.button");
		// this.btnChangePassword.click();

		logger.info("endiing of clickOnChangePassword");
	}

	public String getChangePswdText() {
		logger.info("starting of clickOnChangePassword");
		logger.info("endiing of clickOnChangePassword");
		
		String changePswdText = this.getContentDescValue("change.password.text");
		return changePswdText;
		// return btnChangePswd.getAttribute("content-desc");
	}

	public String getOldPswdText() {
		logger.info("starting of getOldPswdText");
		logger.info("endiing of getOldPswdText");
		
		String oldPswdText = this.getElementValueWithXpath("old.password.changepassword.text");
		return oldPswdText;
		// return btnOldPswd.getAttribute("text");
	}

	public String getNewPswdText() {
		logger.info("starting of getNewPswdText");
		logger.info("endiing of getNewPswdText");
		
		String newPswdText = this.getElementValueWithXpath("new.password.changepassword.text");
		return newPswdText;
		// return txtNewPswd.getAttribute("text");
	}

	public String getConfirmPswdText() {
		logger.info("starting of getConfirmPswdText");
		logger.info("endiing of getConfirmPswdText");
		
		String confirmPswdText = this.getElementValueWithXpath("confirm.password.changepassword.text");
		return confirmPswdText;
	}

	public String getCancelBtnText() {
		logger.info("starting of getCancelBtnText");
		logger.info("endiing of getCancelBtnText");
		String cancelBtnText = this.getTextValue("cancel.changepassword.button");
		return cancelBtnText;
	}

	public void clickOnOldPswd() {
		logger.info("starting of clickOnOldPswd");

		this.clickOnElement("old.password.changepassword.text");
		driver.hideKeyboard();

		logger.info("endiing of clickOnOldPswd");
	}

	public void clickOnNewPswd() {
		logger.info("starting of clickOnNewPswd");

		this.clickOnElement("new.password.changepassword.text");
		driver.hideKeyboard();

		logger.info("endiing of clickOnNewPswd");
	}

	public void clickOnConfirmPswd() {
		logger.info("starting of clickOnConfirmPswd");

		this.clickOnElement("confirm.password.changepassword.text");
		driver.hideKeyboard();

		logger.info("endiing of clickOnConfirmPswd");

	}

	public void clickAllPasswordFields() {
		logger.info("starting of clickAllPasswordFields method");
		this.clickOnElementWithXpath("new.password.changepassword.text");
		driver.hideKeyboard();
		this.clickOnElementWithXpath("old.password.changepassword.text");
		driver.hideKeyboard();
		this.clickOnElementWithXpath("confirm.password.changepassword.text");
		driver.hideKeyboard();
		this.clickOnElementWithXpath("new.password.changepassword.text");
		driver.hideKeyboard();
		//this.clickOnElementWithXpath("old.password.changepassword.text method");
		//driver.hideKeyboard();

		logger.info("starting of clickAllPasswordFields");
	}

	public String getOldPswdErrorMsgText() {
		logger.info("starting of getOldPswdErrorMsgText");
		logger.info("endiing of getOldPswdErrorMsgText");
		
		String oldPswdFldRqrd = this.getContentDescValueWithXPath("oldpassword.thisfld.isrequired");
		return oldPswdFldRqrd;
	}

	public String getNewPswdMustBeAtLeastEightCharactersText() {
		logger.info("starting of getNewPswdMustBeAtLeastEightCharactersText");
		logger.info("endiing of getNewPswdMustBeAtLeastEightCharactersText");
		
		String newPswdMustBeAtLeastEightCharactersText = this.getContentDescValue("password.atleast.eightcrcts");
		return newPswdMustBeAtLeastEightCharactersText;
	}

	public String getCnfmPswdMustBeAtLeastEightCharactersText() {
		logger.info("starting of getCnfmPswdMustBeAtLeastEightCharactersText");
		logger.info("endiing of getCnfmPswdMustBeAtLeastEightCharactersText");
		
		String cnfmPswdMustBeAtLeastEightCharactersText = this.getTextValue("password.atleast.eightcrcts");
		return cnfmPswdMustBeAtLeastEightCharactersText;
	}

	public void clickAndEnterInValidOldPswd(String invalidoldpswd) throws Exception {
		logger.info("starting of clickAndEnterInValidOldPswd");
		
		Thread.sleep(2000);
		this.setValueWithClearWithXpath("old.password.changepassword.text", invalidoldpswd);
		driver.hideKeyboard();

		logger.info("ending of clickAndEnterInValidOldPswd");

	}

	public void clickClearNEnterInvalidNewPswd(String invalidnewpswd) {
		logger.info("starting of clickClearNEnterInvalidNewPswd");
		
		this.setValueWithClearWithXpath("new.password.changepassword.text", invalidnewpswd);
		driver.hideKeyboard();

		logger.info("ending of clickClearNEnterInvalidNewPswd");

	}

	public String getThisPswdTooSimpleText() {
		logger.info("starting of getThisPswdTooSimpleText");
		logger.info("ending of getThisPswdTooSimpleText");
		String thisPswdTooSimpleText = this.getTextValue("password.too.simple");
		return thisPswdTooSimpleText;

	}

	public void clickClearNEnterInvalidconfirmPswd(String invalidcfrmpswd) {
		logger.info("starting of clickClearNEnterInvalidconfirmPswd");
		
		this.setValueWithClearWithXpath("confirm.password.changepassword.text", invalidcfrmpswd);
		driver.hideKeyboard();

		logger.info("ending of clickClearNEnterInvalidconfirmPswd");

	}

	public String getPswdDoNtMatchText() {
		logger.info("starting of getPswdDoNtMatchText");
		logger.info("endiing of getPswdDoNtMatchText");
		
		String thisPswdTooSimpleText = this.getContentDescValue("err.password.dntmatch");
		return thisPswdTooSimpleText;
	}

	public void clickOnBackBtn() {
		logger.info("starting of clickOnBackBtn");

		this.clickOnElement("back.button");

		logger.info("endiing of clickOnBackBtn");

	}

	public void clickClearNEnterNewPswd() {
		logger.info("starting of clickClearNEnterNewPswd");
		
		this.clickAndClear("new.password.changepassword.text");

		logger.info("endiing of clickClearNEnterNewPswd");

	}

	public void enterValidNewPswd(String newpswd) {
		logger.info("starting of enterValidNewPswd");
		
		this.setValueWithClearWithXpath("new.password.changepassword.text", newpswd);
		driver.hideKeyboard();

		logger.info("endiing of enterValidNewPswd");

	}

	public void clickMenuToChangePswd() {
		logger.info("starting of clickMenuToChangePswd");

		this.clickOnElementWithXpath("hamburgermenu.button");
		driver.hideKeyboard();
		this.clickOnElement("settings.button");
		driver.hideKeyboard();
		this.clickOnElement("change.password.button");
		driver.hideKeyboard();

		logger.info("endiing of clickMenuToChangePswd");

	}

	public void clickClearNEnterconfirmPswd(String cfrmpswd) {
		logger.info("starting of clickClearNEnterconfirmPswd");

		this.setValueWithClearWithXpath("confirm.password.changepassword.text", cfrmpswd);

		driver.hideKeyboard();

		logger.info("endiing of clickClearNEnterconfirmPswd");

	}

	public void clickOnSubmitButton() {
		logger.info("starting of clickOnSubmitButton");
		
		this.clickOnElement("submit.changepassword.button");

		logger.info("endiing of clickOnSubmitButton");

	}

	public String getErrorIconText() {
		logger.info("starting of getErrorIconText method");
		logger.info("endiing of getErrorIconText method");
		
		return this.getContentDescValue("err.icon.changepassword");
	}

	public String getOkBtnText() {
		logger.info("starting of getOkBtnText");
		logger.info("endiing of getOkBtnText");
		
		String okBtnText = this.getContentDescValue("ok.changepassword.button");
		return okBtnText;
	}

	public String getPopCancelBtnText() {
		logger.info("starting of getPopCancelBtnText");
		logger.info("endiing of getPopCancelBtnText");
		
		String popupCancelBtn = this.getContentDescValue("cancel.changepassword.err");
		return popupCancelBtn;
	}

	public void clickOnOkBtn() {
		logger.info("starting of clickOnOkBtn");
		
		this.clickOnElement("ok.changepassword.button");

		logger.info("endiing of clickOnOkBtn");

	}

	public void clickAndEnterValidOldPswd(String validoldpswd) {
		logger.info("starting of clickAndEnterValidOldPswd");

		this.setValueWithClear("old.password.changepassword.text", validoldpswd);
		
		driver.hideKeyboard();

		logger.info("endiing of clickAndEnterValidOldPswd");

	}

	public void clickOnSubmitBtnWithValidFields() {
		logger.info("starting of clickOnSubmitBtnWithValidFields");
		this.clickOnElement("submit.changepassword.button");
		//this.btnSubmit.click();

		logger.info("endiing of clickOnSubmitBtnWithValidFields");

	}
}