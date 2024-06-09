package base.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    @BeforeClass
    public void configuration() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x920";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @BeforeMethod
    public void setUp() {
        // https://www.stats.govt.nz/large-datasets/csv-files-for-download/ - URL TO DOWNLOAD FILE
        // https://ps.uci.edu/~franklin/doc/file_upload.html - URL TO UPLOAD FILE
        // https://checkcps.com/double-click/ - URL TO DOUBLE CLICK
        // https://faculty.washington.edu/chudler/java/boxes.html - URL WITH CHECKBOXES

        Selenide.open("https://www.saucedemo.com");
    }

    //    @AfterMethod
//    public void cleanWebDriver(){
//        Selenide.clearBrowserCookies();
//        Selenide.refresh();
//        Selenide.open("about:blank");
//    }
    @AfterClass
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
