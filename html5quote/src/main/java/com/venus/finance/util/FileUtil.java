package com.venus.finance.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
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
		
        FileChannel fileChannel = null;
		try {
			fileChannel = FileChannel.open(file.toPath(), StandardOpenOption.READ);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
 
        FileLock lock = null;
		try {
			lock = fileChannel.lock(0, Long.MAX_VALUE, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        int noOfBytesRead = -1;
		try {
			noOfBytesRead = fileChannel.read(buffer);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        StringBuffer strBuffer = new StringBuffer();
        while (noOfBytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
            	strBuffer.append((char) buffer.get());
                //System.out.print((char) buffer.get());                
            }
            buffer.clear();
            try {
				noOfBytesRead = fileChannel.read(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
 
        try {
			fileChannel.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // also releases the lock
		
		
		String[] strArray = strBuffer.toString().replace("\r", "").split("\n");
		
		List<String> list2 = Arrays.asList(strArray);
		
		
		
//		try {
//			list = FileUtils.readLines(file, "UTF-8");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return list2;
	}

	public void saveSuggest(File file, SuggestVO suggestVO) {
		BufferedWriter out = null;
		String content = suggestVO.getUsername() + "," + suggestVO.getTel() + "," + suggestVO.getSuggest();
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(content + "\r\n");
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

	public static void saveQuoteFile(File file, List<String> list) {

		FileChannel channel = null;
		FileLock lock = null;
		try {
			channel = new FileOutputStream(file, false).getChannel();
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			// 在文件末尾追加内容的处理
			raf.seek(0);
			channel = raf.getChannel();
			// 获得锁方法一：lock()，阻塞的方法，当文件锁不可用时，当前进程会被挂起
			lock = channel.lock();// 无参lock()为独占锁
			// 互斥操作
			for (String line : list) {
				ByteBuffer sendBuffer = ByteBuffer.wrap((line).getBytes());
				channel.write(sendBuffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (lock != null) {
				try {
					lock.release();
					lock = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (channel != null) {
				try {
					channel.close();
					channel = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// CharSink sink = Files.asCharSink(file, Charsets.UTF_8);
		// try {
		// sink.writeLines(list);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
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
					if (codeArray.length >= 9 && null != codeArray[9]) {
						futuresQuoteVO.setPreSettlementPrice(
								Double.parseDouble(codeArray[5]) - Double.parseDouble(codeArray[9]));
					} else {
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
