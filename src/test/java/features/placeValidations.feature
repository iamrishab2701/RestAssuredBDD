Feature: Validating Place API's

  @AddPlace
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
    Given Add AddPlace payload with "<Name>", "<Language>" and "<Address>"
    When User calls "AddPlaceAPI" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And Verify place_Id created maps to "<Name>" using "getPlaceAPI"

    Examples:
    | Name    | Language | Address            |
    | AAHouse | English  | World Cross Center |
    | BBHouse | German   | Sea Cross Center   |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given DeletePlace Payload
    When User calls "deletePlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"