package base.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static base.helpers.Conditions.*;
public class BurgerMenuPage {
    private final SelenideElement logoutButton = $(By.xpath("//a[text()='Logout']"));

    public void clickLogout(){
        logoutButton.shouldBe(clickableCondition).click();
    }
}
