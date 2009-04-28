package no.nav.bidragsveileder.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * User: Vegard Hartmann
 * Date: 28.apr.2009
 * Time: 20:00:45
 */
public class PageMother {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        PageMother.driver = driver;
    }

    public static UnderholdskostnadPage createUnderholdskostnadPage() {
        UnderholdskostnadPage underholdskostnadPage = new UnderholdskostnadPage(driver);
        PageFactory.initElements(driver, underholdskostnadPage);
        return underholdskostnadPage;
    }

    public static InntektPage createInntektPage() {
        InntektPage inntektPage = new InntektPage(driver);
        PageFactory.initElements(driver, inntektPage);
        return inntektPage;
    }

    public static SamvaerPage createSamvaerPage() {
        return PageFactory.initElements(driver, SamvaerPage.class);
    }

    public static ResultatPage createResultatPage() {
        return PageFactory.initElements(driver, ResultatPage.class);
    }
}
