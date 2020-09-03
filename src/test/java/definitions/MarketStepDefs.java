package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.*;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "yahoo":
                getDriver().get("https://www.yahoo.com");
                break;
            case "usps":
                getDriver().get("https://www.usps.com");
                break;
            case "converter":
                getDriver().get("https://www.unitconverters.net");
                break;
            case "calculator":
                getDriver().get("https://www.calculator.net");
                break;
            case "ups":
                getDriver().get("https://www.ups.com/us/en/Home.page");
                break;
            default:
                System.out.println("URL is not found in our library! " + page);
                break;
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
    }

    @And("I fill out required fields")
    public void iFillOutRequiredFields() throws InterruptedException {
        Map<String, String> user = getData("user");

        getDriver().findElement(By.xpath("//input[@name='username']"))
                .sendKeys(user.get("username"));
        getDriver().findElement(By.xpath("//input[@id='name']"))
                .sendKeys(user.get("firstName"));
        getDriver().findElement(By.xpath("//input[@name='email']"))
                .sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@id='password']"))
                .sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']"))
                .sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"))
                .click();
    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']"))
                .click();
    }

    @And("I verify required fields")
    public void iVerifyRequiredFields() {
        Map<String, String> user = getData("user");
        String password = getDriver().findElement(By.xpath("//b[@name='password']"))
                .getText();
        if (password == "12345") {
            System.out.println("Password is displayed!");
        } else
            System.out.println("Password is not displayed");

        //classwork
        String pageResults = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        assertThat(pageResults).doesNotContain("12345");
        assertThat(pageResults).containsIgnoringCase(user.get("username"));
    }

    @And("I get logs")
    public void iGetLogs() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        System.out.println("Logs >>>");
        for (LogEntry log : logs) {
            System.out.println(log);
        }
        System.out.println("Logs ended ----");
    }

    @And("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) {
        //button[@id='thirdPartyButton']
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        if (action.equals("accept")) {
            getDriver().switchTo().alert().accept();
        } else if (action.equals("dismiss")) {
            getDriver().switchTo().alert().dismiss();
        } else {
            throw new RuntimeException("Incorrect action: " + action);
        }
    }

    @And("I fill out {string} name and {string} phone contact")
    public void iFillOutNameAndPhoneContact(String name, String phone) {
        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(phone);
        getDriver().switchTo().defaultContent();
    }

    @And("I verify document list contains {string}")
    public void iVerifyDocumentListContains(String doc) {
        String originalWindow = getDriver().getWindowHandle();
        getDriver().findElement(By.xpath("//button[contains(@onclick, 'new')]")).click();

        //switch to new window
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        String actualResult = getDriver().findElement(By.xpath("//ul")).getText();
        assertThat(actualResult).contains(doc);

        //switch back
        getDriver().switchTo().window(originalWindow);
    }
}
