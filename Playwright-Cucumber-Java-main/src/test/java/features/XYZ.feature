
Feature: E2E Testing Of XYZ Bank
   
  @tag1
  Scenario: Verify the functionality of Bank Manager Login
    Given User launch XYZ Banking application
    Then User Add new customer in Add Customer tab
    Then User open new account for a new customer in Open Account tab
    And user verify details of new customer in Cutomers tab
    
    Scenario: Verify the functionality of Customer Login
    Given User launch XYZ Banking application
    When User login by selecting name from dropdown
    Then User Deposits ammount of dollars
    Then User verify deposit ammount in Transaction tab
    Then User Withdrawl ammount of dollars
    Then User verify withdrawl ammount in Transaction ammount