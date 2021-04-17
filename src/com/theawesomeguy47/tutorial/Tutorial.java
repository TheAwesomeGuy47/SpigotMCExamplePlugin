package com.theawesomeguy47.tutorial;

import com.theawesomeguy47.tutorial.commands.InventoryCommands;
import com.theawesomeguy47.tutorial.commands.TutorialCommands;
import com.theawesomeguy47.tutorial.events.InventoryEvents;
import com.theawesomeguy47.tutorial.events.TutorialEvents;
import com.theawesomeguy47.tutorial.events.WandEvents;
import com.theawesomeguy47.tutorial.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        TutorialCommands commands = new TutorialCommands();
        getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
        getCommand("heal").setExecutor(commands);
        getCommand("feed").setExecutor(commands);
        getCommand("farmtime").setExecutor(commands);
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new WandEvents(), this);
        getCommand("givewand").setExecutor(commands);
        getCommand("select").setExecutor(new InventoryCommands());
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Tutorial] Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Tutorial] Plugin has been disabled!");
    }

}
