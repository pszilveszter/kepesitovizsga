package hu.nive.ujratervezes.kepesitovizsga.army;


public class HeavyCavalry extends MilitaryUnit {

    int round = 1;


    public HeavyCavalry() {
        super(20, 150, true);
    }


    @Override
    int doDamage() {
        if (round == 1) {
            round++;
            return attackPoints * 3;
        }
        return attackPoints;
    }
}
