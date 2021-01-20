Feature: Register page is working

  Scenario: Registering 5 random users
    Given I open 'automation-practice-form' page
    And I see the URL is 'https://demoqa.com/automation-practice-form'
    And I output the non-registered users
    When I register '1st' random user
    And I register '2nd' random user
    And I register '3rd' random user
    And I register '4th' random user
    And I register '5th' random user
    Then I output the non-registered users
