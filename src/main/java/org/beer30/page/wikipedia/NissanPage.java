package org.beer30.page.wikipedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 9:00 PM
 */
public class NissanPage {
    private static final Logger log = LoggerFactory.getLogger(NissanPage.class);
    private WebDriver webDriver;
    private WebElement nissanListOfCarsLink;


    public NissanPage(WebDriver webDriver) {
        log.info("Page  = {}",webDriver.getTitle());
        log.info("URL   = {}",webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if(!webDriver.getTitle().equals("Nissan Motor Company - Wikipedia, the free encyclopedia")){
            throw new IllegalStateException("Requested NissanPage: current page - " + webDriver.getTitle());
        }

        //Initialize WebElements
        nissanListOfCarsLink = webDriver.findElement(By.partialLinkText("List of Nissan vehicles"));
    }

    public NissanCarListPage selectListOfCars() {
        nissanListOfCarsLink.click();

        return new NissanCarListPage(webDriver);
    }
}
