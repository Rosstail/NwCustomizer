package fr.rosstail.nwcustomizer.objectives.myobjective;

import fr.rosstail.nodewar.territory.objective.ObjectiveModel;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;

public class MyObjectiveModel extends ObjectiveModel {

    private String pointToReachStr;

    public MyObjectiveModel(ConfigurationSection section) {
        super(section);
        if (section != null) {
            String pointToReachStr = section.getString("points-to-reach");
            if (pointToReachStr != null && pointToReachStr.matches("(\\d+)")) { // Check if value is a int
                this.pointToReachStr = pointToReachStr;
            }
        }
    }

    protected MyObjectiveModel(MyObjectiveModel childObjectiveModel, @NotNull MyObjectiveModel parentObjectiveModel) {
        super(childObjectiveModel, parentObjectiveModel);
        this.pointToReachStr = childObjectiveModel.getPointToReachStr() != null ? childObjectiveModel.getPointToReachStr() : parentObjectiveModel.getPointToReachStr();
    }

    public String getPointToReachStr() {
        return pointToReachStr;
    }

    public void setPointToReachStr(String pointToReachStr) {
        this.pointToReachStr = pointToReachStr;
    }

    @Override
    public MyObjectiveModel clone() {
        MyObjectiveModel clone = (MyObjectiveModel) super.clone();

        clone.setPointToReachStr(getPointToReachStr());

        return clone;
    }
}
