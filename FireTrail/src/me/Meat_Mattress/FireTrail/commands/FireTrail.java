package me.Meat_Mattress.FireTrail.commands;

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
	public void onMove(PlayerMoveEvent event) throws InterruptedException {
		if (Main.toggleList.get(event.getPlayer()) == true) {
		    double dist = event.getPlayer().getLocation().distance(Main.playersPrevLoc.get(event.getPlayer()));
		    if(dist >= 1) {
		    	Block toSet = Main.playersPrevLoc.get(event.getPlayer()).subtract(0,1,0).getBlock();
		    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		    		 
		    	    @Override
		    	    public void run() {
		    	    	toSet.getRelative(BlockFace.UP).setType(Material.FIRE);
		    	    }
		    	
		    	}, 2);
		    	Main.playersPrevLoc.put(event.getPlayer(), event.getPlayer().getLocation());
		    }
		}
    }
}