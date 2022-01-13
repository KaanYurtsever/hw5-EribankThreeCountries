Feature: Make a payment with three different clients

  @make-payments
  Scenario Outline: Make payments with three different clients
    Given Open browser and homepage screen
    When Login with company username and password
    And Make "<phone>" with the values "<name>",<payments>,"<countries>"
    Then Should see that log out page
    Examples:
      | countries | payments |  name | phone |
      | Canada    | 10       |  kaan | 1231  |
      | USA       | 20       |  osman| 12421 |
      | Japan     | 30       |  mert | 25435 |





#make a payment to three different client
# client countries CN, USA, JPN
# client amounts 10, 20, 30
# for each payment user's balance should be checked.

# scenario
# make payment for each country in countries list



#logout test


