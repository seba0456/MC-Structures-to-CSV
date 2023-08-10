package net.seba0456.mctocsv.network;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MinecraftToCsvModVariables {
	public static double x1 = 0;
	public static double y1 = 0;
	public static double z1 = 0;
	public static double x2 = 0;
	public static double y2 = 0;
	public static double z2 = 0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
	}
}
