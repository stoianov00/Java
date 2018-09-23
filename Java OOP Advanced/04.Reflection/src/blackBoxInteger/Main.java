package blackBoxInteger;

import blackBoxInteger.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static final String className = "BlackBoxInt";
    private static final String classPath = "blackBoxInteger.com.";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BlackBoxInt blackBoxInt;
        try {
            Class<?> blackBoxIntClass = Class.forName(classPath + className);
            Constructor<?> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();

            String line = reader.readLine();
            while (!"END".equals(line)) {
                String[] inputTokens = line.split("_");

                Method declaredMethod = blackBoxInt.getClass().getDeclaredMethod(inputTokens[0], int.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(blackBoxInt, Integer.parseInt(inputTokens[1]));

                Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
                field.setAccessible(true);

                System.out.println(field.get(blackBoxInt));

                line = reader.readLine();
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
