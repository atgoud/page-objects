package org.beer30.page.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 8:24 PM
 */
public class HomePage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);
    private WebDriver webDriver;
    private WebElement privacyPolicyLink;
    private WebElement searchBox;
    private WebElement submitButton;

    public HomePage(WebDriver webDriver) {
        log.info("Page  = {}",webDriver.getTitle());
        log.info("URL   = {}",webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if(!webDriver.getTitle().equals("Wikipedia")){
            throw new IllegalStateException("Requested HomePage: current page - " + webDriver.getTitle());
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
