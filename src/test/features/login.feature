
  Feature: Login Test

    Scenario: Go To KitapYurdu website and test login page

      Given Go to KitapYurdu Website
      And Press the login button
      And Enter email and password
      When Pressed the submit button
      Then Verify the success and error message