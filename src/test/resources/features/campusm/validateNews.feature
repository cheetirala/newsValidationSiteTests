Feature: Validate News

  Scenario: Validate first news article on guardian website
    Given the user is on the guardian home page
    When the user want to validate the first news article
    Then the user validated news from different sources
