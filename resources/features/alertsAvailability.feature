Feature: Check if alerts are available on the Sea Explorer's home page

  Background: user is logged in
    Given browser is open
    And user is on login page
    When user enters fake.user
    And clicks on login button
    Then user is navigated to the home page

  @Regression @GoLive @AlertsAvailability @SEAEXPD-0001
  Scenario: Check if Weather, Vessels, Ports and General alerts are available on the home page
    Given user is on the home page
    Then at least one alert from all categories is available
    Then alerts counter is valid
    And take screenshot of the home page
