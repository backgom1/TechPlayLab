package learn.ddd.infra.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


@Component
public class Events implements EventDispatcher {

    private final ApplicationEventPublisher publisher;

    public Events(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void raise(Object event) {
        if (publisher != null) {
            publisher.publishEvent(event);
        }
    }
}
