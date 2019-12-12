package com.venus.finance.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.venus.finance.fix.FuturesQuote;
import com.venus.finance.vo.AtrVO;
import com.venus.finance.vo.FuturesQuoteVO;
import com.venus.finance.vo.Macd;
import com.venus.finance.vo.MacdVO;
import com.venus.finance.vo.MaxMinPriceVO;
import com.venus.finance.vo.SuggestVO;

public class FileUtil {
	public List<String> readFileToList(File file) {
		List<String> list = null;
		try {
			list = FileUtils.readLines(file, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void saveSuggest(File file,SuggestVO suggestVO){
		BufferedWriter out = null;
		String content = suggestVO.getUsername()+","
				+suggestVO.getTel()+","+suggestVO.getSuggest();
		try {
			out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(file, true)));
			out.write(content+"\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<FuturesQuoteVO> readFileToFuturesQuoteList(File file) {
		List<FuturesQuoteVO> rList = new ArrayList<FuturesQuoteVO>();
		CodeUtil codeUtil = new CodeUtil();
		try {
			List<String> list = FileUtils.readLines(file, "UTF-8");
			for (String quoteStr : list) {
				String[] codeArray = quoteStr.split(",");
				if (codeArray.length >= 8) {
					FuturesQuoteVO futuresQuoteVO = new FuturesQuoteVO();
					futuresQuoteVO.setInstrumentID(codeArray[0]);
					futuresQuoteVO
							.setName(codeUtil.getChineseName(codeArray[0]) + codeUtil.converCodeMonth(codeArray[0]));
					futuresQuoteVO.setOpenPrice(Double.parseDouble(codeArray[1]));
					futuresQuoteVO.setHighestPrice(Double.parseDouble(codeArray[2]));
					futuresQuoteVO.setLowestPrice(Double.parseDouble(codeArray[3]));
					futuresQuoteVO.setClosePrice(Double.parseDouble(codeArray[4]));
					futuresQuoteVO.setSettlementPrice(Double.parseDouble(codeArray[5]));
					futuresQuoteVO.setVolume(Double.parseDouble(codeArray[6]));
					futuresQuoteVO.setCcvolume(Double.parseDouble(codeArray[7]));
					MacdVO macdVO = new MacdVO();
					if(codeArray.length>=9&&null!=codeArray[9]){
						futuresQuoteVO.setPreSettlementPrice(Double.parseDouble(codeArray[5])-Double.parseDouble(codeArray[9]));
					}else{
						futuresQuoteVO.setPreSettlementPrice(0D);
					}
					futuresQuoteVO.setMacdVO(macdVO);
					rList.add(futuresQuoteVO);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rList;
	}
	
	
	public List<MaxMinPriceVO> readFileToMaxMinPriceVOList(File file) {
		List<MaxMinPriceVO> rList = new ArrayList<MaxMinPriceVO>();
		CodeUtil codeUtil = new CodeUtil();
		try {
			List<String> list = FileUtils.readLines(file, "UTF-8");
			for (String quoteStr : list) {
				String[] codeArray = quoteStr.split(",");
				if (codeArray.length >= 3) {
					MaxMinPriceVO maxMinPriceVO = new MaxMinPriceVO();
					maxMinPriceVO.setInstrumentID(codeArray[0]);
					maxMinPriceVO.setMaxValue(Double.parseDouble(codeArray[1]));
					maxMinPriceVO.setMinValue(Double.parseDouble(codeArray[2]));
					rList.add(maxMinPriceVO);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rList;
	}
	
	public List<Macd> readFileMacdVOList(File file) {
		List<Macd> rList = new ArrayList<Macd>();
		try {
			List<String> list = FileUtils.readLines(file, "UTF-8");
			for (String quoteStr : list) {
				String[] codeArray = quoteStr.split(",");
				if (codeArray.length >= 2) {
					Macd macd = new Macd();
					macd.setInstrumentID(codeArray[0]);
					macd.setValue(Double.parseDouble(codeArray[1]));
					rList.add(macd);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rList;
	}
	
	
	public List<AtrVO> readFileToAtrVOList(File file) {
		List<AtrVO> rList = new ArrayList<AtrVO>();
		CodeUtil codeUtil = new CodeUtil();
		try {
			List<String> list = FileUtils.readLines(file, "UTF-8");
			for (String quoteStr : list) {
				String[] codeArray = quoteStr.split(",");
				if (codeArray.length >= 2) {
					AtrVO atrVO = new AtrVO();
					atrVO.setInstrumentID(codeArray[0]);
					atrVO.setAtr(Double.parseDouble(codeArray[1]));
					rList.add(atrVO);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rList;
	}
	
}
