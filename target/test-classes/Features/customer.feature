Feature: Customers

  @Raj2
  Scenario: Add New Customer
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User click login button
    Then User can view Dashboard
    When User click on Customers Menu
    And click on Customers Menu Item
    And click on Add New Button
    Then User can view Add new customer page
    When User enter customer information
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully." or can view information message "Email is already registered"
    And close browser

  @Raj3
  Scenario: Search Customer By Email
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User click login button
    Then User can view Dashboard
    When User click on Customers Menu
    And click on Customers Menu Item
    And Enter customer's email
    When Click on search button
    Then User should found the email in the search table
    And close browser

  @Raj4
  Scenario: Search Customer By Email
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User click login button
    Then User can view Dashboard
    When User click on Customers Menu
    And click on Customers Menu Item
    And Enter customer's email "victoria_victoria@nopCommerce.com"
    When Click on search button
    Then User should found the email "victoria_victoria@nopCommerce.com" in the search table
    And close browser

  @Raj5
  Scenario: Search Customer By First Name and Last Name
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User click login button
    Then User can view Dashboard
    When User click on Customers Menu
    And click on Customers Menu Item
    And Enter customer's first name "Steve" and last name "Gates"
    When Click on search button
    Then User should found the first name "Steve" and last name "Gates" in the search table
    And close browser

  @Raj6
  Scenario: Search Customer By Email
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User click login button
    Then User can view Dashboard
    When User click on Customers Menu
    And click on Customers Menu Item
    And Enter customer's email "arthur_holmes@nopCommerce.com"
    When Click on search button
    Then User1 should found the email "arthur_holmes@nopCommerce.com" in the search table counter 1
    And close browser
