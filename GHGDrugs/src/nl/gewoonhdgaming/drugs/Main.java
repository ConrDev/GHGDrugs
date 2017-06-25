package nl.gewoonhdgaming.drugs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin {
		
		@Override
		public void onEnable() {
			loadConfiguration();
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "--------{De GHGDrugs Plugin}-------");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|       Created by: WTGConner     |");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|      Plugin Status:  Enabled    |");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "-----------------------------------");
		}
		
		@Override
		public void onDisable() {
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "-------{De GHGDrugs Plugin}--------");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|       Created by: WTGConner     |");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|      Plugin Status: Disabled    |");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "-----------------------------------");
		}

	    public void loadConfiguration(){
	        getConfig().options().copyDefaults(true);
	        getConfig().addDefault("key.default", "Dont_Remove_Me!");
	        saveConfig();
	        getLogger().info("Configuratie Herladen");
	        Bukkit.broadcastMessage("De Sexuele Plugin is geladen");
	}
	    
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getItem() != null) {
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(event.getItem().getType() == Material.SUGAR) {
					if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§fCocaïne")) {
						event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000, 5));
						event.getPlayer().setWalkSpeed(0.1F);
					}
				}
			}
		}
		
	}
}
