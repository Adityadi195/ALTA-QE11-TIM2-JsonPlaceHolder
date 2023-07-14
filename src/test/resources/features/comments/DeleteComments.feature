Feature: Delete comments

  @Project
  Scenario Outline: [DL-01] Delete Comments with valid parameter
    Given Set path <id> delete
    When Send request delete comments
    Then Status code should be 200 OK
    Examples:
      | id |
      | 3  |

  @Project
  Scenario Outline: [DL-02] Delete comments with string parameter
    Given Set path "<id>" delete with string
    When Send request delete comments
    Then Status code should be 404 not found
    Examples:
      | id |
      | a  |
      | s  |

  @Project
  Scenario Outline: [DL-03] Delete comments with special character parameter
    Given Set path "<id>" delete with special character
    When Send request delete comments
    Then Status code should be 404 not found
    Examples:
      | id |
      | @  |
      | !  |

  @Project
  Scenario Outline: [DL-04] Delete comments with exceed parameter
    Given Set path <id> delete
    When Send request delete comments
    Then Status code should be 404 not found
    Examples:
      | id     |
      | 324234 |

  @Project
  Scenario Outline: [DL-05] Delete comments with empty parameter
    Given Set path delete with empty parameter "<id>"
    When Send request delete comments
    Then Status code should be 404 not found
    Examples:
      | id |
      |    |