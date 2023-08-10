package net.seba0456.mctocsv.procedures;

import net.seba0456.mctocsv.network.MinecraftToCsvModVariables;
import net.seba0456.mctocsv.MinecraftToCsvMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class WandCommandProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(MinecraftToCsvModVariables.x1 == MinecraftToCsvModVariables.x2 || MinecraftToCsvModVariables.y1 == MinecraftToCsvModVariables.y2 || MinecraftToCsvModVariables.z1 == MinecraftToCsvModVariables.z2)) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Expect LAGs while using high values!"), false);
			MinecraftToCsvMod.queueServerWork(25, () -> {
				CalculateBlocksProcedure.execute(world, entity);
			});
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Invalid selection!"), false);
		}
	}
}
