# Add main protobuf module to classpath
import sys
sys.path.append('../../main')

# Import required RPC modules
import protobuf.socketrpc.server as server
import HelloWorldService as impl


# Create and register the service
# Note that this is an instantiation of the implementation class,
# *not* the class defined in the proto file.
hello_world_service = impl.HelloWorldService()
server = server.SocketRpcServer(8090)
server.registerService(hello_world_service)

# Start the server
print 'Serving on port 8090'
server.run()
