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

	public class SignUpCountryAndLanguageValidationPage extends BaseAutomationPage {

		public SignUpCountryAndLanguageValidationPage(AndroidDriver<WebElement> driver) {
			super(driver);

		}

		private static final Logger logger = Logger.getLogger(SignUpCountryAndLanguageValidationPage.class.getName());
		
		@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
		private WebElement btnAllowWhileUsingTheApp;

		@FindBy(xpath = "//android.view.View[@content-desc = 'Sign up']")
		private WebElement btnSignUp;

		@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'English']")
		private WebElement btnLanguageChange;

		@FindBy(xpath = "//android.view.View[@content-desc = 'English']")
		private WebElement txtselectLanguage;

		@FindBy(xpath = "//android.widget.EditText[@text = 'First Name']")
		private WebElement txtFirstName;

		@FindBy(xpath = "//android.widget.EditText[@text = 'Last Name']")
		private WebElement txtLastName;

		@FindBy(xpath = "//android.widget.EditText[@text = 'Email Address']")
		private WebElement txtEmailAddress;
		
		@FindBy(xpath = "//android.widget.EditText[@text = 'Confirm Email Address']")
		private WebElement txtConfirmEmailAddress;

		@FindBy(xpath = "//android.widget.EditText[@text = 'Password']")
		private WebElement txtPassword;

		@FindBy(xpath = "//android.widget.EditText[@text = 'Confirm new password']")
		private WebElement txtConfirmNewPassword;

		@FindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView")
		private WebElement txtCountrySelection;

		@FindBy(xpath = "//android.view.View[@content-desc = 'India']")
		private WebElement txtIndia;

		@FindBy(xpath = "//android.widget.EditText[2]")
		private WebElement txtMobileNumber;

		@FindBy(xpath = "//android.view.View[3]/android.widget.CheckBox")
		private WebElement btnTermsAndConditions;

		@FindBy(xpath = "//android.view.View[5]/android.widget.CheckBox")
		private WebElement btnPrivacyNotice;

		@FindBy(xpath = "//android.widget.RadioButton[1]")
		private WebElement btnYes;

		@FindBy(xpath = "//android.view.View[@content-desc=\"No\"]")
		private WebElement btnNo;

		@FindBy(xpath = "//android.widget.Button[@content-desc = 'Create my profile']")
		private WebElement btnCreateMyProfile;

		@FindBy(xpath = "//android.widget.Button[@content-desc='Cancel']")
		private WebElement btnCancel;

		@FindBy(xpath = "//android.view.View[@content-desc = 'Welcome to SALUS']")
		private WebElement lblWelcomeToSalus;
		
		@FindBy(xpath = "//android.widget.EditText[@text = 'Confirmation code']")
		private WebElement lblConfirmationCodemsg;
		
		@FindBy(xpath = "//android.view.View[3]")
		private WebElement btnConfirmationEmailFld;
		
		@FindBy(xpath = "//android.widget.EditText[@text ='Confirmation code']")
		private WebElement btnConfirmationCodeFld;
		
		@FindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
		private WebElement btnConfirm;
		
		@FindBy(xpath = "//android.view.View[@content-desc='Resend Confirmation Email']")
		private WebElement txtResendConfirmationEmail;
		
		@FindBy(xpath = "//android.widget.Button[2]")
		private WebElement iconBackNavigation;
		
		@FindBy(xpath = "	\r\n"
				+ "//android.view.View[@content-desc=\"User is not confirmed.\"]")
		private WebElement txtUserIsNotConfirmed;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'English']")
		private WebElement txtLanguageEnglish;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Bulgarian']")
		private WebElement txtLanguageBulgarian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Czech']")
		private WebElement txtLanguageCzech;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Danish']")
		private WebElement txtLanguageDanish;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Dutch']")
		private WebElement txtLanguageDutch;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Estonian']")
		private WebElement txtLanguageEstonian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Finnish']")
		private WebElement txtLanguageFinnish;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'French']")
		private WebElement txtLanguageFrench;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'German']")
		private WebElement txtLanguageGerman;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Greek']")
		private WebElement txtLanguageGreek;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Latvian']")
		private WebElement txtLanguageLatvian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Norwegian']")
		private WebElement txtLanguageNorwegian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Polish']")
		private WebElement txtLanguagePolish;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Romanian']")
		private WebElement txtLanguageRomanian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Russian']")
		private WebElement txtLanguageRussian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Serbian']")
		private WebElement txtLanguageSerbian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Spanish']")
		private WebElement txtLanguageSpanish;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Swedish']")
		private WebElement txtLanguageSwedish;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Ukrainian']") 
		private WebElement txtLanguageUkrainian;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Albania']")
		private WebElement txtCountryAlbania;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Australia']")
		private WebElement txtCountryAustralia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Austria']")
		private WebElement txtCountryAustria;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Azerbaijan']")
		private WebElement txtCountryAzerbaijan;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Belarus']")
		private WebElement txtCountryBelarus;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Belgium']")
		private WebElement txtCountryBelgium;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Bosna and Herz']")  
		private WebElement txtCountryBosnaAndHerz;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Bulgaria']")
		private WebElement txtCountryBulgaria;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'China']")
		private WebElement txtCountryChina;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Croatia']")
		private WebElement txtCountryCroatia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Cyprus']")
		private WebElement txtCountryCyprus;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Czech Republic']")
		private WebElement txtCountryCzechRepublic;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Denmark']")
		private WebElement txtCountryDenmark;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Estonia']")
		private WebElement txtCountryEstonia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Faroe Island']")
		private WebElement txtCountryFaroeIsland;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Finland']")  
		private WebElement txtCountryFinland;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'France']")
		private WebElement txtCountryFrance;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Georgia']")
		private WebElement txtCountryGeorgia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Greenland']")
		private WebElement txtCountryGreenland;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Germany']")
		private WebElement txtCountryGermany;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Greece']")
		private WebElement txtCountryGreece;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Hungary']")
		private WebElement txtCountryHungary;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Iceland']")  //////////////////////////////////////
		private WebElement txtCountryIceland;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'India']")
		private WebElement txtCountryIndia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Ireland']")
		private WebElement txtCountryIreland;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Italy']")
		private WebElement txtCountryItaly;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Kazakhstan']")
		private WebElement txtCountryKazakhistan;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Kosovo']")
		private WebElement txtCountryKosovo;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Latvia']")
		private WebElement txtCountryLatvia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Lithuania']")
		private WebElement txtCountryLithuania;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Macedonia']")
		private WebElement txtCountryMacedonia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Montenegro']")
		private WebElement txtCountryMontenegro;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'New Zealand']")
		private WebElement txtCountryNewZealand;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Netherlands']")
		private WebElement txtCountryNetherlands;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Norway']")
		private WebElement txtCountryNorway;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Portugal']")
		private WebElement txtCountryPortugal;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Poland']")
		private WebElement txtCountryPoland;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Romania']")
		private WebElement txtCountryRomania;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Russia']")
		private WebElement txtCountryRussia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Serbia']")
		private WebElement txtCountrySerbia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Slovakia']")
		private WebElement txtCountrySlovakia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Slovenia']")
		private WebElement txtCountrySlovenia;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Spain']")
		private WebElement txtCountrySpain;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Sweden']")
		private WebElement txtCountrySweden;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Switzerland']")
		private WebElement txtCountrySwitzerland;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Ukraine']")
		private WebElement txtCountryUkraine;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'United Kingdom']")
		private WebElement txtCountryUnitedKingdom;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'United States']")
		private WebElement txtCountryUnitedStates;
		
		@FindBy(xpath = "//android.view.View[@content-desc = 'Uruguay']")
		private WebElement txtCountryUruguay;
		
		@FindBy(xpath = "//android.widget.ImageView[@content-desc = 'India']")
		private WebElement drpdwnCountry;
		

		
		public void clickOnLocationPopup() {
			logger.info("starting of clickOnLocationPopup");

			this.clickOnElement("btn.allow.while.using.app.signup");
			//this.btnAllowWhileUsingTheApp.click();

			logger.info("ending of clickOnLocationPopup");

		}
		
		public void clickOnAllowVideoPopup() {

			logger.info("starting of clickOnAllowVideoPopu method");
			
			this.clickOnElement("btn.allow.while.using.app.signup");
			//this.btnAllowWhileUsingTheApp.click();
			
			logger.info("starting of clickOnAllowVideoPopu method");

		}

		public void clickOnSignUpButton() throws Exception {
			logger.info("Starting of clickOnSignUpButton Method");
			
			Thread.sleep(4000);
			this.clickOnElementWithXpath("signup.button.signup");
			//this.btnSignUp.click();
			
			logger.info("Ending of clickOnSignUpButton Method");
		}

		public void clickOnLanguageDropdown() throws Exception{
			logger.info("Starting of clickOnLanguageButton Method");
		
				Thread.sleep(4000);
				this.clickOnElementWithXpath("drpwn.language.signup");
			//this.btnLanguageChange.click();
			
			logger.info("Ending of clickOnLanguageButton Method");

		}

		public void clickOnSelectLanguageOption() throws Exception {
			logger.info("Starting of clickOnSelectLanguageOption Method");
			
			Thread.sleep(3000);	
			this.clickOnElementWithXpath("txt.select.language.signup");
			//this.txtselectLanguage.click();
			
			logger.info("Ending of clickOnSelectLanguageOption Method");
		}

		public void clickAndEnterFirstName(String firstname) {
			logger.info("Starting of clickAndEnterFirstName Method");
			
			this.setValueWithoutClear("txt.first.name.signup", firstname);
			//this.txtFirstName.click();
//			this.txtFirstName.sendKeys(firstname);
			driver.hideKeyboard();
			
			logger.info("Ending of clickAndEnterFirstName Method");
		}

		public void clickAndEnterLastName(String lastname) throws Exception{
			logger.info("Starting of clickAndEnterLastName Method");
			
				Thread.sleep(2000);
				this.setValueWithoutClear("txt.last.name.signup", lastname);
			//this.txtLastName.click();
//			this.txtLastName.sendKeys(lastname);
			driver.hideKeyboard();
			
			logger.info("Ending of clickAndEnterLastName Method");
		}
		
		public void clickAndEnteEmailAdress(String signupEmailAddress) {
			logger.info("Starting of clickAndEnterConfirmEmail");
			
	    this.implicitWait();
	    this.setValueWithoutClear("txt.email.address.signup", signupEmailAddress);
//		this.txtEmailAddress.click();
//		this.txtEmailAddress.sendKeys(signupEmailAddress);
		driver.hideKeyboard();
		
		logger.info("Ending of clickAndEnterConfirmEmail");	
		}

	    public void clickOnConfirmEmailAddress(String signUpConfirmEmail) {			
			logger.info("Starting of clickOnConfirmEmailAddress Method");
			
			 this.setValueWithoutClear("txt.confirmemail.address.signup", signUpConfirmEmail);
//			this.txtConfirmEmailAddress.click();
//			this.txtConfirmEmailAddress.sendKeys(signUpConfirmEmail);
			driver.hideKeyboard();
			
			logger.info("Ending of clickOnConfirmEmailAddress Method");
		}


	       public void clickAndEnterPassword(String signUpPassword) throws Exception {			
			logger.info("Starting of clickAndEnterPassword Method");
			
			Thread.sleep(4000);
			this.implicitWait();
			 this.setValueWithoutClear("txt.password.signup", signUpPassword);
//			this.txtPassword.click();
//			this.txtPassword.sendKeys(signUpPassword);
			driver.hideKeyboard();
			
			logger.info("Ending of clickAndEnterPasswordMethod");
		}

		public void clickAndEnterConfirmNewPassword(String confirmNewPassword) {
			
			logger.info("Starting of clickAndEnterConfirmNewPassword Method");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			 this.setValueWithoutClear("txt.confirm.password.signup", confirmNewPassword);
//			this.txtConfirmNewPassword.click();
//			this.txtConfirmNewPassword.sendKeys(confirmNewPassword);
			driver.hideKeyboard();
			logger.info("Ending of clickAndEnterConfirmNewPasswor Method");
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

	     public void clickOnCountryDropdown() throws Exception {			
			logger.info("Starting of clickOnCountryButton Method");
			
			this.clickOnElementWithXpath("drpwn.country.signup");
			//this.txtCountrySelection.click();
			
			logger.info("Ending of clickOnCountryButton Method");
		 }
	     
	     public void clickOnCountryDropDown() throws Exception {			
				logger.info("Starting of clickOnCountryDropDown Method");
				
				this.clickOnElementWithXpath("drpdwn.country.signup");
				//this.txtCountrySelection.click();
				
				logger.info("Ending of clickOnCountryDropDown Method");
			 }
	     public void clickOnIndiaCountryButton() {
	    	 logger.info("Starting of clickOnIndiaCountryButton Method");
	    	 
	    	 this.clickOnElementWithXpath("drpwn.country.viewprofile");
	    	 //this.drpdwnCountry.click();
	 		
	 		logger.info("Ending of clickOnIndiaCountryButton Method");
	 	}


		public void verticalScroll111() throws Exception {
			logger.info("Starting of verticalScroll Method");

			Thread.sleep(3000);
			Dimension size = driver.manage().window().getSize();

			int endY = size.width / 2;

			int startY = endY;

			int endX = (int) (size.height * 0.87);

			int startX = (int) (size.height * 0.2);

			TouchAction t = new TouchAction(driver);

			t.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
					.moveTo(PointOption.point(endX, endY)).release().perform();

			logger.info("Ending of verticalScroll Method");
		}

		public void selectCountry() throws Exception {
			logger.info("Starting of selectCountry Method");
			
			Thread.sleep(3000);
			this.implicitWait();
			//this.verticalScroll();
			this.clickOnElementWithXpath("drpwn.india.viewprofile");
			//this.txtIndia.click();
			driver.hideKeyboard();
			
			logger.info("Ending of selectCountry Method");
		}
		
		public String getSelectedCountry() throws Exception {
			logger.info("Starting of getSelectedCountry Method");		
			logger.info("Ending of getSelectedCountry Method");
			
			return this.getContentDescValueWithXPath("text.selected.country");
		}

	   public void clickAndEnterMobileNumber(String signUpMobileNumber) throws InterruptedException {
			
			logger.info("Starting of clickAndEnterMobileNumber Method");
			
			this.implicitWait();
			 this.setValueWithoutClear("btn.newmobile.number.vwprofile", signUpMobileNumber);
//			txtMobileNumber.click();
//			Thread.sleep(2000);
//			txtMobileNumber.sendKeys(signUpMobileNumber);
			driver.hideKeyboard();
			logger.info("Ending of clickAndEnterMobileNumber Method");
		}

	    public void clickOnTermsAndConditionsCheckBox() {			
			logger.info("Starting of TermsAndConditionsCheckBox Method");
			
			this.clickOnElement("chk.terms.signup");
			//btnTermsAndConditions.click();
			
			logger.info("Ending of TermsAndConditionsCheckBox Method");
		}

		public void clickOnPrivacyNoticeCheckBox() {			
			logger.info("Starting of PrivacyNoticeCheckBox Method");
			
			this.clickOnElement("chk.privacy.signup");
			//btnPrivacyNotice.click();
			
			logger.info("Ending of PrivacyNoticeCheckBox Method");
		}
		
	    public void clickOnYesCheckBox() {			
			logger.info("Starting of yesCheckBox Method");
			
			this.clickOnElement("btn.radio.yes.viewprofile");
			//btnYes.click();
			
			logger.info("Ending of yesCheckBox Method");
		}

		public void clickOnCreateMyProfile() {			
			logger.info("Starting of clickOnCreateMyProfile");
			
			this.clickOnElement("btn.create.myprofile");
			//btnCreateMyProfile.click();
			
			logger.info("Ending of clickOnCreateMyProfile");
		}

		
		public String getWelcomeToSalusText() throws InterruptedException {
			logger.info("Starting of getWelcomeToSalusText");
			logger.info("Ending of getWelcomeToSalusText");
			
			Thread.sleep(5000);			
			return this.getContentDescValue("lbl.welcome.to.salus.signup");
			//return lblWelcomeToSalus.getAttribute("content-desc");
		}
		
		public String getConfirmationCodeLbl() {
			logger.info("Starting of getConfirmationCodeLbl");
			logger.info("Ending of getConfirmationCodeLbl");
			
			return this.getContentDescValue("lbl.confirmation.codemsg.signup");
			//return lblConfirmationCodemsg.getAttribute("content-desc");
		}
		
		public 	boolean displyEmailFldBtn() {
			logger.info("Starting of displyEmailFldBtn");
			
			//this.btnConfirmationEmailFld.isDisplayed();
			
			logger.info("Ending of displyEmailFldBtn");
			
			return this.isDisplayed("btn.confirmation.email.field.signup");
		}
		
		public boolean displyConfirmationCodeFld() {
			logger.info("Starting of displyConfirmationCodeFld");
			
			//this.btnConfirmationCodeFld.isDisplayed();
			
			logger.info("Ending of displyConfirmationCodeFld");
			return this.isDisplayed("btn.confirmation.code.field.signup");
		}
		public String getConfirmBtnText(){
			logger.info("Starting of getConfirmBtnText");
			logger.info("Ending of getConfirmBtnText");
			
			return this.getContentDescValue("btn.confirm.signup");
			//return btnConfirm.getAttribute("content-desc");
		}
		
		public String getResendCodeToEmailText() {
			logger.info("Starting of getResendCodeToEmailText");
			logger.info("Ending of getResendCodeToEmailText");
			
			return this.getContentDescValue("txt.resend.confirmationcode.signup");
			//return txtResendConfirmationEmail.getAttribute("content-desc");
		}
		public boolean displyBackNavigatinIcon() {
			logger.info("Starting of displyBackNavigatinIcon");
			
			//this.iconBackNavigation.isDisplayed();
			
			logger.info("Ending of displyBackNavigatinIcon");
			
			return this.isDisplayed("icon.back.navigation.signup");
		}
		public void clickOnConfirmButton() {
			logger.info("Starting of clickOnConfirmButton");
			
			this.clickOnElement("btn.confirm.signup");
			//this.btnConfirm.click();
			
			logger.info("Ending of clickOnConfirmButton");
		}
		public boolean displyLanguageEnglishText() {
			logger.info("Starting of displyLanguageEnglishText");		
			logger.info("Ending of displyLanguageEnglishText");
			
			return this.isDisplayed("txt.english");
		}
		public boolean displyLanguageBulgarianText() {
			logger.info("Starting of displyLanguageBulgarianText");		
			
			//txtLanguageBulgarian.isDisplayed();
			
			logger.info("Ending of displyLanguageBulgarianText");
			
			return this.isDisplayed("txt.bulgarian");
		}
		public boolean displyLanguageCzechText() {
			logger.info("Starting of displyLanguageCzechText");
					
			//txtLanguageCzech.isDisplayed();
			
			logger.info("Ending of displyLanguageCzechText");
			return this.isDisplayed("txt.czech");
		}
		public boolean displyLanguageDanishText() {
			logger.info("Starting of displyLanguageDanishText");
					
			//txtLanguageDanish.isDisplayed();
			
			logger.info("Ending of displyLanguageDanishText");
			return this.isDisplayed("txt.danish");
		}
		public boolean displyLanguageDutchText() {
			logger.info("Starting of displyLanguageDutchText");
			
			//txtLanguageDutch.isDisplayed();
			
			logger.info("Ending of displyLanguageDutchText");
			return this.isDisplayed("txt.dutch");
		}
		public boolean displyLanguageEstonianText() {
			logger.info("Starting of displyLanguageEstonianText");
			
			//txtLanguageEstonian.isDisplayed();
			
			logger.info("Ending of displyLanguageEstonianText");
			return this.isDisplayed("txt.estonian");
		}
		public boolean displyLanguageFinnishText() {
			logger.info("Starting of displyLanguageFinnishText");
			
			//txtLanguageFinnish.isDisplayed();
			
			logger.info("Ending of displyLanguageFinnishText");
			return this.isDisplayed("txt.finnish");
		}
		public boolean displyLanguageFrenchText() {
			logger.info("Starting of displyLanguageFrenchText");
			
			txtLanguageFrench.isDisplayed();
			
			logger.info("Ending of displyLanguageFrenchText");
			return this.isDisplayed("txt.french");
		}
		public boolean displyLanguageGermanText() {
			logger.info("Starting of displyLanguageGermanText");
					
			//txtLanguageGerman.isDisplayed();
			
			logger.info("Ending of displyLanguageGermanText");
			return this.isDisplayed("txt.german");
		}
		public boolean displyLanguageGreekText() {
			logger.info("Starting of displyLanguageGreekText");
			
			txtLanguageGreek.isDisplayed();
			
			logger.info("Ending of displyLanguageGreekText");
			return this.isDisplayed("txt.greek");
		}
		public boolean displyLanguageLatvianText() {
			logger.info("Starting of displyLanguageLatvianText");
			
			//txtLanguageLatvian.isDisplayed();
			
			logger.info("Ending of displyLanguageLatvianText");
			return this.isDisplayed("txt.latvian");
		}
		public boolean displyLanguageNorwegianText() {
			logger.info("Starting of displyLanguageNorwegianText");
			
			//txtLanguageNorwegian.isDisplayed();
			
			logger.info("Ending of displyLanguageNorwegianText");
			return this.isDisplayed("txt.norwegian");
		}
		public boolean displyLanguagePolishText() {
			logger.info("Starting of displyLanguagePolishText");
			
			//txtLanguagePolish.isDisplayed();
			
			logger.info("Ending of displyLanguagePolishText");
			return this.isDisplayed("txt.polish");
		}
		public boolean displyLanguageRomanianText() {
			logger.info("Starting of displyLanguageRomanianText");
			
			//txtLanguageRomanian.isDisplayed();
			
			logger.info("Ending of displyLanguageRomanianText");
			return this.isDisplayed("txt.romanian");
		}
		public boolean displyLanguageRussianText() {
			logger.info("Starting of displyLanguageRussianText");
			
			//txtLanguageRussian.isDisplayed();
			
			logger.info("Ending of displyLanguageRussianText");
			return this.isDisplayed("txt.russian");
		}
		public boolean displyLanguageSerbianText() {
			logger.info("Starting of displyLanguageSerbianText");
			
			//txtLanguageSerbian.isDisplayed();
			
			logger.info("Ending of displyLanguageSerbianText");
			return this.isDisplayed("txt.serbian");
		}
		public boolean displyLanguageSpanishText() {
			logger.info("Starting of displyLanguageSpanishText");
			
			//txtLanguageSpanish.isDisplayed();
			
			logger.info("Ending of displyLanguageSpanishText");
			return this.isDisplayed("txt.spanish");
		}
		public boolean displyLanguageSwedishText() {
			logger.info("Starting of displyLanguageSwedishText");
			
			//txtLanguageSwedish.isDisplayed();
			
			logger.info("Ending of displyLanguageSwedishText");
			return this.isDisplayed("txt.swedish");
		}
		public boolean displyLanguageUkrainianText() {
			logger.info("Starting of displyLanguageUkrainianText");
			
			//txtLanguageUkrainian.isDisplayed();
			
			logger.info("Ending of displyLanguageUkrainianText");
			return this.isDisplayed("txt.ukrainian");
		}
		public boolean displyCountryAlbaniaText() {
			logger.info("Starting of displyCountryAlbaniaText");
			
			//txtCountryAlbania.isDisplayed();
			
			logger.info("Ending of displyCountryAlbaniaText");
			return this.isDisplayed("txt.albania");
		}
		public boolean displyCountryAustraliaText() {
			logger.info("Starting of displyCountryAustraliaText");
			
			//txtCountryAustralia.isDisplayed();
			
			logger.info("Ending of displyCountryAustraliaText");
			return this.isDisplayed("txt.australia");
		}
		public boolean displyCountryAustriaText() {
			logger.info("Starting of displyCountryAustriaText");
			
			//txtCountryAustria.isDisplayed();
			
			logger.info("Ending of displyCountryAustriaText");
			return this.isDisplayed("txt.austria");
		}
		public boolean displyCountryAzerbaijanText() {
			logger.info("Starting of displyCountryAzerbaijanText");
			
			//txtCountryAzerbaijan.isDisplayed();
			
			logger.info("Ending of displyCountryAzerbaijanText");
			return this.isDisplayed("txt.azarbaijan");
		}
		public boolean displyCountryBelarusText() {
			logger.info("Starting of displyCountryBelarusText");
			
			//txtCountryBelarus.isDisplayed();
			
			logger.info("Ending of displyCountryBelarusText");
			return this.isDisplayed("txt.belarus");
		}
		public boolean displyCountryBelgiumText() {
			logger.info("Starting of displyCountryBelgiumText");
			
			//txtCountryBelgium.isDisplayed();
			
			logger.info("Ending of displyCountryBelgiumText");
			return this.isDisplayed("txt.belgium");
		}
		public boolean displyCountryBosnaAndHerzText() {
			logger.info("Starting of displyCountryBosnaAndHerzText");
			
			//txtCountryBosnaAndHerz.isDisplayed();
			
			logger.info("Ending of displyCountryBosnaAndHerzText");
			return this.isDisplayed("txt.bosna.and.herz");
		}
		public boolean displyCountryBulgariaText() {
			logger.info("Starting of displyCountryBulgariaText");
			
			//txtCountryBulgaria.isDisplayed();
			
			logger.info("Ending of displyCountryBulgariaText");
			return this.isDisplayed("txt.bulgaria");
		}
		public boolean displyCountryChinaText() {
			logger.info("Starting of displyCountryChinaText");
			
			//txtCountryChina.isDisplayed();
			
			logger.info("Ending of displyCountryChinaText");
			return this.isDisplayed("txt.china");
		}
		public boolean displyCountryCroatiaText() {
			logger.info("Starting of displyCountryCroatiaText");
			
			//txtCountryCroatia.isDisplayed();
			
			logger.info("Ending of displyCountryCroatiaText");
			return this.isDisplayed("txt.croatia");
		}
		public boolean displyCountryCyprusText() {
			logger.info("Starting of displyCountryCyprusText");
			
			txtCountryCyprus.isDisplayed();
			
			logger.info("Ending of displyCountryCyprusText");
			return this.isDisplayed("txt.cyprus");
		}
		public boolean displyCountryCzechRepublicText() {
			logger.info("Starting of displyCountryCzechRepublicText");
			
			txtCountryCzechRepublic.isDisplayed();
			
			logger.info("Ending of displyCountryCzechRepublicText");
			return this.isDisplayed("txt.czech.republic");
		}
		public boolean displyCountryDenmarkText() {
			logger.info("Starting of displyCountryDenmarkText");
			
			//txtCountryDenmark.isDisplayed();
			
			logger.info("Ending of displyCountryDenmarkText");
			return this.isDisplayed("txt.denmark");
		}
		public boolean displyCountryEstoniaText() {
			logger.info("Starting of displyCountryEstoniaText");
			
			//txtCountryEstonia.isDisplayed();
			
			logger.info("Ending of displyCountryEstoniaText");
			return this.isDisplayed("txt.estonia");
		}
		public boolean displyCountryFaroeIslandText() {
			logger.info("Starting of displyCountryFaroeIslandText");
			
			//txtCountryFaroeIsland.isDisplayed();
			
			logger.info("Ending of displyCountryFaroeIslandText");
			return this.isDisplayed("txt.faroe.island");
		}
		public boolean displyCountryFinlandText() {
			logger.info("Starting of displyCountryFinlandText");
			
			//txtCountryFinland.isDisplayed();
			
			logger.info("Ending of displyCountryFinlandText");
			return this.isDisplayed("txt.finland");
		}
		public boolean displyCountryFranceText() {
			logger.info("Starting of displyCountryFranceText");
			
			txtCountryFrance.isDisplayed();
			
			logger.info("Ending of displyCountryFranceText");
			return this.isDisplayed("txt.france");
		}
		public boolean displyCountryGeorgiaText() {
			logger.info("Starting of displyCountryGeorgiaText");
			
			//txtCountryGeorgia.isDisplayed();
			
			logger.info("Ending of displyCountryGeorgiaText");
			return this.isDisplayed("txt.georgia");
		}
		public boolean displyCountryGreenlandText() {
			logger.info("Starting of displyCountryGreenlandText");
			
			//txtCountryGreenland.isDisplayed();
			
			logger.info("Ending of displyCountryGreenlandText");
			return this.isDisplayed("txt.greenland");
		}
		public boolean displyCountryGermanyText() {
			logger.info("Starting of displyCountryGermanyText");
			
			//txtCountryGermany.isDisplayed();
			
			logger.info("Ending of displyCountryGermanyText");
			return this.isDisplayed("txt.germany");
		}
		public boolean displyCountryGreeceText() {
			logger.info("Starting of displyCountryGreeceText");
			
			//txtCountryGreece.isDisplayed();
			
			logger.info("Ending of displyCountryGreeceText");
			return this.isDisplayed("txt.greece");
		}
		public boolean displyCountryHungaryText() {
			logger.info("Starting of displyCountryHungaryText");
			
			//txtCountryHungary.isDisplayed();
			
			logger.info("Ending of displyCountryHungaryText");
			return this.isDisplayed("txt.hungary");
		}
		public boolean displyCountryIcelandText() {
			logger.info("Starting of displyCountryIcelandText");
			
			//txtCountryIceland.isDisplayed();
			
			logger.info("Ending of displyCountryIcelandText");
			return this.isDisplayed("txt.iceland");
		}
		public boolean displyCountryIndiaText() {
			logger.info("Starting of displyCountryIndiaText");
			
			//txtCountryIndia.isDisplayed();
			
			logger.info("Ending of displyCountryIndiaText");
			return this.isDisplayed("txt.india");
		}
		public boolean displyCountryIrelandText() {
			logger.info("Starting of displyCountryIrelandText");
			
			//txtCountryIreland.isDisplayed();
			
			logger.info("Ending of displyCountryIrelandText");
			return this.isDisplayed("txt.ireland");
		}
		public boolean displyCountryItalyText() {
			logger.info("Starting of displyCountryItalyText");
			
			//txtCountryItaly.isDisplayed();
			
			logger.info("Ending of displyCountryItalyText");
			return this.isDisplayed("txt.italy");
		}
		public boolean displyCountryKazakhistanText() {
			logger.info("Starting of displyCountryKazakhistanText");
			
			//stxtCountryKazakhistan.isDisplayed();
			
			logger.info("Ending of displyCountryKazakhistanText");
			return this.isDisplayed("txt.kazakhstan");
		}
		public boolean displyCountryKosovoText() {
			logger.info("Starting of displyCountryKosovoText");
			
			//txtCountryKosovo.isDisplayed();
			
			logger.info("Ending of displyCountryKosovoText");
			return this.isDisplayed("txt.kosovo");
		}
		public boolean displyCountryLatviaText() {
			logger.info("Starting of displyCountryLatviaText");
			
			//stxtCountryLatvia.isDisplayed();
			
			logger.info("Ending of displyCountryLatviaText");
			return this.isDisplayed("txt.latvia");
		}
		public boolean displyCountryLithuaniaText() {
	        logger.info("Starting of displyCountryLithuaniaText");
	        
	        //txtCountryLithuania.isDisplayed();
	        
	        logger.info("Ending of displyCountryLithuaniaText");
	        return this.isDisplayed("txt.lithuania");
	    }

	    public boolean displyCountryMacedoniaText() {
	        logger.info("Starting of displyCountryMacedoniaText");
	        
	        //txtCountryMacedonia.isDisplayed();
	        
	        logger.info("Ending of displyCountryMacedoniaText");
	        return this.isDisplayed("txt.macedonia");
	    }

	    public boolean displyCountryMontenegroText() throws InterruptedException {
	        logger.info("Starting of displyCountryMontenegroText");
	        
	        //txtCountryMontenegro.isDisplayed();
	        
	        logger.info("Ending of displyCountryMontenegroText");
	        return this.isDisplayed("txt.montenegro");
	    }
	    public boolean displyCountryNewZealandText() {
	        logger.info("Starting of displyCountryMontenegroText");
	        
	        //txtCountryNewZealand.isDisplayed();
	        
	        logger.info("Ending of displyCountryMontenegroText");
	        return this.isDisplayed("txt.new.zealand");
	    }

	    public boolean displyCountryNetherlandsText() {
	        logger.info("Starting of displyCountryNetherlandsText");
	        
	        //txtCountryNetherlands.isDisplayed();
	        
	        logger.info("Ending of displyCountryNetherlandsText");
	        return this.isDisplayed("txt.netherlands");
	    }

	    public boolean displyCountryNorwayText() {
	        logger.info("Starting of displyCountryNorwayText");
	        
	        //txtCountryNorway.isDisplayed();
	        
	        logger.info("Ending of displyCountryNorwayText");
	        return this.isDisplayed("txt.norways");
	    }

	    public boolean displyCountryPolandText() {
	        logger.info("Starting of displyCountryPolandText");
	        
	        //txtCountryPoland.isDisplayed();
	        
	        logger.info("Ending of displyCountryPolandText");
	        return this.isDisplayed("txt.poland");
	    }

	    public boolean displyCountryPortugalText() {
	        logger.info("Starting of displyCountryPortugalText");
	        
	        //txtCountryPortugal.isDisplayed();
	        
	        logger.info("Ending of displyCountryPortugalText");
	        return this.isDisplayed("txt.portugal");
	    }

	    public boolean displyCountryRomaniaText() {
	        logger.info("Starting of displyCountryRomaniaText");
	        
	        //txtCountryRomania.isDisplayed();
	        logger.info("Ending of displyCountryRomaniaText");
	        return this.isDisplayed("txt.romania");
	    }

	    public boolean displyCountryRussiaText() {
	        logger.info("Starting of displyCountryRussiaText");
	        
	        //txtCountryRussia.isDisplayed();
	        
	        logger.info("Ending of displyCountryRussiaText");
	        return this.isDisplayed("txt.russia");
	    }

	    public boolean displyCountrySerbiaText() {
	        logger.info("Starting of displyCountrySerbiaText");
	        
	        //txtCountrySerbia.isDisplayed();
	        
	        logger.info("Ending of displyCountrySerbiaText");
	        return this.isDisplayed("txt.serbia");
	    }
	    
	    public boolean displyCountrySlovakiaText() {
	        logger.info("Starting of displyCountrySlovakiaText");
	        
	        //txtCountrySlovakia.isDisplayed();
	        
	        logger.info("Ending of displyCountrySlovakiaText");
	        return this.isDisplayed("txt.slovakia");
	    }

	    public boolean displyCountrySloveniaText() {
	        logger.info("Starting of displyCountrySloveniaText");
	        
	        //txtCountrySlovenia.isDisplayed();
	        
	        logger.info("Ending of displyCountrySloveniaText");
	        return this.isDisplayed("txt.slovenia");
	    }

	    public boolean displyCountrySpainText() {
	        logger.info("Starting of displyCountrySpainText");
	        
	        //txtCountrySpain.isDisplayed();
	        
	        logger.info("Ending of displyCountrySpainText");
	        return this.isDisplayed("txt.spain");
	    }

	    public boolean displyCountrySwedenText() {
	        logger.info("Starting of displyCountrySwedenText");
	        
	        //txtCountrySweden.isDisplayed();
	        
	        logger.info("Ending of displyCountrySwedenText");
	        return this.isDisplayed("txt.sweden");
	    }

	    public boolean displyCountrySwitzerlandText() {
	        logger.info("Starting of displyCountrySwitzerlandText");
	        
	        //txtCountrySwitzerland.isDisplayed();
	        
	        logger.info("Ending of displyCountrySwitzerlandText");
	        return this.isDisplayed("txt.switzerland");
	    }

	    public boolean displyCountryUkraineText() {
	        logger.info("Starting of displyCountryUkraineText");
	        
	        //txtCountryUkraine.isDisplayed();
	        
	        logger.info("Ending of displyCountryUkraineText");
	        return this.isDisplayed("txt.ukraine");
	    }

	    public boolean displyCountryUnitedKingdomText() {
	        logger.info("Starting of displyCountryUnitedKingdomText");
	        
	        //txtCountryUnitedKingdom.isDisplayed();
	        
	        logger.info("Ending of displyCountryUnitedKingdomText");
	        return this.isDisplayed("txt.united.kingdom");
	    }

	    public boolean displyCountryUnitedStatesText() {
	        logger.info("Starting of displyCountryUnitedStatesText");
	        
	        //txtCountryUnitedStates.isDisplayed();
	        
	        logger.info("Ending of displyCountryUnitedStatesText");
	        return this.isDisplayed("txt.united.states");
	    }

	    public boolean displyCountryUruguayText() {
	        logger.info("Starting of displyCountryUruguayText");
	        
	        //txtCountryUruguay.isDisplayed();
	        
	        logger.info("Ending of displyCountryUruguayText");
	        return this.isDisplayed("txt.uruguay");
	    }
		
	}	



