
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.seba0456.mctocsv.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.CreativeModeTabs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MinecraftToCsvModTabs {
	@SubscribeEvent
	public static void buildTabContentsVanilla(CreativeModeTabEvent.BuildContents tabData) {

		if (tabData.getTab() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(MinecraftToCsvModItems.SELECTION_WAND.get());
		}
	}
}
