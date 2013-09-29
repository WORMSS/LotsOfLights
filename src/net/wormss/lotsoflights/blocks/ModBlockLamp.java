package net.wormss.lotsoflights.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.wormss.lotsoflights.tabs.ModCreativeTabs;

public class ModBlockLamp extends ModBlock
{
	public ModBlockLamp(int id, Material material)
	{
		super(id, material);
		setCreativeTab(ModCreativeTabs.lights);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side,
		float xFace, float yFace, float zFace)
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
				
				world.setBlockMetadataWithNotify(x, y, z, metadata, 3);
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
