package ru.enjoymine.CivCraft.commands.t;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.enjoymine.CivCraft.Main;
import ru.enjoymine.CivCraft.commands.SubCommand;
import ru.enjoymine.CivCraft.json.JSONMessages;

import java.util.ArrayList;
import java.util.Arrays;

public class TownCommandManager implements CommandExecutor {
    private static volatile TownCommandManager instance;
    private ArrayList<SubCommand> commands;

    public static void init() {
        Main.getInstance().getCommand("t").setExecutor(new TownCommandManager());
    }

    private TownCommandManager() {
        instance = this;
        commands = new ArrayList<>();
        fillCommands();
    }

    private void fillCommands() {
        commands.add(new Build("b"));
    }

    public synchronized TownCommandManager getInstance() {
        return instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 0) {
            help(commandSender.getName());
            return true;
        }
        for(SubCommand subCommand: commands) {
            if(strings[0].toLowerCase().equals(subCommand.name())) {
                subCommand.onCommand(Arrays.copyOfRange(strings, 1, strings.length), (Player) commandSender);
                return true;
            }
        }
        help(commandSender.getName());
        return true;
    }

    private void help(String name) {
        Player p = Bukkit.getPlayer(name);
        p.sendMessage("§7Список доступных команд:");
        JSONMessages.sendCommand(p, ChatColor.AQUA, "/t b", "постройки города");
    }
}
