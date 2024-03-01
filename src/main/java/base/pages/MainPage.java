package base.pages;

import base.config.PageTools;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static base.helpers.Conditions.*;

public class MainPage extends PageTools {
    private final SelenideElement logo = $(By.xpath("//div[@class='app_logo']"));
    private final SelenideElement shoppingCard = $(By.xpath("//a[@class='shopping_cart_link']"));
    private final SelenideElement twitterButton = $(By.xpath("//a[text()='Twitter']"));
    private final SelenideElement burgerMenu = $(By.xpath("//button[text()='Open Menu']"));

    // waiters
    public void waitUntilMainPage() {
        logo.shouldBe(Condition.visible, Duration.ofMillis(20000));
    }

    private final ElementsCollection itemHeaders = $$(By.xpath("//div[@class='inventory_item_name ']"));
    private final ElementsCollection buttons = $$(By.xpath("//button[text()='Add to cart']"));

    private final By headers = By.xpath("//div[@class='inventory_item_name ']");
    private final By descriptions = By.xpath("//div[@class='inventory_item_desc']");
    private final By prices = By.xpath("//div[@class='inventory_item_price']");
    private final By headerByName = By.xpath("//div[text()='%s']");
    private final By headerByID = By.xpath("(//div[@class='inventory_item_name '])[%d]");

    //getters
    public ElementsCollection getItemHeaders() {
        return itemHeaders.shouldBe(collectionSizeCondition);
    }

    public List<String> getItemHeadersTexts() {
        return itemHeaders.shouldBe(collectionSizeCondition).texts();
    }

    public ElementsCollection getButtons() {
        return buttons.shouldBe(collectionSizeCondition);
    }

    //clickers
    public void clickShoppingCard() {
        shoppingCard.shouldBe(clickableCondition).click();
    }

    public void clickTwitterButton() {
        twitterButton.shouldBe(clickableCondition).click();
    }

    public void clickBurgerMenuButton() {
        burgerMenu.shouldBe(clickableCondition).click();
    }

    public List<Item> getItemList() {
        List<Item> itemList = new ArrayList<>();

        List<String> headersList = getElementsText(headers);
        List<String> descriptionsList = getElementsText(descriptions);
        List<String> pricesList = getElementsText(prices);

        for (int i = 0; i < headersList.size(); i++) {
            Item item = new Item();

            item.setName(headersList.get(i));
            item.setDescription(descriptionsList.get(i));
            item.setPrice(pricesList.get(i));

            itemList.add(item);
        }
        return itemList;
    }

    public void clickHeaderByName(String name){
        click(headerByName, name);
    }

    public String getElementHeaderByID(int id){
        return getElementText(headerByID, id);
    }
    public void clickHeaderByID(int id){
        click(headerByID, id);
    }
}
