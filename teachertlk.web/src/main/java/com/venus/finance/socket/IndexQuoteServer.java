package com.venus.finance.socket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.venus.finance.util.FuturesQuoteDecoder;
import com.venus.finance.util.FuturesQuoteEncoder;
import com.venus.finance.util.Variable;
import com.venus.finance.vo.FuturesQuoteVO;

import quickfix.SessionID;
import quickfix.StringField;

@ServerEndpoint(value = "/indexquoteserver", decoders = { FuturesQuoteDecoder.class }, encoders = { FuturesQuoteEncoder.class })
public class IndexQuoteServer {


	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;

	/**
	 * 连接建立成功调用的方法
	 * 
	 * @param session
	 *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		Variable.getWebSocketSet().add(this);
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		Variable.getWebSocketSet().remove(this); // 从set中删除
	}

	/**
	 * 收到客户端消息后调用的方法
	 * 
	 * @param message
	 *            客户端发送过来的消息
	 * @param session
	 *            可选的参数
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("来自客户端的消息:" + message);
	}

	/**
	 * 发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		//error.printStackTrace();
	}

//	/**
//	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
//	 * 
//	 * @param message
//	 * @throws IOException
//	 */
//	public void sendMessage(String message) throws IOException {
//		this.session.getBasicRemote().sendText(message);
//	}
	
	public void sendMessage(FuturesQuoteVO futuresQuoteVO) throws IOException {
		try {
			 synchronized (session){
				 if(session.isOpen()){
					 session.getBasicRemote().sendObject(futuresQuoteVO);
				 }
				 
			 }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	public class MessageProcessor implements Runnable {

        public MessageProcessor() {
        	
        }
        public void run() {
            try {
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
