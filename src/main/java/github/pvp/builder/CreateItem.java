package github.pvp.builder;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CreateItem {

    public static ItemStack itemStack(Material material, String nome, String lore, Enchantment enchant, int levelEnchant) {
        ItemStack item = new ItemStack(material);
        item.addUnsafeEnchantment(enchant, levelEnchant);
        ItemMeta itemmeta = item.getItemMeta();
        List<String> iteml = new ArrayList<String>();
        iteml.add(lore);
        itemmeta.setLore(iteml);
        itemmeta.setDisplayName(nome);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack itemStack(Material material, String nome, int amount, int durability) {
        ItemStack item = new ItemStack(material, amount, (short) durability);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack itemStack(Material material, String nome, List<String> lore, int amount, int durability) {
        ItemStack item = new ItemStack(material, amount, (short) durability);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        itemmeta.setLore(lore);
        item.setItemMeta(itemmeta);

        return item;
    }

    public static void setItem(Player p, int i, ItemStack item) {
        i--;
        p.getInventory().setItem(i, item);
        p.updateInventory();
    }

    public static ItemStack itemStack(Material material, String nome) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(nome);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack itemStack(Material material, String nome, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setLore(lore);
        itemmeta.setDisplayName(nome);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack itemSkull(String p, String name, List<String> lore) {
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta mItem = (SkullMeta) item.getItemMeta();
        mItem.setOwner(p);
        mItem.setDisplayName(name);
        mItem.setLore(lore);
        item.setItemMeta(mItem);
        return item;
    }


}