package com.nexsoft.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nexsoft.test.pom.HomePage;
import com.nexsoft.test.pom.LoginPage;
import com.nexsoft.test.pom.SignUpPage;


public class ExamTesting {
	protected WebDriver driver;
	protected Tools tool = new Tools();
	
	protected SignUpPage signUpPage;
	
	@BeforeClass
	public void initial() {
		System.setProperty("url", "https://petstore.octoperf.com/actions/Catalog.action");
		System.setProperty("webdriver.chrome.driver", "C:\\Antoni\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void reset() {
		driver.get(System.getProperty("url"));
	}
	
	//Sign Up ###################################################################
	//user id ++++++++++++++++++++++++++++
  @Test(priority = 0)
  public void userIDValid() {
	  //antonikur99
	  String userId = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
	  .clickAndGoToSignUpPage()
	  .inputUserId("antonikur99")
	  .clickBtnSaveAccount()
	  .getTextUserID();
	  
	  assertEquals(userId, "antonikur99");
  }
  
  @Test(priority = 1)
  public void userIDInvalid() {
	 // !@#$%^&*&^%$#
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputUserId("!@#$%^&*&^%$#")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: User ID Invalid");
	  } catch(Exception e) {
		  tool.screenShoot(driver);
		  fail("Element to display Error message not found");
	  }
	  
  }
  
