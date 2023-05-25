package hanmin.testmod.block;

import hanmin.testmod.item.TestSpawner;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class SpawnerBlock extends Block {
	private EntityType<?> entitytype;

	public SpawnerBlock(EntityType<?> entitytype) {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops());
		this.entitytype = entitytype;
	}
	
	public EntityType<?> getType() {
		return this.entitytype;
	}
	
	@Override
	public InteractionResult use(BlockState blockstate, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult blockHitResult) {
		if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            ItemStack itemstack = player.getItemInHand(hand);
            if(!(itemstack.getItem() instanceof TestSpawner)) {
            	player.sendSystemMessage(Component.literal(this.entitytype.getDescription().getString()+" spawned!"));
            	Entity entity = this.entitytype.spawn((ServerLevel)level, itemstack , player, pos.above(), MobSpawnType.SPAWN_EGG, false, false);
            }
            
			
        }
		return super.use(blockstate, level, pos, player, hand, blockHitResult);
	}
	
}
