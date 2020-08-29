package me.Meat_Mattress.FireTrail.commands;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.Meat_Mattress.FireTrail.Main;

public class FireTrail implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;
	public FireTrail(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		if (Main.toggleList.get(event.getPlayer()) == true) {
		    Location to = event.getTo();
		    Location from = event.getFrom();
		    Block prev = from.subtract(0,1,0).getBlock(); // gets block underneath player
		    if (to.getBlockX() == from.getBlockX() && to.getBlockY() == from.getBlockY() && to.getBlockZ() == from.getBlockZ()) {
		        return; // did not actually move to a new block. do nothing.
		    }
		    else {
		    	prev.getRelative(BlockFace.UP).setType(Material.FIRE);
		    }
		}
    }
}