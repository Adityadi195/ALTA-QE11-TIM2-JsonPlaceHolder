Feature: Delete existing user
  Test case is for delete user

  @Project
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <param>
    When User send request delete user
    Then Status code should be 200 OK
    Examples:
      | param  |
      | 1 |