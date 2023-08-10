
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.seba0456.mctocsv.init;

import net.seba0456.mctocsv.item.SelectionWandItem;
import net.seba0456.mctocsv.MinecraftToCsvMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

public class MinecraftToCsvModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftToCsvMod.MODID);
	public static final RegistryObject<Item> SELECTION_WAND = REGISTRY.register("selection_wand", () -> new SelectionWandItem());
}
