package ru.enjoymine.CivCraft.items.interactive;

import org.bukkit.event.player.PlayerInteractEvent;
import ru.enjoymine.CivCraft.items.CustomItem;

public abstract class InteractiveItem extends CustomItem {

    public InteractiveItem(String name) {
        super(name);
    }

    public abstract void onClick(PlayerInteractEvent e);
}
