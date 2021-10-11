package it.naick.mask.commands;

import it.naick.mask.Mask;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaskCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        player.getInventory().addItem(Mask.getMask());

        player.sendMessage("§aYou received the mask");

        return false;
    }
}
