Feature: Login validation
Scenario: Facebook login validation
Given User should be in facebook login page
When enter username and password
And click on login button
Then verify login is successfully or not

Scenario: instagram Login validation
Given User should be in instagram login page
When enter instagram username and password
And click on  insta login button
Then verify login is successfull
