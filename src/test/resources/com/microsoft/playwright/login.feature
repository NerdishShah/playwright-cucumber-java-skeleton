Feature: Order product online

  Scenario: Login validation
    Given I am on login page
    When I login with valid credentials
    Then I should be displayed product listing page
    And I logout from the application
