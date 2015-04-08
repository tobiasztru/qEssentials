package pl.za.xvacuum.qessentials.listeners;

import java.util.Map;
import java.util.regex.Pattern;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.objects.MetadataStorage;
import pl.za.xvacuum.qessentials.objects.QPlayer;
import pl.za.xvacuum.qessentials.utils.ChatUtil;
import pl.za.xvacuum.qessentials.utils.TimeUtil;
import pl.za.xvacuum.qessentials.utils.Util;

import com.google.common.collect.Maps;

public class PlayerChat implements Listener{
	
	
	public static final Pattern URL_PATTERN = Pattern.compile("((?:(?:https?)://)?[\\w-_\\.]{2,})\\.([a-zA-Z]{2,3}(?:/\\S+)?)");
	public static final Pattern IPPATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	public static final Pattern BANNED_WORDS = Pattern.compile(".*(skkf|mchc|xcrafters|ssij|lifehard|trollcraft|mcwg|doscraft|xkleszcz|craftstory|face2face|f2f|2/10|lagi|gale|algi|chuj|chuja|chujek|chuju|chujem|chujnia|chujowy|chujowa|chujowe|cipa|cipe|cipie|dojebac|dojebie|dojebal|dojebala|dojebalem|dojebalam|dojebie|dopieprzac|dopierdalac|dopierdala|dopierdalal|dopierdalala|dopierdoli|dopierdolil|dopierdole|dopierdoli|dopierdalajacy|dopierdolic|dupa|dupie|dupcia|dupeczka|dupy|dupe|huj|hujek|hujnia|huja|huje|hujem|huju|jebac|jebal|jebie|jebia|jebak|jebaka|jebal|jebany|jebane|jebanka|jebanko|jebankiem|jebanymi|jebana|jebanym|jebanej|jebana|jebani|jebanych|jebanymi|jebcie|jebiacy|jebiaca|jebiacego|jebiacej|jebia|jebie|jebliwy|jebnac|jebnal|jebna|jebnela|jebnie|jebnij|jebut|koorwa|korwa|kurestwo|kurew|kurewski|kurewska|kurewskiej|kurewska|kurewsko|kurewstwo|kurwa|kurwaa|kurwami|kurwe|kurwie|kurwiska|kurwo|kurwy|kurwach|kurwami|kurewski|kurwiarz|kurwiący|kurwica|kurwic|kurwidołek|kurwik|kurwiki|kurwiszcze|kurwiszon|kurwiszona|kurwiszonem|kurwiszony|kutas|kutasa|kutasie|kutasem|kutasy|kutasow|kutasach|kutasami|matkojebca|matkojebcy|matkojebca|matkojebcami|matkojebcach|najebac|najebal|najebane|najebany|najebana|najebie|najebia|naopierdalac|naopierdalal|naopierdalala|napierdalac|napierdalajacy|napierdolic|nawpierdalac|nawpierdalal|nawpierdalala|obsrywac|obsrywajacy|odpieprzac|odpieprzy|odpieprzyl|odpieprzyla|odpierdalac|odpierdol|odpierdolil|odpierdolila|odpierdoli|odpierdalajacy|odpierdalajaca|odpierdolic|odpierdoli|opieprzający|opierdalac|opierdala|opierdalajacy|opierdol|opierdolic|opierdoli|opierdola|piczka|pieprzniety|pieprzony|pierdel|pierdlu|pierdola|pierdolacy|pierdolaca|pierdol|pierdole|pierdolenie|pierdoleniem|pierdoleniu|pierdolec|pierdola|pierdolicie|pierdolic|pierdolil|pierdolila|pierdoli|pierdolniety|pierdolisz|pierdolnac|pierdolnal|pierdolnela|pierdolnie|pierdolnij|pierdolnik|pierdolona|pierdolone|pierdolony|pierdzący|pierdziec|pizda|pizde|pizdzie|pizdnac|pizdu|podpierdalac|podpierdala|podpierdalajacypodpierdolic|podpierdoli|pojeb|pojeba|pojebami|pojebani|pojebanego|myhard|mhard|pojebanemu|pojebani|pojebany|pojebanych|pojebanym|pojebanymi|pojebem|pojebac|pojebalo|popierdala|popierdalac|popierdolic|popierdoli|popierdolonego|popierdolonemu|popierdolonym|popierdolone|popierdoleni|popierdolony|porozpierdala|porozpierdalac|poruchac|przejebane|przejebac|przyjebali|przepierdalac|przepierdala|przepierdalajacy|przepierdalajaca|przepierdolic|przyjebac|przyjebie|przyjebala|przyjebal|przypieprzac|przypieprzajacy|przypieprzajaca|przypierdalac|przypierdala|przypierdoli|przypierdalajacy|przypierdolic|qrwa|rozjebac|rozjebie|rozjebała|rozpierdalac|rozpierdala|rozpierdolic|rozpierdole|rozpierdoli|rozpierducha|skurwiel|skurwiela|skurwielem|skurwielu|skurwysyn|skurwysynow|skurwysyna|skurwysynem|skurwysynu|skurwysyny|skurwysynski|skurwysynstwo|spieprzac|spieprza|spieprzaj|spieprzajcie|spieprzaja|spieprzajacy|spieprzajaca|spierdalac|spierdala|spierdalal|spierdalalcie|spierdalala|spierdalajacy|spierdolic|spierdoli|spierdolą|spierdola|srac|srajacy|srajac|sraj|sukinsyn|sukinsyny|sukinsynom|sukinsynowi|sukinsynow|ujebac|ujebal|ujebana|ujebany|ujebie|ujebała|ujebala|upierdalac|upierdala|upierdoli|upierdolic|upierdoli|upierdola|upierdoleni|wjebac|wjebie|wjebia|wjebiemy|wjebiecie|wkurwiac|wkurwi|wkurwia|wkurwial|wkurwiajacy|wkurwiajaca|wkurwic|wkurwi|wkurwiacie|wkurwiali|wkurwia|wkurwimy|wkurwicie|wkurwiacie|wkurwic|wkurwia|wpierdalac|wpierdalajacy|wpierdol|wpierdolic|wpizdu|wyjebac|wyjebali|wyjebac|wyjebie|wyjebia|wyjebiesz|wyjebie|wyjebiecie|wyjebiemy|wypieprzac|wypieprza|wypieprzal|wypieprzala|wypieprzy|wypieprzyla|wypieprzyl|wypierdal|wypierdalac|wypierdala|wypierdalaj|wypierdalal|wypierdalala|wypierdolic|wypierdoli|wypierdolimy|wypierdolicie|wypierdola|wypierdolili|wypierdolil|wypierdolila|zajebac|zajebie|zajebia|zajebial|zajebiala|zajebali|zajebana|zajebani|zajebane|zajebany|zajebanych|zajebanym|zajebanymi|zajebiste|zajebisty|zajebistych|zajebista|zajebistym|zajebistymi|zajebiscie|zapieprzyc|zapieprzy|zapieprzyl|zapieprzyla|zapieprza|zapieprz|zapieprzymy|zapieprzycie|zapieprzysz|zapierdala|zapierdalac|zapierdalaja|zapierdalaj|zapierdalajcie|zapierdalala|zapierdalali|zapierdalajacy|zapierdolic|zapierdoli|zapierdolil|zapierdolila|zapierdola|zapierniczac|zapierniczajacy|zasrac|zasranym|zasrywajacy|zesrywac|zesrywajac|zjebac|zjebal|zjebala|zjebana|zjebia|zjebali|zjeby+).*");
	public static Map<String, Long> slow = Maps.newHashMap();
	
