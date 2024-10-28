package nl.rocnijmegen.testing;

import java.util.Scanner;

public class HypotheekBerekeningPostcode {

    public double berekenMaximaleHypotheek(double jaarinkomen) {
        return jaarinkomen * 4.25;
    }

    // Methode om te controleren of een postcode geldig is
    public boolean isPostcodeGeldig(String postcode) {
        // Definieer een lijst met risicopostcodes
        String[] risicopostcodes = {"9679", "9681", "9682"};

        // Controleer of de postcode in de lijst met risicopostcodes zit
        for (String risicopostcode : risicopostcodes) {
            if (postcode.equals(risicopostcode)) {
                return false; // Ongeldige postcode
            }
        }
        return true; // Geldige postcode
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HypotheekBerekeningPostcode hypotheekBerekening = new HypotheekBerekeningPostcode();

        // Vraag gebruiker om jaarinkomen
        System.out.print("Voer uw jaarinkomen in: ");
        double jaarinkomen = scanner.nextDouble();

        // Vraag gebruiker om postcode
        System.out.print("Voer uw postcode in: ");
        String postcode = scanner.next();

        // Controleer de postcode
        if (!hypotheekBerekening.isPostcodeGeldig(postcode)) {
            System.out.println("Uw aanvraag is afgewezen: postcode " + postcode + " is niet geldig.");
            return; // Stop de uitvoering
        }

        // Maximale hypotheek berekenen
        double maximaalLeenbedrag = hypotheekBerekening.berekenMaximaleHypotheek(jaarinkomen);
        System.out.println("Het maximale bedrag dat u kunt lenen is: €" + maximaalLeenbedrag);

        // Sluit d
    }
}