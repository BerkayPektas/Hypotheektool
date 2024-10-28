package nl.rocnijmegen.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HypotheekBerekeningLooptijdTest {

    private HypotheekBerekeningLooptijd hypotheekBerekening;

    @BeforeEach
    public void setUp() {
        hypotheekBerekening = new HypotheekBerekeningLooptijd();
    }

    @Test
    public void testMaximaleHypotheekBerekening() {
        double jaarinkomen = 50000;
        double verwachtMaximaalLeenbedrag = 212500;

        double maximaalLeenbedrag = hypotheekBerekening.berekenMaximaleHypotheek(jaarinkomen);

        assertEquals(verwachtMaximaalLeenbedrag, maximaalLeenbedrag, 0.01);
    }

    @Test
    public void testTotaleKostenBerekening() {
        double leenbedrag = 212500;
        double rentepercentage = 5; // Rentepercentage
        int looptijdInJaren = 30; // Looptijd in jaren

        double verwachtTotaleKosten = 637498.8; // Totale kosten na 30 jaar

        double totaleKosten = hypotheekBerekening.berekenTotaleKosten(leenbedrag, rentepercentage, looptijdInJaren);

        assertEquals(verwachtTotaleKosten, totaleKosten, 0.01);
    }
}
