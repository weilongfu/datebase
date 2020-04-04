package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
	private static PropertiesManager instance=new PropertiesManager();
	private Properties prop = new Properties();
	private PropertiesManager() {
		try {

			// 加载文件(从类路径加载）
			InputStream is = PropertiesManager.class.getClassLoader()
					.getResourceAsStream("jdbc.properties");
			prop.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PropertiesManager getInstance(){
		return instance;
	}
	public String getValue(String key){
		return this.prop.getProperty(key);
	}

}
