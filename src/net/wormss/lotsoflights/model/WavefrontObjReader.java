package net.wormss.lotsoflights.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.wormss.utils.Trace;

public class WavefrontObjReader
{
	public static final String ENCODE			= "UTF-8";
	private static final Pattern REGEX_POINT	= Pattern.compile("^v (-?[0-9]+(?:\\.[0-9]*)?) (-?[0-9]+(?:\\.[0-9]*)?) (-?[0-9]+(?:\\.[0-9]*)?)$");
	private static final Pattern REGEX_FACE		= Pattern.compile("^f (\\d+)(?:/\\d*(?:/\\d+)?)? (\\d+)(?:/\\d*(?:/\\d+)?)? (\\d+)(?:/\\d*(?:/\\d+)?)? (\\d+)(?:/\\d*(?:/\\d+)?)?$");
	private static final Pattern REGEX_USE_UV	= Pattern.compile("^usemtl (.+$)");
	
	public Face[] faces;
	
	public WavefrontObjReader(String filename)
	{
		try
		{
			load(filename);
		}
		catch ( Exception err )
		{
			err.printStackTrace();
		}
	}
	
	public WavefrontObjReader(Reader reader)
	{
		try
		{
			load(reader);
		}
		catch ( Exception err )
		{
			err.printStackTrace();
		}
	}
	
	public WavefrontObjReader(InputStream stream)
	{
		try
		{
			load(stream);
		}
		catch ( Exception err )
		{
			err.printStackTrace();
		}
	}
	
	private void load(String filename) throws NumberFormatException, UnsupportedEncodingException, IOException
	{
		load(getClass().getResourceAsStream(filename));
	}
	
	private void load(InputStream stream) throws NumberFormatException, UnsupportedEncodingException, IOException
	{
		load(new InputStreamReader(stream, ENCODE));
	}
	
	private void load(Reader reader) throws NumberFormatException, IOException
	{
		List<Face> faces;
		List<Vector> vPoints;
		BufferedReader buffer;
		String line;
		Matcher matches;
		String currentTexture;
		
		faces = new ArrayList<Face>();
		buffer = new BufferedReader(reader);
		vPoints = new ArrayList<Vector>();
		currentTexture = "Default";
		
		while ( (line = buffer.readLine()) != null )
		{
			matches = REGEX_POINT.matcher(line);
			if ( matches.matches() )
			{
				vPoints.add(new Vector(
					Double.parseDouble(matches.group(1)),
					Double.parseDouble(matches.group(2)),
					Double.parseDouble(matches.group(3))+1)
				);
				continue;
			}
			
			matches = REGEX_FACE.matcher(line);
			if ( matches.matches() )
			{
				try
				{
					faces.add(
						new Face(
							currentTexture,
							vPoints.get(Integer.parseInt(matches.group(1)) -1),
							vPoints.get(Integer.parseInt(matches.group(2)) -1),
							vPoints.get(Integer.parseInt(matches.group(3)) -1),
							vPoints.get(Integer.parseInt(matches.group(4)) -1)
						)
					);
				}
				catch ( Exception err )
				{
					Trace.normal(this, line);
					Trace.normal(this, vPoints.size(), matches.group(1), matches.group(2), matches.group(3), matches.group(4));
					
					throw err;
				}
				
				continue;
			}
			
			matches = REGEX_USE_UV.matcher(line);
			if ( matches.matches() )
			{
				currentTexture = matches.group(1);
				continue;
			}
		}
		
		this.faces = faces.toArray(new Face[faces.size()]);
	}
}
