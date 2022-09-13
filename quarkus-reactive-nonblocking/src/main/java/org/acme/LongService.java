package org.acme;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;

@ApplicationScoped
public class LongService {

    public int sleepTime = 10000;

    @Inject
    Logger logger;

    public String serviceTime() throws InterruptedException {
        logger.info("Service Begin....");
        Thread.sleep(sleepTime);
        logger.info("Service End....");
        return "This is the Service";
    }

    public String serviceTimeUni() {
        logger.info("Service Begin....");
        Uni item = Uni.createFrom().item("This is the Service").onItem().delayIt().by(Duration.ofSeconds(10));
        logger.info("Service End....");
        return "This is the Service";
    }


}
