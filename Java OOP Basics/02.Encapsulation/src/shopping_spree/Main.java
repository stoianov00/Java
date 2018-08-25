package shopping_spree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();
        List<Product> productsList = new ArrayList<>();

        String[] tokens = reader.readLine().split(";");

        for (String token : tokens) {
            String[] tok = token.split("=");
            String name = tok[0].trim();
            double money = Double.parseDouble(tok[1].trim());

            try {
                personList.add(new Person(name, money));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        tokens = reader.readLine().split(";");
        for (String token : tokens) {
            String[] tok = token.split("=");
            String name = tok[0].trim();
            double cost = Double.parseDouble(tok[1].trim());

            try {
                productsList.add(new Product(name, cost));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        try {
            String command = reader.readLine();
            while (!"END".equals(command)) {
                tokens = command.split("\\s+");
                String personName = tokens[0];
                String productName = tokens[1];

                Person person = getPersonByName(personName, personList);
                Product product = getProductByName(productName, productsList);

                if (person.getMoney() >= product.getCost()) {
                    person.setMoney(person.getMoney() - product.getCost());
                    person.addProduct(product);

                    System.out.printf("%s bought %s%n", person.getName(), product.getName());
                } else {
                    System.out.printf("%s can't afford %s%n", person.getName(), product.getName());
                }

                command = reader.readLine();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            for (Person person : personList) {
                if (person.seeBag().size() > 0) {
                    List<String> products = person.seeBag().stream().map(Product::getName).collect(Collectors.toList());

                    System.out.printf("%s - %s%n", person.getName(), String.join(", ", products));
                } else {
                    System.out.printf("%s - Nothing bought%n", person.getName());
                }
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static Product getProductByName(String productName, List<Product> productsList) {
        return productsList.stream()
                .filter(product -> productName.equals(product.getName()))
                .findAny()
                .orElse(null);
    }

    private static Person getPersonByName(String name, List<Person> personList) {
        return personList.stream()
                .filter(person1 -> name.equals(person1.getName()))
                .findAny()
                .orElse(null);
    }

}