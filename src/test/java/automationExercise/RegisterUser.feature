

Feature: Register User

 
  Scenario Outline: Register the user for the first time to ecommerce application
    Given Launch the browser and access automation excercise site
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
    Then Verify 'New User Signup!' is visible
    When Enter "<Name>" and "<Email>"
    And Click 'Signup' button
    Then Verify that the 'Enter Account Information' is visible
    When Fill details: "<Title>", "<Name>", "<Email>", "<Password>", "<Date of birth>"
    And Select checkbox 'Sign up for our newsletter!'
    And Select checkbox 'Receive special offers from our partners!'
		When Fill details: "<First name>", "<Last name>", "<Company>", "<Address>", "<Address2>", "<Country>", "<State>", "<City>", "<Zipcode>", "<Mobile Number>"
    And Click 'Create Account' button
    Then Verify 'Account Created!' is visible
    When Click on 'Continue' button
    Then Verify that 'Logged in as username' is visible
   


Examples:
  | Name     | Email                | Title | Password  | Date of birth | First name | Last name | Company       | Address           | Address2        | Country      | State      | City        | Zipcode | Mobile Number |
  | Alice K  | alicek123@mail.com   | Mrs.   | A1!ice@23 | 12-June-1997   | Alice      | Kapoor    | GreenSoft Ltd | 221B Baker Street | Apt 4B          | United States| New York   | New York    | 10001   | 9876543210    |
  | John D   | john.doe99@gmail.com | Mr.    | Jd@Pass9  | 9-September-1988    | John       | Doe       | FinCorp Inc   | 14 Elmwood Drive  | Suite 210       | Canada       | Ontario    | Toronto     | M5V 3L9 | 9123456789		 |