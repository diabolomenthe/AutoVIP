package fr.yahoo.diabolomenthe75005.AutoVIP;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.PersistenceException;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import fr.yahoo.diabolomenthe75005.AutoVIP.Command.Commandautovip;

public class AutoVIP extends JavaPlugin{
	private Permission permission = null;
	private OnConnection onconnection; 
	//Fonction lors du lancement du serveur
	@Override
	public void onEnable(){
		//database
		try{
			this.getDatabase().find(Payment_header.class).findRowCount();
		}
		catch(PersistenceException e){
			this.installDDL();
		}
		
		//Vault
		setupPermissions();
		
		//événements
		onconnection = new OnConnection(this,permission);
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(onconnection, this);
		
		//Commandes
		CommandExecutor commandautovip = new Commandautovip(this);
		getCommand("autovip").setExecutor(commandautovip);

	}


	//Fonction lors de l'arrêt du serveur
	@Override
	public void onDisable(){

	}

	//Fonction de listes des tables
	@Override
	public List<Class<?>> getDatabaseClasses() {
		List<Class<?>> classes = new LinkedList<Class<?>>();

		classes.add(Payment_header.class);
		classes.add(Payment_trn.class);
		classes.add(Pay_avantage.class);
		classes.add(Player_avantagePK.class);
		classes.add(Pay_player_avantage.class);


		return classes;
	}
	
	//Vault permission
    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

}


