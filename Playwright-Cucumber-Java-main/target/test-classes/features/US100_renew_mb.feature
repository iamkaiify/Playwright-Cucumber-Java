@smoke @renew_mb
  Feature: US_100 Renew MB

    Background: setup
      Given I am on the t-mobile my dashboard page

    Scenario: I can renew data bundle from my tmobile account
      When my data bundle is under 200 mb
      And I want to renew it
      Then I am able to renew the data bundle

#    Scenario: ss 2
#      When my data bundle is under 200 mb
#      And I want to renew it
#      Then I am able to renew the data bundle