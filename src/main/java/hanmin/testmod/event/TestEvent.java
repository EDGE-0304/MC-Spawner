package hanmin.testmod.event;

import hanmin.testmod.TestMod;
import hanmin.testmod.item.TestItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraft.core.BlockPos;

@Mod.EventBusSubscriber(modid = TestMod.MODID)
public class TestEvent {

	@SubscribeEvent
	public static void onPlayerAttack(AttackEntityEvent e) {
		Player player = e.getEntity();
		
		if(player.getMainHandItem().getItem() == Items.TROPICAL_FISH) {
			player.sendSystemMessage(Component.literal(player.getName().getString() + " is knocking with "+player.getMainHandItem().getItem().getDescription().getString()));
		}
		
//		player.sendSystemMessage(Component.literal("in game:"+player.getMainHandItem().getItem().getName(player.getMainHandItem()).toString() ));
//		player.sendSystemMessage(Component.literal(player.getMainHandItem().getItem().getDescriptionId()));
//		player.sendSystemMessage(player.getMainHandItem().getItem().getDescription());
		
		if(player.getMainHandItem().getItem().getDescription().getString().equals("Pig Spawner")) {
			player.sendSystemMessage(Component.literal("This is pig spawner, not for knocking"));
		}
		
	}
	
	@SubscribeEvent
	public static void onPlayerRightClickBlock(RightClickBlock e) {
		Player player = e.getEntity();
		BlockPos pos = e.getPos();
		
		if(player.getMainHandItem().getItem().getDescription().getString().equals("Pig Spawner")) {
			player.sendSystemMessage(Component.literal("This is pig spawner, not for right clicking"));
			
			
		}
		
	}
	
	
}