package hanmin.explodearrow.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ExplodeArrowItem extends ArrowItem {
  public ExplodeArrowItem(Item.Properties settings) {
    super(settings);
  }
  public AbstractArrow createArrow(Level level, ItemStack p_40514_, LivingEntity liveEntity) {
    return (AbstractArrow)new ExplodeArrowEntity(level, liveEntity);
  }
}
