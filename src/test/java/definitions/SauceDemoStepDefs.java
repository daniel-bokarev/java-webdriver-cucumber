package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoStepDefs {

    LoginPage login = new LoginPage();

    @Given("I go to Swag Labs login page")
    public void iGoToSwagLabsPage() {
        login.open();
    }

    @When("I input “standard” username into Username field")
    public void iInputStandardUsernameIntoUsernameField() {
        login.fillUsername("standard_user");
    }

    @And("I input “password” into Password field")
    public void iInputPasswordIntoPasswordField() {
        login.fillPassword("secret_sauce");
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        login.clickLogin();
    }

    @Then("I am redirected to Products page")
    public void iAmRedirectedToPage() {
        login.productsPageIsLoaded();
    }

    @Then("proper password error message is displayed")
    public void properPasswordErrorMessageIsDisplayed() {
        login.errorMessageIsDisplayed();
    }
}
