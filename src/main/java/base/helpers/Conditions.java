package base.helpers;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

public class Conditions {
    public static Condition inputCondition = Condition.and("should be empty and visible", Condition.empty, Condition.visible);
    public static Condition clickableCondition = Condition.and("should be clickable", Condition.visible, Condition.enabled);
    public static CollectionCondition collectionSizeCondition = CollectionCondition.size(6);
}
