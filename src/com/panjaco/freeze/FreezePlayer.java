package com.panjaco.freeze;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class FreezePlayer implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		Location location = player.getLocation();
		
		if(args.length == 1){
			try{
				player = Bukkit.getPlayer(args[0]);
			}catch(Exception e){
				sender.sendMessage(ChatColor.AQUA + "[Freeze] " + ChatColor.RED + args[0] + " could not be found!");
				return true;
			}
		}
		location = player.getLocation();
		if(Freeze.frozenPlayers.contains(player)){
			int index = Freeze.frozenPlayers.indexOf(player);
			Freeze.frozenPlayers.remove(player);
			Freeze.frozenPlayers.remove(location);
			player.sendMessage(ChatColor.AQUA + "[Freeze] " + ChatColor.GREEN + " You have been unfrozen!");
			if(player != sender){
				sender.sendMessage(ChatColor.AQUA + "[Freeze] " + ChatColor.GREEN + player.getDisplayName() + " has been unfrozen!");
			}
		}else{
			Freeze.frozenPlayers.add(player);
			Freeze.frozenLocation.add(location);
			player.sendMessage(ChatColor.AQUA + "[Freeze] " + ChatColor.RED + " You have been frozen!");
			if(player != sender){
				sender.sendMessage(ChatColor.AQUA + "[Freeze] " + ChatColor.RED + player.getDisplayName() + " has been frozen!");
			}
		}
		return true;
	}

}
