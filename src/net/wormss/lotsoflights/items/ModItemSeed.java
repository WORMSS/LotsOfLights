package net.wormss.lotsoflights.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.wormss.lotsoflights.data.ModReferences;

public class ModItemSeed extends ItemSeeds
{
	public ModItemSeed(int id, int cropID)
	{
		super(id, cropID, Block.tilledField.blockID);
	}

	@Override
	public Item setUnlocalizedName(String internalName)
	{
		return super.setUnlocalizedName(ModReferences.PREFIX_LANG + internalName);
	}
}
