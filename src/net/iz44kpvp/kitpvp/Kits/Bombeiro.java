package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Bombeiro implements Listener {
	@EventHandler
	public void bombeiro(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Bombeiro")
				&& (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)
				&& p.getInventory().getItemInHand().getType() == Material.TORCH) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			API.darEfeito(p, PotionEffectType.SPEED, 100, 3);
			API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 100, 2);
			API.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 100, 3);
			API.darEfeito(p, PotionEffectType.FIRE_RESISTANCE, 100, 3);
			p.sendMessage(String.valueOf(String.valueOf(API.preffix))
					+ "�bVoc\u00ea apagou o fogo de pessoas perto 5 blocos de voc\u00ea");
			p.setFireTicks(0);
			for (final Entity perto : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				perto.setFireTicks(0);
				((CommandSender) perto)
						.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�bUm bombeiro apagou seu fogo");
			}
			Cooldown.add(p, 40);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 800L);
		}
	}
}
