package nl.rocnijmegen.testing;

import java.util.Scanner;

public class HypotheekBerekeningTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HypotheekBerekening hypotheekBerekening = new HypotheekBerekening();

        // Vraag gebruiker om jaarinkomen
        System.out.print("Voer uw jaarinkomen in: ");
        double jaarinkomen = scanner.nextDouble();

        // Maximale hypotheek berekenen
        double maximaalLeenbedrag = hypotheekBerekening.berekenMaximaleHypotheek(jaarinkomen);
        System.out.println("Het maximale bedrag dat u kunt lenen is: €" + maximaalLeenbedrag);

        // Sluit de scanner
        scanner.close();
    }
}
