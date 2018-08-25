package cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Siamese> siameseStack = new ArrayDeque<>();
        Deque<Cymric> cymricsStack = new ArrayDeque<>();
        Deque<StreetExtraordinaire> streetExtraordinairesStack = new ArrayDeque<>();

        String[] input = reader.readLine().split("\\s+");
        while (!"End".equals(input[0])) {
            String breed = input[0];
            String name = input[1];
            double criteria = Double.parseDouble(input[2]);

            addCats(siameseStack, cymricsStack, streetExtraordinairesStack, breed, name, criteria);

            input = reader.readLine().split("\\s+");
        }

        printCat(siameseStack, cymricsStack, streetExtraordinairesStack, reader);
    }

    private static void addCats(Deque<Siamese> siameseStack, Deque<Cymric> cymricsStack, Deque<StreetExtraordinaire> streetExtraordinairesStack, String breed, String name, double criteria) {
        switch (breed) {
            case "StreetExtraordinaire":
                StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, criteria);
                streetExtraordinairesStack.push(streetExtraordinaire);
                break;
            case "Siamese":
                Siamese siamese = new Siamese(name, criteria);
                siameseStack.push(siamese);
                break;
            case "Cymric":
                Cymric cymric = new Cymric(name, criteria);
                cymricsStack.push(cymric);
                break;
        }
    }

    private static void printCat(Deque<Siamese> siameseStack, Deque<Cymric> cymricsStack, Deque<StreetExtraordinaire> streetExtraordinairesStack, BufferedReader reader) throws IOException {
        String searchedCat = reader.readLine();

        siameseStack.stream()
                .filter(siamese -> siamese.getName().equals(searchedCat))
                .forEach(siamese -> System.out.printf("Siamese %s %.2f %n", siamese.getName(), siamese.getEarSize()));

        cymricsStack.stream()
                .filter(cymric -> cymric.getName().equals(searchedCat))
                .forEach(cymric -> System.out.printf("Cymric %s %.2f", cymric.getName(), cymric.getFurLength()));

        streetExtraordinairesStack.stream()
                .filter(streetExtraordinaire -> streetExtraordinaire.getName().equals(searchedCat))
                .forEach(streetExtraordinaire -> System.out.printf("StreetExtraordinaire %s %.2f", streetExtraordinaire.getName(), streetExtraordinaire.getDecibelsOfMeows()));

    }
}
