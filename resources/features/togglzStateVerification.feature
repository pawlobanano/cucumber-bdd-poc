Feature: Check if Togglz features are set as desired for LOCAL environment

#  Background: user is logged in
#    Given browser is open
#    And user is on login page
#    When user enters fake.user
#    And clicks on login button
#    Then user is navigated to the home page

  @Regression @TogglzFeaturesStateLOCAL @SEAEXPD-0002
  Scenario Outline: Check if Togglz features are set as desired for <env> environment
    Given user is on the togglz home page
    Then toggles are in desired states:
      | New Angular UI         | Enabled  |
      | Open Search            | Enabled  |
      | Port Grouping          | Enabled  |
      | Alerts                 | Enabled  |
      | Alerts                 | Enabled  |
      | Welcome Message        | Disabled |
      | Show all port statuses | Disabled |
    And take screenshot of the Togglz application index page

    Examples:
      | env   |
      | local |
      | int   |
