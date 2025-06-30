
Feature: Verfying hotels Modle


  Scenario Outline: Select Second hotel name and verify navigate to Book Hotel page
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome Ajith"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the Second hotel name and hotel price
    And User select the Select hotel and accept the alert
    Then User should verify after select success message "Book Hotel"

    Examples: 
      | User name                 | Password   | State  | city  | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |
      | ajithkumar06952@gmail.com | Ajith9843@ | Kerala | Kochi | Suite     |            27 |             28 | 1-One      | 1-One        |            1 |

  Scenario Outline: Select last hotel name and verify navigate to Book Hotel page
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome Ajith"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the last hotel name and hotel price
    And User select the last hotel and accept the alert
    Then User should verify after select success message "Book Hotel"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |
      | ajithkumar06952@gmail.com | Ajith9843@ | Kerala     | Kochi   | Suite     | 27            | 28             | 1-One      | 1-One        |            1 |

  Scenario Outline: Select the first Hotel name and dismiss the alert
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome Ajith"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and dismiss the alert
   Then User should stay on the Select Hotel page with message "Select Hotel"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs |
      | ajithkumar06952@gmail.com | Ajith9843@ | Kerala     | Kochi   | Suite     | 27            | 28             | 1-One      | 1-One        |            1 |
