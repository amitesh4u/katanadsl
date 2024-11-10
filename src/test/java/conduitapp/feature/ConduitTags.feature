Feature: Test for Conduit app Tags api call

  Scenario: Get All tags
    Given url 'https://conduit-api.bondaracademy.com/api/tags'
    When method GET
    Then status 200

  Scenario: Get All tags Wrong End point
    Given url 'https://conduit-api.bondaracademy.com/api/tags1'
    When method GET
    Then status 200
