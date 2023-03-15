package hanmin.testmod.event;

import hanmin.testmod.TestMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MODID)
public class TestEvent {
	@SubscribeEvent
	public static void onPlayerAttack(AttackEntityEvent e) {
		Player player = e.getEntity();
		if(player.getMainHandItem().getItem() == Items.TROPICAL_FISH) {
			player.sendSystemMessage(Component.literal(player.getName().getString() + " is Gao Qi Sheng."));
		}
	}
	
	
}