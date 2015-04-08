package pl.za.xvacuum.qessentials.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import pl.za.xvacuum.qessentials.utils.QCommand;
import pl.za.xvacuum.qessentials.utils.Util;

public class Repair extends QCommand{

	public Repair() {
		super("repair", "Naprawa przedmiotow", "/repair [all/armor]", "repair", Arrays.asList(new String[] { "qrepair", "rep", "napraw"  }), true);
		
	}
	
	Material[] canRepair = { Material.DIAMOND_PICKAXE, Material.DIAMOND_SWORD, Material.DIAMOND_SPADE, Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.IRON_PICKAXE, Material.IRON_SWORD, Material.IRON_SPADE, Material.IRON_AXE, Material.IRON_HOE, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.GOLD_PICKAXE, Material.GOLD_SWORD, Material.GOLD_SPADE, Material.GOLD_AXE, Material.GOLD_HOE, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, Material.STONE_PICKAXE, Material.STONE_SWORD, Material.STONE_SPADE, Material.STONE_AXE, Material.STONE_HOE, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.WOOD_PICKAXE, Material.WOOD_SWORD, Material.WOOD_SPADE, Material.WOOD_AXE, Material.WOOD_HOE, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.FLINT_AND_STEEL, Material.SHEARS, Material.BOW, Material.FISHING_ROD, Material.ANVIL };

	public boolean contains(Material[] board, Material material) {
		for (Material othermaterial : board) {
			if (material.equals(othermaterial)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void onExecute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if(args.length == 0){
			ItemStack i = p.getItemInHand();
			if(i != null && contains(canRepair, i.getType())) {
				i.setDurability((short) 0);
			}
			p.updateInventory();
			Util.sendMessage(p, "&7Pomyslnie naprawiono przedmiot w twojej rece!");
			return;
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("all")) {
				for(ItemStack is : p.getInventory().getContents()) {
					if(is != null && contains(canRepair, is.getType())) {
						is.setDurability((short) 0);
					}
				}
				
				for(ItemStack is : p.getInventory().getArmorContents()) {
					if(is != null && contains(canRepair, is.getType())) {
						is.setDurability((short) 0);
					}
				}
				p.updateInventory();
				Util.sendMessage(p, "&7Pomyslnie naprawiono caly ekwipunek!");
				return;
				
			} else if(args[0].equalsIgnoreCase("armor")) {
				for(ItemStack is : p.getInventory().getArmorContents()) {
					if(is != null && contains(canRepair, is.getType())) {
						is.setDurability((short) 0);
					}
				}
				p.updateInventory();
				Util.sendMessage(p, "&7Pomyslnie naprawiono cala zbroje!");
				return;
			} else {
				Util.sendMessage(p, "&cPoprawne uzycie: /repair [all/armor]");
			}
			return;
		}
		
	}

}
