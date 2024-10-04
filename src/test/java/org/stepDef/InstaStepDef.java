package org.stepDef;

import org.openqa.selenium.By;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class InstaStepDef extends BaseInvoke {


	@Given("User should be in instagram login page")
	public void user_should_be_in_instagram_login_page() {
		
		launch("firefox", "https://www.instagram.com/");
	    
	}
	@When("enter instagram username and password")
	public void enter_instagram_username_and_password() {
	 sendValues(valueName("username"), "vijay");
	 sendValues(valueName("password"), "vijay@123");
	}
	@When("click on  insta login button")
	public void click_on_insta_login_button() {
	  valueXpath("//div[text()='Log in']").click();
	}
	@Then("verify login is successfull")
	public void verify_login_is_successfull() {
	   String Actualtext = driver.findElement(By.xpath("//div[text()='Sorry, your password was incorrect. Please double-check your password.']")).getText();
	   String ExpectedText = "Sorry, your password was incorrect. Please double-check your password.";
	   Assert.assertEquals(ExpectedText, Actualtext);
	}

}
