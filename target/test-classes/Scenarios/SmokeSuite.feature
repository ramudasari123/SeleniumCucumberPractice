Feature: Customer Transfer's Fund

@smokeTest
Scenario: Infostretch Nest Login
Given user opens nest Page
When user enters "ramu.dasari" and "Rd124@124"
And clicks on login button
Then user sees the nest home page
When user clciks on left navigation bar
Then user sees the navigation menu

#Examples:
#|username|password|
#|ramu.dasari|Trust17@17|

@smokeTest
Scenario Outline:: Infostretch Nest Login
Given user opens nest Page
When user enters "username" and "password"
And clicks on login button
Then user sees the nest home page
When user clciks on left navigation bar
Then user sees the navigation menu

Examples:
|username|password|
|ramu.dasari|Trust17@17|