package net.wormss.lotsoflights.render;

import net.wormss.lotsoflights.model.UV;

public class UVSet
{
	final UV[] uv = new UV[4];
	final String name;
	final String iconName;
	
	UVSet(String name, String iconName, UV uv0, UV uv1, UV uv2, UV uv3)
	{
		this(name, iconName);
		setUVs(uv0, uv1, uv2, uv3);
	}
	
	protected UVSet(String name, String iconName)
	{
		this.name = name;
		this.iconName = iconName;
	}
	
	protected UVSet setUVs(UV uv0, UV uv1, UV uv2, UV uv3)
	{
		uv[0] = uv0;
		uv[1] = uv1;
		uv[2] = uv2;
		uv[3] = uv3;
		return this;
	}
	
	public UV get(int index)
	{
		return uv[index];
	}
	
	UVSet rotateCW()
	{
		UV temp = uv[3];
		uv[3] = uv[2];
		uv[2] = uv[1];
		uv[1] = uv[0];
		uv[0] = temp;
		return this;
	}
	
	@Override
	protected UVSet clone()
	{
		return new UVSet(name, iconName,
			uv[0].clone(), uv[1].clone(),
			uv[2].clone(), uv[3].clone());
	}
	
	@Override
	public String toString()
	{
		return "'" + name + "' '" + iconName + "' " + uv;
	}
}