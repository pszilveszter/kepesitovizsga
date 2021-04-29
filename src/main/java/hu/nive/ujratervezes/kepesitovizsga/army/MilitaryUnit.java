package hu.nive.ujratervezes.kepesitovizsga.army;


public abstract class MilitaryUnit {

    protected int attackPoints;
    protected int hitPoints;
    private boolean isArmored;


    MilitaryUnit(int attackPoints, int hitPoints, boolean isArmored) {
        this.attackPoints = attackPoints;
        this.hitPoints = hitPoints;
        this.isArmored = isArmored;
    }


    int doDamage() {
        return attackPoints;
    }


    int sufferDamage(int damage) {
        if (isArmored) {
            hitPoints -= damage / 2;
        }
        else {
            hitPoints -= damage;
        }
        return hitPoints;
    }


    int getHitPoints() {
        return hitPoints;
    }

}
