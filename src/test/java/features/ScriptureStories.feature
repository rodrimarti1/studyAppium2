Feature: Test scripture stories functionalities

  #Validate scripture stories general page
  @ScriptureStories
  Scenario: Verify if I can Open the scripture stories and download content
    Given a user opens the app
    Then Validate the Setting button is displayed
    Then Validate that name "Coloring Books" is displayed on the screen
    And swipe and open the "Scripture Stories" option
    Then validate the "Scripture Stories" title is displayed
    And validate the Old Testament is displayed
    And validate the New Testament is displayed
    And validate the Book of Mormon is displayed
    And validate the Doctrine and Covenants is displayed

  #Validate scripture stories labels in options
  @ScriptureStories
  Scenario: Verify if I can Open the scripture stories and download content
    Given a user opens the app
    Then Validate the Setting button is displayed
    Then Validate that name "Coloring Books" is displayed on the screen
    And swipe and open the "Scripture Stories" option
    Then validate the "Scripture Stories" title is displayed