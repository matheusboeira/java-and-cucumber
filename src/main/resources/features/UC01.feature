@All @UC01 @LoginUser
Feature: Login User
  The system must allow the user to log in to
  the system.

  @LoginUserScenery01
  Scenario Outline: Login successfully on Silver Bullet
    Given that browser is open
    When the user puts his credentials
    And the user clicks on "LoginPage.btnLogin"
    Then the system verifies if the user matches "<username>" on "ProjectPage.lblUsername"
    And the user closes the browser
    Examples:
      | username |
      | test     |

  @LoginUserScenery02
  Scenario Outline: Login failure on Silver Bullet
    Given that browser is open
    When the user puts invalid credentials
    And the user clicks on "LoginPage.btnLogin"
    Then the system will send an error "<error>" on "LoginPage.lblError"
    And the user closes the browser
    Examples:
      | error                               |
      | the email or password is incorrect! |


