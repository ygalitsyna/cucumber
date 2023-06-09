Feature: Swag Labs orders testing
  Check site functionality for creating orders

  Background: Open Login page
    Given Login page is opened

  Scenario Outline: Authorized user can create order successfully
    When <User> log in with user credentials taken from data base
    And Add orders which are stored in data base for mentioned user
    And Proceed to checkout
    Then Order successfully created

    Examples:
      | User |
      | TIM  |
      | JEFF |
      | ELON |

  Scenario Outline: Blocked user cannot login
    When <User> log in with user credentials taken from data base
    Then Blocked message appears on login page

    Examples:
      | User |
      | BILL |
