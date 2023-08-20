Feature: Login
Scenario Outline:login with user name and password
Given user go to the "https:\\login.salesforce.com"
When user enter user "<name>" in  Username field 
And user enter "<password>" in password field 
And user click on login button

    Examples: 
      | name  | password | 
      | name1 |     poonia | 
      | name2 |     poonia1 | 
