Feature: Get Single User
  Test case for get single user

  @Project
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid  id <param>
    When User send request get single user
    Then Status code should be 200 OK
    And Response body id should be id <param>
    Examples:
      | param  |
      | 1 |
      | 2 |
      | 3 |

  @Project
  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with invalid id "<param>"
    When User send request get single user
    Then Status code should be 404 Not Found
    Examples:
      | param   |
      | 11 |
      | ab |
      | -+ |