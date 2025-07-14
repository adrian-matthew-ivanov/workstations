package com.prygin.workstations.commands;

import com.prygin.workstations.Workstations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class giveCustomBlockCommand extends Command {

    private final Workstations plugin;

    public giveCustomBlockCommand(Workstations plugin) {
        super("customblock");
        this.plugin = plugin;
        this.setDescription("Gives you custom blocks");
        this.setAliases(java.util.List.of("gci"));
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can use this command.");
            return true;
        }

        if (args.length == 0 || args[0].isBlank()) {
            player.sendMessage("§cUsage: /customblock <block_name>");
            return true;
        }

        Map<String, ItemStack> custom_blocks = plugin.get_custom_blocks();

        if (!custom_blocks.containsKey(args[0])) {
            player.sendMessage("§cUnknown block: " + args[0]);
            return true;
        }

        player.getInventory().addItem(custom_blocks.get(args[0]));
        player.sendMessage("You have been given a custom block: " + args[0]);
        return true;
    }

    @Override
    public @Nullable List<String> tabComplete(@NotNull CommandSender sender, @NotNull String label, @NotNull String @NotNull [] args) {
        final List<String> validNames = new ArrayList<>();

        if (args.length == 1) {
            Map<String, ItemStack> custom_blocks = plugin.get_custom_blocks();
            List<String> custom_blocks_names = new ArrayList<>(custom_blocks.keySet());
            StringUtil.copyPartialMatches(args[0], custom_blocks_names, validNames);
            return validNames;
        }

        return List.of();
    }
}