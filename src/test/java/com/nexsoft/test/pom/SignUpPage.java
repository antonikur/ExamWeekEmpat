package com.nexsoft.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	protected WebDriver driver;
	Select select;
	
	//user information==========================
	@FindBy(xpath = "//input[@name='username']")
	private WebElement fieldUserID;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement fieldNewPassword;
	
	@FindBy(xpath = "//input[@name='repeatedPassword']")
	private WebElement fieldRepeatPassword;
	
	
	//account information====================
	@FindBy(xpath = "//input[@name='account.firstName']")
	private WebElement fieldFirstName;
	
	@FindBy(xpath = "//input[@name='account.lastName']")
	private WebElement fieldLastName;
	
	@FindBy(xpath = "//input[@name='account.email']")
	private WebElement fieldEmail;
	
	@FindBy(xpath = "//input[@name='account.phone']")
	private WebElement fieldPhone;
	
	@FindBy(xpath = "//input[@name='account.address1']")
	private WebElement fieldAddress1;
	
	@FindBy(xpath = "//input[@name='account.address2']")
	private WebElement fieldAddress2;
	
	@FindBy(xpath = "//input[@name='account.city']")
	private WebElement fieldCity;
	
	@FindBy(xpath = "//input[@name='account.state']")
	private WebElement fieldState;
	
	@FindBy(xpath = "//input[@name='account.zip']")
	private WebElement fieldZip;
	
	@FindBy(xpath = "//input[@name='account.country']")
	private WebElement fieldCountry;
	
	
	//profile information=========================
	@FindBy(name = "account.languagePreference")
	private WebElement dropListLanguage;
	
	@FindBy(name = "account.favouriteCategoryId")
	private WebElement dropListFavouriteCategory;
	
	@FindBy(xpath = "//input[@name='account.listOption']")
	private WebElement checkBoxEnableMyList;
	
	@FindBy(xpath = "//input[@name='account.bannerOption']")
	private WebElement checkBoxMyBanner;
	
	//button======================
	@FindBy(xpath = "//input[@name='newAccount']")
	private WebElement btnSaveAccount;
	
	//error message==========================
	@FindBy(xpath = "insert error message xpath here")
	private WebElement errMsg;
	
	//##############################################################
	
	//webdriver
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	//method to operate web element
	
	//user information==========================
	public SignUpPage inputUserId(String userId) {
		clearAllFieldToDefault();
		fieldUserID.sendKeys(userId);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	
	public SignUpPage inputNewPassword(String newPass) {
		clearAllFieldToDefault();
		fieldNewPassword.sendKeys(newPass);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputRepeatPassword(String repPass) {
		//khusus ini tidak di clear karena perlu data new password
//		clearAllFieldToDefault();
		fieldRepeatPassword.sendKeys(repPass);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	//account information====================
	public SignUpPage inputFirstName(String firstName) {
		clearAllFieldToDefault();
		fieldFirstName.sendKeys(firstName);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputLastName(String lastName) {
		clearAllFieldToDefault();
		fieldLastName.sendKeys(lastName);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputEmail(String email) {
		clearAllFieldToDefault();
		fieldEmail.sendKeys(email);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputPhone(String phone) {
		clearAllFieldToDefault();
		fieldPhone.sendKeys(phone);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputAddress1(String address1) {
		clearAllFieldToDefault();
		fieldAddress1.sendKeys(address1);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputAddress2(String address2) {
		clearAllFieldToDefault();
		fieldAddress2.sendKeys(address2);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputCity(String city) {
		clearAllFieldToDefault();
		fieldCity.sendKeys(city);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputState(String state) {
		clearAllFieldToDefault();
		fieldState.sendKeys(state);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputZip(String zip) {
		clearAllFieldToDefault();
		fieldZip.sendKeys(zip);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage inputCountry(String country) {
		clearAllFieldToDefault();
		fieldCountry.sendKeys(country);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	//profile information=========================
	public SignUpPage selectDropListLanguagePreferenceByValue(String value) {
		clearAllFieldToDefault();
		select = new Select(dropListLanguage);
		select.selectByValue(value);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage selectDropListFavouriteCategoryByValue(String value) {
		clearAllFieldToDefault();
		select = new Select(dropListFavouriteCategory);
		select.selectByValue(value);
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage clickCheckBoxMyList() {
		clearAllFieldToDefault();
		checkBoxEnableMyList.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public SignUpPage clickCheckBoxMyBanner() {
		clearAllFieldToDefault();
		checkBoxMyBanner.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	//button======================
	public SignUpPage clickBtnSaveAccount() {
		btnSaveAccount.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}
	
	public String getTextUserID() {
		return fieldUserID.getAttribute("value");
	}
	
	public String getTextNewPassword() {
		return fieldNewPassword.getAttribute("value");
	}

	public String getTextRepeatPassword() {
		return fieldRepeatPassword.getAttribute("value");
	}

	public String getTextFirstName() {
		return fieldFirstName.getAttribute("value");
	}

	public String getTextLastName() {
		return fieldLastName.getAttribute("value");
	}

	public String getTextEmail() {
		return fieldEmail.getAttribute("value");
	}

	public String getTextPhone() {
		return fieldPhone.getAttribute("value");
	}

	public String getTextAddress1() {
		return fieldAddress1.getAttribute("value");
	}

	public String getTextAddress2() {
		return fieldAddress2.getAttribute("value");
	}

	public String getTextCity() {
		return fieldCity.getAttribute("value");
	}

	public String getTextState() {
		return fieldState.getAttribute("value");
	}

	public String getTextZip() {
		return fieldZip.getAttribute("value");
	}

	public String getTextCountry() {
		return fieldCountry.getAttribute("value");
	}

	//drop list and check box
	public String getCurrentSelectedLanguage() {
		select = new Select(dropListLanguage);
		return select.getFirstSelectedOption().getText();
	}
	
	public String getCurrentSelectedFavourite() {
		select = new Select(dropListFavouriteCategory);
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean checkIfBoxCheckedMyList() {
		return checkBoxEnableMyList.isSelected();
	}
	
	public boolean checkIfBoxCheckedMyBanner() {
		return checkBoxMyBanner.isSelected();
	}
	//get errmsg
	public String getErrorMessage() {
		return errMsg.getText();
	}
	
	//to clear all or return to default
	public void clearAllFieldToDefault() {
		fieldUserID.clear();
		fieldNewPassword.clear();
		fieldRepeatPassword.clear();
		fieldFirstName.clear();
		fieldLastName.clear();
		fieldEmail.clear();
		fieldPhone.clear();
		fieldAddress1.clear();
		fieldAddress2.clear();
		fieldCity.clear();
		fieldState.clear();
		fieldZip.clear();
		fieldCountry.clear();
		select = new Select(dropListLanguage);
		select.selectByValue("english");
		select = new Select(dropListFavouriteCategory);
		select.selectByValue("FISH");
		if(checkBoxEnableMyList.isSelected()) {
			clickCheckBoxMyList();
		}
		if(checkBoxMyBanner.isSelected()) {
			clickCheckBoxMyBanner();
		}
	}
}
