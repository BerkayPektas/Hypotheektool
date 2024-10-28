package nl.rocnijmegen.testing;

import java.util.Scanner;

public class HypotheekBerekeningMetStudieschuld extends HypotheekBerekening {

    public double berekenMaximaleHypotheekMetStudieschuld(double jaarinkomen, boolean heeftStudieschuld) {
        // Bereken de maximale hypotheek
        double maximaalLeenbedrag = berekenMaximaleHypotheek(jaarinkomen);
        // Als de gebruiker een studieschuld heeft, verlaag het bedrag met 25%
        if (heeftStudieschuld) {
            maximaalLeenbedrag *= 0.75;
        }
        return maximaalLeenbedrag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HypotheekBerekeningMetStudieschuld hypotheekBerekening = new HypotheekBerekeningMetStudieschuld();

        // Vraag gebruiker om jaarinkomen
        System.out.print("Voer uw jaarinkomen in: ");
        double jaarinkomen = scanner.nextDouble();

        // Vraag of de gebruiker een studieschuld heeft
        System.out.print("Heeft u een studieschuld? (ja/nee): ");
        String heeftStudieschuldInput = scanner.next();
        boolean heeftStudieschuld = heeftStudieschuldInput.equalsIgnoreCase("ja");

        // Maximale hypotheek berekenen
        double maximaalLeenbedrag = hypotheekBerekening.berekenMaximaleHypotheekMetStudieschuld(jaarinkomen, heeftStudieschuld);
        System.out.println("Het maximale bedrag dat u kunt lenen is: €" + maximaalLeenbedrag);

        // Vraag gebruiker om rentepercentage en looptijd
        System.out.print("Voer het rentepercentage in: ");
        double rentepercentage = scanner.nextDouble();

        System.out.print("Voer de looptijd van de hypotheek in (in jaren): ");
        int looptijdInJaren = scanner.nextInt();

        // Maandlasten berekenen
        double maandlasten = hypotheekBerekening.berekenMaandlasten(maximaalLeenbedrag, rentepercentage, looptijdInJaren);
        System.out.println("Uw maandelijkse lasten zijn: €" + maandlasten);

        // Sluit de scanner
        scanner.close();
    }
}
