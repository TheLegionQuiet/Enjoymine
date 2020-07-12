package ru.enjoymine.CivCraft.db;

import org.bukkit.configuration.file.YamlConfiguration;
import ru.enjoymine.CivCraft.Main;

import java.io.File;

public class MySqlConfig {
    private static YamlConfiguration MySqlConfig;

    public static void init() {
        File file = new File(Main.getInstance().getDataFolder() + File.pathSeparator + "MySql");
        MySqlConfig = YamlConfiguration.loadConfiguration(file);
    }
}
