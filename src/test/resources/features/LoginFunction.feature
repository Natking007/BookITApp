@login
Feature:Login in
  Agile Story: As a user I should be able to login

  Background:On the login page
    Given I am on the login page

    @student
      @smoke
  Scenario: Login as student
      When I login as student
       And I click on My
      And  I click on Self
      Then Role should be student-team-member


  @teamLeader
  Scenario: Login as team leader
    When I login as team leader
    And  I click on My
    And  I click on Self
    Then Role should be student-team-leader



  @teacher
  Scenario: Login as teacher
    When I login as teacher
    And  I click on My
    And  I click on Self
    Then Role should be teacher