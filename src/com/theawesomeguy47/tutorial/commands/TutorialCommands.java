package com.theawesomeguy47.tutorial.commands;

import com.theawesomeguy47.tutorial.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


public class TutorialCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("givewand")) {
            player.getInventory().addItem(ItemManager.wand);
        }


        // /heal
        if (cmd.getName().equalsIgnoreCase("heal")) {
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage("§e§l(!) §eYou have been healed!");
            return true;
        }

        // /feed
        else if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
            player.sendMessage("§e§l(!) §eYou have been fed! Like a lot! Maybe go on a diet...?");
        }


        // / farmtime cow 5
        else if (cmd.getName().equalsIgnoreCase("farmtime")) {
            if (args.length >= 2) {
                try{
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);
                    for (int i = 0; i < amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } catch (IllegalArgumentException e) {
                    player.sendMessage(ChatColor.RED + "§e§l(!) §cThat is not a valid entity!");
                }

            } else {
                player.sendMessage(ChatColor.RED + "§e§l(!) §cUsage of this command is /farmtime <mob> <amount>!");
            }
        }
        return true;
    }
}
