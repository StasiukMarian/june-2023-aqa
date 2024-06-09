package gui.lesson4;

import com.codeborne.selenide.*;
import base.config.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ConditionTest extends BaseTest {

    @Test
    public void checkBoxTest() {
        open("https://faculty.washington.edu/chudler/java/boxes.html");
        Selenide.sleep(3000);

//        $(By.xpath("//input[@type='checkbox'][1]")).click();
//        Assert.assertTrue($(By.xpath("//input[@type='checkbox'][1]")).is(Condition.checked), "checkbox is not checked");

        ElementsCollection checkBoxes = $$(By.xpath("//input[@type='checkbox']"));

        for (int i = 0; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
            Assert.assertTrue(checkBoxes.get(i).is(Condition.checked));
        }

    }


    //    @Test
    public void conditionTest() {

        WebElementCondition clickable = Condition.and("should be clickable", Condition.visible, Condition.enabled);

//        $(By.xpath("//input[@placeholder='Username']")).shouldNotBe(Condition.visible).append("standard_user");
        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.visible).append("standard_user");
        System.out.println($(By.xpath("//div[@id='root']")).is(Condition.exist));
//        $(By.xpath("//input[@placeholder='Username']")).shouldNotBe(Condition.readonly).append("standard_user");
//        $(By.xpath("//input[@placeholder='Username']")).shouldBe(Condition.empty).append("standard_user");

//        $(By.xpath("//input[@type='submit']")).shouldBe(Condition.enabled).click();
//        System.out.println($(By.xpath("//div[@id='root']")).is(Condition.visible));

//        $(By.xpath("//div[@class='loading_spinner']")).shouldBe(Condition.hidden, Duration.ofMillis(60000));

//        $(By.xpath("//input[@placeholder='Password']")).shouldHave(Condition.type("password")).shouldBe(Condition.empty).append("secret_sauce");
        $(By.xpath("//input[@placeholder='Password']")).shouldHave(Condition.id("password")).shouldBe(Condition.empty).append("secret_sauce");
//        $(By.xpath("//input[@type='submit']")).shouldHave(Condition.attribute("class", "submit-button btn_action")).shouldBe(clickable).click();
        $(By.xpath("//input[@type='submit']")).shouldHave(Condition.name("login-button")).shouldBe(clickable).click();
//        $(By.xpath("//input[@type='submit']")).shouldHave(Condition.value("Login")).shouldBe(clickable).click();

//        $(By.xpath("//input[@type='submit']")).shouldHave(Condition.type("submit")).shouldBe(clickable).click();

        Selenide.sleep(3000);

//        $(By.xpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(Condition.text("Sauce Labs Backpack")).click();
//        $(By.xpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(Condition.exactText("sauce labs backpack")).click();
//        $(By.xpath("(//div[@class='inventory_item_name '])[1]")).shouldHave(Condition.exactTextCaseSensitive("Sauce Labs Backpack")).click();


//        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldBe(CollectionCondition.empty);
        List<String> itemHeadersList = $$(By.xpath("//div[@class='inventory_item_name ']")).texts();
        ElementsCollection itemsList = $$(By.xpath("//div[@class='inventory_item_name ']"));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.size(6));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeNotEqual(0));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeLessThan(7));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeLessThanOrEqual(6));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeGreaterThan(5));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(6));

        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.texts("Backpack", "Light", "Bolt", "fleece", "Onesie", "red"));
        $$(By.xpath("//div[@class='inventory_item_name ']")).shouldHave(CollectionCondition.textsInAnyOrder("Backpack", "Light", "Bolt", "fleece", "red", "onesie"));


        List<String> expectedItemHeadersList = new ArrayList<>();
        expectedItemHeadersList.add("Sauce Labs Backpack");
        expectedItemHeadersList.add("Sauce Labs Bike Light");
        expectedItemHeadersList.add("Sauce Labs Bolt T-Shirt");
        expectedItemHeadersList.add("Sauce Labs Fleece Jacket");
        expectedItemHeadersList.add("Sauce Labs Onesie");
        expectedItemHeadersList.add("Test.allTheThings() T-Shirt (Red)");


        Assert.assertEquals(itemHeadersList.get(1), "Sauce Labs Bike Light", "Values are not equals");
        Assert.assertEquals(itemHeadersList, expectedItemHeadersList, "Lists are not equals");

        Assert.assertFalse(itemsList.isEmpty());

        Assert.assertTrue(itemHeadersList.contains("Sauce Labs Bike Light"));
    }

}
