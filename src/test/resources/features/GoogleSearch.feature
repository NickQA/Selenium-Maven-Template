Feature: Google search with something useful

  @SmokeTest
  Scenario Outline: user can search any keyword and get title
    Given an open browser with google.com
    When a keyword <Word> is entered in input field and submit button is clicked
    Then title should contains <Word>

    Examples:
      | Word |
      | cheese |
      | milk   |
      | apple  |