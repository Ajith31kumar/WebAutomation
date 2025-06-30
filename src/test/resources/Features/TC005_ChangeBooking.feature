Feature: verfying ChangeBooking

  Scenario Outline: Modify the Created Order Id - Book hotel by card (debit card)
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>","<Enter Company Name>" and "<Enter Company Address>"
    And User add Special Request "<Request>"
    And User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Your name | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Your name | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Your name | July  | 2025 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email         | Enter Registration No. | Enter Company Name     | Enter Company Address | Request | Card Type | Modify Date |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |            1 | Mr.               | Ajith      | kumar     | 5464536456 | fsf@gmail.com |             9043592058 | Greens Tech OMR Branch | Thoraipakkam          | Smoke   | visa      | 02.06.2025  |

  Scenario Outline: Modify the Created Order Id - Book hotel by  (UPI ID)
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>","<Enter Company Name>" and "<Enter Company Address>"
    And User add Special Request "<Request>"
    And User enter upi details "<Upi ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email      | Enter Registration No. | Enter Company Name | Enter Company Address  | Request      | Upi ID | Modify Date      |            |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |              |                 1 | Mr.        | Ajith     | kumar      | 5464536456 | fsf@gmail.com          |         9043592058 | Greens Tech OMR Branch | Thoraipakkam | Smokel | javatraining@vbc | 02.06.2025 |

  Scenario Outline: Modify the Created Order Id - Book hotel by card (debit card) without GST and with special request
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User add Special Request "<Request>"
    And User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Your name | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Your name | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Your name | July  | 2025 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email      | Request       | Card Type | Modify Date |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |              |                 1 | Mr.        | Ajith     | kumar      | 5464536456 | fsf@gmail.com | visa      | 02.06.2025  |

  Scenario Outline: Modify the Created Order Id - Book hotel by card (debit card) without special request and with GST
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>","<Enter Company Name>" and "<Enter Company Address>"
    And User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Your name | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Your name | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Your name | July  | 2025 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email      | Card Type     | Modify Date |            |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |              |                 1 | Mr.        | Ajith     | kumar      | 5464536456 | fsf@gmail.com | visa        | 02.06.2025 |

  Scenario Outline: Modify the Created Order Id - Book hotel by card (debit card) without special request and without GST
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User enter payment details, procced with Card Type "<Card Type>"
      | Select Card | Card No          | Card Name | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name | July  | 2025 | 123 |
      | MasterCard  | 5555555555554444 | Your name | July  | 2025 | 123 |
      | Amex        | 5555555555550000 | Your name | July  | 2025 | 123 |
      | Discover    | 5555555555556666 | Your name | July  | 2025 | 123 |
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email      | Enter Registration No. | Enter Company Name | Enter Company Address  | Request      | Card Type | Modify Date |            |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |              |                 1 | Mr.        | Ajith     | kumar      | 5464536456 | fsf@gmail.com          |         9043592058 | Greens Tech OMR Branch | Thoraipakkam | Smokel    | visa        | 02.06.2025 |

  Scenario Outline: Modify the Created Order Id - Book hotel by  (UPI ID) without special request and with GST
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome Srini"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User add GST Details "<Enter Registration No.>","<Enter Company Name>" and "<Enter Company Address>"
    And User enter upi details "<Upi ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email      | Enter Registration No. | Enter Company Name | Enter Company Address  | Request      | Upi ID | Modify Date      |            |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |              |                 1 | Mr.        | Ajith     | kumar      | 5464536456 | fsf@gmail.com          |         9043592058 | Greens Tech OMR Branch | Thoraipakkam | Smokel | javatraining@vbc | 02.06.2025 |

  Scenario Outline: Modify the Created Order Id - Book hotel by  (UPI ID) without special request and without GST
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome Srini"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User enter upi details "<Upi ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email      | Enter Registration No. | Enter Company Name | Enter Company Address  | Request      | Upi ID | Modify Date      |            |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |              |                 1 | Mr.        | Ajith     | kumar      | 5464536456 | fsf@gmail.com          |         9043592058 | Greens Tech OMR Branch | Thoraipakkam | Smokel | javatraining@vbc | 02.06.2025 |

  Scenario Outline: Modify the Created Order Id - Book hotel by  (UPI ID) with special request and without GST
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User search hotel "<State>","<city>","<Room type>","<Check in date>","<Check out date>","<No of Room>","<No of Adults>" and "<No of Childs>"
    Then User should verify after search hotel success message "Select Hotel"
    When User save the first hotel name and hotel price
    And User select the first hotel and accept the alert
    Then User should verify after select success message "Book Hotel"
    When User add Guest Details "<Select Salutation>","<First Name>","<Last Name>","<Mobile No.>" and "<Email>"
    And User add Special Request "<Request>"
    And User enter upi details "<Upi ID>" and click submit
    And User should verify after hotel booking success message "Booking is Confirmed" and save the order ID
    Then User should verify same selected Hotel is booked or not
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID
    Then User should verify same booked Order ID is present or not
    And User should verify same booked Hotel Name is present or not
    And User should verify same booked Hotel Price is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | State      | city    | Room type | Check in date | Check out date | No of Room | No of Adults | No of Childs | Select Salutation | First Name | Last Name | Mobile No. | Email      | Enter Registration No. | Enter Company Name | Enter Company Address  | Upi ID       | Modify Date      |            |
      | ajithkumar06952@gmail.com | Ajith9843@ | Tamil Nadu | Chennai | Suite     | 01.06.2025    | 02.06.2025     | 1-One      | 1-One        |              |                 1 | Mr.        | Ajith     | kumar      | 5464536456 | fsf@gmail.com          |         9043592058 | Greens Tech OMR Branch | Thoraipakkam | javatraining@vbc | 02.06.2025 |

  Scenario Outline: Modify Check-in Date for existing Order ID
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User search the Order ID "#YPJCO46488"
    Then User should verify same booked Order ID is present or not
    When User edit the Check-in Date "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | Modify Date |
      | ajithkumar06952@gmail.com | Ajith9843@ | 02.06.2025  |

  Scenario Outline: Modify Check-in Date for first displayed Order ID
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User edit the Check-in Date for the first displayed Order ID "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | Modify Date |
      | ajithkumar06952@gmail.com | Ajith9843@ | 02.06.2025  |

  Scenario Outline: Modify Check-in Date for last displayed Order ID
    Given User is on the OMR Branch hotel page
    When User login "<User name>" and "<Password>"
    Then User should verify success message after login "Welcome first name"
    When User navigate to My Booking page
    Then User should verify after navigate to My Booking page success message as "Bookings"
    When User edit the Check-in Date for the last displayed Order ID "<Modify Date>"
    Then User should verify after modify check-in date success message "Booking updated successfully"

    Examples: 
      | User name                 | Password   | Modify Date |
      | ajithkumar06952@gmail.com | Ajith9843@ | 02.06.2025  |
