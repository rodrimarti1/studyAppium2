Feature: Test parental control functionalities

  @ParentalControl @test
  Scenario: Verify the functionality of parental control screen
    Given a user opens the app
    Then Validate the Setting button is displayed
    Then open the parental control page
    Then validate the "Settings" label is displayed
    And resolve the operation to open setting page
    Then click on the "Submit" button
    Then validate the setting title is displayed

  @ParentalControl @WrongResolve
  Scenario: Verify the functionality of parental control screen
    Given a user opens the app
    Then Validate the Setting button is displayed
    Then open the parental control page
    Then validate the "Settings" label is displayed
    And select "2" as a number
    And select "2" as a number
    Then click on the "Submit" button
    Then validate the "Incorrect answer. Please try again." error message is displayed