	@EventHandler(priority = EventPriority.LOW)
	public void chatevent(final AsyncPlayerChatEvent e){
		Player player = e.getPlayer();
		String format = Main.getInstance().getConfig().getString("chat-format");
		format = format.replace("{PREFIX}", new StringBuilder().append(Main.getChat().getPlayerPrefix(player))).toString();
	    format = format.replace("{SUFFIX}", Main.getChat().getPlayerSuffix(player));
	    format = format.replace("{PLAYER}", player.getDisplayName());
	    format = format.replace("{MESSAGE}", "%2$s");
		e.setFormat(Util.setHEX(format));
		QPlayer p = MetadataStorage.getFromPlayer(player);

		
		if (p.getMute() > 0) {
			if (p.getMute() < System.currentTimeMillis()) {
				p.setMute(0);
				player.sendMessage(Util.setHEX("&aJuz mozesz mowic! Staraj sie zachowywac kulturalniej."));
			} else if (p.getMute() >= System.currentTimeMillis()) {
				e.setCancelled(true);
				Util.sendMessage(player, "&7Jestes wyciszony jeszcze &c"
						+ TimeUtil.parseTimeHour(p.getMute()) + "&7!");
				return;
			}
		}
		if(!player.hasPermission("qessentials.chat.bypass") || !player.isOp()){
			if(ChatUtil.getChat() == false){
				e.setCancelled(true);
				Util.sendMessage(player, "&cChat jest obecnie wylaczony!");
				return;
			}
		}
		FileConfiguration cfg = Main.getInstance().getConfig();
		if (!player.hasPermission("qessentials.chat.bypass") && (URL_PATTERN.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("url-block") == true){
				e.setCancelled(true);
				player.sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				return;
				
			}
		}
		if (!player.hasPermission("qessentials.chat.bypass") && (IPPATTERN.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("ip-block") == true){
				e.setCancelled(true);
				
				player.sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				return;
			}
		}
		if (!player.hasPermission("qessentials.chat.bypass") && (BANNED_WORDS.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("words-block") == true){
				e.setCancelled(true);
				
				player.sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				return;
			}
		}
		int seconds = Main.getInstance().getConfig().getInt("slowdown"); 
		int sloww = seconds * 1000;
		
		
		if(slow.containsKey(p.getName()) && System.currentTimeMillis() - slow.get(p.getName()) <= sloww) {
			
			player.sendMessage(String.format("�7Spokojnie! Poczekaj jeszcze chwile zanim cos napiszesz! (�c%d�7)", seconds));
			e.setCancelled(true);
			return;
		}
		e.setMessage(e.getMessage().replace("qEssentials", "&6&lqEssentials&7").replace("qessentials", "&6&lqEssentials&7").replace("qEssentialsa", "&6&lqEssentials&7").replace("qessentialsa", "&6&lqEssentials&7"));
		if (player.hasPermission("qessentials.chat.color")){
			e.setMessage(Util.setHEX(e.getMessage().replace("qEssentials", "&6&lqEssentials&7").replace("qessentials", "&6&lqEssentials&7").replace("qEssentialsa", "&6&lqEssentials&7").replace("qessentialsa", "&6&lqEssentials&7")));
		}
		if(!player.hasPermission("qessentials.slow.bypass")) {
			slow.put(p.getName(), System.currentTimeMillis());
			return;
		}
		
		
	}

}
