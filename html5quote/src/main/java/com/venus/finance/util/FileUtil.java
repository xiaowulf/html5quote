package com.venus.finance.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	public List<String> readFileToList(File file){
		List<String> list = null;
		try {
			list = FileUtils.readLines(file,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
