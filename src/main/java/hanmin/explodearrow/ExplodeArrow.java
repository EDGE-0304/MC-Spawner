package hanmin.explodearrow;

import hanmin.explodearrow.backend.DispenserBehaviorRegistries;
import hanmin.explodearrow.backend.Registry;
import hanmin.explodearrow.backend.CreativeTabWorker;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod("explode_arrow")
public class ExplodeArrow {
	
  public static final String MOD_ID = "explode_arrow";
  
  public ExplodeArrow() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(CreativeTabWorker::addToCombatTab);
    
    MinecraftForge.EVENT_BUS.register(this);
    
    Registry.arrowEntities.register(FMLJavaModLoadingContext.get().getModEventBus());
    Registry.registerItems();
  }
  
  public void setup(FMLCommonSetupEvent event) {
    DispenserBehaviorRegistries.registerArrowsAsProjectiles();
  }
}