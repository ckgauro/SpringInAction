package com.gauro.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Chandra
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeControllerTest2 {

    @LocalServerPort
    private int port;

    private static HtmlUnitDriver browser;

    @BeforeEach
    void setUp() {
        System.out.println("Setup is called========>");
        browser = new HtmlUnitDriver();

        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void testHomePage() {

    }
}