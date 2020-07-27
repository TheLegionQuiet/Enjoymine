package ru.enjoymine.CivCraft.structure.io;

import com.sk89q.worldedit.math.BlockVector3;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import ru.enjoymine.CivCraft.Main;

import java.io.*;

public class BuildingWriter {
    final File file;
    final Location from, to;

    public BuildingWriter(String name, BlockVector3 from, BlockVector3 to) {
        this.file = new File(Main.getInstance().getDataFolder() + File.pathSeparator + "buildings" + File.pathSeparator + name);
        World build = Bukkit.getWorld("build");
        this.from = new Location(build, from.getX(), from.getY(), from.getZ());
        this.to = new Location(build, to.getX(), to.getY(), to.getZ());
    }

    @SuppressWarnings("deprecation")
    public void write() {
        Bukkit.getScheduler().runTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                final World build = Bukkit.getWorld("build");

                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                    for (int x = (int) from.getX(); x <= (int) to.getX(); x++) {
                        for (int z = (int) from.getZ(); z <= (int) to.getZ(); z++) {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int y = (int) from.getY(); y <= (int) to.getY(); y++) {
                                Block block = build.getBlockAt(x, y, z);
                                stringBuilder.append(block.getBlockData().getMaterial().getId() + " ");
                            }
                            bufferedWriter.write(stringBuilder.toString());
                        }
                        bufferedWriter.write("");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}