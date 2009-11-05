package no.nav.bidragsveileder.webtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * User: Vegard Hartmann
 * Date: 28.apr.2009
 * Time: 20:46:30
 */
public class SamvaerPage {

    @FindBy(how = How.XPATH, using = "//input[contains(@value,'videre')]")
    @CacheLookup
    private WebElement gaaVidereButton;

    public ResultatPage gaaVidere() {
        gaaVidereButton.click();
        return PageMother.createResultatPage();
    }
}
