package dev.xac.utils;

import java.io.File;

import dev.xac.utils.commands.GamemodeCommand;
import dev.xac.utils.listeners.BlockerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Utils extends JavaPlugin {

    public static final boolean Modalidade = false;
    public static Object plugin;

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "________________________________");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "  Utils Enabled");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "  Authors: Xac Development");
        Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + " Open Source Github.com/Tablist");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "_________________________________");
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        conf = new File(getDataFolder(), "config.yml");
        registerCommands();
        registerEvents();

        new BukkitRunnable() {
            public void run() {
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "difficulty peaceful");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "gamerule doMobSpawning false");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "gamerule commandBlockOutput false");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "gamerule logAdminCommands false");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "gamerule mobGriefing false");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "gamerule doDaylightCycle false");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "gamerule sendCommandFeedback false");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "difficulty normal");
                Bukkit.getServer().dispatchCommand((CommandSender) Bukkit.getServer().getConsoleSender(), "time set day");
            }
        }.runTaskLater((Plugin)this, 300L);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"Utils Disabling...");
    }

    private void registerCommands() {

        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        conf = new File(getDataFolder(), "config.yml");
        getCommand("gamemode").setExecutor(new GamemodeCommand());
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new BlockerListener(), this);
    }

    public Object getUserManager() {
        // TODO Auto-generated method stub
        return null;
    }

    public static JavaPlugin getPlugin() {
        // TODO Auto-generated method stub
        return null;
    }
    public static File conf;
    public static FileConfiguration config;

}

