Feature: Post posts
  @Project
  Scenario: Create Post with valid Parameter id
    Given Create posts with valid id
    When Send request post create posts
    Then Status code should be 201 created

  @Project
  Scenario Outline: Create Post with string parameter id
    Given Create posts with string parameter "<id>"
    When Send request post create new posts
    Then Status code should be 400 Bad Request
    Examples:
      | id   |
      | satu |

    @Project
    Scenario: Create Post with integer parameter body
      Given Create posts with integer parameter
      When Send request post create posts
      Then Status code should be 400 Bad Request


    @Project
    Scenario: Create Post with invalid key request body
      Given Create posts with invalid request body
      When Send request post create posts
      Then Status code should be 400 Bad Request

    @Project
    Scenario: Create Post with empty parameter
      Given Create posts with empty parameter
      When Send request post create posts
      Then Status code should be 400 Bad Request





