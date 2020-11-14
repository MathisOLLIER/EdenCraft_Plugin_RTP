package edencraft.plugin.randomteleportation;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import org.bukkit.Location;
import java.util.Random;

public class TeleportUtils {

    private static Location getRandomLoc(World world){
        Random random = new Random();
        int x = random.nextInt(1000);
        int y = 150;
        int z = random.nextInt(1000);
        Location location = new Location(world, x, y, z);
        location.setY(location.getWorld().getHighestBlockYAt(location));
        return location;
    }

    public static void randomTeleport(Player player){
        Location location = getRandomLoc(player.getWorld());
        while (location.getBlock().getBlockData().getMaterial().equals(Material.WATER)){
            location = getRandomLoc(player.getWorld());
        }
        location.setY(location.getY() + 1);
        player.teleport(location);
    }

}
