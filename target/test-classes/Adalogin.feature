Feature: To verify login Functionality and home page
  Scenario: To verify the login functionality with valid input
    Given User is on Addactin page
    When User enter the username and password
    And User should click login button
    Then It should logged in successfully
    And it should display Welcome message in home page
		Then In the Text box it display the UserName with Hello
  
  
  