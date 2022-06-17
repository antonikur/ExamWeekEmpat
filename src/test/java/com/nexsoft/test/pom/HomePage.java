package com.nexsoft.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	protected WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	private WebElement btnSignIn;
	
	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	private WebElement btnSignOut;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage clickAndGotoLoginPage() {
		btnSignIn.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public HomePage clickSignOut() {
		btnSignOut.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public String getTextSignOut() {
		return btnSignOut.getText();
	}
	
}
