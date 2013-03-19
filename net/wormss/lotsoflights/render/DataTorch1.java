package net.wormss.lotsoflights.render;


final class DataTorch1
{
	private static final UVSet metal =  new UVSet(
		new UV(0, 0),
		new UV(1, 0),
		new UV(1, 1),
		new UV(0, 1));
	
	private static final UVSet glass = new UVSet(
		new UV(1, 0),
		new UV(2, 0),
		new UV(2, 1),
		new UV(1, 1));
	
	private static final Point p_topLeft			= new Point(0, .747, 0);
	private static final Point p_topLeftInner		= new Point(.154, .622, .027);
	private static final Point p_bottomLeftInner	= new Point(.26, .125, .132);
	private static final Point p_bottomLeft			= new Point(.159, 0, .159);
	
	private static final Point p_topRight			= p_topLeft.clone().flipX();
	private static final Point p_topRightInner		= p_topLeftInner.clone().flipX();
	private static final Point p_bottomRightInner	= p_bottomLeftInner.clone().flipX();
	private static final Point p_bottomRight		= p_bottomLeft.clone().flipX();
	
	private static final Point p_topPoint			= new Point(.5, 1, .5);
	private static final Point p_bottomLeftInvert	= p_bottomLeft.clone().flipZ();
	private static final Point p_bottomRightInvert	= p_bottomRight.clone().flipZ();
	
	private static final PointSet ps_sLeft	= new PointSet(
		p_topLeft,
		p_topLeftInner,
		p_bottomLeftInner,
		p_bottomLeft);
	private static final PointSet ps_sRight	= new PointSet(
		p_topRightInner,
		p_topRight,
		p_bottomRight,
		p_bottomRightInner);
	private static final PointSet ps_sTop	= new PointSet(
		p_topLeft,
		p_topRight,
		p_topRightInner,
		p_topLeftInner);
	private static final PointSet ps_sBottom	= new PointSet(
		p_bottomLeftInner,
		p_bottomRightInner,
		p_bottomRight,
		p_bottomLeft);
	private static final PointSet ps_sGlass	= new PointSet(
		p_topLeftInner,
		p_topRightInner,
		p_bottomRightInner,
		p_bottomLeftInner);
	private static final PointSet ps_top	= new PointSet(
		p_topLeft,
		p_topPoint,
		p_topPoint,
		p_topRight);
	private static final PointSet ps_bottom	= new PointSet(
		p_bottomLeft,
		p_bottomRight,
		p_bottomRightInvert,
		p_bottomLeftInvert);
	
	private static final Panel pan_sLeft = new Panel(ps_sLeft, metal);
	private static final Panel pan_sRight = new Panel(ps_sRight, metal);
	private static final Panel pan_sTop = new Panel(ps_sTop, metal);
	private static final Panel pan_sBottom = new Panel(ps_sBottom, metal);
	private static final Panel pan_sGlass = new Panel(ps_sGlass, glass);
	private static final Panel pan_top = new Panel(ps_top, metal);
	
	
	static final Panel bottom = new Panel(ps_bottom, metal);
	static final PanelCollection north = new PanelCollection(
		pan_sLeft, pan_sRight, pan_sTop, pan_sBottom, pan_top, pan_sGlass
	);
	static final PanelCollection east = north.clone().rotate90();
	static final PanelCollection south = east.clone().rotate90();
	static final PanelCollection west = south.clone().rotate90();
	
}