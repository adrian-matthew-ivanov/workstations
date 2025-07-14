package com.prygin.workstations;

import com.prygin.workstations.commands.giveCustomBlockCommand;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Workstations extends JavaPlugin {

    private final Map<String, ItemStack> custom_items = new HashMap<>();

    public Map<String, ItemStack> get_custom_blocks(){
        return custom_items;
    }

    private void createItem(String displayName, String id, Material material, String item_model) {
        ItemStack item = new ItemStack(material);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName(displayName);
        if (item_model != null) {
            item_meta.setItemModel(new NamespacedKey("workstations", item_model));
        }
        item.setItemMeta(item_meta);
        custom_items.put(id, item);
    }

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        // Create Custom Items
        createItem("§fTest Item", "test_item", Material.PAPER, null);

        this.getServer().getCommandMap().register("customitem", new giveCustomBlockCommand(this));

        getLogger().info("Workstations Loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
