package car_salesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        int engineCount = Integer.parseInt(reader.readLine());
        while (engineCount-- > 0) {
            String[] engineInput = reader.readLine().split("\\s+");
            String engineModel = engineInput[0];
            int power = Integer.parseInt(engineInput[1]);

            Engine engine = null;
            switch (engineInput.length) {
                case 2:
                    engine = new Engine(engineModel, power);
                    break;
                case 3:
                    if (engineInput[2].matches("\\d+")) {
                        engine = new Engine(engineModel, power, Integer.parseInt(engineInput[2]));
                    } else {
                        engine = new Engine(engineModel, power, engineInput[2]);
                    }
                    break;
                case 4:
                    engine = new Engine(engineModel, power, Integer.parseInt(engineInput[2]), engineInput[3]);
                    break;
            }

            engines.putIfAbsent(engineModel, engine);
        }

        int carCount = Integer.parseInt(reader.readLine());
        while (carCount-- > 0) {
            String[] carInput = reader.readLine().split("\\s+");
            String carModel = carInput[0];
            String engine = carInput[1];

            Car car = null;
            switch (carInput.length) {
                case 2:
                    car = new Car(carModel, engines.get(engine));
                    break;
                case 3:
                    if (carInput[2].matches("\\d+")) {
                        car = new Car(carModel, engines.get(engine), Integer.parseInt(carInput[2]));
                    } else {
                        car = new Car(carModel, engines.get(engine), carInput[2]);
                    }
                    break;
                case 4:
                    car = new Car(carModel, engines.get(engine), Integer.parseInt(carInput[2]), carInput[3]);
                    break;
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
