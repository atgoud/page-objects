package org.beer30;

import org.beer30.page.wikipedia.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 8:25 PM
 */
public class WikipediaPageObjectTest {
    private static final Logger log = LoggerFactory.getLogger(WikipediaPageObjectTest.class);


    @Test
    public void testWikipedia() {
        WebDriver webDriver = new HtmlUnitDriver();

        log.info("Requesting HomePage");
        webDriver.get("http://www.wikipedia.org");
        HomePage homePage = new HomePage(webDriver);
        Assert.assertNotNull(homePage);

        log.info("Requesting Privacy Policy");
        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacyPolicyLink();
        Assert.assertNotNull(privacyPolicyPage);

        // If I go back I should be at the home page again
        log.info("Hitting the Back button");
        webDriver.navigate().back();
        HomePage homePageAfterBack = new HomePage(webDriver);
        Assert.assertNotNull(homePageAfterBack);

        // Search for Nissan
        log.info("Looking up Nissan Motor Company");
        NissanPage nissanPage = homePageAfterBack.searchForNissan();
        Assert.assertNotNull(nissanPage);

        // Goto the List of Nissan Cars
        log.info("Clicking List of Nissan Cars");
        NissanCarListPage nissanCarListPage = nissanPage.selectListOfCars();
        Assert.assertNotNull(nissanCarListPage);

        // Finnaly goto the Nissan Skyline GT-R Page
        log.info("Clicking Skyline GT-R");
        NissanSkylinePage nissanSkylinePage = nissanCarListPage.selectNissanSkyline();
        Assert.assertNotNull(nissanSkylinePage);

        webDriver.quit();

    }
}
