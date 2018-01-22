Feature: First Scenario Test
  In order to explore Valtech functionality
  As a webuser user
  I want to navigate to each Valtech's page

  Background:
    Given I navigate to valtech
    Then I should see "Latest News"

  Scenario Outline: Check that you can load each region
    Given I click on "<page>"
    Then I should see "<page_H1>"
  Examples:
      |page         |page_H1      |home   |
      |ABOUT        |ABOUT        |NewsHub|
      |SERVICES     |SERVICES     |NewsHub|
      |WORK         |WORK         |NewsHub|
