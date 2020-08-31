package me.Meat_Mattress.FireTrail;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.Meat_Mattress.FireTrail.commands.FireTrail;
import me.Meat_Mattress.FireTrail.commands.Toggler;

public class Main extends JavaPlugin {
	public static HashMap<Player, Boolean> toggleList = new HashMap<>();
	public static HashMap<Player,Location> playersPrevLoc = new HashMap<Player,Location>();
	
	@Override
	public void onEnable() {
		new FireTrail(this);
		getServer().getPluginManager().registerEvents(new Toggler(this), this);
		getServer().getPluginManager().registerEvents(new FireTrail(this), this);
	}
}
