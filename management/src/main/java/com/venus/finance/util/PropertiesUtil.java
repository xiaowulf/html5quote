package com.venus.finance.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {
	private final static String fileconfig_file = "/fileconfig.properties";
	public String getValueByKey(String key) {
		Properties pps = new Properties();
		try {
			InputStream in = this.getClass().getResourceAsStream(fileconfig_file);
			pps.load(in);
			String value = pps.getProperty(key);
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String getfileConfigValueByKey(String key) {
		Properties pps = new Properties();
		try {
			InputStream in = this.getClass().getResourceAsStream(fileconfig_file);
			pps.load(in);
			String value = pps.getProperty(key);
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 写入Properties信息
	public  void writeProperties(String pKey,
			String pValue){
		Properties pps = new Properties();
		InputStream in = this.getClass().getResourceAsStream(fileconfig_file);
		//从输入流中读取属性列表（键和元素对）
		try {
			pps.load(in);
			OutputStream out = new FileOutputStream(this.getClass().getResource(fileconfig_file).getPath());
			pps.setProperty(pKey, pValue);
			pps.store(out, pKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
