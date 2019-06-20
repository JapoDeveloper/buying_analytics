package co.japo.demo.buying_analytics.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransactionsBinding {
    String TRANSACTIONS_OUT = "trans_out";

    @Output(TRANSACTIONS_OUT)
    MessageChannel transactionsOut();
}
