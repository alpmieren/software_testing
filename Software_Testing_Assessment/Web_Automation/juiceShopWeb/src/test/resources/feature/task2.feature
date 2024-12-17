@task2
  Feature: Task2
    Scenario: Display specific product with popup
      Given Go to juice shop page
      When Click first product
      Then User should see product popup and product image
      When Expand the product's review if it exists
      When Wait couple of second
      And Close product form