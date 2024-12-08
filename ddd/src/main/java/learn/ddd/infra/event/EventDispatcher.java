package learn.ddd.infra.event;

public interface EventDispatcher {

    void raise(Object event);
}
