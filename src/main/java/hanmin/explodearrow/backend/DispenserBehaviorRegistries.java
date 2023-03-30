package hanmin.explodearrow.backend;

import hanmin.explodearrow.item.ArrowItem;
import hanmin.explodearrow.item.ExplodeArrowEntity;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;

public class DispenserBehaviorRegistries {
	public static void registerArrowsAsProjectiles() {
	    
	    DispenserBlock.registerBehavior((ItemLike)ArrowItem.explode_arrow, (DispenseItemBehavior)new AbstractProjectileDispenseBehavior() {
	          @NotNull
	          public Projectile getProjectile(Level level, Position pos, ItemStack stack) {
	            ExplodeArrowEntity arrow = new ExplodeArrowEntity(level, pos.x(), pos.y(), pos.z());
	            arrow.pickup = AbstractArrow.Pickup.ALLOWED;
	            return (Projectile)arrow;
	          }
	        });
	   
	    
	    
	  }
}
