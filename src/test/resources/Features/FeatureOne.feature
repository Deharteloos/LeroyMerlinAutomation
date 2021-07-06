Feature: First feature
  @Bug_997
  Scenario: Duplicate article
    Given User on the page "Tout vous dire"
    Then Verify whether first article has a duplicate among the following articles