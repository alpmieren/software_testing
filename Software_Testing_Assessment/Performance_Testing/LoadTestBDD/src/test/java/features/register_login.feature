Feature: Perform BDD load testing on client_register and client_login

  Scenario: Register user and perform login
    Given I have random user data
    When I send a POST request to register endpoint with the user data
    Then I should get a 200 response for registration

    When I send a POST request to login endpoint with the same user data
    Then I should get a 200 response for login