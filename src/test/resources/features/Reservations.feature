Feature: Make, view or cancel reservations
  Agile Story:As a user I should be able to make a reservation on Book it application.


  Background:On the login page
    Given I am on the login page

    @regression
Scenario: Make reservation as team lead
  When I login as team leader
  And User clicks Hunt button
  * User picks a date and time
  * User clicks search
  * User goes to Free Spots page and Book a room
  Then User should see "yey,you got it" message



  Scenario Outline: Users should be able to see which rooms are reserved by team
    When user click on email
    And User enters email "<username>"
    And user click on password
    And user enters password "<password>"
    And user clicks sign in button
    And user click's on My section
    Then user should view current schedule
    Examples:
      | username              | password        |
      | elaye8m@wikipedia.org | tabordullingham |
      | teachervamikemarcus@gmail.com | mikemarcus      |
      | wfarrell8n@usnews.com | doniafisby      |






