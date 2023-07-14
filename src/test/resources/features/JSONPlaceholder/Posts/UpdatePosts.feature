Feature: Update Posts
  @Project
  Scenario Outline: Update post with valid parameter id
    Given Update post with valid parameter id <id>
    When Send request update post
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |

  @Project
  Scenario Outline: Update post with invalid parameter id
    Given Update post with invalid parameter id <id>
    When Send request update post
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 102 |

  @Project
  Scenario Outline: Update post with string parameter id
    Given Update post with string parameter id "<id>"
    When Send request update post
    Then Status code should be 404 Not Found
    Examples:
      | id   |
      | halo |

  @Project
  Scenario Outline: Update post with empty parameter
    Given Update post with empty parameter <id>
    When Send request update post
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 0  |


