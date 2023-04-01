package hanmin.testmod.event;

import hanmin.testmod.TestMod;
import hanmin.testmod.item.TestItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;

@Mod.EventBusSubscriber(modid = TestMod.MODID)
public class TestEvent {

	@SubscribeEvent
	public static void onPlayerAttack(AttackEntityEvent e) {
		Player player = e.getEntity();
		
		if(player.getMainHandItem().getItem() == Items.TROPICAL_FISH) {
			player.sendSystemMessage(Component.literal(player.getName().getString() + " is knocking with "+player.getMainHandItem().getItem().getDescription().getString()));
		}
		
		if(player.getMainHandItem().getItem().getDescription().getString().equals("Pig Spawner")) {
			player.sendSystemMessage(Component.literal("This is pig spawner, not for knocking"));
		}
		
	}
	
	@SubscribeEvent
	public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent e) {
		Player player = e.getEntity();
		player.sendSystemMessage(Component.literal("This is pig spawner, not for knocking"));
		
	}
	
//	@SubscribeEvent
//	public static void onPlayerRightClick(RightClickBlock e) {
//		Player player = e.getEntity();
//		
//		player.sendSystemMessage(Component.literal(e.getPos().toString()));
//		
//		BlockState resBlock = e.getLevel().getBlockState(e.getPos());
//		
//		String BlockPositionStr = "null";
//		if(resBlock != null) {
//			BlockPositionStr = resBlock.getType().toString();
//		}
//		
//		player.sendSystemMessage(Component.literal(player.getName().getString() + " is rightclicking on block " + BlockPositionStr));
//		
//	}
	
	
}