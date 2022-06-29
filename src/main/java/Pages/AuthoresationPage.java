package Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class AuthoresationPage {

    public static final String URL = "https://passport.yandex.ru";

    //login or email field
    @FindBy(how= How.ID, using = "passp-field-login")
    private SelenideElement nameField;

    //Enter button
    @FindBy(how= How.ID, using = "passp:sign-in")
    private  SelenideElement enterButton;

    //password field
    @FindBy(how = How.ID, using = "passp-field-passwd")
    private SelenideElement passwordField;

    //Not now button
    @FindBy(how = How.XPATH, using = "//button[@type='button']")
    private SelenideElement tapNotNowButton;

    //check authorisation
    @FindBy(how=How.CLASS_NAME, using = "personal-info-login")
    private SelenideElement result;

    @Step("set login")
    public AuthoresationPage setLogin() {
        nameField.sendKeys("testovish123");
        return page(AuthoresationPage.class);
    }

    @Step("tap on enter button")
    public AuthoresationPage tapEnterButton() {
        enterButton.click();
        return page(AuthoresationPage.class);
    }

    @Step("set password")
    public AuthoresationPage setPassword() {
        passwordField.sendKeys("Testovish123AS");
        return page(AuthoresationPage.class);
    }

    @Step("check success personal account")
    public boolean personalAccount(){
        result.shouldHave(text("testovish123")).shouldBe(visible, enabled);
        return true;
    }

}
