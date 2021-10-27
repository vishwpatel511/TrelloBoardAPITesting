Feature: Testing the Trello APIs using POST call

Scenario: Creating the new board 

Given Trello APIs are operational and running
When payload is prepared
And "URI" as URI "api_key" as API key and "token" as token is passed as a query params with "/1/boards/" as end points
Then Response is sent back by server