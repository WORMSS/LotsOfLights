package net.wormss.lotsoflights.render;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraftforge.common.Configuration.UnicodeInputStreamReader;
import net.wormss.utils.Trace;

public class ObjReader
{
	private static final Pattern REGEX_POINT	= Pattern.compile("^v (-?[0-9]+(?:\\.[0-9]*)?) (-?[0-9]+(?:\\.[0-9]*)?) (-?[0-9]+(?:\\.[0-9]*)?)$");
	private static final Pattern REGEX_FACE		= Pattern.compile("^f (\\d+)/\\d*/\\d+ (\\d+)/\\d*/\\d+ (\\d+)/\\d*/\\d+ (\\d+)/\\d*/\\d+$");
	private static final Pattern REGEX_USE_UV	= Pattern.compile("^usemtl (.+$)");
	private static final UVSet defaultUV = new UVRect(0, 0, 1, 1);
	
	public static PanelCollection store;
	
	static public PanelCollection read(String path)
	{
		return read(path, new UVLink("Default", defaultUV));
	}
	
	@SuppressWarnings("resource")
	static public PanelCollection read(String path, UVLink... links)
	{
		BufferedReader buffer;
		UnicodeInputStreamReader input;
		String line;
		Matcher matches;
		int index1;
		int index2;
		int index3;
		int index4;
		Point point;
		UVSet texture;
		ArrayList<Point>	vPoints = new ArrayList<Point>();
		ArrayList<Panel>	vPanel	= new ArrayList<Panel>();
		
		texture = new UVRect(0, 0, 1, 1);
		
		try
		{
			input = new UnicodeInputStreamReader(ObjReader.class.getResourceAsStream(path), "UTF-8");
			buffer = new BufferedReader(input);
			
			while ( true )
			{
				line = buffer.readLine();
				
				if ( line == null )
				{
					break;
				}
				matches = REGEX_POINT.matcher(line);
				if ( matches.matches() )
				{
					point = new Point(
						Double.parseDouble(matches.group(1)),
						Double.parseDouble(matches.group(2)),
						Double.parseDouble(matches.group(3))+1);
					
					vPoints.add(point);
					
					Trace.normal(point);
					continue;
				}
				
				matches = REGEX_FACE.matcher(line);
				if ( matches.matches() )
				{
					index1 = Integer.parseInt(matches.group(1));
					index2 = Integer.parseInt(matches.group(2));
					index3 = Integer.parseInt(matches.group(3));
					index4 = Integer.parseInt(matches.group(4));
					
					if (
						index1 > vPoints.size() ||
						index2 > vPoints.size() ||
						index3 > vPoints.size() ||
						index4 > vPoints.size()
					)
					{
						continue;
					}
					
					vPanel.add(
						new Panel(
							new PointSet(
								vPoints.get(index1-1),
								vPoints.get(index2-1),
								vPoints.get(index3-1),
								vPoints.get(index4-1)
							),
							texture)
					);
				}
				
				matches = REGEX_USE_UV.matcher(line);
				if ( matches.matches() )
				{
					texture = findLink(links, matches.group(1));
					continue;
				}
			}
		}
		catch ( FileNotFoundException err )
		{
			err.printStackTrace();
		}
		catch ( IOException err )
		{
			err.printStackTrace();
		}
		
		store = new PanelCollection(vPanel.toArray(new Panel[vPanel.size()]));
		
		return store;
	}
	
	private static UVSet findLink(UVLink[] links, String name)
	{
		for ( UVLink link : links )
		{
			if ( link.name.equals(name) )
			{
				return link.uvSet;
			}
		}
		return defaultUV;
	}
}
