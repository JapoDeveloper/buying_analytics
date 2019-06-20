package co.japo.demo.buying_analytics.config;

import co.japo.demo.buying_analytics.kafka.TransactionsBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(TransactionsBinding.class)
public class StreamsConfig {
}
