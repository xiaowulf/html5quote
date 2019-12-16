package com.venus.finance.util;

import javax.websocket.DecodeException;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.venus.finance.vo.FuturesQuoteVO;
import com.alibaba.fastjson.JSON;
public class FuturesQuoteEncoder implements javax.websocket.Encoder.Text<FuturesQuoteVO>{

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(FuturesQuoteVO object) throws EncodeException {
		return JSON.toJSONString(object);
	}

	

}
