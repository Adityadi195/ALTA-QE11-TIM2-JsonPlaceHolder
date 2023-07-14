Feature: Post new comment

  @Project
  Scenario Outline: [PST-01] Post Create new comment with complete request body
    Given Post new comment with complete request body
    When Send request post comments
    Then Status code should be 201 created
    And Response body exist <postId> "<name>" "<email>" "<body>"
    And Validate comment JSON Schema
    Examples:
      | postId | name   | email         | body        |
      | 1      | aditya | dwwi@mail.com | Lorem ipsum |

  @Project
  Scenario: [PST-02] Post Create new comment with invalid key request
    Given Post new comment with with invalid key request
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-03] Create invalid new comments without key PostId
    Given Post create comments invalid without key PostId
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-04] Create invalid new comments with empty value PostId
    Given Post create comments invalid empty value PostId
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-05] Create invalid new comments without key name
    Given Post create comments invalid without key name
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-06] Create invalid new comments with empty value name
    Given Post create comments invalid empty value name
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-07] Create invalid new comments without key email
    Given Post create comments invalid without key email
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-08] Create invalid new comments with empty value email
    Given Post create comments invalid empty value email
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-09] Create new comments with invalid format request value email
    Given Post create comments with invalid format request body email
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-10] Create invalid new comments without key body
    Given Post create comments invalid without key body
    When Send request post comments
    Then Status code should be 400 bad request

  @Project
  Scenario: [PST-11] Create invalid new comments with empty value body
    Given Post create comments invalid empty value body
    When Send request post comments
    Then Status code should be 400 bad request

    #    BUG
  @Project
  Scenario: [PST-12] Create new comment with empty request body
    Given Post new comment with empty request body
    When Send request post comments
    Then Status code should be 400 bad request

    #    BUG
  @Project
  Scenario: [PST-13] Create new comment with empty value
    Given Post new comment with empty value request body
    When Send request post comments
    Then Status code should be 400 bad request