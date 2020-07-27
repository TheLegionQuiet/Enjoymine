package ru.enjoymine.CivCraft.commands.civ;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.enjoymine.CivCraft.Main;
import ru.enjoymine.CivCraft.commands.SubCommand;
import ru.enjoymine.CivCraft.json.JSONMessages;

import java.util.ArrayList;
import java.util.Arrays;

public class CivCommandManager implements CommandExecutor {
    private static volatile CivCommandManager instance;
    private ArrayList<SubCommand> commands;

    public static void init() {
        Main.getInstance().getCommand("c").setExecutor(new CivCommandManager());
        Main.getInstance().getCommand("accept").setExecutor(Reply.YES);
        Main.getInstance().getCommand("deny").setExecutor(Reply.NO);
    }

    private CivCommandManager() {
        instance = this;
        commands = new ArrayList<>();
        fillCommands();
    }

    private void fillCommands() {
        commands.add(new Info("info"));
        commands.add(new Menu("menu"));
        commands.add(new Research("r"));
    }

    public synchronized CivCommandManager getInstance() {
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
        JSONMessages.sendCommand(Bukkit.getPlayer(name), ChatColor.GREEN,"/c menu", "меню цивилизации");
        JSONMessages.sendCommand(Bukkit.getPlayer(name), ChatColor.GREEN,"/c info", "информация о цивилизации");
        JSONMessages.sendCommand(Bukkit.getPlayer(name), ChatColor.GREEN,"/c r", "изучения цивилизации");
    }
}
