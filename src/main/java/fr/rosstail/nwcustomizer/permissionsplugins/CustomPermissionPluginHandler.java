package fr.rosstail.nwcustomizer.permissionsplugins;

import fr.rosstail.nodewar.permissionmannager.NwIPermissionManagerHandler;
import org.bukkit.entity.Player;

public class CustomPermissionPluginHandler implements NwIPermissionManagerHandler {
    CustomPermissionPluginHandler() {
        System.err.println("TODO define permission plugin here");
    }

    @Override
    public void createGroup(String s) {
        System.err.println("TODO Create group");
    }

    @Override
    public void deleteGroup(String s) {
        System.err.println("TODO Delete group");
    }

    @Override
    public void setPlayerGroup(String s, Player player) {
        System.err.println("TODO SetPlayer group");
    }

    @Override
    public void removePlayerGroup(Player player, String s) {
        System.err.println("TODO removePlayer group");
    }
}
