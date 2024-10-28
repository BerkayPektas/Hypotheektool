package nl.rocnijmegen.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HypotheekBerekeningMetRenteTest {

    private HypotheekBerekeningMetRente hypotheekBerekeningMetRente = new HypotheekBerekeningMetRente();

    @Test
    public void testMaandlastenBerekening() {
        double leenbedrag = 212500; // Voorbeeld leenbedrag
        double rentepercentage = 5.0; // Rentepercentage
        int looptijdInJaren = 30; // Looptijd in jaren

        double verwachteMaandlasten = (leenbedrag * (rentepercentage / 100) / 12) + (leenbedrag / (looptijdInJaren * 12));
        double maandlasten = hypotheekBerekeningMetRente.berekenMaandlasten(leenbedrag, rentepercentage, looptijdInJaren);

        assertEquals(verwachteMaandlasten, maandlasten, 0.01);
    }
}
