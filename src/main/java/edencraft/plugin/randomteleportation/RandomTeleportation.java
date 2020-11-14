package edencraft.plugin.randomteleportation;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Random;

public final class RandomTeleportation extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("rtp").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                String locationTitle = ChatColor.BOLD + "Coordonnées : ";
                TeleportUtils.randomTeleport(player);
                player.sendMessage(ChatColor.GREEN + "◆ Téléportation ◆");
                player.sendMessage(ChatColor.GREEN + locationTitle + ChatColor.WHITE + "X = " +String.valueOf(player.getLocation().getX())+ " - " + "Y = " + String.valueOf(player.getLocation().getZ()));
            }else {
                System.out.println("Only player can do this command !");
            }
            return true;
    }
}

