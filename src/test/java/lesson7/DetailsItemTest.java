package lesson7;

import base.Pages;
import base.config.BaseTest;
import base.pages.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DetailsItemTest extends BaseTest {

    @Test
    public void detailsTest() {
        Pages.loginPage().typeUsername("standard_user");
        Pages.loginPage().typePassword("secret_sauce");
        Pages.loginPage().clickSubmit();

        Pages.mainPage().waitUntilMainPage();

        List<Item> itemListFromMainPage = Pages.mainPage().getItemList();

        Pages.mainPage().getItemHeaders().get(5).click();

        Item detailedItem = Pages.detailsItemPage().getDetailedItem();

        Assert.assertTrue(itemListFromMainPage.contains(detailedItem), "item is not presents in the list of items");
    }
}
