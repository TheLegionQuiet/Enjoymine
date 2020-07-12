package ru.enjoymine.CivCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public enum Reply implements CommandExecutor {
    YES,
    NO;


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        switch (name()) {
            case "YES":

                break;
            case "NO":

                break;
        }
        return true;
    }
}
