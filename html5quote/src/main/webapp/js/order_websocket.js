var ws = new WebSocket("ws://localhost:8080/html5quote/indexquoteserver");
ws.onopen = function(evt) { 
  console.log("Connection open ..."); 
  //ws.send("getQuote");
};

ws.onmessage = function(evt) {
  const obj = JSON.parse(evt.data);
  console.log("---------------------"+obj.instrumentID+obj.bidPrice1);
  //ws.close();
};
  
ws.onclose = function(evt) {
  console.log("Connection closed.");
}; 