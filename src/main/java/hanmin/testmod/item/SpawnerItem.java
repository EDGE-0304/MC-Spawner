package hanmin.testmod.item;

import hanmin.testmod.block.SpawnerBlock;
import hanmin.testmod.block.TestBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
public class SpawnerItem extends Item {
	
	private EntityType<?> entitytype;
	
    public SpawnerItem(Properties properties, EntityType<?> entitytype) {
        super(properties);
        this.entitytype = entitytype;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        System.out.println("dolphin spawner use method called");
        ItemStack itemstack = player.getItemInHand(hand);

        HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (hitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemstack);
        } else if (!(level instanceof ServerLevel)) {
            return InteractionResultHolder.success(itemstack);
        } else {
            System.out.println("first else");
            BlockHitResult blockhitresult = (BlockHitResult)hitresult;
            BlockPos blockpos = blockhitresult.getBlockPos();
            if (level.getBlockState(blockpos).getBlock() instanceof TestBlock) {

                Entity entity = this.entitytype.spawn((ServerLevel)level, itemstack, player, blockpos.above(), MobSpawnType.SPAWN_EGG, false, false);
                if (entity == null) {
                    return InteractionResultHolder.pass(itemstack);
                } else {
                	player.sendSystemMessage(Component.literal(this.entitytype.getDescription().getString()+" spawned!"));
                    if (!player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    level.gameEvent(player, GameEvent.ENTITY_PLACE, entity.position());
                    return InteractionResultHolder.consume(itemstack);
                }
            } 
            else if(level.getBlockState(blockpos).getBlock() instanceof SpawnerBlock) {
            	player.sendSystemMessage(Component.literal("Block and item conflict"));
            	return InteractionResultHolder.fail(itemstack);
            }
            else {
                player.sendSystemMessage(Component.literal("Only working on test block"));
                return InteractionResultHolder.fail(itemstack);
            }
        }
    }
}
