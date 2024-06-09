package base.helpers;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.WebElementsCondition;

public class Conditions {
    public static WebElementCondition inputCondition = Condition.and("should be empty and visible", Condition.empty, Condition.visible);
    public static WebElementCondition clickableCondition = Condition.and("should be clickable", Condition.visible, Condition.enabled);
    public static WebElementsCondition collectionSizeCondition = CollectionCondition.size(6);
}
