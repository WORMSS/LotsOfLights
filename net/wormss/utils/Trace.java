package net.wormss.utils;

public class Trace
{
	public static void normal(Class context, Object... text)
	{
		normal(context.toString(), text);
	}
	public static void normal(Object context, Object... text)
	{
		String sContext;
		int i;
		int len;
		
		sContext = String.valueOf(context);
		sContext = sContext.substring(sContext.lastIndexOf(".") + 1, sContext.lastIndexOf("@"));
		
		System.out.print("[" + sContext + "]");
		
		len = text.length;
		if ( len > 0 )
		{
			System.out.print(": ");
			for ( i = 0; i < len - 1; i++ )
			{
				System.out.print(text[i] + " ");				
			}
			System.out.print(text[i]);
		}
		System.out.println();
		System.out.flush();
	}
	
}
