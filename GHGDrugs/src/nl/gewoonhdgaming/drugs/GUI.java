package nl.gewoonhdgaming.drugs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nl.gewoonhdgaming.commands.CommandCoke;

public class GUI implements Listener {
	
	public static void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, "§1Drugs Shop.");
		ItemStack cokeS = new ItemStack(Material.SUGAR);
		ItemMeta cokemeta = cokeS.getItemMeta();
		cokemeta.setDisplayName("§f§lCocaïne");
		ArrayList<String> sLore = new ArrayList<String>();
		sLore.add("§c§lLet op!");
		sLore.add("§fJe zult gaan trippen.");
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			
		Player p = (Player)e.getWhoClicked();
		}
	}

}
