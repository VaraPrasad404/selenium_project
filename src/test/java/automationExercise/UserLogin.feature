

Feature: User Login to Automation Exercise Website

 
  Scenario Outline: Login User with correct email and password
    Given Launch the browser and access automation excercise site
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
    Then Verify 'Login to your account' is visible
    When Enter correct "<Email Address>" and "<Password>"
    And Click 'Login' button
    Then Verify that 'Logged in as username' is visible
    And Click 'Delete Account' button
    Then Verify that the 'Account Deleted!' is visible



    Examples: 
      | Email Address  		 | Password  |
      | alicek123@mail.com | A1!ice@23 |
      
