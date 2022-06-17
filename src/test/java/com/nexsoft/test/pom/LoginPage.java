package com.nexsoft.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement fieldUsername;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement fieldPassword;
	
	//input[@name='signon']
	@FindBy(xpath = "//input[@name='signon']")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']")
	private WebElement btnRegister;
	
	
	//error msg
	@FindBy(xpath = "//li[contains(text(),'Invalid username or password.')]")
	private WebElement errMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//method for operating web element
	public LoginPage inputUsername (String username){
		clearAllFieldToDefault();
		fieldUsername.sendKeys(username);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public LoginPage inputPassword(String password){
		//tidak di clear semua karena perlu username
//		clearAllFieldToDefault();
		fieldPassword.sendKeys(password);
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public SignUpPage clickAndGoToSignUpPage() {
		btnRegister.click();
		return PageFactory.initElements(driver, SignUpPage.class);
	}

	public LoginPage clickBtnLogin(){
		btnLogin.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public String getErrMsg() {
		return errMsg.getText();
	}
	
	public void clearAllFieldToDefault() {
		fieldUsername.clear();
		fieldPassword.clear();
	}
	
	public HomePage gotoHomePageAfterValidLogin() {
		return PageFactory.initElements(driver, HomePage.class);
	}
}
