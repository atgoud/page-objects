package org.beer30.page.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 9:06 PM
 */
public class NissanCarListPage {
    private static final Logger log = LoggerFactory.getLogger(NissanCarListPage.class);
    private WebDriver webDriver;
    private WebElement nissanSkylineLink;


    public NissanCarListPage(WebDriver webDriver) {
        log.info("Page  = {}",webDriver.getTitle());
        log.info("URL   = {}",webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if(!webDriver.getTitle().equals("List of Nissan vehicles - Wikipedia, the free encyclopedia")){
            throw new IllegalStateException("Requested NissanCarListPage: current page - " + webDriver.getTitle());
        }

        //Initialize WebElements
        nissanSkylineLink = webDriver.findElement(By.partialLinkText("Nissan Skyline GT-R"));
    }

    public NissanSkylinePage selectNissanSkyline() {
        nissanSkylineLink.click();

        return new NissanSkylinePage(webDriver);
    }

}
