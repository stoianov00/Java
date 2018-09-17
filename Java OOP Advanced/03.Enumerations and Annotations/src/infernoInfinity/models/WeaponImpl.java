package infernoInfinity.models;

import infernoInfinity.interfaces.GemType;
import infernoInfinity.interfaces.Weapon;
import infernoInfinity.interfaces.WeaponType;

public class WeaponImpl implements Weapon, Comparable<Weapon> {
    private static final int STRENGTH_BONUS_TO_MIN_DAMAGE = 2;
    private static final int STRENGTH_BONUS_TO_MAX_DAMAGE = 3;
    private static final int AGILITY_BONUS_TO_MAX_DAMAGE = 4;
    private static final int DEFAULT_BONUS = 0;

    private WeaponType weaponType;
    private String name;
    private int strength;
    private int agility;
    private int vitality;
    private GemType[] sockets;
    private int minDamage;
    private int maxDamage;

    public WeaponImpl(WeaponType weaponType, String name) {
        this.weaponType = weaponType;
        this.name = name;
        this.strength = DEFAULT_BONUS;
        this.agility = DEFAULT_BONUS;
        this.vitality = DEFAULT_BONUS;
        this.sockets = new GemType[this.weaponType.getNumberOfSockets()];
        this.minDamage = weaponType.getMinDamage();
        this.maxDamage = weaponType.getMaxDamage();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public GemType[] getSockets() {
        return this.sockets;
    }

    @Override
    public boolean isValidIndex(int socketIndex) {
        return socketIndex >= 0 && socketIndex < this.sockets.length;
    }

    @Override
    public void addBonus(GemType gemType, int socketIndex) {
        this.sockets[socketIndex] = gemType;
        this.agility = this.agility + gemType.getAgility();
        this.strength = this.strength + gemType.getStrength();
        this.vitality = this.vitality + gemType.getVitality();

        this.minDamage = this.minDamage + (gemType.getStrength() * STRENGTH_BONUS_TO_MIN_DAMAGE) + gemType.getAgility();
        this.maxDamage = this.maxDamage + (gemType.getStrength() * STRENGTH_BONUS_TO_MAX_DAMAGE) + (gemType.getAgility() * AGILITY_BONUS_TO_MAX_DAMAGE);
    }

    @Override
    public void removeBonus(GemType gemType) {
        this.agility = this.agility - gemType.getAgility();
        this.strength = this.strength - gemType.getStrength();
        this.vitality = this.vitality - gemType.getVitality();

        this.minDamage = this.minDamage - (gemType.getStrength() * STRENGTH_BONUS_TO_MIN_DAMAGE) - gemType.getAgility();
        this.maxDamage = this.maxDamage - (gemType.getStrength() * STRENGTH_BONUS_TO_MAX_DAMAGE) - (gemType.getAgility() * AGILITY_BONUS_TO_MAX_DAMAGE);
    }

    @Override
    public double getItemLevel() {
        return ((this.minDamage + this.maxDamage) / 2.0d) + this.strength + this.agility + this.vitality;
    }

    @Override
    public int compareTo(Weapon otherWeapon) {
        return Double.compare(this.getItemLevel(), otherWeapon.getItemLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name,
                this.minDamage,
                this.maxDamage,
                this.strength,
                this.agility,
                this.vitality
        );
    }
}
