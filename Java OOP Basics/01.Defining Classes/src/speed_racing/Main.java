package speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int carCount = Integer.parseInt(reader.readLine());
        while (carCount-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            String carModel = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelPerKm = Double.parseDouble(input[2]);

            Car car = new Car(carModel, fuelAmount, fuelPerKm);
            cars.add(car);
        }

        String command = reader.readLine();
        while (!"End".equals(command)) {
            String[] input = command.split("\\s+");

            String model = input[1];
            double distance = Double.parseDouble(input[2]);

            cars.stream()
                    .filter(c -> c.getCarModel().equals(model))
                    .collect(Collectors.toList())
                    .forEach(c -> c.drive(distance));

            command = reader.readLine();
        }

        for (Car car : cars) {
            System.out.printf("%s %.2f %.1f%n", car.getCarModel(), car.getFuelAmount(), car.getDistanceTravelled());
        }

    }
}
