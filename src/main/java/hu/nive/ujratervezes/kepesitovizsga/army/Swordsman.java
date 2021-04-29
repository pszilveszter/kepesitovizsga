package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean armorState;

    public Swordsman(boolean isArmored) {
        super(10, 100, isArmored);
        this.armorState = true;
    }

    @Override
    int sufferDamage(int damage) {
        if (armorState) {
            armorState = false;
            return vitality;
        }
        return super.sufferDamage(damage);
    }
}
