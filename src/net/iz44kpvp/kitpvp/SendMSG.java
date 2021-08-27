package net.iz44kpvp.kitpvp;

import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;

public class SendMSG implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; ++i) {
            sb.append(args[i]).append(" ");
        }
        final String motivo = sb.toString().trim();
        if (cmd.getName().equalsIgnoreCase("sendmsg")) {
            final Player t = Bukkit.getPlayer(args[0]);
            if (args.length < 2) {
                sender.sendMessage("�6Master�fMC � �eComando incorreto.");
                sender.sendMessage("�6Master�fMC � &fUse: &e/sendmsg <msg>");
                return true;
            }
            t.sendMessage(motivo);
            sender.sendMessage("�aVoce --> " + t.getName() + " : �f " + motivo);
        }
        return false;
    }
}