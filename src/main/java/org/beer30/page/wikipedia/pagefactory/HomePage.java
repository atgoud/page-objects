package org.beer30.page.wikipedia.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Home Page Page Object using Selenium PageFactory
 *
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 8:24 PM
 */
public class HomePage {
    private static final Logger log = LoggerFactory.getLogger(HomePage.class);
    private WebDriver webDriver;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Privacy Policy")
    private WebElement privacyPolicyLink;
    @FindBy(how = How.ID, using = "searchInput")
    private WebElement searchBox;
    @FindBy(how = How.NAME, using = "go")
    private WebElement submitButton;

    public HomePage(WebDriver webDriver) {
        log.info("Page  = {}", webDriver.getTitle());
        log.info("URL   = {}", webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if (!webDriver.getTitle().equals("Wikipedia")) {
            throw new IllegalStateException("Requested HomePage: current page - " + webDriver.getTitle());
        }

    }


    public PrivacyPolicyPage clickPrivacyPolicyLink() {
        privacyPolicyLink.click();
        return PageFactory.initElements(webDriver, PrivacyPolicyPage.class);
    }

    public NissanPage searchForNissan() {
        searchBox.sendKeys("Nissan Motor Company");
        submitButton.submit();
        return PageFactory.initElements(webDriver, NissanPage.class);
    }
}
