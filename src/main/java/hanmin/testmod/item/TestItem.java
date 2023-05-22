package hanmin.testmod.item;

import java.util.function.Supplier;

import hanmin.testmod.TestMod;
import hanmin.testmod.item.custom.CustomArrow;
import net.minecraft.world.entity.EntityType;
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
		return new TestSpawner(new Properties(), EntityType.PIG);}
	);

	public static RegistryObject<Item> CHICKEN_SPAWNER = ITEMS.register("chicken_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.CHICKEN);}
	);

	public static RegistryObject<Item> HORSE_SPAWNER = ITEMS.register("horse_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.HORSE);}

	);
	
	public static RegistryObject<Item> WOLF_SPAWNER = ITEMS.register("wolf_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.WOLF);}

	);

	public static RegistryObject<Item> CAT_SPAWNER = ITEMS.register("cat_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.CAT);}

	);
	
	public static RegistryObject<Item> VILLAGER_SPAWNER = ITEMS.register("villager_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.VILLAGER);}

	);
	
	public static RegistryObject<Item> RABBIT_SPAWNER = ITEMS.register("rabbit_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.RABBIT);}

	);
	
	public static RegistryObject<Item> TURTLE_SPAWNER = ITEMS.register("turtle_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.TURTLE);}

	);

	public static RegistryObject<Item> FOX_SPAWNER = ITEMS.register("fox_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.FOX);}

	);
	
	public static RegistryObject<Item> BAT_SPAWNER = ITEMS.register("bat_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.BAT);}

	);

	public static RegistryObject<Item> ZOMBIE_SPAWNER = ITEMS.register("zombie_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.ZOMBIE);}

	);

	public static RegistryObject<Item> DOLPHIN_SPAWNER = ITEMS.register("dolphin_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.DOLPHIN);}

	);

	public static RegistryObject<Item> DONKEY_SPAWNER = ITEMS.register("donkey_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.DONKEY);}

	);

	public static RegistryObject<Item> FROG_SPAWNER = ITEMS.register("frog_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.FROG);}

	);

	public static RegistryObject<Item> LLAMA_SPAWNER = ITEMS.register("llama_spawner",() -> {
		return new TestSpawner(new Properties(), EntityType.LLAMA);}

	);
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}