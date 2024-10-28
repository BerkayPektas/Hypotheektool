package nl.rocnijmegen.testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class HypotheekBerekeningPostcodeTest {

    HypotheekBerekeningPostcode hypotheekBerekening = new HypotheekBerekeningPostcode(); // Gebruik de juiste klasse

    @Test
    public void testPostcodeGeldig() {
        // Test met geldige postcodes
        assertTrue(hypotheekBerekening.isPostcodeGeldig("1234"));
        assertTrue(hypotheekBerekening.isPostcodeGeldig("1235"));
    }

    @Test
    public void testPostcodeOngeldig() {
        // Test met risicopostcodes
        assertFalse(hypotheekBerekening.isPostcodeGeldig("9679"));
        assertFalse(hypotheekBerekening.isPostcodeGeldig("9681"));
        assertFalse(hypotheekBerekening.isPostcodeGeldig("9682"));
    }

    @Test
    public void testAanvraagAfwijzenBijOngeldigePostcode() {
        String postcode = "9679"; // Risicopostcode
        boolean isGeldig = hypotheekBerekening.isPostcodeGeldig(postcode);

        // Controleer of de postcode wordt afgewezen
        assertFalse(isGeldig);
    }

    @Test
    public void testAanvraagAccepterenBijGeldigePostcode() {
        String postcode = "1234"; // Geldige postcode
        boolean isGeldig = hypotheekBerekening.isPostcodeGeldig(postcode);

        // Controleer of de postcode wordt geaccepteerd
        assertTrue(isGeldig);
    }
}
