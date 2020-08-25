package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.AbstractStringAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class UspsStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//a[contains(@href, 'ZipLookupAction!')]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//a[text()='Find by Address']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String address, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        Select stateSelect = new Select(getDriver().findElement(By.xpath("//select[@id='tState']")));
        stateSelect.selectByValue(state);
//        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
//        getDriver().findElement(By.xpath("//option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
//      explicit wait
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        WebElement zipResults = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
//      assertThat(zipResults).contains(zip);
        wait.until(ExpectedConditions.textToBePresentInElement(zipResults, zip));
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
        WebElement quickTools = getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(quickTools).perform();
        getDriver().findElement(By.xpath("//a[contains(@href, 'postcalc')][@role='menuitem']/img")).click();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String shape) {
        Select selectCountry = new Select(getDriver().findElement(By.xpath("//select[@id='CountryID']")));
        selectCountry.selectByVisibleText(country);
        getDriver().findElement(By.xpath("//input[@value='" + shape + "']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String qty) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(qty);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        String displayedPrice = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(displayedPrice).contains(price);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchKeys) {
        getDriver().findElement(By.xpath("//input[@id='home-input']")).sendKeys(searchKeys);
        getDriver().findElement(By.xpath("//button[@value='Search']")).click();

    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        getDriver().findElement(By.xpath("//a[@title='" + filter + "']")).click();
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String qty) {
        String numberFound = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        assertThat(numberFound).contains(qty);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String arg0) {
        
    }

    @And("I click {string} button")
    public void iClickButton(String arg0) {
        
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        
    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        switch (tab) {
            case "Help":
                getDriver().findElement(By.xpath("//li[@class='menuheader']/a[contains(@href,'faq')]")).click();
                break;
            default:
                System.out.println("No such tab found: " + tab);
        }
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String search) {
        getDriver().findElement(By.xpath("//input[contains(@class,'search-field')]")).sendKeys(search);
        getDriver().findElement(By.xpath("//button[contains(@class,'search-button')]")).click();
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String search) {
        String actualResult = getDriver().findElement(By.xpath("//div[@class='resultsWrapper']")).getText();
        assertThat(actualResult).doesNotContain(search);
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        getDriver().findElement(By.xpath("//a[@id='link-locator']")).click();
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String type, String service, String available) {
        WebElement typeEntered = getDriver().findElement(By.xpath("//button[contains(text(),'" + type + "')]"));

        Select select = new Select(typeEntered);
    }
}
