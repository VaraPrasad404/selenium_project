Feature: Fill Contact Us form
@tag1
Scenario Outline: Fill the contact us form in automation exercise website

Given Launch the browser and access automation excercise site
Then Verify that home page is visible successfully
When Click on 'Contact us' button
Then Verify 'Get In Touch' is visible
When Enter "<Name>", "<Email>", "<subject>" and "<message>"
And Upload file
When Click Submit button
And Click OK button
Then Verify success message 'Success! Your details have been submitted successfully.' is visible
And Click 'Home' button and verify that landed to home page successfully

Examples:
|Name|Email|subject|message|
|Love|love23@you.com|Feedback|Sample love message|

