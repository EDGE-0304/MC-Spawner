package hanmin.testmod.item;

import hanmin.testmod.TestMod;
import hanmin.testmod.block.TestBlock;
import hanmin.testmod.item.custom.CustomArrow;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.core.PositionImpl;

public class TestItem extends Item {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);
	
	public TestItem() {
		super(new Properties());
	}
	
	public static RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item",() -> {
		return new TestItem();}
	);
	
	public static RegistryObject<Item> PIG_SPAWNER = ITEMS.register("pig_spawner",() -> {
		return new PigSpawner(new Properties());}
	);
	
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		System.out.println("pig spawner use method called");
	      ItemStack itemstack = player.getItemInHand(hand);
	      
	      HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
	      
	      if (hitresult.getType() != HitResult.Type.BLOCK) {
	         return InteractionResultHolder.pass(itemstack);
	      } else if (!(level instanceof ServerLevel)) {
	         return InteractionResultHolder.success(itemstack);
	      } else {
	         BlockHitResult blockhitresult = (BlockHitResult)hitresult;
	         BlockPos blockpos = blockhitresult.getBlockPos().above();
	         EntityType<LightningBolt> entitytype = EntityType.LIGHTNING_BOLT;
	         PositionImpl position = new PositionImpl((double)(blockpos.getX()), (double)(blockpos.getY()), (double)(blockpos.getZ()));
	         for(int i=-10;i<=10;++i) {
	        	 for(int j=-10;j<=10;++j) {
	        		 BlockPos tmpblockpos = blockpos.offset(i, 0, j);
	        		 
	        		 if (tmpblockpos.closerToCenterThan(position,3)) {
	        			 entitytype.spawn((ServerLevel)level, itemstack, player, tmpblockpos, MobSpawnType.COMMAND, false, false);
	        		 }
		        	 
	        	 }
	        	 
	        	 
	         }
	         return InteractionResultHolder.pass(itemstack);
	         
	      }
	   }
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}