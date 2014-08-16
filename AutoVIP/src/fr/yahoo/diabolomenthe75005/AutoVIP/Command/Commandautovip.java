package fr.yahoo.diabolomenthe75005.AutoVIP.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;

public class Commandautovip implements CommandExecutor {
	protected Plugin plugin = null;

	//Constructeur
	public Commandautovip(Plugin plugin){
		this.plugin = plugin;
	}

	//Commande
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			String uuid = player.getUniqueId().toString();

			if(verifArgs(player,args)) {
				//Recherche de l'uuid
				SqlQuery bean = plugin.getDatabase().createSqlQuery("SELECT h.uuid FROM payment_header h WHERE h.playername = :playername AND h.forumname = :forumname");
				bean.setParameter("playername", args[0]);
				bean.setParameter("forumname", args[1]);
				SqlRow headerline = bean.findUnique();

				if(headerline == null){
					player.sendMessage("Combinaison playername et forumname inconnu");
				} else {
					if(headerline.getString("uuid").equalsIgnoreCase("")){

						SqlUpdate update = plugin.getDatabase().createSqlUpdate("UPDATE payment_header h SET uuid = :uuid WHERE h.playername = :playername AND h.forumname = :forumname");
						update.setParameter("playername", args[0]);
						update.setParameter("forumname", args[1]);
						update.setParameter("uuid", uuid);
						update.execute();
						player.sendMessage("UUID associé a votre compte forum");
					} else {
						player.sendMessage("Cet uuid est déjà associé à un compte");
					}
				}
			}
		} else {
			sender.sendMessage("Cette commande doit être lancée par un joueur");
		}


		return true;
	}

	private boolean verifArgs(Player player,String[] args){
		if(args.length == 2 ){
		if(args[0].length() == 0 || args[1].length() == 0){
			player.sendMessage("/autovip <player> <forumname>");
			return false;
		}
		} else {
			player.sendMessage("/autovip <player> <forumname>");
			return false;
		}
		return true;

	}
}


