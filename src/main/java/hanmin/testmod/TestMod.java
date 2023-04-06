package hanmin.testmod;

import hanmin.testmod.block.MessageBlock;


import hanmin.testmod.block.TestBlock;
import yan.yantestmod.block.YanTestBlock;
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

		MessageBlock.BLOCKS.register(modEventBus);
		YanTestBlock.BLOCKS.register(modEventBus);

		
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
			e.accept(TestBlock.C_BLOCK);

			e.accept(TestBlock.CS_BLOCK);
       
            e.accept(TestBlock.CHICKEN_BLOCK);

            e.accept(TestBlock.CAT_BLOCK);


			e.accept(TestBlock.PIGSPAWNER_BLOCK);
			e.accept(TestBlock.HORSESPAWNER_BLOCK);
			e.accept(MessageBlock.MESSAGE_BLOCK);
			e.accept(TestBlock.YAN_BLOCK);


		}
	}
}
