package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MarketStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            default:
                System.out.println("URL is not found in our library! " + page);
        }
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
    }

    @And("I fill out required fields")
    public void iFillOutRequiredFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='username']"))
                .sendKeys("test");
        getDriver().findElement(By.xpath("//input[@name='email']"))
                .sendKeys("email@no.example.com");
        getDriver().findElement(By.xpath("//input[@id='password']"))
                .sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']"))
                .sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@name='username']"))
                .sendKeys("Daniel Test");
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
        String password = getDriver().findElement(By.xpath("//b[@name='password']"))
                .getText();
        if (password == "12345") {
            System.out.println("Password is displayed!");
        } else
            System.out.println("Password is not displayed");
    }
}
