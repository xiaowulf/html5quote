package com.venus.finance.util;

import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.venus.finance.vo.FuturesQuoteVO;
import com.alibaba.fastjson.JSON;
public class FuturesQuoteDecoder implements javax.websocket.Decoder.Text<FuturesQuoteVO>{

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FuturesQuoteVO decode(String futuresQuoteVO) throws DecodeException {
		Gson gson = new Gson();
		return gson.fromJson(futuresQuoteVO, FuturesQuoteVO.class);
		//return JSON.parseObject(futuresQuoteVO, FuturesQuoteDecoder.class);
	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}

}
