package net.wormss.lotsoflights.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;

class TessellatorWrapper
{
	private static Tessellator tess;
	private static int x;
	private static int y;
	private static int z;
	
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
	
	static void tessUV(Point point, UV uv)
	{
		tess().addVertexWithUV(
			x + point.x,
			y + point.y,
			z + point.z,
			uv.u, uv.v);
	}
	
	static void tessUV(PointSet pointSet, UVSet uvSet)
	{
		tessUV(pointSet.get0(), uvSet.get0());
		tessUV(pointSet.get1(), uvSet.get1());
		tessUV(pointSet.get2(), uvSet.get2());
		tessUV(pointSet.get3(), uvSet.get3());
	}
	
	static void tessUV(Panel panel)
	{
		tessUV(panel.pointSet, panel.uvSet);
	}
	
	static void tessUV(PanelCollection panelSet)
	{
		for ( Panel panel : panelSet.panels )
		{
			tessUV(panel);
		}
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
		GL11.glColor4f(1F, 1F, 1F, 1F);
	}
}
