package hanmin.explodearrow.item;

import hanmin.explodearrow.backend.ArrowAPI;
import hanmin.explodearrow.backend.Registry;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ExplodeArrowEntity extends AbstractArrow {
  public static double childDamageAssister = 0.0D;
  
  private LivingEntity attacker;
  
  public ExplodeArrowEntity(EntityType<? extends Entity> entType, Level level) {
    super((EntityType<? extends AbstractArrow>) entType, level);
  }
  
  public ExplodeArrowEntity(Level level, LivingEntity liveEntity) {
    super((EntityType)Registry.explode_arrow.get(), liveEntity, level);
    this.attacker = liveEntity;
  }
  
  public ExplodeArrowEntity(Level level, double x, double y, double z) {
    super((EntityType)Registry.explode_arrow.get(), x, y, z, level);
  }
  
  @NotNull
  protected ItemStack getPickupItem() {
    return new ItemStack((ItemLike)ArrowItem.explode_arrow);
  }
  
  protected void onHitEntity(@NotNull EntityHitResult entityRes) {
    super.onHitEntity(entityRes);
    ArrowAPI.diamondUpOnHitEntity(entityRes);
  }
  
  public void tick() {
    if (this.level.isClientSide) {
      ClientLevel cLevel = (ClientLevel)this.getLevel();
      cLevel.addParticle((ParticleOptions)ParticleTypes.FIREWORK, 8.0D, 8.0D, 8.0D, 0.0D, 0.0D, 0.0D);
    } 
    super.tick();
  }
  
  protected void onHit(HitResult hitResult) {
      super.onHit(hitResult);
  }
}
