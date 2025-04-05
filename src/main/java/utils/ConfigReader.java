package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties initlizeProperties() {
		
		//read properties file
		Properties prop = new Properties();
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resource\\config\\config.properties");
		
		try
		{
			//read the file;
			FileInputStream fis = new FileInputStream(file);
			
			prop.load(fis);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return prop;
	}
	

}