  @Test(priority = 2)
  public void userIDKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputUserId("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: User ID Required");
	  } catch(Exception e) {
		  tool.screenShoot(driver);
		  fail("Element to display Error message not found");
	  }
  }
  
  //new password++++++++++++++++++++++++++++
  @Test(priority = 3)
  public void newPasswordValid() {
	  // 12345
	  String newPass = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputNewPassword("12345")
			  .clickBtnSaveAccount()
			  .getTextNewPassword();
	  
	  assertEquals(newPass, "12345");
  }
  
  @Test(priority = 4)
  public void newPasswordKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputNewPassword("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: New Password Required");
	  } catch(Exception e) {
		  tool.screenShoot(driver);
		  fail("Element to display Error message not found");
	  }
  }
  
  //repeat password++++++++++++++++++++++++++++
  @Test(priority = 5)
  public void repeatPasswordValid() {
	  // 12345
	  signUpPage = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputNewPassword("12345")
			  .inputRepeatPassword("12345")
			  .clickBtnSaveAccount();
	  String newPass = signUpPage.getTextNewPassword();
	  String repPass = signUpPage.getTextRepeatPassword();
	  
	  assertEquals(newPass, repPass);
  }
  
  @Test(priority = 6)
  public void repeatPasswordInvalid() {
	  // 1234
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputNewPassword("12345")
				  .inputRepeatPassword("1234")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Repeat Password Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 7)
  public void repeatPasswordKosong() {
	 try {
	  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputNewPassword("12345")
			  .inputRepeatPassword("")
			  .clickBtnSaveAccount()
			  .getErrorMessage();
	  
	  assertEquals(errMsg, "Error: Repeat Password Required");
		
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  //first name ++++++++++++++++++++++++++++
  @Test(priority = 8)
  public void firstNameValid() {
	  //Antoni
	  String firstName = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputFirstName("Antoni")
			  .clickBtnSaveAccount()
			  .getTextFirstName();
	  assertEquals(firstName, "Antoni");
  }
  
  @Test(priority = 9)
  public void firstNameInvalid() {
	  //Ant9290@#$!#$
	  try {
		String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputFirstName("Ant9290@#$!#$")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		assertEquals(errMsg, "Error: First Name Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
	  
  }
  
  @Test(priority = 10)
  public void firstNameKosong() {
	  try {
			String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
					  .clickAndGoToSignUpPage()
					  .inputFirstName("")
					  .clickBtnSaveAccount()
					  .getErrorMessage();
			assertEquals(errMsg, "Error: First Name Required");
		} catch (Exception e) {
			tool.screenShoot(driver);
			fail("Element to display Error message not found");
		}
  }
  
  //last name ++++++++++++++++++++++++++++
  @Test(priority = 11)
  public void lastNameValid() {
	  //Kurniawan
	  String lastName = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputLastName("Kurniawan")
			  .clickBtnSaveAccount()
			  .getTextLastName();
	  
	  assertEquals(lastName, "Kurniawan");
  }
  
  @Test(priority = 12)
  public void lastNameInvalid() {
	  //Kurniawan9290@#$!$
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputLastName("Kurniawan9290@#$!$")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Last Name Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 13)
  public void lastNameKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputLastName("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Last Name Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  //email++++++++++++++++++++++++++++
  @Test(priority = 14)
  public void emailValid() {
	  //antoni@email.com
	  String email = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputEmail("antoni@email.com")
			  .clickBtnSaveAccount()
			  .getTextEmail();
	  assertEquals(email, "antoni@email.com");
  }
  
  @Test(priority = 15)
  public void emailInvalid() {
	  //antoni.com
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputEmail("antoni.com")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Email Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 16)
  public void emailKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputEmail("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Email Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  //phone ++++++++++++++++++++++++++++
  @Test(priority = 17)
  public void phoneValid() {
	  //0825123412341234
	  String phone = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
	  .clickAndGoToSignUpPage()
	  .inputPhone("0825123412341234")
	  .clickBtnSaveAccount()
	  .getTextPhone();
	  
	  assertEquals(phone, "0825123412341234");
  }
  
  @Test(priority = 18)
  public void phoneInvalid() {
	  //123123
	  
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputPhone("123123")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Phone Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 19)
  public void phoneKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputPhone("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Phone Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  //address1++++++++++++++++++++++++++++
  @Test(priority = 20)
  public void address1Valid() {
	  //jl. bintaro
	  String address1 = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputAddress1("jl. bintaro")
			  .clickBtnSaveAccount()
			  .getTextAddress1();
	  
	  assertEquals(address1, "jl. bintaro");
  }
  
  @Test(priority = 21)
  public void address1Invalid() {
	  //~!@#$%^&*()_+<>?"}{}[]\`-=,.
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputAddress1("~!@#$%^&*()_+<>?\"}{}[]\\`-=,.")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Address 1 Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 22)
  public void address1Kosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputAddress1("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Address 1 Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  
  //address2++++++++++++++++++++++++++++
  @Test(priority = 23)
  public void address2Valid() {
	  //jl. sudirman
	  String address2 = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputAddress2("jl. sudirman")
			  .clickBtnSaveAccount()
			  .getTextAddress2();
	  
	  assertEquals(address2, "jl. sudirman");
  }
  
  @Test(priority = 24)
  public void address2Invalid() {
	  //~!@#$%^&*()_+<>?"}{}[]\`-=,.
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputAddress2("~!@#$%^&*()_+<>?\"}{}[]\\`-=,.")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Address 2 Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 25)
  public void address2Kosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputAddress2("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Address 2 Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  //city++++++++++++++++++++++++++++
  @Test(priority = 26)
  public void cityValid() {
	  //jakarta
	  String city = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputCity("jakarta")
			  .clickBtnSaveAccount()
			  .getTextCity();
	  
	  assertEquals(city, "jakarta");
  }
  
  @Test(priority = 27)
  public void cityInvalid() {
	  //!@#%&*%$#@
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputCity("!@#%&*%$#@")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: City Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 28)
  public void cityKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputCity("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: City Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  //state++++++++++++++++++++++++++++
  @Test(priority = 29)
  public void stateValid() {
	  //single
	  String city = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputState("single")
			  .clickBtnSaveAccount()
			  .getTextState();
	  
	  assertEquals(city, "single");
  }
  
  @Test(priority = 30)
  public void stateInvalid() {
	  //!@#$%^
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputState("!@#$%^")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: State Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 31)
public void stateKosong() {
	try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputState("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: State Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
}
  //zip++++++++++++++++++++++++++++
  @Test(priority = 32)
  public void zipValid() {
	//10110
	  String zip = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputZip("10110")
			  .clickBtnSaveAccount()
			  .getTextZip();
	  
	  assertEquals(zip, "10110");
  }
  
  @Test(priority = 33)
  public void zipInvalid() {
	  //!@#kj12
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputZip("!@#kj12")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: ZIP Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 34)
  public void zipKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputZip("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: ZIP Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  //country++++++++++++++++++++++++++++
  @Test(priority = 35)
  public void countryValid() {
	  //Indonesia
	  String country = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .inputCountry("Indonesia")
			  .clickBtnSaveAccount()
			  .getTextCountry();
	  
	  assertEquals(country, "Indonesia");
  }
  
  @Test(priority = 36)
  public void countryInvalid() {
	  //!@%@#kaldjf
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputCountry("!@%@#kaldjf")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Country Invalid");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  @Test(priority = 37)
  public void countryKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
				  .clickAndGoToSignUpPage()
				  .inputCountry("")
				  .clickBtnSaveAccount()
				  .getErrorMessage();
		  
		  assertEquals(errMsg, "Error: Country Required");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Element to display Error message not found");
	}
  }
  
  //drop list language++++++++++++++++++++++++++++
  @Test(priority = 38)
  public void languageSelectChange() {
	//japanese
	String languageSelected = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
	.clickAndGoToSignUpPage()
	.selectDropListLanguagePreferenceByValue("japanese")
	.getCurrentSelectedLanguage();
	
	assertEquals(languageSelected, "japanese");
  }
  
  //drop list category++++++++++++++++++++++++++++
  @Test(priority = 39)
  public void favouriteCategoryChange() {
	  //CATS
		String languageSelected = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
		.clickAndGoToSignUpPage()
		.selectDropListFavouriteCategoryByValue("CATS")
		.getCurrentSelectedFavourite();
		
		assertEquals(languageSelected, "CATS");
  }
  
  //check box my list ++++++++++++++++++++++++++++
  @Test(priority = 40)
  public void checkBoxMyListBisaDicentang() {
	  // true
	  boolean statusMyList = PageFactory.initElements(driver, HomePage.class)
	  .clickAndGotoLoginPage()
	  .clickAndGoToSignUpPage()
	  .clickCheckBoxMyList()
	  .checkIfBoxCheckedMyList();
	  
	  assertEquals(true, statusMyList);
  }
  
  //check box my banner ++++++++++++++++++++++++++++
  @Test(priority = 41)
  public void checkBoxMyBannerBisaDicentang() {
	  //true
	  boolean statusMyBanner = PageFactory.initElements(driver, HomePage.class)
			  .clickAndGotoLoginPage()
			  .clickAndGoToSignUpPage()
			  .clickCheckBoxMyBanner()
			  .checkIfBoxCheckedMyBanner();
			  
			  assertEquals(true, statusMyBanner);
  }

  //Sign In ###################################################################
  @Test(priority = 42)
  public void usernameValid() {
	  //kurniawan6666
	  try {
		String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
		.inputUsername("kurniawan6666")
		.clickBtnLogin()
		.getErrMsg();

		
		assertEquals(errMsg, "Invalid/Required Password. Signon failed.");
	} catch (Exception e) {
		//tidak terjadi error message
		tool.screenShoot(driver);
		fail("Tidak ada Error message untuk password");
	}
	  
	  
  }
  
  @Test(priority = 43)
  public void usernameInvalid() {
	  //$%^&*(*&^%$# ^&*
	  try {
			String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
			.inputUsername("$%^&*(*&^%$# ^&*")
			.clickBtnLogin()
			.getErrMsg();
			
			assertEquals(errMsg, "Invalid username or password. Signon failed.");
		} catch (Exception e) {
			tool.screenShoot(driver);
			fail("Tidak ada Error message untuk username ataupun password");
		}
		  
  }
  
  @Test(priority = 44)
  public void usernameKosong() {
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
					.inputUsername("")
					.clickBtnLogin()
					.getErrMsg();
		  
		  assertEquals(errMsg, "Invalid username or password. Signon failed.");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Tidak ada error message");
	}
  }
  
  @Test(priority = 45)
  public void passwordValid() {
	  //kurniawan6666 //12345
	  try {
		  HomePage home = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
					.inputUsername("kurniawan6666")
					.inputPassword("12345")
					.clickBtnLogin()
					.gotoHomePageAfterValidLogin();
		  
		  String signInAvailable = home
					.getTextSignOut();
		  
		  home.clickSignOut();
		  
		  System.out.println(signInAvailable);
		  assertEquals(signInAvailable, "Sign Out");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("No Sign Out element found, mean login is fail.");
	}
	  
  }
  
  @Test(priority = 46)
  public void passwordInvalid() {
	  //kurniawan6666 //123
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
					.inputUsername("kurniawan6666")
					.inputPassword("123")
					.clickBtnLogin()
					.getErrMsg();
		  
		  assertEquals(errMsg, "Invalid username or password. Signon failed.");
	} catch (Exception e) {
		tool.screenShoot(driver);
		fail("Error message not found");
	}
	  
  }
  
  @Test(priority = 47)
  public void passwordKosong() {
	  //kurniawan6666
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
					.inputUsername("kurniawan6666")
					.clickBtnLogin()
					.getErrMsg();
		  assertEquals(errMsg, "Required password. Signon failed.");
		  
	  } catch(Exception e) {
		  tool.screenShoot(driver);
		  fail("Error message for password not found");
	  }
  }
  
  @Test(priority = 48)
  public void usernamePasswordNotRegistered() {
	  //antoni6666 //12345
	  try {
		  String errMsg = PageFactory.initElements(driver, HomePage.class).clickAndGotoLoginPage()
					.inputUsername("antoni6666")
					.inputPassword("12345")
					.clickBtnLogin()
					.getErrMsg();
		  assertEquals(errMsg, "Invalid username or password. Signon failed.");
		  
	  } catch(Exception e) {
		  tool.screenShoot(driver);
		  fail("Error message for password not found");
	  }
	  
  }
}
