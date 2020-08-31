package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.xalan.xsltc.compiler.Parser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.Phaser;

import static org.assertj.core.api.Assertions.assertThat;

import static support.TestContext.getDriver;

public class CalculatorStepDefs {
    @When("I navigate to {string}")
    public void iNavigateTo(String type) {
        getDriver().findElement(By.xpath("//a[contains(text(),'" + type + "')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
    }

    @And("I calculate")
    public void iCalculate() {

        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String err) {
        WebElement actualResult = getDriver().findElement(By.xpath("//a[@name='autoloanresult']/.."));

        assertThat(actualResult.getText().contentEquals(err));
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradeIn, String state, String percentTax, String fees) {
        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);
        new Select(getDriver().findElement(By.xpath("//select[@name='cstate']"))).selectByVisibleText(state);
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(percentTax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String expectedPrice) {
        WebElement actualPrice = getDriver().findElement(By.xpath("//h2[@class='h2result']"));
        assertThat(actualPrice.getText().contains(expectedPrice));
    }

    @When("{string}: {int} {string} to {string} result is {double}")
    public void toResultIs(String unit, int fromValue, String from, String to, int expectedResult) {
        getDriver().findElement(By.xpath("//div[@id='menu']//text()='" + unit + "'")).click();
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(String.valueOf(fromValue));
        new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']"))).selectByVisibleText(from);
        new Select(getDriver().findElement(By.xpath("//select[@id='calTo']"))).selectByVisibleText(to);
        WebElement actualResult = getDriver().findElement(By.xpath("//input[@name='toVal']"));
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
