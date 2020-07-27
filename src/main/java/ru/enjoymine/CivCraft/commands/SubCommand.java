package ru.enjoymine.CivCraft.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {
    final String name;

    protected SubCommand(String name) {
        this.name = name;
    }

    public abstract void onCommand(String[] strings, Player p);

    public String name() {
        return name;
    }
}
