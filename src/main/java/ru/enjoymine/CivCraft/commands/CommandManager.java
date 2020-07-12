package ru.enjoymine.CivCraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.enjoymine.CivCraft.Main;

public class CommandManager implements CommandExecutor {
    private static volatile CommandManager instance;

    public static void init() {
        Main.getInstance().getCommand("yes").setExecutor(Reply.YES);
        Main.getInstance().getCommand("no").setExecutor(Reply.NO);
        Main.getInstance().getCommand("c").setExecutor(new CommandManager());
    }

    private CommandManager() {
        instance = this;
    }

    public synchronized CommandManager getInstance() {
        return instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        return true;
    }
}
