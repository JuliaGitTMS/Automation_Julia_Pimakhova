Feature: rabota.by tests

  Scenario: search available vacancies
    Given open HomePage
    When I enter job or company name
    And I click search button
    Then I check if header contains entered job name
    And I check if vacancies quantity is more or equals 20