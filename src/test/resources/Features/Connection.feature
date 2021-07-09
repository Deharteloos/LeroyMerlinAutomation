Feature: Connection scenario
  Scenario Outline: Check message error
    Given User on the homepage
    And User clicks on the connection button in the navbar
    And User clicks on sign up button
    When User enters <figures> in postal code field
    Then The error message shown should not be "Ce champ ne respecte pas le format attendu : 5 caractères numériques"
    Scenarios:
      |figures|
      |68000  |
      |99999  |