package net.wormss.lotsoflights.render;

import net.minecraft.client.renderer.Tessellator;
import net.wormss.utils.NumberUtil;

class RenderHelper
{
	private static Tessellator tess;
	private static int x;
	private static int y;
	private static int z;
	private static double u;
	private static double v;
	
	static void setup(int x, int y, int z, int iconIndex)
	{
		if ( tess == null )
		{
			tess = Tessellator.instance;
		}
		
		RenderHelper.x = x;
		RenderHelper.y = y;
		RenderHelper.z = z;
		u = iconIndex & 0xF;
		v = iconIndex >> 4 & 0xF;
		tess.setBrightness(255);
	}
	
	static void tessUV(Point point, UV uv)
	{
		tess.addVertexWithUV(
			x + point.x,
			y + point.y,
			z + point.z,
			NumberUtil.divHex(u + uv.u),
			NumberUtil.divHex(v + uv.v));
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
}
