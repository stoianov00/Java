package infernoInfinity;

import infernoInfinity.factory.WeaponFactory;
import infernoInfinity.interfaces.Engine;
import infernoInfinity.interfaces.Factory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Factory factory = new WeaponFactory();
        Engine engine = new EngineImpl(factory);

        engine.run();
    }
}
