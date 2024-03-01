package lesson7;

import base.Pages;
import base.config.BaseTest;
import base.pages.Item;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VarArgsTest extends BaseTest {

    @Test
    public void test(){
        Pages.loginPage().typeUsername("standard_user");
        Pages.loginPage().typePassword("secret_sauce");
        Pages.loginPage().clickSubmit();

        Pages.mainPage().waitUntilMainPage();

        List<Item> itemListFromMainPage = Pages.mainPage().getItemList();
        for (int i = 1; i <= itemListFromMainPage.size(); i++) {
            Pages.mainPage().clickHeaderByID(i);

            Item detailedItem = Pages.detailsItemPage().getDetailedItem();

            Assert.assertTrue(itemListFromMainPage.contains(detailedItem), "item is not presents in the list of items");

            Pages.detailsItemPage().clickBackToProducts();
        }

//        System.out.println(Pages.mainPage().getElementHeaderByID(5));

//        Pages.mainPage().clickHeaderByName("Sauce Labs Bolt T-Shirt");
    }

//    @Test
    public void test2(){
        Pages.loginPage().typeUsername("standard_user");
        Pages.loginPage().typePassword("secret_sauce");
        Pages.loginPage().clickSubmit();

        Pages.mainPage().waitUntilMainPage();

        Pages.mainPage().clickBurgerMenuButton();

        Pages.burgerMenuPage().clickLinkByID(3);
    }
}
