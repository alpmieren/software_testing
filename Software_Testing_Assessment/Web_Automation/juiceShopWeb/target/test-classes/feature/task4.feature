@task4
  Feature: Purchase Process

    Background:
      Given Go to juice shop page
      And Click account button
      And Click Login button
      And Click not yet a customer? button
      Given Fill registration form fields with required data
      When Click Register button
      When Login to web application with generated information
      And Add five different products

    Scenario: Verify that user able to purchase products
      Then You should see successful popup message
      Then You should see cart number changed to five
      When Go to your basket
      When Increase number of any product then delete it from basket
      When Click Checkout button
      When Add to address information
      And Click continue button
      When Select delivery method and click continue button
      When Add new card and select it
      And Finish purchase process