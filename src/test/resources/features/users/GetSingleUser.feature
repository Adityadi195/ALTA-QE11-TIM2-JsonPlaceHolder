@Project

Feature: Get Single User
  Test case for get single user

  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid  id <id>
    When User send request get single user
    Then Status code should be 200 OK
    And Response body id should be id <id>
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with invalid id "<id>"
    When User send request get single user
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 11 |
      | ab |
      | -+ |
