import io.vertx.core.Verticle;
import io.vertx.core.spi.VerticleFactory;

/**
 * Created by Mithun on 11/2/2018.
 */
public class CustomVerticleFactory implements VerticleFactory {
    @Override
    public Verticle createVerticle(String s, ClassLoader classLoader) throws Exception {
        System.out.println("inside factory");
        switch(s) {
            case "Receiver":
                return new EventBusReceiverVerticle();
            case "Sender":
                return new EventBusSenderVerticle();
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public String prefix() {
        return "";
    }
}
