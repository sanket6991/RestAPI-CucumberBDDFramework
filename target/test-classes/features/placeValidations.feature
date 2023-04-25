@ValidatePlace
Feature: Validating Place API's

  @AddPlace
  Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI
    Given Add Place Payload with "<name>" "<phone_number>" "<address>" "<website>" "<language>"
    When User calls "AddPlaceAPI" with "post" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify place_Id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name       | phone_number | address        | website                        | language |
      | Sweet Home |   1523585224 | near main road | https://rahulshettyacademy.com | Marathi  |
  # |Pretty Home |  5425236974  | Opposite to Hospital |https://rahulshettyacademy.com| English  |
  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When User calls "deletePlaceAPI" with "post" http request
    Then The API call got success with status code 200
    And "status" in response body is "OK"
