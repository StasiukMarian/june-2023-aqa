package org.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeClass
    public void configuration(){
        Configuration.browser = "chrome"; // edge/firefox/ie
        Configuration.browserSize = "1280x920";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
    }
    @BeforeMethod
    public void setUp(){
        Selenide.open("https://www.google.com");
    }
    @AfterMethod
    public void cleanWebDriver(){
        Selenide.clearBrowserCookies();
        Selenide.refresh();
        Selenide.open("about:blank");
    }
    @AfterClass
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
