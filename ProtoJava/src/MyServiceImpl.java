import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.Message;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.google.protobuf.Service;
import com.googlecode.protobuf.socketrpc.helloworld.HelloWorld.HelloWorldService;

public class MyServiceImpl implements HelloWorldService {

	@Override
	public void callMethod(MethodDescriptor arg0, RpcController arg1,
			Message arg2, RpcCallback<Message> arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public ServiceDescriptor getDescriptorForType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getRequestPrototype(MethodDescriptor arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getResponsePrototype(MethodDescriptor arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
