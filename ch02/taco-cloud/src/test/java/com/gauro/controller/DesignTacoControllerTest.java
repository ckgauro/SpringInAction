package com.gauro.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chandra
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DesignTacoControllerTest {

    private static HtmlUnitDriver browser;

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate rest;

    @BeforeEach
    void setUp() {
        browser=new HtmlUnitDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
        browser.quit();
    }

    @Test
    public void testDesignATacoPage_HappyPath() throws Exception {
        browser.get(homePageUrl());
        clickDesignATaco();

    }

    //
    // Browser test action methods
    //
    private void clickDesignATaco() {
        assertEquals(homePageUrl(), browser.getCurrentUrl());
        browser.findElementByCssSelector("a[id='design']").click();
    }
    private void clickBuildAnotherTaco() {
        assertTrue(browser.getCurrentUrl().startsWith(orderDetailsPageUrl()));
        browser.findElementByCssSelector("a[id='another']").click();

    }
    //
    // URL helper methods
    //
    private String designPageUrl() {
        return homePageUrl() + "design";
    }

    private String homePageUrl() {
        return "http://localhost:" + port + "/";
    }

    private String orderDetailsPageUrl() {
        return homePageUrl() + "orders";
    }

    private String currentOrderDetailsPageUrl() {
        return homePageUrl() + "orders/current";
    }
}