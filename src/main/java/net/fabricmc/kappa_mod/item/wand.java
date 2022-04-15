package net.fabricmc.kappa_mod.item;

import it.unimi.dsi.fastutil.Hash;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.kappa_mod.feature.InwaterrepairProcedure;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ClickType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static net.fabricmc.kappa_mod.item.iteminit.projectile;
import static net.fabricmc.kappa_mod.main.ITEM_GROUP;



public class wand extends SwordItem {
    public static final EntityType<plateofkappa.CustomProjectileEntity> ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE,
            new Identifier("texturemaker", "temp_projectile"),
            FabricEntityTypeBuilder.<plateofkappa.CustomProjectileEntity>create(SpawnGroup.MISC, plateofkappa.CustomProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());


    public wand(ToolMaterial material) {
        super(material, 0, -1.8F, new Settings().group(ITEM_GROUP).maxCount(1));
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);

    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
        if (!world.isClient() && user instanceof ServerPlayerEntity){
        ServerPlayerEntity entity = (ServerPlayerEntity) user;
        plateofkappa.CustomProjectileEntity entityarrow = shoot(world, entity, new Random(31100L), 2f, 5, 5);
    }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        {
            Map<String, Object> $_dependencies = new HashMap<>();
            $_dependencies.put("world", world);
            $_dependencies.put("entity", entity);
            $_dependencies.put("itemstack", stack);
            InwaterrepairProcedure.executeProcedure($_dependencies);
        }


    }

    public static class CustomProjectileEntity extends PersistentProjectileEntity implements FlyingItemEntity {
        public CustomProjectileEntity(EntityType<? extends plateofkappa.CustomProjectileEntity> type, World world) {
            super(type, world);
        }

        public CustomProjectileEntity(EntityType<? extends plateofkappa.CustomProjectileEntity> type, LivingEntity entity, World world) {
            super(type, entity, world);
        }

        @Override
        @Environment(EnvType.CLIENT)
        public ItemStack getStack() {
            return new ItemStack(projectile);
        }

        @Override
        protected ItemStack asItemStack() {
            return ItemStack.EMPTY;
        }

        @Override
        protected void onHit(LivingEntity entity) {
            super.onHit(entity);
        }

        @Override
        public void tick() {
            super.tick();
            if (this.inGround) {
                this.discard();
            }
        }
    }


    public static plateofkappa.CustomProjectileEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
        plateofkappa.CustomProjectileEntity arrow = new plateofkappa.CustomProjectileEntity(ENTITY_TYPE, entity, world);
        arrow.setVelocity(entity.getRotationVector().x, entity.getRotationVector().y, entity.getRotationVector().z, power * 2, 0);
        arrow.setSilent(true);
        arrow.setCritical(false);
        arrow.setDamage(damage);
        arrow.setPunch(knockback);
        world.spawnEntity(arrow);

        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z, new SoundEvent(new Identifier("entity.arrow.shoot")),
                SoundCategory.PLAYERS, 1, 1F / (random.nextFloat() * 0.5F + 1) + (power / 2));

        return arrow;
    }


    public static plateofkappa.CustomProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
        plateofkappa.CustomProjectileEntity arrow = new plateofkappa.CustomProjectileEntity(ENTITY_TYPE, entity, entity.world);
        double d0 = target.getX() + (double) target.getStandingEyeHeight() - 1.1;
        double d1 = target.getY() - entity.getX();
        double d3 = target.getZ() - entity.getZ();
        arrow.setVelocity(d1, d0 - arrow.getY() + (double) MathHelper.sqrt((float) (d1 * d1 + d3 * d3)) * 0.2F, d3, 2f * 2, 12.0F);

        arrow.setSilent(true);
        arrow.setDamage(5);
        arrow.setPunch(5);
        arrow.setCritical(false);
        entity.world.spawnEntity(arrow);

        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z, new SoundEvent(new Identifier("entity.arrow.shoot")),
                SoundCategory.PLAYERS, 1, 1F / (new Random().nextFloat() * 0.5F + 1));

        return arrow;
    }

}