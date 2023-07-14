Feature: Get comments

  @Project
  Scenario: [GT-01] Get all comments
    Given Set path
    When Send request get comments
    Then Status code should be 200 OK
    And All data comments should be shown on response body
    And Validate comment JSON Schema all

  @Project
  Scenario Outline: [GT-02] Get single comment with valid parameter
    Given Set path comment with valid parameter <param>
    When Send request get comments param
    Then Status code should be 200 OK
    And Single data comments should be shown on response body <param>
    And Validate comment JSON Schema
    Examples:
      | param |
      | 1     |

  @Project
  Scenario Outline: [GT-03] Get comment with string parameter
    Given Set path comment with valid parameter string "<param>"
    When Send request get comments param
    Then Status code should be 404 not found
    And Response body should be invalid request response
    Examples:
      | param |
      | s     |
      | a     |

  @Project
  Scenario Outline: [GT-04] Get comment with invalid parameter with special character
    Given Set path comment with valid parameter special character "<param>"
    When Send request get comments param
    Then Status code should be 404 not found
    And Response body should be invalid request response
    Examples:
      | param |
      | !     |
      | @     |

#    GET EXCEED THE LIMIT
  @Project
  Scenario Outline: [GT-05] Get comment exceeds the limit parameter
    Given Set path comment with exceeds the limit parameter <param>
    When Send request get comments param
    Then Status code should be 404 not found
    And Response body should be invalid request response
    Examples:
      | param  |
      | 245674 |
      | 321421 |