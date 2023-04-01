package hanmin.testmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class PigSpawnerBlock extends Block {

	public PigSpawnerBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops());
	}
	
	@Override
	public InteractionResult use(BlockState blockstate, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult blockHitResult) {
		if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.sendSystemMessage(Component.literal("Right Clicked this!"));
        }
		return super.use(blockstate, level, pos, player, hand, blockHitResult);
	}
	
}
