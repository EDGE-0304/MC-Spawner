package hanmin.explodearrow.backend;

import hanmin.explodearrow.ExplodeArrow;
import hanmin.explodearrow.item.ExplodeArrowEntity;
import hanmin.explodearrow.item.ExplodeArrowItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registry {
  public static final DeferredRegister<EntityType<?>> arrowEntities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExplodeArrow.MOD_ID);
  
  public static final DeferredRegister<Item> arrowItems = DeferredRegister.create(ForgeRegistries.ITEMS, ExplodeArrow.MOD_ID);
  
  public static final RegistryObject<EntityType<Entity>> explode_arrow = 
		  arrowEntities.register("explode_arrow", () -> 
		  	EntityType.Builder.of(ExplodeArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).setUpdateInterval(4).setTrackingRange(20).build(
		  			(new ResourceLocation("explode_arrow", "textures/entities/projectiles/arrows/diamond")).toString()));
  
  public static final RegistryObject<Item> explode_arrow_item = arrowItems.register("explode_arrow", (
		  ) -> new ExplodeArrowItem(new Item.Properties()));
  
  public static void registerItems() {
    arrowItems.register(FMLJavaModLoadingContext.get().getModEventBus());
  }
}
