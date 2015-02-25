package me.saphirant.randomLauncher;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener{
	
	
	@Override
	public void onDisable() {
		
		
	}
	
	@Override
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvents(this, this);
		
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void launcher(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location l = p.getLocation();
		Location b = new Location(l.getWorld(), l.getX(), l.getY() - 1, l.getZ());
		
		
		

		
		if(b.getBlock().getType() == Material.SLIME_BLOCK){
			float x = (float) -1 + (float) (Math.random() * ((1 - -1) + 1));
	        float y = (float) -5 + (float)(Math.random() * ((5 - -5) + 1));
	        float z = (float) -0.3 + (float)(Math.random() * ((0.3 - -0.3) + 1));
	        p.playSound(l, Sound.EXPLODE, 5, 5);
	        p.playEffect(b, Effect.MOBSPAWNER_FLAMES, 50);
	        p.getWorld().spawnEntity(b, EntityType.FIREWORK);
	        p.setVelocity(new Vector(x,y,z));
	        
	        Firework f = (Firework) p.getWorld().spawnEntity(l, EntityType.FIREWORK);
			FireworkMeta meta = f.getFireworkMeta();
			FireworkEffect effect = FireworkEffect.builder().flicker(true).withColor(Color.BLUE).withFade(Color.AQUA).with(Type.BALL_LARGE).trail(true).build();
			meta.addEffect(effect);
			meta.setPower(0);
			f.setFireworkMeta(meta);
		}
	}
	
	 
}
