package net.seba0456.mctocsv.procedures;

import net.seba0456.mctocsv.network.MinecraftToCsvModVariables;
import net.seba0456.mctocsv.MinecraftToCsvMod;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;

public class CalculateBlocksProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject blockdata = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subobj = new com.google.gson.JsonObject();
		double HighestX = 0;
		double LowestX = 0;
		double IterationsX = 0;
		double HighestY = 0;
		double LowestY = 0;
		double HighestZ = 0;
		double LowestZ = 0;
		double IterationsY = 0;
		double IterationsZ = 0;
		double CurrentX = 0;
		double CurrentY = 0;
		double CurrentZ = 0;
		double BlocksOperated = 0;
		BlocksOperated = 0;
		if (MinecraftToCsvModVariables.x1 == MinecraftToCsvModVariables.x2 || MinecraftToCsvModVariables.y1 == MinecraftToCsvModVariables.y2 || MinecraftToCsvModVariables.z1 == MinecraftToCsvModVariables.z2) {
			MinecraftToCsvMod.LOGGER.error("Coordinates should be unique!");
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Coordinates should be unique!"), false);
		} else {
			if (MinecraftToCsvModVariables.x1 > MinecraftToCsvModVariables.x2) {
				HighestX = MinecraftToCsvModVariables.x1;
				LowestX = MinecraftToCsvModVariables.x2;
			} else {
				HighestX = MinecraftToCsvModVariables.x2;
				LowestX = MinecraftToCsvModVariables.x1;
			}
			IterationsX = Math.abs(HighestX - LowestX);
			if (MinecraftToCsvModVariables.y1 > MinecraftToCsvModVariables.y2) {
				HighestY = MinecraftToCsvModVariables.y1;
				LowestY = MinecraftToCsvModVariables.y2;
			} else {
				HighestY = MinecraftToCsvModVariables.y2;
				LowestY = MinecraftToCsvModVariables.y1;
			}
			IterationsY = Math.abs(HighestY - LowestY);

			if (MinecraftToCsvModVariables.z1 > MinecraftToCsvModVariables.z2) {
				HighestZ = MinecraftToCsvModVariables.z1;
				LowestZ = MinecraftToCsvModVariables.z2;
			} else {
				HighestZ = MinecraftToCsvModVariables.z2;
				LowestZ = MinecraftToCsvModVariables.z1;
			}
			IterationsZ = Math.abs(HighestZ - LowestZ);
			CurrentX = LowestX;
			CurrentY = LowestY;
			CurrentZ = LowestZ;
			MinecraftToCsvMod.LOGGER.info(("Iterations X: " + IterationsX + "Iterations Y: " + IterationsY + "Iterations Z: " + IterationsZ));
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/exported"),
					File.separator + ((world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + ".csv"));
			if (!file.exists()) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
			try {
				FileWriter filewriter = new FileWriter(file);
				BufferedWriter filebw = new BufferedWriter(filewriter);
				{
					filebw.write((("X" + ";" + "Y" + ";" + "Z") + ";" + "ID" + ";" + "Direction"));
					filebw.newLine();
				}
				filebw.close();
				filewriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			for (int index0 = 0; index0 < (int) (IterationsX + 1); index0++) {
				for (int index1 = 0; index1 < (int) (IterationsY + 1); index1++) {
					for (int index2 = 0; index2 < (int) (IterationsZ + 1); index2++) {
						if (!((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getBlock() == Blocks.AIR)) {
							if (!((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getBlock() == Blocks.VOID_AIR)) {
								if (!((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getBlock() == Blocks.CAVE_AIR)) {
									MinecraftToCsvMod.LOGGER.info((("Coords: " + Math.round(CurrentX) + "," + Math.round(CurrentY) + "," + Math.round(CurrentZ)) + " ID:"
											+ ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getBlock()).toString() + " Direction:" + (new Object() {
												public Direction getDirection(BlockState _bs) {
													Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
													if (_prop instanceof DirectionProperty _dp)
														return _bs.getValue(_dp);
													_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
													return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
															? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
															: Direction.NORTH;
												}
											}.getDirection((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))))).get3DDataValue()));
									try {
										FileWriter filewriter = new FileWriter(file, true);
										BufferedWriter filebw = new BufferedWriter(filewriter);
										{
											filebw.write(((Math.round(CurrentX) + ";" + Math.round(CurrentY) + ";" + Math.round(CurrentZ)) + ";"
													+ ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))).getBlock()).toString() + ";" + (new Object() {
														public Direction getDirection(BlockState _bs) {
															Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
															if (_prop instanceof DirectionProperty _dp)
																return _bs.getValue(_dp);
															_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
															return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
																	? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
																	: Direction.NORTH;
														}
													}.getDirection((world.getBlockState(BlockPos.containing(CurrentX, CurrentY, CurrentZ))))).get3DDataValue()));
											filebw.newLine();
										}
										filebw.close();
										filewriter.close();
									} catch (IOException exception) {
										exception.printStackTrace();
									}
									BlocksOperated = BlocksOperated + 1;
								}
							}
						}
						CurrentZ = CurrentZ + 1;
					}
					CurrentZ = LowestZ;
					CurrentY = CurrentY + 1;
				}
				CurrentY = LowestY;
				CurrentX = CurrentX + 1;
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Operation completed! Saved " + BlocksOperated + " blocks.")), false);
		}
	}
}
