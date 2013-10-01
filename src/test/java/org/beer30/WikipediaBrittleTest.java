package org.beer30;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 7:57 PM
 */
public class WikipediaBrittleTest {
    private static final Logger log = LoggerFactory.getLogger(WikipediaBrittleTest.class);


    @Test
    public void testWikipediaBrittle() {
        WebDriver webDriver = new HtmlUnitDriver();

        log.info("Requesting HomePage");
        webDriver.get("http://www.wikipedia.org");
        Assert.assertEquals("Wikipedia",webDriver.getTitle());

        log.info("Requesting Privacy Policy");
        WebElement privacyPolicyLink = webDriver.findElement(By.partialLinkText("Privacy Policy"));
        privacyPolicyLink.click();
        Assert.assertEquals("Privacy policy - Wikimedia Foundation", webDriver.getTitle());

        // If I go back I should be at the home page again
        log.info("Hitting the Back button");
        webDriver.navigate().back();
        Assert.assertEquals("Wikipedia", webDriver.getTitle());

        // Search for Nissan
        log.info("Looking up Nissan Motor Company");
        WebElement searchBox = webDriver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Nissan Motor Company");
        WebElement submitButton = webDriver.findElement(By.name("go"));
        submitButton.submit();
        Assert.assertEquals("Nissan Motor Company - Wikipedia, the free encyclopedia", webDriver.getTitle());

        // Goto the List of Nissan Cars
        log.info("Clicking List of Nissan Cars");
        WebElement nissanListOfCarsLink = webDriver.findElement(By.partialLinkText("List of Nissan vehicles"));
        nissanListOfCarsLink.click();
        Assert.assertEquals("List of Nissan vehicles - Wikipedia, the free encyclopedia", webDriver.getTitle());

        // Finnaly goto the Nissan Skyline GT-R Page
        log.info("Clicking Skyline GT-R");
        WebElement nissanSkylineLink = webDriver.findElement(By.partialLinkText("Nissan Skyline GT-R"));
        nissanSkylineLink.click();
        Assert.assertEquals("Nissan Skyline GT-R - Wikipedia, the free encyclopedia", webDriver.getTitle());

        webDriver.quit();

    }
}
