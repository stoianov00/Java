package raw_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Car> cars = new ArrayList<>();

        int carCount = Integer.parseInt(reader.readLine());
        while (carCount-- > 0) {
            String[] input = reader.readLine().split("\\s+");

            String carModel = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age);

            Car car = new Car(carModel, engine, cargo, tire);
            cars.add(car);
        }

        String cargoType = reader.readLine();
        if ("fragile".equals(cargoType)) {
            cars.stream()
                    .filter(car -> car.getTire().getTire1Pressure() < 1 || car.getTire().getTire2Pressure() < 1)
                    .forEach(car -> System.out.println(car.getCarModel()));

        } else {
            cars.stream()
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getCarModel()));
        }

    }
}
