
import io.smallrye.reactive.messaging.annotations.Blocking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MovieProducer {

    @Inject
    @Channel("movies-out")
    Emitter<String> emitter;

    public void sendMovieToKafka(Movie movie) {
        System.out.println("Send movie: "+ movie.title);
        emitter.send(movie.title);
    }

    @Incoming("movies-received")
    public String receive(String record) {

        System.out.println("Receive modified movie: "+ record);
        return record;
    }
}