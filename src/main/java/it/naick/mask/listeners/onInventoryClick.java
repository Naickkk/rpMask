package it.naick.mask.listeners;

import it.naick.mask.Mask;
import it.naick.mask.utils.Utils;
import me.neznamy.tab.shared.TAB;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class onInventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (Utils.isMask(e.getCurrentItem())) {

            if (e.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
                TAB.getInstance().getPlayer(player.getName()).showNametag();
                return;
            }

            if (e.getClick().equals(ClickType.SHIFT_LEFT)) {

                e.setCurrentItem(null);
                player.getInventory().setHelmet(Mask.getMask());
                player.updateInventory();

                TAB.getInstance().getPlayer(player.getName()).hideNametag();

            }
        }
    }
}
