package learn.ddd.config;

import learn.ddd.infra.common.Events;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventsConfiguration {

    private final ApplicationContext applicationContext;

    @Autowired
    public EventsConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public InitializingBean initializingBean() {
        return () -> Events.setPublisher(applicationContext);
    }
}
