Feature: Update comment

  @Project
  Scenario Outline: [PT-01] Update comments with complete request and parameter id
    Given Update comments with complete request and parameter <id>
    When Send request put comments
    Then Status code should be 200 OK
    And Response body exist <id> <postId> "<name>" "<email>" "<body>"
    And Validate put comments json schema
    Examples:
      | id | postId | name   | email         | body        |
      | 50 | 1      | aditya | dwwi@mail.com | Lorem ipsum |

  @Project
  Scenario Outline: [PT-02] Update comments with string parameter and valid request body
    Given Update comments with valid request body and string parameter "<id>"
    When Send request put comments
    Then Status code should be 500 internal server error
    Examples:
      | id |
      | a  |
      | s  |

  @Project
  Scenario Outline: [PT-03] Update comments with special character parameter and valid request body
    Given Update comments with valid request body and special character parameter "<id>"
    When Send request put comments
    Then Status code should be 500 internal server error
    Examples:
      | id |
      | !  |
      | @  |

  @Project
  Scenario Outline: [PT-04] Update comments with valid request body and exceed parameter
    Given Update comments with valid request body and exceed parameter <id>
    When Send request put comments
    Then Status code should be 500 internal server error
    Examples:
      | id  |
      | 900 |


  @Project
  Scenario Outline: [PT-05] Update comments with invalid key body request
    Given Update comments with invalid key body request <id>
    When Send request put comments
    Then Status code should be 400 bad request
    Examples:
      | id |
      | 1  |

  @Project
  Scenario Outline: [PT-06] Update comments with empty value body request
    Given Update comments with empty value body request <id>
    When Send request put comments
    Then Status code should be 400 bad request
    Examples:
      | id |
      | 1  |