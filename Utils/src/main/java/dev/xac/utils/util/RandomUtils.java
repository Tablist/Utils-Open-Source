package dev.xac.utils.util;

import java.util.Random;

import dev.xac.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomUtils {

    JavaPlugin plugin;

    public RandomUtils() {
        plugin =
                Utils.getPlugin();
    }

    public Integer getRandomNumber(int min, int max) {
        Random rand = new Random();
        int n = rand.nextInt(max) + min;
        return n;
    }
}
