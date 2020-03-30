package net.cjservers.givemesoup;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class GiveMeSoup extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("givemesoup").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("givemesoup")) {
				if (p.hasPermission("givemesoup.access")) {
					PlayerInventory inv = p.getInventory();
					for (int i = 0; i < inv.getSize(); ++i) {
						if (inv.getItem(i) == null) {
							inv.setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
}
