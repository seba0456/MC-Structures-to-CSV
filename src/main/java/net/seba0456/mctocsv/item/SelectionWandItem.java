
package net.seba0456.mctocsv.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SelectionWandItem extends Item {
	public SelectionWandItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
