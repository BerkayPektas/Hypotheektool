package nl.rocnijmegen.testing;

import java.util.Scanner;

public class HypotheekBerekeningLooptijd {

    public double berekenMaximaleHypotheek(double jaarinkomen) {
        // Maximale hypotheek is 4,25 keer het jaarinkomen
        return jaarinkomen * 4.25;
    }

    // Simpele lineaire methode voor maandlasten
    public double berekenMaandlasten(double leenbedrag, double rentepercentage, int looptijdInJaren) {
        // Bereken rente per maand over het volledige leenbedrag
        double rentePerMaand = (leenbedrag * (rentepercentage / 100)) / 12;

        // Bereken de aflossing per maand
        int looptijdInMaanden = looptijdInJaren * 12;
        double aflossingPerMaand = leenbedrag / looptijdInMaanden;

        // Maandlasten = rente per maand + aflossing per maand
        return rentePerMaand + aflossingPerMaand;
    }

    // Bereken totale kosten na de volledige looptijd
    public double berekenTotaleKosten(double leenbedrag, double rentepercentage, int looptijdInJaren) {
        // Bereken de maandlasten
        double maandlasten = berekenMaandlasten(leenbedrag, rentepercentage, looptijdInJaren);

        // Totale kosten = maandlasten * looptijd in maanden
        return maandlasten * looptijdInJaren * 12;
    }

    public static void main(String[] args) {
        // Maak een scanner aan om invoer van de gebruiker te lezen
        Scanner scanner = new Scanner(System.in);
        HypotheekBerekeningLooptijd berekening = new HypotheekBerekeningLooptijd();

        // Vraag de gebruiker om jaarinkomen
        System.out.print("Voer uw jaarinkomen in (€): ");
        double jaarinkomen = scanner.nextDouble();

        // Vraag de gebruiker om rentepercentage
        System.out.print("Voer het rentepercentage in (%): ");
        double rentepercentage = scanner.nextDouble();

        // Vraag de gebruiker om de looptijd van de hypotheek in jaren
        System.out.print("Voer de looptijd van de hypotheek in (jaren): ");
        int looptijdInJaren = scanner.nextInt();

        // Bereken het maximale leenbedrag op basis van het jaarinkomen
        double maximaalLeenbedrag = berekening.berekenMaximaleHypotheek(jaarinkomen);
        System.out.println("Het maximale bedrag dat u kunt lenen is: €" + maximaalLeenbedrag);

        // Bereken de maandlasten
        double maandlasten = berekening.berekenMaandlasten(maximaalLeenbedrag, rentepercentage, looptijdInJaren);
        System.out.println("Uw maandlasten (inclusief rente en aflossing) zijn: €" + maandlasten);

        // Bereken de totale kosten over de looptijd
        double totaleKosten = berekening.berekenTotaleKosten(maximaalLeenbedrag, rentepercentage, looptijdInJaren);
        System.out.println("De totale kosten van de hypotheek na " + looptijdInJaren + " jaar zijn: €" + totaleKosten);

        // Sluit de scanner
        scanner.close();
    }
}
