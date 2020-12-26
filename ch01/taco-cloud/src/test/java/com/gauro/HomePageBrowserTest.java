package com.gauro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

/**
 * @author Chandra
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {

    @LocalServerPort
    private int port;

    private  HtmlUnitDriver browser;

    @BeforeEach
    void setup() {
        System.out.println("Setup is called========>");
        browser = new HtmlUnitDriver();

        browser.manage().timeouts()
                .implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown() {
        browser.quit();
    }

    @Test
    public void testHomePage() {
        String homePage = "http://localhost:" + port;
        System.out.println("=======homePage=========");
        System.out.println(homePage);
        browser.get(homePage);

         String title=browser.getTitle();
         Assert.assertEquals("Taco Cloud",title);

         String h1Test=browser.findElementByTagName("h1").getText();
         Assert.assertEquals("Welcome to...",h1Test);

         String imgsrc=browser.findElementByTagName("img").getAttribute("src");
         Assert.assertEquals(homePage+"/images/TacoCloud.png",imgsrc);




    }
}
