@All @UC01 @LoginUser
Feature: Login User
  The system must allow the user to log in to
  the system.

  Scenario: Login successfully on Silver Bullet
    Given that browser is open
    When the user puts his credentials
    And the user clicks on "LoginPage.btnLogin"


