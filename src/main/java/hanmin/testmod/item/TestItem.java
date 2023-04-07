package hanmin.testmod.item;

import java.util.function.Supplier;

import hanmin.testmod.TestMod;
import hanmin.testmod.item.custom.CustomArrow;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
	

	public static RegistryObject<Item> CHICKEN_SPAWNER = ITEMS.register("chicken_spawner",() -> {
		return new ChickenSpawner(new Properties());}
	);

	public static RegistryObject<Item> HORSE_SPAWNER = ITEMS.register("horse_spawner",() -> {
		return new HorseSpawner(new Properties());}

	);
	
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}