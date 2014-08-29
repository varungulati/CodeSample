import hello_world_pb2
import time


class HelloWorldService(hello_world_pb2.HelloWorldService):
    def HelloWorld(self, controller, request, done):
        print "In HelloWorld!"

        # Print the request
        print request

        # Extract name from the message received
        name = request.my_name

        # Create a reply
        response = hello_world_pb2.HelloResponse()
        response.hello_world = 'Hello %s' % name

        # Sleeping to show asynchronous behavior on client end.
        time.sleep(1)

        # We're done, call the run method of the done callback
        done.run(response)