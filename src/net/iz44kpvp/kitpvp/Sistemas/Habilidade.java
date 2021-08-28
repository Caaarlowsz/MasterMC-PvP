package net.iz44kpvp.kitpvp.Sistemas;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class Habilidade {
	public static Map<String, String> powerMap;

	static {
		Habilidade.powerMap = new HashMap<String, String>();
	}

	public static String NomeDoKit(final String original) {
		if (original.length() == 0) {
			return original;
		}
		return String.valueOf(String.valueOf(original.substring(0, 1).toUpperCase())) + original.substring(1);
	}

	public static String getAbility(final Player player) {
		if (!Habilidade.powerMap.containsKey(player.getName())) {
			Habilidade.powerMap.put(player.getName(), "Nenhum");
		}
		return Habilidade.powerMap.get(player.getName());
	}

	public static void setAbility(final Player player, final String ability) {
		Habilidade.powerMap.put(player.getName(), ability);
	}

	public static void removeAbility(final Player p) {
		Habilidade.powerMap.remove(p.getName());
	}
}
