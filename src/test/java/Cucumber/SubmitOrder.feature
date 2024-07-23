@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file	
	Background:
	Given I landed on Ecommerce Website

  @tag2
  Scenario Outline: Positive test of submiting the order
    Given Logged in with username <userName> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username  						| password 		| productName  	|
      | danielowen@gmail.com 	| Flanuermh0 	| IPHONE 13 PRO |
      
