package org.beer30.page.wikipedia;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 9:09 PM
 */
public class NissanSkylinePage {
    private static final Logger log = LoggerFactory.getLogger(NissanSkylinePage.class);
    private WebDriver webDriver;

    public NissanSkylinePage(WebDriver webDriver) {
        log.info("Page  = {}",webDriver.getTitle());
        log.info("URL   = {}",webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if(!webDriver.getTitle().equals("Nissan Skyline GT-R - Wikipedia, the free encyclopedia")){
            throw new IllegalStateException("Requested NissanSkylinePage: current page - " + webDriver.getTitle());
        }

        //Initialize WebElements
    }
}
