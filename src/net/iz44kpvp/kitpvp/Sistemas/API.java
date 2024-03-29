package net.iz44kpvp.kitpvp.Sistemas;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import ca.wacos.nametagedit.NametagAPI;
import net.iz44kpvp.kitpvp.Main;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class API {
	public static String Motd;
	public static String StatusMotd;
	public static String NomeServer;
	public static String AutoM1;
	public static String AutoM2;
	public static String AutoM3;
	public static String AutoM4;
	public static String AutoM5;
	public static String MSGAplicar1;
	public static String MSGYoutuber1;
	public static String MSGYoutuber2;
	public static String MSGYoutuber3;
	public static String preffix;
	public static String jogadoroff;
	public static String semperm;
	public static String semconsole;
	public static String comkit;
	public static String semkit;
	public static String fimcooldown;
	public static String bloquearpvp;
	public static String naotemtag;

	static {
		API.Motd = Main.getInstance().getConfig().getString("Motd").replace("&", "�");
		API.StatusMotd = Main.getInstance().getConfig().getString("StatusMotd").replace("&", "�");
		API.NomeServer = Main.getInstance().getConfig().getString("NomeServer").replace("&", "�");
		API.AutoM1 = Main.getInstance().getConfig().getString("MensagemAutomatica1").replace("&", "�");
		API.AutoM2 = Main.getInstance().getConfig().getString("MensagemAutomatica2").replace("&", "�");
		API.AutoM3 = Main.getInstance().getConfig().getString("MensagemAutomatica3").replace("&", "�");
		API.AutoM4 = Main.getInstance().getConfig().getString("MensagemAutomatica4").replace("&", "�");
		API.AutoM5 = Main.getInstance().getConfig().getString("MensagemAutomatica5").replace("&", "�");
		API.MSGAplicar1 = Main.getInstance().getConfig().getString("MensagemAplicar1").replace("&", "�");
		API.MSGYoutuber1 = Main.getInstance().getConfig().getString("MensagemYoutuber1").replace("&", "�");
		API.MSGYoutuber2 = Main.getInstance().getConfig().getString("MensagemYoutuber2").replace("&", "�");
		API.MSGYoutuber3 = Main.getInstance().getConfig().getString("MensagemYoutuber3").replace("&", "�");
		API.preffix = String.valueOf(String.valueOf(API.NomeServer)) + " �c\u27a1 ";
		API.jogadoroff = String.valueOf(String.valueOf(API.preffix)) + "�cJogador offline ou inexistente";
		API.semperm = String.valueOf(String.valueOf(API.preffix)) + "�cVoc\u00ea n\u00e3o tem permiss\u00e3o";
		API.semconsole = String.valueOf(String.valueOf(API.preffix)) + "�cConsole n\u00e3o pode digitar esse comando";
		API.comkit = String.valueOf(String.valueOf(API.preffix)) + "�7Voc\u00ea ja esta com kit";
		API.semkit = String.valueOf(String.valueOf(API.preffix)) + "�cVoc\u00ea n\u00e3o possui esse kit";
		API.fimcooldown = String.valueOf(String.valueOf(API.preffix))
				+ "�aVoc\u00ea n\u00e3o est\u00e1 mais em cooldown";
		API.bloquearpvp = String.valueOf(String.valueOf(API.preffix)) + "�aBloqueado em pvp";
		API.naotemtag = String.valueOf(String.valueOf(API.preffix)) + "�cVoc\u00ea n\u00e3o possui essa tag";
	}

	public static ItemStack darArmadura(final Material material, final Color cor) {
		final ItemStack item = new ItemStack(material);
		final LeatherArmorMeta itemm = (LeatherArmorMeta) item.getItemMeta();
		itemm.setColor(cor);
		item.setItemMeta((ItemMeta) itemm);
		return item;
	}

	public static void MensagemCooldown(final Player p) {
		p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "�bVoc\u00ea est\u00e1 em cooldown de: �5"
				+ Cooldown.cooldown(p) + "�bs");
	}

	public static void darItem(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static void darItemInv(final Inventory inv, final Material mat, final int quantidade, final int modo,
			final String nome, final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade, (short) modo);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		inv.setItem(lugar, item);
	}

	public static void darItemInvDesc(final Inventory inv, final Material mat, final int quantidade, final int modo,
			final String nome, final String desc, final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade, (short) modo);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		final ArrayList<String> descitem = new ArrayList<String>();
		descitem.add(desc);
		itemmeta.setLore(descitem);
		item.setItemMeta(itemmeta);
		inv.setItem(lugar, item);
	}

	public static void novaReceita() {
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP, 1);
		final ItemMeta sopam = sopa.getItemMeta();
		sopam.setDisplayName("�aSopinha");
		sopa.setItemMeta(sopam);
		final ShapelessRecipe SopaNormal = new ShapelessRecipe(sopa);
		SopaNormal.addIngredient(1, Material.BROWN_MUSHROOM);
		SopaNormal.addIngredient(1, Material.RED_MUSHROOM);
		SopaNormal.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe((Recipe) SopaNormal);
	}

	public static void venderItem(final InventoryClickEvent e, final Player p, final Material materialdoinv,
			final int pre\u00e7o, final String coisacomprada, final String permissao) {
		if (e.getCurrentItem().getType() == materialdoinv) {
			e.setCancelled(true);
			if (KillsDeathsRankXp.getXp(p) >= pre\u00e7o) {
				KillsDeathsRankXp.removerXp(p, pre\u00e7o);
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + coisacomprada);
				PermissionsEx.getUser(p).addPermission(permissao);
				p.closeInventory();
			} else {
				p.sendMessage(
						String.valueOf(String.valueOf(API.preffix)) + "�cVoc\u00ea n\u00e3o possui xp suficiente");
			}
		}
	}

	public static void venderCaixa(final InventoryClickEvent e, final Player p, final String nomedomaterial,
			final int pre\u00e7o, final String coisacomprada, final int quantidade) {
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(nomedomaterial)) {
			e.setCancelled(true);
			if (KillsDeathsRankXp.getXp(p) >= pre\u00e7o) {
				KillsDeathsRankXp.removerXp(p, pre\u00e7o);
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + coisacomprada);
				KillsDeathsRankXp.adicionarCaixa(p, quantidade);
				p.closeInventory();
			} else {
				p.sendMessage(
						String.valueOf(String.valueOf(API.preffix)) + "�cVoc\u00ea n\u00e3o possui xp suficiente");
			}
		}
	}

	public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
		p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
	}

	public static void tirarEfeitos(final Player p) {
		p.removePotionEffect(PotionEffectType.ABSORPTION);
		p.removePotionEffect(PotionEffectType.BLINDNESS);
		p.removePotionEffect(PotionEffectType.CONFUSION);
		p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		p.removePotionEffect(PotionEffectType.HARM);
		p.removePotionEffect(PotionEffectType.HEAL);
		p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		p.removePotionEffect(PotionEffectType.HUNGER);
		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		p.removePotionEffect(PotionEffectType.INVISIBILITY);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.removePotionEffect(PotionEffectType.NIGHT_VISION);
		p.removePotionEffect(PotionEffectType.POISON);
		p.removePotionEffect(PotionEffectType.REGENERATION);
		p.removePotionEffect(PotionEffectType.SATURATION);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.WATER_BREATHING);
		p.removePotionEffect(PotionEffectType.WEAKNESS);
		p.removePotionEffect(PotionEffectType.WITHER);
	}

	public static String getKit(final Player p) {
		return Habilidade.getAbility(p);
	}

	public static void darSopa(final Player p, final int quantas) {
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta msopa = sopa.getItemMeta();
		msopa.setDisplayName("�aSopinha");
		sopa.setItemMeta(msopa);
		for (int i = 0; i < quantas; ++i) {
			p.getInventory().setItem(p.getInventory().firstEmpty(), new ItemStack(sopa));
		}
	}

	public static int getItemNoInv(final Player p, final Material Mat) {
		int value = 0;
		ItemStack[] contents;
		for (int length = (contents = p.getInventory().getContents()).length, i = 0; i < length; ++i) {
			final ItemStack item = contents[i];
			if (item != null && item.getType() == Mat && item.getAmount() > 0) {
				value += item.getAmount();
			}
		}
		return value;
	}

	public static void CoisasNoNome(final Player p) {
		NametagAPI.setSuffix(p.getName(), " �7(" + KillsDeathsRankXp.getRankPequeno(p) + "�7)");
	}

	public static void tirarArmadura(final Player p) {
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));
		p.getInventory().setBoots(new ItemStack(Material.AIR));
	}

	public static void darItemBussola(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static void darItemInkSack(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar) {
		final ItemStack item = new ItemStack(mat, quantidade, (short) 10);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static void darItemEnchant(final Player p, final Material mat, final int quantidade, final String nome,
			final int lugar, final Enchantment enchant, final int level, final boolean trueorfalse) {
		final ItemStack item = new ItemStack(mat, quantidade);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.addEnchant(enchant, level, trueorfalse);
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static void playFirework(final Location location, final Color color, final Player p) {
		final Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
		final FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(FireworkEffect.builder().withColor(color).build());
		firework.setFireworkMeta(fMeta);
		firework.setVelocity(new Vector(0.0, -1.0, 0.0));
	}

	public void playFirework(final Location location, final FireworkEffect effecta, final Player p) {
		final Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
		final FireworkMeta fMeta = firework.getFireworkMeta();
		fMeta.addEffect(effecta);
		firework.setFireworkMeta(fMeta);
	}

	public static void ItemServer(final Player p) {
		darItemBussola(p, Material.COMPASS, 1, "�e�lWARPS", 1);
		darItem(p, Material.ENDER_CHEST, 1, "�e�lCAIXA", 3);
		darItem(p, Material.CHEST, 1, "�e�lKITS", 4);
		darItem(p, Material.PAPER, 1, "�e�lRANKS", 5);
		darItemInkSack(p, Material.INK_SACK, 1, "�e�lLOJAS", 7);
	}
}
