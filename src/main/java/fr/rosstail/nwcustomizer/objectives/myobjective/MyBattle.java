package fr.rosstail.nwcustomizer.objectives.myobjective;

import fr.rosstail.nodewar.lang.LangManager;
import fr.rosstail.nodewar.territory.Territory;
import fr.rosstail.nodewar.territory.battle.Battle;

public class MyBattle extends Battle {
    private int startCountdown = 3;
    private int currentPoint = 0;
    public MyBattle(Territory territory) {
        super(territory);

        // plugins/Nodewar/locale/usedLang.yml
        this.description = LangManager.getCurrentLang().getLangConfig().getStringList("territory.battle.types.my-objective.description");
    }

    public int getStartCountdown() {
        return startCountdown;
    }

    public void setStartCountdown(int startCountdown) {
        this.startCountdown = startCountdown;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }
}
