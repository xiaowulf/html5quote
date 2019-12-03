package com.venus.finance.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.ini4j.Wini;

public class InitUtil {
	
	private final static String codeconfig_file = "/codeconfig.ini";
	
	public String getCodeSettingFilePath() throws IOException
    {
		InputStream in = this.getClass().getResourceAsStream(codeconfig_file);
        Wini ini = new Wini(in);
        String code_file_dir = ini.get("code", "code_setting_file");
        return code_file_dir;
    }
	public File getSettingFile() throws IOException
    {
		String settingFilePath = getCodeSettingFilePath();
		File settingFile = new File(settingFilePath);
		return settingFile;
    }
	public String getRecordDate() throws IOException
    {
		String settingFilePath = getCodeSettingFilePath();
		File settingFile = new File(settingFilePath);
		Wini ini = new Wini(settingFile);
        String record_date = ini.get("Date", "record_date");
        return record_date;
    }
	public File getCodeFile() throws IOException
    {
		InputStream in = this.getClass().getResourceAsStream(codeconfig_file);
        Wini ini = new Wini(in);
        String code_file_dir = ini.get("code", "code_file_path");
        File codeFile = new File(code_file_dir+"code"+getRecordDate()+".txt");
        return codeFile;
    }
	
	public static void main(String[] args) throws IOException {
		CodeUtil codeUtil = new CodeUtil();
//		List<String> list = codeUtil.getCodeByJys("cffex");
//		for(String str:list){
//			System.out.println(str);
//		}
		
	}
}
