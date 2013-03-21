package net.wormss.lotsoflights.render;

class RenderBlockPoleData
{
	private static final Point p_topLeft		= new Point(.4, 0, .26);
	private static final Point p_topRight		= p_topLeft.clone().flipX();
	private static final Point p_bottomLeft		= p_topLeft.clone().flipY();
	private static final Point p_bottomRight	= p_topLeft.clone().flipY();
	private static final Point p_topAngle		= p_topLeft.clone().rotate();
	private static final Point p_bottomAngle	= p_topAngle.clone().flipY();
	
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
	
	private static final Panel pan_angle	= new Panel(ps_angle, null); 
	private static final Panel pan_side		= new Panel(ps_side, null);
	
	static final PanelCollection north	= new PanelCollection(
		pan_angle, pan_side);
	static final PanelCollection east	= north.clone().rotate90();
	static final PanelCollection south	= east.clone().rotate90();
	static final PanelCollection west	= south.clone().rotate90();
}
