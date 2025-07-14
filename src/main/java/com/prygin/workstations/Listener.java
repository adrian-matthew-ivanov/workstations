package com.prygin.workstations;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;


public class Listener implements org.bukkit.event.Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setResourcePack("https://github.com/adrian-matthew-ivanov/workstations/tree/develop/src/main/resources/resourcepack");
    }
}
