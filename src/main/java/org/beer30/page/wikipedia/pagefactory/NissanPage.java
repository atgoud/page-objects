package org.beer30.page.wikipedia.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Nissan Page Page Object using Selenium PageFactory
 *
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 9:00 PM
 */
public class NissanPage {
    private static final Logger log = LoggerFactory.getLogger(NissanPage.class);
    private WebDriver webDriver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "List of Nissan vehicles")
    private WebElement nissanListOfCarsLink;


    public NissanPage(WebDriver webDriver) {
        log.info("Page  = {}", webDriver.getTitle());
        log.info("URL   = {}", webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if (!webDriver.getTitle().equals("Nissan Motor Company - Wikipedia, the free encyclopedia")) {
            throw new IllegalStateException("Requested NissanPage: current page - " + webDriver.getTitle());
        }

    }

    public NissanCarListPage selectListOfCars() {
        nissanListOfCarsLink.click();

        return PageFactory.initElements(webDriver, NissanCarListPage.class);
    }
}
