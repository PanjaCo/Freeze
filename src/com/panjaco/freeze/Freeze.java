package com.panjaco.freeze;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.panjaco.freeze.events.onPlayerMovement;

public class Freeze extends JavaPlugin{
	
	public static ArrayList<Player> frozenPlayers = new ArrayList<Player>();
	public static ArrayList<Location> frozenLocation = new ArrayList<Location>();

	public void onEnable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Double Jump] Enabled");
		
		//Register commands
		getCommand("freeze").setExecutor(new FreezePlayer());
		
		
		//Register listeners
		Bukkit.getPluginManager().registerEvents(new onPlayerMovement(), this);
		
	}
	
	public void onDisable(){
		
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Double Jump] Disabled");
		
	}
	
}
