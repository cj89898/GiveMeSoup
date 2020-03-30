package net.cjservers.givemesoup;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class GiveMeSoup extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("givemesoup").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		
		Player p = (Player) sender;
		if (!p.hasPermission("givemesoup.access")) {
			p.sendMessage(ChatColor.RED + "No permission");
			return false;
		}
		
		PlayerInventory inv = p.getInventory();
		p.getInventory().forEach(item -> {
			if (item == null)
				inv.addItem(new ItemStack(Material.MUSHROOM_SOUP));
		});
		return true;
	}
	
}
