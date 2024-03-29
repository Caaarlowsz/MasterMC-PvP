package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Phantom implements Listener {
	public static HashMap<String, ItemStack[]> salvararmor;
	public static ArrayList<String> emphantom;

	static {
		Phantom.salvararmor = new HashMap<String, ItemStack[]>();
		Phantom.emphantom = new ArrayList<String>();
	}

	@EventHandler
	public void aogigante(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Phantom")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.FEATHER) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			Phantom.salvararmor.put(p.getName(), p.getInventory().getArmorContents());
			API.tirarArmadura(p);
			p.getInventory()
					.setArmorContents(new ItemStack[] { API.darArmadura(Material.LEATHER_HELMET, Color.WHITE),
							API.darArmadura(Material.LEATHER_CHESTPLATE, Color.WHITE),
							API.darArmadura(Material.LEATHER_LEGGINGS, Color.WHITE),
							API.darArmadura(Material.LEATHER_BOOTS, Color.WHITE) });
			p.updateInventory();
			Phantom.emphantom.add(p.getName());
			p.setAllowFlight(true);
			p.setFlying(true);
			Cooldown.add(p, 20);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�7O �bfly �7est\u00e1 acabando em �b5�7s");
				}
			}, 0L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�7O �bfly �7est\u00e1 acabando em �b4�7s");
				}
			}, 20L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�7O �bfly �7est\u00e1 acabando em �b3�7s");
				}
			}, 40L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�7O �bfly �7est\u00e1 acabando em �b2�7s");
				}
			}, 60L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�7O �bfly �7est\u00e1 acabando em �b1�7s");
				}
			}, 80L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�7O �bfly �7est\u00e1 acabou");
					Phantom.emphantom.remove(p.getName());
					p.getInventory().setArmorContents((ItemStack[]) Phantom.salvararmor.get(p.getName()));
					p.updateInventory();
					p.setAllowFlight(false);
					p.setFlying(false);
				}
			}, 100L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 400L);
		}
	}

	@EventHandler
	public void aoinv(final InventoryClickEvent e) {
		try {
			final Player p = (Player) e.getWhoClicked();
			if (Phantom.emphantom.contains(p.getName())
					&& e.getSlotType().equals((Object) InventoryType.SlotType.ARMOR)) {
				e.setCancelled(true);
			}
		} catch (Exception ex) {
		}
	}
}
