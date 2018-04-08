import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.eventbus.DeliveryOptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mithun on 10/2/2018.
 */
public class EventBusSenderVerticle extends AbstractVerticle {
    static int i = 0;
    private ScheduledExecutorService ea = Executors.newScheduledThreadPool(1);

    public void start(Future<Void> startFuture) {
        ea.scheduleAtFixedRate(() -> {
            for (i = 0; i < 200; i++) {
                vertx.eventBus().send("anAddress", "message " + i);
            }
            System.out.println("sent all messages");
        }, 1, 1, TimeUnit.SECONDS);
        startFuture.complete();
    }
}