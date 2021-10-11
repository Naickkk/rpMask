package it.naick.mask;

import com.google.common.collect.Lists;
import it.naick.mask.commands.MaskCommand;
import it.naick.mask.license.AdvancedLicense;
import it.naick.mask.listeners.onChat;
import it.naick.mask.listeners.onInteract;
import it.naick.mask.listeners.onInventoryClick;
import it.naick.mask.listeners.onJoin;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

import static it.naick.mask.utils.Utils.cc;

public final class Mask extends JavaPlugin {

    @Getter
    private static Mask instance;
    @Getter
    private static ItemStack mask;

    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        saveDefaultConfig();
        registerCommands();
        registerListeners();

        ItemStack itemStack = new ItemStack(Material.valueOf(this.getConfig().getString("item.material")));
        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> arrayList = Lists.newArrayList();

        for (String s : this.getConfig().getStringList("item.lore")) {
            arrayList.add(cc(s));
        }

        itemMeta.setLore(arrayList);
        itemMeta.setDisplayName(cc(this.getConfig().getString("item.displayname")));
        itemStack.setItemMeta(itemMeta);

        mask = itemStack;

        if (!new AdvancedLicense(getConfig().getString("license-key"), "https://unfathomed-foods.000webhostapp.com/verify.php", this).register())
            Bukkit.getPluginManager().disablePlugin(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new onInteract(), this);
        pluginManager.registerEvents(new onInventoryClick(), this);
        pluginManager.registerEvents(new onJoin(), this);
        pluginManager.registerEvents(new onChat(), this);

    }

    private void registerCommands() {

        getCommand("mask").setExecutor(new MaskCommand());

    }

}
