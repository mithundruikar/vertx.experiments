import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by Mithun on 11/2/2018.
 */
public class SenderDeployingVerticle  extends AbstractVerticle {

    public void start(Future<Void> startFuture) {
        // Now deploy some other verticle:

        vertx.registerVerticleFactory(new CustomVerticleFactory());
        System.out.println("current factories"+vertx.verticleFactories());
        vertx.deployVerticle("EventBusSenderVerticle", res -> {
            if (res.succeeded()) {
                System.out.println("Deployment id is: " + res.result());
                startFuture.complete();
            } else {
                System.out.println("Deployment failed!");
                startFuture.fail(res.cause());
            }
        });
    }
}