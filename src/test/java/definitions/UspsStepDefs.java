package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.AbstractStringAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

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
        WebElement quickTools = getDriver().findElement(By.xpath("//a[text()='Quick Tools']"));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(quickTools).perform();
        getDriver().findElement(By.xpath("//a[text()='Quick Tools']/..//a[contains(@href,'postcalc')]")).click();
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
    public void iCalculateThePriceAndValidateCostIs(String expectedPrice) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        String displayedPrice = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(displayedPrice).contains(expectedPrice);
    }

    @When("I perform {string} search")
    public void iPerformSearch(String text) throws InterruptedException {
        WebElement searchMenu = getDriver().findElement(By.xpath("//li[contains(@class,'nav-search')]"));
        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='global-header--search-track-search']"));
        new Actions(getDriver())
                .moveToElement(searchMenu)
                .sendKeys(searchInput, text)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filter) {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@class='white-spinner-container']"));
//        wait.until(ExpectedConditions.invisibilityOf(spinner));

        //JavaScript click
        WebElement filterElement = getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][text()='" + filter + "']"));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", filterElement);

//        getDriver().findElement(By.xpath("//a[@class='dn-attr-a'][text()='" + filter + "']")).click();
        getWait().until(ExpectedConditions.invisibilityOf(spinner));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String expectedCount) {
        int expectedSize = Integer.parseInt(expectedCount);

        String heading = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();
        String headingCount = heading.replaceAll("\\D*", "");
        int parsedHeadingCount = Integer.parseInt(headingCount);

        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']//li"));
        int actualSize = results.size();

        assertThat(actualSize).isEqualTo(expectedSize);
        assertThat(actualSize).isEqualTo(parsedHeadingCount);
    }

    @When("I select {string} in results")
    public void iSelectInResults(String result) {
         getDriver().findElement(By.xpath("//span[text()='" + result + "']")).click();
        
    }

    @And("I click {string} button")
    public void iClickButton(String buttonTitle) throws InterruptedException {
        int numOfWin = getDriver().getWindowHandles().size();
        while (getDriver().getWindowHandles().size() < numOfWin + 1) {
            getDriver().findElement(By.xpath("//a[contains(text(),'" + buttonTitle + "')]")).click();
            Thread.sleep(100);
        }
    }

    @Then("I validate that Sign In is required")
    public void iValidateThatSignInIsRequired() {
        String originalWindow = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.titleContains("Sign In"));

//        WebElement username = getDriver().findElement(By.xpath("//input[@id='username']"));
//        assertThat(username.isDisplayed()).isTrue();
        getDriver().findElement(By.xpath("//button[@id='btn-submit']")).click();
        WebElement errorElement = getDriver().findElement(By.xpath("//span[@id='error-password']"));
        wait.until(ExpectedConditions.textToBePresentInElement(errorElement, "required"));
        getDriver().switchTo().window(originalWindow);
    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        switch (tab) {
            case "Help":
                getDriver().findElement(By.xpath("//li[@class='menuheader']//a[text()='" + tab + "']")).click();
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
        WebElement actualResult = getDriver().findElement(By.xpath("(//div[@class='listContent'])[1]"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.textToBePresentInElement(actualResult, search));
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        getDriver().findElement(By.xpath("//a[@id='link-locator']")).click();
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String type, String service, String available) throws InterruptedException {
        //type
        getDriver().findElement(By.xpath("//div[@class='dropdown-selection']/button[contains(text(),'" + type + "')]")).click();
        //service
        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        getDriver().findElement(By.xpath("//li[@id='pickupPo']//a[contains(text(),'" + service + "')]")).click();
        //available
        getDriver().findElement(By.xpath("//button[@id='available-service-select']")).click();
        getDriver().findElement(By.xpath("//a[contains(text(),'" + available + "')]")).click();
    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String address, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();
        getDriver().findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);
        new Select(getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']"))).selectByValue(state);
        getDriver().findElement(By.xpath("//a[contains(text(),'Go to Results')]")).click();
    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String phone) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='resultBox']/div[1]")));
        getDriver().findElement(By.xpath("//div[@id='resultBox']/div[1]")).click();
        By phoneWrapper = By.xpath("//div[@class='phone-wrapper']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneWrapper));
    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String providedSubMenu, String providedMenuTitle) {
        WebElement menuTitle = getDriver().findElement(By.xpath("//a[@class='menuitem'][(text()='" + providedMenuTitle + "')]"));
        WebElement subMenu = getDriver().findElement(By.xpath("//a[(text()='" + providedSubMenu + "')]"));
        getActions()
                .moveToElement(menuTitle)
                .click(subMenu)
                .perform();
    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='address']")));
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//button[contains(@class,'field-icon-search')]")).click();

    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String button) {
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='route-table-toggle'][text()='" + button + " ']")));
        getDriver().findElement(By.xpath("//a[@class='route-table-toggle'][text()='" + button +  " ']")).click();

    }
}
