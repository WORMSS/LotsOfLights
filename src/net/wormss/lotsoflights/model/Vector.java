package net.wormss.lotsoflights.model;

public class Vector
{
	public double x;
	public double y;
	public double z;
	
	public Vector(){};
	
	public Vector(double x, double y)
	{
		this(x, y, 0);
	}
	
	public Vector(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector flipX() { x = 1-x; return this; }
	public Vector flipY() { y = 1-y; return this; }
	public Vector flipZ() { z = 1-z; return this; }
	
	public Vector offset(double x, double y, double z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		
		return this;
	}
	
	public Vector rotate()
	{
		double tmp = x;
		x = z;
		z = tmp;
		
		return this;
	}
	
	@Override
	public Vector clone()
	{
		return new Vector(x, y, z);
	}
	
	@Override
	public String toString()
	{
		return "Vector " + x + ", " + y + ", " + z;
	}
}