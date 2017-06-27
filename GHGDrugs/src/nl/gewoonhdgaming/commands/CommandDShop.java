package nl.gewoonhdgaming.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandDShop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String level, String[] args) {
		if(sender.hasPermission("drugs.dealer")) {
			if(sender instanceof Player) {
				ItemStack stack = new ItemStack(Material.ENDER_CHEST);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("§1§lDrugs Shop.");
				stack.setItemMeta(meta);
				((Player)sender).getInventory().addItem(stack);
			} else {
				sender.sendMessage("§cJe moet een Dealer zijn!");
			}
		} else {
			sender.sendMessage("§cJe moet een Dealer zijn!");
		}
		return true;
	}

}
