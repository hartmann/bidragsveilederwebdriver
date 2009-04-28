package no.nav.bidragsveileder.webtest.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * User: Vegard Hartmann
 * Date: 28.apr.2009
 * Time: 20:17:13
 */
public class InntektPage {
    private WebDriver driver;



    public enum Boforhold {
        ALENE("BOR_ALENE"),
        DELER("DELER_MED_ANDRE_VOKSNE");

        private final String id;

        Boforhold(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

    }

    public enum TrueFalse {
        TRUE("true"),
        FALSE("false");

        private final String id;

        TrueFalse(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

    }

    public enum Skatteklasse {
        SKATTEKLASSE_1("SKATTEKLASSE_1"),
        SKATTEKLASSE_2("SKATTEKLASSE_2");

        private final String id;

        Skatteklasse(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

    }

    @FindBy(how = How.NAME, using = "bidragsgiverOrdinaerInntekt")
    @CacheLookup
    private WebElement inntektBidragspliktig;

    @FindBy(how = How.NAME, using = "bidragsmottakerOrdinaerInntekt")
    @CacheLookup
    private WebElement inntektBidragsmottaker;

    @FindBy(how = How.XPATH, using = "//input[contains(@value,'videre')]")
    @CacheLookup
    private WebElement gaaVidereButton;

    public InntektPage(WebDriver driver) {
        this.driver = driver;
    }

    public void velgSkatteklasseBidragsmottaker(Skatteklasse skatteklasse) {
        WebElement radiobutton = driver.findElement(By.xpath("//input[(@value='" + skatteklasse + "') and (@name='bidragsmottakerSkatteklasseString')]"));
        radiobutton.setSelected();
    }

    public void velgUtvidetBarnetrygd(TrueFalse utvidetBarnetrygd) {
        WebElement radiobutton = driver.findElement(By.xpath("//input[(@value='" + utvidetBarnetrygd + "') and (@name='bidragsmottakerFaarUtvidetBarnetrygd')]"));
        radiobutton.setSelected();
    }

    public void registrerPersonInntektBidragspliktig(int inntekt) {
        inntektBidragspliktig.sendKeys(String.valueOf(inntekt));
    }

    public void velgSkatteklasseBidragspliktig(Skatteklasse skatteklasse) {
          WebElement radiobutton = driver.findElement(By.xpath("//input[(@value='" + skatteklasse + "') and (@name='bidragsgiverSkatteklasseString')]"));
        radiobutton.setSelected();
    }

    public void velgBoforhold(Boforhold boforhold) {
        WebElement radiobutton = driver.findElement(By.xpath("//input[@value='" + boforhold + "']"));
        radiobutton.setSelected();
    }

    public SamvaerPage gaaVidere() {
        gaaVidereButton.click();
        return PageMother.createSamvaerPage();
    }
    
    public void registrerPersonInntektBidragsmottaker(int inntekt) {
        inntektBidragsmottaker.sendKeys(String.valueOf(inntekt));
    }
}
