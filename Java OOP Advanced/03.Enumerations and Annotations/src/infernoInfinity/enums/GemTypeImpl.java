package infernoInfinity.enums;

import infernoInfinity.interfaces.GemType;

public enum GemTypeImpl implements GemType {
    RUBY(7, 2, 5),
    EMERALD(1, 4, 9),
    AMETHYST(2, 8, 4);

    private int strength;
    private int agility;
    private int vitality;

    GemTypeImpl(int strength, int agility, int vitality) {
        this.strength = strength;
        this.agility = agility;
        this.vitality = vitality;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getAgility() {
        return this.agility;
    }

    @Override
    public int getVitality() {
        return this.vitality;
    }
}