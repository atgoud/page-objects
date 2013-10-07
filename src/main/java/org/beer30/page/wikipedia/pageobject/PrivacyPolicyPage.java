package org.beer30.page.wikipedia.pageobject;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Privacy Policy Page implemented using pure Page Object pattern (No Helpers)
 *
 * @author tsweets
 *         Date: 9/30/13
 *         Time: 8:35 PM
 */
public class PrivacyPolicyPage {
    private static final Logger log = LoggerFactory.getLogger(PrivacyPolicyPage.class);
    private WebDriver webDriver;

    public PrivacyPolicyPage(WebDriver webDriver) {
        log.info("Page  = {}", webDriver.getTitle());
        log.info("URL   = {}", webDriver.getCurrentUrl());
        this.webDriver = webDriver;
        if (!webDriver.getTitle().equals("Privacy policy - Wikimedia Foundation")) {
            throw new IllegalStateException("Requested PrivacyPolicyPage: current page - " + webDriver.getTitle());
        }
    }
}
