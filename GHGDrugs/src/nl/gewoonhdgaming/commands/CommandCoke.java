package nl.gewoonhdgaming.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandCoke implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String level, String[] args) {
		if(sender.hasPermission("drugs.coke")) {
			if(sender instanceof Player) {
				ItemStack stack = new ItemStack(Material.SUGAR);
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName("§f§lCocaïne");
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
