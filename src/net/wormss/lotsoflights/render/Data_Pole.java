package net.wormss.lotsoflights.render;


class Data_Pole
{
	private static final UVSet metal	= new UVRect(0, 0, 1, 1);
	private static final UVSet part		= new UVRect(0, 0, 0.01, 0.01);
	
	private static final Point p_topLeft		= new Point(.4627, 1, .41);
	private static final Point p_topRight		= p_topLeft.clone().flipX();
	private static final Point p_bottomLeft		= p_topLeft.clone().flipY();
	private static final Point p_bottomRight	= p_topRight.clone().flipY();
	private static final Point p_topAngle		= p_topLeft.clone().rotate();
	private static final Point p_bottomAngle	= p_topAngle.clone().flipY();
	private static final Point p_topCentre		= new Point(.5, 0, .5);
	private static final Point p_bottomCentre	= p_topCentre.clone().flipY();
	
	private static final PointSet ps_angle	= new PointSet(
		p_topAngle,
		p_topLeft,
		p_bottomLeft,
		p_bottomAngle);
	private static final PointSet ps_side	= new PointSet(
		p_topLeft,
		p_topRight,
		p_bottomRight,
		p_bottomLeft);
	private static final PointSet ps_capTop	= new PointSet(
		p_topAngle,
		p_topCentre,
		p_topRight,
		p_topLeft);
	private static final PointSet ps_capBottom = new PointSet(
		p_bottomLeft,
		p_bottomRight,
		p_bottomCentre,
		p_bottomAngle);
		
	private static final Panel pan_angle		= new Panel(ps_angle, metal); 
	private static final Panel pan_side			= new Panel(ps_side, metal);
	private static final Panel pan_capTop		= new Panel(ps_capTop, part);
	private static final Panel pan_capBottom	= new Panel(ps_capBottom, part);
	
	static final PanelCollection north	= new PanelCollection(pan_side, pan_angle, pan_capTop, pan_capBottom);
	static final PanelCollection east	= north.clone().rotate90();
	static final PanelCollection south	= east.clone().rotate90();
	static final PanelCollection west	= south.clone().rotate90();
}
