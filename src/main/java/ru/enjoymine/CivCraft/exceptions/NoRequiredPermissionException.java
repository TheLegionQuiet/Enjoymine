package ru.enjoymine.CivCraft.exceptions;

import org.bukkit.Bukkit;

public class NoRequiredPermissionException extends Exception {
    public NoRequiredPermissionException() {
    }

    public void message(String name) {
        Bukkit.getPlayer(name).sendMessage("[§5CivCraft§f] §7у вас нет права на использование этой команды :(");
    }
}
