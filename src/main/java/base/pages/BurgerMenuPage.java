package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static base.helpers.Conditions.*;
public class BurgerMenuPage extends PageTools {
    private final SelenideElement logoutButton = $(By.xpath("//a[text()='Logout']"));
    private final By linkByID = By.xpath("//div[@class='bm-menu']//a[%d]");

    public void clickLogout(){
        logoutButton.shouldBe(clickableCondition).click();
    }

    public void clickLinkByID(int id){
        click(linkByID, id);
    }
}
