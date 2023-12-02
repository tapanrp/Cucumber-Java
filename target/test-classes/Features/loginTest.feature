
Feature: Login
@Sanity
  Scenario: Login into the application with valid credentials
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User click login button
    Then User can view Dashboard
    When User click logout
    Then Page title should be "Your store. Login"
    And close browser
@Raj1	
  Scenario Outline: Login into the application with valid credentials
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<Email>" and password as "<Password>"
    And User click login button
    Then User can view Dashboard
    When User click logout
    Then Page title should be "Your store. Login"
    And close browser

    Examples: 
      | Email               | Password |
      | admin@yourstore.com | admin    |
      | abc@yourstore.com   | xyz123   |
