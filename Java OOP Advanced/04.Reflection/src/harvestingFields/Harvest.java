package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Harvest {
    private static final String PRIVATE_FIELDS = "private";
    private static final String PROTECTED_FIELDS = "protected";
    private static final String PUBLIC_FIELDS = "public";
    private static final String ALL = "all";

    private Field[] fields;
    private RichSoilLand soilLand;

    public Harvest(RichSoilLand soilLand) {
        this.soilLand = soilLand;
        this.fields = soilLand.getClass().getDeclaredFields();
    }

    public void dispatchCommand(String command) {
        switch (command) {
            case PRIVATE_FIELDS:
                this.printAllPrivateFields();
                break;
            case PROTECTED_FIELDS:
                this.printAllProtectedFields();
                break;
            case PUBLIC_FIELDS:
                this.printAllPublicFields();
                break;
            case ALL:
                this.allFields();
                break;
        }
    }

    private void printAllPrivateFields() {
        for (Field field : this.fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            }
        }
    }

    private void printAllProtectedFields() {
        for (Field field : this.fields) {
            if (Modifier.isProtected(field.getModifiers())) {
                System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            }
        }
    }

    private void printAllPublicFields() {
        for (Field field : this.fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
            }
        }
    }

    private void allFields() {
        for (Field field : this.fields) {
            System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
        }
    }

}
