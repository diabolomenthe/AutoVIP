package fr.yahoo.diabolomenthe75005.AutoVIP;

import java.util.List;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.Plugin;

import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

public class OnConnection implements Listener{
	private final Plugin plugin;
	private final Permission permission;
	private final String defaultgroup = "default";

	public OnConnection(final Plugin plugin, final Permission permission){
		this.plugin = plugin;
		this.permission = permission;

	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void PlayerJoinEvent(final PlayerLoginEvent event){
		Player player = event.getPlayer();
		String playername = player.getName();
		String world;
		//plugin.getLogger().info("Connexion joueur " + playername);
		List<World> worlds = plugin.getServer().getWorlds();
		List<SqlRow> groupeOK = GetGroupOK(playername);
		List<SqlRow> groupeKO = GetGroupKO(playername);

		//Modif par monde
		for(int j=0;j<worlds.size();j++){
			world = worlds.get(j).getName();
			//Ajout des groupes
			if(groupeOK != null){
				for(int i=0;i<groupeOK.size();i++){
					if(!permission.playerInGroup(world,player, groupeOK.get(i).getString("groupe"))){
						//plugin.getLogger().info("OK :"+groupeOK.get(0).getString("groupe"));
						permission.playerAddGroup(world,player,groupeOK.get(i).getString("groupe"));
						if(permission.playerInGroup(world,player, defaultgroup)){
							permission.playerRemoveGroup(world,player,defaultgroup);
						}
					}
				}
			}

			//Retrait des groupes
			if(groupeKO != null){
				for(int i=0;i<groupeKO.size();i++){

					if(permission.playerInGroup(world,player, groupeKO.get(i).getString("groupe"))){
						//plugin.getLogger().info("KO :"+groupeKO.get(0).getString("groupe"));
						permission.playerRemoveGroup(world,player,groupeKO.get(i).getString("groupe"));
					}
				}
			}

			//Ajout du groupe default si aucune permission
			if(groupeOK.size() == 0 || groupeOK == null){
				if(permission.getPlayerGroups(world,player).length == 0){
					permission.playerAddGroup(world,player,defaultgroup);
				}
			}
		}

	}

	private List<SqlRow> GetGroupOK(String playername){
		SqlQuery bean = plugin.getDatabase().createSqlQuery("SELECT b.groupe FROM payment_header h, pay_player_avantage a, pay_avantage b WHERE h.playername = :playername AND h.idplayer = a.idplayer AND a.idavantage = b.idavantage AND a.datedebut < now() AND a.datefin > now()");
		bean.setParameter("playername", playername);
		List<SqlRow> groupe = bean.findList();
		return groupe;
	}

	private List<SqlRow> GetGroupKO(String playername){
		SqlQuery bean = plugin.getDatabase().createSqlQuery("SELECT c.groupe FROM pay_avantage c WHERE c.groupe NOT IN (SELECT b.groupe FROM payment_header h, pay_player_avantage a, pay_avantage b WHERE h.playername = :playername AND h.idplayer = a.idplayer AND a.idavantage = b.idavantage AND a.datedebut < now() AND a.datefin > now())");
		bean.setParameter("playername", playername);
		List<SqlRow> groupe = bean.findList();
		return groupe;
	}


}
