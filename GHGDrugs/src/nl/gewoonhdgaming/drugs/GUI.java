package nl.gewoonhdgaming.drugs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {
	
	public static Inventory dShop = Bukkit.createInventory(null, 9, "§1§lDrugs Shop");
	
	static {
		dShop.setItem(2, new ItemStack(Material.SUGAR, 1));
		dShop.setItem(3, new ItemStack(Material.DOUBLE_PLANT, 3));
	}
	
	public static void createDisplay(Inventory inv, int Slot, String lore) {
		ItemStack Coke = new ItemStack(Material.SUGAR, 1);
		ItemMeta Cokemeta = Coke.getItemMeta();
		Cokemeta.setDisplayName("§f§lCocaïne");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("§c§lLet op!");
		Lore.add("§fJe zult gaan trippen.");
		
		inv.setItem(2, Coke);
		
		ItemStack Weed = new ItemStack(Material.DOUBLE_PLANT, 3);
		ItemMeta Weedmeta = Weed.getItemMeta();
		Weedmeta.setDisplayName("§a§lWeed");
		Lore.add("§c§lLet op!");
		Lore.add("§fJe word " + Lore.add("§a§lHigh."));
		
		inv.setItem(3, Weed);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
	Player p = (Player)e.getWhoClicked();
	ItemStack Clicked = e.getCurrentItem();
	Inventory inv = e.getInventory();
	//Coke Item
	ItemStack Coke = new ItemStack(Material.SUGAR, 1);
	ItemMeta Cokemeta = Coke.getItemMeta();
	Cokemeta.setDisplayName("§f§lCocaïne");
	ArrayList<String> Lore = new ArrayList<String>();
	Lore.add("§c§lLet op!");
	Lore.add("§fJe zult gaan trippen.");
	//Weed Item
	ItemStack Weed = new ItemStack(Material.SUGAR, 1);
	ItemMeta Weedmeta = Weed.getItemMeta();
	Weedmeta.setDisplayName("§f§lWeed");
	Lore.add("§c§lLet op!");
	Lore.add("§fJe word " + Lore.add("§a§lHigh."));
	
	//Geeft de speler Cocaïne.
	if(inv.getName().equals(dShop.getName()));
		if(Clicked.getType() == Material.SUGAR) {
			e.setCancelled(true);
			p.getInventory().addItem(new ItemStack(Coke));
		}
	
	//Geef de speler Weed.
	if(inv.getName().equals(dShop.getName()));
		if(Clicked.getType() == Material.DOUBLE_PLANT) {
			e.setCancelled(true);
			p.getInventory().addItem(new ItemStack(Weed));
		}
	}
	
	
}
