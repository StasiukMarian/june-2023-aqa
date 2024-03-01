package base;

import base.pages.*;

public class Pages {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static ShoppingCardPage shoppingCardPage;
    public static BurgerMenuPage burgerMenuPage;
    public static DetailsItemPage detailsItemPage;

    /*this method returns instance of LoginPage*/
    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public static ShoppingCardPage shoppingCardPage() {
        if (shoppingCardPage == null) {
            shoppingCardPage = new ShoppingCardPage();
        }
        return shoppingCardPage;
    }

    public static BurgerMenuPage burgerMenuPage() {
        if (burgerMenuPage == null) {
            burgerMenuPage = new BurgerMenuPage();
        }
        return burgerMenuPage;
    }

    public static DetailsItemPage detailsItemPage() {
        if (detailsItemPage == null) {
            detailsItemPage = new DetailsItemPage();
        }
        return detailsItemPage;
    }
}
