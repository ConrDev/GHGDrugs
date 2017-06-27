package nl.gewoonhdgaming.drugs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import nl.gewoonhdgaming.commands.CommandCoke;
import nl.gewoonhdgaming.commands.CommandDShop;

public class Main extends JavaPlugin {
		
		@Override
		public void onEnable() {
			loadConfiguration();
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "--------{De GHGDrugs Plugin}-------");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|       Created by: WTGConner     |");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.YELLOW + "|      Plugin Status:  Enabled    |");
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[GHG] " + ChatColor.GOLD + "-----------------------------------");
			getServer().getPluginManager().registerEvents(new GUI(), this);
			getCommand("coke").setExecutor(new CommandCoke());
			getCommand("drugsshop").setExecutor(new CommandDShop());
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
	        Bukkit.broadcastMessage("De GHGDrugs Plugin is geladen");
	}
	    
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
	Player p = e.getPlayer();
		if(e.getItem() != null) {
			if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(e.getItem().getType() == Material.SUGAR) {
					if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§f§lCocaïne")) {
						p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, (float) 1, (float) 1.5);
						p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000, 1800));
						p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 1800));
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1, 1800));
						p.sendMessage(ChatColor.WHITE + "Je hebt zojuist Cocaïne gebruikt! " + ChatColor.RED + "Helaas ben je nu verslaafd.");
					}
				}
			}
		}
	}

	
}
