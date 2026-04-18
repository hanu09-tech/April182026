Feature: Test Login Functionality
@MyFirstTag
Scenario: Login with valid credentials
	Given user launches application
	When user enters username as "username1" and password as "password"
	And user clicks on submit button
	Then user logged in successfully and the title of the current page should be "Logged In Successfully | Practice Test Automation"

