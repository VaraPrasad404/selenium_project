Feature: Get all the Product Details  

Scenario Outline: Get the total products count, Product name and Product Cost

Given Launch the browser and access automation excercise site
Then Verify that home page is visible successfully
When Click on 'Products' button
And Get the products count
Then Print each product name and cost
And Sort the products list as per cost in ascending order

