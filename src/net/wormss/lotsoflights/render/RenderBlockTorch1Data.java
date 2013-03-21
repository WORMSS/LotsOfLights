package net.wormss.lotsoflights.render;


final class RenderBlockTorch1Data
{
	private static final UVSet metal	= new UVRect(0, 0, .5, 1);
	private static final UVSet glass	= new UVRect(.5, 0, .5, 1);
	
	private static final Point p_topLeft			= new Point(0, .747, 0);
	private static final Point p_topLeftInner		= new Point(.154, .622, .027);
	private static final Point p_bottomLeftInner	= new Point(.26, .125, .132);
	private static final Point p_bottomLeft			= new Point(.159, 0, .159);
	private static final Point p_topLeftInset		= p_topLeftInner.clone().offsetZ(.1);
	private static final Point p_bottomLeftInset	= p_bottomLeftInner.clone().offsetZ(.1);
	
	private static final Point p_topRight			= p_topLeft.clone().flipX();
	private static final Point p_topRightInner		= p_topLeftInner.clone().flipX();
	private static final Point p_bottomRightInner	= p_bottomLeftInner.clone().flipX();
	private static final Point p_bottomRight		= p_bottomLeft.clone().flipX();
	private static final Point p_topRightInset		= p_topRightInner.clone().offsetZ(.1);
	private static final Point p_bottomRightInset	= p_bottomRightInner.clone().offsetZ(.1);
	
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
	private static final PointSet ps_sInsetLeft = new PointSet(
		p_topLeftInner,
		p_topLeftInset,
		p_bottomLeftInset,
		p_bottomLeftInner);
	private static final PointSet ps_sInsetRight = new PointSet(
		p_topRightInset,
		p_topRightInner,
		p_bottomRightInner,
		p_bottomRightInset);
	private static final PointSet ps_sInsetTop = new PointSet(
		p_topLeftInner,
		p_topRightInner,
		p_topRightInset,
		p_topLeftInset);
	private static final PointSet ps_sInsetBottom = new PointSet(
		p_bottomLeftInset,
		p_bottomRightInset,
		p_bottomRightInner,
		p_bottomLeftInner);
	private static final PointSet ps_sGlass	= new PointSet(
		p_topLeftInset,
		p_topRightInset,
		p_bottomRightInset,
		p_bottomLeftInset);
	private static final PointSet ps_top	= new PointSet(
		p_topPoint,
		p_topPoint,
		p_topRight,
		p_topLeft);
	private static final PointSet ps_bottom	= new PointSet(
		p_bottomLeft,
		p_bottomRight,
		p_bottomRightInvert,
		p_bottomLeftInvert);
	
	private static final Panel pan_sLeft = new Panel(ps_sLeft, metal);
	private static final Panel pan_sRight = new Panel(ps_sRight, metal);
	private static final Panel pan_sTop = new Panel(ps_sTop, metal);
	private static final Panel pan_sBottom = new Panel(ps_sBottom, metal);
	private static final Panel pan_sInsetLeft = new Panel(ps_sInsetLeft, metal);
	private static final Panel pan_sInsetRight = new Panel(ps_sInsetRight, metal);
	private static final Panel pan_sInsetTop = new Panel(ps_sInsetTop, metal);
	private static final Panel pan_sInsetBottom = new Panel(ps_sInsetBottom, metal);
	private static final Panel pan_top = new Panel(ps_top, metal);
	
	static final Panel northGlass	= new Panel(ps_sGlass, glass);
	static final Panel eastGlass	= northGlass.clone().rotate90();
	static final Panel southGlass	= eastGlass.clone().rotate90();
	static final Panel westGlass	= southGlass.clone().rotate90();
	static final Panel bottom		= new Panel(ps_bottom, metal);
	static final PanelCollection north	= new PanelCollection(
		pan_sLeft, pan_sRight, pan_sTop, pan_sBottom, pan_top, pan_sInsetLeft,
		pan_sInsetRight, pan_sInsetTop, pan_sInsetBottom);
	static final PanelCollection east	= north.clone().rotate90();
	static final PanelCollection south	= east.clone().rotate90();
	static final PanelCollection west	= south.clone().rotate90();
}