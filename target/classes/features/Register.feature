Feature: User Registration

Background:
Given User navigates to Register Account page
	

@register @mandatoryfields @smoke @all
Scenario: Register with mandatory fields
When User enters below details into the fields

|firstname      |Ramu                  |
|lastname       |Illapu     					 |
|telephone      |1234567890						 |
|password       |12345								 |
|confirmPassword|12345								 |

And Selects Privacy policy field
And Clicks on continue button
Then Account should get successfully created

@register @allfields @smoke @all
Scenario: Register with all fields

When User enters below details into the fields

|firstname      |Ramu                  |
|lastname       |Illapu     					 |
|telephone      |1234567890						 |
|password       |12345								 |
|confirmPassword|12345								 |

And Selects Yes for newsletter
And Selects Privacy policy field
And Clicks on continue button
Then Account should get successfully created

@register @withoutfields @regression @all
Scenario: Register without providing any fields
When User dont enter details into any fields
And Clicks on continue button
Then Warning messages should be displayed for all mandatory fields

@register @duplicateemail @regression @all
Scenario: Register with duplicate email address

When User enters below details into the fields with duplicate email

|firstname      |Ramu                  |
|lastname       |Illapu     					 |
|email          |ramuillapu10@gmail.com|
|telephone      |1234567890						 |
|password       |12345								 |
|confirmPassword|12345								 |

And Selects Privacy policy field
And Clicks on continue button
Then warning message informating the user about duplicate email should be displayed





