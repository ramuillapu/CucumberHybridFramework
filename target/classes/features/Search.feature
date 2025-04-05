Feature: Search Functionality

# what are the common steps in every scenario those steps is wrtten in background.
Background:
Given User open the application

@search @searchvalidproduct @smoke @all
Scenario: Search for a valid product
When User enters valid product "HP" into the search field
And Clicks the search button
Then valid product should get displayed in search results


@search @searchnon-existingproduct @smoke @all
Scenario: Search for non-existing product
When User enters non-existing product "Honda" into the search field
And Clicks the search button
Then proper text informing the user about no product matching should be displayed

@search @searchwithoutprovideanyproduct @regression @all
Scenario: Search without providing any product
When User dont enter any product into the search field
And Clicks the search button
Then proper text informing the user about no product matching should be displayed