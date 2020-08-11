@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

    @predefined2
    Scenario: Predefined steps for Yahoo
      Given I open url "https://www.yahoo.com/"
      Then I should see page title as "Yahoo"
      Then element with xpath "//input[@id='header-search-input']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='header-search-input']"
      Then I click on element with xpath "//button[@id='header-desktop-search-button']"
      Then I wait for element with xpath "//*[@id='web']" to be present
      Then element with xpath "//*[@id='web']" should contain text "Cucumber"

    @predefined3
    Scenario: Predefined steps for Bing
      Given I open url "https://www.bing.com/"
      Then I should see page title as "Bing"
      Then element with xpath "//input[@id='sb_form_q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
      Then I click on element with xpath "//label[@for='sb_form_go']"
      Then I wait for element with xpath "//ol[@id='b_results']" to be present
      Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

    @predefined4
    Scenario: Predefined steps for Gibiru
      Given I open url "https://gibiru.com/"
      Then I should see page title as "Gibiru – Protecting your privacy since 2009"
      Then element with xpath "//input[@id='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
      Then I click on element with xpath "//button[@type='submit']"
      Then I wait for element with xpath "//*[contains(@class,'resultsbox')]" to be present
      Then element with xpath "//*[contains(@class,'resultsbox')]" should contain text "Cucumber"

    @predefined5
    Scenario: Predefined steps for DuckDuckGo
      Given I open url "https://duckduckgo.com/"
      Then I should see page title as "DuckDuckGo — Privacy, simplified."
      Then element with xpath "//input[@name='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
      Then I click on element with xpath "//input[@type='submit']"
      Then I wait for element with xpath "//*[@class='results--main']" to be present
      Then element with xpath "//*[@class='results--main']" should contain text "Cucumber"

    @predefined6
    Scenario: Predefined steps for Swisscows
      Given I open url "https://swisscows.com/"
      Then I should see page title as "Swisscows the alternative, data secure search engine."
      Then element with xpath "//input[@name='query']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
      Then I click on element with xpath "//button[@class='search-submit']"
      Then I wait for element with xpath "//*[@class='web-results']" to be present
      Then element with xpath "//*[@class='web-results']" should contain text "Cucumber"

    @predefined7
    Scenario: Predefined steps for SearchEncrypt
      Given I open url "https://www.searchencrypt.com/"
      Then I should see page title as "Search Encrypt | Home"
      Then element with xpath "//input[@name='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
      Then I click on element with xpath "//button[@type='submit']"
      Then I wait for element with xpath "//*[@class='serp__results container']" to be present
      Then element with xpath "//*[@class='serp__results container']" should contain text "Cucumber"

    @predefined8
    Scenario: Predefined steps for Startpage
      Given I open url "https://startpage.com/"
      Then I should see page title as "Startpage.com - The world's most private search engine"
      Then element with xpath "//input[@id='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
      Then I click on element with xpath "//button[contains(@class,'form__button')]"
      Then I wait for element with xpath "//section[contains(@class,'w-gl')]" to be present
      And I wait for 2 sec
      Then element with xpath "//section[contains(@class,'w-gl')]" should contain text "Cucumber"

    @predefined9
    Scenario: Predefined steps for Yandex
      Given I open url "https://yandex.com/"
      Then I should see page title as "Yandex"
      Then element with xpath "//input[@id='text']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
      Then I click on element with xpath "//button[contains(@class,'websearch')]"
      Then I wait for element with xpath "//ul[@id='search-result']" to be present
      Then element with xpath "//ul[@id='search-result']" should contain text "Cucumber"

    @predefined10
    Scenario: Predefined steps for Boardreader
      Given I open url "https://boardreader.com/"
      Then I should see page title as "Boardreader - Forum Search Engine"
      Then element with xpath "//input[@id='title-query']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
      Then I click on element with xpath "//button[@id='title-submit']"
      Then I wait for element with xpath "//*[@class='mdl-list']" to be present
      Then element with xpath "//*[@class='mdl-list']" should contain text "Cucumber"

    @predefined11
    Scenario: Predefined steps for Ecosia
      Given I open url "https://www.ecosia.org/"
      Then I should see page title as "Ecosia - the search engine that plants trees"
      Then element with xpath "//input[@name='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
      Then I click on element with xpath "//button[@type='submit']"
      Then I wait for element with xpath "//div[@class='mainline-results']" to be present
      Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"

    @testcase1
    Scenario: Validate responsive UI behavior
      Given I open url "https://skryabin.com/market/quote.html"
      And I resize window to 1280 and 1024
      Then element with xpath "//b[@id='location']" should be displayed
      Then element with xpath "//b[@id='currentDate']" should be displayed
      Then element with xpath "//b[@id='currentTime']" should be displayed
      And I resize window to 800 and 1024
      Then element with xpath "//b[@id='location']" should be displayed
      Then element with xpath "//b[@id='currentDate']" should be displayed
      Then element with xpath "//b[@id='currentTime']" should be displayed
      And I resize window to 400 and 1024
      Then element with xpath "//b[@id='location']" should not be displayed
      Then element with xpath "//b[@id='currentDate']" should not be displayed
      Then element with xpath "//b[@id='currentTime']" should not be displayed

    @testcase2
    Scenario: Fill out and validate "Username" field
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "a" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='email']"
      Then element with xpath "//label[@id='username-error']" should be displayed
      When I type "b" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='email']"
      Then element with xpath "//label[@id='username-error']" should not be displayed

    @testcase3
    Scenario: Validate "Email" field behavior
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "a@." into element with xpath "//input[@name='email']"
      And I click on element with xpath "//input[@name='username']"
      Then element with xpath "//label[@id='email-error']" should be displayed
      When I clear element with xpath "//input[@name='email']"
      And I type "a@test.com" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//input[@name='username']"
      Then element with xpath "//label[@id='email-error']" should not be displayed

    @testcase4
    Scenario: Fill out and validate "Password" set of fields
      Given I open url "https://skryabin.com/market/quote.html"
      Then element with xpath "//input[@id='confirmPassword']" should be disabled 
      When I type "test" into element with xpath "//input[@id='password']"
      And I click on element with xpath "//input[@id='confirmPassword']"
      Then element with xpath "//label[@id='password-error']" should be displayed
      And element with xpath "//input[@id='confirmPassword']" should be enabled
      When I type "1" into element with xpath "//input[@id='password']"
      Then element with xpath "//label[@id='password-error']" should not be displayed

    @testcase5
    Scenario: Validate "Name" field behavior
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@role='dialog']" should be displayed
      When I type "Daniel" into element with xpath "//input[@id='firstName']"
      And I type "Middle" into element with xpath "//input[@id='middleName']"
      And I type "Last" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[contains(text(),'Save')]"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Daniel Middle Last"

    @testcase6
    Scenario: Validate Accepting Privacy Policy field
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[contains(@id,'Policy-error')]" should be displayed
      When I click on element with xpath "//input[contains(@name, 'Policy')]"
      Then element with xpath "//label[contains(@id,'Policy-error')]" should not be displayed

    @testcase7
    Scenario: Entering non-required fields
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "18585555555" into element with xpath "//input[@name='phone']"
      And I click on element with xpath "//select[@name='countryOfOrigin']"
      And I click on element with xpath "//option[@value='USA']"
      And I click on element with xpath "//input[@value='male']"
      And I click on element with xpath "//input[@name='allowedToContact']"
      And I type "123 Test Drive" into element with xpath "//textarea[@id='address']"
      And I click on element with xpath "//select[@name='carMake']/option[@value='Other']"
      And I click on element with xpath "//button[@id='thirdPartyButton']"
      And I accept alert
      And I type "06/28/2010" into element with xpath "//input[@id='dateOfBirth']"

    @testcase8
    Scenario: Submit form and verify the data
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "testing" into element with xpath "//input[@name='username']"
      And I type "12345678" into element with xpath "//input[@id='password']"
      And I type "12345678" into element with xpath "//input[@id='confirmPassword']"
      And I type "test@noemail.com" into element with xpath "//input[@name='email']"
      And I type "Daniel M Test" into element with xpath "//input[@id='name']"
      And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//div[@id='quotePageResult']" should be displayed
      And element with xpath "//b[@name='password']" should not contain text "12345678"
