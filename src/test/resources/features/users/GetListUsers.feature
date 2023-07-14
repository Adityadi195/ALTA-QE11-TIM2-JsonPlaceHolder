Feature: Get List Users
  Test case for get list users

  @Project
  Scenario: Get list users data
    Given Get list users data
    When User send request get list users
    Then Status code should be 200 OK
    And Validate get list users schema