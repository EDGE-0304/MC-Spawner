package hanmin.testmod;

import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("testmod_hanmin")
@Mod.EventBusSubscriber // annotation for event listener
public class Main {
	
	@SubscribeEvent
	public static void playerJoinWorld(PlayerEvent.PlayerLoggedInEvent e) {
		
		Player player = e.getEntity();
		String messageToDisplay = "Hello this is a test message.";
		
		player.displayClientMessage(Component.literal(messageToDisplay), true);
	
	}
}
