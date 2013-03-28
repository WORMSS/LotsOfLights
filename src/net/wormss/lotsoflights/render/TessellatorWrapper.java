package net.wormss.lotsoflights.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.wormss.utils.Trace;

import org.lwjgl.opengl.GL11;

class TessellatorWrapper
{
	private static Tessellator tess;
	private static int x;
	private static int y;
	private static int z;
	private static MinMax u;
	private static MinMax v;
	
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

	public static void setUVPosition(Icon icon)
	{
		setUVPosition(icon.getMinU(), icon.getMaxU(), icon.getMinV(), icon.getMaxV());
	}
	
	public static void setUVPosition(float minU, float maxU, float minV, float maxV)
	{
		u = new MinMax(minU, maxU);
		v = new MinMax(minV, maxV);
		
		Trace.normal(TessellatorWrapper.class, u, v);
	}
	
	static void tessUV(Point point, UV uv)
	{
		tess().addVertexWithUV(
			x + point.x,
			y + point.y,
			z + point.z,
			u.value(uv.u),
			v.value(uv.v));
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

class MinMax
{
	float min;
	float max;
	MinMax(float min, float max)
	{
		this.min = min;
		this.max = max;
	}
	
	double value(double percent)
	{
		return min+((max-min)*percent);
	}
	
	@Override
	public String toString()
	{
		return "[" + min + ", " + max + "]";
	}
}

