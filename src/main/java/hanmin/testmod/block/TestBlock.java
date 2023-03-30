package hanmin.testmod.block;

import java.util.function.Supplier;

import hanmin.testmod.TestMod;
import hanmin.testmod.item.TestItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.BedBlock;

public class TestBlock {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
	
	//Hanmin Block 
	public static final RegistryObject<Block> TEST_BLOCK = registerBlockAndItem("test_block", () -> {
		return new Block(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops() );
	});
	
	//Haitian Block
	public static final RegistryObject<Block> C_BLOCK = registerBlockAndItem("c_block", () -> {
		return new Block(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops() );
	});
	
	//Chenshun Block
	public static final RegistryObject<Block> SB_BLOCK = registerBlockAndItem("sb_block", () -> {
		return new Block(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops() );
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