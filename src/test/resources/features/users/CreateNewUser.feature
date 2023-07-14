@Project
Feature: Create New User
  Test case for create new user

  Scenario Outline:Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Status code should be 201 created
    And Response body name was "<name>", username was "<username>" and email was "<email>"
    Examples:
      | name    | username | email          |
      | Mayanda | Mynd     | Mynd@gmail.com |