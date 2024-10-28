package nl.rocnijmegen.testing;

import java.util.Scanner;

public class HypotheekBerekeningMetRente extends HypotheekBerekening {

    public double berekenMaandlasten(double leenbedrag, double rentepercentage, int looptijdInJaren) {
        // Bereken rente per maand
        double rentePerMaand = (leenbedrag * (rentepercentage / 100)) / 12;

        // Bereken aflossing per maand
        int looptijdInMaanden = looptijdInJaren * 12;
        double aflossingPerMaand = leenbedrag / looptijdInMaanden;

        // Maandlasten = rente + aflossing
        return rentePerMaand + aflossingPerMaand;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HypotheekBerekeningMetRente hypotheekBerekeningMetRente = new HypotheekBerekeningMetRente();

        // Vraag gebruiker om het maximale leenbedrag
        System.out.print("Voer het maximale leenbedrag in: ");
        double maximaalLeenbedrag = scanner.nextDouble();

        // Vraag gebruiker om rentepercentage
        System.out.print("Voer het rentepercentage in: ");
        double rentepercentage = scanner.nextDouble();

        // Vraag gebruiker om de looptijd van de hypotheek
        System.out.print("Voer de looptijd van de hypotheek in (in jaren). Kies uit 1,5,10,20,30 jaar: ");
        int looptijdInJaren = scanner.nextInt();

        // Maandlasten berekenen
        double maandlasten = hypotheekBerekeningMetRente.berekenMaandlasten(maximaalLeenbedrag, rentepercentage, looptijdInJaren);

        // Resultaat weergeven
        System.out.println("Uw maandelijkse lasten zijn: €" + maandlasten);

        // Sluit de scanner
        scanner.close();
    }
}
