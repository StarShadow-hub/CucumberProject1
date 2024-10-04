package org.stepDef;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.*;

public class StepDefinition extends BaseInvoke {
	

	@Given("User should be in facebook login page")
	public void user_should_be_in_facebook_login_page() {
	   launch("chrome", "https://www.facebook.com/");
	}
	@When("enter username and password")
	public void enter_username_and_password() {
	    sendValues(ValueId("email"), "vijay");
	    sendValues(ValueId("pass"), "vijay@123");
	}
	@When("click on login button")
	public void click_on_login_button() {
	   valueXpath("//button[@name='login']").click();
	}
	@Then("verify login is successfully or not")
	public void verify_login_is_successfully_or_not() {
		String text = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
		System.out.println(text);
		String s = "The email address or mobile number you entered isn't connected to an account. ";
	    Assert.assertEquals(text, s);
	}



}
