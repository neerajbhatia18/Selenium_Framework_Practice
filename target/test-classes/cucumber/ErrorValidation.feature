@tag
Feature: Error Validation
I want to use this template for my feature file

Given Background:
Given I landed on ecommerce page

@ErrorValidation
Scenario Outline: Checking login error message
Given I landed on ecommerce page
When Logged in with username <username> and password <password>
Then "Incorrect email or password." message is displayed

Examples:
| username | password|
| bhatianeeraj86@gmail.com| Home@49995|