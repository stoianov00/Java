package infernoInfinity;

import infernoInfinity.enums.GemTypeImpl;
import infernoInfinity.enums.WeaponTypeImpl;
import infernoInfinity.interfaces.Engine;
import infernoInfinity.interfaces.Factory;
import infernoInfinity.interfaces.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EngineImpl implements Engine {
    private Factory factory;
    private List<Weapon> weapons;

    public EngineImpl(Factory factory) {
        this.factory = factory;
        this.weapons = new ArrayList<>();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        while (!command.equals("END")) {
            String[] inputTokens = command.split(";");
            switch (inputTokens[0]) {
                case "Create":
                    Weapon weapon = this.factory.createWeapon(WeaponTypeImpl.valueOf(inputTokens[1]), inputTokens[2]);
                    this.weapons.add(weapon);
                    break;
                case "Add":
                    for (Weapon weapon1 : this.weapons) {
                        if (weapon1.getName().equals(inputTokens[1])) {
                            int index = Integer.parseInt(inputTokens[2]);
                            this.factory.addGemsToWeapon(weapon1, index, GemTypeImpl.valueOf(inputTokens[3]));
                            break;
                        }
                    }
                    break;
                case "Remove":
                    for (Weapon weapon1 : this.weapons) {
                        if (weapon1.getName().equals(inputTokens[1])) {
                            int indexToRemove = Integer.parseInt(inputTokens[2]);
                            this.factory.removeGemFromWeapon(weapon1, indexToRemove);
                            break;
                        }
                    }
                    break;
                case "Print":
                    for (Weapon weapon1 : this.weapons) {
                        if (weapon1.getName().equals(inputTokens[1])) {
                            System.out.println((this.factory.printWeapon(weapon1)));
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }

            command = reader.readLine();
        }
    }
}
