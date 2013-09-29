package net.wormss.lotsoflights.render;

import net.wormss.lotsoflights.model.UV;

public class UVRect extends UVSet
{
	UVRect(String name, String iconName, double x, double y, double width, double height)
	{
		super(name, iconName);
		setUVs(new UV(x, y), new UV(x + width, y), new UV(x + width, y + height), new UV(x, y + height));
	}

	public UVRect(String name, String iconName)
	{
		this(name, iconName, 0, 0, 1, 1);
	}
}