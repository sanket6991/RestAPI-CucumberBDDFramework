#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#
@ValidatePlace
Feature: Validating Place API's

  #I want to use this template for my feature file
  @AddPlace
  Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<phone_number>" "<address>" "<website>" "<language>"
    #And some other precondition
    When User calls "AddPlaceAPI" with "post" http request
    #And some other action
    # And yet another action
    Then The API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_Id created maps to "<name>" using "getPlaceAPI"
   Examples:  
    | name       | phone_number |     address          |           website            | language |
    | Sweet Home |  1523585224  | near main road       |https://rahulshettyacademy.com| Marathi  |
   # |Pretty Home |  5425236974  | Opposite to Hospital |https://rahulshettyacademy.com| English  |
  
   @DeletePlace
   Scenario: Verify if Delete Place functionality is working 
      Given DeletePlace Payload
       When User calls "deletePlaceAPI" with "post" http request
       Then The API call got success with status code 200
        And "status" in response body is "OK"
       
       
   
  
