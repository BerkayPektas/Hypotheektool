package nl.rocnijmegen.testing;

public class HypotheekBerekening {

    public double berekenMaximaleHypotheek(double jaarinkomen) {
        // Maximale hypotheek is 4,25 keer het jaarinkomen
        return jaarinkomen * 4.25;
    }

    public double berekenMaandlasten(double leenbedrag, double rentepercentage, int looptijdInJaren) {
        // Bereken rente per maand
        double rentePerMaand = (leenbedrag * (rentepercentage / 100)) / 12;

        // Bereken aflossing per maand
        int looptijdInMaanden = looptijdInJaren * 12;
        double aflossingPerMaand = leenbedrag / looptijdInMaanden;

        // Maandlasten = rente + aflossing
        return rentePerMaand + aflossingPerMaand;
    }
}
