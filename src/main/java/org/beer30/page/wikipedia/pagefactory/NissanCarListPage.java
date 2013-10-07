package org.beer30.page.wikipedia.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nissan Car List Page Page Object using Selenium PageFactory
 *
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 9:06 PM
 */
public class NissanCarListPage {
    private static final Logger log = LoggerFactory.getLogger(NissanCarListPage.class);
    private WebDriver webDriver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Nissan Skyline GT-R")
    private WebElement nissanSkylineLink;


    public NissanCarListPage(WebDriver webDriver) {
        log.info("Page  = {}", webDriver.getTitle());
        log.info("URL   = {}", webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if (!webDriver.getTitle().equals("List of Nissan vehicles - Wikipedia, the free encyclopedia")) {
            throw new IllegalStateException("Requested NissanCarListPage: current page - " + webDriver.getTitle());
        }

    }

    public NissanSkylinePage selectNissanSkyline() {
        nissanSkylineLink.click();

        return PageFactory.initElements(webDriver, NissanSkylinePage.class);
    }

}
