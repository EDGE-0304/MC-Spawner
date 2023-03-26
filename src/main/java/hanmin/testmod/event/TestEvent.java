package hanmin.testmod.event;

import hanmin.testmod.TestMod;
import hanmin.testmod.item.TestItem;
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
			player.sendSystemMessage(Component.literal(player.getName().getString() + " is knocking with "+player.getMainHandItem().getItem().getDescription().getString()));
		}
		
		player.sendSystemMessage(Component.literal("in game:"+player.getMainHandItem().getItem().getName(player.getMainHandItem()).toString() ));
		player.sendSystemMessage(Component.literal("in TestItem:"+TestItem.PIG_SPAWNER.getId().toString()));
		
		if(player.getMainHandItem().getItem().getDescriptionId().equals(TestItem.PIG_SPAWNER.getId().toString())) {
			player.sendSystemMessage(player.getMainHandItem().getItem().getDescription());
		}
		
	}
	
	
}