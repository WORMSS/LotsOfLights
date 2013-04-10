package net.wormss.lotsoflights.model;

public class UV
{
	public double u;
	public double v;
	
	public UV(){}
	
	public UV(double u, double v)
	{
		this.u = u;
		this.v = v;
	}
	
	@Override
	public UV clone()
	{
		return new UV(u, v);
	}
}