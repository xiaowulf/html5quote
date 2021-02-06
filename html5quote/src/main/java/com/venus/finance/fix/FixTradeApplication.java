package com.venus.finance.fix;

import quickfix.Application;
import quickfix.DefaultMessageFactory;
import quickfix.DoNotSend;
import quickfix.DoubleField;
import quickfix.FieldNotFound;
import quickfix.FixVersions;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.IntField;
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
import quickfix.field.TargetStrategy;
import quickfix.field.Text;
import quickfix.field.TimeInForce;
import quickfix.field.TransactTime;




import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.venus.finance.model.FuturesOrders;
import com.venus.finance.vo.FuturesOrderRet;

public class FixTradeApplication implements Application{

	private ExecutorService exec;
	private SessionID sessionID;
	public FixTradeApplication()
	{
		exec = Executors.newCachedThreadPool();
	}
	@Override
	public void fromAdmin(Message arg0, SessionID arg1)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
	}
	@Override
	public void onCreate(SessionID arg0) {
		//System.out.println("--0--"+arg0);
	}
	@Override
	public void onLogon(SessionID arg0) {
		System.out.println("--1--"+arg0);
		sessionID = arg0;
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
		//System.out.println("--3--"+message);
		exec.execute(new MessageProcessor(message,sessionID));
	}
	
	public void sendOrder(){
		quickfix.fix50sp2.NewOrderSingle newOrderSingle = new quickfix.fix50sp2.NewOrderSingle();
		try {
			if(sessionID!=null){
				Session.sendToTarget(newOrderSingle, sessionID);
			}
            
        } catch (SessionNotFound e) {
            System.out.println(e);
        }
	}
	
	public String sendOrder(FuturesOrders futuresOrders){
		String result = "1";
		quickfix.fix50sp2.NewOrderSingle newOrderSingle = new quickfix.fix50sp2.NewOrderSingle();
		/*
		if(futuresOrders.getFangxiang().equals("buy")){
			newOrderSingle.set(new Side(Side.BUY));
		}else{
			newOrderSingle.set(new Side(Side.SELL));
		}
		*/
		//newOrderSingle.set(new ClOrdID(futuresOrders.getUuid()));
		newOrderSingle.set(new TransactTime());
		newOrderSingle.set(new OrdType(OrdType.MARKET));
		newOrderSingle.set(new OrderQty(futuresOrders.getHand()));
        newOrderSingle.set(new Symbol(futuresOrders.getCode()));
        newOrderSingle.set(new HandlInst('1'));
        newOrderSingle.set(new Price(futuresOrders.getOpen_price()));
        newOrderSingle.set(new TargetStrategy(futuresOrders.getStrategy_id().intValue()));
        //newOrderSingle.setField(new StringField(Constants.OrderAction, "open"));
		try {
			if(sessionID!=null){
				Session.sendToTarget(newOrderSingle, sessionID);
				result = "0";
			}else{
				result = "1";
			}
            
        } catch (SessionNotFound e) {
            System.out.println(e);
        }
		return result;
	}
	
	public String sendRetriveOrder(FuturesOrders futuresOrders){
		quickfix.fix50sp2.NewOrderSingle newOrderSingle = new quickfix.fix50sp2.NewOrderSingle();
		String result = "1";
		/*
		if(futuresOrders.getFangxiang().equals("buy")){
			newOrderSingle.set(new Side(Side.BUY));
		}else{
			newOrderSingle.set(new Side(Side.SELL));
		}
		*/
		//newOrderSingle.set(new ClOrdID(futuresOrders.getUuid()));
		newOrderSingle.set(new TransactTime());
		newOrderSingle.set(new OrdType(OrdType.MARKET));
		newOrderSingle.set(new OrderQty(futuresOrders.getHand()));
        newOrderSingle.set(new Symbol(futuresOrders.getCode()));
        newOrderSingle.set(new HandlInst('1'));
        newOrderSingle.set(new Price(futuresOrders.getOpen_price()));
        newOrderSingle.set(new TargetStrategy(futuresOrders.getStrategy_id().intValue()));
        //newOrderSingle.setField(new StringField(Constants.OrderAction, "retrive"));
		try {
			if(sessionID!=null){
				Session.sendToTarget(newOrderSingle, sessionID);
				result = "0";
			}
        } catch (SessionNotFound e) {
            System.out.println(e);
        }
		return result;
	}
	public String sendModifyeOrder(FuturesOrders futuresOrders){
		quickfix.fix50sp2.NewOrderSingle newOrderSingle = new quickfix.fix50sp2.NewOrderSingle();
		String result = "1";
		/*
		if(futuresOrders.getFangxiang().equals("buy")){
			newOrderSingle.set(new Side(Side.BUY));
		}else{
			newOrderSingle.set(new Side(Side.SELL));
		}
		*/
		//newOrderSingle.set(new ClOrdID(futuresOrders.getUuid()));
		newOrderSingle.set(new TransactTime());
		newOrderSingle.set(new OrdType(OrdType.MARKET));
		newOrderSingle.set(new OrderQty(futuresOrders.getHand()));
        newOrderSingle.set(new Symbol(futuresOrders.getCode()));
        newOrderSingle.set(new HandlInst('1'));
        newOrderSingle.set(new Price(futuresOrders.getOpen_price()));
        newOrderSingle.set(new TargetStrategy(futuresOrders.getStrategy_id().intValue()));
        //newOrderSingle.setField(new StringField(Constants.OrderAction, "change"));
		try {
			if(sessionID!=null){
				Session.sendToTarget(newOrderSingle, sessionID);
				result = "0";
			}
        } catch (SessionNotFound e) {
            System.out.println(e);
        }
		return result;
	}
	
	public String sendCloseOrder(FuturesOrders futuresOrders){
		String result = "1";
		quickfix.fix50sp2.NewOrderSingle newOrderSingle = new quickfix.fix50sp2.NewOrderSingle();
		/*
		if(futuresOrders.getFangxiang().equals("buy")){
			newOrderSingle.set(new Side(Side.BUY));
		}else{
			newOrderSingle.set(new Side(Side.SELL));
		}
		*/
		//newOrderSingle.set(new ClOrdID(futuresOrders.getUuid()));
		newOrderSingle.set(new TransactTime());
		newOrderSingle.set(new OrdType(OrdType.MARKET));
		newOrderSingle.set(new OrderQty(futuresOrders.getHand()));
        newOrderSingle.set(new Symbol(futuresOrders.getCode()));
        newOrderSingle.set(new HandlInst('1'));
        //newOrderSingle.set(new Price(futuresOrders.getClose_price()));
        newOrderSingle.set(new TargetStrategy(futuresOrders.getStrategy_id().intValue()));
        /*
        if(futuresOrders.getRecord_date().longValue()==Long.parseLong(frame.getTomorrow_date())
				&&CodeUtil.converJYSByCode(futuresOrders.getCode()).equals("SHFE")){
        	newOrderSingle.setField(new StringField(Constants.OrderAction, "closetoday"));
		}else{
			newOrderSingle.setField(new StringField(Constants.OrderAction, "close"));
		}
		*/
		try {
			if(sessionID!=null){
				Session.sendToTarget(newOrderSingle, sessionID);
				result = "0";
			}
        } catch (SessionNotFound e) {
            System.out.println(e);
        }
		return result;
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
            	//System.out.println("--message--"+message);
            	FuturesOrderRet futuresOrderRet = new FuturesOrderRet();
            	Calendar cal = Calendar.getInstance();
            	futuresOrderRet.setOrder_result(message.getField(new StringField(8060)).getValue());
            	if(futuresOrderRet.getOrder_result().equals("1")){
            		futuresOrderRet.setVolume(Double.parseDouble(message.getField(new StringField(9000)).getValue()));
                	futuresOrderRet.setCode(message.getField(new StringField(55)).getValue());
                	futuresOrderRet.setUuid(message.getField(new StringField(8059)).getValue());
                	
                	futuresOrderRet.setRef_value(message.getField(new IntField(8061)).getValue());
                	futuresOrderRet.setSessionid(message.getField(new IntField(8062)).getValue());
                	futuresOrderRet.setFrontid(message.getField(new IntField(8063)).getValue());
                	futuresOrderRet.setSxf(message.getField(new DoubleField(8064)).getValue());
                	futuresOrderRet.setOrder_type(message.getField(new StringField(8065)).getValue());
                	futuresOrderRet.setClose_price(message.getField(new DoubleField(8057)).getValue());
                	futuresOrderRet.setOpen_price(message.getField(new DoubleField(8053)).getValue());
                	//开仓
                	/*
                	if(!futuresOrderRet.getUuid().equals("")&&futuresOrderRet.getOrder_type().equals("open")){
                		FuturesOrders futuresSusOrders = sqlliteDbDAO.findFuturesSusOrdersByUUID(futuresOrderRet.getUuid());
                		if(futuresSusOrders.getId()!=0L){
                			sqlliteDbDAO.deleteFuturesSusOrdersByUUID(futuresOrderRet.getUuid());
                    		sqlliteDbDAO.insertFuturesOrders(futuresSusOrders,futuresOrderRet);
                    		for(int i=0;i<frame.getFuturesSusOrdersList().size();i++){
                				FuturesOrders FuturesOrdersTemp = frame.getFuturesSusOrdersList().get(i);
                				if(FuturesOrdersTemp.getUuid().equals(futuresSusOrders.getUuid())){
                					frame.getFuturesSusOrdersList().remove(i);
                				}
                			}
                		}
                		frame.updateCC();
                		frame.updateSus();
                	}else if(!futuresOrderRet.getUuid().equals("")&&futuresOrderRet.getOrder_type().equals("close")){
                		//平仓
                		FuturesOrders futuresSusOrders = sqlliteDbDAO.findFuturesSusOrdersByUUID(futuresOrderRet.getUuid());
                		FuturesOrders futuresOrders = sqlliteDbDAO.findFuturesOrdersByUUID(futuresOrderRet.getUuid());
                		if(futuresOrders.getId()==null||futuresOrders.getId().equals(0L))
                		{
                			sqlliteDbDAO.deleteFuturesSusOrdersByUUID(futuresOrderRet.getUuid());
                			return;
                		}
                		int size =  sqlliteDbDAO.findFuturesCloseByOpenId(futuresOrders.getId()).size();
                		if(size>0)
                		{
                			sqlliteDbDAO.deleteFuturesSusOrdersByUUID(futuresOrderRet.getUuid());
                			return;
                		}
                		FuturesClose futuresClose = new FuturesClose();
                		futuresClose.setClose_price(futuresOrderRet.getClose_price());
                		futuresClose.setCode(futuresSusOrders.getCode());
                		if(futuresSusOrders.getFangxiang().equals("buy")){
                			futuresClose.setClose_profit((futuresOrderRet.getClose_price()-futuresOrders.getOpen_price())*
                					futuresOrders.getHand()*CodeUtil.getCodeDianShu(futuresSusOrders.getCode()));
                		}else{
                			futuresClose.setClose_profit((futuresOrders.getOpen_price()-futuresOrderRet.getClose_price())*
                					futuresOrders.getHand()*CodeUtil.getCodeDianShu(futuresSusOrders.getCode()));
                		}
                		futuresClose.setFangxiang(futuresSusOrders.getFangxiang());
                		futuresClose.setHand(futuresOrderRet.getVolume());
                		futuresClose.setOrder_id(futuresOrders.getId());
                		futuresClose.setStrategy_id(futuresOrders.getStrategy_id());
                		futuresClose.setSxf(futuresOrderRet.getSxf());
                		futuresClose.setUuid(futuresOrders.getUuid());
                		futuresClose.setRecord_date(Long.parseLong(frame.getTomorrow_date()));
                		futuresClose.setOpen_price(futuresOrders.getOpen_price());
                		futuresClose.setRecord_time(DateUtil.getStringTime(Calendar.getInstance()));
                		//插入平仓数据
                		sqlliteDbDAO.insertFuturesClose(futuresClose);
                		frame.getCloseOrdersList().add(futuresClose);
                		if(futuresSusOrders.getId()!=0L&&futuresOrders.getId()!=0L){
                			sqlliteDbDAO.deleteFuturesSusOrdersByUUID(futuresOrderRet.getUuid());
                    		sqlliteDbDAO.deleteFuturesOrdersByUUID(futuresOrderRet.getUuid());
                    		frame.removeCCOrdersById(futuresOrderRet.getUuid());
                    		//删除挂单数据
                    		for(int i=0;i<frame.getFuturesSusOrdersList().size();i++){
                				FuturesOrders FuturesOrdersTemp = frame.getFuturesSusOrdersList().get(i);
                				if(FuturesOrdersTemp.getUuid().equals(futuresSusOrders.getUuid())){
                					frame.getFuturesSusOrdersList().remove(i);
                				}
                			}
                    		//删除持仓数据
                    		for(int i=0;i<frame.getFuturesOrdersList().size();i++)
            				{
            					FuturesOrders futuresOrdersTemp = frame.getFuturesOrdersList().get(i);
            					if(futuresOrdersTemp.getUuid().equals(futuresClose.getUuid())){
            						frame.getFuturesOrdersList().remove(i);
            					}
            				}
                		}
                		frame.updateCC();
                		frame.updateSus();
                	}
            	}else if(futuresOrderRet.getOrder_result().equals("2")){
            		futuresOrderRet.setUuid(message.getField(new StringField(8059)).getValue());
            		sqlliteDbDAO.deleteFuturesSusOrdersByUUID(futuresOrderRet.getUuid());
            		for(int i=0;i<frame.getFuturesSusOrdersList().size();i++){
        				FuturesOrders futuresOrdersTemp = frame.getFuturesSusOrdersList().get(i);
        				if(futuresOrdersTemp.getUuid().equals(futuresOrderRet.getUuid())){
        					frame.getFuturesSusOrdersList().remove(i);
        				}
        			}
            		frame.updateSus();
            		*/
            	}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
}
