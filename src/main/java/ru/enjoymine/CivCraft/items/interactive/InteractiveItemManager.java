package ru.enjoymine.CivCraft.items.interactive;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEvent;
import ru.enjoymine.CivCraft.Main;
import ru.enjoymine.CivCraft.items.ItemNames;

import java.util.ArrayList;

public class InteractiveItemManager {
    private static volatile InteractiveItemManager instance;
    private ArrayList<InteractiveItem> items;

    private InteractiveItemManager() {
        Bukkit.getPluginManager().registerEvents(new InteractiveItemListener(), Main.getInstance());
        init();
    }

    public static synchronized InteractiveItemManager getInstance() {
        if(instance == null) instance = new InteractiveItemManager();
        return instance;
    }

    private void init() {
        items.add(new CampItem(ItemNames.camp));
    }

    public void onClick(String name, PlayerInteractEvent e) {
        for(InteractiveItem i: items) {
            if(i.getName().equals(name)) i.onClick(e);
        }
    }
}
