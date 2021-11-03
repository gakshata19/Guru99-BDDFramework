Feature: Test Guru99 Application
Scenario: Test Login

Given Launch Guru99 Application
When User enter valid username and password
Then User click on login button
Then User is on home page
And Close browser