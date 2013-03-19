package net.wormss.lotsoflights.blocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.wormss.lotsoflights.proxy.CommonProxy;
import net.wormss.lotsoflights.render.RenderBlockTorch1;
import static net.minecraftforge.common.ForgeDirection.*;

public class TorchPack4 extends Block
{
	public TorchPack4(int __id)
	{
		super(__id, 0, Material.circuits);
		setTickRandomly(true);
		setCreativeTab(CreativeTabs.tabDecorations);
		setHardness(0.0F);
		setLightValue(1F);
		setStepSound(soundWoodFootstep);
		setBlockName("torch4Pack");
		setRequiresSelfNotify();
		
		LanguageRegistry.addName(this, "Torch 4 Pack");
		GameRegistry.registerBlock(this);
		
		_setBlockBounds();
	}
	
	public void _setBlockBounds()
	{
		float __width	= 0.15F;
		float __height	= 0.6F;
		
		setBlockBounds(0.5F - __width, 0.0F, 0.5F - __width, 0.5F + __width, 0.6F, 0.5F + __width);
	}
	
	public void traceBounds()
	{
		System.out.println("MinX: " + minX);
		System.out.println("MinX: " + maxX);
		System.out.println("MinY: " + minY);
		System.out.println("MaxY: " + maxY);
		System.out.println("MinZ: " + minZ);
		System.out.println("MaxZ: " + maxZ);
	}
	
	@Override
	public int idDropped(int par1, Random random, int par2)
	{
		return blockID;
	}
	
	
	@Override
	public String getTextureFile()
	{
		return CommonProxy.BLOCK_PNG;
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return RenderBlockTorch1.renderID;
	}

	/**
	 * Gets if we can place a torch on a block.
	 */
	private boolean canPlaceTorchOn(World par1World, int par2, int par3, int par4)
	{
		if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
		{
			return true;
		}
		else
		{
			int var5 = par1World.getBlockId(par2, par3, par4);
			return (Block.blocksList[var5] != null && Block.blocksList[var5].canPlaceTorchOnTop(par1World, par2, par3, par4));
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return canPlaceTorchOn(par1World, par2, par3 - 1, par4);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockMetadata(par2, par3, par4) == 0)
		{
			this.onBlockAdded(par1World, par2, par3, par4);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1);
		}
		else if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
		}
		else if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
		}
		else if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
		}
		else if (this.canPlaceTorchOn(par1World, par2, par3 - 1, par4))
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
		}

		this.dropTorchIfCantStay(par1World, par2, par3, par4);
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		if (this.dropTorchIfCantStay(par1World, par2, par3, par4))
		{
			int var6 = par1World.getBlockMetadata(par2, par3, par4);
			boolean var7 = false;
			
			if (!par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true) && var6 == 1)
			{
				var7 = true;
			}
			
			if (!par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST, true) && var6 == 2)
			{
				var7 = true;
			}
			
			if (!par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) && var6 == 3)
			{
				var7 = true;
			}
			
			if (!par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true) && var6 == 4)
			{
				var7 = true;
			}
			
			if (!this.canPlaceTorchOn(par1World, par2, par3 - 1, par4) && var6 == 5)
			{
				var7 = true;
			}
			
			if (var7)
			{
				dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockWithNotify(par2, par3, par4, 0);
			}
		}
	}

	/**
	 * Tests if the block can remain at its current location and will drop as an item if it is unable to stay. Returns
	 * True if it can stay and False if it drops. Args: world, x, y, z
	 */
	private boolean dropTorchIfCantStay(World par1World, int par2, int par3, int par4)
	{
		if (!this.canPlaceBlockAt(par1World, par2, par3, par4))
		{
			if (par1World.getBlockId(par2, par3, par4) == this.blockID)
			{
				this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
				par1World.setBlockWithNotify(par2, par3, par4, 0);
			}
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * A randomly called display update to be able to add particles or other items for display
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		double __centreX = (double)((float)par2 + 0.5F);
		double __height = (double)((float)par3 + 0.7F);
		double __centreZ = (double)((float)par4 + 0.5F);
		float __pixel = 0.0625F;
		
		switch ( par5Random.nextInt(4) )
		{
			case 0 :
			{
				par1World.spawnParticle("smoke", (double)(__centreX - __pixel),	__height, (double)(__centreZ - __pixel), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(__centreX - __pixel), __height, (double)(__centreZ - __pixel), 0.0D, 0.0D, 0.0D);
				break;
			}
			case 1 :
			{
				par1World.spawnParticle("smoke", (double)(__centreX + __pixel),	__height, (double)(__centreZ - __pixel), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(__centreX + __pixel), __height, (double)(__centreZ - __pixel), 0.0D, 0.0D, 0.0D);
				break;
			}
			case 2 :
			{
				par1World.spawnParticle("smoke", (double)(__centreX + __pixel),	__height, (double)(__centreZ + __pixel), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(__centreX + __pixel), __height, (double)(__centreZ + __pixel), 0.0D, 0.0D, 0.0D);
				break;
			}
			default :
			{
				par1World.spawnParticle("smoke", (double)(__centreX - __pixel),	__height, (double)(__centreZ + __pixel), 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", (double)(__centreX - __pixel), __height, (double)(__centreZ + __pixel), 0.0D, 0.0D, 0.0D);
			}
		}
		
	}
}


