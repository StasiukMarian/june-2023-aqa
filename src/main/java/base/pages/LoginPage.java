package base.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static base.helpers.Conditions.*;

public class LoginPage {
    private final SelenideElement usernameInput = $(By.xpath("//input[@placeholder='Username']"));
    private final SelenideElement passwordInput = $(By.xpath("//input[@placeholder='Password']"));
    private final SelenideElement submitButton = $(By.xpath("//input[@value='Login']"));


    public void typeUsername(String username) {
        usernameInput.shouldBe(inputCondition).append(username);
    }

    public void typePassword(String password) {
        passwordInput.shouldBe(inputCondition).append(password);
    }

    public void clickSubmit() {
        submitButton.shouldBe(clickableCondition).click();
    }
}
