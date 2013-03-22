package net.wormss.lotsoflights.render;

import net.minecraft.client.renderer.Tessellator;
import net.wormss.utils.NumberUtil;

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
	
	static void tess(Point point)
	{
		tess().addVertex(
			x + point.x,
			y + point.y,
			z + point.z);
	}
	
	static void tess(PointSet pointSet)
	{
		tess(pointSet.get0());
		tess(pointSet.get1());
		tess(pointSet.get2());
		tess(pointSet.get3());
	}
	
	static void tess(Panel panel)
	{
		tess(panel.pointSet);
	}
	
	static void tess(PanelCollection panelSet)
	{
		for ( Panel panel : panelSet.panels )
		{
			tess(panel);
		}
	}

	static void setBrightness(float value)
	{
		tess().setBrightness((int)(value * 255));
	}

	public static void setColour(int red, int green, int blue)
	{
		tess().setColorOpaque(red, green, blue);
	}

	public static void disableColour()
	{
		tess().disableColor();
		
	}
}
