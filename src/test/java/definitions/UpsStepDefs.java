package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import static support.TestContext.*;

public class UpsStepDefs {
    Map<String, String> upsFrom = getData("upsFrom");

    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2']")).click();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        getDriver().findElement(By.xpath("//ul[@class='ups-menu_links']//a[contains(@href,'ship?')]")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ups-wrap_inner']//div[@class='ups-wrap']")));
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {

        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(upsFrom.get("name"));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys(upsFrom.get("address"));
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(upsFrom.get("zip"));

        WebElement city = getDriver().findElement(By.xpath("//input[@id='origincity']"));
        getWait().until(ExpectedConditions.textToBePresentInElementValue(city, upsFrom.get("city").toUpperCase()));

        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys(upsFrom.get("email"));
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys(upsFrom.get("phone"));

    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        getDriver().findElement(By.xpath("//button[contains(@id,'ContinueButton')]")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ups-wrap_inner']//div[@class='ups-wrap']")));
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String actualName = getDriver().findElement(By.xpath("//div[@class='ups-group ups-group_condensed']/..")).getText();
        assertThat(actualName).contains(upsFrom.get("name"));
        assertThat(actualName).contains(upsFrom.get("address"));
        assertThat(actualName).contains(upsFrom.get("city").toUpperCase());
        assertThat(actualName).contains(upsFrom.get("zip"));
        assertThat(actualName).contains(upsFrom.get("phone"));
        assertThat(actualName).contains(upsFrom.get("email"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() throws InterruptedException {
        WebElement cancelElement = getDriver().findElement(By.xpath("//button[contains(@id,'CancelShipmentButton')]"));
        getExecutor().executeScript("arguments[0].click();", cancelElement);

        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//agent[@class='ng-star-inserted']//section")));
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        getDriver().findElement(By.xpath("//input[@id='originname']")).getText().isEmpty();
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {

    }

    @When("I check Kayak page")
    public void iCheckKayakPage() throws InterruptedException {
        //go to page
        getDriver().get("https://www.kayak.com/");
        String actualTitle = getDriver().getTitle();
        assertThat(actualTitle).isEqualTo("Search Flights, Hotels & Rental Cars | KAYAK");

        //search for flight
        getDriver().findElement(By.xpath("//a[@href='/flights']")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search-form-inner']//div[@data-placeholder='From?']")));
        getDriver().findElement(By.xpath("//div[@class='search-form-inner']//div[@data-placeholder='From?']")).click();
        getDriver().findElement(By.xpath("//input[@name='origin'][@placeholder='From?']")).sendKeys("San Diego");
        getDriver().findElement(By.xpath("//li[@id='ap-SAN/10760']//div[@class='item-info']")).click();
        getDriver().findElement(By.xpath("//div[@class='search-form-inner']//div[@data-placeholder='To?']")).click();
        getDriver().findElement(By.xpath("//div[contains(@id, 'destination')]/input[@placeholder='To?']")).sendKeys("San Jose");
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='ap-SJC/11228']//div[@class='item-info']")));
        getDriver().findElement(By.xpath("//li[@id='ap-SJC/11228']//div[@class='item-info']")).click();
        getDriver().findElement(By.xpath("//span[contains(@class,'v-c-p centre')]//span[contains(@class,'icon')]//*[local-name()='svg']")).click();

        //click toggle
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Flights-Results-FlightCovidLoadingModal']")));
        getDriver().findElement(By.xpath("//button[contains(@id, 'close-button')]")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'Flights-Results-FlightQueryPricePrediction two')]")));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//*[contains(@id, 'toggle')][@type='checkbox']")));

        //verify dates
        assertThat(getDriver().findElement(By.xpath("//span[@class='date']")).getText()).hasToString("Thu 10/22 - Thu 10/29");
    }

    @When("I check {string} tracking number")
    public void iCheckTrackingNumber(String tracking) {
        //go to page
        getDriver().get("https://www.ups.com/us/en/Home.page");

        //search for tracking
        getDriver().findElement(By.xpath("//textarea[@id='ups-track--qs']")).sendKeys(tracking);
        getDriver().findElement(By.xpath("//button[@id='ups-tracking-submit']")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ups-card']")));

        //print scheduled delivery date
        String deliveryDay = getDriver().findElement(By.xpath("//span[@id='stApp_scheduledDeliveryDay']")).getText();
        String deliveryDate = getDriver().findElement(By.xpath("//span[@id='stApp_scheduledDelivery']")).getText();
        System.out.println("Expected delivery date is " + deliveryDay + ", " + deliveryDate);
    }
}
