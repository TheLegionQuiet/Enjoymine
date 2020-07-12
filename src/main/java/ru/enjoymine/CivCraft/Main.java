package ru.enjoymine.CivCraft;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.enjoymine.CivCraft.commands.CommandManager;
import ru.enjoymine.CivCraft.db.MySql;
import ru.enjoymine.CivCraft.db.MySqlConfig;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private static volatile Main instance;
    private final Logger logger;

    public Main() {
        instance = this;
        logger = Bukkit.getLogger();
    }

    public static synchronized Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§eCivCraft plugin is enabling...");

    }

    @Override
    public void onDisable() {
        logger.info("CivCraft plugin disabled.");
    }

    @Override
    public void onLoad() {
        logger.info("CivCraft plugin loaded.");
    }

    static {
        MySql.init();
        MySqlConfig.init();
    }
}
