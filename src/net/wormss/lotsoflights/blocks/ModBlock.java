package net.wormss.lotsoflights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.render.ModRenderBlocks;
import net.wormss.utils.Trace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlock extends Block
{
	protected String _internalName;
	
	public ModBlock(int id, Material material)
	{
		super(id, material);
	}
	
	public ModBlock setBlockBounds(double minX, double minY, double minZ, double maxX, double maxY, double maxZ)
	{
		super.setBlockBounds((float)minX, (float)minY, (float)minZ, (float)maxX, (float)maxY, (float)maxZ);
		return this;
	}
	
	@Override
	public ModBlock setUnlocalizedName(String internalName)
	{
		_internalName = internalName;
		
		if ( !ModRenderBlocks.ids.containsKey(_internalName) )
		{
			ModRenderBlocks.ids.put(_internalName, 0);
		}
		
		super.setUnlocalizedName(ModReferences.PREFIX_LANG + internalName);
		return this;
	}
	
	@Override
	public int getRenderType()
	{
		return ModRenderBlocks.ids.get(_internalName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(ModReferences.ID + ":" + getUnlocalizedName2());
	}

}
