Feature: Add product to cart

  Scenario: Successful Login and Add Sony Vaio i5 to Cart
        Given Browser is initialized
        When user click on Login option
        When User logs in using credentials from config
        And click on Login 
        Then Page Title should be "STORE"
    		When User navigates to Laptops category
    		And User selects Product
    		And User clicks on Add to cart button
    		Then A confirmation alert with message "Product added" should appear
    		And close browser