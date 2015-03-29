package pl.za.xvacuum.qessentials.stonegenerator;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import pl.za.xvacuum.qessentials.Main;

public class StoneMain {
	
	public static void createRecipe(){
		ItemStack sg = new ItemStack(Material.ENDER_STONE, 1);
	    ItemMeta meta = sg.getItemMeta();
	    meta.setDisplayName("§7Stoniarka");
	    sg.setItemMeta(meta);
	    ShapedRecipe stonegenerator = new ShapedRecipe(sg).shape(new String[] { 
	      "DAD", 
	      "ABA", 
	      "DCD" })
	      .setIngredient('A', Material.IRON_INGOT)
	      .setIngredient('B', Material.STONE)
	      .setIngredient('C', Material.PISTON_BASE)
	      .setIngredient('D', Material.REDSTONE);
	    Main.getInstance().getServer().addRecipe(stonegenerator); 
	}

}
