package net.wormss.lotsoflights.render;

import java.util.ArrayList;


class PanelCollection
{
	final ArrayList<Panel> panels = new ArrayList<Panel>();
	
	PanelCollection(Panel... panels)
	{
		for ( Panel p : panels )
		{
			this.panels.add(p);
		}
	}
	PanelCollection(ArrayList<Panel> panels)
	{
		this.panels.addAll(panels);
	}

	PanelCollection rotate90()
	{
		for ( Panel panel : panels )
		{
			panel.rotate90();
		}
		return this;
	}
	
	PanelCollection offset(double x, double y, double z)
	{
		for ( Panel p : panels )
		{
			p.offset(x, y, z);
		}
		return this;
	}
	
	@Override
	protected PanelCollection clone()
	{
		ArrayList<Panel> panels;
		
		panels = new ArrayList<Panel>();
		for ( Panel panel : this.panels )
		{
			panels.add(panel.clone());
		}
		
		return new PanelCollection(panels);
	}
	
	public int size()
	{
		return panels.size();
	}
}

class PointSet
{
	private final Point[] p = new Point[4];
	
	PointSet(Point p0, Point p1, Point p2, Point p3)
	{
		p[0] = p0;
		p[1] = p1;
		p[2] = p2;
		p[3] = p3;
	}
	
	PointSet rotate90()
	{
		for ( Point p : this.p )
		{
			p.rotate();
			p.flipX();
		}
		
		return this;
	}

	Point get0(){ return p[0]; }
	Point get1(){ return p[1]; }
	Point get2(){ return p[2]; }
	Point get3(){ return p[3]; }
	
	PointSet offset(double x, double y, double z)
	{
		for ( Point p : this.p )
		{
			p.offset(x, y, z);
		}
		return this;
	}
	
	@Override
	protected PointSet clone()
	{
		return new PointSet(p[0].clone(), p[1].clone(), p[2].clone(), p[3].clone());
	}
}

class UVSet
{
	final UV[] uv = new UV[4];

	UVSet(UV uv0, UV uv1, UV uv2, UV uv3)
	{
		uv[0] = uv0;
		uv[1] = uv1;
		uv[2] = uv2;
		uv[3] = uv3;
	}
	
	UV get0() { return uv[0]; }
	UV get1() { return uv[1]; }
	UV get2() { return uv[2]; }
	UV get3() { return uv[3]; }
	
	UVSet rotateCW()
	{
		UV temp = uv[3];
		uv[3] = uv[2];
		uv[2] = uv[1];
		uv[1] = uv[0];
		uv[0] = temp;
		return this;
	}
}

class UVRect extends UVSet
{
	UVRect(double x, double y, double width, double height)
	{
		super(
			new UV(x, y),
			new UV(x + width, y),
			new UV(x + width, y + height),
			new UV(x, y + height));
	}
}

class Panel
{
	final PointSet pointSet;
	final UVSet uvSet;
	
	Panel(PointSet pointSet, UVSet uvSet)
	{
		this.pointSet = pointSet;
		this.uvSet = uvSet;
	}
	
	Panel offset(double x, double y, double z)
	{
		pointSet.offset(x, y, z);
		return this;
	}
	
	Panel rotate90()
	{
		pointSet.rotate90();
		return this;
	}
	
	@Override
	protected Panel clone()
	{
		return new Panel(pointSet.clone(), uvSet);
	}
}

class Point
{
	double x;
	double y;
	double z;
	
	Point(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	Point flipX() { x = 1-x; return this; }
	Point flipY() { y = 1-y; return this; }
	Point flipZ() { z = 1-z; return this; }
	Point offset(double x, double y, double z)
	{
		this.x+=x;
		this.y+=y;
		this.z+=z;
		return this;
	}
	
	Point rotate()
	{
		double tmp = x;
		x = z;
		z = tmp;
		return this;
	}
	
	@Override
	protected Point clone()
	{
		return new Point(x, y, z);
	}
}

class UV
{
	double u;
	double v;
	
	UV(double u, double v)
	{
		this.u = u;
		this.v = v;
	}
}