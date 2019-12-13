var ws = new WebSocket("ws://localhost:7080/html5quote/indexquoteserver");

ws.onopen = function(evt) { 
  //console.log("Connection open ..."); 
  //ws.send("getQuote");
};

ws.onmessage = function(evt) {
  console.log( "Received Message: " + evt.data);
  //ws.close();
};

ws.onclose = function(evt) {
  console.log("Connection closed.");
}; 