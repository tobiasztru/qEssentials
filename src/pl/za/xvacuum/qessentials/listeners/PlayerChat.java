package pl.za.xvacuum.qessentials.listeners;

import java.util.regex.Pattern;

import me.confuser.barapi.BarAPI;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import pl.za.xvacuum.qessentials.Main;
import pl.za.xvacuum.qessentials.utils.Util;

public class PlayerChat implements Listener{
	
	public static final Pattern URL_PATTERN = Pattern.compile("((?:(?:https?)://)?[\\w-_\\.]{2,})\\.([a-zA-Z]{2,3}(?:/\\S+)?)");
	public static final Pattern IPPATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	public static final Pattern BANNED_WORDS = Pattern.compile(".*(skkf|mchc|xcrafters|ssij|xkleszcz|craftstory|face2face|f2f|2/10|lagi|gale|algi|chuj|chuja|chujek|chuju|chujem|chujnia|chujowy|chujowa|chujowe|cipa|cipe|cipie|dojebac|dojebie|dojebal|dojebala|dojebalem|dojebalam|dojebie|dopieprzac|dopierdalac|dopierdala|dopierdalal|dopierdalala|dopierdoli|dopierdolil|dopierdole|dopierdoli|dopierdalajacy|dopierdolic|dupa|dupie|dupcia|dupeczka|dupy|dupe|huj|hujek|hujnia|huja|huje|hujem|huju|jebac|jebal|jebie|jebia|jebak|jebaka|jebal|jebany|jebane|jebanka|jebanko|jebankiem|jebanymi|jebana|jebanym|jebanej|jebana|jebani|jebanych|jebanymi|jebcie|jebiacy|jebiaca|jebiacego|jebiacej|jebia|jebie|jebliwy|jebnac|jebnal|jebna|jebnela|jebnie|jebnij|jebut|koorwa|korwa|kurestwo|kurew|kurewski|kurewska|kurewskiej|kurewska|kurewsko|kurewstwo|kurwa|kurwaa|kurwami|kurwe|kurwie|kurwiska|kurwo|kurwy|kurwach|kurwami|kurewski|kurwiarz|kurwiÄ…cy|kurwica|kurwic|kurwidoÅ‚ek|kurwik|kurwiki|kurwiszcze|kurwiszon|kurwiszona|kurwiszonem|kurwiszony|kutas|kutasa|kutasie|kutasem|kutasy|kutasow|kutasach|kutasami|matkojebca|matkojebcy|matkojebca|matkojebcami|matkojebcach|najebac|najebal|najebane|najebany|najebana|najebie|najebia|naopierdalac|naopierdalal|naopierdalala|napierdalac|napierdalajacy|napierdolic|nawpierdalac|nawpierdalal|nawpierdalala|obsrywac|obsrywajacy|odpieprzac|odpieprzy|odpieprzyl|odpieprzyla|odpierdalac|odpierdol|odpierdolil|odpierdolila|odpierdoli|odpierdalajacy|odpierdalajaca|odpierdolic|odpierdoli|opieprzajÄ…cy|opierdalac|opierdala|opierdalajacy|opierdol|opierdolic|opierdoli|opierdola|piczka|pieprzniety|pieprzony|pierdel|pierdlu|pierdola|pierdolacy|pierdolaca|pierdol|pierdole|pierdolenie|pierdoleniem|pierdoleniu|pierdolec|pierdola|pierdolicie|pierdolic|pierdolil|pierdolila|pierdoli|pierdolniety|pierdolisz|pierdolnac|pierdolnal|pierdolnela|pierdolnie|pierdolnij|pierdolnik|pierdolona|pierdolone|pierdolony|pierdzÄ…cy|pierdziec|pizda|pizde|pizdzie|pizdnac|pizdu|podpierdalac|podpierdala|podpierdalajacypodpierdolic|podpierdoli|pojeb|pojeba|pojebami|pojebani|pojebanego|myhard|mhard|pojebanemu|pojebani|pojebany|pojebanych|pojebanym|pojebanymi|pojebem|pojebac|pojebalo|popierdala|popierdalac|popierdolic|popierdoli|popierdolonego|popierdolonemu|popierdolonym|popierdolone|popierdoleni|popierdolony|porozpierdala|porozpierdalac|poruchac|przejebane|przejebac|przyjebali|przepierdalac|przepierdala|przepierdalajacy|przepierdalajaca|przepierdolic|przyjebac|przyjebie|przyjebala|przyjebal|przypieprzac|przypieprzajacy|przypieprzajaca|przypierdalac|przypierdala|przypierdoli|przypierdalajacy|przypierdolic|qrwa|rozjebac|rozjebie|rozjebaÅ‚a|rozpierdalac|rozpierdala|rozpierdolic|rozpierdole|rozpierdoli|rozpierducha|skurwiel|skurwiela|skurwielem|skurwielu|skurwysyn|skurwysynow|skurwysyna|skurwysynem|skurwysynu|skurwysyny|skurwysynski|skurwysynstwo|spieprzac|spieprza|spieprzaj|spieprzajcie|spieprzaja|spieprzajacy|spieprzajaca|spierdalac|spierdala|spierdalal|spierdalalcie|spierdalala|spierdalajacy|spierdolic|spierdoli|spierdolÄ…|spierdola|srac|srajacy|srajac|sraj|sukinsyn|sukinsyny|sukinsynom|sukinsynowi|sukinsynow|ujebac|ujebal|ujebana|ujebany|ujebie|ujebaÅ‚a|ujebala|upierdalac|upierdala|upierdoli|upierdolic|upierdoli|upierdola|upierdoleni|wjebac|wjebie|wjebia|wjebiemy|wjebiecie|wkurwiac|wkurwi|wkurwia|wkurwial|wkurwiajacy|wkurwiajaca|wkurwic|wkurwi|wkurwiacie|wkurwiali|wkurwia|wkurwimy|wkurwicie|wkurwiacie|wkurwic|wkurwia|wpierdalac|wpierdalajacy|wpierdol|wpierdolic|wpizdu|wyjebac|wyjebali|wyjebac|wyjebie|wyjebia|wyjebiesz|wyjebie|wyjebiecie|wyjebiemy|wypieprzac|wypieprza|wypieprzal|wypieprzala|wypieprzy|wypieprzyla|wypieprzyl|wypierdal|wypierdalac|wypierdala|wypierdalaj|wypierdalal|wypierdalala|wypierdolic|wypierdoli|wypierdolimy|wypierdolicie|wypierdola|wypierdolili|wypierdolil|wypierdolila|zajebac|zajebie|zajebia|zajebial|zajebiala|zajebali|zajebana|zajebani|zajebane|zajebany|zajebanych|zajebanym|zajebanymi|zajebiste|zajebisty|zajebistych|zajebista|zajebistym|zajebistymi|zajebiscie|zapieprzyc|zapieprzy|zapieprzyl|zapieprzyla|zapieprza|zapieprz|zapieprzymy|zapieprzycie|zapieprzysz|zapierdala|zapierdalac|zapierdalaja|zapierdalaj|zapierdalajcie|zapierdalala|zapierdalali|zapierdalajacy|zapierdolic|zapierdoli|zapierdolil|zapierdolila|zapierdola|zapierniczac|zapierniczajacy|zasrac|zasranym|zasrywajacy|zesrywac|zesrywajac|zjebac|zjebal|zjebala|zjebana|zjebia|zjebali|zjeby+).*");
	
	
	@EventHandler(priority = EventPriority.LOW)
	public void chatevent(AsyncPlayerChatEvent e){
		String format = Main.getInstance().getConfig().getString("chat-format");
		format = format.replace("{PREFIX}", new StringBuilder().append(Main.getChat().getPlayerPrefix(e.getPlayer()))).toString();
	    format = format.replace("{SUFFIX}", Main.getChat().getPlayerSuffix(e.getPlayer()));
	    format = format.replace("{PLAYER}", "%1$s");
	    format = format.replace("{MESSAGE}", "%2$s");
		e.setFormat(Util.setHEX(format));
 
		/**
		 * Tu w przyszlosci bêdzie slowmode i w³¹czanie/wy³¹czanie chatu
		 */
		FileConfiguration cfg = Main.getInstance().getConfig();
		if (!e.getPlayer().hasPermission("qessentials.chat.bypass") && (URL_PATTERN.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("url-block") == true){
				e.setCancelled(true);
				if(Main.getBarAPI() == true){
					BarAPI.setMessage(e.getPlayer(), Util.setHEX("&7TWOJ TEKST ZOSTAL &cZABLOKOWANY"), 10);
				}else{
					e.getPlayer().sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				}
			}
		}
		if (!e.getPlayer().hasPermission("qessentials.chat.bypass") && (IPPATTERN.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("ip-block") == true){
				e.setCancelled(true);
				if(Main.getBarAPI() == true){
					BarAPI.setMessage(e.getPlayer(), Util.setHEX("&7TWOJ TEKST ZOSTAL &cZABLOKOWANY"), 10);
				}else{
					e.getPlayer().sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				}
			}
		}
		if (!e.getPlayer().hasPermission("qessentials.chat.bypass") && (BANNED_WORDS.matcher(e.getMessage()).find())) {
			if(cfg.getBoolean("words-block") == true){
				e.setCancelled(true);
				if(Main.getBarAPI() == true){
					BarAPI.setMessage(e.getPlayer(), Util.setHEX("&7TWOJ TEKST ZOSTAL &cZABLOKOWANY"), 10);
				}else{
					e.getPlayer().sendMessage(Util.setHEX("&7Twoj tekst zostal &czablokowany&7!"));
				}
			}
		}
			
		
		if (e.getPlayer().hasPermission("qessentials.chat.color")){
			e.setMessage(Util.setHEX(e.getMessage()));
		}
		
	}

}
