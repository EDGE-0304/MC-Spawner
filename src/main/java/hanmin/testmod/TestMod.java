package hanmin.testmod;

import hanmin.testmod.block.TestBlock;
import hanmin.testmod.item.TestItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TestMod.MODID)
public class TestMod {
	
	public static final String MODID = "testmod";
	
	public TestMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		TestItem.ITEMS.register(modEventBus);
		TestBlock.BLOCKS.register(modEventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		modEventBus.addListener(this::addCreative);
	}
	
	private void addCreative(CreativeModeTabEvent.BuildContents e) {
		System.out.println("creativeTab");
		if(e.getTab() == CreativeModeTabs.INGREDIENTS) {
			e.accept(TestItem.TEST_ITEM);
			e.accept(TestItem.PIG_SPAWNER);
		}
		if(e.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
			e.accept(TestBlock.TEST_BLOCK);
			e.accept(TestBlock.B_BLOCK);
		}
	}
}
