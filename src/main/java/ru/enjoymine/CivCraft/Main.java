package ru.enjoymine.CivCraft;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.enjoymine.CivCraft.commands.t.TownCommandManager;
import ru.enjoymine.CivCraft.commands.civ.CivCommandManager;
import ru.enjoymine.CivCraft.db.MySql;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private static Main instance;
    private final Logger logger;

    public Main() {
        instance = this;
        logger = Bukkit.getLogger();
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§eCivCraft plugin enabled.");
        init();
    }

    @Override
    public void onDisable() {
        logger.info("CivCraft plugin disabled.");
    }

    @Override
    public void onLoad() {
        logger.info("CivCraft plugin loaded.");
    }

    private void init() {
        MySql.init();
        TownCommandManager.init();
        CivCommandManager.init();
    }

    public static WorldEditPlugin getWorldEdit() {
        if(Bukkit.getPluginManager().getPlugin("WorldEdit") instanceof  WorldEditPlugin)
            return (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
        return null;
    }

    static {

    }
}
