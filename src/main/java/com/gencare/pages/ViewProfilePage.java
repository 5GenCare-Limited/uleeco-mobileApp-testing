package com.gencare.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;

public class ViewProfilePage extends BaseAutomationPage {

	public ViewProfilePage(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	private static final Logger logger = Logger.getLogger(ViewProfilePage.class.getName());

	@FindBy(xpath = "//android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.ImageView[2]")
	private WebElement hamBurgerMenu;

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

	@FindBy(xpath = "//android.view.View[@content-desc = 'Edit Profile']")
	private WebElement txtEditProfile;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement txtFirstName;

	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement txtLastName;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'India']")
	private WebElement drpdwnCountry;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Country']")
	private WebElement txtDrpdwnCountry;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Mobile 1 Name']")
	private WebElement txtMobileName;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Mobile 1 Number']")
	private WebElement txtMobileNumber;

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='English']")
	private WebElement drpdwnLanguage;

	@FindBy(xpath = "//android.view.View[@content-desc = 'My Access']")
	private WebElement txtMyAcess;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Terms & Conditions']")
	private WebElement txtTermsAndConditions;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Privacy Notice']")
	private WebElement txtPrivacyNotice;

	@FindBy(xpath = "//android.widget.RadioButton[1]")
	private WebElement rdoYes;

	@FindBy(xpath = "//android.widget.RadioButton[2]")
	private WebElement rdoNo;

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[2]")
	private WebElement iconEdit;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement txtBoxNewMobileNumberName;

	@FindBy(xpath = "//android.widget.EditText[1]")
	private WebElement btnBoxNewMobileNumberName;

	@FindBy(xpath = "//android.view.View[@content-desc = 'New Mobile Number']")
	private WebElement txtNewMobileNumber;

	@FindBy(xpath = "//android.widget.EditText[2]")
	private WebElement btnNewMobileNumber;

	@FindBy(xpath = "//android.widget.EditText[3]")
	private WebElement txtBoxVerificationCode;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Request Verification Code']")
	private WebElement btnRequestVerificationCode;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Submit']")
	private WebElement btnSubmit;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement btnCancel;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Delete User Profile']")
	private WebElement txtdeleteUserProfile;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Delete your user profile?']")
	private WebElement txtdeleteYourUserProfile;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Submit']")
	private WebElement btnEditProfileSubmit;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'Cancel']")
	private WebElement btnEditProfileCancel;

	@FindBy(xpath = "//android.view.View[4]")
	private WebElement errNewMblTzFldRequired;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Invalid Mobile Number']")
	private WebElement errInvalidMblNm;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Invalid Mobile Number']")
	private WebElement errVerificationCdTzFldRequired;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Email Address']")
	private WebElement txtEmailAddress;

	@FindBy(xpath = "//android.view.View[@content-desc = 'India']")
	private WebElement drpDwnIndia;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Old Mobile Name']")
	private WebElement txtOldMobileName;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Old Mobile Number']")
	private WebElement txtOldMobileNumber;

	@FindBy(xpath = "//android.view.View[@content-desc = 'English']")
	private WebElement drpDwnEnglish;

	@FindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
	private WebElement txtChangeMobileNumber;

	@FindBy(xpath = "//android.widget.EditText[@text = 'Verification Code']")
	private WebElement txtVerificationCode;

	@FindBy(xpath = "//android.view.View[@content-desc = 'The verification code has been sent to the new mobile number.']")
	private WebElement txtTheVerificationCodeHsBnSntTheNum;

	@FindBy(xpath = "//android.widget.Button[@content-desc = 'OK']")
	private WebElement btnOk;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Invalid OTP']")
	private WebElement txtInvalidOTP;

	@FindBy(xpath = "//android.view.View[@content-desc = 'This field is required']")
	private WebElement txtThisFieldRequired;

	@FindBy(xpath = "//android.view.View[@content-desc = 'Back']")
	private WebElement btnBack;

	@FindBy(xpath = "//android.widget.ImageView")
	private WebElement errIcon;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[1]")
	private WebElement txtMudimadugula;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText[2]")
	private WebElement txtSharath;

	public void clickOnHamBurgerMenu() {
		logger.info("starting of clickOnHamBurgerMenu");
		this.clickOnElementWithXpath("hamburgermenu.button");
		// this.hamBurgerMenu.click();

		logger.info("ending of clickOnHamBurgerMenu");
	}

	public String getEquipmentText() {
		logger.info("starting of getEquipmentText");
		logger.info("ending of getEquipmentText");

		return this.getContentDescValue("equipment.button");
		// return btnEquipment.getAttribute("content-desc");

	}

	public String getUsersAndPermissionsText() {
		logger.info("starting of getUsersAndPermissionsText");
		logger.info("ending of getUsersAndPermissionsText");

		return this.getContentDescValue("users.and.permissions.button");
		// return btnUsersAndPermissions.getAttribute("content-desc");
	}

	public String getSettingsText() {
		logger.info("starting of getSettingsText");
		logger.info("ending ofgetSettingsText");

		return this.getContentDescValue("settings.button");
		// return btnSettings.getAttribute("content-desc");

	}

	public boolean displayMudimadugulaText() {
		logger.info("starting of getMudimadugulaText");
		logger.info("ending of getMudimadugulaText");

		return this.isDisplayed("mudimadugula.text");
		// return this.isDisplayed("");
	}

	public boolean displaySharathText() {
		logger.info("starting of getSharathText");
		logger.info("ending getSharathText");

		return this.isDisplayed("sharath.text");
		// return txtSharath.isDisplayed();

	}

	public String getHelpText() {
		logger.info("starting of getHelpText");
		logger.info("ending of getHelpText");

		return this.getContentDescValue("help.button");
		// return btnHelp.getAttribute("content-desc");

	}

	public String getLegalText() {
		logger.info("starting of getLegalText");

		this.verticalScroll();

		logger.info("ending of getLegalText");

		return this.getContentDescValue("legal.button");
		// return btnLegal.getAttribute("content-desc");
	}

	public String getLogoutText() {
		logger.info("starting of getLogoutText");
		logger.info("ending of getLogoutText");

		return this.getContentDescValueWithXPath("logout.button");
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

		return this.getContentDescValue("profile.button");
		// return btnProfile.getAttribute("content-desc");
	}

	public String getChangePasswordText() {
		logger.info("starting of getChangePasswordText");
		logger.info("ending of getChangePasswordText");

		return this.getContentDescValue("change.password.button");
		// return btnChangePassword.getAttribute("content-desc");

	}

	public String getSetupEquipmentText() {
		logger.info("starting of getSetupEquipmentText");
		logger.info("ending of getSetupEquipmentText");

		return this.getContentDescValue("setup.equipment.button");
		// return btnSetupEquipment.getAttribute("content-desc");
	}

	public String getFirstNameText() {
		logger.info("starting of getEditProfileText");
		logger.info("ending of getEditProfileText");

		return this.getContentDescValueWithXPath("txt.first.name.viewprofile");
		// return txtFirstName.getAttribute("content-desc");

	}

	public String getEditProfileText() {
		logger.info("starting of getEditProfileText");
		logger.info("ending of getEditProfileText");

		return this.getContentDescValueWithXPath("lbl.editprofile.viewprofile");
		// return txtEditProfile.getAttribute("content-desc");
	}

	public String getLastNameFieldText() {
		logger.info("starting of getEditProfileText");
		logger.info("ending of getEditProfileText");

		return this.getContentDescValueWithXPath("txt.last.name.viewprofile");
		// return txtLastName.getAttribute("content-desc");

	}

	public void clickAndEnterFirstNameField(String firstname) {
		logger.info("starting of clickOnFirstNameField");

		this.setValueWithClearWithXpath("lbl.first.name.viewprofile", firstname);
		// this.txtFirstName.click();
		// this.txtFirstName.clear();
		// this.txtFirstName.sendKeys(firstname);
		driver.hideKeyboard();

		logger.info("ending of clickOnFirstNameField");
	}

	public void clickAndEnterLastNameField(String lastname) {
		logger.info("starting of clickOnLastNameField");

		this.setValueWithClearWithXpath("lbl.last.name.viewprofile", lastname);
		// this.txtLastName.click();
		// this.txtLastName.clear();
		// this.txtLastName.sendKeys(lastname);
		driver.hideKeyboard();

		logger.info("ending of clickOnLastNameField");
	}

	public String getCountryText() {
		logger.info("starting of clickOnCountryDropdown");
		logger.info("ending of clickOnCountryDropdown");

		return this.getContentDescValueWithXPath("txt.drpwn.country.viewprofile");
		// return txtDrpdwnCountry.getAttribute("content-desc");
	}

	public String getEmailAddressText() {
		logger.info("starting of clickOnCountryDropdown");
		logger.info("ending of clickOnCountryDropdown");

		return this.getContentDescValueWithXPath("txt.email.address.viewprofile");
		// return txtEmailAddress.getAttribute("content-desc");
	}

	public String getMobileNameText() {
		this.verticalScroll();
		this.verticalScroll();
		logger.info("starting of getMobileNameText");
		logger.info("ending of getMobileNameText");

		return this.getContentDescValue("txt.mobile.name.viewprofile");
		// return txtMobileName.getAttribute("content-desc");

	}

	public String getMobileNumberText() {
		logger.info("starting of getMobileNumberText");
		logger.info("ending of getMobileNumberText");

		return this.getContentDescValue("txt.mobile.number.viewprofile");
		// return txtMobileNumber.getAttribute("content-desc");

	}

	public void clickOnLanguageDropdown() {
		logger.info("starting of clickOnLanguageDropdown");

		this.verticalScroll();
		this.clickOnElementWithXpath("drpwn.language.viewprofile");
		// this.drpdwnLanguage.click();
//		 WebElement element = driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"English\"]"
//				  )); element.click();

		logger.info("ending of clickOnLanguageDropdown");
	}

	public String getMyAcessText() {
		logger.info("starting of getMyAcessText");
		logger.info("ending of getMyAcessText");

		return this.getContentDescValueWithXPath("txt.my.access.viewprofile");
		// return txtMyAcess.getAttribute("content-desc");

	}

	public String getTermsAndConditionsText() {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		logger.info("starting of getTermsAndConditionsText");
		logger.info("ending of getTermsAndConditionsText");

		return this.getContentDescValueWithXPath("txt.terms.conditions.vwprofile");
		// return txtTermsAndConditions.getAttribute("content-desc");

	}

	public void yesRadioButton() {
		logger.info("starting of clickOnYesRadioButton");

		this.clickOnElement("btn.radio.yes.viewprofile");
		// this.rdoYes.click();

		logger.info("ending of clickOnYesRadioButton");
	}

	public String getPrivacyNoticeText() {
		logger.info("starting of getPrivacyNoticeText");

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		this.verticalScroll();
		logger.info("ending of getPrivacyNoticeText");

		return this.getContentDescValueWithXPath("txt.privacy.notice.vwprofile");
		// return txtPrivacyNotice.getAttribute("content-desc");
	}

	public String getSubmitbtnText() {
		logger.info("starting of getSubmitText");
		logger.info("ending of getSubmitText");

		return this.getContentDescValueWithXPath("btn.submit.vwprofile");
		// return btnSubmit.getAttribute("content-desc");

	}

	public String getCancelText() {
		logger.info("starting of getCancelText");
		logger.info("ending of getCancelText");

		return this.getContentDescValueWithXPath("btn.cancel.vwprofile");
		// return btnCancel.getAttribute("content-desc");

	}

	public void clickOnBackBtn() {
		logger.info("starting of clickOnBackBtn");

		this.clickOnElementWithXpath("back.button.viewprofile");
		// this.btnBack.click();

		logger.info("ending of clickOnBackBtn");
	}

	public String getDeleteUserProfileText() {
		logger.info("starting of getDeleteUserProfileText");
		logger.info("ending of getDeleteUserProfileText");

		return this.getContentDescValueWithXPath("txt.delete.userprofile");
		// return txtdeleteUserProfile.getAttribute("content-desc");

	}

	public String getDeleteYourUserProfileText() {
		logger.info("starting of getDeleteYourUserProfileText");
		logger.info("ending of getDeleteYourUserProfileText");

		return this.getContentDescValue("txt.delete.your.userprofile");
		// return txtdeleteYourUserProfile.getAttribute("content-desc");

	}

	public void clickOnDeleteUserProfile() {
		logger.info("starting of clickOnDeleteUserProfile");

		this.clickOnElementWithXpath("txt.delete.userprofile");
		// this.txtdeleteUserProfile.click();

		logger.info("ending of clickOnDeleteUserProfile");
	}

	public void clickOnEditIcon() {
		logger.info("starting of clickOnEditIcon");

		this.verticalScrollUp();
		this.verticalScrollUp();
		this.clickOnElementWithXpath("icon.edit.vwprofile");
		//this.iconEdit.click();

		logger.info("ending of clickOnEditIcon");
	}

	public void clickOnnewMobileNumberNameField(String mobilenumname) {
		logger.info("starting of clickOnnewMobileNumberNameField");

		this.setValueWithClearWithXpath("txt.newmobile.name.viewprofile", mobilenumname);
		// this.txtBoxNewMobileNumberName.click();
		// this.txtBoxNewMobileNumberName.clear();
		// this.txtBoxNewMobileNumberName.sendKeys(mobilenumname);
		driver.hideKeyboard();

		logger.info("ending of clickOnnewMobileNumberNameField");
	}

	public void clickOnnewMobileNumberField(String mobilenum) {

		logger.info("starting of clickOnnewMobileNumberField");

		this.setValueWithClearWithXpath("btn.newmobile.number.vwprofile", mobilenum);
		// this.btnNewMobileNumber.click();
		// this.btnNewMobileNumber.clear();
		// this.btnNewMobileNumber.sendKeys(mobilenum);
		driver.hideKeyboard();
		logger.info("ending of clickOnnewMobileNumberField");
	}

	public void clickOnverificationCodeField(String verificationcode) {
		logger.info("starting of clickOnverificationCodeField");

		this.setValueWithClear("txt.box.verfication.code.vwprofile", verificationcode);
		this.txtBoxVerificationCode.click();
		// this.txtBoxVerificationCode.clear();
		// this.txtBoxVerificationCode.sendKeys(verificationcode);
		driver.hideKeyboard();

		logger.info("ending of clickOnverificationCodeField");
	}

	public String getRequestVerificationCodeText() {
		this.verticalScroll();
		logger.info("starting of getRequestVerificationCodeText");
		logger.info("ending of getRequestVerificationCodeText");

		return this.getContentDescValueWithXPath("btn.request.verificationcode");
		// return btnRequestVerificationCode.getAttribute("content-desc");

	}

	public String getEditProfileSubmitButtonText() {
		logger.info("starting of getEditProfileSubmitButtonText");
		logger.info("ending of getEditProfileSubmitButtonText");

		return this.getContentDescValue("btn.submit.vwprofile");
		// return btnEditProfileSubmit.getAttribute("content-desc");

	}

	public String getEditProfileCancelButtonText() {
		logger.info("starting of getEditProfileCancelButtonText");
		logger.info("ending of getEditProfileCancelButtonText");

		return this.getContentDescValue("btn.cancel.vwprofile");
		// return btnEditProfileCancel.getAttribute("content-desc");

	}

	public String getLanguageOptionText() {
		logger.info("starting of getEditProfileCancelButtonText");
		logger.info("ending of getEditProfileCancelButtonText");

		return this.getContentDescValueWithXPath("txt.drpwn.language.viewprofile");
		// return drpdwnLanguage.getAttribute("content-desc");

	}

	public void clickOnSubmitButton() {
		logger.info("starting of clickOnSubmitButton");

		this.clickOnElementWithXpath("btn.submit.vwprofile");
		// this.btnSubmit.click();
		// this.btnSubmit.click();

		logger.info("ending of clickOnSubmitButton");
	}

	public String getNewMblTzFldRequiredErrMsgText() {
		logger.info("starting of getnewMblTzFldRequiredErrMsgText");
		logger.info("ending of getnewMblTzFldRequiredErrMsgText");

		return this.getContentDescValue("err.thizfld.required.vwprofile");
		// return errNewMblTzFldRequired.getAttribute("text");

	}

	public String getVerificationCdTzFldRequiredErrMsgText() {
		logger.info("starting of getVerificationCdTzFldRequiredErrMsgText");
		logger.info("ending of getVerificationCdTzFldRequiredErrMsgText");

		return this.getContentDescValue("err.verification.code.thizfld.required");
		// return errVerificationCdTzFldRequired.getAttribute("content-desc");

	}

	public String getInvalidMblNmErrMsgText() {

		return this.getContentDescValue("err.mblnumber.vwprofile");
		// return errInvalidMblNm.getAttribute("content-desc");

	}

	public void clickOnProfile() {
		logger.info("starting of clickOnProfile method");

		this.clickOnElementWithXpath("profile.button.viewprofile");
		// this.btnProfile.click();

		logger.info("ending of clickOnProfile method");

	}

	public void clickOnCountryButton() {
		logger.info("starting of clickOnCountryButton method");

		this.clickOnElementWithXpath("drpwn.country.viewprofile");
		// this.drpdwnCountry.click();

		logger.info("ending of clickOnCountryButton method");
	}

	public void clickOnIndia() {
		logger.info("starting of clickOnCountryButton method");

		this.verticalScroll();
		this.clickOnElementWithXpath("drpwn.india.viewprofile");
		// this.drpDwnIndia.click();
		logger.info("ending of clickOnCountryButton method");
	}

	public void displyYesRadioBtn() {
		logger.info("starting of clickOnCountryButton method");

		this.isDisplayed("btn.radio.yes.viewprofile");
		// this.rdoYes.isDisplayed();
		logger.info("ending of clickOnCountryButton method");
	}

	public void displyNoRadioBtn() {
		logger.info("starting of clickOnCountryButton method");

		this.isDisplayed("btn.radio.no.viewprofile");
		// this.rdoNo.isDisplayed();
		logger.info("ending of clickOnCountryButton method");
	}

	public String getOldMobileNameText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getContentDescValueWithXPath("txt.oldmbl.name.viewprofile");
		// return txtOldMobileName.getAttribute("content-desc");

	}

	public boolean isOldMobileNameTextDisplyed() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.isDisplayed("txt.oldmbl.name.viewprofile");
		// return this.getContentDescValueWithXPath("txt.oldmbl.name.viewprofile");
		// return txtOldMobileName.getAttribute("content-desc");

	}

	public String getOldMobileNumberText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getContentDescValueWithXPath("txt.oldmbl.number.viewprofile");
		// return txtOldMobileNumber.getAttribute("content-desc");
	}

	public void displyEditIcon() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		this.isDisplayed("icon.edit.vwprofile");
		// this.iconEdit.isDisplayed();
	}

	public void clickOnEnglish() {
		logger.info("starting of clickOnCountryButton method");

		this.clickOnElementWithXpath("drpwn.language.english.viewprofile");
		// this.drpDwnEnglish.click();
		logger.info("ending of clickOnCountryButton method");
	}

	public String GetChangeMobileNumberText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getContentDescValueWithXPath("txt.changemobile.number.vwprofile");
		// return txtChangeMobileNumber.getAttribute("content-desc");
	}

	public String getNewMobileNameText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getTextValueWithXpath("txt.newmobile.name.viewprofile");
		// return txtBoxNewMobileNumberName.getText();

	}

	public String getNewMobileNumberText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getContentDescValueWithXPath("txt.newmobile.number.vwprofile");
		// return txtNewMobileNumber.getAttribute("content-desc");
	}

	public String getVerificationCodeText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getTextValueWithXpath("txt.verfication.code.vwprofile");
		// return txtVerificationCode.getText();
	}

	public void clickOnOkButton() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		this.clickOnElementWithXpath("btn.ok.vwprofile");
		// this.btnOk.click();
	}

	public String getInvalidOTPText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getTextValue("txt.invalid.otp");
		// return txtInvalidOTP.getText();
	}

	public String getOkText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getTextValue("btn.ok.vwprofile");
		// return btnOk.getText();
	}

	public boolean displayOkBtn() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.isDisplayed("btn.ok.vwprofile");
		// return btnOk.isDisplayed();
	}

	public boolean displayErrIcon() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.isDisplayed("err.icon.vwprofile");
		// return errIcon.isDisplayed();
	}

	public String getTheVerificationCodeHsBnSntTheNumText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getTextValue("txt.verification.sent.new.mobilenumber");
		// return txtTheVerificationCodeHsBnSntTheNum.getText();
	}

	public String getThisFieldIsRequiredText() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		return this.getTextValue("txt.thisfield.required.viewprofile");
		// return txtThisFieldRequired.getText();
	}

	public void clickOnSubmitButton1() {
		logger.info("starting of clickOnCountryButton method");
		logger.info("ending of clickOnCountryButton method");

		this.clickOnElement("btn.submit.vwprofile");
		// this.btnSubmit.click();

	}

	public void clickonRequestedVerificationcode() {
		logger.info("starting of clickOnCountryButton method");

		this.clickOnElementWithXpath("btn.request.verificationcode");
		this.clickOnElementWithXpath("btn.request.verificationcode");

		// this.btnRequestVerificationCode.click();
		// this.btnRequestVerificationCode.click();
		logger.info("ending of clickOnCountryButton method");
	}

	public String getMyStatusText() {
		logger.info("starting of getMyStatusText");
		logger.info("ending of getMyStatusText");

		return this.getContentDescValue("mystatus.button");
	}

	public String getLocationText() {
		logger.info("starting of getLocationText");
		logger.info("ending of getLocationText");

		return this.getContentDescValue("location.button");
	}
}