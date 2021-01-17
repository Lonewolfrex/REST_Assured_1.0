Feature: Validating place API's
@Add_Place
Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
	Given Add Place Payload
	When user calls "AddPlaceAPI" with "POST" http request with "<name>" "<language>" "<address>"
	Then the API call is successful with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	
Examples: 
	| name 			| language 	| address						|
	| The Villa 	| English 	| The Villa Cafe and Bar, Sakchi|
#	| The Basement 	| Dutch 	| The Basement Restraunt, Sonari|

@Delete_Place
Scenario Outline: Verify if DeletePlace is working
	Given Delete Place Payload
	When user calls "DeletePlaceAPI" with "POST" http request with "<name>" "<language>" "<address>"
	Then the API call is successful with status code 200
	And "status" in response body is "OK"
	
Examples: 
	| name 			| language 	| address						|
	| The Villa 	| English 	| The Villa Cafe and Bar, Sakchi|	