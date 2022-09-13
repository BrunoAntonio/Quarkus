

import io.smallrye.reactive.messaging.annotations.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MovieConsumer {


    @Incoming("movies-in")
    @Outgoing("new-movie")
    @Blocking
    public String receive(String record) {
        System.out.println("Movie to modify: "+ record);
        return record+" modified";
    }
}