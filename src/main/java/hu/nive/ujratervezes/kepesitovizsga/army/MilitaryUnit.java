package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    protected int attackPoints;
    protected int vitality;
    private boolean isArmored;

    MilitaryUnit(int attackPoints, int vitality, boolean isArmored) {
        this.attackPoints = attackPoints;
        this.vitality = vitality;
        this.isArmored = isArmored;
    }

    int doDamage() {
        return attackPoints;
    }


    int sufferDamage(int damage) {
        if (isArmored) {
            vitality -= damage / 2;
        }
        else {
            vitality -= damage;
        }
        return vitality;
    }


    int getHitPoints() {
        return vitality;
    }
}
