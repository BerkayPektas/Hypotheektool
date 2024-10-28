package nl.rocnijmegen.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HypotheekBerekeningMetStudieschuldTest {

    // Test voor het berekenen van de maximale hypotheek met een studieschuld
    @Test
    public void testMaximaleHypotheekMetStudieschuld() {
        HypotheekBerekeningMetStudieschuld hypotheekBerekening = new HypotheekBerekeningMetStudieschuld();
        double jaarinkomen = 50000;

        // Verwacht maximaal leenbedrag zonder studieschuld
        double verwachtMaximaalLeenbedragZonderStudieschuld = hypotheekBerekening.berekenMaximaleHypotheek(jaarinkomen);

        // Verlaag het leenbedrag met 25% omdat de gebruiker een studieschuld heeft
        double verwachtMaximaalLeenbedragMetStudieschuld = verwachtMaximaalLeenbedragZonderStudieschuld * 0.75;

        // Simuleer de berekening van de maximale hypotheek met studieschuld
        double maximaalLeenbedrag = hypotheekBerekening.berekenMaximaleHypotheekMetStudieschuld(jaarinkomen, true);

        // Controleer of het berekende bedrag met studieschuld klopt
        assertEquals(verwachtMaximaalLeenbedragMetStudieschuld, maximaalLeenbedrag, 0.01);
    }

    // Test voor het berekenen van de maandlasten met een studieschuld
    @Test
    public void testMaandlastenMetStudieschuld() {
        HypotheekBerekeningMetStudieschuld hypotheekBerekening = new HypotheekBerekeningMetStudieschuld();
        double jaarinkomen = 50000;
        double rentepercentage = 5.0;
        int looptijdInJaren = 30;

        // Bereken het maximaal leenbedrag met studieschuld
        double maximaalLeenbedrag = hypotheekBerekening.berekenMaximaleHypotheekMetStudieschuld(jaarinkomen, true);

        // Bereken de maandlasten
        double maandlasten = hypotheekBerekening.berekenMaandlasten(maximaalLeenbedrag, rentepercentage, looptijdInJaren);

        // Verwachte maandlasten berekenen
        double verwachteRentePerMaand = (maximaalLeenbedrag * (rentepercentage / 100)) / 12;
        double looptijdInMaanden = looptijdInJaren * 12;
        double verwachteAflossingPerMaand = maximaalLeenbedrag / looptijdInMaanden;
        double verwachteMaandlasten = verwachteRentePerMaand + verwachteAflossingPerMaand;

        // Controleer of de maandlasten correct zijn
        assertEquals(verwachteMaandlasten, maandlasten, 0.01);
    }
}
