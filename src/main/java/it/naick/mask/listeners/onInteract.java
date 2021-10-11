package it.naick.mask.listeners;

import it.naick.mask.Mask;
import it.naick.mask.utils.Utils;
import me.neznamy.tab.shared.TAB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class onInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (!Utils.isMask(player.getInventory().getItemInMainHand())) return;

        player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
        player.getInventory().setHelmet(Mask.getMask());
        player.updateInventory();

        TAB.getInstance().getPlayer(player.getName()).hideNametag();
    }

}
