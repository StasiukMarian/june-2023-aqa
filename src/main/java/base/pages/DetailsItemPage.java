package base.pages;

import base.config.PageTools;
import org.openqa.selenium.By;

public class DetailsItemPage extends PageTools {

    private final By header = By.xpath("//div[contains(@class,'inventory_details_name')]");
    private final By description = By.xpath("(//div[contains(@class,'inventory_details_desc')])[2]");
    private final By price = By.xpath("//div[@class='inventory_details_price']");
    private final By backToProducts = By.xpath("//button[text()='Back to products']");
    public Item getDetailedItem() {
        Item item = new Item();

        item.setName(getElementText(header));
        item.setDescription(getElementText(description));
        item.setPrice(getElementText(price));
        return item;
    }
    public void clickBackToProducts(){
        click(backToProducts);
    }
}
