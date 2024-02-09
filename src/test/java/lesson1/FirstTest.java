package lesson1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.$;

public class FirstTest extends BaseTest{

    //    @BeforeMethod
//    public void beforeMethodTest(){
//        System.out.println("This method works before every methods class");
//    }
//    @AfterMethod
//    public void afterMethodTest(){
//        System.out.println("This method works after every methods class");
//    }

    @Test
    public void test(){
        System.out.println("test");
    }


//    @AfterClass
//    public void afterClassTest() {
//        System.out.println("This method works after test class");
//    }
}
