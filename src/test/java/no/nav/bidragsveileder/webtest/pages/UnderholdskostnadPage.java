package no.nav.bidragsveileder.webtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.How;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;

/**
 * User: Vegard Hartmann
 * Date: 28.apr.2009
 * Time: 20:03:21
 */
public class UnderholdskostnadPage {
    private WebDriver driver;

    public enum UtgifterBarnetilsyn {
        HAR_UTGIFTER_TIL_BARNETILSYN("steg2_bidragsmottakerHarUtgiftertrue"),
        HAR_IKKE_UTGIFTER_TIL_BARNETILSYN("steg2_bidragsmottakerHarUtgifterfalse");

        private final String id;

        UtgifterBarnetilsyn(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

    }



    @FindBy(how = How.NAME, using = "barnetsFodselsdatoString")
    @CacheLookup
    private WebElement barnetsFodselsdato;

    @FindBy(how = How.XPATH, using = "//input[contains(@value,'videre')]")
    @CacheLookup
    private WebElement gaaVidereButton;

    public UnderholdskostnadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registrerBarnetsFodselsdato(String fodselsdato) {
        barnetsFodselsdato.sendKeys(fodselsdato);
    }

    public void velgUtgifterTilBarnetilsyn(UtgifterBarnetilsyn utgifterBarnetilsyn) {
        WebElement radiobutton = driver.findElement(By.xpath("//input[@id='" + utgifterBarnetilsyn + "']"));
        radiobutton.setSelected();
    }

    public InntektPage gaaVidere() {
        gaaVidereButton.click();
        return PageMother.createInntektPage();
    }
}
