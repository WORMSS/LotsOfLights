package net.wormss.lotsoflights.render;

import java.util.Map;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.wormss.lotsoflights.model.Face;
import net.wormss.lotsoflights.model.UV;
import net.wormss.lotsoflights.model.Vector;
import net.wormss.lotsoflights.model.WavefrontObjReader;
import net.wormss.utils.Trace;

import org.lwjgl.opengl.GL11;

class TessellatorWrapper
{
	private static Tessellator tess;
	private static int x;
	private static int y;
	private static int z;
	private static Icon icon;
	private static Map<String, Icon> iconPool;
	private static UVSet[] texturePool;
	
	private static Tessellator tess()
	{
		if ( tess == null ) tess = Tessellator.instance;
		return tess;
	}
	
	static void setPosition(int x, int y, int z)
	{
		TessellatorWrapper.x = x;
		TessellatorWrapper.y = y;
		TessellatorWrapper.z = z;
		
		tess = Tessellator.instance; // Just refreshing it.
	}
	
	private static void render(Vector vector, UV uv)
	{
		Trace.normal(TessellatorWrapper.class, icon, uv);
		tess().addVertexWithUV(
			x + vector.x,
			y + vector.y,
			z + vector.z,
			icon.getInterpolatedU(16 * uv.u),
			icon.getInterpolatedV(16 * uv.v)
		);
		
		Trace.normal(TessellatorWrapper.class, "drawing vector");
	}
	
	static void render(Face face, UVSet uvs)
	{
		for ( int i = 0; i < 4; i++ )
		{
			render(face.vectors.get(i), uvs.get(i));
		}
	}
	
	private static void render(Face face)
	{
		setIcon(face.textureName);
		render(face, findUVSet(face.textureName));
	}
	
	private static UVSet findUVSet(String textureName)
	{
		for ( UVSet uv : texturePool )
		{
			if ( uv.name.equals(textureName) )
			{
				return uv;
			}
		}
		return new UVRect("","");
	}

	private static void setIcon(String textureName)
	{
		Trace.normal(TessellatorWrapper.class, "setIcon", textureName);
		UVSet uv = findUVSet(textureName);
		
		if ( uv != null )
		{
			icon = iconPool.get(uv.iconName);
		}
		else
		{
			Trace.normal(TessellatorWrapper.class, "Icon Not Found");
			icon = iconPool.get(iconPool.keySet().toArray(new String[0])[0]);
		}
	}

	public static void render(Face[] faces)
	{
		for ( Face face : faces )
		{
			render(face);
		}
	}

	public static void render(WavefrontObjReader obj)
	{
		render(obj.faces);
	}

	static void setBrightness(float value)
	{
		tess().setBrightness((int)(value * 255));
	}

	public static void draw()
	{
		tess().draw();
	}

	public static void start()
	{
		tess().startDrawingQuads();
	}

	public static void resetBugFix()
	{
		//GL11.glColor4f(1F, 1F, 1F, 1F);
		tess().setColorOpaque_I(0xFFFFFF);
	}

	public static void setIconPool(Map<String, Icon> iconPool)
	{
		TessellatorWrapper.iconPool = iconPool;
	}
	
	public static void setTexturePool(UVSet[] texturePool)
	{
		TessellatorWrapper.texturePool = texturePool;
	}

}

