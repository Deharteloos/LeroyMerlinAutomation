Feature: First feature
  @Bug_997
  Scenario: Duplicate article 997
    Given User on the page Tout vous dire
    Then Verify whether first article has a duplicate among the following articles

  @Bug_1011
  Scenario Outline: Non-existent questions 1011
    Given User on the page "Service après-vente | Leroy Merlin"
    When User clicks on "Je souhaite savoir où en est ma commande web"
    And Clicks on <question>
    Then The question should be found

    Scenarios:
      |question                   |
      |point relais fermé         |
      |suivi commande Marketplace |
      |suivi commande             |
