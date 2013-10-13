package org.beer30.page.wikipedia.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Home Page implemented using pure Page Object pattern (No Helpers)
 *
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 8:24 PM
 */
// This is the Home Page Class which when created (When the test is ran) becomes a Page Object
public class HomePage {
    // This is a logging utility. Used to log to a file and/or the screen
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    // This is the Object that acts as a web browser when using Html Unit
    // or the thing that "drives" a real web browser like Firefox
    private WebDriver webDriver;

    // These are elements (Links, Input Boxes, etc) on this page that I need to use
    private WebElement privacyPolicyLink;
    private WebElement searchBox;
    private WebElement submitButton;

    // Constructor of this Page Object
    public HomePage(WebDriver webDriver) {
        log.info("Page  = {}", webDriver.getTitle());
        log.info("URL   = {}", webDriver.getCurrentUrl());
        this.webDriver = webDriver;

        // Test that the page that the page we are on is actually the Wikipedia Home Page.
        // We know that we are on the home page if the title matches the single word
        // "Wikipedia" and nothing else
        if (!webDriver.getTitle().equals("Wikipedia")) {
            throw new IllegalStateException
                    ("Requested HomePage: current page - " + webDriver.getTitle());
        }

        //Initialize WebElements
        privacyPolicyLink = webDriver.findElement(By.partialLinkText("Privacy Policy"));
        searchBox = webDriver.findElement(By.id("searchInput"));
        submitButton = webDriver.findElement(By.name("go"));
    }

    public PrivacyPolicyPage clickPrivacyPolicyLink() {
        privacyPolicyLink.click();

        return new PrivacyPolicyPage(webDriver);
    }

    public NissanPage searchForNissan() {
        searchBox.sendKeys("Nissan Motor Company");
        submitButton.submit();

        return new NissanPage(webDriver);
    }
}
