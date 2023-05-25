package hanmin.testmod.block;

import java.util.function.Supplier;



import hanmin.testmod.TestMod;
import hanmin.testmod.item.TestItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestBlock extends Block {
	public TestBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops());
	}

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
	
	public static final RegistryObject<Block> TEST_BLOCK = registerBlockAndItem("test_block", () -> {
		return new TestBlock();
	});
	
	public static final RegistryObject<Block> PIGSPAWNER_BLOCK = registerBlockAndItem("pigspawner_block", () -> {
		return new SpawnerBlock(EntityType.PIG);
	});
	
	public static final RegistryObject<Block> HORSESPAWNER_BLOCK = registerBlockAndItem("horsespawner_block", () -> {
		return new SpawnerBlock(EntityType.HORSE);
	});
	
	public static final RegistryObject<Block> CHICKEN_BLOCK = registerBlockAndItem("chicken_block", () -> {
		return new SpawnerBlock(EntityType.CHICKEN);
	});
	
	public static final RegistryObject<Block> CAT_BLOCK = registerBlockAndItem("cat_block", () -> {
		return new SpawnerBlock(EntityType.CAT);
	});
	
	public static final RegistryObject<Block> WOLF_BLOCK = registerBlockAndItem("wolf_block", () -> {
		return new SpawnerBlock(EntityType.WOLF);
	});

	public static final RegistryObject<Block> VILLAGER_BLOCK = registerBlockAndItem("villager_block", () -> {
		return new SpawnerBlock(EntityType.VILLAGER);
	});
	
	public static final RegistryObject<Block> RABBIT_BLOCK = registerBlockAndItem("rabbit_block", () -> {
		return new SpawnerBlock(EntityType.RABBIT);
	});
	
	public static final RegistryObject<Block> TURTLE_BLOCK = registerBlockAndItem("turtle_block", () -> {
		return new SpawnerBlock(EntityType.TURTLE);
	});

	public static final RegistryObject<Block> FOX_BLOCK = registerBlockAndItem("fox_block", () -> {
		return new SpawnerBlock(EntityType.FOX);
	});
	
	public static final RegistryObject<Block> BAT_BLOCK = registerBlockAndItem("bat_block", () -> {
		return new SpawnerBlock(EntityType.BAT);
	});

	public static final RegistryObject<Block> ZOMBIE_BLOCK = registerBlockAndItem("zombie_block", () -> {
		return new SpawnerBlock(EntityType.ZOMBIE);
	});

	public static final RegistryObject<Block> DOLPHIN_BLOCK = registerBlockAndItem("dolphin_block", () -> {
		return new SpawnerBlock(EntityType.DOLPHIN);
	});

	public static final RegistryObject<Block> DONKEY_BLOCK = registerBlockAndItem("donkey_block", () -> {
		return new SpawnerBlock(EntityType.DONKEY);
	});

	public static final RegistryObject<Block> FROG_BLOCK = registerBlockAndItem("frog_block", () -> {
		return new SpawnerBlock(EntityType.FROG);
	});

	public static final RegistryObject<Block> LLAMA_BLOCK = registerBlockAndItem("llama_block", () -> {
		return new SpawnerBlock(EntityType.LLAMA);
	});
	
	private static <T extends Block> RegistryObject<T> registerBlockAndItem(String blockName, Supplier<T> block){
		RegistryObject<T> testBlockInstance = BLOCKS.register(blockName, block);
		TestItem.ITEMS.register( blockName, ()-> new BlockItem(testBlockInstance.get(), new Item.Properties()) );
		return testBlockInstance;
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}