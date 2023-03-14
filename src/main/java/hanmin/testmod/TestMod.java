package hanmin.testmod;

import hanmin.testmod.item.TestItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("testmod_hanmin")
public class TestMod {
	
	public static final String MODID = "testmod_hanmin";
	
	public TestMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		MinecraftForge.EVENT_BUS.register(this);
		TestItem.ITEMS.register(modEventBus);
		modEventBus.addListener(this::addCreative);
	}
	
	private void addCreative(CreativeModeTabEvent.BuildContents e) {
		System.out.println("creativeTab");
		if(e.getTab() == CreativeModeTabs.INGREDIENTS) {
			e.accept(TestItem.TEST_ITEM);
		}
	}
}
