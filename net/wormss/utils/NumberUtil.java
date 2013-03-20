package net.wormss.utils;

public class NumberUtil
{
	public static final float	pixel	= 0.0625F;

	public static int increment(int num, int limit)
	{
		return increment(num, limit, false);
	}
	
	public static int increment(int num, int limit, boolean wrap)
	{
		return num < limit ? num + 1 : (wrap ? 0 : num);
	}
	
	public static int decrement(int num)
	{
		return decrement(num, 0);
	}
	
	public static int decrement(int num, int limit)
	{
		return num > 0 ? num - 1 : limit;
	}
	
	public static double divHex(double num)
	{
		return 0.0625 * num;
	}
}
