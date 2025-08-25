Feature: User Logout

Scenario Outline: User logsout from the automation exercise website

 Given Launch the browser and access automation excercise site
 Then Verify that home page is visible successfully
 When Click on 'Signup / Login' button
 Then Verify 'Login to your account' is visible
 When Enter correct "<Email Address>" and "<Password>"
 And Click 'Login' button
 Then Verify that 'Logged in as username' is visible
 When Click 'Logout' button
 Then Verify that user is navigated to login page
 
 Examples: 
 | Email Address  		 | Password  |
 | alicek123@mail.com  | A1!ice@23 |
 
 
 
 