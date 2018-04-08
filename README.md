# vertx.experiments

This project has 2 verticles. One to send messages over to event bus and another to receive messages from the event bus.

These verticles can be started using command line as:
vertx run EventBusSenderVerticle.java
vertx run EventBusReceiverVerticle.java


Try starting multiple receivers and notice how scaling works

vertx run EventBusReceiverVerticle.java -ha mode to test out High Availibity mode of vertx
