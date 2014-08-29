import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.RpcController;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.RpcConnectionFactory;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.SocketRpcController;
import com.googlecode.protobuf.socketrpc.helloworld.HelloWorld;
import com.googlecode.protobuf.socketrpc.helloworld.HelloWorld.HelloWorldService.BlockingInterface;

class RunClient {
	private int port = 1111;
	private String host = "localhost";
	// Create channel
	RpcConnectionFactory connectionFactory = SocketRpcConnectionFactories
	    .createRpcConnectionFactory(host, port);
	BlockingRpcChannel channel = RpcChannels.newBlockingRpcChannel(connectionFactory);

	// Call service
	BlockingInterface service = MyService.newBlockingStub(channel);
	RpcController controller = new SocketRpcController();
	MyResponse myResponse = service.myMethod(controller, myRequest);

	// Check success
	if (rpcController.failed()) {
	  System.err.println(String.format("Rpc failed %s : %s", rpcController.errorReason(),
	      rpcController.errorText()));
	}
	
  public static void main(String[] args) throws Exception {
    System.out.println("ALL Well");
    HelloWorld.HelloRequest.Builder aa = HelloWorld.HelloRequest.newBuilder();
    System.out.println(aa);
    aa.setMyName("Zach");
    aa.build();
  }
}