package hanmin.explodearrow.backend;


import hanmin.explodearrow.item.ArrowItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CreativeTabWorker {
  @SubscribeEvent
  public static void addToCombatTab(CreativeModeTabEvent.BuildContents event) {
    if (event.getTab().equals(CreativeModeTabs.COMBAT)) {
    	event.accept((ItemLike)ArrowItem.explode_arrow);
    } 
  }
}
