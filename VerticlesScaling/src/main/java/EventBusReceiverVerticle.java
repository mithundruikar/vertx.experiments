import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Mithun on 10/2/2018.
 */
public class EventBusReceiverVerticle extends AbstractVerticle {
    int counter = 0;
    private String name = null;

    public EventBusReceiverVerticle() {
        this.name = UUID.randomUUID().toString();
    }
    public void start(Future<Void> startFuture) {
        vertx.runOnContext( o -> {
            vertx.eventBus().consumer("anAddress", message -> {
                    System.out.println(this.name +
                            " received message: " +
                            message.body()+" counter "+counter);
                counter++;
            });
        });
        startFuture.complete();
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        System.out.println("received total"+counter+" messages");
        stopFuture.complete();
    }
}
