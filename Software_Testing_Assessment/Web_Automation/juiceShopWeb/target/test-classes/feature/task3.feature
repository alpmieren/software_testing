@task3
  Feature: Register Page

    Background:
      Given Go to juice shop page
      And Click account button
      And Click Login button
      And Click not yet a customer? button

    Scenario: Verify trigger validation messages on the registration page
      Given Click on all fields without adding any values
      Then You should see a validation messages for all fields

    Scenario: Verify register to application
      Given Fill registration form fields with required data
      When Click show password advice
      When Click Register button
      Then You should see successful message of registration
      When Login to web application with generated information