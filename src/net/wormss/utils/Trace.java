package net.wormss.utils;

public class Trace
{
	public static void normal(Class context, Object... text)
	{
		normal(context != null ? context.toString() : null, text);
	}
	
	public static void normal(Object context, Object... text)
	{
		boolean hasContext;
		String sContext;
		int i;
		int len;
		
		hasContext = false;
		if ( context != null )
		{
			sContext = String.valueOf(context);
			
			if ( sContext.startsWith("class ") )
			{
				sContext = sContext.substring(sContext.lastIndexOf(".") + 1);
			}
			else
			{
				sContext = sContext.substring(sContext.lastIndexOf(".") + 1, sContext.lastIndexOf("@"));
			}
			
			System.out.print("[" + sContext + "]");
			
			hasContext = true;
		}
		
		len = text.length;
		if ( len > 0 )
		{
			if ( hasContext )
			{
				System.out.print(": ");
			}
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
