#This '@all' tag is common for all scenarios.
@all
Feature: User Login to the appication
Registerd User should be able to login to acess account details

# what are the common steps in every scenario those steps is wrtten in background.
Background: 
Given User navigates to Login page

#If you run one scenario more than one time use scenario outline:

#This are are tags in cucumber.

# dev is the default tags in cucumber
# It is used for when the developer is not yet develop the code for this scenario.

@login @validcredentials @smoke @dev
Scenario Outline: Login with valid credentials
When User enters valid email address <email>
And enters valid password <password>
And Clicks on Login button
Then User should login successfully

Examples:
|email                 |password|
|ramuillapu01@gmail.com|12345   |
|ramuillapu10@gmail.com|12345		|
|ramuillapu11@gmail.com|12345		|
|ramuillapu04@gmail.com|12345		|

#wip is the default tags in cucumber
#it is used to the develop the code for the scenario but the tester didnt write the automation code yet

@login @invalidcredentials @smoke @wip
Scenario: Login with invalid credentials
When User enters invalid email address 
And enters invalid password "123"
And Clicks on Login button
Then User should get a proper warning message

@login @validemailandinvalidpassword @regression
Scenario: Login with valid email address and invalid password
When User enters valid email address "ramuillapu10@gmail.com"
And enters invalid password "1234"
And Clicks on Login button
Then User should get a proper warning message

@login @invalidemailandvalidpassword @regression
Scenario: Login with invalid email address and valid password
When User enters invalid email address
And enters valid password "12345"
And Clicks on Login button
Then User should get a proper warning message

#ignore is the default tags in cucumber
#ignore is used to we dont want to run this scenario that we use

@login @withoutcredentials @regression @ignore
Scenario: Login without providing any credentials
When User dont enter any credentials
And Clicks on Login button
Then User should get a proper warning message

