package infernoInfinity.factory;

import infernoInfinity.interfaces.Factory;
import infernoInfinity.interfaces.GemType;
import infernoInfinity.interfaces.Weapon;
import infernoInfinity.interfaces.WeaponType;
import infernoInfinity.models.WeaponImpl;

public class WeaponFactory implements Factory {
    @Override
    public Weapon createWeapon(WeaponType weaponType, String weaponName) {
        return new WeaponImpl(weaponType, weaponName);
    }

    @Override
    public void addGemsToWeapon(Weapon weapon, int socketIndex, GemType gemType) {
        if (weapon.isValidIndex(socketIndex)) {
            if (weapon.getSockets()[socketIndex] != null) {
                this.removeGemFromWeapon(weapon, socketIndex);
            }

            weapon.addBonus(gemType, socketIndex);
        }
    }

    @Override
    public void removeGemFromWeapon(Weapon weapon, int socketIndex) {
        if (weapon.isValidIndex(socketIndex)) {
            GemType gemType = weapon.getSockets()[socketIndex];

            if (gemType != null) {
                weapon.removeBonus(gemType);
            }

            weapon.getSockets()[socketIndex] = null;
        }
    }

    @Override
    public String printWeapon(Weapon weaponName) {
        return weaponName.toString();
    }
}
