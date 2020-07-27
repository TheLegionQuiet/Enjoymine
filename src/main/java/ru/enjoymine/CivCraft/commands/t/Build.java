package ru.enjoymine.CivCraft.commands.t;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.internal.annotation.Selection;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.world.World;
import net.md_5.bungee.api.ChatColor;
import net.royawesome.jlibnoise.module.combiner.Select;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.enjoymine.CivCraft.Main;
import ru.enjoymine.CivCraft.commands.RequiredPermission;
import ru.enjoymine.CivCraft.commands.SubCommand;
import ru.enjoymine.CivCraft.exceptions.NoRequiredPermissionException;
import ru.enjoymine.CivCraft.json.JSONMessages;
import ru.enjoymine.CivCraft.structure.io.BuildingWriter;

import java.io.IOException;

public class Build extends SubCommand {
    protected Build(String name) {
        super(name);
    }

    @Override
    public void onCommand(String[] strings, Player p) {
        if(strings[0] == null) build(p);
        switch (strings[0].toLowerCase()) {
            case "list":
            case "l":
                list(p);
                break;
            case "write":
                try {
                    write(p, strings);
                } catch (IncompleteRegionException e) {
                    p.sendMessage("§4Вы не выделили регион!");
                } catch (NoRequiredPermissionException e) {
                    e.message(p.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void build(Player p) {
        p.sendMessage("§7Список доступных подкоманд:");
        JSONMessages.sendCommand(p, ChatColor.AQUA, "/t list", "список построек города");
        if(p.hasPermission("cc.builder")) {
            JSONMessages.sendCommand(p, ChatColor.AQUA, "/t list", "список построек города");
        }

    }

    private void list(Player p) {

    }

    @RequiredPermission(permission = "cc.builder")
    private void write(Player p, String[] strings) throws IncompleteRegionException, NoRequiredPermissionException, IOException {
        if(!p.hasPermission("cc.builder"))
            throw new NoRequiredPermissionException();

        Region region = Main.getWorldEdit().getSession(p).getSelection((World) Bukkit.getWorld("build"));
        try {
            BuildingWriter buildingWriter = new BuildingWriter(strings[1], region.getMinimumPoint(), region.getMinimumPoint());
            buildingWriter.write();
        } catch (NullPointerException e) {
            p.sendMessage("[§5CivCraft§f] §7используйте §f/b write <название постройки>");
        }
    }
}
