
package pl.za.xvacuum.qessentials;

import java.io.IOException;
import java.lang.reflect.Field;

import net.milkbowl.vault.chat.Chat;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import pl.za.xvacuum.qessentials.Runtime.DataType;
import pl.za.xvacuum.qessentials.commands.AdminChat;
import pl.za.xvacuum.qessentials.commands.Back;
import pl.za.xvacuum.qessentials.commands.Ban;
import pl.za.xvacuum.qessentials.commands.Broadcast;
import pl.za.xvacuum.qessentials.commands.ChangeLore;
import pl.za.xvacuum.qessentials.commands.ChangeName;
import pl.za.xvacuum.qessentials.commands.ChatManager;
import pl.za.xvacuum.qessentials.commands.ClearInv;
import pl.za.xvacuum.qessentials.commands.Enchant;
import pl.za.xvacuum.qessentials.commands.Ender;
import pl.za.xvacuum.qessentials.commands.Feed;
import pl.za.xvacuum.qessentials.commands.Fly;
import pl.za.xvacuum.qessentials.commands.Gamemode;
import pl.za.xvacuum.qessentials.commands.Gc;
import pl.za.xvacuum.qessentials.commands.Give;
import pl.za.xvacuum.qessentials.commands.God;
import pl.za.xvacuum.qessentials.commands.Head;
import pl.za.xvacuum.qessentials.commands.Heal;
import pl.za.xvacuum.qessentials.commands.Help;
import pl.za.xvacuum.qessentials.commands.Helpop;
import pl.za.xvacuum.qessentials.commands.Home;
import pl.za.xvacuum.qessentials.commands.Info;
import pl.za.xvacuum.qessentials.commands.Invsee;
import pl.za.xvacuum.qessentials.commands.Item;
import pl.za.xvacuum.qessentials.commands.Kick;
import pl.za.xvacuum.qessentials.commands.Kit;
import pl.za.xvacuum.qessentials.commands.Message;
import pl.za.xvacuum.qessentials.commands.Motd;
import pl.za.xvacuum.qessentials.commands.Mute;
import pl.za.xvacuum.qessentials.commands.Nick;
import pl.za.xvacuum.qessentials.commands.PlayerList;
import pl.za.xvacuum.qessentials.commands.QReload;
import pl.za.xvacuum.qessentials.commands.Repair;
import pl.za.xvacuum.qessentials.commands.Reply;
import pl.za.xvacuum.qessentials.commands.Sethome;
import pl.za.xvacuum.qessentials.commands.Setspawn;
import pl.za.xvacuum.qessentials.commands.Spawn;
import pl.za.xvacuum.qessentials.commands.Teleport;
import pl.za.xvacuum.qessentials.commands.TempBan;
import pl.za.xvacuum.qessentials.commands.Time;
import pl.za.xvacuum.qessentials.commands.Tpa;
import pl.za.xvacuum.qessentials.commands.Tpaccept;
import pl.za.xvacuum.qessentials.commands.Tpdeny;
import pl.za.xvacuum.qessentials.commands.Tppos;
import pl.za.xvacuum.qessentials.commands.Unban;
import pl.za.xvacuum.qessentials.commands.Unmute;
import pl.za.xvacuum.qessentials.commands.Weather;
import pl.za.xvacuum.qessentials.commands.Whois;
import pl.za.xvacuum.qessentials.commands.World;
import pl.za.xvacuum.qessentials.flatfile.Flat;
import pl.za.xvacuum.qessentials.listeners.Connect;
import pl.za.xvacuum.qessentials.listeners.Join;
import pl.za.xvacuum.qessentials.listeners.KickPlayer;
import pl.za.xvacuum.qessentials.listeners.Leave;
import pl.za.xvacuum.qessentials.listeners.Move;
import pl.za.xvacuum.qessentials.listeners.PlayerChat;
import pl.za.xvacuum.qessentials.listeners.PlayerGod;
import pl.za.xvacuum.qessentials.listeners.ServerList;
import pl.za.xvacuum.qessentials.listeners.SignChange;
import pl.za.xvacuum.qessentials.listeners.UnknownCommand;
import pl.za.xvacuum.qessentials.mysql.ConnectionSource;
import pl.za.xvacuum.qessentials.mysql.Manager;
import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.stonegenerator.StoneMain;
import pl.za.xvacuum.qessentials.stonegenerator.listeners.Break;
import pl.za.xvacuum.qessentials.stonegenerator.listeners.Place;
import pl.za.xvacuum.qessentials.tasks.AutoMessage;
import pl.za.xvacuum.qessentials.tasks.ClearItems;
import pl.za.xvacuum.qessentials.utils.KitLoader;
import pl.za.xvacuum.qessentials.utils.LogUtil;
public class Main extends JavaPlugin
{
	private static Main instance;
	private static CommandMap cmdMap;
	private static Chat chat = null;
	
	
	
	public static Main getInstance()
	{
		return instance;
	}
	
