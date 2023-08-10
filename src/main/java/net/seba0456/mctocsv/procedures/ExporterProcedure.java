package net.seba0456.mctocsv.procedures;

import net.seba0456.mctocsv.network.MinecraftToCsvModVariables;
import net.seba0456.mctocsv.MinecraftToCsvMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ExporterProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double lowestX = 0;
		double highestX = 0;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("Expect LAGs while using high values!"), false);
		MinecraftToCsvModVariables.x1 = new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position1").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX();
		MinecraftToCsvModVariables.y1 = new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position1").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY();
		MinecraftToCsvModVariables.z1 = new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position1").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ();
		MinecraftToCsvModVariables.x2 = new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "positon2").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX();
		MinecraftToCsvModVariables.y2 = new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "positon2").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY();
		MinecraftToCsvModVariables.z2 = new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "positon2").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ();
		MinecraftToCsvMod.LOGGER.info("Executing command for: " + (" position1 is: " + (new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position1").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX() + "" + new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position1").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY() + new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "position1").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ()) + " position2 is: " + (new Object() {
			public double getX() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "positon2").getX();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getX() + "" + new Object() {
			public double getY() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "positon2").getY();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getY() + new Object() {
			public double getZ() {
				try {
					return BlockPosArgument.getLoadedBlockPos(arguments, "positon2").getZ();
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}.getZ())));
		MinecraftToCsvMod.queueServerWork(25, () -> {
			CalculateBlocksProcedure.execute(world, entity);
		});
	}
}
