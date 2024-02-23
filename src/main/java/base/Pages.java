package base;

import base.pages.BurgerMenuPage;
import base.pages.LoginPage;
import base.pages.MainPage;
import base.pages.ShoppingCardPage;

public class Pages {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static ShoppingCardPage shoppingCardPage;
    public static BurgerMenuPage burgerMenuPage;

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
}
