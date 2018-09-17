package infernoInfinity.interfaces;

public interface Factory {
    Weapon createWeapon(WeaponType weaponType, String weaponName);

    void addGemsToWeapon(Weapon weaponName, int socketIndex, GemType gemType);

    void removeGemFromWeapon(Weapon weaponName, int socketIndex);

    String printWeapon(Weapon weaponName);
}
