@task1
Feature: Task1
  Scenario: Displays all of items
    Given Go to juice shop page
    When Scroll down to end of the page
    When Change items per page to max number
    Then We should see all items on home page

