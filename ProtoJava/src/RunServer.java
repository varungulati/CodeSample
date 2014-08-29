import java.util.concurrent.Executors;

import com.googlecode.protobuf.socketrpc.RpcServer;
import com.googlecode.protobuf.socketrpc.ServerRpcConnectionFactory;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.helloworld.HelloWorld;

class RunServer {
	public static void main(String[] args) {
		// Start server
		int port = 1111;
		ServerRpcConnectionFactory rpcConnectionFactory = SocketRpcConnectionFactories.createServerRpcConnectionFactory(port);
		int threadPoolSize = 1;
		RpcServer server = new RpcServer(rpcConnectionFactory, 
		    Executors.newFixedThreadPool(threadPoolSize ), true);
		server.registerService(new MyServiceImpl()); // For non-blocking impl
		server.registerBlockingService(MyService
		    .newReflectiveBlockingService(new MyBlockingInterfaceImpl())); // For blocking impl
		server.run();
	}
}