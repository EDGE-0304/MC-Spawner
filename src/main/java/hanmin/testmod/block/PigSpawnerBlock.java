package hanmin.testmod.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class PigSpawnerBlock extends Block {

	public PigSpawnerBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops());
	}
	
}
