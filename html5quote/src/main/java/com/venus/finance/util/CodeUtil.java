package com.venus.finance.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodeUtil {
	public List<String> getCodeList(){
		FileUtil fileUtil = new FileUtil();
		InitUtil initUtil = new InitUtil();
		File codeFile = null;
		try {
			codeFile = initUtil.getCodeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list = fileUtil.readFileToList(codeFile);
		return list;
	}
	public List<String> getCodeByJys(String jys){
		FileUtil fileUtil = new FileUtil();
		InitUtil initUtil = new InitUtil();
		List<String>codeList = new ArrayList<String>();
		File codeFile = null;
		try {
			codeFile = initUtil.getCodeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> list = fileUtil.readFileToList(codeFile);
		for(String codeStr:list){
			String [] codeArray = codeStr.split(",");
			if(codeArray.length==2){
				if(codeArray[1].toUpperCase().equals(jys.toUpperCase())){
					codeList.add(codeArray[0]);
				}
			}
		}
		return codeList;
	}
}
