@tag
Feature: Purchase the order from Ecommerce website.
I want to use this template for my feature file.

Background:
Given I landed on ecommerce page

@tag2
Scenario Outline: Positive test of submitting the order
Given Logged in with username <username> and password <password>
When I add the product <productName> to cart
And  checkout <productName> and submit the order

    Examples:
      | username | password | productName |
      | bhatianeeraj86@gmail.com   | Test@123  | ZARA COAT 3  |
      | bhatianeeraj98@gmail.com   | Home@496  | IPHONE 13 PRO  |