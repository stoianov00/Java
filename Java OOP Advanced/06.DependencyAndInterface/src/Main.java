import contracts.*;
import controllers.BoatSimulatorControllerImpl;
import core.CommandHandlerImpl;
import core.Engine;
import database.BoatEngineRepository;
import database.BoatRepository;
import database.BoatSimulatorDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Runnable;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Repository<Boat> boatRepository = new BoatRepository();
        Repository<BoatEngine> boatEngineRepository = new BoatEngineRepository();

        BoatSimulatorDatabase database = new BoatSimulatorDatabase(boatRepository, boatEngineRepository);

        BoatSimulatorController controller = new BoatSimulatorControllerImpl(database);
        CommandHandler commandHandler = new CommandHandlerImpl(controller);

        Runnable engine = new Engine(reader, commandHandler);
        engine.run();

        /*
CreateBoatEngine\GPH01\250\100\Jet
CreateBoatEngine\GPH02\150\150\Sterndrive
CreateRowBoat\Rower15\450\6
CreatePowerBoat\PB150\2200\GPH01\GPH02
CreateSailBoat\SailBoatPro\200\98
OpenRace\1000\10\5\true
SignUpBoat\SailBoatPro
SignUpBoat\Rower15
SignUpBoat\PB150
StartRace
End
         */
    }
}
