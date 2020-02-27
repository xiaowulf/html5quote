package com.venus.finance.thread;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.venus.finance.socket.IndexQuoteServer;
import com.venus.finance.util.CodeUtil;
import com.venus.finance.util.FileUtil;
import com.venus.finance.util.InitUtil;
import com.venus.finance.util.Variable;
import com.venus.finance.vo.FuturesQuoteVO;

public class SaveLatestQuote implements Runnable {

	private boolean isReady = false;

	// private ConcurrentHashMap<String,FuturesQuoteVO> quoteMap;
	public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public SaveLatestQuote() {
	}

	@Override
	public void run() {
		List<String> codeList = CodeUtil.getCodeList();
		List<String> list = new ArrayList<String>();
		StringBuffer codeStrBuf = new StringBuffer();
		File file = null;
		try {
			file = InitUtil.getFutures_latest_file();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				if (isReady) {
					list.clear();
					for (int i = 0; i < codeList.size(); i++) {
						String[] codeArray = codeList.get(i).split(",");
						// Set<String> keySet = Variable.getFuturesQuoteMap().keySet();
						// Iterator it = keySet.iterator();
						// while(it.hasNext()){
						// System.out.println(it.next());
						// }
						// System.out.println(codeArray.length);
						if (codeArray.length > 0 && Variable.getFuturesQuoteMap().containsKey(codeArray[0])) {
							codeStrBuf.setLength(0);
							FuturesQuoteVO futuresQuoteVO = Variable.getFuturesQuoteMap().get(codeArray[0]);
							codeStrBuf.append(futuresQuoteVO.getInstrumentID());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getOpenPrice());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getHighestPrice());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getLowestPrice());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getClosePrice());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getSettlementPrice());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getVolume());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getCcvolume());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getBidPrice1());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getBidVolume1());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getAskPrice1());
							codeStrBuf.append(",");
							codeStrBuf.append(futuresQuoteVO.getAskVolume1());
							codeStrBuf.append(",");
							codeStrBuf.append(codeArray[1]);
							codeStrBuf.append("\n");
							list.add(codeStrBuf.toString());
						}
					}
					//System.out.println("--list--"+list.size());
					FileUtil.saveQuoteFile(file, list);
					codeStrBuf.setLength(0);
					list.clear();
					//System.out.println(list.toString());
					Thread.sleep(5000);
				} else {
					Thread.sleep(1);
				}
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted...");
			}
		}
	}
}
