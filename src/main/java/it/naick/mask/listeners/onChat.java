package it.naick.mask.listeners;

import it.naick.mask.Mask;
import it.naick.mask.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static it.naick.mask.utils.Utils.cc;

public class onChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();

        if (Utils.isMask(player.getInventory().getHelmet()))
            e.setFormat(cc(Mask.getInstance().getConfig().getString("config.chat")).replaceAll("%message%", e.getMessage().toString()));
    }
}
