package infernoInfinity.enums;

import infernoInfinity.interfaces.WeaponType;

public enum WeaponTypeImpl implements WeaponType {
    AXE(5, 10, 4),
    SWORD(4, 6, 3),
    KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;

    WeaponTypeImpl(int minDamage, int maxDamage, int numberOfSockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numberOfSockets = numberOfSockets;
    }

    @Override
    public int getMinDamage() {
        return this.minDamage;
    }

    @Override
    public int getMaxDamage() {
        return this.maxDamage;
    }

    @Override
    public int getNumberOfSockets() {
        return this.numberOfSockets;
    }
}
