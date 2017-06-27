package nl.gewoonhdgaming.drugs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

//import nl.gewoonhdgaming.commands.CommandCoke;

public class GUI implements Listener {
	
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, "§1§lDrugs Shop.");
		ItemStack cokeD = new ItemStack(Material.SUGAR);
		ItemMeta cokemeta = cokeD.getItemMeta();
		cokemeta.setDisplayName("§f§lCocaïne");
		ArrayList<String> cLore = new ArrayList<String>();
		cLore.add("§c§lLet op!");
		cLore.add("§fJe zult gaan trippen.");
		cokemeta.setLore(cLore);
		cokeD.setItemMeta(cokemeta);
		
		ItemStack weedD = new ItemStack(Material.DOUBLE_PLANT, 3);
		ItemMeta weedmeta = weedD.getItemMeta();
		cokemeta.setDisplayName("§a§lWeed");
		ArrayList<String> wLore = new ArrayList<String>();
		wLore.add("§c§lLet op!");
		wLore.add("§fJe word " + wLore.add("§a§lHigh."));
		weedmeta.setLore(wLore);
		weedD.setItemMeta(weedmeta);
		
		inv.setItem(2, cokeD);
		inv.setItem(3, weedD);
		
		p.openInventory(inv);
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			
		Player p = (Player)e.getWhoClicked();
		
		ItemStack item = e.getCurrentItem();
		
		if(item.hasItemMeta()) {
			if(e.getRawSlot() == 2) {
				ItemStack stack = new ItemStack(Material.SUGAR);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("§f§lCocaïne");
				stack.setItemMeta(meta);
				p.getInventory().addItem(stack);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPunch(PlayerInteractEvent e) {
	Player p = e.getPlayer();
		if(p.getItemInHand().getType().equals(Material.ENDER_CHEST)) {
			openGUI(p);
			p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 10, 1);
		} else if(p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().getDisplayName().equals("Open GUI") && p.getItemInHand().getType().equals(Material.ARROW)) {
			openGUI(p);
			p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 1);
		}
	}
}
