package me.Meat_Mattress.FireTrail.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.Meat_Mattress.FireTrail.Main;

public class Toggler implements CommandExecutor, Listener {
	@SuppressWarnings("unused")
	private Main plugin;
	public Toggler (Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("FireTrail").setExecutor(this);
	}
	
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Main.toggleList.put(player, false);
        Main.playersPrevLoc.put(event.getPlayer(), event.getPlayer().getLocation());
        player.sendMessage("You have been added to the toggle list (off). use /fireTrail on to enable (for all)");
    }

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String playerName;
		String state;
		if (args[0].equalsIgnoreCase("on")) { // if command is: /fireTrail on
			Main.toggleList.replaceAll((k,v)->v=true);
		}
		else if (args[0].equalsIgnoreCase("off")) { // if command is: /fireTrail off
			Main.toggleList.replaceAll((k,v)->v=false);
		}
		else {
			playerName = args[0];
			Player player = p.getServer().getPlayer(playerName);
			state = args[1];
			if (state.equalsIgnoreCase("ON")){
				Main.toggleList.replace(player, true); // player trail toggled on
			}
			else if (state.equalsIgnoreCase("OFF")) {
				Main.toggleList.replace(player, false); // player trail toggled off
		}
		}
		return true;
	}
}
