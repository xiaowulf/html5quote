package com.venus.finance.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.venus.finance.fix.FuturesQuote;
import com.venus.finance.vo.FuturesQuoteVO;

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
	
	public List<FuturesQuoteVO> readFileToFuturesQuoteList(File file){
		List<FuturesQuoteVO> rList = new ArrayList<FuturesQuoteVO>();
		CodeUtil codeUtil = new CodeUtil();
		try {
			List<String>list = FileUtils.readLines(file,"UTF-8");
			for(String quoteStr:list) {
				String[]codeArray=quoteStr.split(",");
				if(codeArray.length>=8) {
					FuturesQuoteVO futuresQuoteVO = new FuturesQuoteVO();
					futuresQuoteVO.setInstrumentID(codeArray[0]);
					futuresQuoteVO.setName(codeUtil.getChineseName(codeArray[0])+codeUtil.converCodeMonth(codeArray[0]));
					futuresQuoteVO.setOpenPrice(Double.parseDouble(codeArray[1]));
					futuresQuoteVO.setHighestPrice(Double.parseDouble(codeArray[2]));
					futuresQuoteVO.setLowestPrice(Double.parseDouble(codeArray[3]));
					futuresQuoteVO.setClosePrice(Double.parseDouble(codeArray[4]));
					futuresQuoteVO.setSettlementPrice(Double.parseDouble(codeArray[5]));
					futuresQuoteVO.setVolume(Double.parseDouble(codeArray[6]));
					futuresQuoteVO.setCcvolume(Double.parseDouble(codeArray[7]));
					rList.add(futuresQuoteVO);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rList;
	}
}
