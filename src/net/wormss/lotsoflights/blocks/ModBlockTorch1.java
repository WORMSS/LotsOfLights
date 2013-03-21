package net.wormss.lotsoflights.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.wormss.lotsoflights.render.RenderBlockTorch1;

public class ModBlockTorch1 extends ModBlock
{
	public ModBlockTorch1(int id, int iconIndex, Material material)
	{
		super(id, iconIndex, material);
		setLightValue(1);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side,
		float par7,	float par8, float par9)
	{
		ItemStack itemStack;
		int metadata;
		if ( !world.isRemote )
		{
			itemStack = player.getCurrentEquippedItem();
			
			if ( itemStack != null && itemStack.itemID == Item.flintAndSteel.itemID )
			{
				metadata = world.getBlockMetadata(x, y, z);
				if ( metadata == 0 )
				{
					metadata = 1;
					itemStack.damageItem(1, player);
				}
				else
				{
					metadata = 0;
				}
				
				world.setBlockMetadataWithNotify(x, y, z, metadata);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		if ( world.getBlockMetadata(x, y, z) == 1 )
		{
			return 15;
		}
		return 0;
	}
	
	@Override
	public int getRenderType()
	{
		return RenderBlockTorch1.renderID;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
}
