package com.venus.finance.fix;

import quickfix.Application;
import quickfix.DefaultMessageFactory;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.FixVersions;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.StringField;
import quickfix.UnsupportedMessageType;
import quickfix.field.AvgPx;
import quickfix.field.BeginString;
import quickfix.field.BusinessRejectReason;
import quickfix.field.ClOrdID;
import quickfix.field.CumQty;
import quickfix.field.CxlType;
import quickfix.field.DeliverToCompID;
import quickfix.field.ExecID;
import quickfix.field.HandlInst;
import quickfix.field.LastPx;
import quickfix.field.LastShares;
import quickfix.field.LeavesQty;
import quickfix.field.LocateReqd;
import quickfix.field.MsgSeqNum;
import quickfix.field.MsgType;
import quickfix.field.OrdStatus;
import quickfix.field.OrdType;
import quickfix.field.OrderQty;
import quickfix.field.OrigClOrdID;
import quickfix.field.Price;
import quickfix.field.RefMsgType;
import quickfix.field.RefSeqNum;
import quickfix.field.SenderCompID;
import quickfix.field.SessionRejectReason;
import quickfix.field.Side;
import quickfix.field.StopPx;
import quickfix.field.Symbol;
import quickfix.field.TargetCompID;
import quickfix.field.Text;
import quickfix.field.TimeInForce;
import quickfix.field.TransactTime;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixApplication implements Application{

	private ExecutorService exec;
	public FixApplication()
	{
		exec = Executors.newCachedThreadPool();
	}
	@Override
	public void fromAdmin(Message arg0, SessionID arg1)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
	}
	@Override
	public void onCreate(SessionID arg0) {
		System.out.println("-=======-0--"+arg0);
	}
	@Override
	public void onLogon(SessionID arg0) {
		System.out.println("--1--"+arg0);
	}

	@Override
	public void onLogout(SessionID arg0) {
		
	}

	@Override
	public void toAdmin(Message message, SessionID arg1) {
		//System.out.println("--2--"+message);
	}
	@Override
	public void toApp(Message arg0, SessionID arg1) throws DoNotSend {
		
	}
	@Override
	public void fromApp(Message message, SessionID sessionID)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
		System.out.println("--3--"+message);
		exec.execute(new MessageProcessor(message,sessionID));
	}
	public class MessageProcessor implements Runnable {
        private final quickfix.Message message;
        private final SessionID sessionID;

        public MessageProcessor(quickfix.Message message, SessionID sessionID) {
            this.message = message;
            this.sessionID = sessionID;
        }
        public void run() {
            try {
            	FuturesQuote quote = new FuturesQuote();
            	quote.setCcvolume(Double.parseDouble(message.getField(new StringField(9001)).getValue()));
            	quote.setVolume(Double.parseDouble(message.getField(new StringField(9000)).getValue()));
            	quote.setHighprice(Double.parseDouble(message.getField(new StringField(8054)).getValue()));
            	quote.setLowprice(Double.parseDouble(message.getField(new StringField(8055)).getValue()));
            	quote.setCloseprice(Double.parseDouble(message.getField(new StringField(8012)).getValue()));
            	quote.setOpenprice(Double.parseDouble(message.getField(new StringField(8053)).getValue()));
            	quote.setCode(message.getField(new StringField(55)).getValue());
            	quote.setJsjprice(Double.parseDouble(message.getField(new StringField(8058)).getValue()));
            	quote.setBuy1(Double.parseDouble(message.getField(new StringField(9002)).getValue()));
            	quote.setSell1(Double.parseDouble(message.getField(new StringField(9003)).getValue()));
            	quote.setBuy1qty(Double.parseDouble(message.getField(new StringField(9004)).getValue()));  
            	quote.setSell1qty(Double.parseDouble(message.getField(new StringField(9005)).getValue()));  
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
}
