package net.seba0456.mctocsv.procedures;

import net.seba0456.mctocsv.network.MinecraftToCsvModVariables;
import net.seba0456.mctocsv.init.MinecraftToCsvModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RightMouseSelectionProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(double x, double y, double z, Entity entity) {
		execute(null, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MinecraftToCsvModItems.SELECTION_WAND.get()) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			MinecraftToCsvModVariables.x2 = x;
			MinecraftToCsvModVariables.y2 = y;
			MinecraftToCsvModVariables.z2 = z;
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Second edge coordinates: " + ("x:" + x) + (" y:" + y) + (" z:" + z))), false);
		}
	}
}
