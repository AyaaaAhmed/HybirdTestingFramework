package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperty 
{
	public static Properties userData = loadProperties(System.getProperty("user.dir")+
			"\\src\\test\\java\\data\\url.properties");
	private static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		try 
		{
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return pro;
	}
	
	

}
