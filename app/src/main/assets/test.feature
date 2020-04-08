Feature: Question Activity

  Scenario: Choose wrong option
    Given Question shows title quiz "Quiz example"
    And Question shows question number "Question 1"
    And Question shows the question text "Question 1"
    And Next button is disabled
    And Options buttons are enable
    And Hint button is enable
    When User presses option "3"
    Then Question shows result "incorrect"
    And Option pressed changes change colour red
    And Correct option changes colour green
    And Next button is enabled
    And Options buttons are disabled
