package com.prygin.workstations;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.MetadataValue;
import org.eclipse.aether.metadata.Metadata;


public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack("src/main/resources/resourcepack");
    }
}
