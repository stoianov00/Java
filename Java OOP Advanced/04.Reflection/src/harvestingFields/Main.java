package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        RichSoilLand soilLand = new RichSoilLand();
        Harvest harvest = new Harvest(soilLand);

        String command = reader.readLine();
        while (!"HARVEST".equals(command)) {
            harvest.dispatchCommand(command);

            command = reader.readLine();
        }

    }
}
