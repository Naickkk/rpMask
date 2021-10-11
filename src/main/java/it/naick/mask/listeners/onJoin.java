package it.naick.mask.listeners;

import it.naick.mask.utils.Utils;
import me.neznamy.tab.shared.TAB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (player.getInventory().getHelmet() != null) return;

        if (Utils.isMask(player.getInventory().getHelmet()))
            TAB.getInstance().getPlayer(player.getName()).hideNametag();

    }
}
