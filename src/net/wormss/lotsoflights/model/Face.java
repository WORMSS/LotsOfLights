package net.wormss.lotsoflights.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Face
{
	public List<Vector> vectors;
	public String textureName = "";
	
	public Face()
	{
		vectors = new ArrayList<Vector>();
	}
	
	public Face(String textureName)
	{
		this.textureName = textureName;
	}
	
	public Face(Vector... vectors)
	{
		this.vectors = Arrays.asList(vectors);
	}
	
	public Face(String textureName, Vector... vectors)
	{
		this(vectors);
		this.textureName = textureName;
	}
	
	Face rotate90()
	{
		for ( Vector p : vectors )
		{
			p.rotate();
			p.flipX();
		}
		
		return this;
	}

	Face offset(double x, double y, double z)
	{
		for ( Vector v : vectors )
		{
			v.offset(x, y, z);
		}
		return this;
	}
	
	@Override
	protected Face clone()
	{
		Face clone = new Face();
		for ( Vector v : vectors )
		{
			clone.vectors.add(v.clone());
		}
		return clone;
	}
}
