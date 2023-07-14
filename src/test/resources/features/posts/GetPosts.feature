Feature: Get Posts
  @Project
  Scenario: Get List Posts
    Given Get list posts
    When Send get list posts
    Then Status code should be 200 OK
    And Response body field id, userId, title, body should be exist

  @Project
  Scenario Outline: Get single post with valid parameter id
    Given Get single posts with valid parameter id <id>
    When Send get single posts
    Then Status code should be 200 OK
    And Response body posts ID should be <id>

  Examples:
    | id |
    | 1  |

  @Project
  Scenario Outline: Get single post with invalid parameter id
    Given Get single posts with invalid parameter id "<id>"
    When Send get posts
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | a  |
      | @  |

  @Project
  Scenario Outline: Get single post with exceed parameter id
    Given Get single posts with exceed parameter id <id>
    When Send get posts
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 101 |