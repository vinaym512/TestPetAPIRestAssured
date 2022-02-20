Feature: Pet API test

  @functional
  Scenario: Get pet info
    When User serach for pet id 1
    Then Service return code is 200

  @functional
  Scenario: Update pet info
    When User update info for pet id 1
    Then Service return code is 200

  @functional
  Scenario: Delete pet info
    When User deletes info for pet id 1
    Then Service return code is 200