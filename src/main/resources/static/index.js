import {
  RSocketClient,
  MAX_STREAM_ID
} from 'rsocket-core';
import RSocketWebSocketClient from 'rsocket-websocket-client';
// Create an instance of a client
const client = new RSocketClient({
  // send/receive objects instead of strings/buffers
  //serializers: JsonSerializers,
  setup: {
    // ms btw sending keepalive to server
    keepAlive: 60000,
    // ms timeout if no keepalive response
    lifetime: 180000,
    // format of `data`
    dataMimeType: 'application/json',
    // format of `metadata`
    metadataMimeType: 'message/x.rsocket.routing.v0',
  },
  transport: new RSocketWebSocketClient({url: 'ws://localhost:7000'}),
});

// Open the connection
client.connect().subscribe({
  onComplete: socket => {
    console.log('connect');
    // socket provides the rsocket interactions fire/forget, request/response,
    // request/stream, etc as well as methods to close the socket.
        socket.requestStream({metadata: String.fromCharCode("addresses".length) + "addresses"})
            .subscribe({
                onSubscribe(subscription) {
                    subscription.request(MAX_STREAM_ID);
                },
                onNext(payload) {
                    document.getElementById("requestStream").innerHTML += payload.data + "<br>";
                }
            });
  },
  onError: error => console.error(error),
  onSubscribe: cancel => {/* call cancel() to abort */}
});