	public void onDisable() {
		Manager.saveAll();
	}
	
	
	@SuppressWarnings("deprecation")
	public void onEnable()
	{
		LogUtil.info("Ladowanie systemu...");
		saveDefaultConfig();
		
		LogUtil.info("Zaladowano konfiguracje serwera!");
	    setupChat();
		
		if(pl.za.xvacuum.qessentials.Runtime.getMySQL() == DataType.SQL) {
			LogUtil.info("Laczenie z MySQL...");
			new ConnectionSource(getConfig().getString("mysql.host"), getConfig().getString("mysql.user"), getConfig().getString("mysql.password"), getConfig().getString("mysql.database"), getConfig().getInt("mysql.port")); 
			Manager.createTables();
			Manager.loadPlayers();
			Manager.loadBans();
		} else {
			LogUtil.info("Tworzenie folderow...");
			Flat.prepare();
			Manager.loadPlayers();
			Manager.loadBans();
		}
		
	    LogUtil.info("Znaleziono plugin: Vault");
		LogUtil.info("Implementacja API zakonczona!");
	    Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new AutoMessage(), 0L, Main.getInstance().getConfig().getLong("am-delay") * 20);
	    LogUtil.info("Wystartowano task: AutoMessage");
	    if(getConfig().getBoolean("clear-enabled")){
	    	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new ClearItems(), 0L, Main.getInstance().getConfig().getLong("clear-delay-2") * 20);
	    	LogUtil.info("Wystartowano task: ClearItems");
	    }
	    regCommands();
		
		LogUtil.info("Zaladowano komendy!");
		registerEvents();
		LogUtil.info("Zaladowano wydarzenia!");
		KitLoader.loadKits();
		LogUtil.info("Zaladowano kity!");
		StoneMain.createRecipe();
		LogUtil.info("Zaladowano stoniarki!");
	    try {
	        Metrics metrics = new Metrics(this);
	        metrics.start();
	    } catch (IOException e) {
	        e.printStackTrace();
	        LogUtil.error("NIE MOZNA POLACZYC SIE Z METRICS ZE STRONY MCSTATS.ORG!");
	    }

	    LogUtil.info("Zaladowano statystyki mcstats.org");
		ItemStack ender = new ItemStack(Material.ENDER_CHEST, 1);
	    ShapedRecipe enderchest = new ShapedRecipe(ender).shape(new String[] { 
	      "OOO", 
	      "OEO", 
	      "OOO" })
	      .setIngredient('O', Material.OBSIDIAN)
	      .setIngredient('E', Material.ENDER_PEARL);
	    Main.getInstance().getServer().addRecipe(enderchest); 
	    
		LogUtil.info("Zaladowano enderchesta!");
		LogUtil.info("System zostal zaladowany!");
		for(Player p : Bukkit.getOnlinePlayers()) {
			MetadataStorage.insert(p);
		}
		
	}

	
    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
	
	public void onLoad()
	{
		instance = this;
	}
	
	private void registerCommands(Command... commands){
		for(Command command : commands){
			registerCommand(command);
		}
	}
	
	private void regCommands(){
		registerCommands(new Info(),
		new Gc(),
		new QReload(),
		new AdminChat(),
		new ClearInv(),
		new Mute(),
		new Helpop(),
		new Enchant(),
		new ChangeName(),
		new ChangeLore(),
		new Help(),
		new Gamemode(),
		new God(),
		new Motd(),
		new Broadcast(),
		new Time(),
		new Weather(), 
		new Home(),
		new Sethome(),
		new Teleport(),
		new Whois(),
		new Heal(),
		new Tppos(),
		new Setspawn(),
		new Spawn(),
		new Message(),
		new Reply(),
		new Unmute(),
		new PlayerList(),
		new ChatManager(),
		new Fly(),
		new Invsee(),
		new World(),
		new Back(),
		new Head(),
		new Kit(),
		new Nick(),
		new Repair(),
		new Tpa(),
		new Tpaccept(),
		new Tpdeny(),
		new Feed(),
		new Kick(),
		new Ender(),
		new Ban(),
		new TempBan(),
		new Unban(),
		new Give(),
		new Item());
	}
	
	private void registerEvents()
	{
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new ServerList(), this);
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Leave(), this);
		pm.registerEvents(new Move(), this);
		pm.registerEvents(new Break(), this);
		pm.registerEvents(new Place(), this);
		pm.registerEvents(new SignChange(), this);
		pm.registerEvents(new UnknownCommand(), this);
		pm.registerEvents(new KickPlayer(), this);
		pm.registerEvents(new Connect(), this);
		pm.registerEvents(new PlayerGod(), this);
	}
	
	
	public static Chat getChat()
	{
		return chat;
	}
	
	
	protected boolean registerCommand(Command command)
	{
	  if (cmdMap == null) {
	     try {
	        Field field = SimplePluginManager.class.getDeclaredField("commandMap");
	        field.setAccessible(true);
	        cmdMap = (CommandMap)field.get(Bukkit.getServer().getPluginManager());
	     }
	     catch (Exception e) {
	        e.printStackTrace();
	        return false;
	     }
	 }
	 cmdMap.register("", command);
	 return true;
	 }
	
}
