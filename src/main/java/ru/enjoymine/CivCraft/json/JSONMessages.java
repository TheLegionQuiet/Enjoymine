package ru.enjoymine.CivCraft.json;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.entity.Player;

public class JSONMessages {
    @SuppressWarnings("deprecation")
    public static void sendCommand(Player p, ChatColor color, String command, String message) {
        BaseComponent cmdComponent = new TextComponent(command);

        ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, command);
        cmdComponent.setClickEvent(clickEvent);

        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7*нажми*").create());
        cmdComponent.setColor(color);
        cmdComponent.setHoverEvent(hoverEvent);

        BaseComponent messageComponent = new TextComponent(" - " + message);

        cmdComponent.addExtra(messageComponent);
        p.spigot().sendMessage(cmdComponent);
    }

    @SuppressWarnings("deprecation")
    public static void sendLink(Player p, ChatColor color, String message, String URL) {
        TextComponent messageComponent = new TextComponent(message);

        ClickEvent clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, URL);
        messageComponent.setClickEvent(clickEvent);

        HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(URL).create());
        messageComponent.setHoverEvent(hoverEvent);
        messageComponent.setColor(color);

        p.spigot().sendMessage(messageComponent);
    }
}
