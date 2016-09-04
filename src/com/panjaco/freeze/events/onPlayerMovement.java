package com.panjaco.freeze.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.panjaco.freeze.Freeze;

public class onPlayerMovement implements Listener {

	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		
		Player player = event.getPlayer();
		
		if(Freeze.frozenPlayers.contains(player)){
			
			int index = Freeze.frozenPlayers.indexOf(player);
			Location location = (Location) Freeze.frozenLocation.toArray()[index];
			
			double x = location.getX();
			double y = location.getY();
			double z = location.getZ();
			
			if(player.getLocation().getX() != location.getX() || player.getLocation().getY() != location.getY() || player.getLocation().getZ() != location.getZ()){
				float yaw = player.getLocation().getYaw();
				float pitch = player.getLocation().getPitch();
				
				location = new Location(Bukkit.getPlayer(player.getName()).getWorld(), x, y, z, yaw, pitch);
				
				player.teleport(location);
			}
			

		}
	}
	
}
