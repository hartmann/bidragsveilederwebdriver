package no.nav.bidragsveileder.webtest;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import no.nav.bidragsveileder.webtest.pages.*;
import static no.nav.bidragsveileder.webtest.pages.UnderholdskostnadPage.UtgifterBarnetilsyn.HAR_IKKE_UTGIFTER_TIL_BARNETILSYN;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * User: Vegard Hartmann
 * Date: 28.apr.2009
 * Time: 19:24:58
 */
public class BidragsveilederWebTest {

    private WebDriver driver;

    private static final String START_PAGE = "http://tjenester.nav.no/bidragsveileder/steg1.action";

    @Before
    public void setup() {
        driver = new FirefoxDriver();
//        HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver();
//        htmlUnitDriver.setJavascriptEnabled(true);
//        driver = htmlUnitDriver;
        PageMother.setDriver(driver);
        driver.get(START_PAGE);
    }

    @Test
    public void bidragsveilederEnkeltTilfelle() {
        UnderholdskostnadPage underholdskostnadPage = PageMother.createUnderholdskostnadPage();
        underholdskostnadPage.registrerBarnetsFodselsdato("01.01.2001");
        underholdskostnadPage.velgUtgifterTilBarnetilsyn(HAR_IKKE_UTGIFTER_TIL_BARNETILSYN);
        InntektPage inntektPage = underholdskostnadPage.gaaVidere();

        inntektPage.registrerPersonInntektBidragsmottaker(250000);
        inntektPage.velgSkatteklasseBidragsmottaker(InntektPage.Skatteklasse.SKATTEKLASSE_2);
        inntektPage.velgUtvidetBarnetrygd(InntektPage.TrueFalse.FALSE);
        inntektPage.registrerPersonInntektBidragspliktig(300000);
        inntektPage.velgSkatteklasseBidragspliktig(InntektPage.Skatteklasse.SKATTEKLASSE_1);
        inntektPage.velgBoforhold(InntektPage.Boforhold.ALENE);
        SamvaerPage samvaerPage = inntektPage.gaaVidere();

        ResultatPage resultatPage = samvaerPage.gaaVidere();

        assertTrue(resultatPage.isCurrentPage());
    }

    @Test
    public void skalViseFeilmeldingDersomFodselsdatoIkkeOppgis() {
        UnderholdskostnadPage underholdskostnadPage = PageMother.createUnderholdskostnadPage();
        underholdskostnadPage.gaaVidereMedValideringsfeil();
        assertTrue(underholdskostnadPage.isCurrentPage());
        assertTrue(underholdskostnadPage.isErrorMessagesDisplayed());
    }

    @Test
    public void skalViseHjelpetekstForBarnetsFodselsdato() {
        UnderholdskostnadPage underholdskostnadPage = PageMother.createUnderholdskostnadPage();
        assertFalse(underholdskostnadPage.isHelptextDisplayed());
        underholdskostnadPage.visHjelpForBarnetsFodselsdato();
        assertTrue(underholdskostnadPage.isHelptextDisplayed());
    }

    public void visInformasjonOmBeregningAvUnderholdskostnad() {
        //klikk link for � vise informasjon
    }

    public void skalFylleInnTilsynsutgifterForToBarn() {
        //har utgifter
        //mottar ikke st�nad til barnetilsyn
        //verifiser textinput tilstede
        //verifiser dropdown tilstede
    }

    public void skalKunneEndreTidligereSteg() {
        //bla gjennom til steg4
        //g� tilbake til hvert enkelt tidligere steg
    }

    @After
    public void teardown() {
        driver.close();
    }

}
