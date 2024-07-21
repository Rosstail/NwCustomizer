package fr.rosstail.nwcustomizer.objectives.myobjective;

import fr.rosstail.nodewar.lang.LangManager;
import fr.rosstail.nodewar.territory.Territory;
import fr.rosstail.nodewar.territory.objective.NwObjective;

public class MyObjective extends NwObjective {

    int pointsToReach;
    MyObjectiveModel myObjectiveModel;
    public MyObjective(Territory territory, MyObjectiveModel childModel, MyObjectiveModel parentModel) {
        super(territory, childModel, parentModel);
        MyObjectiveModel clonedChildObjectiveModel = childModel.clone();
        MyObjectiveModel clonedParentObjectiveModel = parentModel.clone();
        this.myObjectiveModel = new MyObjectiveModel(clonedChildObjectiveModel, clonedParentObjectiveModel);

        this.pointsToReach = Integer.parseInt(this.myObjectiveModel.getPointToReachStr());

        // plugins/Nodewar/locale/usedLang.yml
        this.display = LangManager.getCurrentLang().getLangConfig().getString("territory.objective.description.my-objective.display");
        this.description = LangManager.getCurrentLang().getLangConfig().getStringList("territory.objective.types.my-objective.description");
    }

    @Override
    public boolean checkStart() {
        MyBattle currentBattle = (MyBattle) territory.getCurrentBattle();
        if (currentBattle.getStartCountdown() <= 0) {
            return true;
        }
        currentBattle.setStartCountdown(currentBattle.getStartCountdown() - 1);
        return false;
    }

    @Override
    public void onGoing() {
        super.onGoing();
        MyBattle currentBattle = (MyBattle) territory.getCurrentBattle();
        currentBattle.setCurrentPoint(currentBattle.getCurrentPoint() + 1);
    }

    @Override
    public boolean checkEnding() {
        MyBattle currentBattle = (MyBattle) territory.getCurrentBattle();
        return(currentBattle.getCurrentPoint() >= this.pointsToReach);
    }
}
