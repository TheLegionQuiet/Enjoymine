package ru.enjoymine.CivCraft.items.interactive;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractiveItemListener implements Listener {
    @EventHandler
    private void onPlayerInteract(PlayerInteractEvent e) {
        if(!e.getAction().equals(Action.PHYSICAL)) InteractiveItemManager.getInstance().onClick(e.getItem().getItemMeta().getDisplayName(), e);
    }
}
