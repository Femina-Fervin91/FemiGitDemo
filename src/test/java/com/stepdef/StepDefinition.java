package com.stepdef;

import org.test.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

BaseClass b;
@Given("User is on Addactin page")
public void user_is_on_Addactin_page() {
	b=new BaseClass();
    b.browserLaunch("https://adactinhotelapp.com/");
}

@When("User enter the username and password")
public void user_enter_the_username_and_password() {
	b.locatorInput("name", "username", "FeminaFervin");
   b.locatorInput("name", "password", "femina1991");
}

@When("User should click login button")
public void user_should_click_login_button() {
    b.locatorClick("id", "login");
}

@Then("It should logged in successfully")
public void it_should_logged_in_successfully() {
    System.out.println("-------------------Logged in Successfully-------------------");
 }

@Then("it should display Welcome message in home page")
public void it_should_display_Welcome_message_in_home_page() {
    String text = b.getText("//td[text()='Welcome to Adactin Group of Hotels']");
    System.out.println(text);
}

@Then("In the Text box it display the UserName with Hello")
public void in_the_Text_box_it_display_the_UserName_with_Hello() {
    String text1 = b.getAttrib("//input[@id='username_show']");
    System.out.println(text1);
}


}
