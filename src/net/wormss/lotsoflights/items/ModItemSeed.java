package net.wormss.lotsoflights.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public class ModItemSeed extends ItemSeeds
{
	public ModItemSeed(int id, int cropID)
	{
		super(id, cropID, Block.tilledField.blockID);
	}
}
