package lesson6;

import base.Pages;
import base.config.BaseTest;
import org.testng.annotations.Test;

public class FrameworkTest extends BaseTest {
    @Test
    public void test(){
        Pages.loginPage().typeUsername("standard_user");
        Pages.loginPage().typePassword("secret_sauce");
        Pages.loginPage().clickSubmit();
    }
}
