package no.nav.bidragsveileder.webtest;

/**
 * User: Vegard Hartmann
 * Date: 28.apr.2009
 * Time: 19:24:58
 */
public class BidragsveilederWebTest {

    public void bidragsveilederEnkeltTilfelle() {
        //bla igjennom letteste måte
        //fødselsdato 01.01.2001
        //ingen utgifter til barnetilsyn

        //personinntekt 250000
        //skatteklasse 2
        //ikke utvidet barnetrygd
        //bidragspliktig inntekt 300000
        //skatteklasse 1
        //bor alene

        //0-1 netter samvær

    }

    public void skalViseFeilmeldingDersomFodselsdatoIkkeOppgis() {
        //gå videre
    }

    public void skalViseHjelpetekstForBarnetsFodselsdato() {
        //klikk ikon for hjelpetekst
    }

    public void visInformasjonOmBeregningAvUnderholdskostnad() {
        //klikk link for å vise informasjon
    }

    public void skalFylleInnTilsynsutgifterForToBarn() {
        //har utgifter
        //mottar ikke stønad til barnetilsyn
        //verifiser textinput tilstede
        //verifiser dropdown tilstede
    }

    public void skalKunneEndreTidligereSteg() {
        //bla gjennom til steg4
        //gå tilbake til hvert enkelt tidligere steg
    }

}
