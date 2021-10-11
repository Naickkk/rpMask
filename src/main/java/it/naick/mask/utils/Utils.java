package it.naick.mask.utils;

import it.naick.mask.Mask;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class Utils {

    public static String cc(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static boolean isMask(ItemStack itemStack) {
        return (itemStack != null
                && itemStack.getType().equals(Mask.getMask().getType())
                && itemStack.hasItemMeta()
                && itemStack.getItemMeta().hasDisplayName()
                && itemStack.getItemMeta().getDisplayName().equals(Mask.getMask().getItemMeta().getDisplayName()));
    }
}
