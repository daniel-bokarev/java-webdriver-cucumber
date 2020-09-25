package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginPage {

    protected String url;
    protected String productsUrl;
    protected String title;

    public LoginPage() {
        url = "https://www.saucedemo.com/";
        productsUrl = "https://www.saucedemo.com/inventory.html";
        title = "Swag Labs";
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement error;

    public void open() {
        getDriver().get(url);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorText() {
        return error.getText();
    }

    public void productsPageIsLoaded() {
        String page = getDriver().getCurrentUrl();
        assertThat(page).isEqualTo(productsUrl);
    }

    public void errorMessageIsDisplayed() {
        assertThat(error.isDisplayed());
    }

}
