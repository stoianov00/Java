package barracksWars.core;

import barracksWars.contracts.Repository;
import barracksWars.contracts.Unit;
import barracksWars.contracts.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException | ClassNotFoundException | InstantiationException
                    | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String result;
        switch (commandName) {
            case "add":
                result = this.addUnitCommand(data);
                break;
            case "report":
                result = this.reportCommand(data);
                break;
            case "fight":
                result = this.fightCommand(data);
                break;
            default:
                throw new RuntimeException("Invalid command!");
        }

        return result;
    }

    private String reportCommand(String[] data) {
        return this.repository.getStatistics();
    }

    private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = data[1];

        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);

        return String.format("%s added!", unitType);
    }

    private String fightCommand(String[] data) {
        return "fight";
    }
}