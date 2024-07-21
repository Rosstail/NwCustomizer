package fr.rosstail.nwcustomizer;

import fr.rosstail.nodewar.ConfigData;
import fr.rosstail.nodewar.NwAPI;
import fr.rosstail.nodewar.lang.AdaptMessage;
import fr.rosstail.nodewar.lang.LangManager;
import fr.rosstail.nwcustomizer.objectives.myobjective.MyBattle;
import fr.rosstail.nwcustomizer.objectives.myobjective.MyObjective;
import fr.rosstail.nwcustomizer.objectives.myobjective.MyObjectiveModel;
import fr.rosstail.nwcustomizer.permissionsplugins.CustomPermissionPluginHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class NwCustomizer extends JavaPlugin {
    private YamlConfiguration config;

    @Override
    public void onLoad() {
        NwAPI nwAPI = NwAPI.getNwAPI();
        if (nwAPI != null) {
            nwAPI.addCustomObjective("my-objective", MyObjective.class, MyObjectiveModel.class, MyBattle.class);
            nwAPI.addCustomPermissionManager("my-permission", CustomPermissionPluginHandler.class);
        }
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        //loadCustomConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadCustomConfig() {
        File fileConfig = new File("plugins/" + getName() + "/config.yml");
        if (!(fileConfig.exists())) {
            System.out.println("[" + this.getName() + "] Preparing default config.yml");
            this.saveDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(fileConfig);
        System.out.println(getName() + "version: " + config.getString("config-version", "None"));
    }
}
