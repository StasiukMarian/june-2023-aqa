package base.pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static base.helpers.Conditions.*;

public class ShoppingCardPage {

    private final SelenideElement continueShopping = $(By.xpath("//button[@id='continue-shopping']"));

    public void clickContinueShopping() {
        continueShopping.shouldBe(clickableCondition).click();
    }
}
