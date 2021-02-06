var ws = new WebSocket("ws://localhost:7080/html5quote/indexquoteserver");
ws.onopen = function(evt) { 
  console.log("Connection open ..."); 
  //ws.send("getQuote");
};

ws.onmessage = function(evt) {
  const obj = JSON.parse(evt.data);
  if(obj.closePrice>obj.openPrice){
	  $("#"+ obj.instrumentID+"openPrice").html("<font color=\"green\">"+obj.openPrice+"</font>");
	  $("#"+ obj.instrumentID+"highestPrice").html("<font color=\"green\">"+obj.highestPrice+"</font>");
	  $("#"+ obj.instrumentID+"lowestPrice").html("<font color=\"green\">"+obj.lowestPrice+"</font>");
	  $("#"+ obj.instrumentID+"closePrice").html("<font color=\"green\">"+obj.closePrice+"</font>");
	  $("#"+ obj.instrumentID+"settlementPrice").html("<font color=\"green\">"+obj.settlementPrice+"</font>");
	  $("#"+ obj.instrumentID+"bidPrice1").html("<font color=\"green\">"+obj.bidPrice1+"</font>");
	  $("#"+ obj.instrumentID+"bidVolume1").html("<font color=\"green\">"+obj.bidVolume1+"</font>");
	  $("#"+ obj.instrumentID+"askPrice1").html("<font color=\"green\">"+obj.askPrice1+"</font>");
	  $("#"+ obj.instrumentID+"askVolume1").html("<font color=\"green\">"+obj.askVolume1+"</font>");
	  $("#"+ obj.instrumentID+"volume").html("<font color=\"green\">"+obj.volume+"</font>");
	  $("#"+ obj.instrumentID+"ccvolume").html("<font color=\"green\">"+obj.ccvolume+"</font>");
  }else{
	  $("#"+ obj.instrumentID+"openPrice").html("<font color=\"red\">"+obj.openPrice+"</font>");
	  $("#"+ obj.instrumentID+"highestPrice").html("<font color=\"red\">"+obj.highestPrice+"</font>");
	  $("#"+ obj.instrumentID+"lowestPrice").html("<font color=\"red\">"+obj.lowestPrice+"</font>");
	  $("#"+ obj.instrumentID+"closePrice").html("<font color=\"red\">"+obj.closePrice+"</font>");
	  $("#"+ obj.instrumentID+"settlementPrice").html("<font color=\"red\">"+obj.settlementPrice+"</font>");
	  $("#"+ obj.instrumentID+"bidPrice1").html("<font color=\"red\">"+obj.bidPrice1+"</font>");
	  $("#"+ obj.instrumentID+"bidVolume1").html("<font color=\"red\">"+obj.bidVolume1+"</font>");
	  $("#"+ obj.instrumentID+"askPrice1").html("<font color=\"red\">"+obj.askPrice1+"</font>");
	  $("#"+ obj.instrumentID+"askVolume1").html("<font color=\"red\">"+obj.askVolume1+"</font>");
	  $("#"+ obj.instrumentID+"volume").html("<font color=\"red\">"+obj.volume+"</font>");
	  $("#"+ obj.instrumentID+"ccvolume").html("<font color=\"red\">"+obj.ccvolume+"</font>");
  }  
   //console.log("---------------------"+obj.instrumentID+obj.bidPrice1);
  //ws.close();
};
  
ws.onclose = function(evt) {
  console.log("Connection closed.");
}; 