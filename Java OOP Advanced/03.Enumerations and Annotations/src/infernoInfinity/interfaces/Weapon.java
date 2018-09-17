package infernoInfinity.interfaces;

public interface Weapon {
    String getName();

    GemType[] getSockets();

    boolean isValidIndex(int socketIndex);

    void addBonus(GemType gemType, int socketIndex);

    void removeBonus(GemType gemType);

    double getItemLevel();
}
