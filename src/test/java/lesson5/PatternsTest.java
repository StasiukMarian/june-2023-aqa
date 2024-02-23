package lesson5;

import base.Pages;
import base.config.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class PatternsTest extends BaseTest {
    String username = "standard_user";
    String password = "secret_sauce";

    @Test
    public void pattern() {
        Pages.loginPage().typeUsername(username);
        Pages.loginPage().typePassword(password);
        Pages.loginPage().clickSubmit();

        Pages.mainPage().waitUntilMainPage();

//        List<String> itemHeadersTextsList = Pages.mainPage().getItemHeadersTexts();
//
//        System.out.println(itemHeadersTextsList);
//
//        Pages.mainPage().getButtons().get(3).click();
//
//        Pages.mainPage().clickShoppingCard();
//
//        Pages.shoppingCardPage().clickContinueShopping();
//
//        ElementsCollection itemHeaders = Pages.mainPage().getItemHeaders();
//
//        itemHeaders.get(1).click();


        Pages.mainPage().clickTwitterButton();

        Selenide.switchTo().window(1);

        Selenide.sleep(5000);

        Assert.assertTrue($(By.xpath("//span[text()='Sauce Labs']")).is(Condition.visible));

        Selenide.closeWindow();

        Selenide.switchTo().window(0);

        Pages.mainPage().clickBurgerMenuButton();

        Pages.burgerMenuPage().clickLogout();



//        actions().keyDown(Keys.CONTROL)  open new tab from the keyboard
//                .sendKeys("t")
//                .keyUp(Keys.CONTROL)
//                .build()
//                .perform();
    }
}