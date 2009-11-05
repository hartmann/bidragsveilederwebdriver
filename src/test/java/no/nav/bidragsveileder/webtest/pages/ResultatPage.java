package no.nav.bidragsveileder.webtest.pages;

import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * User: Vegard Hartmann
 * Date: 28.apr.2009
 * Time: 20:50:17
 */
public class ResultatPage {

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'detaljertBeregning')]")
    @CacheLookup
    private RenderedWebElement detaljertUtregningLink;

    public boolean isCurrentPage() {
        return detaljertUtregningLink.isDisplayed();
    }
}
