package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Army {

    private static final int MIN_HITPOINTS = 25;
    private List<MilitaryUnit> military = new ArrayList<>();

    
    public void addUnit(MilitaryUnit militaryUnit) {
        military.add(militaryUnit);
    }


    public int getArmySize() {
        return military.size();
    }

    
    public int getArmyDamage() {
        int totalDamage = 0;
        for (MilitaryUnit mu: military) {
            totalDamage += mu.doDamage();
        }
        return totalDamage;
    }


    public void damageAll(int damage) {
        for (MilitaryUnit mu: military) {
            mu.sufferDamage(damage);
        }
        decommissionWeekUnits();
    }


    private void decommissionWeekUnits() {
        for (Iterator<MilitaryUnit> mui = military.iterator(); mui.hasNext();) {
            MilitaryUnit unit = mui.next();
            if (unit.hitPoints < MIN_HITPOINTS) {
                mui.remove();
            }
        }
    }
}
