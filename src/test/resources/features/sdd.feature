  
     Feature: Login
  
  Scenario:  login with username and password
    Given user go to "https://qa-tekarch.firebaseapp.com/"
    When user enters "admin123@gmail.com" in username field
    And "admin123" in password field
    And user click on login button
    Then page title should be "Selenium"
  

  Scenario:  login with valid username and password
    Given user go to "https://qa-tekarch.firebaseapp.com/"
    When user enters "admin123@gmail.com" in username field
    And "admin1234" in password field
    And user click on login button
     Then page title should be "Selenium12"
